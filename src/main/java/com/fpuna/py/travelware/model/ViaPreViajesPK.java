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
public class ViaPreViajesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "via_id", nullable = false)
    private int viaId;
    @Basic(optional = false)
    @Column(name = "pre_id", nullable = false)
    private int preId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mon_id", nullable = false)
    private int monId;

    public ViaPreViajesPK() {
    }

    public ViaPreViajesPK(int viaId, int preId, int monId) {
        this.viaId = viaId;
        this.preId = preId;
        this.monId = monId;
    }

    public int getViaId() {
        return viaId;
    }

    public void setViaId(int viaId) {
        this.viaId = viaId;
    }

    public int getPreId() {
        return preId;
    }

    public void setPreId(int preId) {
        this.preId = preId;
    }

    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) viaId;
        hash += (int) preId;
        hash += (int) monId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPreViajesPK)) {
            return false;
        }
        ViaPreViajesPK other = (ViaPreViajesPK) object;
        if (this.viaId != other.viaId) {
            return false;
        }
        if (this.preId != other.preId) {
            return false;
        }
        if (this.monId != other.monId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaPreViajesPK[ viaId=" + viaId + ", preId=" + preId + ", monId=" + monId + " ]";
    }
    
}
