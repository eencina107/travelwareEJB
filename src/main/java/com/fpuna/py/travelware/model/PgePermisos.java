/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pge_permisos", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgePermisos.findAll", query = "SELECT p FROM PgePermisos p"),
    @NamedQuery(name = "PgePermisos.findByRolId", query = "SELECT p FROM PgePermisos p WHERE p.pgePermisosPK.rolId = :rolId"),
    @NamedQuery(name = "PgePermisos.findByMenuId", query = "SELECT p FROM PgePermisos p WHERE p.pgePermisosPK.menuId = :menuId"),
    @NamedQuery(name = "PgePermisos.findBySubmenuId", query = "SELECT p FROM PgePermisos p WHERE p.pgePermisosPK.submenuId = :submenuId")})
public class PgePermisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PgePermisosPK pgePermisosPK;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PgeRoles pgeRoles;

    public PgePermisos() {
    }

    public PgePermisos(PgePermisosPK pgePermisosPK) {
        this.pgePermisosPK = pgePermisosPK;
    }

    public PgePermisos(int rolId, int menuId, int submenuId) {
        this.pgePermisosPK = new PgePermisosPK(rolId, menuId, submenuId);
    }

    public PgePermisosPK getPgePermisosPK() {
        return pgePermisosPK;
    }

    public void setPgePermisosPK(PgePermisosPK pgePermisosPK) {
        this.pgePermisosPK = pgePermisosPK;
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
        hash += (pgePermisosPK != null ? pgePermisosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgePermisos)) {
            return false;
        }
        PgePermisos other = (PgePermisos) object;
        if ((this.pgePermisosPK == null && other.pgePermisosPK != null) || (this.pgePermisosPK != null && !this.pgePermisosPK.equals(other.pgePermisosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgePermisos[ pgePermisosPK=" + pgePermisosPK + " ]";
    }
    
}
