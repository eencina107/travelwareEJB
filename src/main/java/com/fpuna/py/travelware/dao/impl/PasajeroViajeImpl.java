/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PasajeroViajeDao;
import com.fpuna.py.travelware.model.ViaPasViajes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class PasajeroViajeImpl implements PasajeroViajeDao{
    final static Logger logger = Logger.getLogger(PasajeroViajeImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaPasViajes create(ViaPasViajes object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el pasajero con id:"+object.getViaPasViajesPK().getPerId()+" en el viaje con id:"+object.getViaPasViajesPK().getViaId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    public ViaPasViajes getById(Integer perId, Integer viaId) {
        try {
            return (ViaPasViajes) em.createQuery("SELECT pv from ViaPasViajes pv WHERE pv.viaPasViajesPK.perId = :perId AND pv.viaPasViajesPK.viaId = :viaId").setParameter("perId", perId).setParameter("viaId", viaId).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ViaPasViajes update(ViaPasViajes object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualizan el registro de pasajero con id:"+object.getViaPasViajesPK().getPerId()+" del viaje con id:"+object.getViaPasViajesPK().getViaId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaPasViajes object) {
        try {
            int perId = object.getViaPasViajesPK().getPerId();
            int viaId = object.getViaPasViajesPK().getViaId();
            em.remove(em.find(ViaPasViajes.class, object));
            logger.info("Se elimina la persona con id:"+perId+" del viaje con id:"+viaId);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ViaPasViajes> getAll() {
        try {
            return em.createQuery("SELECT pv from ViaPasViajes pv").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public ViaPasViajes getById(Integer id) {
        throw new UnsupportedOperationException("ERROR. Metodo no soportado"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
