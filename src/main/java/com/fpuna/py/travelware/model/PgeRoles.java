/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pge_roles", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgeRoles.findAll", query = "SELECT p FROM PgeRoles p"),
    @NamedQuery(name = "PgeRoles.findByRolId", query = "SELECT p FROM PgeRoles p WHERE p.rolId = :rolId"),
    @NamedQuery(name = "PgeRoles.findByRolDesc", query = "SELECT p FROM PgeRoles p WHERE p.rolDesc = :rolDesc"),
    @NamedQuery(name = "PgeRoles.findByRolUsuIns", query = "SELECT p FROM PgeRoles p WHERE p.rolUsuIns = :rolUsuIns"),
    @NamedQuery(name = "PgeRoles.findByRolFecIns", query = "SELECT p FROM PgeRoles p WHERE p.rolFecIns = :rolFecIns"),
    @NamedQuery(name = "PgeRoles.findByRolUsuMod", query = "SELECT p FROM PgeRoles p WHERE p.rolUsuMod = :rolUsuMod"),
    @NamedQuery(name = "PgeRoles.findByRolFecMod", query = "SELECT p FROM PgeRoles p WHERE p.rolFecMod = :rolFecMod")})
public class PgeRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id", nullable = false)
    private Integer rolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "rol_desc", nullable = false, length = 35)
    private String rolDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rol_usu_ins", nullable = false, length = 10)
    private String rolUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rolFecIns;
    @Size(max = 10)
    @Column(name = "rol_usu_mod", length = 10)
    private String rolUsuMod;
    @Column(name = "rol_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rolFecMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private List<PgePermisos> pgePermisosList;

    public PgeRoles() {
    }

    public PgeRoles(Integer rolId) {
        this.rolId = rolId;
    }

    public PgeRoles(Integer rolId, String rolDesc, String rolUsuIns, Date rolFecIns) {
        this.rolId = rolId;
        this.rolDesc = rolDesc;
        this.rolUsuIns = rolUsuIns;
        this.rolFecIns = rolFecIns;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolDesc() {
        return rolDesc;
    }

    public void setRolDesc(String rolDesc) {
        this.rolDesc = rolDesc;
    }

    public String getRolUsuIns() {
        return rolUsuIns;
    }

    public void setRolUsuIns(String rolUsuIns) {
        this.rolUsuIns = rolUsuIns;
    }

    public Date getRolFecIns() {
        return rolFecIns;
    }

    public void setRolFecIns(Date rolFecIns) {
        this.rolFecIns = rolFecIns;
    }

    public String getRolUsuMod() {
        return rolUsuMod;
    }

    public void setRolUsuMod(String rolUsuMod) {
        this.rolUsuMod = rolUsuMod;
    }

    public Date getRolFecMod() {
        return rolFecMod;
    }

    public void setRolFecMod(Date rolFecMod) {
        this.rolFecMod = rolFecMod;
    }

    public List<PgePermisos> getPgePermisosList() {
        return pgePermisosList;
    }

    public void setPgePermisosList(List<PgePermisos> pgePermisosList) {
        this.pgePermisosList = pgePermisosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeRoles)) {
            return false;
        }
        PgeRoles other = (PgeRoles) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeRoles[ rolId=" + rolId + " ]";
    }
    
    public List<PgeMenus> getPgeMenusList(){
        Iterator i = this.pgePermisosList.iterator();
        List<PgeMenus> menus = new ArrayList();
        PgePermisos permisoAct;
        while (i.hasNext()){
            permisoAct = (PgePermisos) i.next();
            menus.add(permisoAct.getPgeMenus());
        }
        return menus;
    }
    
}
