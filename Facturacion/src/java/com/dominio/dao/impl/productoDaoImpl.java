/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominio.dao.impl;

import com.dominio.conexion.Conexion;
import com.dominio.dao.contrato;
import com.dominio.dto.productoBean;
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
 * @author Home-01
 */
public class productoDaoImpl implements contrato<productoBean>{
    
    
    private  final Conexion conexion = Conexion.saberEstado();
    private final String SQL_SELECT_ALL = "SELECT id_producto,nombre,descripcion,precio,stock  FROM producto";
    private final String SQL_INSERT ="INSERT INTO producto (nombre,descripcion,precio,stock) values (?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE producto SET nombre = ? , descripcion = ?, precio = ?, stock = ?  WHERE id_producto = ? ";
    private final String SQL_DELETE = "DELETE FROM producto WHERE id_producto = ?";
    private final String SQL_SELECT = "SELECT * FROM producto WHERE id_producto = ?";
    
    @Override
    public List<productoBean> selectAll() {
        List<productoBean> listaproductos = new ArrayList<>();
        ResultSet rs ;
        try {
           
            PreparedStatement ps = conexion.getConn().prepareStatement(SQL_SELECT_ALL);
            rs=ps.executeQuery();
            while(rs.next()){
                productoBean p = new productoBean();
                p.setId_producto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                listaproductos.add(p);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(productoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Conexion.cerrarConexion();
        }
        return listaproductos;
    }
   
 
    
    @Override
    public String create(productoBean b) {
    String msg= "";
    try {
            
            PreparedStatement ps = conexion.getConn().prepareStatement(SQL_INSERT);
            ps.setString(1, b.getNombre());
            ps.setString(2, b.getDescripcion());
            ps.setDouble(3,b.getPrecio());
            ps.setInt(4, b.getStock());
          
            if(ps.executeUpdate() > 0){
               msg="Fila ingresada con exito";
            }
            
            
     } catch (SQLException ex) {
            Logger.getLogger(productoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       finally{
           Conexion.cerrarConexion();
       }
       
    return msg;
    
    
    }

    @Override
    public String update(productoBean p) {
    String msg= "";
        try {
            PreparedStatement ps = conexion.getConn().prepareStatement(SQL_UPDATE);
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getDescripcion());
            ps.setDouble(3,p.getPrecio());
            ps.setInt(4,p.getStock() );
            ps.setInt(5, p.getId_producto());
            
            if(ps.executeUpdate()> 0){
                
                 msg = "fila actualizada con exito";
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(productoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Conexion.cerrarConexion();
        }
        
        return msg;
    }

    @Override
    public String Delete(int id_producto) {
    String msg= "";
    
        try {
            PreparedStatement  ps =  conexion.getConn().prepareStatement(SQL_DELETE);
            ps.setInt(1, id_producto);
            if(ps.executeUpdate() > 0){
                  msg = "fila borrada correctamente";
            }
           /* else{
               msg = "no se puedo eliminar el elemento";
            }
            */
        } catch (SQLException ex) {
            Logger.getLogger(productoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            msg = "error SQLException" + ex.toString();
        }
        finally{
        Conexion.cerrarConexion();
        
        }
        
    return msg ;
    
    }

    @Override
    public productoBean select(int id_producto) {
    productoBean p = new productoBean();
     
        ResultSet rs ;
        try {
            PreparedStatement ps = conexion.getConn().prepareStatement(SQL_SELECT);
            ps.setInt(1,id_producto );
            rs = ps.executeQuery();
            while(rs.next()){
                p.setId_producto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(productoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return p;
 }

 
    
    
    
}
