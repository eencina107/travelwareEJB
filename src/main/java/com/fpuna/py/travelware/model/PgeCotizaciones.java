/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "PGE_COTIZACIONES")
@NamedQueries({
    @NamedQuery(name = "PgeCotizaciones.findAll", query = "SELECT p FROM PgeCotizaciones p"),
    @NamedQuery(name = "PgeCotizaciones.findByMonId", query = "SELECT p FROM PgeCotizaciones p WHERE p.pgeCotizacionesPK.monId = :monId"),
    @NamedQuery(name = "PgeCotizaciones.findByCotValCompra", query = "SELECT p FROM PgeCotizaciones p WHERE p.cotValCompra = :cotValCompra"),
    @NamedQuery(name = "PgeCotizaciones.findByCotValVenta", query = "SELECT p FROM PgeCotizaciones p WHERE p.cotValVenta = :cotValVenta"),
    @NamedQuery(name = "PgeCotizaciones.findByCotFecha", query = "SELECT p FROM PgeCotizaciones p WHERE p.pgeCotizacionesPK.cotFecha = :cotFecha"),
    @NamedQuery(name = "PgeCotizaciones.findByCotUsuIns", query = "SELECT p FROM PgeCotizaciones p WHERE p.cotUsuIns = :cotUsuIns"),
    @NamedQuery(name = "PgeCotizaciones.findByCotFecIns", query = "SELECT p FROM PgeCotizaciones p WHERE p.cotFecIns = :cotFecIns"),
    @NamedQuery(name = "PgeCotizaciones.findByCotUsuMod", query = "SELECT p FROM PgeCotizaciones p WHERE p.cotUsuMod = :cotUsuMod"),
    @NamedQuery(name = "PgeCotizaciones.findByCotFecMod", query = "SELECT p FROM PgeCotizaciones p WHERE p.cotFecMod = :cotFecMod")})
public class PgeCotizaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PgeCotizacionesPK pgeCotizacionesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "COT_VAL_COMPRA")
    private BigDecimal cotValCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COT_VAL_VENTA")
    private BigDecimal cotValVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COT_USU_INS")
    private String cotUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COT_FEC_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cotFecIns;
    @Size(max = 10)
    @Column(name = "COT_USU_MOD")
    private String cotUsuMod;
    @Column(name = "COT_FEC_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cotFecMod;
    @JoinColumn(name = "MON_ID", referencedColumnName = "MON_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PgeMonedas pgeMonedas;

    public PgeCotizaciones() {
    }

    public PgeCotizaciones(PgeCotizacionesPK pgeCotizacionesPK) {
        this.pgeCotizacionesPK = pgeCotizacionesPK;
    }

    public PgeCotizaciones(PgeCotizacionesPK pgeCotizacionesPK, BigDecimal cotValCompra, BigDecimal cotValVenta, String cotUsuIns, Date cotFecIns) {
        this.pgeCotizacionesPK = pgeCotizacionesPK;
        this.cotValCompra = cotValCompra;
        this.cotValVenta = cotValVenta;
        this.cotUsuIns = cotUsuIns;
        this.cotFecIns = cotFecIns;
    }

    public PgeCotizaciones(int monId, Date cotFecha) {
        this.pgeCotizacionesPK = new PgeCotizacionesPK(monId, cotFecha);
    }

    public PgeCotizacionesPK getPgeCotizacionesPK() {
        return pgeCotizacionesPK;
    }

    public void setPgeCotizacionesPK(PgeCotizacionesPK pgeCotizacionesPK) {
        this.pgeCotizacionesPK = pgeCotizacionesPK;
    }

    public BigDecimal getCotValCompra() {
        return cotValCompra;
    }

    public void setCotValCompra(BigDecimal cotValCompra) {
        this.cotValCompra = cotValCompra;
    }

    public BigDecimal getCotValVenta() {
        return cotValVenta;
    }

    public void setCotValVenta(BigDecimal cotValVenta) {
        this.cotValVenta = cotValVenta;
    }

    public String getCotUsuIns() {
        return cotUsuIns;
    }

    public void setCotUsuIns(String cotUsuIns) {
        this.cotUsuIns = cotUsuIns;
    }

    public Date getCotFecIns() {
        return cotFecIns;
    }

    public void setCotFecIns(Date cotFecIns) {
        this.cotFecIns = cotFecIns;
    }

    public String getCotUsuMod() {
        return cotUsuMod;
    }

    public void setCotUsuMod(String cotUsuMod) {
        this.cotUsuMod = cotUsuMod;
    }

    public Date getCotFecMod() {
        return cotFecMod;
    }

    public void setCotFecMod(Date cotFecMod) {
        this.cotFecMod = cotFecMod;
    }

    public PgeMonedas getPgeMonedas() {
        return pgeMonedas;
    }

    public void setPgeMonedas(PgeMonedas pgeMonedas) {
        this.pgeMonedas = pgeMonedas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgeCotizacionesPK != null ? pgeCotizacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeCotizaciones)) {
            return false;
        }
        PgeCotizaciones other = (PgeCotizaciones) object;
        if ((this.pgeCotizacionesPK == null && other.pgeCotizacionesPK != null) || (this.pgeCotizacionesPK != null && !this.pgeCotizacionesPK.equals(other.pgeCotizacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.PgeCotizaciones[ pgeCotizacionesPK=" + pgeCotizacionesPK + " ]";
    }
    
}
