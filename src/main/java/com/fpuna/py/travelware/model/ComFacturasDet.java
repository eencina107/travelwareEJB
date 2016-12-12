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
@Table(name = "com_facturas_det", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ComFacturasDet.findAll", query = "SELECT c FROM ComFacturasDet c"),
    @NamedQuery(name = "ComFacturasDet.findByFadId", query = "SELECT c FROM ComFacturasDet c WHERE c.fadId = :fadId"),
    @NamedQuery(name = "ComFacturasDet.findByFadNroSec", query = "SELECT c FROM ComFacturasDet c WHERE c.fadNroSec = :fadNroSec"),
    @NamedQuery(name = "ComFacturasDet.findByFadDesc", query = "SELECT c FROM ComFacturasDet c WHERE c.fadDesc = :fadDesc"),
    @NamedQuery(name = "ComFacturasDet.findByArtId", query = "SELECT c FROM ComFacturasDet c WHERE c.artId = :artId"),
    @NamedQuery(name = "ComFacturasDet.findByFadCant", query = "SELECT c FROM ComFacturasDet c WHERE c.fadCant = :fadCant"),
    @NamedQuery(name = "ComFacturasDet.findByFadValUni", query = "SELECT c FROM ComFacturasDet c WHERE c.fadValUni = :fadValUni"),
    @NamedQuery(name = "ComFacturasDet.findByFadValor", query = "SELECT c FROM ComFacturasDet c WHERE c.fadValor = :fadValor"),
    @NamedQuery(name = "ComFacturasDet.findByFadPorImp", query = "SELECT c FROM ComFacturasDet c WHERE c.fadPorImp = :fadPorImp"),
    @NamedQuery(name = "ComFacturasDet.findByFadMtoGra", query = "SELECT c FROM ComFacturasDet c WHERE c.fadMtoGra = :fadMtoGra"),
    @NamedQuery(name = "ComFacturasDet.findByFadMtoImp", query = "SELECT c FROM ComFacturasDet c WHERE c.fadMtoImp = :fadMtoImp"),
    @NamedQuery(name = "ComFacturasDet.findByFadMtoExe", query = "SELECT c FROM ComFacturasDet c WHERE c.fadMtoExe = :fadMtoExe"),
    @NamedQuery(name = "ComFacturasDet.findByFadMtoTot", query = "SELECT c FROM ComFacturasDet c WHERE c.fadMtoTot = :fadMtoTot"),
    @NamedQuery(name = "ComFacturasDet.findByFadUsuIns", query = "SELECT c FROM ComFacturasDet c WHERE c.fadUsuIns = :fadUsuIns"),
    @NamedQuery(name = "ComFacturasDet.findByFadFecIns", query = "SELECT c FROM ComFacturasDet c WHERE c.fadFecIns = :fadFecIns"),
    @NamedQuery(name = "ComFacturasDet.findByFadUsuMod", query = "SELECT c FROM ComFacturasDet c WHERE c.fadUsuMod = :fadUsuMod"),
    @NamedQuery(name = "ComFacturasDet.findByFadFecMod", query = "SELECT c FROM ComFacturasDet c WHERE c.fadFecMod = :fadFecMod"),
    @NamedQuery(name = "ComFacturasDet.findByFadUti", query = "SELECT c FROM ComFacturasDet c WHERE c.fadUti = :fadUti")})
public class ComFacturasDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fad_id", nullable = false)
    private Integer fadId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fad_nro_sec", nullable = false)
    private int fadNroSec;
    @Size(max = 250)
    @Column(name = "fad_desc", length = 250)
    private String fadDesc;
    @Column(name = "art_id")
    private Integer artId;
    @Column(name = "fad_cant")
    private Integer fadCant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fad_val_uni", precision = 18, scale = 2)
    private BigDecimal fadValUni;
    @Column(name = "fad_valor", precision = 18, scale = 2)
    private BigDecimal fadValor;
    @Column(name = "fad_por_imp", precision = 4, scale = 2)
    private BigDecimal fadPorImp;
    @Column(name = "fad_mto_gra", precision = 18, scale = 2)
    private BigDecimal fadMtoGra;
    @Column(name = "fad_mto_imp", precision = 18, scale = 2)
    private BigDecimal fadMtoImp;
    @Column(name = "fad_mto_exe", precision = 18, scale = 2)
    private BigDecimal fadMtoExe;
    @Column(name = "fad_mto_tot", precision = 18, scale = 2)
    private BigDecimal fadMtoTot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fad_usu_ins", nullable = false, length = 10)
    private String fadUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fad_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fadFecIns;
    @Size(max = 10)
    @Column(name = "fad_usu_mod", length = 10)
    private String fadUsuMod;
    @Column(name = "fad_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fadFecMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fad_uti", nullable = false)
    private Character fadUti;
    @JoinColumn(name = "fac_id", referencedColumnName = "fac_id", nullable = false)
    @ManyToOne(optional = false)
    private ComFacturas facId;
    @JoinColumn(name = "con_id", referencedColumnName = "con_id")
    @ManyToOne
    private ViaConceptos conId;
    @JoinColumn(name = "via_det_id", referencedColumnName = "vid_id")
    @ManyToOne
    private ViaViajesDet viaDetId;
    @OneToMany(mappedBy = "fadId")
    private List<ViaViajesDet> viaViajesDetList;

    public ComFacturasDet() {
    }

    public ComFacturasDet(Integer fadId) {
        this.fadId = fadId;
    }

    public ComFacturasDet(Integer fadId, int fadNroSec, String fadUsuIns, Date fadFecIns, Character fadUti) {
        this.fadId = fadId;
        this.fadNroSec = fadNroSec;
        this.fadUsuIns = fadUsuIns;
        this.fadFecIns = fadFecIns;
        this.fadUti = fadUti;
    }

    public Integer getFadId() {
        return fadId;
    }

    public void setFadId(Integer fadId) {
        this.fadId = fadId;
    }

    public int getFadNroSec() {
        return fadNroSec;
    }

    public void setFadNroSec(int fadNroSec) {
        this.fadNroSec = fadNroSec;
    }

    public String getFadDesc() {
        return fadDesc;
    }

    public void setFadDesc(String fadDesc) {
        this.fadDesc = fadDesc;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public Integer getFadCant() {
        return fadCant;
    }

    public void setFadCant(Integer fadCant) {
        this.fadCant = fadCant;
    }

    public BigDecimal getFadValUni() {
        return fadValUni;
    }

    public void setFadValUni(BigDecimal fadValUni) {
        this.fadValUni = fadValUni;
    }

    public BigDecimal getFadValor() {
        return fadValor;
    }

    public void setFadValor(BigDecimal fadValor) {
        this.fadValor = fadValor;
    }

    public BigDecimal getFadPorImp() {
        return fadPorImp;
    }

    public void setFadPorImp(BigDecimal fadPorImp) {
        this.fadPorImp = fadPorImp;
    }

    public BigDecimal getFadMtoGra() {
        return fadMtoGra;
    }

    public void setFadMtoGra(BigDecimal fadMtoGra) {
        this.fadMtoGra = fadMtoGra;
    }

    public BigDecimal getFadMtoImp() {
        return fadMtoImp;
    }

    public void setFadMtoImp(BigDecimal fadMtoImp) {
        this.fadMtoImp = fadMtoImp;
    }

    public BigDecimal getFadMtoExe() {
        return fadMtoExe;
    }

    public void setFadMtoExe(BigDecimal fadMtoExe) {
        this.fadMtoExe = fadMtoExe;
    }

    public BigDecimal getFadMtoTot() {
        return fadMtoTot;
    }

    public void setFadMtoTot(BigDecimal fadMtoTot) {
        this.fadMtoTot = fadMtoTot;
    }

    public String getFadUsuIns() {
        return fadUsuIns;
    }

    public void setFadUsuIns(String fadUsuIns) {
        this.fadUsuIns = fadUsuIns;
    }

    public Date getFadFecIns() {
        return fadFecIns;
    }

    public void setFadFecIns(Date fadFecIns) {
        this.fadFecIns = fadFecIns;
    }

    public String getFadUsuMod() {
        return fadUsuMod;
    }

    public void setFadUsuMod(String fadUsuMod) {
        this.fadUsuMod = fadUsuMod;
    }

    public Date getFadFecMod() {
        return fadFecMod;
    }

    public void setFadFecMod(Date fadFecMod) {
        this.fadFecMod = fadFecMod;
    }

    public Character getFadUti() {
        return fadUti;
    }

    public void setFadUti(Character fadUti) {
        this.fadUti = fadUti;
    }

    public ComFacturas getFacId() {
        return facId;
    }

    public void setFacId(ComFacturas facId) {
        this.facId = facId;
    }

    public ViaConceptos getConId() {
        return conId;
    }

    public void setConId(ViaConceptos conId) {
        this.conId = conId;
    }

    public ViaViajesDet getViaDetId() {
        return viaDetId;
    }

    public void setViaDetId(ViaViajesDet viaDetId) {
        this.viaDetId = viaDetId;
    }

    public List<ViaViajesDet> getViaViajesDetList() {
        return viaViajesDetList;
    }

    public void setViaViajesDetList(List<ViaViajesDet> viaViajesDetList) {
        this.viaViajesDetList = viaViajesDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fadId != null ? fadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComFacturasDet)) {
            return false;
        }
        ComFacturasDet other = (ComFacturasDet) object;
        if ((this.fadId == null && other.fadId != null) || (this.fadId != null && !this.fadId.equals(other.fadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ComFacturasDet[ fadId=" + fadId + " ]";
    }
    
}
