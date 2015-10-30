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
public class PgeMenusPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_id", nullable = false)
    private int menId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_sub_id", nullable = false)
    private int menSubId;

    public PgeMenusPK() {
    }

    public PgeMenusPK(int menId, int menSubId) {
        this.menId = menId;
        this.menSubId = menSubId;
    }

    public int getMenId() {
        return menId;
    }

    public void setMenId(int menId) {
        this.menId = menId;
    }

    public int getMenSubId() {
        return menSubId;
    }

    public void setMenSubId(int menSubId) {
        this.menSubId = menSubId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) menId;
        hash += (int) menSubId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeMenusPK)) {
            return false;
        }
        PgeMenusPK other = (PgeMenusPK) object;
        if (this.menId != other.menId) {
            return false;
        }
        if (this.menSubId != other.menSubId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeMenusPK[ menId=" + menId + ", menSubId=" + menSubId + " ]";
    }
    
}
