/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominio.conexion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home-01
 */
public class Conexion {
    
    private Connection conn;
    private static Conexion instancia;
    
    private Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facturacion", "root","1234");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static synchronized Conexion saberEstado(){
        if(instancia == null){
            instancia = new Conexion();
        }
    return instancia;
    }
    
    public Connection getConn(){
         return conn;
    }
    public static void cerrarConexion(){
        instancia = null;
    }
    
    
    
}
