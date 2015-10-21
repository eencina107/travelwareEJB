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
@Table(name = "VIA_FIDELIDADES")
@NamedQueries({
    @NamedQuery(name = "ViaFidelidades.findAll", query = "SELECT v FROM ViaFidelidades v"),
    @NamedQuery(name = "ViaFidelidades.findByPerId", query = "SELECT v FROM ViaFidelidades v WHERE v.viaFidelidadesPK.perId = :perId"),
    @NamedQuery(name = "ViaFidelidades.findByOrgId", query = "SELECT v FROM ViaFidelidades v WHERE v.viaFidelidadesPK.orgId = :orgId"),
    @NamedQuery(name = "ViaFidelidades.findByFidUsuIns", query = "SELECT v FROM ViaFidelidades v WHERE v.fidUsuIns = :fidUsuIns"),
    @NamedQuery(name = "ViaFidelidades.findByFidFecIns", query = "SELECT v FROM ViaFidelidades v WHERE v.fidFecIns = :fidFecIns"),
    @NamedQuery(name = "ViaFidelidades.findByFidUsuMod", query = "SELECT v FROM ViaFidelidades v WHERE v.fidUsuMod = :fidUsuMod"),
    @NamedQuery(name = "ViaFidelidades.findByFidFecMod", query = "SELECT v FROM ViaFidelidades v WHERE v.fidFecMod = :fidFecMod")})
    @NamedQuery(name = "ViaFidelidades.findById", query = "SELECT v FROM ViaFidelidades v WHERE v.viaFidelidadesPK.perId = :perId and v.viaFidelidadesPK.orgId = :orgId")
public class ViaFidelidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ViaFidelidadesPK viaFidelidadesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FID_USU_INS")
    private String fidUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FID_FEC_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fidFecIns;
    @Size(max = 10)
    @Column(name = "FID_USU_MOD")
    private String fidUsuMod;
    @Column(name = "FID_FEC_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fidFecMod;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PgePersonas pgePersonas;
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ORG_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PgeOrganizaciones pgeOrganizaciones;

    public ViaFidelidades() {
    }

    public ViaFidelidades(ViaFidelidadesPK viaFidelidadesPK) {
        this.viaFidelidadesPK = viaFidelidadesPK;
    }

    public ViaFidelidades(ViaFidelidadesPK viaFidelidadesPK, String fidUsuIns, Date fidFecIns) {
        this.viaFidelidadesPK = viaFidelidadesPK;
        this.fidUsuIns = fidUsuIns;
        this.fidFecIns = fidFecIns;
    }

    public ViaFidelidades(int perId, int orgId) {
        this.viaFidelidadesPK = new ViaFidelidadesPK(perId, orgId);
    }

    public ViaFidelidadesPK getViaFidelidadesPK() {
        return viaFidelidadesPK;
    }

    public void setViaFidelidadesPK(ViaFidelidadesPK viaFidelidadesPK) {
        this.viaFidelidadesPK = viaFidelidadesPK;
    }

    public String getFidUsuIns() {
        return fidUsuIns;
    }

    public void setFidUsuIns(String fidUsuIns) {
        this.fidUsuIns = fidUsuIns;
    }

    public Date getFidFecIns() {
        return fidFecIns;
    }

    public void setFidFecIns(Date fidFecIns) {
        this.fidFecIns = fidFecIns;
    }

    public String getFidUsuMod() {
        return fidUsuMod;
    }

    public void setFidUsuMod(String fidUsuMod) {
        this.fidUsuMod = fidUsuMod;
    }

    public Date getFidFecMod() {
        return fidFecMod;
    }

    public void setFidFecMod(Date fidFecMod) {
        this.fidFecMod = fidFecMod;
    }

    public PgePersonas getPgePersonas() {
        return pgePersonas;
    }

    public void setPgePersonas(PgePersonas pgePersonas) {
        this.pgePersonas = pgePersonas;
    }

    public PgeOrganizaciones getPgeOrganizaciones() {
        return pgeOrganizaciones;
    }

    public void setPgeOrganizaciones(PgeOrganizaciones pgeOrganizaciones) {
        this.pgeOrganizaciones = pgeOrganizaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viaFidelidadesPK != null ? viaFidelidadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaFidelidades)) {
            return false;
        }
        ViaFidelidades other = (ViaFidelidades) object;
        if ((this.viaFidelidadesPK == null && other.viaFidelidadesPK != null) || (this.viaFidelidadesPK != null && !this.viaFidelidadesPK.equals(other.viaFidelidadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.ViaFidelidades[ viaFidelidadesPK=" + viaFidelidadesPK + " ]";
    }
    
}
