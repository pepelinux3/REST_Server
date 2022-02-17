/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.entidadesList;

import com.adrimar.basedatos.entidades.InventoryVo;
import java.util.List;

/**
 *
 * @author pepe
 */
public class InventoryList {
   private List <InventoryVo> invlist;
    
    public List<InventoryVo> getListInv(){
        return invlist;
    }
    
    public void setListInv(List<InventoryVo> invlist){
        this.invlist = invlist;
    }
}
