/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pge_tipo_org", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgeTipoOrg.findAll", query = "SELECT p FROM PgeTipoOrg p"),
    @NamedQuery(name = "PgeTipoOrg.findByTipCodigo", query = "SELECT p FROM PgeTipoOrg p WHERE p.tipCodigo = :tipCodigo"),
    @NamedQuery(name = "PgeTipoOrg.findByTipDescripcion", query = "SELECT p FROM PgeTipoOrg p WHERE p.tipDescripcion = :tipDescripcion"),
    @NamedQuery(name = "PgeTipoOrg.findByTipId", query = "SELECT p FROM PgeTipoOrg p WHERE p.tipId = :tipId")})
public class PgeTipoOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tip_codigo", nullable = false, length = 2)
    private String tipCodigo;
    @Size(max = 30)
    @Column(name = "tip_descripcion", length = 30)
    private String tipDescripcion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tip_id", nullable = false)
    private Integer tipId;
    @OneToMany(mappedBy = "tipOrgId")
    private List<PgeOrganizaciones> pgeOrganizacionesList;

    public PgeTipoOrg() {
    }

    public PgeTipoOrg(Integer tipId) {
        this.tipId = tipId;
    }

    public PgeTipoOrg(Integer tipId, String tipCodigo) {
        this.tipId = tipId;
        this.tipCodigo = tipCodigo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipDescripcion() {
        return tipDescripcion;
    }

    public void setTipDescripcion(String tipDescripcion) {
        this.tipDescripcion = tipDescripcion;
    }

    public Integer getTipId() {
        return tipId;
    }

    public void setTipId(Integer tipId) {
        this.tipId = tipId;
    }

    public List<PgeOrganizaciones> getPgeOrganizacionesList() {
        return pgeOrganizacionesList;
    }

    public void setPgeOrganizacionesList(List<PgeOrganizaciones> pgeOrganizacionesList) {
        this.pgeOrganizacionesList = pgeOrganizacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipId != null ? tipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeTipoOrg)) {
            return false;
        }
        PgeTipoOrg other = (PgeTipoOrg) object;
        if ((this.tipId == null && other.tipId != null) || (this.tipId != null && !this.tipId.equals(other.tipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeTipoOrg[ tipId=" + tipId + " ]";
    }
    
}
