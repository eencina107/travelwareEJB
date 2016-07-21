/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PagoDao;
import com.fpuna.py.travelware.model.ComPagos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author damia_000
 */
@Stateless
public class PagoImpl implements PagoDao{
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ComPagos create(ComPagos object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el pago con id:"+object.getPgoId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: create "+e);
            return null;
        }
    }

    @Override
    public ComPagos getById(Integer id) {
        try {
            return em.find(ComPagos.class, id);
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: getById "+e);
            return null;
        }
    }

    @Override
    public ComPagos update(ComPagos object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza o guarda el pago con id:"+object.getPgoId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+ this.getClass().getName()+" METHOD: update "+e);
            return null;
        }
    }

    @Override
    public boolean delete(ComPagos object) {
        try {
            int id=object.getPgoId();
            object.setPgoAnulado('S');
            em.merge(object);
            em.flush();
            System.out.println("Se anula el pago con id:"+object.getPgoId());
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: delete "+e);
            return false;
        }
    }

    @Override
    public List<ComPagos> getAll() {
        try {
            return em.createQuery("SELECT p FROM ComPagos p WHERE p.pgoAnulado<>\'S\'").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getAll "+e);
            return null;
        }
    }
    
}
