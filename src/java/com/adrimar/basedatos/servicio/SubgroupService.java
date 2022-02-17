/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.servicio;

import com.adrimar.basedatos.dao.SubgroupDao;
import com.adrimar.basedatos.entidades.GroupVo;
import com.adrimar.basedatos.entidades.SubgroupVo;
import java.util.List;

/**
 *
 * @author pepe
 */
public class SubgroupService {
    
    SubgroupDao subdao;
    
    public SubgroupService() {
        subdao = new SubgroupDao();
    }
    
    public int getLastSub(){
        return subdao.getLastSub();
    }
    
	public List<SubgroupVo> getListSubgroup(){
        return subdao.getListSubgroups();
    }  
	
	public List<SubgroupVo> getListSub_High(int id){
        return subdao.getListSubGroup_High(id);
    } 
	
}
