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
@Table(name = "via_pas_viajes", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"via_id", "per_id"})})
@NamedQueries({
    @NamedQuery(name = "ViaPasViajes.findAll", query = "SELECT v FROM ViaPasViajes v"),
    @NamedQuery(name = "ViaPasViajes.findByPviRel", query = "SELECT v FROM ViaPasViajes v WHERE v.pviRel = :pviRel"),
    @NamedQuery(name = "ViaPasViajes.findByPreId", query = "SELECT v FROM ViaPasViajes v WHERE v.preId = :preId"),
    @NamedQuery(name = "ViaPasViajes.findByMonId", query = "SELECT v FROM ViaPasViajes v WHERE v.monId = :monId"),
    @NamedQuery(name = "ViaPasViajes.findByPviUsuIns", query = "SELECT v FROM ViaPasViajes v WHERE v.pviUsuIns = :pviUsuIns"),
    @NamedQuery(name = "ViaPasViajes.findByPviFecIns", query = "SELECT v FROM ViaPasViajes v WHERE v.pviFecIns = :pviFecIns"),
    @NamedQuery(name = "ViaPasViajes.findByPviUsuMod", query = "SELECT v FROM ViaPasViajes v WHERE v.pviUsuMod = :pviUsuMod"),
    @NamedQuery(name = "ViaPasViajes.findByPviFecMod", query = "SELECT v FROM ViaPasViajes v WHERE v.pviFecMod = :pviFecMod"),
    @NamedQuery(name = "ViaPasViajes.findByPviId", query = "SELECT v FROM ViaPasViajes v WHERE v.pviId = :pviId")})
public class ViaPasViajes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pvi_rel", nullable = false)
    private Character pviRel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pre_id", nullable = false)
    private int preId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mon_id", nullable = false)
    private int monId;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pvi_usu_mod", nullable = false, length = 10)
    private String pviUsuMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pvi_fec_mod", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date pviFecMod;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pvi_id", nullable = false)
    private Integer pviId;
    @JoinColumn(name = "via_id", referencedColumnName = "via_id", nullable = false)
    @ManyToOne(optional = false)
    private ViaViajes viaId;
    @JoinColumn(name = "pvi_id", referencedColumnName = "pre_id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ViaPreViajes viaPreViajes;
    @JoinColumn(name = "pvi_pas_id", referencedColumnName = "per_id", nullable = false)
    @ManyToOne(optional = false)
    private ViaPasajeros pviPasId;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id", nullable = false)
    @ManyToOne(optional = false)
    private ViaPasajeros perId;

    public ViaPasViajes() {
    }

    public ViaPasViajes(Integer pviId) {
        this.pviId = pviId;
    }

    public ViaPasViajes(Integer pviId, Character pviRel, int preId, int monId, String pviUsuIns, Date pviFecIns, String pviUsuMod, Date pviFecMod) {
        this.pviId = pviId;
        this.pviRel = pviRel;
        this.preId = preId;
        this.monId = monId;
        this.pviUsuIns = pviUsuIns;
        this.pviFecIns = pviFecIns;
        this.pviUsuMod = pviUsuMod;
        this.pviFecMod = pviFecMod;
    }

    public Character getPviRel() {
        return pviRel;
    }

    public void setPviRel(Character pviRel) {
        this.pviRel = pviRel;
    }

    public int getPreId() {
        return preId;
    }

    public void setPreId(int preId) {
        this.preId = preId;
    }

    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
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

    public ViaViajes getViaId() {
        return viaId;
    }

    public void setViaId(ViaViajes viaId) {
        this.viaId = viaId;
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

    public ViaPasajeros getPerId() {
        return perId;
    }

    public void setPerId(ViaPasajeros perId) {
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
        if (!(object instanceof ViaPasViajes)) {
            return false;
        }
        ViaPasViajes other = (ViaPasViajes) object;
        if ((this.pviId == null && other.pviId != null) || (this.pviId != null && !this.pviId.equals(other.pviId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaPasViajes[ pviId=" + pviId + " ]";
    }
    
}
