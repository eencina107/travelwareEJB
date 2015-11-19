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

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pge_modulos", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgeModulos.findAll", query = "SELECT p FROM PgeModulos p"),
    @NamedQuery(name = "PgeModulos.findByModId", query = "SELECT p FROM PgeModulos p WHERE p.modId = :modId"),
    @NamedQuery(name = "PgeModulos.findByModDesc", query = "SELECT p FROM PgeModulos p WHERE p.modDesc = :modDesc"),
    @NamedQuery(name = "PgeModulos.findByModAbr", query = "SELECT p FROM PgeModulos p WHERE p.modAbr = :modAbr"),
    @NamedQuery(name = "PgeModulos.findByModUsuIns", query = "SELECT p FROM PgeModulos p WHERE p.modUsuIns = :modUsuIns"),
    @NamedQuery(name = "PgeModulos.findByModFecIns", query = "SELECT p FROM PgeModulos p WHERE p.modFecIns = :modFecIns"),
    @NamedQuery(name = "PgeModulos.findByModUsuMod", query = "SELECT p FROM PgeModulos p WHERE p.modUsuMod = :modUsuMod"),
    @NamedQuery(name = "PgeModulos.findByModFecMod", query = "SELECT p FROM PgeModulos p WHERE p.modFecMod = :modFecMod"),
    @NamedQuery(name = "PgeModulos.findByModEstado", query = "SELECT p FROM PgeModulos p WHERE p.modEstado = :modEstado")})
public class PgeModulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mod_id", nullable = false)
    private Integer modId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "mod_desc", nullable = false, length = 35)
    private String modDesc;
    @Size(max = 10)
    @Column(name = "mod_abr", length = 10)
    private String modAbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mod_usu_ins", nullable = false, length = 10)
    private String modUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mod_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modFecIns;
    @Size(max = 10)
    @Column(name = "mod_usu_mod", length = 10)
    private String modUsuMod;
    @Column(name = "mod_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modFecMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mod_estado", nullable = false)
    private Character modEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgeModulos")
    private List<PgeMenus> pgeMenusList;

    public PgeModulos() {
    }

    public PgeModulos(Integer modId) {
        this.modId = modId;
    }

    public PgeModulos(Integer modId, String modDesc, String modUsuIns, Date modFecIns, Character modEstado) {
        this.modId = modId;
        this.modDesc = modDesc;
        this.modUsuIns = modUsuIns;
        this.modFecIns = modFecIns;
        this.modEstado = modEstado;
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

    public Character getModEstado() {
        return modEstado;
    }

    public void setModEstado(Character modEstado) {
        this.modEstado = modEstado;
    }

    public List<PgeMenus> getPgeMenusList() {
        return pgeMenusList;
    }

    public void setPgeMenusList(List<PgeMenus> pgeMenusList) {
        this.pgeMenusList = pgeMenusList;
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
        return "com.fpuna.py.travelware.model.PgeModulos[ modId=" + modId + " ]";
    }

    
    
}
