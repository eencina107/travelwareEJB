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
public class ViaPasaportesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID")
    private int perId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAT_NRO_SEC")
    private int patNroSec;

    public ViaPasaportesPK() {
    }

    public ViaPasaportesPK(int perId, int patNroSec) {
        this.perId = perId;
        this.patNroSec = patNroSec;
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public int getPatNroSec() {
        return patNroSec;
    }

    public void setPatNroSec(int patNroSec) {
        this.patNroSec = patNroSec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) perId;
        hash += (int) patNroSec;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPasaportesPK)) {
            return false;
        }
        ViaPasaportesPK other = (ViaPasaportesPK) object;
        if (this.perId != other.perId) {
            return false;
        }
        if (this.patNroSec != other.patNroSec) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.ViaPasaportesPK[ perId=" + perId + ", patNroSec=" + patNroSec + " ]";
    }
    
}
