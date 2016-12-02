/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ComprobanteDetDao;
import com.fpuna.py.travelware.model.PagComprobantes;
import com.fpuna.py.travelware.model.PagComprobantesDet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eencina
 */
public class ComprobanteDetImpl implements ComprobanteDetDao{

    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;
    
    @Override
    public PagComprobantesDet create(PagComprobantesDet object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el detalle "+object.getCdeNroDet()
                    +" del comprobante:"+object.getComId().getComIdTran()
                    +" - Id="+object.getComDetId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: create "+e);
            return null;
        }
    }

    @Override
    public PagComprobantesDet getById(Integer id) {
        try {
            return em.find(PagComprobantesDet.class, id);
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: getById "+e);
            return null;
        }
    }

    @Override
    public PagComprobantesDet update(PagComprobantesDet object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza el detalle "+object.getCdeNroDet()+" del comprobante con id:" +object.getComId()+" - Id="+object.getComDetId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: update "+e);
            return null;
        }
    }

    @Override
    public boolean delete(PagComprobantesDet object) {
        try {
            int id=object.getComDetId();
            em.remove(em.find(PagComprobantesDet.class, id));
            em.flush();
            System.out.println("Se elimina el detalle de comprobante con id="+id);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: delete"+e);
            return false;
        }
    }

    @Override
    public List<PagComprobantesDet> getAll() {
       
        try {
            return em.createQuery("SELECT cd FROM PagComprobantesDet cd").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getall "+e);
            return null;
        }
    }

    @Override
    public List<PagComprobantesDet> getAll(PagComprobantes comprobante) {
        try {
            return em.createQuery("SELECT cd FROM PagComprobantesDet cd WHERE cd.comId=:comId ORDER BY cd.cdeNroDet").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getall(PagComprobantes comprobante) "+e);
            return null;
        }
    }
    
}
