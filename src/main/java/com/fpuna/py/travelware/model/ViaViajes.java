/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "via_viajes", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViaViajes.findAll", query = "SELECT v FROM ViaViajes v"),
    @NamedQuery(name = "ViaViajes.findByViaId", query = "SELECT v FROM ViaViajes v WHERE v.viaId = :viaId"),
    @NamedQuery(name = "ViaViajes.findByViaDesc", query = "SELECT v FROM ViaViajes v WHERE v.viaDesc = :viaDesc"),
    @NamedQuery(name = "ViaViajes.findByViaFecSali", query = "SELECT v FROM ViaViajes v WHERE v.viaFecSali = :viaFecSali"),
    @NamedQuery(name = "ViaViajes.findByViaFecReg", query = "SELECT v FROM ViaViajes v WHERE v.viaFecReg = :viaFecReg"),
    @NamedQuery(name = "ViaViajes.findByViaUsuIns", query = "SELECT v FROM ViaViajes v WHERE v.viaUsuIns = :viaUsuIns"),
    @NamedQuery(name = "ViaViajes.findByViaFecIns", query = "SELECT v FROM ViaViajes v WHERE v.viaFecIns = :viaFecIns"),
    @NamedQuery(name = "ViaViajes.findByViaUsuMod", query = "SELECT v FROM ViaViajes v WHERE v.viaUsuMod = :viaUsuMod"),
    @NamedQuery(name = "ViaViajes.findByViaFecMod", query = "SELECT v FROM ViaViajes v WHERE v.viaFecMod = :viaFecMod"),
    @NamedQuery(name = "ViaViajes.findByViaCost", query = "SELECT v FROM ViaViajes v WHERE v.viaCost = :viaCost"),
    @NamedQuery(name = "ViaViajes.findByViaCantTot", query = "SELECT v FROM ViaViajes v WHERE v.viaCantTot = :viaCantTot"),
    @NamedQuery(name = "ViaViajes.findByViaCantVend", query = "SELECT v FROM ViaViajes v WHERE v.viaCantVend = :viaCantVend")})
public class ViaViajes implements Serializable {
    @Size(max = 2147483647)
    @Column(name = "via_resumen")
    private String viaResumen;
    @Size(max = 2147483647)
    @Column(name = "via_img")
    private String viaImg;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id")
    @ManyToOne
    private PgeMonedas monId;
    @Column(name = "via_cant_vend")
    private Integer viaCantVend;
    @Column(name = "via_cant_tot")
    private Integer viaCantTot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaId")
    private Collection<ViaViajesDet> viaViajesDetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaId")
    private List<PagCobros> pagCobrosList;
    @OneToMany(mappedBy = "viaId")
    private List<PagComprobantesDet> pagComprobantesDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaId")
    private List<ViaPasajeros> viaPasajerosList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "via_id", nullable = false)
    private Integer viaId;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "via_cost", precision = 18, scale = 2)
    private BigDecimal viaCost;

    public ViaViajes() {
    }

    public ViaViajes(Integer viaId) {
        this.viaId = viaId;
    }

    public ViaViajes(Integer viaId, String viaDesc, Date viaFecSali, Date viaFecReg, String viaUsuIns, Date viaFecIns) {
        this.viaId = viaId;
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

    public BigDecimal getViaCost() {
        return viaCost;
    }

    public void setViaCost(BigDecimal viaCost) {
        this.viaCost = viaCost;
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

    public List<ViaPasajeros> getViaPasajerosList() {
        return viaPasajerosList;
    }

    public void setViaPasajerosList(List<ViaPasajeros> viaPasajerosList) {
        this.viaPasajerosList = viaPasajerosList;
    }

    public List<PagComprobantesDet> getPagComprobantesDetList() {
        return pagComprobantesDetList;
    }

    public void setPagComprobantesDetList(List<PagComprobantesDet> pagComprobantesDetList) {
        this.pagComprobantesDetList = pagComprobantesDetList;
    }

    public List<PagCobros> getPagCobrosList() {
        return pagCobrosList;
    }

    public void setPagCobrosList(List<PagCobros> pagCobrosList) {
        this.pagCobrosList = pagCobrosList;
    }

    public Integer getViaCantTot() {
        return viaCantTot;
    }

    public void setViaCantTot(Integer viaCantTot) {
        this.viaCantTot = viaCantTot;
    }

    @XmlTransient
    public Collection<ViaViajesDet> getViaViajesDetCollection() {
        return viaViajesDetCollection;
    }

    public void setViaViajesDetCollection(Collection<ViaViajesDet> viaViajesDetCollection) {
        this.viaViajesDetCollection = viaViajesDetCollection;
    }

    public Integer getViaCantVend() {
        return viaCantVend;
    }

    public void setViaCantVend(Integer viaCantVend) {
        this.viaCantVend = viaCantVend;
    }

    public PgeMonedas getMonId() {
        return monId;
    }

    public void setMonId(PgeMonedas monId) {
        this.monId = monId;
    }

    public String getViaResumen() {
        return viaResumen;
    }

    public void setViaResumen(String viaResumen) {
        this.viaResumen = viaResumen;
    }

    public String getViaImg() {
        return viaImg;
    }

    public void setViaImg(String viaImg) {
        this.viaImg = viaImg;
    }
    
}
