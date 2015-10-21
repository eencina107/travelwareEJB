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
@Table(name = "PGE_USU_ROLES")
@NamedQueries({
    @NamedQuery(name = "PgeUsuRoles.findAll", query = "SELECT p FROM PgeUsuRoles p"),
    @NamedQuery(name = "PgeUsuRoles.findByRolId", query = "SELECT p FROM PgeUsuRoles p WHERE p.pgeUsuRolesPK.rolId = :rolId"),
    @NamedQuery(name = "PgeUsuRoles.findByUsuId", query = "SELECT p FROM PgeUsuRoles p WHERE p.pgeUsuRolesPK.usuId = :usuId"),
    @NamedQuery(name = "PgeUsuRoles.findByUroUsuIns", query = "SELECT p FROM PgeUsuRoles p WHERE p.uroUsuIns = :uroUsuIns"),
    @NamedQuery(name = "PgeUsuRoles.findByUroFecIns", query = "SELECT p FROM PgeUsuRoles p WHERE p.uroFecIns = :uroFecIns"),
    @NamedQuery(name = "PgeUsuRoles.findByUroUsuMod", query = "SELECT p FROM PgeUsuRoles p WHERE p.uroUsuMod = :uroUsuMod"),
    @NamedQuery(name = "PgeUsuRoles.findByUroFecMod", query = "SELECT p FROM PgeUsuRoles p WHERE p.uroFecMod = :uroFecMod")})
public class PgeUsuRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PgeUsuRolesPK pgeUsuRolesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "URO_USU_INS")
    private String uroUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "URO_FEC_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uroFecIns;
    @Size(max = 10)
    @Column(name = "URO_USU_MOD")
    private String uroUsuMod;
    @Column(name = "URO_FEC_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uroFecMod;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PgeUsuarios pgeUsuarios;
    @JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PgeRoles pgeRoles;

    public PgeUsuRoles() {
    }

    public PgeUsuRoles(PgeUsuRolesPK pgeUsuRolesPK) {
        this.pgeUsuRolesPK = pgeUsuRolesPK;
    }

    public PgeUsuRoles(PgeUsuRolesPK pgeUsuRolesPK, String uroUsuIns, Date uroFecIns) {
        this.pgeUsuRolesPK = pgeUsuRolesPK;
        this.uroUsuIns = uroUsuIns;
        this.uroFecIns = uroFecIns;
    }

    public PgeUsuRoles(int rolId, int usuId) {
        this.pgeUsuRolesPK = new PgeUsuRolesPK(rolId, usuId);
    }

    public PgeUsuRolesPK getPgeUsuRolesPK() {
        return pgeUsuRolesPK;
    }

    public void setPgeUsuRolesPK(PgeUsuRolesPK pgeUsuRolesPK) {
        this.pgeUsuRolesPK = pgeUsuRolesPK;
    }

    public String getUroUsuIns() {
        return uroUsuIns;
    }

    public void setUroUsuIns(String uroUsuIns) {
        this.uroUsuIns = uroUsuIns;
    }

    public Date getUroFecIns() {
        return uroFecIns;
    }

    public void setUroFecIns(Date uroFecIns) {
        this.uroFecIns = uroFecIns;
    }

    public String getUroUsuMod() {
        return uroUsuMod;
    }

    public void setUroUsuMod(String uroUsuMod) {
        this.uroUsuMod = uroUsuMod;
    }

    public Date getUroFecMod() {
        return uroFecMod;
    }

    public void setUroFecMod(Date uroFecMod) {
        this.uroFecMod = uroFecMod;
    }

    public PgeUsuarios getPgeUsuarios() {
        return pgeUsuarios;
    }

    public void setPgeUsuarios(PgeUsuarios pgeUsuarios) {
        this.pgeUsuarios = pgeUsuarios;
    }

    public PgeRoles getPgeRoles() {
        return pgeRoles;
    }

    public void setPgeRoles(PgeRoles pgeRoles) {
        this.pgeRoles = pgeRoles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgeUsuRolesPK != null ? pgeUsuRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeUsuRoles)) {
            return false;
        }
        PgeUsuRoles other = (PgeUsuRoles) object;
        if ((this.pgeUsuRolesPK == null && other.pgeUsuRolesPK != null) || (this.pgeUsuRolesPK != null && !this.pgeUsuRolesPK.equals(other.pgeUsuRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.PgeUsuRoles[ pgeUsuRolesPK=" + pgeUsuRolesPK + " ]";
    }
    
}
