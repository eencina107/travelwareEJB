/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.RolDao;
import com.fpuna.py.travelware.model.PgePermisos;
import com.fpuna.py.travelware.model.PgeRoles;
import com.fpuna.py.travelware.model.PgeUsuRoles;
import com.fpuna.py.travelware.model.PgeUsuarios;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.html.HTMLDocument;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
@Stateless
public class RolImpl implements RolDao{
    final static Logger logger = Logger.getLogger(RolImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeRoles create(PgeRoles object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el rol con id:"+object.getRolId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgeRoles getById(Integer id) {
        try {
            return em.find(PgeRoles.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeRoles update(PgeRoles object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el rol con el id:"+object.getRolId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeRoles object) {
        try {
            int id = object.getRolId();
            
            em.remove(em.find(PgeRoles.class, id));
            em.flush();
            logger.info("Se elimina el rol con id:"+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeRoles> getAll() {
        try {
            return em.createQuery("select r from PgeRoles r").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public List<PgeRoles> getRolesByUsuario(PgeUsuarios usuario) {
        List<PgeUsuRoles> usuRoles;
        List<PgeRoles> roles = new ArrayList();
        
        usuRoles = em.createNamedQuery("PgeUsuRoles.findByUsuId").setParameter("usuId", usuario.getUsuId()).getResultList();

        Iterator it = usuRoles.iterator();

        while (it.hasNext()){
            try{
                PgeUsuRoles uro= (PgeUsuRoles) it.next();
                PgeRoles ro=(PgeRoles) em.createNamedQuery("PgeRoles.findByRolId").setParameter("rolId",uro.getPgeUsuRolesPK().getRolId()).getSingleResult();
                roles.add(ro);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }

        return roles;
    }
    

    @Override
    public List<PgePermisos> getPermisos(PgeRoles object) {
        return  em.createNamedQuery("PgePermisos.findByRolId").setParameter("rolId", object.getRolId()).getResultList();
    }

    @Override
    public PgeRoles getByName(String name) {
        try {
            return (PgeRoles) em.createNamedQuery("PgeRoles.findByRolDesc").setParameter("rolDesc", name).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

}
