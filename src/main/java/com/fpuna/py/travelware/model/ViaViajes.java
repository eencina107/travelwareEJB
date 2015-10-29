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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "via_viajes", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViaViajes.findAll", query = "SELECT v FROM ViaViajes v"),
    @NamedQuery(name = "ViaViajes.findByViaId", query = "SELECT v FROM ViaViajes v WHERE v.viaId = :viaId"),
    @NamedQuery(name = "ViaViajes.findByViaDest", query = "SELECT v FROM ViaViajes v WHERE v.viaDest = :viaDest"),
    @NamedQuery(name = "ViaViajes.findByViaDesc", query = "SELECT v FROM ViaViajes v WHERE v.viaDesc = :viaDesc"),
    @NamedQuery(name = "ViaViajes.findByViaFecSali", query = "SELECT v FROM ViaViajes v WHERE v.viaFecSali = :viaFecSali"),
    @NamedQuery(name = "ViaViajes.findByViaFecReg", query = "SELECT v FROM ViaViajes v WHERE v.viaFecReg = :viaFecReg"),
    @NamedQuery(name = "ViaViajes.findByViaUsuIns", query = "SELECT v FROM ViaViajes v WHERE v.viaUsuIns = :viaUsuIns"),
    @NamedQuery(name = "ViaViajes.findByViaFecIns", query = "SELECT v FROM ViaViajes v WHERE v.viaFecIns = :viaFecIns"),
    @NamedQuery(name = "ViaViajes.findByViaUsuMod", query = "SELECT v FROM ViaViajes v WHERE v.viaUsuMod = :viaUsuMod"),
    @NamedQuery(name = "ViaViajes.findByViaFecMod", query = "SELECT v FROM ViaViajes v WHERE v.viaFecMod = :viaFecMod")})
public class ViaViajes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "via_id", nullable = false)
    private Integer viaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "via_dest", nullable = false, length = 50)
    private String viaDest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "via_desc", nullable = false, length = 2147483647)
    private String viaDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "via_fec_sali", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date viaFecSali;
    @Basic(optional = false)
    @NotNull
    @Column(name = "via_fec_reg", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date viaFecReg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "via_usu_ins", nullable = false, length = 10)
    private String viaUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "via_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date viaFecIns;
    @Size(max = 10)
    @Column(name = "via_usu_mod", length = 10)
    private String viaUsuMod;
    @Column(name = "via_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viaFecMod;
    @OneToMany(mappedBy = "viaId")
    private List<PagComprobantesDet> pagComprobantesDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaViajes")
    private List<ViaPreViajes> viaPreViajesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaViajes")
    private List<ViaActividades> viaActividadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaViajes")
    private List<ViaPasViajes> viaPasViajesList;

    public ViaViajes() {
    }

    public ViaViajes(Integer viaId) {
        this.viaId = viaId;
    }

    public ViaViajes(Integer viaId, String viaDest, String viaDesc, Date viaFecSali, Date viaFecReg, String viaUsuIns, Date viaFecIns) {
        this.viaId = viaId;
        this.viaDest = viaDest;
        this.viaDesc = viaDesc;
        this.viaFecSali = viaFecSali;
        this.viaFecReg = viaFecReg;
        this.viaUsuIns = viaUsuIns;
        this.viaFecIns = viaFecIns;
    }

    public Integer getViaId() {
        return viaId;
    }

    public void setViaId(Integer viaId) {
        this.viaId = viaId;
    }

    public String getViaDest() {
        return viaDest;
    }

    public void setViaDest(String viaDest) {
        this.viaDest = viaDest;
    }

    public String getViaDesc() {
        return viaDesc;
    }

    public void setViaDesc(String viaDesc) {
        this.viaDesc = viaDesc;
    }

    public Date getViaFecSali() {
        return viaFecSali;
    }

    public void setViaFecSali(Date viaFecSali) {
        this.viaFecSali = viaFecSali;
    }

    public Date getViaFecReg() {
        return viaFecReg;
    }

    public void setViaFecReg(Date viaFecReg) {
        this.viaFecReg = viaFecReg;
    }

    public String getViaUsuIns() {
        return viaUsuIns;
    }

    public void setViaUsuIns(String viaUsuIns) {
        this.viaUsuIns = viaUsuIns;
    }

    public Date getViaFecIns() {
        return viaFecIns;
    }

    public void setViaFecIns(Date viaFecIns) {
        this.viaFecIns = viaFecIns;
    }

    public String getViaUsuMod() {
        return viaUsuMod;
    }

    public void setViaUsuMod(String viaUsuMod) {
        this.viaUsuMod = viaUsuMod;
    }

    public Date getViaFecMod() {
        return viaFecMod;
    }

    public void setViaFecMod(Date viaFecMod) {
        this.viaFecMod = viaFecMod;
    }

    public List<PagComprobantesDet> getPagComprobantesDetList() {
        return pagComprobantesDetList;
    }

    public void setPagComprobantesDetList(List<PagComprobantesDet> pagComprobantesDetList) {
        this.pagComprobantesDetList = pagComprobantesDetList;
    }

    public List<ViaPreViajes> getViaPreViajesList() {
        return viaPreViajesList;
    }

    public void setViaPreViajesList(List<ViaPreViajes> viaPreViajesList) {
        this.viaPreViajesList = viaPreViajesList;
    }

    public List<ViaActividades> getViaActividadesList() {
        return viaActividadesList;
    }

    public void setViaActividadesList(List<ViaActividades> viaActividadesList) {
        this.viaActividadesList = viaActividadesList;
    }

    public List<ViaPasViajes> getViaPasViajesList() {
        return viaPasViajesList;
    }

    public void setViaPasViajesList(List<ViaPasViajes> viaPasViajesList) {
        this.viaPasViajesList = viaPasViajesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viaId != null ? viaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaViajes)) {
            return false;
        }
        ViaViajes other = (ViaViajes) object;
        if ((this.viaId == null && other.viaId != null) || (this.viaId != null && !this.viaId.equals(other.viaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaViajes[ viaId=" + viaId + " ]";
    }
    
}