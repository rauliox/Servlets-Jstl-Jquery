/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominio.servlet;

import com.dominio.dao.impl.productoDaoImpl;
import com.dominio.dto.productoBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Home-01
 */
@WebServlet(name = "productoServlet", urlPatterns = {"/productoServlet"})
public class productoServlet extends HttpServlet {

 
  productoDaoImpl pdi = new productoDaoImpl();
   
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
      String operacion = request.getParameter("operacion");
      
      HttpSession session = request.getSession();
   
      PrintWriter out = response.getWriter();
       
       
       try {
                 if(operacion.equals("listar")){
                    
                    session.setAttribute("listaproductos", listar());
                    
                 }
                 else if(operacion.equals("insertar")){
                     
                  String nombre = request.getParameter("nombre");
                  String descripcion = request.getParameter("descripcion");
                  String precio =  request.getParameter("precio");
                  String stock  = request.getParameter("stock");  
                  
                  
                   productoBean p = new productoBean();
                   p.setNombre(nombre);
                   p.setDescripcion(descripcion);
                   p.setPrecio(Double.valueOf(precio));
                   p.setStock(Integer.parseInt(stock));
                   out.print(insertar(p));
                   
            }
                 else if(operacion.equals("eliminar")){
                     
                  Integer id_producto = Integer.parseInt(request.getParameter("id_producto")) ;
                  out.print(pdi.Delete(id_producto));
                     
                 
                 }
                 else if(operacion.equals("editar")){
                  Integer id_producto = Integer.parseInt(request.getParameter("id_producto")) ;
                  String nombre = request.getParameter("nombre");
                  String descripcion = request.getParameter("descripcion");
                  String precio =  request.getParameter("precio");
                  String stock  = request.getParameter("stock"); 
                   
                   productoBean p = new productoBean();
                   p.setId_producto(id_producto);
                   p.setNombre(nombre);
                   p.setDescripcion(descripcion);
                   p.setPrecio(Double.valueOf(precio));
                   p.setStock(Integer.parseInt(stock));
                   out.print(pdi.update(p));
                  
                 
                 }
                 else if(operacion.equals("consultar")){
                  Integer id_producto = Integer.parseInt(request.getParameter("id_producto")) ;
                  //importante
                  //en este caso meter en session una variable que se va a utilizar para una simple consulta
                  //podría ocasionar inconvenientes, por eso le damos el scope request
                  request.setAttribute("productoBean",pdi.select(id_producto));
                //  session.setAttribute("producto2",pdi.select(id_producto));
                  
                  
                  //out.print("ok");
                 
                 }
                 
                
      } catch (Exception e) {
         
        out.print("No se ingreso operación :" + e);
      }
       
     }
    
    public List<productoBean> listar(){
       
        List<productoBean> listaproductos = new ArrayList<>();
        try {
            listaproductos = pdi.selectAll();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       return listaproductos;
        
    }
    
    public String insertar(productoBean prod){
               String msg = pdi.create(prod);
               return msg;
    }
    
    


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
