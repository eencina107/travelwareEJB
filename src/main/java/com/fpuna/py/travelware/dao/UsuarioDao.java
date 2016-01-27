/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PgeUsuarios;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author eencina
 */
public interface UsuarioDao extends GenericDao<PgeUsuarios, Integer>{
    public PgeUsuarios autenticate(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    public PgeUsuarios changePass(String username, String newPassword);
    public PgeUsuarios getByName(String name);
}
