/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.dao;

import com.adrimar.basedatos.entidades.InventoryVo;
import com.adrimar.basedatos.entidades.ItemVo;
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
public class ItemDao {
    
    public ItemVo getItem(int idArt, int idEmp){
        ItemVo item = new ItemVo();
       
        try {
            Connect_DB connection = new Connect_DB();
            
            String query;
            query =  " SELECT art_clave, art_clavearticulo, art_nombreCorto,  "; 
            query += "        art_nombreLargo, art_emp_clave, art_subg_clave,   ";
	    query += "        art_status, IFNULL(art_listavisible,0) as art_listavisible, art_impuesto";
            query += "   FROM articulos        ";     
            query += "  WHERE art_clave = '"+idArt+"' and art_emp_clave = '"+idEmp+"';";          
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();                              
                
            if(rs.next()){
                item = new ItemVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getFloat(9), 0);
            }else{
                item = null;
            } 
			
            rs.close();
            ps.close();
            connection.getConnection().close();
                    
        } catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }
    
	public List<ItemVo> getListAllItems(){
        List<ItemVo> listItem= new ArrayList<ItemVo>();
        
        try{
            Connect_DB connection = new Connect_DB();
            
            String query =	" SELECT art_clave, art_clavearticulo, art_nombreCorto, "+
				"        art_nombreLargo, art_emp_clave, art_subg_clave, "+
				"        art_status, IFNULL(art_listavisible,0) as art_listavisible, art_impuesto "+
				"   FROM articulos WHERE art_listavisible = 1 and  art_status = 1 ";
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            ItemVo itemVo;
            
            while (rs.next()){
                itemVo = new ItemVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getFloat(9), 0);
                listItem.add(itemVo);
            }
			
			rs.close();
			ps.close();
            connection.getConnection().close();
        }
        catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return listItem;
    }
	
        public List<ItemVo> getListItem_High(int idLastItem){
        List<ItemVo> listSub = new ArrayList<ItemVo>();
        
        try{
            Connect_DB connection = new Connect_DB();
            
              String query =	" SELECT edart_art_clave, edart_clavearticulo, edart_nombrecorto, "+
				"        edart_nombrelargo, edart_emp_clave, edart_subg_clave, "+
				"        edart_status, edart_visible, edart_impuesto "+
				"   FROM edit_articulo  "+
                                "  WHERE edart_status = 1 and edart_clave > "+idLastItem;
            
            PreparedStatement ps = connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            ItemVo itemVo;
            
            while (rs.next()){
                itemVo =  new ItemVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getFloat(9), 0);
                listSub.add(itemVo);
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
        
    public int getLastItem(){
       int idSecuencia = 0;
        
        try {
            Connect_DB connection = new Connect_DB();
                      
            String query;
            query = " SELECT sec_final FROM secuencia WHERE sec_clave = 3;";          
            
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
    
	public int getLastEdItem(){
       int idSecuencia = 0;
        
        try {
            Connect_DB connection = new Connect_DB();
                      
            String query;
            query = "SELECT sec_final FROM secuencia WHERE sec_clave = 4;";          
            
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
	
    public void addItem (ItemVo itemVo){
        try{
            Connect_DB connection = new Connect_DB();           
            
            String insertItem =  " INSERT INTO articulos (art_clave, art_clavearticulo, art_nombreCorto, art_nombreLargo, ";
            insertItem += "                    art_inventariable, art_status, art_emp_clave, art_subg_clave, art_impuesto, art_listavisible)  ";
            insertItem += "         VALUES ( ";
            insertItem += ""+itemVo.getIdClave()+", '"+itemVo.getNoParte()+"', '"+itemVo.getNomCorto()+"', ";
            insertItem += "'"+itemVo.getNomLargo()+"', 1, "+itemVo.getStatus()+", "+itemVo.getIdEmpresa()+", ";
            insertItem += " "+itemVo.getIdSubgrupo()+", "+itemVo.getImpuesto()+", "+itemVo.getVisible()+");";
			
            PreparedStatement ps = connection.getConnection().prepareStatement(insertItem);
            ps.execute(insertItem);
            		
            String insertInv =  " INSERT INTO inventario (inv_art_clave, inv_suc_clave, inv_existencia)" ;
            insertInv += " (SELECT art_clave, suc_clave, 0 FROM sucursales, articulos ";
            insertInv += "  WHERE art_emp_clave = suc_emp_clave and art_clave = "+itemVo.getIdClave()+");";
           
            PreparedStatement ps2 = connection.getConnection().prepareStatement(insertInv);
            ps2.execute(insertInv);
        
			ps.close();
			ps2.close();
            connection.getConnection().close();
			
        } catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public void addEditItem (ItemVo itemVo, int tipo){
        try{
            Connect_DB connection = new Connect_DB();           
            
            String insertItem =  " INSERT INTO edit_articulo (edart_clave, edart_art_clave, edart_clavearticulo, edart_nombreCorto, edart_nombreLargo, ";
            insertItem += "                    edart_tipomov, edart_status, edart_emp_clave, edart_subg_clave, edart_impuesto, edart_visible)  ";
            insertItem += "         VALUES ( ";
            insertItem += ""+itemVo.getModifica()+", "+itemVo.getIdClave()+", '"+itemVo.getNoParte()+"', '"+itemVo.getNomCorto()+"', ";
            insertItem += "'"+itemVo.getNomLargo()+"', "+tipo+", "+itemVo.getStatus()+", "+itemVo.getIdEmpresa()+", ";
            insertItem += " "+itemVo.getIdSubgrupo()+", "+itemVo.getImpuesto()+", "+itemVo.getVisible()+");";
            
	    PreparedStatement ps = connection.getConnection().prepareStatement(insertItem);
            ps.execute(insertItem);
            		      
	    ps.close();
            connection.getConnection().close();
			
        } catch (SQLException ex){
            Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateItem(ItemVo itemVo){
         try{
             Connect_DB connection = new Connect_DB();
             
             String query = " UPDATE articulos SET ";
                    query += "   art_clavearticulo = '"+itemVo.getNoParte()+"',";
                    query += "   art_nombreCorto = '"+itemVo.getNomCorto()+"',";
                    query += "   art_nombreLargo = '"+itemVo.getNomLargo()+"',";           
                    query += "   art_status = "+itemVo.getStatus()+",";
                    query += "   art_subg_clave = "+itemVo.getIdSubgrupo()+",";
                    query += "   art_impuesto = "+itemVo.getImpuesto()+",";
                    query += "   art_listavisible= "+itemVo.getVisible()+"";
                    query += " WHERE art_clave = "+itemVo.getIdClave();
             
                    System.out.println(query);
                    
             PreparedStatement ps = connection.getConnection().prepareStatement(query);
             ps.execute(query);
             
             ps.close();
	     connection.getConnection().close();
			 
         } catch (SQLException ex){
             Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }   
        
    public void updateSecItem(int last_sec){
         try{
             Connect_DB connection = new Connect_DB();
             
             String query = " UPDATE secuencia SET ";
                    query += "   sec_inicial =  sec_final, ";
                    query += "   sec_final = "+last_sec;
                    query += " WHERE sec_clave = 4";
             
             PreparedStatement ps = connection.getConnection().prepareStatement(query);
             ps.execute(query);
             
			 ps.close();
			 connection.getConnection().close();
			 
         } catch (SQLException ex){
             Logger.getLogger(InventoryDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
