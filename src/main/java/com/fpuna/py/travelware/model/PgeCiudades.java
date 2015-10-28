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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pge_ciudades", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgeCiudades.findAll", query = "SELECT p FROM PgeCiudades p"),
    @NamedQuery(name = "PgeCiudades.findByCiuId", query = "SELECT p FROM PgeCiudades p WHERE p.pgeCiudadesPK.ciuId = :ciuId"),
    @NamedQuery(name = "PgeCiudades.findByPaiId", query = "SELECT p FROM PgeCiudades p WHERE p.pgeCiudadesPK.paiId = :paiId"),
    @NamedQuery(name = "PgeCiudades.findByCiuDesc", query = "SELECT p FROM PgeCiudades p WHERE p.ciuDesc = :ciuDesc"),
    @NamedQuery(name = "PgeCiudades.findByCiuUbi", query = "SELECT p FROM PgeCiudades p WHERE p.ciuUbi = :ciuUbi"),
    @NamedQuery(name = "PgeCiudades.findByCiuUsuIns", query = "SELECT p FROM PgeCiudades p WHERE p.ciuUsuIns = :ciuUsuIns"),
    @NamedQuery(name = "PgeCiudades.findByCiuFecIns", query = "SELECT p FROM PgeCiudades p WHERE p.ciuFecIns = :ciuFecIns"),
    @NamedQuery(name = "PgeCiudades.findByCiuUsuMod", query = "SELECT p FROM PgeCiudades p WHERE p.ciuUsuMod = :ciuUsuMod"),
    @NamedQuery(name = "PgeCiudades.findByCiuFecMod", query = "SELECT p FROM PgeCiudades p WHERE p.ciuFecMod = :ciuFecMod")})
public class PgeCiudades implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PgeCiudadesPK pgeCiudadesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "ciu_desc", nullable = false, length = 35)
    private String ciuDesc;
    @Size(max = 500)
    @Column(name = "ciu_ubi", length = 500)
    private String ciuUbi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ciu_usu_ins", nullable = false, length = 10)
    private String ciuUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ciu_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ciuFecIns;
    @Size(max = 10)
    @Column(name = "ciu_usu_mod", length = 10)
    private String ciuUsuMod;
    @Column(name = "ciu_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ciuFecMod;
    @OneToMany(mappedBy = "pgeCiudades")
    private List<ViaActividades> viaActividadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgeCiudades")
    private List<PgeOrganizaciones> pgeOrganizacionesList;
    @JoinColumn(name = "pai_id", referencedColumnName = "pai_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PgePaises pgePaises;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgeCiudades")
    private List<PgeAtractivos> pgeAtractivosList;

    public PgeCiudades() {
    }

    public PgeCiudades(PgeCiudadesPK pgeCiudadesPK) {
        this.pgeCiudadesPK = pgeCiudadesPK;
    }

    public PgeCiudades(PgeCiudadesPK pgeCiudadesPK, String ciuDesc, String ciuUsuIns, Date ciuFecIns) {
        this.pgeCiudadesPK = pgeCiudadesPK;
        this.ciuDesc = ciuDesc;
        this.ciuUsuIns = ciuUsuIns;
        this.ciuFecIns = ciuFecIns;
    }

    public PgeCiudades(int ciuId, int paiId) {
        this.pgeCiudadesPK = new PgeCiudadesPK(ciuId, paiId);
    }

    public PgeCiudadesPK getPgeCiudadesPK() {
        return pgeCiudadesPK;
    }

    public void setPgeCiudadesPK(PgeCiudadesPK pgeCiudadesPK) {
        this.pgeCiudadesPK = pgeCiudadesPK;
    }

    public String getCiuDesc() {
        return ciuDesc;
    }

    public void setCiuDesc(String ciuDesc) {
        this.ciuDesc = ciuDesc;
    }

    public String getCiuUbi() {
        return ciuUbi;
    }

    public void setCiuUbi(String ciuUbi) {
        this.ciuUbi = ciuUbi;
    }

    public String getCiuUsuIns() {
        return ciuUsuIns;
    }

    public void setCiuUsuIns(String ciuUsuIns) {
        this.ciuUsuIns = ciuUsuIns;
    }

    public Date getCiuFecIns() {
        return ciuFecIns;
    }

    public void setCiuFecIns(Date ciuFecIns) {
        this.ciuFecIns = ciuFecIns;
    }

    public String getCiuUsuMod() {
        return ciuUsuMod;
    }

    public void setCiuUsuMod(String ciuUsuMod) {
        this.ciuUsuMod = ciuUsuMod;
    }

    public Date getCiuFecMod() {
        return ciuFecMod;
    }

    public void setCiuFecMod(Date ciuFecMod) {
        this.ciuFecMod = ciuFecMod;
    }

    public List<ViaActividades> getViaActividadesList() {
        return viaActividadesList;
    }

    public void setViaActividadesList(List<ViaActividades> viaActividadesList) {
        this.viaActividadesList = viaActividadesList;
    }

    public List<PgeOrganizaciones> getPgeOrganizacionesList() {
        return pgeOrganizacionesList;
    }

    public void setPgeOrganizacionesList(List<PgeOrganizaciones> pgeOrganizacionesList) {
        this.pgeOrganizacionesList = pgeOrganizacionesList;
    }

    public PgePaises getPgePaises() {
        return pgePaises;
    }

    public void setPgePaises(PgePaises pgePaises) {
        this.pgePaises = pgePaises;
    }

    public List<PgeAtractivos> getPgeAtractivosList() {
        return pgeAtractivosList;
    }

    public void setPgeAtractivosList(List<PgeAtractivos> pgeAtractivosList) {
        this.pgeAtractivosList = pgeAtractivosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgeCiudadesPK != null ? pgeCiudadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeCiudades)) {
            return false;
        }
        PgeCiudades other = (PgeCiudades) object;
        if ((this.pgeCiudadesPK == null && other.pgeCiudadesPK != null) || (this.pgeCiudadesPK != null && !this.pgeCiudadesPK.equals(other.pgeCiudadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeCiudades[ pgeCiudadesPK=" + pgeCiudadesPK + " ]";
    }
    
}
