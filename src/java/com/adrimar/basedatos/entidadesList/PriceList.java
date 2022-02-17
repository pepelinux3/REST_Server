/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.entidadesList;

import com.adrimar.basedatos.entidades.PriceVo;
import java.util.List;

/**
 *
 * @author pepe
 */
public class PriceList {
    private List <PriceVo> pricelist;
    
    public List<PriceVo> getListPrice(){
        return pricelist;
    }
    
    public void setListPrice(List<PriceVo> pricelist){
        this.pricelist = pricelist;
    }
}

/*
 private List <ItemVo> itemlist;
    
    public List<ItemVo> getListItem(){
        return itemlist;
    }
    
    public void setListItem(List<ItemVo> itemlist){
        this.itemlist = itemlist;
    }
*/