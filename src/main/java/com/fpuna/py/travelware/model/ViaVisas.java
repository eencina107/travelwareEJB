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
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "via_visas", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pat_id", "vis_nro_sec"})})
@NamedQueries({
    @NamedQuery(name = "ViaVisas.findAll", query = "SELECT v FROM ViaVisas v"),
    @NamedQuery(name = "ViaVisas.findByVisId", query = "SELECT v FROM ViaVisas v WHERE v.visId = :visId"),
    @NamedQuery(name = "ViaVisas.findByVisNro", query = "SELECT v FROM ViaVisas v WHERE v.visNro = :visNro"),
    @NamedQuery(name = "ViaVisas.findByVisNroSec", query = "SELECT v FROM ViaVisas v WHERE v.visNroSec = :visNroSec"),
    @NamedQuery(name = "ViaVisas.findByVisFecVenc", query = "SELECT v FROM ViaVisas v WHERE v.visFecVenc = :visFecVenc")})
public class ViaVisas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vis_id", nullable = false)
    private Integer visId;
    @Column(name = "vis_nro")
    private Integer visNro;
    @Size(max = 50)
    @Column(name = "vis_nro_sec", length = 50)
    private String visNroSec;
    @Column(name = "vis_fec_venc")
    @Temporal(TemporalType.DATE)
    private Date visFecVenc;
    @JoinColumn(name = "pat_id", referencedColumnName = "pat_id")
    @ManyToOne
    private ViaPasaportes patId;
    @JoinColumn(name = "pai_id", referencedColumnName = "pai_id")
    @ManyToOne
    private PgePaises paiId;

    public ViaVisas() {
    }

    public ViaVisas(Integer visId) {
        this.visId = visId;
    }

    public Integer getVisId() {
        return visId;
    }

    public void setVisId(Integer visId) {
        this.visId = visId;
    }

    public Integer getVisNro() {
        return visNro;
    }

    public void setVisNro(Integer visNro) {
        this.visNro = visNro;
    }

    public String getVisNroSec() {
        return visNroSec;
    }

    public void setVisNroSec(String visNroSec) {
        this.visNroSec = visNroSec;
    }

    public Date getVisFecVenc() {
        return visFecVenc;
    }

    public void setVisFecVenc(Date visFecVenc) {
        this.visFecVenc = visFecVenc;
    }

    public ViaPasaportes getPatId() {
        return patId;
    }

    public void setPatId(ViaPasaportes patId) {
        this.patId = patId;
    }

    public PgePaises getPaiId() {
        return paiId;
    }

    public void setPaiId(PgePaises paiId) {
        this.paiId = paiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visId != null ? visId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaVisas)) {
            return false;
        }
        ViaVisas other = (ViaVisas) object;
        if ((this.visId == null && other.visId != null) || (this.visId != null && !this.visId.equals(other.visId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaVisas[ visId=" + visId + " ]";
    }
    
}
