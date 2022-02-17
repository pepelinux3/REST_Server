/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.dao;

import com.adrimar.basedatos.entidades.GroupVo;
import com.adrimar.basedatos.entidades.InventoryVo;
import com.adrimar.basedatos.entidades.ItemVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pepe
 */
public class GroupDao {
    
    public int getSecFinalGroup(){
       int idSecuencia = 0;
        
        try {
            Connect_DB connection = new Connect_DB();
                      
            String query;
            query = " SELECT sec_final FROM secuencia WHERE sec_clave = 6;";          
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();                              
                           
            if(rs.next()){
               idSecuencia = rs.getInt(1);
            }  
            
			rs.close();
			ps.close();
            connection.getConnection().close();
			
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return idSecuencia;
    }
	
	public List<GroupVo> getListGroups(){
        List<GroupVo> listGru= new ArrayList<GroupVo>();
        
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =	" SELECT gru_clave, gru_emp_clave, gru_nombre FROM grupos "+
							"  WHERE gru_status = 1 ";
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            GroupVo gruVo;
            
            while (rs.next()){
                gruVo =  new GroupVo(rs.getInt(1), rs.getInt(2), rs.getString(3));
                listGru.add(gruVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return listGru;
    }
	
	public List<GroupVo> getListGroup_High(int idGroup){
        List<GroupVo> listGru = new ArrayList<GroupVo>();
        
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =	" SELECT gru_clave, gru_emp_clave, gru_nombre FROM grupos "+
							"  WHERE gru_status = 1 and gru_clave > "+idGroup+
							"  ORDER BY gru_clave;";
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            GroupVo gruVo;
            
            while (rs.next()){
                gruVo =  new GroupVo(rs.getInt(1), rs.getInt(2), rs.getString(3));
                listGru.add(gruVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listGru;
    }
		
}
