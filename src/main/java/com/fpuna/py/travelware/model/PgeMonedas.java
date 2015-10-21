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

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "PGE_MONEDAS")
@NamedQueries({
    @NamedQuery(name = "PgeMonedas.findAll", query = "SELECT p FROM PgeMonedas p"),
    @NamedQuery(name = "PgeMonedas.findByMonId", query = "SELECT p FROM PgeMonedas p WHERE p.monId = :monId"),
    @NamedQuery(name = "PgeMonedas.findByMonDesc", query = "SELECT p FROM PgeMonedas p WHERE p.monDesc = :monDesc"),
    @NamedQuery(name = "PgeMonedas.findByMonUsuIns", query = "SELECT p FROM PgeMonedas p WHERE p.monUsuIns = :monUsuIns"),
    @NamedQuery(name = "PgeMonedas.findByMonFecIns", query = "SELECT p FROM PgeMonedas p WHERE p.monFecIns = :monFecIns"),
    @NamedQuery(name = "PgeMonedas.findByMonUsuMod", query = "SELECT p FROM PgeMonedas p WHERE p.monUsuMod = :monUsuMod"),
    @NamedQuery(name = "PgeMonedas.findByMonFecMod", query = "SELECT p FROM PgeMonedas p WHERE p.monFecMod = :monFecMod")})
public class PgeMonedas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MON_ID")
    private Integer monId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "MON_DESC")
    private String monDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MON_USU_INS")
    private String monUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MON_FEC_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date monFecIns;
    @Size(max = 10)
    @Column(name = "MON_USU_MOD")
    private String monUsuMod;
    @Column(name = "MON_FEC_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date monFecMod;
    @JoinColumn(name = "PAI_ID", referencedColumnName = "PAI_ID")
    @ManyToOne(optional = false)
    private PgePaises paiId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgeMonedas")
    private List<ViaPreViajes> viaPreViajesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monId")
    private List<PagComprobantes> pagComprobantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgeMonedas")
    private List<PgeCotizaciones> pgeCotizacionesList;

    public PgeMonedas() {
    }

    public PgeMonedas(Integer monId) {
        this.monId = monId;
    }

    public PgeMonedas(Integer monId, String monDesc, String monUsuIns, Date monFecIns) {
        this.monId = monId;
        this.monDesc = monDesc;
        this.monUsuIns = monUsuIns;
        this.monFecIns = monFecIns;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public String getMonDesc() {
        return monDesc;
    }

    public void setMonDesc(String monDesc) {
        this.monDesc = monDesc;
    }

    public String getMonUsuIns() {
        return monUsuIns;
    }

    public void setMonUsuIns(String monUsuIns) {
        this.monUsuIns = monUsuIns;
    }

    public Date getMonFecIns() {
        return monFecIns;
    }

    public void setMonFecIns(Date monFecIns) {
        this.monFecIns = monFecIns;
    }

    public String getMonUsuMod() {
        return monUsuMod;
    }

    public void setMonUsuMod(String monUsuMod) {
        this.monUsuMod = monUsuMod;
    }

    public Date getMonFecMod() {
        return monFecMod;
    }

    public void setMonFecMod(Date monFecMod) {
        this.monFecMod = monFecMod;
    }

    public PgePaises getPaiId() {
        return paiId;
    }

    public void setPaiId(PgePaises paiId) {
        this.paiId = paiId;
    }

    public List<ViaPreViajes> getViaPreViajesList() {
        return viaPreViajesList;
    }

    public void setViaPreViajesList(List<ViaPreViajes> viaPreViajesList) {
        this.viaPreViajesList = viaPreViajesList;
    }

    public List<PagComprobantes> getPagComprobantesList() {
        return pagComprobantesList;
    }

    public void setPagComprobantesList(List<PagComprobantes> pagComprobantesList) {
        this.pagComprobantesList = pagComprobantesList;
    }

    public List<PgeCotizaciones> getPgeCotizacionesList() {
        return pgeCotizacionesList;
    }

    public void setPgeCotizacionesList(List<PgeCotizaciones> pgeCotizacionesList) {
        this.pgeCotizacionesList = pgeCotizacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monId != null ? monId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeMonedas)) {
            return false;
        }
        PgeMonedas other = (PgeMonedas) object;
        if ((this.monId == null && other.monId != null) || (this.monId != null && !this.monId.equals(other.monId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.PgeMonedas[ monId=" + monId + " ]";
    }
    
}
