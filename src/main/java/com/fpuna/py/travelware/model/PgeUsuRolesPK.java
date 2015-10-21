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
public class PgeUsuRolesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID")
    private int rolId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID")
    private int usuId;

    public PgeUsuRolesPK() {
    }

    public PgeUsuRolesPK(int rolId, int usuId) {
        this.rolId = rolId;
        this.usuId = usuId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rolId;
        hash += (int) usuId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeUsuRolesPK)) {
            return false;
        }
        PgeUsuRolesPK other = (PgeUsuRolesPK) object;
        if (this.rolId != other.rolId) {
            return false;
        }
        if (this.usuId != other.usuId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.PgeUsuRolesPK[ rolId=" + rolId + ", usuId=" + usuId + " ]";
    }
    
}
