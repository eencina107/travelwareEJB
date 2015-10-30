/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.MenuDao;
import com.fpuna.py.travelware.model.PgeMenus;
import java.util.List;
import org.apache.log4j.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eencina
 */
@Stateless
public class MenuImpl implements MenuDao{
    final static Logger logger = Logger.getLogger(MenuImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;
    
    @Override
    public PgeMenus create(PgeMenus object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el menu con id:"+object.getPgeMenusPK().getMenId()+" con el submenu con id:"+object.getPgeMenusPK().getMenSubId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    public PgeMenus getById(Integer menuId, Integer subMenuId) {
        try {
            return (PgeMenus) em.createQuery("SELECT m from PgeMenus m WHERE m.pgeMenusPK.menId = :menuId and m.pgeMenusPK.menSubId = :subMenuId").setParameter("menuId", menuId).setParameter("subMenuId", subMenuId).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeMenus update(PgeMenus object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el menu con id:"+object.getPgeMenusPK().getMenId()+" y submenu con id:"+object.getPgeMenusPK().getMenSubId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeMenus object) {
        try {
            int menuId = object.getPgeMenusPK().getMenId();
            int subMenuId = object.getPgeMenusPK().getMenSubId();
            em.remove(em.find(PgeMenus.class, object));
            em.flush();
            logger.info("Se elimina el menu con id:"+menuId+" con el submenu con id:"+subMenuId);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeMenus> getAll() {
        try {
            return em.createQuery("select m FROM PgeMenus m").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public PgeMenus getById(Integer id) {
        throw new UnsupportedOperationException("ERROR. Metodo no soportado."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
