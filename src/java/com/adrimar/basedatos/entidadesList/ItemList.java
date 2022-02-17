/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.entidadesList;

import com.adrimar.basedatos.entidades.ItemVo;
import java.util.List;

/**
 *
 * @author pepe
 */
public class ItemList {
    
    private List <ItemVo> itemlist;
    
    public List<ItemVo> getListItem(){
        return itemlist;
    }
    
    public void setListItem(List<ItemVo> itemlist){
        this.itemlist = itemlist;
    }
}
