/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "via_pre_viajes", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"via_id", "mon_id"})})
@NamedQueries({
    @NamedQuery(name = "ViaPreViajes.findAll", query = "SELECT v FROM ViaPreViajes v"),
    @NamedQuery(name = "ViaPreViajes.findByPreId", query = "SELECT v FROM ViaPreViajes v WHERE v.preId = :preId"),
    @NamedQuery(name = "ViaPreViajes.findByPrePrecio", query = "SELECT v FROM ViaPreViajes v WHERE v.prePrecio = :prePrecio"),
    @NamedQuery(name = "ViaPreViajes.findByPreNombre", query = "SELECT v FROM ViaPreViajes v WHERE v.preNombre = :preNombre"),
    @NamedQuery(name = "ViaPreViajes.findByPreDescripcion", query = "SELECT v FROM ViaPreViajes v WHERE v.preDescripcion = :preDescripcion")})
public class ViaPreViajes implements Serializable {
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "viaPreViajes")
    private ViaPasajeros viaPasajeros;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pre_id", nullable = false)
    private Integer preId;
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
    @JoinColumn(name = "via_id", referencedColumnName = "via_id", nullable = false)
    @ManyToOne(optional = false)
    private ViaViajes viaId;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeMonedas monId;

    public ViaPreViajes() {
    }

    public ViaPreViajes(Integer preId) {
        this.preId = preId;
    }

    public ViaPreViajes(Integer preId, BigDecimal prePrecio, String preNombre) {
        this.preId = preId;
        this.prePrecio = prePrecio;
        this.preNombre = preNombre;
    }

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
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

    public ViaViajes getViaId() {
        return viaId;
    }

    public void setViaId(ViaViajes viaId) {
        this.viaId = viaId;
    }

    public PgeMonedas getMonId() {
        return monId;
    }

    public void setMonId(PgeMonedas monId) {
        this.monId = monId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preId != null ? preId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPreViajes)) {
            return false;
        }
        ViaPreViajes other = (ViaPreViajes) object;
        if ((this.preId == null && other.preId != null) || (this.preId != null && !this.preId.equals(other.preId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaPreViajes[ preId=" + preId + " ]";
    }

    public ViaPasajeros getViaPasajeros() {
        return viaPasajeros;
    }

    public void setViaPasajeros(ViaPasajeros viaPasajeros) {
        this.viaPasajeros = viaPasajeros;
    }
    
}
