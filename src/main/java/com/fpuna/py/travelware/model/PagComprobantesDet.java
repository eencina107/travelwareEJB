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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "pag_comprobantes_det", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PagComprobantesDet.findAll", query = "SELECT p FROM PagComprobantesDet p"),
    @NamedQuery(name = "PagComprobantesDet.findByComId", query = "SELECT p FROM PagComprobantesDet p WHERE p.pagComprobantesDetPK.comId = :comId"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeNroDet", query = "SELECT p FROM PagComprobantesDet p WHERE p.pagComprobantesDetPK.cdeNroDet = :cdeNroDet"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeNumCuota", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeNumCuota = :cdeNumCuota"),
    @NamedQuery(name = "PagComprobantesDet.findByCdePorRde", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdePorRde = :cdePorRde"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeExe", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeExe = :cdeExe"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeGra", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeGra = :cdeGra"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeIva", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeIva = :cdeIva"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeTot", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeTot = :cdeTot"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeUsuIns", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeUsuIns = :cdeUsuIns"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeFecIns", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeFecIns = :cdeFecIns"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeUsuMod", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeUsuMod = :cdeUsuMod"),
    @NamedQuery(name = "PagComprobantesDet.findByCdeFecMod", query = "SELECT p FROM PagComprobantesDet p WHERE p.cdeFecMod = :cdeFecMod")})
public class PagComprobantesDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagComprobantesDetPK pagComprobantesDetPK;
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
    @JoinColumn(name = "via_id", referencedColumnName = "via_id")
    @ManyToOne
    private ViaViajes viaId;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id", nullable = false)
    @ManyToOne(optional = false)
    private PgePersonas perId;
    @JoinColumn(name = "com_id", referencedColumnName = "com_id_tran", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PagComprobantes pagComprobantes;

    public PagComprobantesDet() {
    }

    public PagComprobantesDet(PagComprobantesDetPK pagComprobantesDetPK) {
        this.pagComprobantesDetPK = pagComprobantesDetPK;
    }

    public PagComprobantesDet(PagComprobantesDetPK pagComprobantesDetPK, int cdeNumCuota, BigDecimal cdeExe, BigDecimal cdeGra, BigDecimal cdeIva, BigDecimal cdeTot, String cdeUsuIns, Date cdeFecIns) {
        this.pagComprobantesDetPK = pagComprobantesDetPK;
        this.cdeNumCuota = cdeNumCuota;
        this.cdeExe = cdeExe;
        this.cdeGra = cdeGra;
        this.cdeIva = cdeIva;
        this.cdeTot = cdeTot;
        this.cdeUsuIns = cdeUsuIns;
        this.cdeFecIns = cdeFecIns;
    }

    public PagComprobantesDet(int comId, int cdeNroDet) {
        this.pagComprobantesDetPK = new PagComprobantesDetPK(comId, cdeNroDet);
    }

    public PagComprobantesDetPK getPagComprobantesDetPK() {
        return pagComprobantesDetPK;
    }

    public void setPagComprobantesDetPK(PagComprobantesDetPK pagComprobantesDetPK) {
        this.pagComprobantesDetPK = pagComprobantesDetPK;
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

    public ViaViajes getViaId() {
        return viaId;
    }

    public void setViaId(ViaViajes viaId) {
        this.viaId = viaId;
    }

    public PgePersonas getPerId() {
        return perId;
    }

    public void setPerId(PgePersonas perId) {
        this.perId = perId;
    }

    public PagComprobantes getPagComprobantes() {
        return pagComprobantes;
    }

    public void setPagComprobantes(PagComprobantes pagComprobantes) {
        this.pagComprobantes = pagComprobantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagComprobantesDetPK != null ? pagComprobantesDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagComprobantesDet)) {
            return false;
        }
        PagComprobantesDet other = (PagComprobantesDet) object;
        if ((this.pagComprobantesDetPK == null && other.pagComprobantesDetPK != null) || (this.pagComprobantesDetPK != null && !this.pagComprobantesDetPK.equals(other.pagComprobantesDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PagComprobantesDet[ pagComprobantesDetPK=" + pagComprobantesDetPK + " ]";
    }
    
}
