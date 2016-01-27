/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PasajeroDao;
import com.fpuna.py.travelware.model.ViaPasajeros;
import com.fpuna.py.travelware.model.ViaViajes;
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
public class PasajeroImpl implements PasajeroDao{
    final static Logger logger = Logger.getLogger(PasajeroImpl.class);

    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaPasajeros create(ViaPasajeros object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el pasajero con id:"+object.getPerId());
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: create "+ e);
            return null;
        }
    }

    @Override
    public ViaPasajeros getById(Integer id) {
        try {
            return em.find(ViaPasajeros.class, id);
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getById "+ e);
            return null;
        }
    }

    @Override
    public ViaPasajeros update(ViaPasajeros object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza el pasajero con id:"+object.getPerId());
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: update "+ e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaPasajeros object) {
        try {
            int id = object.getPerId().getPerId();
            em.remove(em.find(ViaPasajeros.class, id));
            em.flush();
            System.out.println("Se elimina el pasajero con id:"+id);
            return true;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: delete "+ e);
            return false;
        }
    }

    @Override
    public List<ViaPasajeros> getAll() {
        try {
            return em.createQuery("select p from ViaPasajeros p").getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll(viajeSelected) "+ e);
            return null;
        }
    }

    @Override
    public List<ViaPasajeros> getAll(ViaViajes viajeSelected) {
        try {
            return em.createQuery("select p from ViaPasajeros p WHERE p.viaId=:viaId").setParameter("viaId", viajeSelected).getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll(viajeSelected) "+ e);
            return null;
        }
    }
    
}
