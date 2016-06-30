/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominio.dao.impl;

import com.dominio.conexion.Conexion;
import com.dominio.dao.contrato;
import com.dominio.dto.usuarioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class usuarioDaoImpl implements contrato<usuarioBean>{

    @Override
    public String create(usuarioBean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(usuarioBean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Delete(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public List<usuarioBean> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  public boolean validar(String user,String pw){
            
            PreparedStatement ps ;
            ResultSet rs;
        try {
           
            ps = Conexion.saberEstado().getConn().prepareStatement("select nombre,password from usuario WHERE nombre = ? and password = MD5(?)");
            ps.setString(1, user);
            ps.setString(2, pw);
            rs = ps.executeQuery();
            
                 if(rs.next() == true){
                    // msg= "datos correctos";
                     return true;
                 }
                

          } catch (SQLException ex) {
            Logger.getLogger(productoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
         Conexion.cerrarConexion();
        }
   return false;
   
  }

    @Override
    public usuarioBean select(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
