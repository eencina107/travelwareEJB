/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PagoDao;
import com.fpuna.py.travelware.model.ComFacturas;
import com.fpuna.py.travelware.model.ComPagos;
import com.fpuna.py.travelware.utils.NumeroLetrasConverter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author damia_000
 */
@Stateless
public class PagoImpl implements PagoDao {

    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;
    private final NumeroLetrasConverter nlConv;

    public PagoImpl() {
        this.nlConv = new NumeroLetrasConverter();
    }

    @Override
    public ComPagos create(ComPagos object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el pago con id:" + object.getPgoId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:" + this.getClass().getName() + " METHOD: create " + e);
            return null;
        }
    }

    @Override
    public ComPagos getById(Integer id) {
        try {
            return em.find(ComPagos.class, id);
        } catch (Exception e) {
            System.out.println("ERROR:" + this.getClass().getName() + " METHOD: getById " + e);
            return null;
        }
    }

    @Override
    public ComPagos update(ComPagos object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza o guarda el pago con id:" + object.getPgoId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:" + this.getClass().getName() + " METHOD: update " + e);
            return null;
        }
    }

    @Override
    public boolean delete(ComPagos object) {
        try {
            int id = object.getPgoId();
            object.setPgoAnulado('S');
            em.merge(object);
            em.flush();
            System.out.println("Se anula el pago con id:" + object.getPgoId());
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + this.getClass().getName() + " METHOD: delete " + e);
            return false;
        }
    }

    @Override
    public List<ComPagos> getAll() {
        try {
            return em.createQuery("SELECT p FROM ComPagos p WHERE p.pgoAnulado<>\'S\'").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: " + this.getClass().getName() + " METHOD: getAll " + e);
            return null;
        }
    }

    @Override
    public void agregarCuotasFactura(ComFacturas fact) {
        ComPagos pag;
        try {
            for (int i = 0; i < fact.getFacCanCuo(); i++) {
                pag = new ComPagos();
                pag.setMonId(fact.getMonId());
                pag.setPgoCambio(fact.getFacCambio());
                pag.setPgoCuotaNro(i + 1);
                pag.setPgoEstado(false);
                pag.setPgoFecIns(new Date());
                pag.setPgoAnulado('N');
                if (fact.getFacCond().equals('C') || pag.getPgoCuotaNro()==fact.getFacCanCuo()){
                    pag.setPgoTipo("CAN");
                } else {
                    pag.setPgoTipo("CTA");
                }
                pag.setFacId(fact);
                pag.setPgoMonto(fact.getFacTotal().divide(BigDecimal.valueOf(fact.getFacCanCuo().doubleValue())));
                pag.setPgoMontoLetras(nlConv.Convertir(fact.getFacTotal().toPlainString(), true));
                pag.setPgoUsuIns(fact.getFacUsuIns());

                em.persist(pag);
                em.flush();

                System.out.println("Se agrego el pago " + pag.getPgoId() + " de la factura con id " + fact.getFacId());
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + this.getClass().getName() + " METHOD: agregarCuotasFacturas " + e);

        }
    }

    @Override
    public ComPagos getCuotaAPagar(ComFacturas fact) {
        try {
            ArrayList<ComPagos> list = new ArrayList<>();
            list.addAll(em.createQuery("SELECT p from ComPagos p WHERE p.facId = :fact AND p.pgoEstado = false order by p.pgoCuotaNro ASC").setParameter("fact", fact).getResultList());
            ComPagos cp= list.get(0);
            return cp;
        } catch (Exception e) {
            System.out.println("ERROR: " + this.getClass().getName() + " METHOD: getCuotaAPagar " + e);
            return null;
        }
    }

}


