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
public class ViaFidelidadesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_id", nullable = false)
    private int perId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "org_id", nullable = false)
    private int orgId;

    public ViaFidelidadesPK() {
    }

    public ViaFidelidadesPK(int perId, int orgId) {
        this.perId = perId;
        this.orgId = orgId;
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) perId;
        hash += (int) orgId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaFidelidadesPK)) {
            return false;
        }
        ViaFidelidadesPK other = (ViaFidelidadesPK) object;
        if (this.perId != other.perId) {
            return false;
        }
        if (this.orgId != other.orgId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaFidelidadesPK[ perId=" + perId + ", orgId=" + orgId + " ]";
    }
    
}
