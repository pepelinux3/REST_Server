/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pepe  
 */
public class Connect_DB {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/ws_lssai_bd";  
  //   private static String user = "root";
  //   private static String password = "12345678";
    private static String user = "ws_martin";
    private static String password = "**Linux333221";
	
    private static Connection conn;
    
    public Connect_DB() {
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            
            if(conn != null){
                System.out.println("Conexion establecida");
            }
        } 
        catch(SQLException SQLE){
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION CON BD\nERROR : " + SQLE.getMessage());
        }
        catch(ClassNotFoundException CNFE){
            JOptionPane.showMessageDialog(null, "ERROR DRIVER BD JAVA\nERROR : " + CNFE.getMessage());
        }
    }
    
    // con este metodo nos retorna la conexion
    public Connection getConnection(){
        return conn;
    }
       
    // con este metodo nos desconectamos de la BD
    public void disconnect(){
        conn = null;        
        if(conn == null){
            System.out.println("Conexion terminada");
        }
    }
	
	/*
	
	
private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "lssai_user";
    private static final String password = "ls123"; 
    private static final String url = "jdbc:mysql://10.10.20.200:3306/lssai_bd";

    public ConnectDB() {
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            
            if(conn != null){
                System.out.println("Conexion establecida");
            }
        } 
        catch(SQLException SQLE){
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION CON BD\nERROR : " + SQLE.getMessage());
        }
        catch(ClassNotFoundException CNFE){
            JOptionPane.showMessageDialog(null, "ERROR DRIVER BD JAVA\nERROR : " + CNFE.getMessage());
        }
    }
    
    // con este metodo nos retorna la conexion
    public Connection getConnection(){
        return conn;
    }
       
    // con este metodo nos desconectamos de la BD
    public void disconnect(){
        conn = null;        
        if(conn == null){
            System.out.println("Conexion terminada");
        }
    }	
	
	
	*/
	
}
