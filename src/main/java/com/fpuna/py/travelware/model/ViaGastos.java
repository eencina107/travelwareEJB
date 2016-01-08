/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "via_gastos", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"per_id", "gas_nro"})})
@NamedQueries({
    @NamedQuery(name = "ViaGastos.findAll", query = "SELECT v FROM ViaGastos v"),
    @NamedQuery(name = "ViaGastos.findByGasId", query = "SELECT v FROM ViaGastos v WHERE v.gasId = :gasId"),
    @NamedQuery(name = "ViaGastos.findByGasNro", query = "SELECT v FROM ViaGastos v WHERE v.gasNro = :gasNro"),
    @NamedQuery(name = "ViaGastos.findByGasTip", query = "SELECT v FROM ViaGastos v WHERE v.gasTip = :gasTip"),
    @NamedQuery(name = "ViaGastos.findByGasMonto", query = "SELECT v FROM ViaGastos v WHERE v.gasMonto = :gasMonto")})
public class ViaGastos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gas_id", nullable = false)
    private Integer gasId;
    @Column(name = "gas_nro")
    private Integer gasNro;
    @Size(max = 3)
    @Column(name = "gas_tip", length = 3)
    private String gasTip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gas_monto", precision = 18, scale = 2)
    private BigDecimal gasMonto;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne
    private PgePersonas perId;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id")
    @ManyToOne
    private PgeMonedas monId;

    public ViaGastos() {
    }

    public ViaGastos(Integer gasId) {
        this.gasId = gasId;
    }

    public Integer getGasId() {
        return gasId;
    }

    public void setGasId(Integer gasId) {
        this.gasId = gasId;
    }

    public Integer getGasNro() {
        return gasNro;
    }

    public void setGasNro(Integer gasNro) {
        this.gasNro = gasNro;
    }

    public String getGasTip() {
        return gasTip;
    }

    public void setGasTip(String gasTip) {
        this.gasTip = gasTip;
    }

    public BigDecimal getGasMonto() {
        return gasMonto;
    }

    public void setGasMonto(BigDecimal gasMonto) {
        this.gasMonto = gasMonto;
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
        hash += (gasId != null ? gasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaGastos)) {
            return false;
        }
        ViaGastos other = (ViaGastos) object;
        if ((this.gasId == null && other.gasId != null) || (this.gasId != null && !this.gasId.equals(other.gasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaGastos[ gasId=" + gasId + " ]";
    }
    
}
