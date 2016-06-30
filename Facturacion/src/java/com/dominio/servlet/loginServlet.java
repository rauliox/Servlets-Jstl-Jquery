/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominio.servlet;

import com.dominio.conexion.Conexion;
import com.dominio.dao.impl.productoDaoImpl;
import com.dominio.dao.impl.usuarioDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author Home-01
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String accion = request.getParameter("accion");
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       PrintWriter out = response.getWriter();
       HttpSession session = request.getSession();
        
        if(accion.equals("verificar")){
            if(validarUsuario(username,password).equals("ok")){
                 session.setAttribute("usuario",username);
                  out.print("ok");
                  //response.sendRedirect("modulo/principal.jsp");
              
             }
            else{
            
            out.print("datos incorrectos");
            }
        }
        else if(accion.equals("redirectHome")){
           String usuario =(String) session.getAttribute("usuario");
         
           if(usuario != null){
                response.sendRedirect("modulo/principal.jsp");
              //  RequestDispatcher despachador = request.getRequestDispatcher("/modulo/principal.jsp");
              //  despachador.forward(request, response);
           }
           else{
               // RequestDispatcher despachador = request.getRequestDispatcher("/index.jsp");
               // despachador.forward(request, response);
                response.sendRedirect("index.jsp");
           }
         
        }
        
        else{
         out.print("accion no valida");
         
        }
   
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
    
    
    private String validarUsuario(String username,String password){
        
            String msg = null;
            usuarioDaoImpl udi = new usuarioDaoImpl();
            
            if(udi.validar(username, password) == true){
                 msg= "ok";
                
                //response.sendRedirect("modulo/principal.jsp");
                // RequestDispatcher despachador = request.getRequestDispatcher("modulo/principal.jsp");
                // despachador.forward(request, response);
                
            }
            
            else{
                
                msg= "datos incorrectos";
            }              
       
    return msg; 
    }
    

}
