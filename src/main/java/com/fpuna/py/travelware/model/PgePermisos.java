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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pge_permisos", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgePermisos.findAll", query = "SELECT p FROM PgePermisos p"),
    @NamedQuery(name = "PgePermisos.findByPrmId", query = "SELECT p FROM PgePermisos p WHERE p.prmId = :prmId")})
public class PgePermisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prm_id", nullable = false)
    private Integer prmId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeRoles rolId;
    @JoinColumns({
        @JoinColumn(name = "men_id", referencedColumnName = "men_id", nullable = false),
        @JoinColumn(name = "men_sub_id", referencedColumnName = "men_sub_id", nullable = false)})
    @ManyToOne(optional = false)
    private PgeMenus pgeMenus;

    public PgePermisos() {
    }

    public PgePermisos(Integer prmId) {
        this.prmId = prmId;
    }

    public Integer getPrmId() {
        return prmId;
    }

    public void setPrmId(Integer prmId) {
        this.prmId = prmId;
    }

    public PgeRoles getRolId() {
        return rolId;
    }

    public void setRolId(PgeRoles rolId) {
        this.rolId = rolId;
    }

    public PgeMenus getPgeMenus() {
        return pgeMenus;
    }

    public void setPgeMenus(PgeMenus pgeMenus) {
        this.pgeMenus = pgeMenus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prmId != null ? prmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgePermisos)) {
            return false;
        }
        PgePermisos other = (PgePermisos) object;
        if ((this.prmId == null && other.prmId != null) || (this.prmId != null && !this.prmId.equals(other.prmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgePermisos[ prmId=" + prmId + " ]";
    }
    
}
