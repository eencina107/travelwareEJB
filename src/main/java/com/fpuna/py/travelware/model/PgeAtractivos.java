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
import javax.persistence.Lob;
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
@Table(name = "pge_atractivos", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ciu_id", "atr_id"})})
@NamedQueries({
    @NamedQuery(name = "PgeAtractivos.findAll", query = "SELECT p FROM PgeAtractivos p"),
    @NamedQuery(name = "PgeAtractivos.findByAtrId", query = "SELECT p FROM PgeAtractivos p WHERE p.atrId = :atrId"),
    @NamedQuery(name = "PgeAtractivos.findByAtrDesc", query = "SELECT p FROM PgeAtractivos p WHERE p.atrDesc = :atrDesc"),
    @NamedQuery(name = "PgeAtractivos.findByAtrUbi", query = "SELECT p FROM PgeAtractivos p WHERE p.atrUbi = :atrUbi"),
    @NamedQuery(name = "PgeAtractivos.findByAtrUsuIns", query = "SELECT p FROM PgeAtractivos p WHERE p.atrUsuIns = :atrUsuIns"),
    @NamedQuery(name = "PgeAtractivos.findByAtrFecIns", query = "SELECT p FROM PgeAtractivos p WHERE p.atrFecIns = :atrFecIns"),
    @NamedQuery(name = "PgeAtractivos.findByAtrUsuMod", query = "SELECT p FROM PgeAtractivos p WHERE p.atrUsuMod = :atrUsuMod"),
    @NamedQuery(name = "PgeAtractivos.findByAtrFecMod", query = "SELECT p FROM PgeAtractivos p WHERE p.atrFecMod = :atrFecMod")})
public class PgeAtractivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "atr_id", nullable = false)
    private Integer atrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "atr_desc", nullable = false, length = 35)
    private String atrDesc;
    @Lob
    @Column(name = "atr_img")
    private byte[] atrImg;
    @Size(max = 500)
    @Column(name = "atr_ubi", length = 500)
    private String atrUbi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "atr_usu_ins", nullable = false, length = 10)
    private String atrUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "atr_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date atrFecIns;
    @Size(max = 10)
    @Column(name = "atr_usu_mod", length = 10)
    private String atrUsuMod;
    @Column(name = "atr_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atrFecMod;
    @JoinColumn(name = "ciu_id", referencedColumnName = "ciu_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeCiudades ciuId;

    public PgeAtractivos() {
    }

    public PgeAtractivos(Integer atrId) {
        this.atrId = atrId;
    }

    public PgeAtractivos(Integer atrId, String atrDesc, String atrUsuIns, Date atrFecIns) {
        this.atrId = atrId;
        this.atrDesc = atrDesc;
        this.atrUsuIns = atrUsuIns;
        this.atrFecIns = atrFecIns;
    }

    public Integer getAtrId() {
        return atrId;
    }

    public void setAtrId(Integer atrId) {
        this.atrId = atrId;
    }

    public String getAtrDesc() {
        return atrDesc;
    }

    public void setAtrDesc(String atrDesc) {
        this.atrDesc = atrDesc;
    }

    public byte[] getAtrImg() {
        return atrImg;
    }

    public void setAtrImg(byte[] atrImg) {
        this.atrImg = atrImg;
    }

    public String getAtrUbi() {
        return atrUbi;
    }

    public void setAtrUbi(String atrUbi) {
        this.atrUbi = atrUbi;
    }

    public String getAtrUsuIns() {
        return atrUsuIns;
    }

    public void setAtrUsuIns(String atrUsuIns) {
        this.atrUsuIns = atrUsuIns;
    }

    public Date getAtrFecIns() {
        return atrFecIns;
    }

    public void setAtrFecIns(Date atrFecIns) {
        this.atrFecIns = atrFecIns;
    }

    public String getAtrUsuMod() {
        return atrUsuMod;
    }

    public void setAtrUsuMod(String atrUsuMod) {
        this.atrUsuMod = atrUsuMod;
    }

    public Date getAtrFecMod() {
        return atrFecMod;
    }

    public void setAtrFecMod(Date atrFecMod) {
        this.atrFecMod = atrFecMod;
    }

    public PgeCiudades getCiuId() {
        return ciuId;
    }

    public void setCiuId(PgeCiudades ciuId) {
        this.ciuId = ciuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atrId != null ? atrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeAtractivos)) {
            return false;
        }
        PgeAtractivos other = (PgeAtractivos) object;
        if ((this.atrId == null && other.atrId != null) || (this.atrId != null && !this.atrId.equals(other.atrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeAtractivos[ atrId=" + atrId + " ]";
    }
    
}
