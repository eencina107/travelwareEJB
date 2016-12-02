/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ComprobanteDao;
import com.fpuna.py.travelware.model.PagComprobantes;
import java.math.BigDecimal;
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
public class ComprobanteImpl implements ComprobanteDao{
    final static Logger logger = Logger.getLogger(ComprobanteImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PagComprobantes create(PagComprobantes object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el documento de tipo:"+object.getComTipDoc()+" con el concepto:"+object.getComConc()+" con el numero:"+object.getComNumDoc());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PagComprobantes getById(Integer id) {
        try {
            return em.find(PagComprobantes.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PagComprobantes update(PagComprobantes object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el documento con id: "+object.getComIdTran());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PagComprobantes object) {
        try {
            int id = object.getComIdTran();
            em.remove(em.find(PagComprobantes.class, id));
            em.flush();
            logger.info("Se elimina la transaccion con id: "+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PagComprobantes> getAll() {
        try {
            return em.createQuery("select c from PagComprobantes c").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public PagComprobantes getByNroDoc(Integer nroDoc, String conc) {
        try {
            return (PagComprobantes) em.createQuery("SELECT c from PagComprobantes c WHERE c.comConc=:conc AND c.comNumDoc=:numDoc").setParameter("conc", conc).setParameter("numDoc", nroDoc.toString()).getSingleResult();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll "+ e);
            return null;
        }
    }

    @Override
    public BigDecimal getLastCotizacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getLastNroDoc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
