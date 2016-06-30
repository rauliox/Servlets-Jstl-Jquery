/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "importantescope", urlPatterns = {"/importantescope"})
public class importantescope extends HttpServlet {

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
         response.setContentType("text/html;charset=UTF-8");
          try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>SCOPE DE LAS VARIABLES EN UNA APPLICACION WEB JAVA</h1>");
            out.println("<h6> PAGE   /  REQUEST /  SESSION  /  APPLICATION(getServletContext)</h6>");
            out.println("<h3>request.getContextPath()    :  " + request.getContextPath() + "</h3>");
            out.println("<h3>request.getServletPath()   :  " + request.getServletPath() + "</h3>");
            out.println("<h3>request.getSession().getAttribute('dato') :  " + request.getSession().getAttribute("usuario")+ "</h3>");
            out.println("<h3>session.getAttribute('dato')  :  " + session.getAttribute("usuario")+ "</h2>");
            out.println("<h3>getServletContext().getContextPath()  :   " + getServletContext().getContextPath() + "</h3>");
            out.println("<h3>getServletContext().getRealPath  :   " + getServletContext().getRealPath("index.jsp")+ "</h3>");
            out.println("<h3>getServletContext().getServerInfo()  :   " + getServletContext().getServerInfo() + "</h3>");
            out.println("<h3>getServletContext().getServletContextName()  :   " + getServletContext().getServletContextName() + "</h3>");
            out.println("<span>Las peticiones ajax no respetan request , ni response - hacer pequeña prueba</span>");
            
            out.println("</body>");
            out.println("</html>");
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

}
