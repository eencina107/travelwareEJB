/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "VIA_PAS_VIAJES")
@NamedQueries({
    @NamedQuery(name = "ViaPasViajes.findAll", query = "SELECT v FROM ViaPasViajes v"),
    @NamedQuery(name = "ViaPasViajes.findByViaId", query = "SELECT v FROM ViaPasViajes v WHERE v.viaPasViajesPK.viaId = :viaId"),
    @NamedQuery(name = "ViaPasViajes.findByPerId", query = "SELECT v FROM ViaPasViajes v WHERE v.viaPasViajesPK.perId = :perId"),
    @NamedQuery(name = "ViaPasViajes.findByPviRel", query = "SELECT v FROM ViaPasViajes v WHERE v.pviRel = :pviRel"),
    @NamedQuery(name = "ViaPasViajes.findByPviUsuIns", query = "SELECT v FROM ViaPasViajes v WHERE v.pviUsuIns = :pviUsuIns"),
    @NamedQuery(name = "ViaPasViajes.findByPviFecIns", query = "SELECT v FROM ViaPasViajes v WHERE v.pviFecIns = :pviFecIns"),
    @NamedQuery(name = "ViaPasViajes.findByPviUsuMod", query = "SELECT v FROM ViaPasViajes v WHERE v.pviUsuMod = :pviUsuMod"),
    @NamedQuery(name = "ViaPasViajes.findByPviFecMod", query = "SELECT v FROM ViaPasViajes v WHERE v.pviFecMod = :pviFecMod")})
public class ViaPasViajes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ViaPasViajesPK viaPasViajesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PVI_REL")
    private Character pviRel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PVI_USU_INS")
    private String pviUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PVI_FEC_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pviFecIns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PVI_USU_MOD")
    private String pviUsuMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PVI_FEC_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pviFecMod;
    @JoinColumn(name = "VIA_ID", referencedColumnName = "VIA_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ViaViajes viaViajes;
    @JoinColumns({
        @JoinColumn(name = "VIA_ID", referencedColumnName = "VIA_ID", insertable = false, updatable = false),
        @JoinColumn(name = "PRE_ID", referencedColumnName = "PRE_ID"),
        @JoinColumn(name = "MON_ID", referencedColumnName = "MON_ID")})
    @ManyToOne(optional = false)
    private ViaPreViajes viaPreViajes;
    @JoinColumn(name = "PVI_PAS_ID", referencedColumnName = "PER_ID")
    @ManyToOne(optional = false)
    private ViaPasajeros pviPasId;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ViaPasajeros viaPasajeros;

    public ViaPasViajes() {
    }

    public ViaPasViajes(ViaPasViajesPK viaPasViajesPK) {
        this.viaPasViajesPK = viaPasViajesPK;
    }

    public ViaPasViajes(ViaPasViajesPK viaPasViajesPK, Character pviRel, String pviUsuIns, Date pviFecIns, String pviUsuMod, Date pviFecMod) {
        this.viaPasViajesPK = viaPasViajesPK;
        this.pviRel = pviRel;
        this.pviUsuIns = pviUsuIns;
        this.pviFecIns = pviFecIns;
        this.pviUsuMod = pviUsuMod;
        this.pviFecMod = pviFecMod;
    }

    public ViaPasViajes(int viaId, int perId) {
        this.viaPasViajesPK = new ViaPasViajesPK(viaId, perId);
    }

    public ViaPasViajesPK getViaPasViajesPK() {
        return viaPasViajesPK;
    }

    public void setViaPasViajesPK(ViaPasViajesPK viaPasViajesPK) {
        this.viaPasViajesPK = viaPasViajesPK;
    }

    public Character getPviRel() {
        return pviRel;
    }

    public void setPviRel(Character pviRel) {
        this.pviRel = pviRel;
    }

    public String getPviUsuIns() {
        return pviUsuIns;
    }

    public void setPviUsuIns(String pviUsuIns) {
        this.pviUsuIns = pviUsuIns;
    }

    public Date getPviFecIns() {
        return pviFecIns;
    }

    public void setPviFecIns(Date pviFecIns) {
        this.pviFecIns = pviFecIns;
    }

    public String getPviUsuMod() {
        return pviUsuMod;
    }

    public void setPviUsuMod(String pviUsuMod) {
        this.pviUsuMod = pviUsuMod;
    }

    public Date getPviFecMod() {
        return pviFecMod;
    }

    public void setPviFecMod(Date pviFecMod) {
        this.pviFecMod = pviFecMod;
    }

    public ViaViajes getViaViajes() {
        return viaViajes;
    }

    public void setViaViajes(ViaViajes viaViajes) {
        this.viaViajes = viaViajes;
    }

    public ViaPreViajes getViaPreViajes() {
        return viaPreViajes;
    }

    public void setViaPreViajes(ViaPreViajes viaPreViajes) {
        this.viaPreViajes = viaPreViajes;
    }

    public ViaPasajeros getPviPasId() {
        return pviPasId;
    }

    public void setPviPasId(ViaPasajeros pviPasId) {
        this.pviPasId = pviPasId;
    }

    public ViaPasajeros getViaPasajeros() {
        return viaPasajeros;
    }

    public void setViaPasajeros(ViaPasajeros viaPasajeros) {
        this.viaPasajeros = viaPasajeros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viaPasViajesPK != null ? viaPasViajesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPasViajes)) {
            return false;
        }
        ViaPasViajes other = (ViaPasViajes) object;
        if ((this.viaPasViajesPK == null && other.viaPasViajesPK != null) || (this.viaPasViajesPK != null && !this.viaPasViajesPK.equals(other.viaPasViajesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.ViaPasViajes[ viaPasViajesPK=" + viaPasViajesPK + " ]";
    }
    
}
