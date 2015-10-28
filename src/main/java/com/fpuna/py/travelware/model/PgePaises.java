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
@Table(name = "pge_paises", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgePaises.findAll", query = "SELECT p FROM PgePaises p"),
    @NamedQuery(name = "PgePaises.findByPaiId", query = "SELECT p FROM PgePaises p WHERE p.paiId = :paiId"),
    @NamedQuery(name = "PgePaises.findByPaiDesc", query = "SELECT p FROM PgePaises p WHERE p.paiDesc = :paiDesc"),
    @NamedQuery(name = "PgePaises.findByPaiNac", query = "SELECT p FROM PgePaises p WHERE p.paiNac = :paiNac"),
    @NamedQuery(name = "PgePaises.findByPaiUbi", query = "SELECT p FROM PgePaises p WHERE p.paiUbi = :paiUbi"),
    @NamedQuery(name = "PgePaises.findByPaiUsuIns", query = "SELECT p FROM PgePaises p WHERE p.paiUsuIns = :paiUsuIns"),
    @NamedQuery(name = "PgePaises.findByPaiFecIns", query = "SELECT p FROM PgePaises p WHERE p.paiFecIns = :paiFecIns"),
    @NamedQuery(name = "PgePaises.findByPaiUsuMod", query = "SELECT p FROM PgePaises p WHERE p.paiUsuMod = :paiUsuMod"),
    @NamedQuery(name = "PgePaises.findByPaiFecMod", query = "SELECT p FROM PgePaises p WHERE p.paiFecMod = :paiFecMod")})
public class PgePaises implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pai_id", nullable = false)
    private Integer paiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "pai_desc", nullable = false, length = 35)
    private String paiDesc;
    @Size(max = 40)
    @Column(name = "pai_nac", length = 40)
    private String paiNac;
    @Size(max = 500)
    @Column(name = "pai_ubi", length = 500)
    private String paiUbi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pai_usu_ins", nullable = false, length = 10)
    private String paiUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pai_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiFecIns;
    @Size(max = 10)
    @Column(name = "pai_usu_mod", length = 10)
    private String paiUsuMod;
    @Column(name = "pai_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiFecMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paiId")
    private List<PgeMonedas> pgeMonedasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paiId")
    private List<PgePersonas> pgePersonasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgePaises")
    private List<PgeCiudades> pgeCiudadesList;

    public PgePaises() {
    }

    public PgePaises(Integer paiId) {
        this.paiId = paiId;
    }

    public PgePaises(Integer paiId, String paiDesc, String paiUsuIns, Date paiFecIns) {
        this.paiId = paiId;
        this.paiDesc = paiDesc;
        this.paiUsuIns = paiUsuIns;
        this.paiFecIns = paiFecIns;
    }

    public Integer getPaiId() {
        return paiId;
    }

    public void setPaiId(Integer paiId) {
        this.paiId = paiId;
    }

    public String getPaiDesc() {
        return paiDesc;
    }

    public void setPaiDesc(String paiDesc) {
        this.paiDesc = paiDesc;
    }

    public String getPaiNac() {
        return paiNac;
    }

    public void setPaiNac(String paiNac) {
        this.paiNac = paiNac;
    }

    public String getPaiUbi() {
        return paiUbi;
    }

    public void setPaiUbi(String paiUbi) {
        this.paiUbi = paiUbi;
    }

    public String getPaiUsuIns() {
        return paiUsuIns;
    }

    public void setPaiUsuIns(String paiUsuIns) {
        this.paiUsuIns = paiUsuIns;
    }

    public Date getPaiFecIns() {
        return paiFecIns;
    }

    public void setPaiFecIns(Date paiFecIns) {
        this.paiFecIns = paiFecIns;
    }

    public String getPaiUsuMod() {
        return paiUsuMod;
    }

    public void setPaiUsuMod(String paiUsuMod) {
        this.paiUsuMod = paiUsuMod;
    }

    public Date getPaiFecMod() {
        return paiFecMod;
    }

    public void setPaiFecMod(Date paiFecMod) {
        this.paiFecMod = paiFecMod;
    }

    public List<PgeMonedas> getPgeMonedasList() {
        return pgeMonedasList;
    }

    public void setPgeMonedasList(List<PgeMonedas> pgeMonedasList) {
        this.pgeMonedasList = pgeMonedasList;
    }

    public List<PgePersonas> getPgePersonasList() {
        return pgePersonasList;
    }

    public void setPgePersonasList(List<PgePersonas> pgePersonasList) {
        this.pgePersonasList = pgePersonasList;
    }

    public List<PgeCiudades> getPgeCiudadesList() {
        return pgeCiudadesList;
    }

    public void setPgeCiudadesList(List<PgeCiudades> pgeCiudadesList) {
        this.pgeCiudadesList = pgeCiudadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paiId != null ? paiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgePaises)) {
            return false;
        }
        PgePaises other = (PgePaises) object;
        if ((this.paiId == null && other.paiId != null) || (this.paiId != null && !this.paiId.equals(other.paiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgePaises[ paiId=" + paiId + " ]";
    }
    
}
