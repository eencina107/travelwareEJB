/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PrecioViajeDao;
import com.fpuna.py.travelware.model.ViaPreViajes;
import com.fpuna.py.travelware.model.ViaViajes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eencina
 */
@Stateless
public class PrecioViajeImpl implements PrecioViajeDao{    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaPreViajes create(ViaPreViajes object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el precio con id:"+object.getPreId()+" en la moneda con id:"+object.getMonId()+" del viaje con id:"+object.getViaId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR: "+"CLASS "+this.getClass().getName()+" METHOD: create "+ e);
            return null;
        }
    }

    public ViaPreViajes getById(Integer preId,Integer monId,Integer viaId) {
        try {
            return (ViaPreViajes) em.createQuery("SELECT pv FROM ViaPreViajes pv WHERE pv.preId = :preId and PV.monId = :monId and pv.viaId = :viaId").setParameter("preId", preId).setParameter("monId", monId).setParameter("viaId", viaId).getSingleResult();
        } catch (Exception e) {
            System.out.println("ERROR: "+"CLASS "+this.getClass().getName()+" METHOD: getById "+ e);
            return null;
        }
    }

    @Override
    public ViaPreViajes update(ViaPreViajes object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza el precio de viaje con id:"+object.getPreId()+" en la moneda con id:"+object.getMonId()+" del viaje con id:"+object.getViaId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR: "+"CLASS "+this.getClass().getName()+" METHOD: update "+ e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaPreViajes object) {
        try {
            int preId = object.getPreId();
            int monId = object.getMonId().getMonId();
            int viaId = object.getViaId().getViaId();
        
            em.remove(em.find(ViaPreViajes.class, object));
            System.out.println("Se elimina el precio con id:"+preId+" en la moneda con id:"+monId+" del viaje con id:"+viaId);
            return true;
        
        } catch (Exception e) {
            System.out.println("ERROR: "+"CLASS "+this.getClass().getName()+" METHOD: delete "+ e);
            return false;
        }
    }

    @Override
    public List<ViaPreViajes> getAll() {
        try {
            return em.createQuery("select pv from ViaPreViajes pv").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: "+"CLASS "+this.getClass().getName()+" METHOD: getAll "+ e);
            return null;
        }
    }

    @Override
    public ViaPreViajes getById(Integer id) {
        throw new UnsupportedOperationException("ERROR. Metodo no soportado."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ViaPreViajes getByName(String value) {
        try {
            return (ViaPreViajes) em.createNamedQuery("ViaPreViajes.findByPreDescripcion").setParameter("preDescripcion", value).getSingleResult();
        } catch (Exception e) {
            System.out.println("ERROR: "+"CLASS "+this.getClass().getName()+" METHOD: getByName "+ e);
            return null;
        }
    }

    @Override
    public List<ViaPreViajes> getAll(ViaViajes viaje) {
        try {
            return em.createQuery("SELECT pv FROM ViaPreViajes pv WHERE pv.viaId=:viaId").setParameter("viaId", viaje).getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: "+"CLASS "+this.getClass().getName()+" METHOD: getByName "+ e);
            return null;
        }
    }
    
}
