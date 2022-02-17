/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.servicio;

import com.adrimar.basedatos.dao.InventoryDao;
import com.adrimar.basedatos.entidadesList.InventoryList;
import com.adrimar.basedatos.entidades.InventoryVo;
import java.util.List;

/**
 *
 * @author pepe
 */
public class InventoryServicio {
    
    private InventoryDao inventDao;
    
    public InventoryServicio(){
        inventDao = new InventoryDao();
    }
    
    public int getLastInv(){
        return inventDao.getLastInv();
    }
    
    public int getFirtsInv(){
        return inventDao.getFirtsInv();
    }
    
    public InventoryVo getInv(InventoryVo invent){
        return inventDao.getInv(invent.getInvIdItem(), invent.getInvIdBranch());
    }
    
    public List<InventoryVo> getListInv(int id){
        return inventDao.getListInv_High(id);
    }  
    
    public List<InventoryVo> getListInvLim(int ini, int fin){
        return inventDao.getListInv_HighLim(ini, fin);
    }
	
    public List<InventoryVo> getListInvNewItem(int idSecFinal){
        return inventDao.getListInvNewItem(idSecFinal);
    }  
    
	public List<InventoryVo> getListAllInv(){
        return inventDao.getListAllInv();
    }  
	
	public List<InventoryVo> getListInvItem(int idItem){
        return inventDao.getListInvItem(idItem);
    }  
    
    public void updateListInv (InventoryList invList)throws Exception {
        
        if(invList == null)
            throw new NullPointerException("Registro inv no puede ser null");
        
        List <InventoryVo> listInv = invList.getListInv();           
        int last_sec = 0;
        
        for(InventoryVo ob: listInv){          
                        
            if(getInv(ob) == null){
                System.out.println("no encuentra  Id:"+ob.getInvId()+"  Art:"+ob.getInvIdItem()+"   Suc:"+ob.getInvIdBranch());  
            }else{
                inventDao.updateInv(ob); 
                last_sec = ob.getInvUltimo();
                System.out.println("hace update inv "+ob.getInvId());  
            }           
        }
        inventDao.updateSec(last_sec);
    }
    
    public void updateInv(InventoryVo inventVo)throws Exception {
        
        if(inventVo == null)
            throw new NullPointerException("El registro no puede ser null");
        
        if(inventVo.getInvIdItem() == 0)
            throw new Exception("El id del articulo no existe: '"+inventVo.getInvIdItem()+"'");
            
        if(inventVo.getInvIdBranch() == 0)
            throw new Exception("El id de la sucursal no existe: '"+inventVo.getInvIdBranch()+"'");
        
        inventDao.updateInv(inventVo);
    }
    
}
