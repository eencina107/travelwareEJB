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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pge_usu_roles", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rol_id", "usu_id"})})
@NamedQueries({
    @NamedQuery(name = "PgeUsuRoles.findAll", query = "SELECT p FROM PgeUsuRoles p"),
    @NamedQuery(name = "PgeUsuRoles.findByUroUsuIns", query = "SELECT p FROM PgeUsuRoles p WHERE p.uroUsuIns = :uroUsuIns"),
    @NamedQuery(name = "PgeUsuRoles.findByUroFecIns", query = "SELECT p FROM PgeUsuRoles p WHERE p.uroFecIns = :uroFecIns"),
    @NamedQuery(name = "PgeUsuRoles.findByUroUsuMod", query = "SELECT p FROM PgeUsuRoles p WHERE p.uroUsuMod = :uroUsuMod"),
    @NamedQuery(name = "PgeUsuRoles.findByUroFecMod", query = "SELECT p FROM PgeUsuRoles p WHERE p.uroFecMod = :uroFecMod"),
    @NamedQuery(name = "PgeUsuRoles.findByUsuRolId", query = "SELECT p FROM PgeUsuRoles p WHERE p.usuRolId = :usuRolId")})
    @NamedQuery(name = "PgeUsuRoles.findByUsuId", query = "SELECT p FROM PgeUsuRoles p WHERE p.usuId.usuId = :usuId")
public class PgeUsuRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "uro_usu_ins", nullable = false, length = 10)
    private String uroUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uro_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date uroFecIns;
    @Size(max = 10)
    @Column(name = "uro_usu_mod", length = 10)
    private String uroUsuMod;
    @Column(name = "uro_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uroFecMod;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_rol_id", nullable = false)
    private Integer usuRolId;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeUsuarios usuId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeRoles rolId;

    public PgeUsuRoles() {
    }

    public PgeUsuRoles(Integer usuRolId) {
        this.usuRolId = usuRolId;
    }

    public PgeUsuRoles(Integer usuRolId, String uroUsuIns, Date uroFecIns) {
        this.usuRolId = usuRolId;
        this.uroUsuIns = uroUsuIns;
        this.uroFecIns = uroFecIns;
    }

    public String getUroUsuIns() {
        return uroUsuIns;
    }

    public void setUroUsuIns(String uroUsuIns) {
        this.uroUsuIns = uroUsuIns;
    }

    public Date getUroFecIns() {
        return uroFecIns;
    }

    public void setUroFecIns(Date uroFecIns) {
        this.uroFecIns = uroFecIns;
    }

    public String getUroUsuMod() {
        return uroUsuMod;
    }

    public void setUroUsuMod(String uroUsuMod) {
        this.uroUsuMod = uroUsuMod;
    }

    public Date getUroFecMod() {
        return uroFecMod;
    }

    public void setUroFecMod(Date uroFecMod) {
        this.uroFecMod = uroFecMod;
    }

    public Integer getUsuRolId() {
        return usuRolId;
    }

    public void setUsuRolId(Integer usuRolId) {
        this.usuRolId = usuRolId;
    }

    public PgeUsuarios getUsuId() {
        return usuId;
    }

    public void setUsuId(PgeUsuarios usuId) {
        this.usuId = usuId;
    }

    public PgeRoles getRolId() {
        return rolId;
    }

    public void setRolId(PgeRoles rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuRolId != null ? usuRolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeUsuRoles)) {
            return false;
        }
        PgeUsuRoles other = (PgeUsuRoles) object;
        if ((this.usuRolId == null && other.usuRolId != null) || (this.usuRolId != null && !this.usuRolId.equals(other.usuRolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeUsuRoles[ usuRolId=" + usuRolId + " ]";
    }
    
}
