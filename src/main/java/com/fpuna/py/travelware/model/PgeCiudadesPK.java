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
public class PgeCiudadesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ciu_id", nullable = false)
    private int ciuId;
    @Basic(optional = false)
    @Column(name = "pai_id", nullable = false)
    private int paiId;

    public PgeCiudadesPK() {
    }

    public PgeCiudadesPK(int ciuId, int paiId) {
        this.ciuId = ciuId;
        this.paiId = paiId;
    }

    public int getCiuId() {
        return ciuId;
    }

    public void setCiuId(int ciuId) {
        this.ciuId = ciuId;
    }

    public int getPaiId() {
        return paiId;
    }

    public void setPaiId(int paiId) {
        this.paiId = paiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ciuId;
        hash += (int) paiId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeCiudadesPK)) {
            return false;
        }
        PgeCiudadesPK other = (PgeCiudadesPK) object;
        if (this.ciuId != other.ciuId) {
            return false;
        }
        if (this.paiId != other.paiId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeCiudadesPK[ ciuId=" + ciuId + ", paiId=" + paiId + " ]";
    }
    
}
