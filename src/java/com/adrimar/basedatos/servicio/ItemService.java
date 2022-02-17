/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.servicio;

import com.adrimar.basedatos.dao.ItemDao;
import com.adrimar.basedatos.entidades.InventoryVo;
import com.adrimar.basedatos.entidadesList.ItemList;
import com.adrimar.basedatos.entidades.ItemVo;
import java.util.List;

/**
 *
 * @author pepe
 */
public class ItemService {
    
    private ItemDao itemdao;

    public ItemService() {
        itemdao = new ItemDao();
    }
    
    public ItemVo getItem(ItemVo itemvo){
        return itemdao.getItem(itemvo.getIdClave(), itemvo.getIdEmpresa());
    }
    
    public int getLastItem(){
        return itemdao.getLastItem();
    }
	
    public List<ItemVo> getListItem_High(int id){
        return itemdao.getListItem_High(id);
    } 
  
    public int getLastEdItem(){
        return itemdao.getLastEdItem();
    }
    
    public List<ItemVo> getListItem(){
        return itemdao.getListAllItems();
    }  
	
    public void addItem (ItemVo itemvo) throws Exception {
        
        if(itemvo == null)
            throw new NullPointerException("Articulo no puede ser null");
            
        if(itemvo.getIdClave()== 0 )
            throw new Exception("La clave del articulo no contiene puede ser 0 : '"+itemvo.getIdClave()+"'");
            
        if(itemvo.getIdEmpresa()== 0)
            throw new Exception("la clave de la empresa no puede ser 0 : '"+itemvo.getIdEmpresa()+"'");
        
        if(itemvo.getIdSubgrupo()== 0 )
            throw new Exception("La clave del subgrupo no puede ser cero: '"+itemvo.getIdSubgrupo()+"'");
            
        if(itemvo.getNoParte() == null || itemvo.getNoParte().length() == 0)
            throw new Exception("El No.Parte no contiene caracteres: '"+itemvo.getNoParte()+"'");
        
        itemdao.addItem(itemvo);
    }
    
    public List<ItemVo> checkNewItem(ItemList itemlist) throws Exception{
       
        if(itemlist == null)
            throw new NullPointerException("Registro ItemList no puede ser null");
        
        List <ItemVo> listitem = itemlist.getListItem();
		int last_sec = 0;
			
        for(ItemVo ob: listitem){          
                               
            if(getItem(ob) != null){				
		itemdao.addEditItem(ob, 2);
                itemdao.updateItem(ob);
                System.out.println("articulo ya existe entra a EDITAR"); 				
            } else{ 				
		if(ob.getStatus() == 1){
                    addItem(ob);
                    itemdao.addEditItem(ob, 1);

                    System.out.println("articulo no existe entra a INSERTAR "+ob.getNoParte()); 
		}
            }	                         			
            last_sec = ob.getModifica();
        }
        
        itemdao.updateSecItem(last_sec);
        return listitem;
    }
      
}
