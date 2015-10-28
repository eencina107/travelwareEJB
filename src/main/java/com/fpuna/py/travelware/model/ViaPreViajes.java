/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "via_pre_viajes", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViaPreViajes.findAll", query = "SELECT v FROM ViaPreViajes v"),
    @NamedQuery(name = "ViaPreViajes.findByViaId", query = "SELECT v FROM ViaPreViajes v WHERE v.viaPreViajesPK.viaId = :viaId"),
    @NamedQuery(name = "ViaPreViajes.findByPreId", query = "SELECT v FROM ViaPreViajes v WHERE v.viaPreViajesPK.preId = :preId"),
    @NamedQuery(name = "ViaPreViajes.findByMonId", query = "SELECT v FROM ViaPreViajes v WHERE v.viaPreViajesPK.monId = :monId"),
    @NamedQuery(name = "ViaPreViajes.findByPrePrecio", query = "SELECT v FROM ViaPreViajes v WHERE v.prePrecio = :prePrecio"),
    @NamedQuery(name = "ViaPreViajes.findByPreNombre", query = "SELECT v FROM ViaPreViajes v WHERE v.preNombre = :preNombre"),
    @NamedQuery(name = "ViaPreViajes.findByPreDescripcion", query = "SELECT v FROM ViaPreViajes v WHERE v.preDescripcion = :preDescripcion")})
public class ViaPreViajes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ViaPreViajesPK viaPreViajesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "pre_precio", nullable = false, precision = 18, scale = 2)
    private BigDecimal prePrecio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pre_nombre", nullable = false, length = 10)
    private String preNombre;
    @Size(max = 2147483647)
    @Column(name = "pre_descripcion", length = 2147483647)
    private String preDescripcion;
    @JoinColumn(name = "via_id", referencedColumnName = "via_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ViaViajes viaViajes;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PgeMonedas pgeMonedas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaPreViajes")
    private List<ViaPasViajes> viaPasViajesList;

    public ViaPreViajes() {
    }

    public ViaPreViajes(ViaPreViajesPK viaPreViajesPK) {
        this.viaPreViajesPK = viaPreViajesPK;
    }

    public ViaPreViajes(ViaPreViajesPK viaPreViajesPK, BigDecimal prePrecio, String preNombre) {
        this.viaPreViajesPK = viaPreViajesPK;
        this.prePrecio = prePrecio;
        this.preNombre = preNombre;
    }

    public ViaPreViajes(int viaId, int preId, int monId) {
        this.viaPreViajesPK = new ViaPreViajesPK(viaId, preId, monId);
    }

    public ViaPreViajesPK getViaPreViajesPK() {
        return viaPreViajesPK;
    }

    public void setViaPreViajesPK(ViaPreViajesPK viaPreViajesPK) {
        this.viaPreViajesPK = viaPreViajesPK;
    }

    public BigDecimal getPrePrecio() {
        return prePrecio;
    }

    public void setPrePrecio(BigDecimal prePrecio) {
        this.prePrecio = prePrecio;
    }

    public String getPreNombre() {
        return preNombre;
    }

    public void setPreNombre(String preNombre) {
        this.preNombre = preNombre;
    }

    public String getPreDescripcion() {
        return preDescripcion;
    }

    public void setPreDescripcion(String preDescripcion) {
        this.preDescripcion = preDescripcion;
    }

    public ViaViajes getViaViajes() {
        return viaViajes;
    }

    public void setViaViajes(ViaViajes viaViajes) {
        this.viaViajes = viaViajes;
    }

    public PgeMonedas getPgeMonedas() {
        return pgeMonedas;
    }

    public void setPgeMonedas(PgeMonedas pgeMonedas) {
        this.pgeMonedas = pgeMonedas;
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
        hash += (viaPreViajesPK != null ? viaPreViajesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPreViajes)) {
            return false;
        }
        ViaPreViajes other = (ViaPreViajes) object;
        if ((this.viaPreViajesPK == null && other.viaPreViajesPK != null) || (this.viaPreViajesPK != null && !this.viaPreViajesPK.equals(other.viaPreViajesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaPreViajes[ viaPreViajesPK=" + viaPreViajesPK + " ]";
    }
    
}
