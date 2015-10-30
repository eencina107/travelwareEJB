/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pge_menus", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgeMenus.findAll", query = "SELECT p FROM PgeMenus p"),
    @NamedQuery(name = "PgeMenus.findByMenId", query = "SELECT p FROM PgeMenus p WHERE p.pgeMenusPK.menId = :menId"),
    @NamedQuery(name = "PgeMenus.findByMenSubId", query = "SELECT p FROM PgeMenus p WHERE p.pgeMenusPK.menSubId = :menSubId"),
    @NamedQuery(name = "PgeMenus.findByMenDescripcion", query = "SELECT p FROM PgeMenus p WHERE p.menDescripcion = :menDescripcion"),
    @NamedQuery(name = "PgeMenus.findByMenTipo", query = "SELECT p FROM PgeMenus p WHERE p.menTipo = :menTipo")})
public class PgeMenus implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PgeMenusPK pgeMenusPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "men_descripcion", nullable = false, length = 50)
    private String menDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_tipo", nullable = false)
    private Character menTipo;
    @JoinTable(name = "pge_permisos", joinColumns = {
        @JoinColumn(name = "men_id", referencedColumnName = "men_id", nullable = false),
        @JoinColumn(name = "men_sub_id", referencedColumnName = "men_sub_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "rol_id", referencedColumnName = "rol_id", nullable = false)})
    @ManyToMany
    private List<PgeRoles> pgeRolesList;

    public PgeMenus() {
    }

    public PgeMenus(PgeMenusPK pgeMenusPK) {
        this.pgeMenusPK = pgeMenusPK;
    }

    public PgeMenus(PgeMenusPK pgeMenusPK, String menDescripcion, Character menTipo) {
        this.pgeMenusPK = pgeMenusPK;
        this.menDescripcion = menDescripcion;
        this.menTipo = menTipo;
    }

    public PgeMenus(int menId, int menSubId) {
        this.pgeMenusPK = new PgeMenusPK(menId, menSubId);
    }

    public PgeMenusPK getPgeMenusPK() {
        return pgeMenusPK;
    }

    public void setPgeMenusPK(PgeMenusPK pgeMenusPK) {
        this.pgeMenusPK = pgeMenusPK;
    }

    public String getMenDescripcion() {
        return menDescripcion;
    }

    public void setMenDescripcion(String menDescripcion) {
        this.menDescripcion = menDescripcion;
    }

    public Character getMenTipo() {
        return menTipo;
    }

    public void setMenTipo(Character menTipo) {
        this.menTipo = menTipo;
    }

    public List<PgeRoles> getPgeRolesList() {
        return pgeRolesList;
    }

    public void setPgeRolesList(List<PgeRoles> pgeRolesList) {
        this.pgeRolesList = pgeRolesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgeMenusPK != null ? pgeMenusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeMenus)) {
            return false;
        }
        PgeMenus other = (PgeMenus) object;
        if ((this.pgeMenusPK == null && other.pgeMenusPK != null) || (this.pgeMenusPK != null && !this.pgeMenusPK.equals(other.pgeMenusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeMenus[ pgeMenusPK=" + pgeMenusPK + " ]";
    }
    
}