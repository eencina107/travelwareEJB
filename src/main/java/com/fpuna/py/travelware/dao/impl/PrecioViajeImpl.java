/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PrecioViajeDao;
import com.fpuna.py.travelware.model.ViaPreViajes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class PrecioViajeImpl implements PrecioViajeDao{
    final static Logger logger = Logger.getLogger(FidelidadImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaPreViajes create(ViaPreViajes object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el precio con id:"+object.getViaPreViajesPK().getPreId()+" en la moneda con id:"+object.getViaPreViajesPK().getMonId()+" del viaje con id:"+object.getViaPreViajesPK().getViaId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    public ViaPreViajes getById(Integer preId,Integer monId,Integer viaId) {
        try {
            return (ViaPreViajes) em.createQuery("SELECT pv FROM ViaPreViajes pv WHERE pv.viaPreViajesPK.preId = :preId and PV.viaPreViajesPK.monId = :monId and pv.viaPreViajesPK.viaId = :viaId").setParameter("preId", preId).setParameter("monId", monId).setParameter("viaId", viaId).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ViaPreViajes update(ViaPreViajes object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el precio de viaje con id:"+object.getViaPreViajesPK().getPreId()+" en la moneda con id:"+object.getViaPreViajesPK().getMonId()+" del viaje con id:"+object.getViaPreViajesPK().getViaId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaPreViajes object) {
        try {
            int preId = object.getViaPreViajesPK().getPreId();
            int monId = object.getViaPreViajesPK().getMonId();
            int viaId = object.getViaPreViajesPK().getViaId();
        
            em.remove(em.find(ViaPreViajes.class, object));
            logger.info("Se elimina el precio con id:"+preId+" en la moneda con id:"+monId+" del viaje con id:"+viaId);
            return true;
        
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ViaPreViajes> getAll() {
        try {
            return em.createQuery("select pv from ViaPreViajes pv").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public ViaPreViajes getById(Integer id) {
        throw new UnsupportedOperationException("ERROR. Metodo no soportado."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
