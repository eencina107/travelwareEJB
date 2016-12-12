/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "com_facturas", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ComFacturas.findAll", query = "SELECT c FROM ComFacturas c"),
    @NamedQuery(name = "ComFacturas.findByFacId", query = "SELECT c FROM ComFacturas c WHERE c.facId = :facId"),
    @NamedQuery(name = "ComFacturas.findByFacNro", query = "SELECT c FROM ComFacturas c WHERE c.facNro = :facNro"),
    @NamedQuery(name = "ComFacturas.findByFacFecha", query = "SELECT c FROM ComFacturas c WHERE c.facFecha = :facFecha"),
    @NamedQuery(name = "ComFacturas.findByFacCambio", query = "SELECT c FROM ComFacturas c WHERE c.facCambio = :facCambio"),
    @NamedQuery(name = "ComFacturas.findByFacTip", query = "SELECT c FROM ComFacturas c WHERE c.facTip = :facTip"),
    @NamedQuery(name = "ComFacturas.findByFacIvaInc", query = "SELECT c FROM ComFacturas c WHERE c.facIvaInc = :facIvaInc"),
    @NamedQuery(name = "ComFacturas.findByFacTotal", query = "SELECT c FROM ComFacturas c WHERE c.facTotal = :facTotal"),
    @NamedQuery(name = "ComFacturas.findByFacDesc", query = "SELECT c FROM ComFacturas c WHERE c.facDesc = :facDesc"),
    @NamedQuery(name = "ComFacturas.findByFacEst", query = "SELECT c FROM ComFacturas c WHERE c.facEst = :facEst"),
    @NamedQuery(name = "ComFacturas.findByFacNroTim", query = "SELECT c FROM ComFacturas c WHERE c.facNroTim = :facNroTim"),
    @NamedQuery(name = "ComFacturas.findByFacFecVen", query = "SELECT c FROM ComFacturas c WHERE c.facFecVen = :facFecVen"),
    @NamedQuery(name = "ComFacturas.findByFacCond", query = "SELECT c FROM ComFacturas c WHERE c.facCond = :facCond"),
    @NamedQuery(name = "ComFacturas.findByFacRuc", query = "SELECT c FROM ComFacturas c WHERE c.facRuc = :facRuc"),
    @NamedQuery(name = "ComFacturas.findByFacSaldo", query = "SELECT c FROM ComFacturas c WHERE c.facSaldo = :facSaldo"),
    @NamedQuery(name = "ComFacturas.findByFacCanCuo", query = "SELECT c FROM ComFacturas c WHERE c.facCanCuo = :facCanCuo"),
    @NamedQuery(name = "ComFacturas.findByFacImg", query = "SELECT c FROM ComFacturas c WHERE c.facImg = :facImg"),
    @NamedQuery(name = "ComFacturas.findByFacUsuIns", query = "SELECT c FROM ComFacturas c WHERE c.facUsuIns = :facUsuIns"),
    @NamedQuery(name = "ComFacturas.findByFacFecIns", query = "SELECT c FROM ComFacturas c WHERE c.facFecIns = :facFecIns"),
    @NamedQuery(name = "ComFacturas.findByFacUsuMod", query = "SELECT c FROM ComFacturas c WHERE c.facUsuMod = :facUsuMod"),
    @NamedQuery(name = "ComFacturas.findByFacFecMod", query = "SELECT c FROM ComFacturas c WHERE c.facFecMod = :facFecMod"),
    @NamedQuery(name = "ComFacturas.findByFacFormaPago", query = "SELECT c FROM ComFacturas c WHERE c.facFormaPago = :facFormaPago")})
public class ComFacturas implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facId")
    private List<ComPagos> comPagosList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fac_id", nullable = false)
    private Integer facId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fac_nro", nullable = false, length = 20)
    private String facNro;
    @Column(name = "fac_fecha")
    @Temporal(TemporalType.DATE)
    private Date facFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fac_cambio", precision = 14, scale = 2)
    private BigDecimal facCambio;
    @Column(name = "fac_tip")
    private Character facTip;
    @Column(name = "fac_iva_inc")
    private Character facIvaInc;
    @Column(name = "fac_total", precision = 18, scale = 2)
    private BigDecimal facTotal;
    @Size(max = 1000)
    @Column(name = "fac_desc", length = 1000)
    private String facDesc;
    @Column(name = "fac_est")
    private Character facEst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "fac_nro_tim", nullable = false, length = 15)
    private String facNroTim;
    @Column(name = "fac_fec_ven")
    @Temporal(TemporalType.DATE)
    private Date facFecVen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fac_cond", nullable = false)
    private Character facCond;
    @Size(max = 20)
    @Column(name = "fac_ruc", length = 20)
    private String facRuc;
    @Column(name = "fac_saldo", precision = 18, scale = 2)
    private BigDecimal facSaldo;
    @Column(name = "fac_can_cuo")
    private Integer facCanCuo;
    @Size(max = 2147483647)
    @Column(name = "fac_img", length = 2147483647)
    private String facImg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fac_usu_ins", nullable = false, length = 10)
    private String facUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fac_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date facFecIns;
    @Size(max = 10)
    @Column(name = "fac_usu_mod", length = 10)
    private String facUsuMod;
    @Column(name = "fac_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date facFecMod;
    @Size(max = 3)
    @Column(name = "fac_forma_pago", length = 3)
    private String facFormaPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facId")
    private List<ComFacturasDet> comFacturasDetList;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id", nullable = false)
    @ManyToOne(optional = false)
    private ComProveedores proId;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id")
    @ManyToOne
    private PgeMonedas monId;

    public ComFacturas() {
    }

    public ComFacturas(Integer facId) {
        this.facId = facId;
    }

    public ComFacturas(Integer facId, String facNro, String facNroTim, Character facCond, String facUsuIns, Date facFecIns) {
        this.facId = facId;
        this.facNro = facNro;
        this.facNroTim = facNroTim;
        this.facCond = facCond;
        this.facUsuIns = facUsuIns;
        this.facFecIns = facFecIns;
    }

    public Integer getFacId() {
        return facId;
    }

    public void setFacId(Integer facId) {
        this.facId = facId;
    }

    public String getFacNro() {
        return facNro;
    }

    public void setFacNro(String facNro) {
        this.facNro = facNro;
    }

    public Date getFacFecha() {
        return facFecha;
    }

    public void setFacFecha(Date facFecha) {
        this.facFecha = facFecha;
    }

    public BigDecimal getFacCambio() {
        return facCambio;
    }

    public void setFacCambio(BigDecimal facCambio) {
        this.facCambio = facCambio;
    }

    public Character getFacTip() {
        return facTip;
    }

    public void setFacTip(Character facTip) {
        this.facTip = facTip;
    }

    public Character getFacIvaInc() {
        return facIvaInc;
    }

    public void setFacIvaInc(Character facIvaInc) {
        this.facIvaInc = facIvaInc;
    }

    public BigDecimal getFacTotal() {
        return facTotal;
    }

    public void setFacTotal(BigDecimal facTotal) {
        this.facTotal = facTotal;
    }

    public String getFacDesc() {
        return facDesc;
    }

    public void setFacDesc(String facDesc) {
        this.facDesc = facDesc;
    }

    public Character getFacEst() {
        return facEst;
    }

    public void setFacEst(Character facEst) {
        this.facEst = facEst;
    }

    public String getFacNroTim() {
        return facNroTim;
    }

    public void setFacNroTim(String facNroTim) {
        this.facNroTim = facNroTim;
    }

    public Date getFacFecVen() {
        return facFecVen;
    }

    public void setFacFecVen(Date facFecVen) {
        this.facFecVen = facFecVen;
    }

    public Character getFacCond() {
        return facCond;
    }

    public void setFacCond(Character facCond) {
        this.facCond = facCond;
    }

    public String getFacRuc() {
        return facRuc;
    }

    public void setFacRuc(String facRuc) {
        this.facRuc = facRuc;
    }

    public BigDecimal getFacSaldo() {
        return facSaldo;
    }

    public void setFacSaldo(BigDecimal facSaldo) {
        this.facSaldo = facSaldo;
    }

    public Integer getFacCanCuo() {
        return facCanCuo;
    }

    public void setFacCanCuo(Integer facCanCuo) {
        this.facCanCuo = facCanCuo;
    }

    public String getFacImg() {
        return facImg;
    }

    public void setFacImg(String facImg) {
        this.facImg = facImg;
    }

    public String getFacUsuIns() {
        return facUsuIns;
    }

    public void setFacUsuIns(String facUsuIns) {
        this.facUsuIns = facUsuIns;
    }

    public Date getFacFecIns() {
        return facFecIns;
    }

    public void setFacFecIns(Date facFecIns) {
        this.facFecIns = facFecIns;
    }

    public String getFacUsuMod() {
        return facUsuMod;
    }

    public void setFacUsuMod(String facUsuMod) {
        this.facUsuMod = facUsuMod;
    }

    public Date getFacFecMod() {
        return facFecMod;
    }

    public void setFacFecMod(Date facFecMod) {
        this.facFecMod = facFecMod;
    }

    public String getFacFormaPago() {
        return facFormaPago;
    }

    public void setFacFormaPago(String facFormaPago) {
        this.facFormaPago = facFormaPago;
    }

    public List<ComFacturasDet> getComFacturasDetList() {
        return comFacturasDetList;
    }

    public void setComFacturasDetList(List<ComFacturasDet> comFacturasDetList) {
        this.comFacturasDetList = comFacturasDetList;
    }

    public ComProveedores getProId() {
        return proId;
    }

    public void setProId(ComProveedores proId) {
        this.proId = proId;
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
        hash += (facId != null ? facId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComFacturas)) {
            return false;
        }
        ComFacturas other = (ComFacturas) object;
        if ((this.facId == null && other.facId != null) || (this.facId != null && !this.facId.equals(other.facId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ComFacturas[ facId=" + facId + " ]";
    }

    public List<ComPagos> getComPagosList() {
        return comPagosList;
    }

    public void setComPagosList(List<ComPagos> comPagosList) {
        this.comPagosList = comPagosList;
    }
    
}
