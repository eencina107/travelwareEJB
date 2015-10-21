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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "PAG_COMPROBANTES", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COM_CONC", "COM_TIP_DOC", "COM_NUM_DOC", "COM_ESTADO"})})
@NamedQueries({
    @NamedQuery(name = "PagComprobantes.findAll", query = "SELECT p FROM PagComprobantes p"),
    @NamedQuery(name = "PagComprobantes.findByComIdTran", query = "SELECT p FROM PagComprobantes p WHERE p.comIdTran = :comIdTran"),
    @NamedQuery(name = "PagComprobantes.findByComConc", query = "SELECT p FROM PagComprobantes p WHERE p.comConc = :comConc"),
    @NamedQuery(name = "PagComprobantes.findByComNumDoc", query = "SELECT p FROM PagComprobantes p WHERE p.comNumDoc = :comNumDoc"),
    @NamedQuery(name = "PagComprobantes.findByComTipDoc", query = "SELECT p FROM PagComprobantes p WHERE p.comTipDoc = :comTipDoc"),
    @NamedQuery(name = "PagComprobantes.findByComTimbrado", query = "SELECT p FROM PagComprobantes p WHERE p.comTimbrado = :comTimbrado"),
    @NamedQuery(name = "PagComprobantes.findByComEstado", query = "SELECT p FROM PagComprobantes p WHERE p.comEstado = :comEstado"),
    @NamedQuery(name = "PagComprobantes.findByComFecEmis", query = "SELECT p FROM PagComprobantes p WHERE p.comFecEmis = :comFecEmis"),
    @NamedQuery(name = "PagComprobantes.findByComFecVenc", query = "SELECT p FROM PagComprobantes p WHERE p.comFecVenc = :comFecVenc"),
    @NamedQuery(name = "PagComprobantes.findByComCondicion", query = "SELECT p FROM PagComprobantes p WHERE p.comCondicion = :comCondicion"),
    @NamedQuery(name = "PagComprobantes.findByComCotizacion", query = "SELECT p FROM PagComprobantes p WHERE p.comCotizacion = :comCotizacion"),
    @NamedQuery(name = "PagComprobantes.findByComObservacion", query = "SELECT p FROM PagComprobantes p WHERE p.comObservacion = :comObservacion"),
    @NamedQuery(name = "PagComprobantes.findByComTotExe", query = "SELECT p FROM PagComprobantes p WHERE p.comTotExe = :comTotExe"),
    @NamedQuery(name = "PagComprobantes.findByComTotGra", query = "SELECT p FROM PagComprobantes p WHERE p.comTotGra = :comTotGra"),
    @NamedQuery(name = "PagComprobantes.findByComTotImp", query = "SELECT p FROM PagComprobantes p WHERE p.comTotImp = :comTotImp"),
    @NamedQuery(name = "PagComprobantes.findByComTotTot", query = "SELECT p FROM PagComprobantes p WHERE p.comTotTot = :comTotTot")})
public class PagComprobantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COM_ID_TRAN", nullable = false)
    private Integer comIdTran;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "COM_CONC", nullable = false, length = 4)
    private String comConc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COM_NUM_DOC", nullable = false)
    private int comNumDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "COM_TIP_DOC", nullable = false, length = 2)
    private String comTipDoc;
    @Size(max = 12)
    @Column(name = "COM_TIMBRADO", length = 12)
    private String comTimbrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COM_ESTADO", nullable = false)
    private Character comEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COM_FEC_EMIS", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date comFecEmis;
    @Column(name = "COM_FEC_VENC")
    @Temporal(TemporalType.DATE)
    private Date comFecVenc;
    @Column(name = "COM_CONDICION")
    private Character comCondicion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COM_COTIZACION", precision = 8, scale = 2)
    private BigDecimal comCotizacion;
    @Size(max = 2147483647)
    @Column(name = "COM_OBSERVACION", length = 2147483647)
    private String comObservacion;
    @Column(name = "COM_TOT_EXE", precision = 18, scale = 2)
    private BigDecimal comTotExe;
    @Column(name = "COM_TOT_GRA", precision = 18, scale = 2)
    private BigDecimal comTotGra;
    @Column(name = "COM_TOT_IMP", precision = 18, scale = 2)
    private BigDecimal comTotImp;
    @Column(name = "COM_TOT_TOT", precision = 18, scale = 2)
    private BigDecimal comTotTot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagComprobantes")
    private List<PagComprobantesDet> pagComprobantesDetList;

    public PagComprobantes() {
    }

    public PagComprobantes(Integer comIdTran) {
        this.comIdTran = comIdTran;
    }

    public PagComprobantes(Integer comIdTran, String comConc, int comNumDoc, String comTipDoc, Character comEstado, Date comFecEmis) {
        this.comIdTran = comIdTran;
        this.comConc = comConc;
        this.comNumDoc = comNumDoc;
        this.comTipDoc = comTipDoc;
        this.comEstado = comEstado;
        this.comFecEmis = comFecEmis;
    }

    public Integer getComIdTran() {
        return comIdTran;
    }

    public void setComIdTran(Integer comIdTran) {
        this.comIdTran = comIdTran;
    }

    public String getComConc() {
        return comConc;
    }

    public void setComConc(String comConc) {
        this.comConc = comConc;
    }

    public int getComNumDoc() {
        return comNumDoc;
    }

    public void setComNumDoc(int comNumDoc) {
        this.comNumDoc = comNumDoc;
    }

    public String getComTipDoc() {
        return comTipDoc;
    }

    public void setComTipDoc(String comTipDoc) {
        this.comTipDoc = comTipDoc;
    }

    public String getComTimbrado() {
        return comTimbrado;
    }

    public void setComTimbrado(String comTimbrado) {
        this.comTimbrado = comTimbrado;
    }

    public Character getComEstado() {
        return comEstado;
    }

    public void setComEstado(Character comEstado) {
        this.comEstado = comEstado;
    }

    public Date getComFecEmis() {
        return comFecEmis;
    }

    public void setComFecEmis(Date comFecEmis) {
        this.comFecEmis = comFecEmis;
    }

    public Date getComFecVenc() {
        return comFecVenc;
    }

    public void setComFecVenc(Date comFecVenc) {
        this.comFecVenc = comFecVenc;
    }

    public Character getComCondicion() {
        return comCondicion;
    }

    public void setComCondicion(Character comCondicion) {
        this.comCondicion = comCondicion;
    }

    public BigDecimal getComCotizacion() {
        return comCotizacion;
    }

    public void setComCotizacion(BigDecimal comCotizacion) {
        this.comCotizacion = comCotizacion;
    }

    public String getComObservacion() {
        return comObservacion;
    }

    public void setComObservacion(String comObservacion) {
        this.comObservacion = comObservacion;
    }

    public BigDecimal getComTotExe() {
        return comTotExe;
    }

    public void setComTotExe(BigDecimal comTotExe) {
        this.comTotExe = comTotExe;
    }

    public BigDecimal getComTotGra() {
        return comTotGra;
    }

    public void setComTotGra(BigDecimal comTotGra) {
        this.comTotGra = comTotGra;
    }

    public BigDecimal getComTotImp() {
        return comTotImp;
    }

    public void setComTotImp(BigDecimal comTotImp) {
        this.comTotImp = comTotImp;
    }

    public BigDecimal getComTotTot() {
        return comTotTot;
    }

    public void setComTotTot(BigDecimal comTotTot) {
        this.comTotTot = comTotTot;
    }

    public List<PagComprobantesDet> getPagComprobantesDetList() {
        return pagComprobantesDetList;
    }

    public void setPagComprobantesDetList(List<PagComprobantesDet> pagComprobantesDetList) {
        this.pagComprobantesDetList = pagComprobantesDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comIdTran != null ? comIdTran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagComprobantes)) {
            return false;
        }
        PagComprobantes other = (PagComprobantes) object;
        if ((this.comIdTran == null && other.comIdTran != null) || (this.comIdTran != null && !this.comIdTran.equals(other.comIdTran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PagComprobantes[ comIdTran=" + comIdTran + " ]";
    }
    
}
