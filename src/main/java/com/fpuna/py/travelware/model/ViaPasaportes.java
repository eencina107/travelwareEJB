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
import javax.persistence.Lob;
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
@Table(name = "via_pasaportes", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViaPasaportes.findAll", query = "SELECT v FROM ViaPasaportes v"),
    @NamedQuery(name = "ViaPasaportes.findByPerId", query = "SELECT v FROM ViaPasaportes v WHERE v.viaPasaportesPK.perId = :perId"),
    @NamedQuery(name = "ViaPasaportes.findByPatNroSec", query = "SELECT v FROM ViaPasaportes v WHERE v.viaPasaportesPK.patNroSec = :patNroSec"),
    @NamedQuery(name = "ViaPasaportes.findByPatNroPas", query = "SELECT v FROM ViaPasaportes v WHERE v.patNroPas = :patNroPas"),
    @NamedQuery(name = "ViaPasaportes.findByPatFecEmi", query = "SELECT v FROM ViaPasaportes v WHERE v.patFecEmi = :patFecEmi"),
    @NamedQuery(name = "ViaPasaportes.findByPatFecVen", query = "SELECT v FROM ViaPasaportes v WHERE v.patFecVen = :patFecVen"),
    @NamedQuery(name = "ViaPasaportes.findByPatUsuIns", query = "SELECT v FROM ViaPasaportes v WHERE v.patUsuIns = :patUsuIns"),
    @NamedQuery(name = "ViaPasaportes.findByPatFecIns", query = "SELECT v FROM ViaPasaportes v WHERE v.patFecIns = :patFecIns"),
    @NamedQuery(name = "ViaPasaportes.findByPatUsuMod", query = "SELECT v FROM ViaPasaportes v WHERE v.patUsuMod = :patUsuMod"),
    @NamedQuery(name = "ViaPasaportes.findByPatFecMod", query = "SELECT v FROM ViaPasaportes v WHERE v.patFecMod = :patFecMod")})
public class ViaPasaportes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ViaPasaportesPK viaPasaportesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "pat_nro_pas", nullable = false, length = 15)
    private String patNroPas;
    @Lob
    @Column(name = "pat_img_pas")
    private byte[] patImgPas;
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
    @JoinColumn(name = "per_id", referencedColumnName = "per_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PgePersonas pgePersonas;

    public ViaPasaportes() {
    }

    public ViaPasaportes(ViaPasaportesPK viaPasaportesPK) {
        this.viaPasaportesPK = viaPasaportesPK;
    }

    public ViaPasaportes(ViaPasaportesPK viaPasaportesPK, String patNroPas, String patUsuIns, Date patFecIns) {
        this.viaPasaportesPK = viaPasaportesPK;
        this.patNroPas = patNroPas;
        this.patUsuIns = patUsuIns;
        this.patFecIns = patFecIns;
    }

    public ViaPasaportes(int perId, int patNroSec) {
        this.viaPasaportesPK = new ViaPasaportesPK(perId, patNroSec);
    }

    public ViaPasaportesPK getViaPasaportesPK() {
        return viaPasaportesPK;
    }

    public void setViaPasaportesPK(ViaPasaportesPK viaPasaportesPK) {
        this.viaPasaportesPK = viaPasaportesPK;
    }

    public String getPatNroPas() {
        return patNroPas;
    }

    public void setPatNroPas(String patNroPas) {
        this.patNroPas = patNroPas;
    }

    public byte[] getPatImgPas() {
        return patImgPas;
    }

    public void setPatImgPas(byte[] patImgPas) {
        this.patImgPas = patImgPas;
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

    public PgePersonas getPgePersonas() {
        return pgePersonas;
    }

    public void setPgePersonas(PgePersonas pgePersonas) {
        this.pgePersonas = pgePersonas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viaPasaportesPK != null ? viaPasaportesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPasaportes)) {
            return false;
        }
        ViaPasaportes other = (ViaPasaportes) object;
        if ((this.viaPasaportesPK == null && other.viaPasaportesPK != null) || (this.viaPasaportesPK != null && !this.viaPasaportesPK.equals(other.viaPasaportesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaPasaportes[ viaPasaportesPK=" + viaPasaportesPK + " ]";
    }
    
}
