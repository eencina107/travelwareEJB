/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pge_secuencias", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgeSecuencias.findAll", query = "SELECT p FROM PgeSecuencias p"),
    @NamedQuery(name = "PgeSecuencias.findBySecTabla", query = "SELECT p FROM PgeSecuencias p WHERE p.secTabla = :secTabla"),
    @NamedQuery(name = "PgeSecuencias.findBySecOrden", query = "SELECT p FROM PgeSecuencias p WHERE p.secOrden = :secOrden"),
    @NamedQuery(name = "PgeSecuencias.findBySecId", query = "SELECT p FROM PgeSecuencias p WHERE p.secId = :secId")})
public class PgeSecuencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "sec_tabla", length = 20)
    private String secTabla;
    @Column(name = "sec_orden")
    private Integer secOrden;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sec_id", nullable = false)
    private Integer secId;

    public PgeSecuencias() {
    }

    public PgeSecuencias(Integer secId) {
        this.secId = secId;
    }

    public String getSecTabla() {
        return secTabla;
    }

    public void setSecTabla(String secTabla) {
        this.secTabla = secTabla;
    }

    public Integer getSecOrden() {
        return secOrden;
    }

    public void setSecOrden(Integer secOrden) {
        this.secOrden = secOrden;
    }

    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secId != null ? secId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeSecuencias)) {
            return false;
        }
        PgeSecuencias other = (PgeSecuencias) object;
        if ((this.secId == null && other.secId != null) || (this.secId != null && !this.secId.equals(other.secId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeSecuencias[ secId=" + secId + " ]";
    }
    
}
