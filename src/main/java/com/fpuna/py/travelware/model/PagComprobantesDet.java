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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pag_comprobantes_det", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"com_id", "cde_nro_det"})})
@NamedQueries({
    @NamedQuery(name = "PagComprobantesDet.findAll", query = "SELECT p FROM PagComprobantesDet p"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeNroDet", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeNroDet = :cdeNroDet"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeNumCuota", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeNumCuota = :cdeNumCuota"),
    @NamedQuery(name = "PagComprobantesDet.findByCdePorRde", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdePorRde = :cdePorRde"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeExe", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeExe = :cdeExe"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeGra", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeGra = :cdeGra"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeIva", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeIva = :cdeIva"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeTot", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeTot = :cdeTot"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeUsuIns", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeUsuIns = :cdeUsuIns"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeFecIns", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeFecIns = :cdeFecIns"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeUsuMod", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeUsuMod = :cdeUsuMod"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeFecMod", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeFecMod = :cdeFecMod"),
    @NamedQuery(name = "PagComprobantesDet.findByComDetId", query = "SELECT p FROM PagComprobantesDet p WHERE p.comDetId = :comDetId")})
public class PagComprobantesDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cde_nro_det", nullable = false)
    private int cdeNroDet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cde_num_cuota", nullable = false)
    private int cdeNumCuota;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cde_por_rde", precision = 8, scale = 2)
    private BigDecimal cdePorRde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cde_exe", nullable = false, precision = 18, scale = 2)
    private BigDecimal cdeExe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cde_gra", nullable = false, precision = 18, scale = 2)
    private BigDecimal cdeGra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cde_iva", nullable = false, precision = 18, scale = 2)
    private BigDecimal cdeIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cde_tot", nullable = false, precision = 18, scale = 2)
    private BigDecimal cdeTot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cde_usu_ins", nullable = false, length = 10)
    private String cdeUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cde_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdeFecIns;
    @Size(max = 10)
    @Column(name = "cde_usu_mod", length = 10)
    private String cdeUsuMod;
    @Column(name = "cde_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdeFecMod;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "com_det_id", nullable = false)
    private Integer comDetId;
    @JoinColumn(name = "via_id", referencedColumnName = "via_id")
    @ManyToOne
    private ViaViajes viaId;
    @JoinColumn(name = "com_id", referencedColumnName = "com_id_tran", nullable = false)
    @ManyToOne(optional = false)
    private PagComprobantes comId;

    public PagComprobantesDet() {
    }

    public PagComprobantesDet(Integer comDetId) {
        this.comDetId = comDetId;
    }

    public PagComprobantesDet(Integer comDetId, int cdeNroDet, int cdeNumCuota, BigDecimal cdeExe, BigDecimal cdeGra, BigDecimal cdeIva, BigDecimal cdeTot, String cdeUsuIns, Date cdeFecIns) {
        this.comDetId = comDetId;
        this.cdeNroDet = cdeNroDet;
        this.cdeNumCuota = cdeNumCuota;
        this.cdeExe = cdeExe;
        this.cdeGra = cdeGra;
        this.cdeIva = cdeIva;
        this.cdeTot = cdeTot;
        this.cdeUsuIns = cdeUsuIns;
        this.cdeFecIns = cdeFecIns;
    }

    public int getCdeNroDet() {
        return cdeNroDet;
    }

    public void setCdeNroDet(int cdeNroDet) {
        this.cdeNroDet = cdeNroDet;
    }

    public int getCdeNumCuota() {
        return cdeNumCuota;
    }

    public void setCdeNumCuota(int cdeNumCuota) {
        this.cdeNumCuota = cdeNumCuota;
    }

    public BigDecimal getCdePorRde() {
        return cdePorRde;
    }

    public void setCdePorRde(BigDecimal cdePorRde) {
        this.cdePorRde = cdePorRde;
    }

    public BigDecimal getCdeExe() {
        return cdeExe;
    }

    public void setCdeExe(BigDecimal cdeExe) {
        this.cdeExe = cdeExe;
    }

    public BigDecimal getCdeGra() {
        return cdeGra;
    }

    public void setCdeGra(BigDecimal cdeGra) {
        this.cdeGra = cdeGra;
    }

    public BigDecimal getCdeIva() {
        return cdeIva;
    }

    public void setCdeIva(BigDecimal cdeIva) {
        this.cdeIva = cdeIva;
    }

    public BigDecimal getCdeTot() {
        return cdeTot;
    }

    public void setCdeTot(BigDecimal cdeTot) {
        this.cdeTot = cdeTot;
    }

    public String getCdeUsuIns() {
        return cdeUsuIns;
    }

    public void setCdeUsuIns(String cdeUsuIns) {
        this.cdeUsuIns = cdeUsuIns;
    }

    public Date getCdeFecIns() {
        return cdeFecIns;
    }

    public void setCdeFecIns(Date cdeFecIns) {
        this.cdeFecIns = cdeFecIns;
    }

    public String getCdeUsuMod() {
        return cdeUsuMod;
    }

    public void setCdeUsuMod(String cdeUsuMod) {
        this.cdeUsuMod = cdeUsuMod;
    }

    public Date getCdeFecMod() {
        return cdeFecMod;
    }

    public void setCdeFecMod(Date cdeFecMod) {
        this.cdeFecMod = cdeFecMod;
    }

    public Integer getComDetId() {
        return comDetId;
    }

    public void setComDetId(Integer comDetId) {
        this.comDetId = comDetId;
    }

    public ViaViajes getViaId() {
        return viaId;
    }

    public void setViaId(ViaViajes viaId) {
        this.viaId = viaId;
    }

    public PagComprobantes getComId() {
        return comId;
    }

    public void setComId(PagComprobantes comId) {
        this.comId = comId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comDetId != null ? comDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagComprobantesDet)) {
            return false;
        }
        PagComprobantesDet other = (PagComprobantesDet) object;
        if ((this.comDetId == null && other.comDetId != null) || (this.comDetId != null && !this.comDetId.equals(other.comDetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PagComprobantesDet[ comDetId=" + comDetId + " ]";
    }
    
}
