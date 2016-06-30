/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominio.dao.impl;

import com.dominio.conexion.Conexion;
import com.dominio.dto.productoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home-01
 */
public class test {
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
         String[] nombres = {"usuario1","usuario2"};
         
         List<productoBean> lista  = new ArrayList<>();
         
         lista.add(new productoBean(1,"tv","smart",1500d,10));
         lista.add(new productoBean(2,"pc2","smart2",1476.5d,10));
         lista.add(new productoBean(3,"pc3","smart3",1476.5d,10));
         lista.add(new productoBean(4,"pc4","smart4",1476.5d,10));
         lista.add(new productoBean(5,"pc5","smart5",1476.5d,10));
         
         int i= 0;      
         for(productoBean l:lista){
          
           if(i== 2){
               System.out.println(l.getNombre());
               
           }
          i=i+1;
         }
        lista.remove(2);
        
         for(int j= 0 ; j < lista.size() ; j++){
             if(j == 2){
                 System.out.println(lista.get(j).getDescripcion());
            }
         
         }
         
        
    }
}