/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "PGE_ROLES")
@NamedQueries({
    @NamedQuery(name = "PgeRoles.findAll", query = "SELECT p FROM PgeRoles p"),
    @NamedQuery(name = "PgeRoles.findByRolId", query = "SELECT p FROM PgeRoles p WHERE p.rolId = :rolId"),
    @NamedQuery(name = "PgeRoles.findByRolDesc", query = "SELECT p FROM PgeRoles p WHERE p.rolDesc = :rolDesc"),
    @NamedQuery(name = "PgeRoles.findByRolUsuIns", query = "SELECT p FROM PgeRoles p WHERE p.rolUsuIns = :rolUsuIns"),
    @NamedQuery(name = "PgeRoles.findByRolFecIns", query = "SELECT p FROM PgeRoles p WHERE p.rolFecIns = :rolFecIns"),
    @NamedQuery(name = "PgeRoles.findByRolUsuMod", query = "SELECT p FROM PgeRoles p WHERE p.rolUsuMod = :rolUsuMod"),
    @NamedQuery(name = "PgeRoles.findByRolFecMod", query = "SELECT p FROM PgeRoles p WHERE p.rolFecMod = :rolFecMod")})
public class PgeRoles implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgeRoles")
    private Collection<PgePermisos> pgePermisosCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ROL_ID")
    private Integer rolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "ROL_DESC")
    private String rolDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ROL_USU_INS")
    private String rolUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_FEC_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rolFecIns;
    @Size(max = 10)
    @Column(name = "ROL_USU_MOD")
    private String rolUsuMod;
    @Column(name = "ROL_FEC_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rolFecMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgeRoles")
    private List<PgeUsuRoles> pgeUsuRolesList;

    public PgeRoles() {
    }

    public PgeRoles(Integer rolId) {
        this.rolId = rolId;
    }

    public PgeRoles(Integer rolId, String rolDesc, String rolUsuIns, Date rolFecIns) {
        this.rolId = rolId;
        this.rolDesc = rolDesc;
        this.rolUsuIns = rolUsuIns;
        this.rolFecIns = rolFecIns;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolDesc() {
        return rolDesc;
    }

    public void setRolDesc(String rolDesc) {
        this.rolDesc = rolDesc;
    }

    public String getRolUsuIns() {
        return rolUsuIns;
    }

    public void setRolUsuIns(String rolUsuIns) {
        this.rolUsuIns = rolUsuIns;
    }

    public Date getRolFecIns() {
        return rolFecIns;
    }

    public void setRolFecIns(Date rolFecIns) {
        this.rolFecIns = rolFecIns;
    }

    public String getRolUsuMod() {
        return rolUsuMod;
    }

    public void setRolUsuMod(String rolUsuMod) {
        this.rolUsuMod = rolUsuMod;
    }

    public Date getRolFecMod() {
        return rolFecMod;
    }

    public void setRolFecMod(Date rolFecMod) {
        this.rolFecMod = rolFecMod;
    }

    public List<PgeUsuRoles> getPgeUsuRolesList() {
        return pgeUsuRolesList;
    }

    public void setPgeUsuRolesList(List<PgeUsuRoles> pgeUsuRolesList) {
        this.pgeUsuRolesList = pgeUsuRolesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeRoles)) {
            return false;
        }
        PgeRoles other = (PgeRoles) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.PgeRoles[ rolId=" + rolId + " ]";
    }

    public Collection<PgePermisos> getPgePermisosCollection() {
        return pgePermisosCollection;
    }

    public void setPgePermisosCollection(Collection<PgePermisos> pgePermisosCollection) {
        this.pgePermisosCollection = pgePermisosCollection;
    }
    
}
