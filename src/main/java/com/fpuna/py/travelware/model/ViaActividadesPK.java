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
public class ViaActividadesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "via_id", nullable = false)
    private int viaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "act_ord", nullable = false)
    private int actOrd;

    public ViaActividadesPK() {
    }

    public ViaActividadesPK(int viaId, int actOrd) {
        this.viaId = viaId;
        this.actOrd = actOrd;
    }

    public int getViaId() {
        return viaId;
    }

    public void setViaId(int viaId) {
        this.viaId = viaId;
    }

    public int getActOrd() {
        return actOrd;
    }

    public void setActOrd(int actOrd) {
        this.actOrd = actOrd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) viaId;
        hash += (int) actOrd;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaActividadesPK)) {
            return false;
        }
        ViaActividadesPK other = (ViaActividadesPK) object;
        if (this.viaId != other.viaId) {
            return false;
        }
        if (this.actOrd != other.actOrd) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaActividadesPK[ viaId=" + viaId + ", actOrd=" + actOrd + " ]";
    }
    
}
