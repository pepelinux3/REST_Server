/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.dao;

import com.adrimar.basedatos.entidades.InventoryVo;
import java.sql.Connection;
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
public class InventoryDao {
    
    public int getFirtsInv(){
       int idSecuencia = 0;
        
        try {
			Connect_DB connection = new Connect_DB();
                      
            String query;
            query = " SELECT sec_inicial FROM secuencia WHERE sec_clave = 1;";          
            
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
    
    public int getLastInv(){
       int idSecuencia = 0;
        
        try {
            Connect_DB connection = new Connect_DB();
                      
            String query;
            query = " SELECT sec_final FROM secuencia WHERE sec_clave = 1;";          
            
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
    
    public InventoryVo getInv(int idArt, int idSuc){
        InventoryVo invent = new InventoryVo();
       
        try {
            Connect_DB connection = new Connect_DB();
            
            String query;
            query =  " SELECT inv_clave, inv_art_clave, inv_suc_clave, "; 
            query += "        inv_existencia, inv_ultimo  ";
            query += "   FROM inventario        ";     
            query += "  WHERE inv_art_clave = '"+idArt+"' and inv_suc_clave = '"+idSuc+"';";          
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();                              
                
            if(rs.next()){
                invent = new InventoryVo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }else{
                invent = null;
            } 
			
            rs.close();
			ps.close();
            connection.getConnection().close();
			
        } catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invent;
    }
    
    public List<InventoryVo> getListInv_High(int idSecIni){
        List<InventoryVo> listInv= new ArrayList<InventoryVo>();
        
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =	" SELECT inv_clave, inv_art_clave, inv_suc_clave, "+
							"        inv_existencia, inv_ultimo "+
							"   FROM inventario WHERE inv_ultimo > "+idSecIni+" "+
							"   ORDER BY inv_ultimo;";
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            InventoryVo invVo;
            
            while (rs.next()){
                invVo =  new InventoryVo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                listInv.add(invVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listInv;
    }
    
    	public List<InventoryVo> getListInv_HighLim(int idSecIni, int idSecFin){
        List<InventoryVo> listInv= new ArrayList<InventoryVo>();
        
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =	" SELECT inv_clave, inv_art_clave, inv_suc_clave, "+
							"        inv_existencia, inv_ultimo "+
							"   FROM inventario "+
							"  WHERE inv_ultimo > "+idSecIni+" "+
							"    and inv_ultimo <= "+idSecFin+" "+	
							"   ORDER BY inv_ultimo;";
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            InventoryVo invVo;
            
            while (rs.next()){
                invVo =  new InventoryVo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                listInv.add(invVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listInv;
    }
    
    public void updateInv(InventoryVo inventVo){
         try{
             Connect_DB connection = new Connect_DB();
             
             String query = " UPDATE inventario SET ";
             query += " inv_existencia = '"+inventVo.getInvExist()+"', ";
             query += " inv_ultimo = '"+inventVo.getInvUltimo()+"' ";
             query += " WHERE inv_art_clave = "+inventVo.getInvIdItem();
             query += "   and inv_suc_clave = "+inventVo.getInvIdBranch();
             
             PreparedStatement ps = connection.getConnection().prepareStatement(query);
             ps.execute(query);
			 
			 ps.close();
			 connection.getConnection().close();
			 
         } catch (SQLException ex){
             Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void updateSec(int last_sec){
         try{
             Connect_DB connection = new Connect_DB();
             
             String query = " UPDATE secuencia SET ";
                    query += "   sec_inicial =  sec_final, ";
                    query += "   sec_final = "+last_sec;
                    query += " WHERE sec_clave = 1";
             
             PreparedStatement ps = connection.getConnection().prepareStatement(query);
             ps.execute(query);
             
			 ps.close();
			 connection.getConnection().close();
			 
         } catch (SQLException ex){
             Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
	
	public List<InventoryVo> getListAllInv(){
        List<InventoryVo> listInv= new ArrayList<InventoryVo>();
		
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =	" SELECT inv_clave, inv_art_clave, inv_suc_clave, "+
							"        inv_existencia, inv_ultimo "+
							"   FROM inventario, articulos "+
				            "  WHERE inv_art_clave = art_clave"+
							"  ORDER BY inv_art_clave; ";		
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            InventoryVo invVo;
            
            while (rs.next()){
                invVo =  new InventoryVo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                listInv.add(invVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listInv;
    }
	
    public List<InventoryVo> getListInvNewItem(int secFinal){
        List<InventoryVo> listInv= new ArrayList<InventoryVo>();
		
        try{
            Connect_DB connection = new Connect_DB();
            
            String query = " SELECT inv_clave, inv_art_clave, inv_suc_clave, "+
			   "        inv_existencia, inv_ultimo "+
			   "   FROM inventario, edit_articulo "+
                           "  WHERE inv_art_clave = edart_art_clave "+
                           "    and edart_tipomov = 1"+
                           "    and edart_clave > "+secFinal+
			   "  ORDER BY inv_clave; ";		
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            InventoryVo invVo;
            
            while (rs.next()){
                invVo =  new InventoryVo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                listInv.add(invVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listInv;
    }
        
    public List<InventoryVo> getListInvItem(int idItem){
        List<InventoryVo> listInv= new ArrayList<InventoryVo>();
		
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =	" SELECT inv_clave, inv_art_clave, inv_suc_clave, "+
							"        inv_existencia, inv_ultimo "+
							"   FROM inventario, articulos "+
				            "  WHERE inv_art_clave = art_clave"+
							"    and art_clavearticulo = (select art_clavearticulo from articulos where art_clave = "+idItem+")"+
							"  ORDER BY inv_suc_clave; ";		
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            InventoryVo invVo;
            
            while (rs.next()){
                invVo =  new InventoryVo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                listInv.add(invVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listInv;
    }
    
}
