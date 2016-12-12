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
@Table(name = "com_pagos", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ComPagos.findAll", query = "SELECT c FROM ComPagos c"),
    @NamedQuery(name = "ComPagos.findByPgoId", query = "SELECT c FROM ComPagos c WHERE c.pgoId = :pgoId"),
    @NamedQuery(name = "ComPagos.findByPgoTipo", query = "SELECT c FROM ComPagos c WHERE c.pgoTipo = :pgoTipo"),
    @NamedQuery(name = "ComPagos.findByPgoNro", query = "SELECT c FROM ComPagos c WHERE c.pgoNro = :pgoNro"),
    @NamedQuery(name = "ComPagos.findByPgoCambio", query = "SELECT c FROM ComPagos c WHERE c.pgoCambio = :pgoCambio"),
    @NamedQuery(name = "ComPagos.findByPgoMonto", query = "SELECT c FROM ComPagos c WHERE c.pgoMonto = :pgoMonto"),
    @NamedQuery(name = "ComPagos.findByPgoForPago", query = "SELECT c FROM ComPagos c WHERE c.pgoForPago = :pgoForPago"),
    @NamedQuery(name = "ComPagos.findByPgoObservacion", query = "SELECT c FROM ComPagos c WHERE c.pgoObservacion = :pgoObservacion"),
    @NamedQuery(name = "ComPagos.findByPgoAnulado", query = "SELECT c FROM ComPagos c WHERE c.pgoAnulado = :pgoAnulado"),
    @NamedQuery(name = "ComPagos.findByPgoUsuIns", query = "SELECT c FROM ComPagos c WHERE c.pgoUsuIns = :pgoUsuIns"),
    @NamedQuery(name = "ComPagos.findByPgoFecIns", query = "SELECT c FROM ComPagos c WHERE c.pgoFecIns = :pgoFecIns"),
    @NamedQuery(name = "ComPagos.findByPgoUsuMod", query = "SELECT c FROM ComPagos c WHERE c.pgoUsuMod = :pgoUsuMod"),
    @NamedQuery(name = "ComPagos.findByPgoFecMod", query = "SELECT c FROM ComPagos c WHERE c.pgoFecMod = :pgoFecMod"),
    @NamedQuery(name = "ComPagos.findByPgoMontoLetras", query = "SELECT c FROM ComPagos c WHERE c.pgoMontoLetras = :pgoMontoLetras"),
    @NamedQuery(name = "ComPagos.findByPgoCuotaNro", query = "SELECT c FROM ComPagos c WHERE c.pgoCuotaNro = :pgoCuotaNro"),
    @NamedQuery(name = "ComPagos.findByPgoEstado", query = "SELECT c FROM ComPagos c WHERE c.pgoEstado = :pgoEstado")})
public class ComPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pgo_id", nullable = false)
    private Integer pgoId;
    @Size(max = 3)
    @Column(name = "pgo_tipo", length = 3)
    private String pgoTipo;
    @Size(max = 15)
    @Column(name = "pgo_nro", length = 15)
    private String pgoNro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pgo_cambio", precision = 14, scale = 2)
    private BigDecimal pgoCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pgo_monto", nullable = false, precision = 18, scale = 2)
    private BigDecimal pgoMonto;
    @Size(max = 3)
    @Column(name = "pgo_for_pago", length = 3)
    private String pgoForPago;
    @Size(max = 2147483647)
    @Column(name = "pgo_observacion", length = 2147483647)
    private String pgoObservacion;
    @Column(name = "pgo_anulado")
    private Character pgoAnulado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pgo_usu_ins", nullable = false, length = 10)
    private String pgoUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pgo_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date pgoFecIns;
    @Size(max = 10)
    @Column(name = "pgo_usu_mod", length = 10)
    private String pgoUsuMod;
    @Column(name = "pgo_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pgoFecMod;
    @Size(max = 2147483647)
    @Column(name = "pgo_monto_letras", length = 2147483647)
    private String pgoMontoLetras;
    @Column(name = "pgo_cuota_nro")
    private Integer pgoCuotaNro;
    @Column(name = "pgo_estado")
    private Boolean pgoEstado;
    @JoinColumn(name = "fac_id", referencedColumnName = "fac_id", nullable = false)
    @ManyToOne(optional = false)
    private ComFacturas facId;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeMonedas monId;

    public ComPagos() {
    }

    public ComPagos(Integer pgoId) {
        this.pgoId = pgoId;
    }

    public ComPagos(Integer pgoId, BigDecimal pgoMonto, String pgoUsuIns, Date pgoFecIns) {
        this.pgoId = pgoId;
        this.pgoMonto = pgoMonto;
        this.pgoUsuIns = pgoUsuIns;
        this.pgoFecIns = pgoFecIns;
    }

    public Integer getPgoId() {
        return pgoId;
    }

    public void setPgoId(Integer pgoId) {
        this.pgoId = pgoId;
    }

    public String getPgoTipo() {
        return pgoTipo;
    }

    public void setPgoTipo(String pgoTipo) {
        this.pgoTipo = pgoTipo;
    }

    public String getPgoNro() {
        return pgoNro;
    }

    public void setPgoNro(String pgoNro) {
        this.pgoNro = pgoNro;
    }

    public BigDecimal getPgoCambio() {
        return pgoCambio;
    }

    public void setPgoCambio(BigDecimal pgoCambio) {
        this.pgoCambio = pgoCambio;
    }

    public BigDecimal getPgoMonto() {
        return pgoMonto;
    }

    public void setPgoMonto(BigDecimal pgoMonto) {
        this.pgoMonto = pgoMonto;
    }

    public String getPgoForPago() {
        return pgoForPago;
    }

    public void setPgoForPago(String pgoForPago) {
        this.pgoForPago = pgoForPago;
    }

    public String getPgoObservacion() {
        return pgoObservacion;
    }

    public void setPgoObservacion(String pgoObservacion) {
        this.pgoObservacion = pgoObservacion;
    }

    public Character getPgoAnulado() {
        return pgoAnulado;
    }

    public void setPgoAnulado(Character pgoAnulado) {
        this.pgoAnulado = pgoAnulado;
    }

    public String getPgoUsuIns() {
        return pgoUsuIns;
    }

    public void setPgoUsuIns(String pgoUsuIns) {
        this.pgoUsuIns = pgoUsuIns;
    }

    public Date getPgoFecIns() {
        return pgoFecIns;
    }

    public void setPgoFecIns(Date pgoFecIns) {
        this.pgoFecIns = pgoFecIns;
    }

    public String getPgoUsuMod() {
        return pgoUsuMod;
    }

    public void setPgoUsuMod(String pgoUsuMod) {
        this.pgoUsuMod = pgoUsuMod;
    }

    public Date getPgoFecMod() {
        return pgoFecMod;
    }

    public void setPgoFecMod(Date pgoFecMod) {
        this.pgoFecMod = pgoFecMod;
    }

    public String getPgoMontoLetras() {
        return pgoMontoLetras;
    }

    public void setPgoMontoLetras(String pgoMontoLetras) {
        this.pgoMontoLetras = pgoMontoLetras;
    }

    public Integer getPgoCuotaNro() {
        return pgoCuotaNro;
    }

    public void setPgoCuotaNro(Integer pgoCuotaNro) {
        this.pgoCuotaNro = pgoCuotaNro;
    }

    public Boolean getPgoEstado() {
        return pgoEstado;
    }

    public void setPgoEstado(Boolean pgoEstado) {
        this.pgoEstado = pgoEstado;
    }

    public ComFacturas getFacId() {
        return facId;
    }

    public void setFacId(ComFacturas facId) {
        this.facId = facId;
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
        hash += (pgoId != null ? pgoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComPagos)) {
            return false;
        }
        ComPagos other = (ComPagos) object;
        if ((this.pgoId == null && other.pgoId != null) || (this.pgoId != null && !this.pgoId.equals(other.pgoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ComPagos[ pgoId=" + pgoId + " ]";
    }
    
}
