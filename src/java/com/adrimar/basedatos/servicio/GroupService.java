/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.servicio;

import com.adrimar.basedatos.dao.GroupDao;
import com.adrimar.basedatos.entidades.GroupVo;
import java.util.List;

/**
 *
 * @author pepe
 */
public class GroupService {
    
    private GroupDao groupdao;

    public GroupService() {
        groupdao = new GroupDao();
    }
    
    public int getLastGroup(){
        return groupdao.getSecFinalGroup();
    }
    
	public List<GroupVo> getListGroup(){
        return groupdao.getListGroups();
    }  
	
	public List<GroupVo> getListGroup_High(int id){
        return groupdao.getListGroup_High(id);
    } 
}
