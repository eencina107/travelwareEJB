/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.UsuarioDao;
import com.fpuna.py.travelware.model.PgeRoles;
import com.fpuna.py.travelware.model.PgeUsuRoles;
import com.fpuna.py.travelware.model.PgeUsuarios;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
@Stateless
public class UsuarioImpl implements UsuarioDao{
    final static Logger logger = Logger.getLogger(FidelidadImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeUsuarios create(PgeUsuarios object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el disertante con id:"+object.getUsuId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgeUsuarios getById(Integer id) {
        try {
            return em.find(PgeUsuarios.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeUsuarios update(PgeUsuarios object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el usuario con el id:"+object.getUsuId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeUsuarios object) {
        try {
            int id = object.getUsuId();
            
            em.remove(em.find(PgeUsuarios.class, id));
            em.flush();
            logger.info("Se elimina el usuario con el id:"+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeUsuarios> getAll() {
        try {
            return em.createQuery("SELECT u from PgeUsuarios u").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
    @Override
    public PgeUsuarios autenticate (String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        PgeUsuarios usuario;
        try{
            usuario = (PgeUsuarios) em.createNamedQuery("PgeUsuarios.findByUsuCod").setParameter("usuCod", username).getSingleResult();

            /*Se convierte el string ingresado en codigo Hash-MD5 y se compara con el de la BD*/
            String hashIngresado;
            hashIngresado = (String) em.createNativeQuery("SELECT md5(\'"+password+"\')").getSingleResult();

            String hashBD;
            hashBD = usuario.getUsuPass();

            if ((usuario != null) && (hashIngresado.equals(hashBD))) {
                return usuario;
            }
            else {
                return null;    
            }   
        }
        catch(Exception e)
        {
            return null;
        }
    }

    
    
}
