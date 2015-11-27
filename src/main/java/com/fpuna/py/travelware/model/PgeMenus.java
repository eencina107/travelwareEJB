/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pge_menus", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"men_id", "men_sub_id"})})
@NamedQueries({
    @NamedQuery(name = "PgeMenus.findAll", query = "SELECT p FROM PgeMenus p"),
    @NamedQuery(name = "PgeMenus.findByMenId", query = "SELECT p FROM PgeMenus p WHERE p.menId = :menId"),
    @NamedQuery(name = "PgeMenus.findByMenSubId", query = "SELECT p FROM PgeMenus p WHERE p.menSubId = :menSubId"),
    @NamedQuery(name = "PgeMenus.findByMenDescripcion", query = "SELECT p FROM PgeMenus p WHERE p.menDescripcion = :menDescripcion"),
    @NamedQuery(name = "PgeMenus.findByMenTipo", query = "SELECT p FROM PgeMenus p WHERE p.menTipo = :menTipo"),
    @NamedQuery(name = "PgeMenus.findByMenUbicacion", query = "SELECT p FROM PgeMenus p WHERE p.menUbicacion = :menUbicacion"),
    @NamedQuery(name = "PgeMenus.findByMenUsuIns", query = "SELECT p FROM PgeMenus p WHERE p.menUsuIns = :menUsuIns"),
    @NamedQuery(name = "PgeMenus.findByMenFecIns", query = "SELECT p FROM PgeMenus p WHERE p.menFecIns = :menFecIns"),
    @NamedQuery(name = "PgeMenus.findByMenUsuMod", query = "SELECT p FROM PgeMenus p WHERE p.menUsuMod = :menUsuMod"),
    @NamedQuery(name = "PgeMenus.findByMenFecMod", query = "SELECT p FROM PgeMenus p WHERE p.menFecMod = :menFecMod"),
    @NamedQuery(name = "PgeMenus.findByMenCod", query = "SELECT p FROM PgeMenus p WHERE p.menCod = :menCod")})
public class PgeMenus implements Serializable, Comparable<PgeMenus> {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_id", nullable = false)
    private int menId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_sub_id", nullable = false)
    private int menSubId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "men_descripcion", nullable = false, length = 50)
    private String menDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_tipo", nullable = false)
    private Character menTipo;
    @Size(max = 50)
    @Column(name = "men_ubicacion", length = 50)
    private String menUbicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "men_usu_ins", nullable = false, length = 10)
    private String menUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date menFecIns;
    @Size(max = 10)
    @Column(name = "men_usu_mod", length = 10)
    private String menUsuMod;
    @Column(name = "men_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date menFecMod;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "men_cod", nullable = false)
    private Integer menCod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgeMenus")
    private List<PgePermisos> pgePermisosList;

    public PgeMenus() {
    }

    public PgeMenus(Integer menCod) {
        this.menCod = menCod;
    }

    public PgeMenus(Integer menCod, int menId, int menSubId, String menDescripcion, Character menTipo, String menUsuIns, Date menFecIns) {
        this.menCod = menCod;
        this.menId = menId;
        this.menSubId = menSubId;
        this.menDescripcion = menDescripcion;
        this.menTipo = menTipo;
        this.menUsuIns = menUsuIns;
        this.menFecIns = menFecIns;
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

    public String getMenUbicacion() {
        return menUbicacion;
    }

    public void setMenUbicacion(String menUbicacion) {
        this.menUbicacion = menUbicacion;
    }

    public String getMenUsuIns() {
        return menUsuIns;
    }

    public void setMenUsuIns(String menUsuIns) {
        this.menUsuIns = menUsuIns;
    }

    public Date getMenFecIns() {
        return menFecIns;
    }

    public void setMenFecIns(Date menFecIns) {
        this.menFecIns = menFecIns;
    }

    public String getMenUsuMod() {
        return menUsuMod;
    }

    public void setMenUsuMod(String menUsuMod) {
        this.menUsuMod = menUsuMod;
    }

    public Date getMenFecMod() {
        return menFecMod;
    }

    public void setMenFecMod(Date menFecMod) {
        this.menFecMod = menFecMod;
    }

    public Integer getMenCod() {
        return menCod;
    }

    public void setMenCod(Integer menCod) {
        this.menCod = menCod;
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
        hash += (menCod != null ? menCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeMenus)) {
            return false;
        }
        PgeMenus other = (PgeMenus) object;
        if ((this.menCod == null && other.menCod != null) || (this.menCod != null && !this.menCod.equals(other.menCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeMenus[ menCod=" + menCod + " ]";
    }

    @Override
    public int compareTo(PgeMenus m) {
        if (menId < m.getMenId()) {
            return -1;
        }
        else if (menId > m.getMenId()){
            return 1;
        }
        else{
            if (menSubId < m.getMenSubId()){
                return -1;
            }
            else if (menSubId > m.getMenSubId()){
                return 1;
            }
            else{
                return 0;
            }
        }
           
    }
    
}
