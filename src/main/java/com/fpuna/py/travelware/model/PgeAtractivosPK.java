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

/**
 *
 * @author eencina
 */
@Embeddable
public class PgeAtractivosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pai_id", nullable = false)
    private int paiId;
    @Basic(optional = false)
    @Column(name = "ciu_id", nullable = false)
    private int ciuId;
    @Basic(optional = false)
    @Column(name = "atr_id", nullable = false)
    private int atrId;

    public PgeAtractivosPK() {
    }

    public PgeAtractivosPK(int paiId, int ciuId, int atrId) {
        this.paiId = paiId;
        this.ciuId = ciuId;
        this.atrId = atrId;
    }

    public int getPaiId() {
        return paiId;
    }

    public void setPaiId(int paiId) {
        this.paiId = paiId;
    }

    public int getCiuId() {
        return ciuId;
    }

    public void setCiuId(int ciuId) {
        this.ciuId = ciuId;
    }

    public int getAtrId() {
        return atrId;
    }

    public void setAtrId(int atrId) {
        this.atrId = atrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) paiId;
        hash += (int) ciuId;
        hash += (int) atrId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeAtractivosPK)) {
            return false;
        }
        PgeAtractivosPK other = (PgeAtractivosPK) object;
        if (this.paiId != other.paiId) {
            return false;
        }
        if (this.ciuId != other.ciuId) {
            return false;
        }
        if (this.atrId != other.atrId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeAtractivosPK[ paiId=" + paiId + ", ciuId=" + ciuId + ", atrId=" + atrId + " ]";
    }
    
}
