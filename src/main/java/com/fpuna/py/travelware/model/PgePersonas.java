/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ViaPasaportes;
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
import javax.persistence.OneToOne;
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
@Table(name = "pge_personas", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgePersonas.findAll", query = "SELECT p FROM PgePersonas p"),
    @NamedQuery(name = "PgePersonas.findByPerId", query = "SELECT p FROM PgePersonas p WHERE p.perId = :perId"),
    @NamedQuery(name = "PgePersonas.findByPerNom", query = "SELECT p FROM PgePersonas p WHERE p.perNom = :perNom"),
    @NamedQuery(name = "PgePersonas.findByPerApe", query = "SELECT p FROM PgePersonas p WHERE p.perApe = :perApe"),
    @NamedQuery(name = "PgePersonas.findByPerNroDoc", query = "SELECT p FROM PgePersonas p WHERE p.perNroDoc = :perNroDoc"),
    @NamedQuery(name = "PgePersonas.findByPerFecNac", query = "SELECT p FROM PgePersonas p WHERE p.perFecNac = :perFecNac"),
    @NamedQuery(name = "PgePersonas.findByPerLugNac", query = "SELECT p FROM PgePersonas p WHERE p.perLugNac = :perLugNac"),
    @NamedQuery(name = "PgePersonas.findByPerEmail", query = "SELECT p FROM PgePersonas p WHERE p.perEmail = :perEmail"),
    @NamedQuery(name = "PgePersonas.findByPerUsuIns", query = "SELECT p FROM PgePersonas p WHERE p.perUsuIns = :perUsuIns"),
    @NamedQuery(name = "PgePersonas.findByPerFecIns", query = "SELECT p FROM PgePersonas p WHERE p.perFecIns = :perFecIns"),
    @NamedQuery(name = "PgePersonas.findByPerUsuMod", query = "SELECT p FROM PgePersonas p WHERE p.perUsuMod = :perUsuMod"),
    @NamedQuery(name = "PgePersonas.findByPerFecMod", query = "SELECT p FROM PgePersonas p WHERE p.perFecMod = :perFecMod"),
    @NamedQuery(name = "PgePersonas.findByPerDoc", query = "SELECT p FROM PgePersonas p WHERE p.perDoc = :perDoc")})
public class PgePersonas implements Serializable {
    @OneToMany(mappedBy = "perId")
    private List<PgeDirecciones> pgeDireccionesList;
    @OneToMany(mappedBy = "perId")
    private List<ViaGastos> viaGastosList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "perId")
    private ViaPasaportes viaPasaportes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perId")
    private List<ViaPasaportes> viaPasaportesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perId")
    private List<PgeUsuarios> pgeUsuariosList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_id", nullable = false)
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "per_nom", nullable = false, length = 35)
    private String perNom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "per_ape", nullable = false, length = 35)
    private String perApe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "per_nro_doc", nullable = false, length = 12)
    private String perNroDoc;
    @Column(name = "per_fec_nac")
    @Temporal(TemporalType.DATE)
    private Date perFecNac;
    @Size(max = 30)
    @Column(name = "per_lug_nac", length = 30)
    private String perLugNac;
    @Size(max = 50)
    @Column(name = "per_email", length = 50)
    private String perEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "per_usu_ins", nullable = false, length = 10)
    private String perUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFecIns;
    @Size(max = 10)
    @Column(name = "per_usu_mod", length = 10)
    private String perUsuMod;
    @Column(name = "per_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFecMod;
    @Size(max = 2147483647)
    @Column(name = "per_doc", length = 2147483647)
    private String perDoc;
    @JoinColumn(name = "prf_id", referencedColumnName = "prf_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeProfesiones prfId;
    @JoinColumn(name = "pai_id", referencedColumnName = "pai_id", nullable = false)
    @ManyToOne(optional = false)
    private PgePaises paiId;

    public PgePersonas() {
    }

    public PgePersonas(Integer perId) {
        this.perId = perId;
    }

    public PgePersonas(Integer perId, String perNom, String perApe, String perNroDoc, String perUsuIns, Date perFecIns) {
        this.perId = perId;
        this.perNom = perNom;
        this.perApe = perApe;
        this.perNroDoc = perNroDoc;
        this.perUsuIns = perUsuIns;
        this.perFecIns = perFecIns;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNom() {
        return perNom;
    }

    public void setPerNom(String perNom) {
        this.perNom = perNom;
    }

    public String getPerApe() {
        return perApe;
    }

    public void setPerApe(String perApe) {
        this.perApe = perApe;
    }

    public String getPerNroDoc() {
        return perNroDoc;
    }

    public void setPerNroDoc(String perNroDoc) {
        this.perNroDoc = perNroDoc;
    }

    public Date getPerFecNac() {
        return perFecNac;
    }

    public void setPerFecNac(Date perFecNac) {
        this.perFecNac = perFecNac;
    }

    public String getPerLugNac() {
        return perLugNac;
    }

    public void setPerLugNac(String perLugNac) {
        this.perLugNac = perLugNac;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getPerUsuIns() {
        return perUsuIns;
    }

    public void setPerUsuIns(String perUsuIns) {
        this.perUsuIns = perUsuIns;
    }

    public Date getPerFecIns() {
        return perFecIns;
    }

    public void setPerFecIns(Date perFecIns) {
        this.perFecIns = perFecIns;
    }

    public String getPerUsuMod() {
        return perUsuMod;
    }

    public void setPerUsuMod(String perUsuMod) {
        this.perUsuMod = perUsuMod;
    }

    public Date getPerFecMod() {
        return perFecMod;
    }

    public void setPerFecMod(Date perFecMod) {
        this.perFecMod = perFecMod;
    }

    public String getPerDoc() {
        return perDoc;
    }

    public void setPerDoc(String perDoc) {
        this.perDoc = perDoc;
    }

    public PgeProfesiones getPrfId() {
        return prfId;
    }

    public void setPrfId(PgeProfesiones prfId) {
        this.prfId = prfId;
    }

    public PgePaises getPaiId() {
        return paiId;
    }

    public void setPaiId(PgePaises paiId) {
        this.paiId = paiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgePersonas)) {
            return false;
        }
        PgePersonas other = (PgePersonas) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgePersonas[ perId=" + perId + " ]";
    }

    public List<PgeUsuarios> getPgeUsuariosList() {
        return pgeUsuariosList;
    }

    public void setPgeUsuariosList(List<PgeUsuarios> pgeUsuariosList) {
        this.pgeUsuariosList = pgeUsuariosList;
    }

    public List<ViaPasaportes> getViaPasaportesList() {
        return viaPasaportesList;
    }

    public void setViaPasaportesList(List<ViaPasaportes> viaPasaportesList) {
        this.viaPasaportesList = viaPasaportesList;
    }

    public ViaPasaportes getViaPasaportes() {
        return viaPasaportes;
    }

    public void setViaPasaportes(ViaPasaportes viaPasaportes) {
        this.viaPasaportes = viaPasaportes;
    }

    public List<PgeDirecciones> getPgeDireccionesList() {
        return pgeDireccionesList;
    }

    public void setPgeDireccionesList(List<PgeDirecciones> pgeDireccionesList) {
        this.pgeDireccionesList = pgeDireccionesList;
    }

    public List<ViaGastos> getViaGastosList() {
        return viaGastosList;
    }

    public void setViaGastosList(List<ViaGastos> viaGastosList) {
        this.viaGastosList = viaGastosList;
    }
    
}
