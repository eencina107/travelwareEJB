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
public class PagComprobantesDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COM_ID", nullable = false)
    private int comId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDE_NRO_DET", nullable = false)
    private int cdeNroDet;

    public PagComprobantesDetPK() {
    }

    public PagComprobantesDetPK(int comId, int cdeNroDet) {
        this.comId = comId;
        this.cdeNroDet = cdeNroDet;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public int getCdeNroDet() {
        return cdeNroDet;
    }

    public void setCdeNroDet(int cdeNroDet) {
        this.cdeNroDet = cdeNroDet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) comId;
        hash += (int) cdeNroDet;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagComprobantesDetPK)) {
            return false;
        }
        PagComprobantesDetPK other = (PagComprobantesDetPK) object;
        if (this.comId != other.comId) {
            return false;
        }
        if (this.cdeNroDet != other.cdeNroDet) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PagComprobantesDetPK[ comId=" + comId + ", cdeNroDet=" + cdeNroDet + " ]";
    }
    
}
