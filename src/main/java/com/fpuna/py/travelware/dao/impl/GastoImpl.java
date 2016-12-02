/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.GastoDao;
import com.fpuna.py.travelware.model.ViaGastos;
import com.fpuna.py.travelware.model.ViaPasajeros;
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
public class GastoImpl implements GastoDao{
    final static Logger logger = Logger.getLogger(GastoImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaGastos create(ViaGastos object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el gasto con id:"+object.getGasId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: create "+e);
            return null;
        }
    }

    @Override
    public ViaGastos getById(Integer id) {
        try {
            return em.find(ViaGastos.class, id);
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: getById "+e);
            return null;
        }
    }

    @Override
    public ViaGastos update(ViaGastos object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza el gasto con id: "+object.getGasId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: update "+e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaGastos object) {
        try {
            int id = object.getGasId();
            em.remove(em.find(ViaGastos.class, id));
            em.flush();
            System.out.println("Se elimina el gasto con id: "+id);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: delete"+e);
            return false;
        }
    }

    @Override
    public List<ViaGastos> getAll() {
        try {
            return em.createQuery("SELECT v FROM ViaGastos v").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getall "+e);
            return null;
        }
    }

    @Override
    public List<ViaGastos> getAll(ViaPasajeros pasajero) {
        try {
            return em.createQuery("SELECT v FROM ViaGastos v WHERE v.pviId=:pviId").setParameter("pviId", pasajero).getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getAll(pasajero) "+e);
            return null;
        }
    }
    
}
