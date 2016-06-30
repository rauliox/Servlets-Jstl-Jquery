/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominio.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Home-01
 */
@WebFilter(filterName = "filtroLogin" , urlPatterns ={"/modulo/fdsfds/*"} )

public class filterLogin implements Filter{
    FilterConfig config;  
    @Override
    public void init(FilterConfig filterconfig) throws ServletException {
         this.config=filterconfig;  
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
    
        HttpServletRequest _request =(HttpServletRequest) request;
        HttpServletResponse _response = (HttpServletResponse) response;
        String url = _request.getContextPath();
        String usuario = (String) _request.getAttribute("usuario");
      
       if(usuario != null){
            _response.sendRedirect("/modulo/principal.jsp"); 
        }
        else{
         _response.sendRedirect(url+"/index.jsp");
        }
        
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
