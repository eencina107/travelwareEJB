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

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pag_cobros", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PagCobros.findAll", query = "SELECT p FROM PagCobros p"),
    @NamedQuery(name = "PagCobros.findByCobId", query = "SELECT p FROM PagCobros p WHERE p.cobId = :cobId"),
    @NamedQuery(name = "PagCobros.findByCobTipo", query = "SELECT p FROM PagCobros p WHERE p.cobTipo = :cobTipo"),
    @NamedQuery(name = "PagCobros.findByCobNro", query = "SELECT p FROM PagCobros p WHERE p.cobNro = :cobNro"),
    @NamedQuery(name = "PagCobros.findByCobCambio", query = "SELECT p FROM PagCobros p WHERE p.cobCambio = :cobCambio"),
    @NamedQuery(name = "PagCobros.findByCobMonto", query = "SELECT p FROM PagCobros p WHERE p.cobMonto = :cobMonto"),
    @NamedQuery(name = "PagCobros.findByCobForPago", query = "SELECT p FROM PagCobros p WHERE p.cobForPago = :cobForPago"),
    @NamedQuery(name = "PagCobros.findByCobObservacion", query = "SELECT p FROM PagCobros p WHERE p.cobObservacion = :cobObservacion"),
    @NamedQuery(name = "PagCobros.findByCobAnulado", query = "SELECT p FROM PagCobros p WHERE p.cobAnulado = :cobAnulado"),
    @NamedQuery(name = "PagCobros.findByCobUsuIns", query = "SELECT p FROM PagCobros p WHERE p.cobUsuIns = :cobUsuIns"),
    @NamedQuery(name = "PagCobros.findByCobFecIns", query = "SELECT p FROM PagCobros p WHERE p.cobFecIns = :cobFecIns"),
    @NamedQuery(name = "PagCobros.findByCobUsuMod", query = "SELECT p FROM PagCobros p WHERE p.cobUsuMod = :cobUsuMod"),
    @NamedQuery(name = "PagCobros.findByCobFecMod", query = "SELECT p FROM PagCobros p WHERE p.cobFecMod = :cobFecMod")})
public class PagCobros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cob_id", nullable = false)
    private Integer cobId;
    @Size(max = 3)
    @Column(name = "cob_tipo", length = 3)
    private String cobTipo;
    @Size(max = 15)
    @Column(name = "cob_nro", length = 15)
    private String cobNro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cob_cambio", precision = 14, scale = 2)
    private BigDecimal cobCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cob_monto", nullable = false, precision = 18, scale = 2)
    private BigDecimal cobMonto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cob_for_pago", nullable = false, length = 3)
    private String cobForPago;
    @Size(max = 2147483647)
    @Column(name = "cob_observacion", length = 2147483647)
    private String cobObservacion;
    @Column(name = "cob_anulado")
    private Character cobAnulado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cob_usu_ins", nullable = false, length = 10)
    private String cobUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cob_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cobFecIns;
    @Size(max = 10)
    @Column(name = "cob_usu_mod", length = 10)
    private String cobUsuMod;
    @Column(name = "cob_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cobFecMod;
    @JoinColumn(name = "via_id", referencedColumnName = "via_id", nullable = false)
    @ManyToOne(optional = false)
    private ViaViajes viaId;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id", nullable = false)
    @ManyToOne(optional = false)
    private PgePersonas perId;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeMonedas monId;

    public PagCobros() {
    }

    public PagCobros(Integer cobId) {
        this.cobId = cobId;
    }

    public PagCobros(Integer cobId, BigDecimal cobMonto, String cobForPago, String cobUsuIns, Date cobFecIns) {
        this.cobId = cobId;
        this.cobMonto = cobMonto;
        this.cobForPago = cobForPago;
        this.cobUsuIns = cobUsuIns;
        this.cobFecIns = cobFecIns;
    }

    public Integer getCobId() {
        return cobId;
    }

    public void setCobId(Integer cobId) {
        this.cobId = cobId;
    }

    public String getCobTipo() {
        return cobTipo;
    }

    public void setCobTipo(String cobTipo) {
        this.cobTipo = cobTipo;
    }

    public String getCobNro() {
        return cobNro;
    }

    public void setCobNro(String cobNro) {
        this.cobNro = cobNro;
    }

    public BigDecimal getCobCambio() {
        return cobCambio;
    }

    public void setCobCambio(BigDecimal cobCambio) {
        this.cobCambio = cobCambio;
    }

    public BigDecimal getCobMonto() {
        return cobMonto;
    }

    public void setCobMonto(BigDecimal cobMonto) {
        this.cobMonto = cobMonto;
    }

    public String getCobForPago() {
        return cobForPago;
    }

    public void setCobForPago(String cobForPago) {
        this.cobForPago = cobForPago;
    }

    public String getCobObservacion() {
        return cobObservacion;
    }

    public void setCobObservacion(String cobObservacion) {
        this.cobObservacion = cobObservacion;
    }

    public Character getCobAnulado() {
        return cobAnulado;
    }

    public void setCobAnulado(Character cobAnulado) {
        this.cobAnulado = cobAnulado;
    }

    public String getCobUsuIns() {
        return cobUsuIns;
    }

    public void setCobUsuIns(String cobUsuIns) {
        this.cobUsuIns = cobUsuIns;
    }

    public Date getCobFecIns() {
        return cobFecIns;
    }

    public void setCobFecIns(Date cobFecIns) {
        this.cobFecIns = cobFecIns;
    }

    public String getCobUsuMod() {
        return cobUsuMod;
    }

    public void setCobUsuMod(String cobUsuMod) {
        this.cobUsuMod = cobUsuMod;
    }

    public Date getCobFecMod() {
        return cobFecMod;
    }

    public void setCobFecMod(Date cobFecMod) {
        this.cobFecMod = cobFecMod;
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

    public PgeMonedas getMonId() {
        return monId;
    }

    public void setMonId(PgeMonedas monId) {
        this.monId = monId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cobId != null ? cobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagCobros)) {
            return false;
        }
        PagCobros other = (PagCobros) object;
        if ((this.cobId == null && other.cobId != null) || (this.cobId != null && !this.cobId.equals(other.cobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PagCobros[ cobId=" + cobId + " ]";
    }
    
}
