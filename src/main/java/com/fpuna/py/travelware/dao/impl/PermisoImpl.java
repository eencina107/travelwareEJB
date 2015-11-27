/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PermisoDao;
import com.fpuna.py.travelware.model.PgePermisos;
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
public class PermisoImpl implements PermisoDao{
    final static Logger logger = Logger.getLogger(PermisoImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgePermisos create(PgePermisos object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el permiso del rol con id:"+object.getRolId()+" en el menu "+object.getPgeMenus().getMenId()+"-"+object.getPgeMenus().getMenSubId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    public PgePermisos getById(Integer rolId, Integer menuId, Integer submId) {
        try {
            return (PgePermisos) em.createQuery("select p from PgePermisos p WHERE p.pgePermisosPK.rolId = :rolId and p.pgePermisosPK.menuId = :menuId and p.pgePermisosPK.submenuId = :submId").setParameter("rolId", rolId).setParameter("menuId", menuId).setParameter("submId", submId).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgePermisos update(PgePermisos object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el permiso de rol con id:"+object.getRolId()+" sobre el menu:"+object.getPgeMenus().getMenId()+"-"+object.getPgeMenus().getMenSubId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgePermisos object) {
        try {
            int rolId = object.getRolId().getRolId();
            int menuId = object.getPgeMenus().getMenId();
            int submId = object.getPgeMenus().getMenSubId();
            
            em.remove(em.find(PgePermisos.class, object));
            em.flush();
            logger.info("Se elimina el permiso del rol con id:"+rolId+" sobre el menu:"+menuId+"-"+submId);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgePermisos> getAll() {
        try {
            return em.createQuery("select p from PgePermisos p").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public PgePermisos getById(Integer id) {
        throw new UnsupportedOperationException("ERROR. Metodo no soportado."); //To change body of generated methods, choose Tools | Templates.
    }

  

    
    
}
