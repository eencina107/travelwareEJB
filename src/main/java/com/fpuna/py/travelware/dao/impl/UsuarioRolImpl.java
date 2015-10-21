/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.UsuarioRolDao;
import com.fpuna.py.travelware.model.PgeUsuRoles;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class UsuarioRolImpl implements UsuarioRolDao{
    final static Logger logger = Logger.getLogger(UsuarioRolImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeUsuRoles create(PgeUsuRoles object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta la relacion entre el usuario con id:"+object.getPgeUsuRolesPK().getUsuId()+" con el rol con id:"+object.getPgeUsuRolesPK().getRolId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    public PgeUsuRoles getById(Integer usuId, Integer rolId) {
        try {
            return (PgeUsuRoles) em.createQuery("SELECT ur from PgeUsuRoles ur WHERE ur.pgeUsuRolesPK.usuId= :usuId and ur.pgeUsuRolesPK.rolId= :rolId").setParameter("usuId", usuId).setParameter("rolId", rolId).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeUsuRoles update(PgeUsuRoles object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza la relacion del usuario con id:"+object.getPgeUsuRolesPK().getUsuId()+" con el rol con id:"+object.getPgeUsuRolesPK().getRolId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeUsuRoles object) {
        try {
            int usuId = object.getPgeUsuRolesPK().getUsuId();
            int rolId = object.getPgeUsuRolesPK().getRolId();
            
            em.remove(em.find(PgeUsuRoles.class, object));
            em.flush();
            logger.info("Se elimina la relacion del usuario con id:"+usuId+" con el rol con id:"+rolId);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeUsuRoles> getAll() {
        try {
            return em.createQuery("select ur from PgeUsuRoles ur").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public PgeUsuRoles getById(Integer id) {
        throw new UnsupportedOperationException("ERROR. Metodo no soportado."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
