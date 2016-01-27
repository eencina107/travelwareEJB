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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pag_comprobantes", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"com_conc", "com_tip_doc", "com_num_doc", "com_estado"})})
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
    @NamedQuery(name = "PagComprobantes.findByComTotTot", query = "SELECT p FROM PagComprobantes p WHERE p.comTotTot = :comTotTot"),
    @NamedQuery(name = "PagComprobantes.findByComUsuIns", query = "SELECT p FROM PagComprobantes p WHERE p.comUsuIns = :comUsuIns"),
    @NamedQuery(name = "PagComprobantes.findByComFecIns", query = "SELECT p FROM PagComprobantes p WHERE p.comFecIns = :comFecIns"),
    @NamedQuery(name = "PagComprobantes.findByComUsuMod", query = "SELECT p FROM PagComprobantes p WHERE p.comUsuMod = :comUsuMod"),
    @NamedQuery(name = "PagComprobantes.findByComFecMod", query = "SELECT p FROM PagComprobantes p WHERE p.comFecMod = :comFecMod")})
public class PagComprobantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "com_id_tran", nullable = false)
    private Integer comIdTran;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "com_conc", nullable = false, length = 4)
    private String comConc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "com_num_doc", nullable = false)
    private int comNumDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "com_tip_doc", nullable = false, length = 2)
    private String comTipDoc;
    @Size(max = 12)
    @Column(name = "com_timbrado", length = 12)
    private String comTimbrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "com_estado", nullable = false)
    private Character comEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "com_fec_emis", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date comFecEmis;
    @Column(name = "com_fec_venc")
    @Temporal(TemporalType.DATE)
    private Date comFecVenc;
    @Column(name = "com_condicion")
    private Character comCondicion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "com_cotizacion", precision = 8, scale = 2)
    private BigDecimal comCotizacion;
    @Size(max = 2147483647)
    @Column(name = "com_observacion", length = 2147483647)
    private String comObservacion;
    @Column(name = "com_tot_exe", precision = 18, scale = 2)
    private BigDecimal comTotExe;
    @Column(name = "com_tot_gra", precision = 18, scale = 2)
    private BigDecimal comTotGra;
    @Column(name = "com_tot_imp", precision = 18, scale = 2)
    private BigDecimal comTotImp;
    @Column(name = "com_tot_tot", precision = 18, scale = 2)
    private BigDecimal comTotTot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "com_usu_ins", nullable = false, length = 10)
    private String comUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "com_fec_ins", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date comFecIns;
    @Size(max = 10)
    @Column(name = "com_usu_mod", length = 10)
    private String comUsuMod;
    @Column(name = "com_fec_mod")
    @Temporal(TemporalType.DATE)
    private Date comFecMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comId")
    private List<PagComprobantesDet> pagComprobantesDetList;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id", nullable = false)
    @ManyToOne(optional = false)
    private PgePersonas perId;
    @JoinColumn(name = "mon_id", referencedColumnName = "mon_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeMonedas monId;

    public PagComprobantes() {
    }

    public PagComprobantes(Integer comIdTran) {
        this.comIdTran = comIdTran;
    }

    public PagComprobantes(Integer comIdTran, String comConc, int comNumDoc, String comTipDoc, Character comEstado, Date comFecEmis, String comUsuIns, Date comFecIns) {
        this.comIdTran = comIdTran;
        this.comConc = comConc;
        this.comNumDoc = comNumDoc;
        this.comTipDoc = comTipDoc;
        this.comEstado = comEstado;
        this.comFecEmis = comFecEmis;
        this.comUsuIns = comUsuIns;
        this.comFecIns = comFecIns;
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

    public String getComUsuIns() {
        return comUsuIns;
    }

    public void setComUsuIns(String comUsuIns) {
        this.comUsuIns = comUsuIns;
    }

    public Date getComFecIns() {
        return comFecIns;
    }

    public void setComFecIns(Date comFecIns) {
        this.comFecIns = comFecIns;
    }

    public String getComUsuMod() {
        return comUsuMod;
    }

    public void setComUsuMod(String comUsuMod) {
        this.comUsuMod = comUsuMod;
    }

    public Date getComFecMod() {
        return comFecMod;
    }

    public void setComFecMod(Date comFecMod) {
        this.comFecMod = comFecMod;
    }

    public List<PagComprobantesDet> getPagComprobantesDetList() {
        return pagComprobantesDetList;
    }

    public void setPagComprobantesDetList(List<PagComprobantesDet> pagComprobantesDetList) {
        this.pagComprobantesDetList = pagComprobantesDetList;
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
