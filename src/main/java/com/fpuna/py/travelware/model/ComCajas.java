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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author damia_000
 */
@Entity
@Table(name = "com_cajas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComCajas.findAll", query = "SELECT c FROM ComCajas c"),
    @NamedQuery(name = "ComCajas.findByCajId", query = "SELECT c FROM ComCajas c WHERE c.cajId = :cajId"),
    @NamedQuery(name = "ComCajas.findByCajDesc", query = "SELECT c FROM ComCajas c WHERE c.cajDesc = :cajDesc"),
    @NamedQuery(name = "ComCajas.findByCajEst", query = "SELECT c FROM ComCajas c WHERE c.cajEst = :cajEst"),
    @NamedQuery(name = "ComCajas.findByCajLim", query = "SELECT c FROM ComCajas c WHERE c.cajLim = :cajLim"),
    @NamedQuery(name = "ComCajas.findByCajSaldo", query = "SELECT c FROM ComCajas c WHERE c.cajSaldo = :cajSaldo"),
    @NamedQuery(name = "ComCajas.findByCajUsuIns", query = "SELECT c FROM ComCajas c WHERE c.cajUsuIns = :cajUsuIns"),
    @NamedQuery(name = "ComCajas.findByCajFecIns", query = "SELECT c FROM ComCajas c WHERE c.cajFecIns = :cajFecIns"),
    @NamedQuery(name = "ComCajas.findByCajUsuMod", query = "SELECT c FROM ComCajas c WHERE c.cajUsuMod = :cajUsuMod"),
    @NamedQuery(name = "ComCajas.findByCajFecMod", query = "SELECT c FROM ComCajas c WHERE c.cajFecMod = :cajFecMod")})
public class ComCajas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "caj_id")
    private Integer cajId;
    @Size(max = 100)
    @Column(name = "caj_desc")
    private String cajDesc;
    @Column(name = "caj_est")
    private Character cajEst;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "caj_lim")
    private BigDecimal cajLim;
    @Column(name = "caj_saldo")
    private BigDecimal cajSaldo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "caj_usu_ins")
    private String cajUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caj_fec_ins")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cajFecIns;
    @Size(max = 10)
    @Column(name = "caj_usu_mod")
    private String cajUsuMod;
    @Column(name = "caj_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cajFecMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajId")
    private Collection<ComMovCajas> comMovCajasCollection;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id")
    @ManyToOne(optional = false)
    private PgeMonedas monId;

    public ComCajas() {
    }

    public ComCajas(Integer cajId) {
        this.cajId = cajId;
    }

    public ComCajas(Integer cajId, String cajUsuIns, Date cajFecIns) {
        this.cajId = cajId;
        this.cajUsuIns = cajUsuIns;
        this.cajFecIns = cajFecIns;
    }

    public Integer getCajId() {
        return cajId;
    }

    public void setCajId(Integer cajId) {
        this.cajId = cajId;
    }

    public String getCajDesc() {
        return cajDesc;
    }

    public void setCajDesc(String cajDesc) {
        this.cajDesc = cajDesc;
    }

    public Character getCajEst() {
        return cajEst;
    }

    public void setCajEst(Character cajEst) {
        this.cajEst = cajEst;
    }

    public BigDecimal getCajLim() {
        return cajLim;
    }

    public void setCajLim(BigDecimal cajLim) {
        this.cajLim = cajLim;
    }

    public BigDecimal getCajSaldo() {
        return cajSaldo;
    }

    public void setCajSaldo(BigDecimal cajSaldo) {
        this.cajSaldo = cajSaldo;
    }

    public String getCajUsuIns() {
        return cajUsuIns;
    }

    public void setCajUsuIns(String cajUsuIns) {
        this.cajUsuIns = cajUsuIns;
    }

    public Date getCajFecIns() {
        return cajFecIns;
    }

    public void setCajFecIns(Date cajFecIns) {
        this.cajFecIns = cajFecIns;
    }

    public String getCajUsuMod() {
        return cajUsuMod;
    }

    public void setCajUsuMod(String cajUsuMod) {
        this.cajUsuMod = cajUsuMod;
    }

    public Date getCajFecMod() {
        return cajFecMod;
    }

    public void setCajFecMod(Date cajFecMod) {
        this.cajFecMod = cajFecMod;
    }

    @XmlTransient
    public Collection<ComMovCajas> getComMovCajasCollection() {
        return comMovCajasCollection;
    }

    public void setComMovCajasCollection(Collection<ComMovCajas> comMovCajasCollection) {
        this.comMovCajasCollection = comMovCajasCollection;
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
        hash += (cajId != null ? cajId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComCajas)) {
            return false;
        }
        ComCajas other = (ComCajas) object;
        if ((this.cajId == null && other.cajId != null) || (this.cajId != null && !this.cajId.equals(other.cajId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ComCajas[ cajId=" + cajId + " ]";
    }
    
}
