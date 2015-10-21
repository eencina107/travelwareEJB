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
public class ViaPasViajesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "VIA_ID")
    private int viaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID")
    private int perId;

    public ViaPasViajesPK() {
    }

    public ViaPasViajesPK(int viaId, int perId) {
        this.viaId = viaId;
        this.perId = perId;
    }

    public int getViaId() {
        return viaId;
    }

    public void setViaId(int viaId) {
        this.viaId = viaId;
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) viaId;
        hash += (int) perId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPasViajesPK)) {
            return false;
        }
        ViaPasViajesPK other = (ViaPasViajesPK) object;
        if (this.viaId != other.viaId) {
            return false;
        }
        if (this.perId != other.perId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.ViaPasViajesPK[ viaId=" + viaId + ", perId=" + perId + " ]";
    }
    
}
