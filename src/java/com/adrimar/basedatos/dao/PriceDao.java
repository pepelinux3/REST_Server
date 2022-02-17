/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.dao;

import com.adrimar.basedatos.entidades.PriceVo;
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
public class PriceDao {    
    
    public PriceVo getPrice(int idArt, int idList){
        PriceVo obPrice = new PriceVo();
       
        try {
            Connect_DB connection = new Connect_DB();
            
            String query;
            query =  " SELECT lisd_clave, lisd_precio, lisd_fecha, "; 
            query += "        lisd_lise_clave, lisd_art_clave, lisd_ultimo  ";
            query += "   FROM listapreciosdetalle        ";     
            query += "  WHERE lisd_art_clave = '"+idArt+"' and lisd_lise_clave = '"+idList+"';";          
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();                              
                
            if(rs.next()){
                obPrice = new PriceVo(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
            }else{
                obPrice = null;
            } 
			
            rs.close();
            ps.close();
            connection.getConnection().close();
			
        } catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obPrice;
    }
    
    public int getLastPrice(){
       int idSecuencia = 0;
        
        try {
            Connect_DB connection = new Connect_DB();
                      
            String query;
            query = " SELECT sec_final FROM secuencia WHERE sec_clave = 2;";          
            
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
    
    public List<PriceVo> getListAllPrice(){
        List<PriceVo> listPrice= new ArrayList<PriceVo>();
		
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =  " SELECT lisd_clave, lisd_precio, lisd_fecha, "+
			    "        lisd_lise_clave, lisd_art_clave, lisd_ultimo "+
			    "   FROM listapreciosdetalle "+		
			    "  ORDER BY lisd_art_clave; ";		
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            PriceVo priVo;
            
            while (rs.next()){
                priVo =  new PriceVo(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                listPrice.add(priVo);
            }
			
            rs.close();
            ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPrice;
    }
    
    public List<PriceVo> getListPri_High(int idSecIni){
        List<PriceVo> listPrice= new ArrayList<PriceVo>();
        
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =  " SELECT lisd_clave, lisd_precio, lisd_fecha, "+
			    "        lisd_lise_clave, lisd_art_clave, lisd_ultimo "+
			    "   FROM listapreciosdetalle "+
                            "  WHERE lisd_ultimo > "+idSecIni+
			    "  ORDER BY lisd_ultimo; ";	
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            PriceVo priVo;
            
            while (rs.next()){
                priVo = new PriceVo(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                listPrice.add(priVo);
            }
			
            rs.close();
            ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPrice;
    }
    
    public void addPrice (PriceVo price){
        try{
            Connect_DB connection = new Connect_DB();           
            
            String insertPrice =  " INSERT INTO listapreciosdetalle (lisd_precio, lisd_fecha,  ";
            insertPrice += "                    lisd_lise_clave, lisd_art_clave, lisd_ultimo)  ";
            insertPrice += "         VALUES ( ";
            insertPrice += ""+price.getTpri_precio()+", '"+price.getTpri_fecha()+"', "+price.getTpri_lista()+", ";
            insertPrice += ""+price.getTpri_articulo()+", "+price.getTpri_ultimo()+") ";
           
            
	    PreparedStatement ps = connection.getConnection().prepareStatement(insertPrice);
            ps.execute(insertPrice);
            		      
	    ps.close();
            connection.getConnection().close();
			
        } catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePrice(PriceVo priVo){
        try{
            Connect_DB connection = new Connect_DB();
             
            String query = " UPDATE listapreciosdetalle SET ";
            query += " lisd_precio = "+priVo.getTpri_precio()+", ";
            query += " lisd_fecha = '"+priVo.getTpri_fecha()+"', ";
            query += " lisd_ultimo = "+priVo.getTpri_ultimo()+" ";
            query += " WHERE lisd_art_clave = "+priVo.getTpri_articulo();
            query += "   and lisd_lise_clave = "+priVo.getTpri_lista();
             
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
                    query += " WHERE sec_clave = 2";
             
             PreparedStatement ps = connection.getConnection().prepareStatement(query);
             ps.execute(query);
             
			 ps.close();
			 connection.getConnection().close();
			 
         } catch (SQLException ex){
             Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
