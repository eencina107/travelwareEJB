/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.FidelidadDao;
import com.fpuna.py.travelware.model.ViaFidelidades;
import com.fpuna.py.travelware.model.ViaFidelidadesPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class FidelidadImpl implements FidelidadDao{
    final static Logger logger = Logger.getLogger(FidelidadImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaFidelidades create(ViaFidelidades object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta la fidelidad de la persona con id:"+object.getViaFidelidadesPK().getPerId()+" con la empresa con id:"+object.getViaFidelidadesPK().getOrgId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    public ViaFidelidades getById(Integer perId, Integer orgId) {
        try {
            return (ViaFidelidades) em.createQuery("Select f from ViaFidelidades f where f.viaFidelidadesPK.orgId = :orgId AND f.ViaFidelidadesPK.perId= :perId").setParameter("orgId", orgId).setParameter("perId", perId).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ViaFidelidades update(ViaFidelidades object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza la fidelidad de la persona con id:"+object.getViaFidelidadesPK().getPerId()+"con la empresa con id:"+object.getViaFidelidadesPK().getOrgId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaFidelidades object) {
        try {
            int perId = object.getViaFidelidadesPK().getPerId();
            int orgId = object.getViaFidelidadesPK().getOrgId();
            em.remove(em.find(ViaFidelidades.class, object));
            em.flush();
            logger.info("Se elimina la fidelidad de la persona con id:"+perId+" con la org con id:"+orgId);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ViaFidelidades> getAll() {
        try {
            return em.createQuery("select f FROM ViaFidelidades f").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public ViaFidelidades getById(Integer id) {
        throw new UnsupportedOperationException("ERROR. Operacion no soportada"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
