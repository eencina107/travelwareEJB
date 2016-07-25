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
@Table(name = "com_mov_cajas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComMovCajas.findAll", query = "SELECT c FROM ComMovCajas c"),
    @NamedQuery(name = "ComMovCajas.findByMovId", query = "SELECT c FROM ComMovCajas c WHERE c.movId = :movId"),
    @NamedQuery(name = "ComMovCajas.findByMovCambio", query = "SELECT c FROM ComMovCajas c WHERE c.movCambio = :movCambio"),
    @NamedQuery(name = "ComMovCajas.findByMovForPago", query = "SELECT c FROM ComMovCajas c WHERE c.movForPago = :movForPago"),
    @NamedQuery(name = "ComMovCajas.findByMovMonto", query = "SELECT c FROM ComMovCajas c WHERE c.movMonto = :movMonto"),
    @NamedQuery(name = "ComMovCajas.findByMovTip", query = "SELECT c FROM ComMovCajas c WHERE c.movTip = :movTip"),
    @NamedQuery(name = "ComMovCajas.findByMovObservacion", query = "SELECT c FROM ComMovCajas c WHERE c.movObservacion = :movObservacion"),
    @NamedQuery(name = "ComMovCajas.findByMovMontoLetras", query = "SELECT c FROM ComMovCajas c WHERE c.movMontoLetras = :movMontoLetras"),
    @NamedQuery(name = "ComMovCajas.findByMovAnulado", query = "SELECT c FROM ComMovCajas c WHERE c.movAnulado = :movAnulado"),
    @NamedQuery(name = "ComMovCajas.findByMovUsuIns", query = "SELECT c FROM ComMovCajas c WHERE c.movUsuIns = :movUsuIns"),
    @NamedQuery(name = "ComMovCajas.findByMovFecIns", query = "SELECT c FROM ComMovCajas c WHERE c.movFecIns = :movFecIns"),
    @NamedQuery(name = "ComMovCajas.findByMovUsuMod", query = "SELECT c FROM ComMovCajas c WHERE c.movUsuMod = :movUsuMod"),
    @NamedQuery(name = "ComMovCajas.findByMovFecMod", query = "SELECT c FROM ComMovCajas c WHERE c.movFecMod = :movFecMod")})
public class ComMovCajas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mov_id")
    private Integer movId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mov_cambio")
    private BigDecimal movCambio;
    @Size(max = 3)
    @Column(name = "mov_for_pago")
    private String movForPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mov_monto")
    private BigDecimal movMonto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mov_tip")
    private Character movTip;
    @Size(max = 2147483647)
    @Column(name = "mov_observacion")
    private String movObservacion;
    @Size(max = 2147483647)
    @Column(name = "mov_monto_letras")
    private String movMontoLetras;
    @Column(name = "mov_anulado")
    private Character movAnulado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mov_usu_ins")
    private String movUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mov_fec_ins")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movFecIns;
    @Size(max = 10)
    @Column(name = "mov_usu_mod")
    private String movUsuMod;
    @Column(name = "mov_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movFecMod;
    @JoinColumn(name = "caj_id", referencedColumnName = "caj_id")
    @ManyToOne(optional = false)
    private ComCajas cajId;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id")
    @ManyToOne(optional = false)
    private PgeMonedas monId;

    public ComMovCajas() {
    }

    public ComMovCajas(Integer movId) {
        this.movId = movId;
    }

    public ComMovCajas(Integer movId, BigDecimal movMonto, Character movTip, String movUsuIns, Date movFecIns) {
        this.movId = movId;
        this.movMonto = movMonto;
        this.movTip = movTip;
        this.movUsuIns = movUsuIns;
        this.movFecIns = movFecIns;
    }

    public Integer getMovId() {
        return movId;
    }

    public void setMovId(Integer movId) {
        this.movId = movId;
    }

    public BigDecimal getMovCambio() {
        return movCambio;
    }

    public void setMovCambio(BigDecimal movCambio) {
        this.movCambio = movCambio;
    }

    public String getMovForPago() {
        return movForPago;
    }

    public void setMovForPago(String movForPago) {
        this.movForPago = movForPago;
    }

    public BigDecimal getMovMonto() {
        return movMonto;
    }

    public void setMovMonto(BigDecimal movMonto) {
        this.movMonto = movMonto;
    }

    public Character getMovTip() {
        return movTip;
    }

    public void setMovTip(Character movTip) {
        this.movTip = movTip;
    }

    public String getMovObservacion() {
        return movObservacion;
    }

    public void setMovObservacion(String movObservacion) {
        this.movObservacion = movObservacion;
    }

    public String getMovMontoLetras() {
        return movMontoLetras;
    }

    public void setMovMontoLetras(String movMontoLetras) {
        this.movMontoLetras = movMontoLetras;
    }

    public Character getMovAnulado() {
        return movAnulado;
    }

    public void setMovAnulado(Character movAnulado) {
        this.movAnulado = movAnulado;
    }

    public String getMovUsuIns() {
        return movUsuIns;
    }

    public void setMovUsuIns(String movUsuIns) {
        this.movUsuIns = movUsuIns;
    }

    public Date getMovFecIns() {
        return movFecIns;
    }

    public void setMovFecIns(Date movFecIns) {
        this.movFecIns = movFecIns;
    }

    public String getMovUsuMod() {
        return movUsuMod;
    }

    public void setMovUsuMod(String movUsuMod) {
        this.movUsuMod = movUsuMod;
    }

    public Date getMovFecMod() {
        return movFecMod;
    }

    public void setMovFecMod(Date movFecMod) {
        this.movFecMod = movFecMod;
    }

    public ComCajas getCajId() {
        return cajId;
    }

    public void setCajId(ComCajas cajId) {
        this.cajId = cajId;
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
        hash += (movId != null ? movId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComMovCajas)) {
            return false;
        }
        ComMovCajas other = (ComMovCajas) object;
        if ((this.movId == null && other.movId != null) || (this.movId != null && !this.movId.equals(other.movId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ComMovCajas[ movId=" + movId + " ]";
    }
    
}
