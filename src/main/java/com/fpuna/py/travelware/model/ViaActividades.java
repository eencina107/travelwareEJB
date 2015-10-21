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
@Table(name = "VIA_ACTIVIDADES")
@NamedQueries({
    @NamedQuery(name = "ViaActividades.findAll", query = "SELECT v FROM ViaActividades v"),
    @NamedQuery(name = "ViaActividades.findByViaId", query = "SELECT v FROM ViaActividades v WHERE v.viaActividadesPK.viaId = :viaId"),
    @NamedQuery(name = "ViaActividades.findByActOrd", query = "SELECT v FROM ViaActividades v WHERE v.viaActividadesPK.actOrd = :actOrd"),
    @NamedQuery(name = "ViaActividades.findByActFecha", query = "SELECT v FROM ViaActividades v WHERE v.actFecha = :actFecha"),
    @NamedQuery(name = "ViaActividades.findByActDet", query = "SELECT v FROM ViaActividades v WHERE v.actDet = :actDet"),
    @NamedQuery(name = "ViaActividades.findByActUsuIns", query = "SELECT v FROM ViaActividades v WHERE v.actUsuIns = :actUsuIns"),
    @NamedQuery(name = "ViaActividades.findByActFecIns", query = "SELECT v FROM ViaActividades v WHERE v.actFecIns = :actFecIns"),
    @NamedQuery(name = "ViaActividades.findByActUsuMod", query = "SELECT v FROM ViaActividades v WHERE v.actUsuMod = :actUsuMod"),
    @NamedQuery(name = "ViaActividades.findByActFecMod", query = "SELECT v FROM ViaActividades v WHERE v.actFecMod = :actFecMod")})
public class ViaActividades implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ViaActividadesPK viaActividadesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_FECHA")
    @Temporal(TemporalType.DATE)
    private Date actFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ACT_DET")
    private String actDet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ACT_USU_INS")
    private String actUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_FEC_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFecIns;
    @Size(max = 10)
    @Column(name = "ACT_USU_MOD")
    private String actUsuMod;
    @Column(name = "ACT_FEC_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFecMod;
    @JoinColumn(name = "VIA_ID", referencedColumnName = "VIA_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ViaViajes viaViajes;
    @JoinColumns({
        @JoinColumn(name = "CIU_ID", referencedColumnName = "CIU_ID"),
        @JoinColumn(name = "PAI_ID", referencedColumnName = "PAI_ID")})
    @ManyToOne
    private PgeCiudades pgeCiudades;

    public ViaActividades() {
    }

    public ViaActividades(ViaActividadesPK viaActividadesPK) {
        this.viaActividadesPK = viaActividadesPK;
    }

    public ViaActividades(ViaActividadesPK viaActividadesPK, Date actFecha, String actDet, String actUsuIns, Date actFecIns) {
        this.viaActividadesPK = viaActividadesPK;
        this.actFecha = actFecha;
        this.actDet = actDet;
        this.actUsuIns = actUsuIns;
        this.actFecIns = actFecIns;
    }

    public ViaActividades(int viaId, int actOrd) {
        this.viaActividadesPK = new ViaActividadesPK(viaId, actOrd);
    }

    public ViaActividadesPK getViaActividadesPK() {
        return viaActividadesPK;
    }

    public void setViaActividadesPK(ViaActividadesPK viaActividadesPK) {
        this.viaActividadesPK = viaActividadesPK;
    }

    public Date getActFecha() {
        return actFecha;
    }

    public void setActFecha(Date actFecha) {
        this.actFecha = actFecha;
    }

    public String getActDet() {
        return actDet;
    }

    public void setActDet(String actDet) {
        this.actDet = actDet;
    }

    public String getActUsuIns() {
        return actUsuIns;
    }

    public void setActUsuIns(String actUsuIns) {
        this.actUsuIns = actUsuIns;
    }

    public Date getActFecIns() {
        return actFecIns;
    }

    public void setActFecIns(Date actFecIns) {
        this.actFecIns = actFecIns;
    }

    public String getActUsuMod() {
        return actUsuMod;
    }

    public void setActUsuMod(String actUsuMod) {
        this.actUsuMod = actUsuMod;
    }

    public Date getActFecMod() {
        return actFecMod;
    }

    public void setActFecMod(Date actFecMod) {
        this.actFecMod = actFecMod;
    }

    public ViaViajes getViaViajes() {
        return viaViajes;
    }

    public void setViaViajes(ViaViajes viaViajes) {
        this.viaViajes = viaViajes;
    }

    public PgeCiudades getPgeCiudades() {
        return pgeCiudades;
    }

    public void setPgeCiudades(PgeCiudades pgeCiudades) {
        this.pgeCiudades = pgeCiudades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viaActividadesPK != null ? viaActividadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaActividades)) {
            return false;
        }
        ViaActividades other = (ViaActividades) object;
        if ((this.viaActividadesPK == null && other.viaActividadesPK != null) || (this.viaActividadesPK != null && !this.viaActividadesPK.equals(other.viaActividadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.ViaActividades[ viaActividadesPK=" + viaActividadesPK + " ]";
    }
    
}
