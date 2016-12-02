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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "via_actividades", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"via_id", "act_ord"})})
@NamedQueries({
    @NamedQuery(name = "ViaActividades.findAll", query = "SELECT v FROM ViaActividades v"),
    @NamedQuery(name = "ViaActividades.findByActOrd", query = "SELECT v FROM ViaActividades v WHERE v.actOrd = :actOrd"),
    @NamedQuery(name = "ViaActividades.findByActFecha", query = "SELECT v FROM ViaActividades v WHERE v.actFecha = :actFecha"),
    @NamedQuery(name = "ViaActividades.findByActDet", query = "SELECT v FROM ViaActividades v WHERE v.actDet = :actDet"),
    @NamedQuery(name = "ViaActividades.findByActUsuIns", query = "SELECT v FROM ViaActividades v WHERE v.actUsuIns = :actUsuIns"),
    @NamedQuery(name = "ViaActividades.findByActFecIns", query = "SELECT v FROM ViaActividades v WHERE v.actFecIns = :actFecIns"),
    @NamedQuery(name = "ViaActividades.findByActUsuMod", query = "SELECT v FROM ViaActividades v WHERE v.actUsuMod = :actUsuMod"),
    @NamedQuery(name = "ViaActividades.findByActFecMod", query = "SELECT v FROM ViaActividades v WHERE v.actFecMod = :actFecMod"),
    @NamedQuery(name = "ViaActividades.findByActId", query = "SELECT v FROM ViaActividades v WHERE v.actId = :actId")})
public class ViaActividades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "act_ord", nullable = false)
    private int actOrd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "act_fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date actFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "act_det", nullable = false, length = 2147483647)
    private String actDet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "act_usu_ins", nullable = false, length = 10)
    private String actUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "act_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFecIns;
    @Size(max = 10)
    @Column(name = "act_usu_mod", length = 10)
    private String actUsuMod;
    @Column(name = "act_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFecMod;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "act_id", nullable = false)
    private Integer actId;
    @JoinColumn(name = "via_id", referencedColumnName = "via_id", nullable = false)
    @ManyToOne(optional = false)
    private ViaViajes viaId;
    @JoinColumn(name = "ciu_id", referencedColumnName = "ciu_id")
    @ManyToOne
    private PgeCiudades ciuId;

    public ViaActividades() {
    }

    public ViaActividades(Integer actId) {
        this.actId = actId;
    }

    public ViaActividades(Integer actId, int actOrd, Date actFecha, String actDet, String actUsuIns, Date actFecIns) {
        this.actId = actId;
        this.actOrd = actOrd;
        this.actFecha = actFecha;
        this.actDet = actDet;
        this.actUsuIns = actUsuIns;
        this.actFecIns = actFecIns;
    }

    public int getActOrd() {
        return actOrd;
    }

    public void setActOrd(int actOrd) {
        this.actOrd = actOrd;
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

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public ViaViajes getViaId() {
        return viaId;
    }

    public void setViaId(ViaViajes viaId) {
        this.viaId = viaId;
    }

    public PgeCiudades getCiuId() {
        return ciuId;
    }

    public void setCiuId(PgeCiudades ciuId) {
        this.ciuId = ciuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaActividades)) {
            return false;
        }
        ViaActividades other = (ViaActividades) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaActividades[ actId=" + actId + " ]";
    }
    
}
