/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "via_pasaportes", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"per_id"})})
@NamedQueries({
    @NamedQuery(name = "ViaPasaportes.findAll", query = "SELECT v FROM ViaPasaportes v"),
    @NamedQuery(name = "ViaPasaportes.findByPatNroPas", query = "SELECT v FROM ViaPasaportes v WHERE v.patNroPas = :patNroPas"),
    @NamedQuery(name = "ViaPasaportes.findByPatFecEmi", query = "SELECT v FROM ViaPasaportes v WHERE v.patFecEmi = :patFecEmi"),
    @NamedQuery(name = "ViaPasaportes.findByPatFecVen", query = "SELECT v FROM ViaPasaportes v WHERE v.patFecVen = :patFecVen"),
    @NamedQuery(name = "ViaPasaportes.findByPatUsuIns", query = "SELECT v FROM ViaPasaportes v WHERE v.patUsuIns = :patUsuIns"),
    @NamedQuery(name = "ViaPasaportes.findByPatFecIns", query = "SELECT v FROM ViaPasaportes v WHERE v.patFecIns = :patFecIns"),
    @NamedQuery(name = "ViaPasaportes.findByPatUsuMod", query = "SELECT v FROM ViaPasaportes v WHERE v.patUsuMod = :patUsuMod"),
    @NamedQuery(name = "ViaPasaportes.findByPatFecMod", query = "SELECT v FROM ViaPasaportes v WHERE v.patFecMod = :patFecMod"),
    @NamedQuery(name = "ViaPasaportes.findByPatId", query = "SELECT v FROM ViaPasaportes v WHERE v.patId = :patId")})
public class ViaPasaportes implements Serializable {
    @OneToMany(mappedBy = "patId")
    private List<ViaVisas> viaVisasList;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "pat_nro_pas", nullable = false, length = 15)
    private String patNroPas;
    @Column(name = "pat_fec_emi")
    @Temporal(TemporalType.DATE)
    private Date patFecEmi;
    @Column(name = "pat_fec_ven")
    @Temporal(TemporalType.DATE)
    private Date patFecVen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pat_usu_ins", nullable = false, length = 10)
    private String patUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pat_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date patFecIns;
    @Size(max = 10)
    @Column(name = "pat_usu_mod", length = 10)
    private String patUsuMod;
    @Column(name = "pat_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date patFecMod;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pat_id", nullable = false)
    private Integer patId;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id", nullable = false)
    @OneToOne(optional = false)
    private PgePersonas perId;

    public ViaPasaportes() {
    }

    public ViaPasaportes(Integer patId) {
        this.patId = patId;
    }

    public ViaPasaportes(Integer patId, String patNroPas, String patUsuIns, Date patFecIns) {
        this.patId = patId;
        this.patNroPas = patNroPas;
        this.patUsuIns = patUsuIns;
        this.patFecIns = patFecIns;
    }

    public String getPatNroPas() {
        return patNroPas;
    }

    public void setPatNroPas(String patNroPas) {
        this.patNroPas = patNroPas;
    }

    public Date getPatFecEmi() {
        return patFecEmi;
    }

    public void setPatFecEmi(Date patFecEmi) {
        this.patFecEmi = patFecEmi;
    }

    public Date getPatFecVen() {
        return patFecVen;
    }

    public void setPatFecVen(Date patFecVen) {
        this.patFecVen = patFecVen;
    }

    public String getPatUsuIns() {
        return patUsuIns;
    }

    public void setPatUsuIns(String patUsuIns) {
        this.patUsuIns = patUsuIns;
    }

    public Date getPatFecIns() {
        return patFecIns;
    }

    public void setPatFecIns(Date patFecIns) {
        this.patFecIns = patFecIns;
    }

    public String getPatUsuMod() {
        return patUsuMod;
    }

    public void setPatUsuMod(String patUsuMod) {
        this.patUsuMod = patUsuMod;
    }

    public Date getPatFecMod() {
        return patFecMod;
    }

    public void setPatFecMod(Date patFecMod) {
        this.patFecMod = patFecMod;
    }

    public Integer getPatId() {
        return patId;
    }

    public void setPatId(Integer patId) {
        this.patId = patId;
    }

    public PgePersonas getPerId() {
        return perId;
    }

    public void setPerId(PgePersonas perId) {
        this.perId = perId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patId != null ? patId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPasaportes)) {
            return false;
        }
        ViaPasaportes other = (ViaPasaportes) object;
        if ((this.patId == null && other.patId != null) || (this.patId != null && !this.patId.equals(other.patId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaPasaportes[ patId=" + patId + " ]";
    }

    public List<ViaVisas> getViaVisasList() {
        return viaVisasList;
    }

    public void setViaVisasList(List<ViaVisas> viaVisasList) {
        this.viaVisasList = viaVisasList;
    }
    
}
