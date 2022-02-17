/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.dao;

import com.adrimar.basedatos.entidades.BlogVo;
import com.adrimar.basedatos.entidades.SequenceVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin3
 */
public class ToolsDao {
	
    public List<SequenceVo> getListSequence(){
        List<SequenceVo> listSec= new ArrayList<SequenceVo>();
        
        try{
            Connect_DB connection = new Connect_DB();

            String query =	" SELECT sec_clave, sec_codigo, sec_tabla, sec_fecha, sec_Final, sec_update, sec_restore "+
							" FROM secuencia ";
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            SequenceVo secVo;
            
            while (rs.next()){
                secVo =  new SequenceVo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                listSec.add(secVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return listSec;
    }
    
    public List<BlogVo> getListBlog() {
        List<BlogVo> listBlog= new ArrayList<BlogVo>();
        
        try{
            Connect_DB connection = new Connect_DB();

            String query =  " SELECT bit_clave, bit_numeroCel, bit_nombre, bit_codigoIMEI, bit_mac,"+
                            " bit_accion, bit_fechahora, bit_descripcion, bit_suc_clave FROM bitacora ";
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            BlogVo blogVo;
            
            while (rs.next()){
                blogVo =  new BlogVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                listBlog.add(blogVo);
            }
			
            rs.close();
            ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return listBlog;
    }
    
    public void addBlog (BlogVo blogVo){
        try{
            Connect_DB connection = new Connect_DB();           
            
            String insertItem =  " INSERT INTO bitacora (bit_numeroCel, bit_nombre, bit_codigoIMEI, bit_mac, ";
            insertItem += "                    bit_accion, bit_fechahora, bit_descripcion, bit_suc_clave)  ";
            insertItem += "         VALUES ( ";
            insertItem += "'"+blogVo.getTbi_numcel()+"', '"+blogVo.getTbi_nombre()+"', '"+blogVo.getTbi_imei()+"', ";
            insertItem += "'"+blogVo.getTbi_mac()+"', '"+blogVo.getTbi_accion()+"', '"+blogVo.getTbi_fechahora()+"', ";
            insertItem += "'"+blogVo.getTbi_descripcion()+"', "+blogVo.getTbi_sucursal()+")";
            // '"+blogVo.getTbi_mac()+"', ";
            System.out.println(insertItem);
            
	    PreparedStatement ps = connection.getConnection().prepareStatement(insertItem);
            ps.execute(insertItem);
            		      
	    ps.close();
            connection.getConnection().close();
			
        } catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
     public BlogVo getBlog(String imei){
        BlogVo obBlog = new BlogVo();
       
        try {
            Connect_DB connection = new Connect_DB();
            
            String query;
            query =  " SELECT bit_clave, bit_numeroCel, bit_nombre, "; 
            query += "        bit_codigoIMEI, bit_mac, bit_accion,  ";
            query += "        bit_fechahora, bit_descripcion, bit_suc_clave  ";
            query += "   FROM bitacora        ";     
            query += "  WHERE bit_codigoIMEI = '"+imei+"' ORDER BY bit_clave DESC LIMIT 1;";          
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();                              
                
            if(rs.next()){
                obBlog = new BlogVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }else{
                obBlog = null;
            } 
			
            rs.close();
            ps.close();
            connection.getConnection().close();
			
        } catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obBlog;
    }
}
