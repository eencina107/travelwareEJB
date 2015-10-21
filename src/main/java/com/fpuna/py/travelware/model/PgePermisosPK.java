/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eencina
 */
@Embeddable
public class PgePermisosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID", nullable = false)
    private int rolId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MENU_ID", nullable = false)
    private int menuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBMENU_ID", nullable = false)
    private int submenuId;

    public PgePermisosPK() {
    }

    public PgePermisosPK(int rolId, int menuId, int submenuId) {
        this.rolId = rolId;
        this.menuId = menuId;
        this.submenuId = submenuId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getSubmenuId() {
        return submenuId;
    }

    public void setSubmenuId(int submenuId) {
        this.submenuId = submenuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rolId;
        hash += (int) menuId;
        hash += (int) submenuId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgePermisosPK)) {
            return false;
        }
        PgePermisosPK other = (PgePermisosPK) object;
        if (this.rolId != other.rolId) {
            return false;
        }
        if (this.menuId != other.menuId) {
            return false;
        }
        if (this.submenuId != other.submenuId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.dao.PgePermisosPK[ rolId=" + rolId + ", menuId=" + menuId + ", submenuId=" + submenuId + " ]";
    }
    
}
