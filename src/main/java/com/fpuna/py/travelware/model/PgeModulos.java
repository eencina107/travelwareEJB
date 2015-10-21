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
@Table(name = "PGE_MODULOS")
@NamedQueries({
    @NamedQuery(name = "PgeModulos.findAll", query = "SELECT p FROM PgeModulos p"),
    @NamedQuery(name = "PgeModulos.findByModId", query = "SELECT p FROM PgeModulos p WHERE p.modId = :modId"),
    @NamedQuery(name = "PgeModulos.findByModDesc", query = "SELECT p FROM PgeModulos p WHERE p.modDesc = :modDesc"),
    @NamedQuery(name = "PgeModulos.findByModAbr", query = "SELECT p FROM PgeModulos p WHERE p.modAbr = :modAbr"),
    @NamedQuery(name = "PgeModulos.findByModEst", query = "SELECT p FROM PgeModulos p WHERE p.modEst = :modEst"),
    @NamedQuery(name = "PgeModulos.findByModUsuIns", query = "SELECT p FROM PgeModulos p WHERE p.modUsuIns = :modUsuIns"),
    @NamedQuery(name = "PgeModulos.findByModFecIns", query = "SELECT p FROM PgeModulos p WHERE p.modFecIns = :modFecIns"),
    @NamedQuery(name = "PgeModulos.findByModUsuMod", query = "SELECT p FROM PgeModulos p WHERE p.modUsuMod = :modUsuMod"),
    @NamedQuery(name = "PgeModulos.findByModFecMod", query = "SELECT p FROM PgeModulos p WHERE p.modFecMod = :modFecMod")})
public class PgeModulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MOD_ID")
    private Integer modId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "MOD_DESC")
    private String modDesc;
    @Size(max = 10)
    @Column(name = "MOD_ABR")
    private String modAbr;
    @Column(name = "MOD_EST")
    private Short modEst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MOD_USU_INS")
    private String modUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOD_FEC_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modFecIns;
    @Size(max = 10)
    @Column(name = "MOD_USU_MOD")
    private String modUsuMod;
    @Column(name = "MOD_FEC_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modFecMod;

    public PgeModulos() {
    }

    public PgeModulos(Integer modId) {
        this.modId = modId;
    }

    public PgeModulos(Integer modId, String modDesc, String modUsuIns, Date modFecIns) {
        this.modId = modId;
        this.modDesc = modDesc;
        this.modUsuIns = modUsuIns;
        this.modFecIns = modFecIns;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String getModDesc() {
        return modDesc;
    }

    public void setModDesc(String modDesc) {
        this.modDesc = modDesc;
    }

    public String getModAbr() {
        return modAbr;
    }

    public void setModAbr(String modAbr) {
        this.modAbr = modAbr;
    }

    public Short getModEst() {
        return modEst;
    }

    public void setModEst(Short modEst) {
        this.modEst = modEst;
    }

    public String getModUsuIns() {
        return modUsuIns;
    }

    public void setModUsuIns(String modUsuIns) {
        this.modUsuIns = modUsuIns;
    }

    public Date getModFecIns() {
        return modFecIns;
    }

    public void setModFecIns(Date modFecIns) {
        this.modFecIns = modFecIns;
    }

    public String getModUsuMod() {
        return modUsuMod;
    }

    public void setModUsuMod(String modUsuMod) {
        this.modUsuMod = modUsuMod;
    }

    public Date getModFecMod() {
        return modFecMod;
    }

    public void setModFecMod(Date modFecMod) {
        this.modFecMod = modFecMod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modId != null ? modId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeModulos)) {
            return false;
        }
        PgeModulos other = (PgeModulos) object;
        if ((this.modId == null && other.modId != null) || (this.modId != null && !this.modId.equals(other.modId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.PgeModulos[ modId=" + modId + " ]";
    }
    
}
