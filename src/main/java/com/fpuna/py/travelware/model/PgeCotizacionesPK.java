/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eencina
 */
@Embeddable
public class PgeCotizacionesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "MON_ID")
    private int monId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COT_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cotFecha;

    public PgeCotizacionesPK() {
    }

    public PgeCotizacionesPK(int monId, Date cotFecha) {
        this.monId = monId;
        this.cotFecha = cotFecha;
    }

    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public Date getCotFecha() {
        return cotFecha;
    }

    public void setCotFecha(Date cotFecha) {
        this.cotFecha = cotFecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) monId;
        hash += (cotFecha != null ? cotFecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeCotizacionesPK)) {
            return false;
        }
        PgeCotizacionesPK other = (PgeCotizacionesPK) object;
        if (this.monId != other.monId) {
            return false;
        }
        if ((this.cotFecha == null && other.cotFecha != null) || (this.cotFecha != null && !this.cotFecha.equals(other.cotFecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.PgeCotizacionesPK[ monId=" + monId + ", cotFecha=" + cotFecha + " ]";
    }
    
}
