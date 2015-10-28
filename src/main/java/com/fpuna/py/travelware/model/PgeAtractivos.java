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
import javax.persistence.JoinColumns;
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
@Table(name = "pge_atractivos", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgeAtractivos.findAll", query = "SELECT p FROM PgeAtractivos p"),
    @NamedQuery(name = "PgeAtractivos.findByPaiId", query = "SELECT p FROM PgeAtractivos p WHERE p.pgeAtractivosPK.paiId = :paiId"),
    @NamedQuery(name = "PgeAtractivos.findByCiuId", query = "SELECT p FROM PgeAtractivos p WHERE p.pgeAtractivosPK.ciuId = :ciuId"),
    @NamedQuery(name = "PgeAtractivos.findByAtrId", query = "SELECT p FROM PgeAtractivos p WHERE p.pgeAtractivosPK.atrId = :atrId"),
    @NamedQuery(name = "PgeAtractivos.findByAtrDesc", query = "SELECT p FROM PgeAtractivos p WHERE p.atrDesc = :atrDesc"),
    @NamedQuery(name = "PgeAtractivos.findByAtrUbi", query = "SELECT p FROM PgeAtractivos p WHERE p.atrUbi = :atrUbi"),
    @NamedQuery(name = "PgeAtractivos.findByAtrUsuIns", query = "SELECT p FROM PgeAtractivos p WHERE p.atrUsuIns = :atrUsuIns"),
    @NamedQuery(name = "PgeAtractivos.findByAtrFecIns", query = "SELECT p FROM PgeAtractivos p WHERE p.atrFecIns = :atrFecIns"),
    @NamedQuery(name = "PgeAtractivos.findByAtrUsuMod", query = "SELECT p FROM PgeAtractivos p WHERE p.atrUsuMod = :atrUsuMod"),
    @NamedQuery(name = "PgeAtractivos.findByAtrFecMod", query = "SELECT p FROM PgeAtractivos p WHERE p.atrFecMod = :atrFecMod")})
public class PgeAtractivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PgeAtractivosPK pgeAtractivosPK;
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
    @JoinColumns({
        @JoinColumn(name = "pai_id", referencedColumnName = "pai_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ciu_id", referencedColumnName = "ciu_id", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PgeCiudades pgeCiudades;

    public PgeAtractivos() {
    }

    public PgeAtractivos(PgeAtractivosPK pgeAtractivosPK) {
        this.pgeAtractivosPK = pgeAtractivosPK;
    }

    public PgeAtractivos(PgeAtractivosPK pgeAtractivosPK, String atrDesc, String atrUsuIns, Date atrFecIns) {
        this.pgeAtractivosPK = pgeAtractivosPK;
        this.atrDesc = atrDesc;
        this.atrUsuIns = atrUsuIns;
        this.atrFecIns = atrFecIns;
    }

    public PgeAtractivos(int paiId, int ciuId, int atrId) {
        this.pgeAtractivosPK = new PgeAtractivosPK(paiId, ciuId, atrId);
    }

    public PgeAtractivosPK getPgeAtractivosPK() {
        return pgeAtractivosPK;
    }

    public void setPgeAtractivosPK(PgeAtractivosPK pgeAtractivosPK) {
        this.pgeAtractivosPK = pgeAtractivosPK;
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

    public PgeCiudades getPgeCiudades() {
        return pgeCiudades;
    }

    public void setPgeCiudades(PgeCiudades pgeCiudades) {
        this.pgeCiudades = pgeCiudades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgeAtractivosPK != null ? pgeAtractivosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeAtractivos)) {
            return false;
        }
        PgeAtractivos other = (PgeAtractivos) object;
        if ((this.pgeAtractivosPK == null && other.pgeAtractivosPK != null) || (this.pgeAtractivosPK != null && !this.pgeAtractivosPK.equals(other.pgeAtractivosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeAtractivos[ pgeAtractivosPK=" + pgeAtractivosPK + " ]";
    }
    
}
