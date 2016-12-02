/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author damia_000
 */
@Entity
@Table(name = "via_conceptos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViaConceptos.findAll", query = "SELECT v FROM ViaConceptos v"),
    @NamedQuery(name = "ViaConceptos.findByConId", query = "SELECT v FROM ViaConceptos v WHERE v.conId = :conId"),
    @NamedQuery(name = "ViaConceptos.findByConDesc", query = "SELECT v FROM ViaConceptos v WHERE v.conDesc = :conDesc"),
    @NamedQuery(name = "ViaConceptos.findByConEst", query = "SELECT v FROM ViaConceptos v WHERE v.conEst = :conEst"),
    @NamedQuery(name = "ViaConceptos.findByConReq", query = "SELECT v FROM ViaConceptos v WHERE v.conReq = :conReq"),
    @NamedQuery(name = "ViaConceptos.findByConUsuIns", query = "SELECT v FROM ViaConceptos v WHERE v.conUsuIns = :conUsuIns"),
    @NamedQuery(name = "ViaConceptos.findByConFecIns", query = "SELECT v FROM ViaConceptos v WHERE v.conFecIns = :conFecIns"),
    @NamedQuery(name = "ViaConceptos.findByConUsuMod", query = "SELECT v FROM ViaConceptos v WHERE v.conUsuMod = :conUsuMod"),
    @NamedQuery(name = "ViaConceptos.findByConFecMod", query = "SELECT v FROM ViaConceptos v WHERE v.conFecMod = :conFecMod")})
public class ViaConceptos implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conId")
    private Collection<ViaGastos> viaGastosCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_id")
    private Integer conId;
    @Size(max = 100)
    @Column(name = "con_desc")
    private String conDesc;
    @Column(name = "con_est")
    private Character conEst;
    @Column(name = "con_req")
    private Character conReq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "con_usu_ins")
    private String conUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "con_fec_ins")
    @Temporal(TemporalType.TIMESTAMP)
    private Date conFecIns;
    @Size(max = 10)
    @Column(name = "con_usu_mod")
    private String conUsuMod;
    @Column(name = "con_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date conFecMod;
    @OneToMany(mappedBy = "conId")
    private Collection<ComFacturasDet> comFacturasDetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conId")
    private Collection<ViaViajesDet> viaViajesDetCollection;

    public ViaConceptos() {
    }

    public ViaConceptos(Integer conId) {
        this.conId = conId;
    }

    public ViaConceptos(Integer conId, String conUsuIns, Date conFecIns) {
        this.conId = conId;
        this.conUsuIns = conUsuIns;
        this.conFecIns = conFecIns;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConDesc() {
        return conDesc;
    }

    public void setConDesc(String conDesc) {
        this.conDesc = conDesc;
    }

    public Character getConEst() {
        return conEst;
    }

    public void setConEst(Character conEst) {
        this.conEst = conEst;
    }

    public Character getConReq() {
        return conReq;
    }

    public void setConReq(Character conReq) {
        this.conReq = conReq;
    }

    public String getConUsuIns() {
        return conUsuIns;
    }

    public void setConUsuIns(String conUsuIns) {
        this.conUsuIns = conUsuIns;
    }

    public Date getConFecIns() {
        return conFecIns;
    }

    public void setConFecIns(Date conFecIns) {
        this.conFecIns = conFecIns;
    }

    public String getConUsuMod() {
        return conUsuMod;
    }

    public void setConUsuMod(String conUsuMod) {
        this.conUsuMod = conUsuMod;
    }

    public Date getConFecMod() {
        return conFecMod;
    }

    public void setConFecMod(Date conFecMod) {
        this.conFecMod = conFecMod;
    }

    @XmlTransient
    public Collection<ComFacturasDet> getComFacturasDetCollection() {
        return comFacturasDetCollection;
    }

    public void setComFacturasDetCollection(Collection<ComFacturasDet> comFacturasDetCollection) {
        this.comFacturasDetCollection = comFacturasDetCollection;
    }

    @XmlTransient
    public Collection<ViaViajesDet> getViaViajesDetCollection() {
        return viaViajesDetCollection;
    }

    public void setViaViajesDetCollection(Collection<ViaViajesDet> viaViajesDetCollection) {
        this.viaViajesDetCollection = viaViajesDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaConceptos)) {
            return false;
        }
        ViaConceptos other = (ViaConceptos) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaConceptos[ conId=" + conId + " ]";
    }

    @XmlTransient
    public Collection<ViaGastos> getViaGastosCollection() {
        return viaGastosCollection;
    }

    public void setViaGastosCollection(Collection<ViaGastos> viaGastosCollection) {
        this.viaGastosCollection = viaGastosCollection;
    }
    
}
