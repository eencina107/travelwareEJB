/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author damia_000
 */
@Entity
@Table(name = "via_viajes_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViaViajesDet.findAll", query = "SELECT v FROM ViaViajesDet v"),
    @NamedQuery(name = "ViaViajesDet.findByVidId", query = "SELECT v FROM ViaViajesDet v WHERE v.vidId = :vidId"),
    @NamedQuery(name = "ViaViajesDet.findByVidDesc", query = "SELECT v FROM ViaViajesDet v WHERE v.vidDesc = :vidDesc"),
    @NamedQuery(name = "ViaViajesDet.findByVidCantTot", query = "SELECT v FROM ViaViajesDet v WHERE v.vidCantTot = :vidCantTot"),
    @NamedQuery(name = "ViaViajesDet.findByVidCantVend", query = "SELECT v FROM ViaViajesDet v WHERE v.vidCantVend = :vidCantVend"),
    @NamedQuery(name = "ViaViajesDet.findByVidTip", query = "SELECT v FROM ViaViajesDet v WHERE v.vidTip = :vidTip")})
public class ViaViajesDet implements Serializable {
    @Column(name = "vid_tip")
    private Character vidTip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vid_monto")
    private BigDecimal vidMonto;
    @Column(name = "vid_cant_vend")
    private Integer vidCantVend;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "vid_usu_ins")
    private String vidUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vid_fec_ins")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vidFecIns;
    @Size(max = 10)
    @Column(name = "vid_usu_mod")
    private String vidUsuMod;
    @Column(name = "vid_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vidFecMod;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vid_id")
    private Integer vidId;
    @Size(max = 100)
    @Column(name = "vid_desc")
    private String vidDesc;
    @Column(name = "vid_cant_tot")
    private Integer vidCantTot;
    @JoinColumn(name = "fad_id", referencedColumnName = "fad_id")
    @ManyToOne
    private ComFacturasDet fadId;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id")
    @ManyToOne
    private PgeMonedas monId;
    @JoinColumn(name = "con_id", referencedColumnName = "con_id")
    @ManyToOne(optional = false)
    private ViaConceptos conId;
    @JoinColumn(name = "via_id", referencedColumnName = "via_id")
    @ManyToOne(optional = false)
    private ViaViajes viaId;

    public ViaViajesDet() {
    }

    public ViaViajesDet(Integer vidId) {
        this.vidId = vidId;
    }

    public Integer getVidId() {
        return vidId;
    }

    public void setVidId(Integer vidId) {
        this.vidId = vidId;
    }

    public String getVidDesc() {
        return vidDesc;
    }

    public void setVidDesc(String vidDesc) {
        this.vidDesc = vidDesc;
    }

    public Integer getVidCantTot() {
        return vidCantTot;
    }

    public void setVidCantTot(Integer vidCantTot) {
        this.vidCantTot = vidCantTot;
    }

    public ComFacturasDet getFadId() {
        return fadId;
    }

    public void setFadId(ComFacturasDet fadId) {
        this.fadId = fadId;
    }

    public PgeMonedas getMonId() {
        return monId;
    }

    public void setMonId(PgeMonedas monId) {
        this.monId = monId;
    }

    public ViaConceptos getConId() {
        return conId;
    }

    public void setConId(ViaConceptos conId) {
        this.conId = conId;
    }

    public ViaViajes getViaId() {
        return viaId;
    }

    public void setViaId(ViaViajes viaId) {
        this.viaId = viaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vidId != null ? vidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaViajesDet)) {
            return false;
        }
        ViaViajesDet other = (ViaViajesDet) object;
        if ((this.vidId == null && other.vidId != null) || (this.vidId != null && !this.vidId.equals(other.vidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaViajesDet[ vidId=" + vidId + " ]";
    }

    public String getVidUsuIns() {
        return vidUsuIns;
    }

    public void setVidUsuIns(String vidUsuIns) {
        this.vidUsuIns = vidUsuIns;
    }

    public Date getVidFecIns() {
        return vidFecIns;
    }

    public void setVidFecIns(Date vidFecIns) {
        this.vidFecIns = vidFecIns;
    }

    public String getVidUsuMod() {
        return vidUsuMod;
    }

    public void setVidUsuMod(String vidUsuMod) {
        this.vidUsuMod = vidUsuMod;
    }

    public Date getVidFecMod() {
        return vidFecMod;
    }

    public void setVidFecMod(Date vidFecMod) {
        this.vidFecMod = vidFecMod;
    }

    public Integer getVidCantVend() {
        return vidCantVend;
    }

    public void setVidCantVend(Integer vidCantVend) {
        this.vidCantVend = vidCantVend;
    }

    public BigDecimal getVidMonto() {
        return vidMonto;
    }

    public void setVidMonto(BigDecimal vidMonto) {
        this.vidMonto = vidMonto;
    }

    public Character getVidTip() {
        return vidTip;
    }

    public void setVidTip(Character vidTip) {
        this.vidTip = vidTip;
    }
    
}
