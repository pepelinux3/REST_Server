/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.dao;

import com.adrimar.basedatos.entidades.SubgroupVo;
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
public class SubgroupDao {
    
    public int getLastSub(){
       int idSecuencia = 0;
        
        try {
            Connect_DB connection = new Connect_DB();
                      
            String query;
            query = " SELECT sec_final FROM secuencia WHERE sec_clave = 5;";          
            
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
    
	public List<SubgroupVo> getListSubgroups(){
        List<SubgroupVo> listSub = new ArrayList<SubgroupVo>();
        
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =	" SELECT subg_clave, subg_nombre, subg_descripcion, "+
							"        subg_gru_clave, subg_descuento, subg_porcentaje "+
				            "   FROM subgrupos "+
							"  WHERE subg_status = 1 ";
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            SubgroupVo subVo;
  
            while (rs.next()){
                subVo =  new SubgroupVo(rs.getInt(1), rs.getString(2), rs.getString(3)+"", rs.getInt(4), rs.getFloat(5), rs.getFloat(6));
                listSub.add(subVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return listSub;
    }
	
	
	public List<SubgroupVo> getListSubGroup_High(int idSub){
        List<SubgroupVo> listSub = new ArrayList<SubgroupVo>();
        
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =	" SELECT subg_clave, subg_nombre, subg_descripcion, "+
							"        subg_gru_clave, subg_descuento, subg_porcentaje "+
				            "   FROM subgrupos "+
							"  WHERE subg_status = 1 and subg_clave > "+idSub+
							 " ORDER BY subg_clave ";
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            SubgroupVo subVo;
            
            while (rs.next()){
                subVo =  new SubgroupVo(rs.getInt(1), rs.getString(2), rs.getString(3)+"", rs.getInt(4), rs.getFloat(5), rs.getFloat(6));
                listSub.add(subVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listSub;
    }
	
}
