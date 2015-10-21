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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "VIA_PASAJEROS")
@NamedQueries({
    @NamedQuery(name = "ViaPasajeros.findAll", query = "SELECT v FROM ViaPasajeros v"),
    @NamedQuery(name = "ViaPasajeros.findByPerId", query = "SELECT v FROM ViaPasajeros v WHERE v.perId = :perId"),
    @NamedQuery(name = "ViaPasajeros.findByPasPrefAsi", query = "SELECT v FROM ViaPasajeros v WHERE v.pasPrefAsi = :pasPrefAsi"),
    @NamedQuery(name = "ViaPasajeros.findByPasPrefComi", query = "SELECT v FROM ViaPasajeros v WHERE v.pasPrefComi = :pasPrefComi"),
    @NamedQuery(name = "ViaPasajeros.findByPasUsuIns", query = "SELECT v FROM ViaPasajeros v WHERE v.pasUsuIns = :pasUsuIns"),
    @NamedQuery(name = "ViaPasajeros.findByPasFecIns", query = "SELECT v FROM ViaPasajeros v WHERE v.pasFecIns = :pasFecIns"),
    @NamedQuery(name = "ViaPasajeros.findByPasUsuMod", query = "SELECT v FROM ViaPasajeros v WHERE v.pasUsuMod = :pasUsuMod"),
    @NamedQuery(name = "ViaPasajeros.findByPasFecMod", query = "SELECT v FROM ViaPasajeros v WHERE v.pasFecMod = :pasFecMod")})
public class ViaPasajeros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID")
    private Integer perId;
    @Column(name = "PAS_PREF_ASI")
    private Character pasPrefAsi;
    @Size(max = 20)
    @Column(name = "PAS_PREF_COMI")
    private String pasPrefComi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PAS_USU_INS")
    private String pasUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAS_FEC_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pasFecIns;
    @Size(max = 10)
    @Column(name = "PAS_USU_MOD")
    private String pasUsuMod;
    @Column(name = "PAS_FEC_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pasFecMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pviPasId")
    private List<ViaPasViajes> viaPasViajesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaPasajeros")
    private List<ViaPasViajes> viaPasViajesList1;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PgePersonas pgePersonas;

    public ViaPasajeros() {
    }

    public ViaPasajeros(Integer perId) {
        this.perId = perId;
    }

    public ViaPasajeros(Integer perId, String pasUsuIns, Date pasFecIns) {
        this.perId = perId;
        this.pasUsuIns = pasUsuIns;
        this.pasFecIns = pasFecIns;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Character getPasPrefAsi() {
        return pasPrefAsi;
    }

    public void setPasPrefAsi(Character pasPrefAsi) {
        this.pasPrefAsi = pasPrefAsi;
    }

    public String getPasPrefComi() {
        return pasPrefComi;
    }

    public void setPasPrefComi(String pasPrefComi) {
        this.pasPrefComi = pasPrefComi;
    }

    public String getPasUsuIns() {
        return pasUsuIns;
    }

    public void setPasUsuIns(String pasUsuIns) {
        this.pasUsuIns = pasUsuIns;
    }

    public Date getPasFecIns() {
        return pasFecIns;
    }

    public void setPasFecIns(Date pasFecIns) {
        this.pasFecIns = pasFecIns;
    }

    public String getPasUsuMod() {
        return pasUsuMod;
    }

    public void setPasUsuMod(String pasUsuMod) {
        this.pasUsuMod = pasUsuMod;
    }

    public Date getPasFecMod() {
        return pasFecMod;
    }

    public void setPasFecMod(Date pasFecMod) {
        this.pasFecMod = pasFecMod;
    }

    public List<ViaPasViajes> getViaPasViajesList() {
        return viaPasViajesList;
    }

    public void setViaPasViajesList(List<ViaPasViajes> viaPasViajesList) {
        this.viaPasViajesList = viaPasViajesList;
    }

    public List<ViaPasViajes> getViaPasViajesList1() {
        return viaPasViajesList1;
    }

    public void setViaPasViajesList1(List<ViaPasViajes> viaPasViajesList1) {
        this.viaPasViajesList1 = viaPasViajesList1;
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
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPasajeros)) {
            return false;
        }
        ViaPasajeros other = (ViaPasajeros) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.ViaPasajeros[ perId=" + perId + " ]";
    }
    
}
