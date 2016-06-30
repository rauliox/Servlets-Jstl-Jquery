/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominio.dao;

import java.util.List;

/**
 *
 * @author Home-01
 */
public interface contrato<Bean> {
    public String create(Bean b);
    public String update(Bean b);
    public String Delete(int key);
    public Bean select(int key);
    public List<Bean> selectAll();
    
    
}
