/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.servicio;

import com.adrimar.basedatos.dao.PriceDao;
import com.adrimar.basedatos.entidadesList.ItemList;
import com.adrimar.basedatos.entidades.ItemVo;
import com.adrimar.basedatos.entidadesList.PriceList;
import com.adrimar.basedatos.entidades.PriceVo;
import java.util.List;

/**
 *
 * @author pepe
 */
public class PriceService {
    
    private PriceDao pricedao;
    
    public PriceService(){
        pricedao = new PriceDao();
    }
    
    public PriceVo getPrice(PriceVo pricevo){
        return pricedao.getPrice(pricevo.getTpri_articulo(), pricevo.getTpri_lista());
    }
    
    public PriceVo updatePrice(PriceVo pricevo){
        pricedao.updatePrice(pricevo);
        return getPrice(pricevo);
    }
    
    public int getLastPrice (){
        return pricedao.getLastPrice();
    }
    
    public List<PriceVo> getNewPrices(int id){
        return pricedao.getListPri_High(id);
    }  
    
    public List<PriceVo> getAllPrices(){
        return pricedao.getListAllPrice();
    }  
    
    public List<PriceVo> checkNewPrice(PriceList priceList) throws Exception{
       
        if(priceList == null)
            throw new NullPointerException("Registro PriceList no puede ser null");
        
        List <PriceVo> listprice = priceList.getListPrice();
	int last_sec = 0;
			
        for(PriceVo ob: listprice){          
                               
            if(getPrice(ob) != null){				
		pricedao.updatePrice(ob);
                System.out.println("precio ya existe entra a EDITAR"); 				
            } else{ 				
               pricedao.addPrice(ob);
                System.out.println("articulo no existe entra a INSERTAR "+ob.getTpri_articulo()); 
            }	
            
            last_sec = ob.getTpri_ultimo();
        }
        
        pricedao.updateSec(last_sec);
        return listprice;
    }
    
}
