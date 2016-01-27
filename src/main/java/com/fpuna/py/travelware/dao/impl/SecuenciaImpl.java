/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.SecuenciaDao;
import com.fpuna.py.travelware.model.PgeSecuencias;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eencina
 */
@Stateless
public class SecuenciaImpl implements SecuenciaDao{
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public Integer getSec(String clave) {
        try {
            PgeSecuencias sec = (PgeSecuencias) em.createNamedQuery("PgeSecuencias.findBySecTabla").setParameter("secTabla", clave).getSingleResult();
            return sec.getSecOrden();
        } catch (Exception e) {
            System.out.println("ERROR. CLASS: "+this.getClass().getName()+" METHOD: getSec"+e);
            return null;
        }
    }

    @Override
    public boolean actSec(String clave) {
        try {
            PgeSecuencias sec = (PgeSecuencias) em.createNamedQuery("PgeSecuencias.findBySecTabla").setParameter("secTabla", clave).getSingleResult();
            sec.setSecOrden(sec.getSecOrden()+1);
            em.merge(sec);
            em.flush();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR. CLASS: "+this.getClass().getName()+" METHOD: actSec"+e);
            return false;
        }
    }
    
}
