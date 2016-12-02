/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.DatosGeneralesDao;
import com.fpuna.py.travelware.model.PgeDatosGenerales;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eencina
 */
@Stateless
public class DatosGeneralesImpl implements DatosGeneralesDao{
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeDatosGenerales create(PgeDatosGenerales object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se insertan Datos Generales");
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: create "+ e);
            return null;
        }
    }

    @Override
    public PgeDatosGenerales getById(Integer id) {
        try {
            return em.find(PgeDatosGenerales.class, id);
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getById "+ e);
            return null;
        }
    }

    @Override
    public PgeDatosGenerales update(PgeDatosGenerales object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualizan datos generales");
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: update "+ e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeDatosGenerales object) {
        try {
            int id= object.getGralId();
            em.remove(em.find(PgeDatosGenerales.class, id));
            em.flush();
            return true;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: delete "+ e);
            return false;
        }
    }

    @Override
    public List<PgeDatosGenerales> getAll() {
        try {
            return em.createQuery("SELECT p from PgeDatosGenerales p").getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll "+ e);
            return null;
        }
    }
    
}
