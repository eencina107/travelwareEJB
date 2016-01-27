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
@Table(name = "via_pasajeros", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"via_id", "per_id"})})
@NamedQueries({
    @NamedQuery(name = "ViaPasajeros.findAll", query = "SELECT v FROM ViaPasajeros v"),
    @NamedQuery(name = "ViaPasajeros.findByPasRel", query = "SELECT v FROM ViaPasajeros v WHERE v.pasRel = :pasRel"),
    @NamedQuery(name = "ViaPasajeros.findByPviUsuIns", query = "SELECT v FROM ViaPasajeros v WHERE v.pviUsuIns = :pviUsuIns"),
    @NamedQuery(name = "ViaPasajeros.findByPviFecIns", query = "SELECT v FROM ViaPasajeros v WHERE v.pviFecIns = :pviFecIns"),
    @NamedQuery(name = "ViaPasajeros.findByPviUsuMod", query = "SELECT v FROM ViaPasajeros v WHERE v.pviUsuMod = :pviUsuMod"),
    @NamedQuery(name = "ViaPasajeros.findByPviFecMod", query = "SELECT v FROM ViaPasajeros v WHERE v.pviFecMod = :pviFecMod"),
    @NamedQuery(name = "ViaPasajeros.findByPviId", query = "SELECT v FROM ViaPasajeros v WHERE v.pviId = :pviId"),
    @NamedQuery(name = "ViaPasajeros.findByPasPrefAsi", query = "SELECT v FROM ViaPasajeros v WHERE v.pasPrefAsi = :pasPrefAsi"),
    @NamedQuery(name = "ViaPasajeros.findByPasPrefComi", query = "SELECT v FROM ViaPasajeros v WHERE v.pasPrefComi = :pasPrefComi")})
public class ViaPasajeros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pas_rel", nullable = false)
    private Character pasRel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pvi_usu_ins", nullable = false, length = 10)
    private String pviUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pvi_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date pviFecIns;
    @Size(max = 10)
    @Column(name = "pvi_usu_mod", length = 10)
    private String pviUsuMod;
    @Column(name = "pvi_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pviFecMod;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pvi_id", nullable = false)
    private Integer pviId;
    @Column(name = "pas_pref_asi")
    private Character pasPrefAsi;
    @Size(max = 20)
    @Column(name = "pas_pref_comi", length = 20)
    private String pasPrefComi;
    @JoinColumn(name = "via_id", referencedColumnName = "via_id", nullable = false)
    @ManyToOne(optional = false)
    private ViaViajes viaId;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id", nullable = false)
    @ManyToOne(optional = false)
    private PgePersonas perId;

    public ViaPasajeros() {
    }

    public ViaPasajeros(Integer pviId) {
        this.pviId = pviId;
    }

    public ViaPasajeros(Integer pviId, Character pasRel, String pviUsuIns, Date pviFecIns) {
        this.pviId = pviId;
        this.pasRel = pasRel;
        this.pviUsuIns = pviUsuIns;
        this.pviFecIns = pviFecIns;
    }

    public Character getPasRel() {
        return pasRel;
    }

    public void setPasRel(Character pasRel) {
        this.pasRel = pasRel;
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

    public Integer getPviId() {
        return pviId;
    }

    public void setPviId(Integer pviId) {
        this.pviId = pviId;
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

    public ViaViajes getViaId() {
        return viaId;
    }

    public void setViaId(ViaViajes viaId) {
        this.viaId = viaId;
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
        hash += (pviId != null ? pviId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPasajeros)) {
            return false;
        }
        ViaPasajeros other = (ViaPasajeros) object;
        if ((this.pviId == null && other.pviId != null) || (this.pviId != null && !this.pviId.equals(other.pviId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaPasajeros[ pviId=" + pviId + " ]";
    }
    
}
