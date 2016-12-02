/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.CobroDao;
import com.fpuna.py.travelware.model.PagCobros;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eencina
 */
@Stateless
public class CobroImpl implements CobroDao{
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PagCobros create(PagCobros object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el cobro con id:"+object.getCobId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: create "+e);
            return null;
        }
    }

    @Override
    public PagCobros getById(Integer id) {
        try {
            return em.find(PagCobros.class, id);
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: getById "+e);
            return null;
        }
    }

    @Override
    public PagCobros update(PagCobros object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza o guarda el gasto con id:"+object.getCobId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+ this.getClass().getName()+" METHOD: update "+e);
            return null;
        }
    }

    @Override
    public boolean delete(PagCobros object) {
        try {
            int id=object.getCobId();
            object.setCobAnulado('S');
            em.merge(object);
            em.flush();
            System.out.println("Se anula el cobro con id:"+object.getCobId());
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: delete "+e);
            return false;
        }
    }

    @Override
    public List<PagCobros> getAll() {
        try {
            return em.createQuery("SELECT c FROM PagCobros c WHERE c.cobAnulado<>\'S\'").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getAll "+e);
            return null;
        }
    }
    
}
