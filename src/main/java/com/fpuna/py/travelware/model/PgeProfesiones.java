/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

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
@Table(name = "pge_profesiones", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgeProfesiones.findAll", query = "SELECT p FROM PgeProfesiones p"),
    @NamedQuery(name = "PgeProfesiones.findByPrfId", query = "SELECT p FROM PgeProfesiones p WHERE p.prfId = :prfId"),
    @NamedQuery(name = "PgeProfesiones.findByPrfDesc", query = "SELECT p FROM PgeProfesiones p WHERE p.prfDesc = :prfDesc"),
    @NamedQuery(name = "PgeProfesiones.findByPrfObs", query = "SELECT p FROM PgeProfesiones p WHERE p.prfObs = :prfObs"),
    @NamedQuery(name = "PgeProfesiones.findByPrfUsuIns", query = "SELECT p FROM PgeProfesiones p WHERE p.prfUsuIns = :prfUsuIns"),
    @NamedQuery(name = "PgeProfesiones.findByPrfFecIns", query = "SELECT p FROM PgeProfesiones p WHERE p.prfFecIns = :prfFecIns"),
    @NamedQuery(name = "PgeProfesiones.findByPrfUsuMod", query = "SELECT p FROM PgeProfesiones p WHERE p.prfUsuMod = :prfUsuMod"),
    @NamedQuery(name = "PgeProfesiones.findByPrfFecMod", query = "SELECT p FROM PgeProfesiones p WHERE p.prfFecMod = :prfFecMod")})
public class PgeProfesiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prf_id", nullable = false)
    private Integer prfId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "prf_desc", nullable = false, length = 35)
    private String prfDesc;
    @Size(max = 50)
    @Column(name = "prf_obs", length = 50)
    private String prfObs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "prf_usu_ins", nullable = false, length = 10)
    private String prfUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prf_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date prfFecIns;
    @Size(max = 10)
    @Column(name = "prf_usu_mod", length = 10)
    private String prfUsuMod;
    @Column(name = "prf_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prfFecMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prfId")
    private List<PgePersonas> pgePersonasList;

    public PgeProfesiones() {
    }

    public PgeProfesiones(Integer prfId) {
        this.prfId = prfId;
    }

    public PgeProfesiones(Integer prfId, String prfDesc, String prfUsuIns, Date prfFecIns) {
        this.prfId = prfId;
        this.prfDesc = prfDesc;
        this.prfUsuIns = prfUsuIns;
        this.prfFecIns = prfFecIns;
    }

    public Integer getPrfId() {
        return prfId;
    }

    public void setPrfId(Integer prfId) {
        this.prfId = prfId;
    }

    public String getPrfDesc() {
        return prfDesc;
    }

    public void setPrfDesc(String prfDesc) {
        this.prfDesc = prfDesc;
    }

    public String getPrfObs() {
        return prfObs;
    }

    public void setPrfObs(String prfObs) {
        this.prfObs = prfObs;
    }

    public String getPrfUsuIns() {
        return prfUsuIns;
    }

    public void setPrfUsuIns(String prfUsuIns) {
        this.prfUsuIns = prfUsuIns;
    }

    public Date getPrfFecIns() {
        return prfFecIns;
    }

    public void setPrfFecIns(Date prfFecIns) {
        this.prfFecIns = prfFecIns;
    }

    public String getPrfUsuMod() {
        return prfUsuMod;
    }

    public void setPrfUsuMod(String prfUsuMod) {
        this.prfUsuMod = prfUsuMod;
    }

    public Date getPrfFecMod() {
        return prfFecMod;
    }

    public void setPrfFecMod(Date prfFecMod) {
        this.prfFecMod = prfFecMod;
    }

    public List<PgePersonas> getPgePersonasList() {
        return pgePersonasList;
    }

    public void setPgePersonasList(List<PgePersonas> pgePersonasList) {
        this.pgePersonasList = pgePersonasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prfId != null ? prfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeProfesiones)) {
            return false;
        }
        PgeProfesiones other = (PgeProfesiones) object;
        if ((this.prfId == null && other.prfId != null) || (this.prfId != null && !this.prfId.equals(other.prfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeProfesiones[ prfId=" + prfId + " ]";
    }
    
}
