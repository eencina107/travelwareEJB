/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ContactoDao;
import com.fpuna.py.travelware.model.ConContactos;
import com.fpuna.py.travelware.model.PgeUsuarios;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author olimp
 */
@Stateless
public class ContactoImpl implements ContactoDao{
    final static Logger logger = Logger.getLogger(ContactoImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ConContactos create(ConContactos object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserto el contacto con el id:"+object.getConId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public ConContactos getById(Integer id) {
        try {
            return em.find(ConContactos.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ConContactos update(ConContactos object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el contacto con id:"+object.getConId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ConContactos object) {
        try {
            int id = object.getConId();
            em.remove(em.find(ConContactos.class, id));
            em.flush();
            logger.info("Se elimina el contacto con id:"+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ConContactos> getAll() {
        try {
            return em.createNamedQuery("ConContactos.findAll").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public List<ConContactos> getPendientesByUsuario(PgeUsuarios usuario) {
        try {
            List<ConContactos> lista = em.createQuery("SELECT c from ConContactos c WHERE c.conEstado ='P' AND c.conIdUsuarioCont= :usuario")
                    .setParameter("usuario", usuario)
                    .getResultList() ;
            return lista;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getPendientesByUsuario ", e);
            return null;
        }
    }

    @Override
    public List<ConContactos> getPendientesDia(PgeUsuarios usuario, Date fecha) {
        try {
            List<ConContactos> lista = em.createQuery("SELECT c from ConContactos c WHERE c.conEstado ='P' AND c.conIdUsuarioCont= :usuario AND c.conFechaContacto = :fecha")
                    .setParameter("usuario", usuario)
                    .setParameter("fecha", fecha)
                    .getResultList() ;
            return lista;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getPendientesDia ", e);
            return null;
        }
    }
    
}
