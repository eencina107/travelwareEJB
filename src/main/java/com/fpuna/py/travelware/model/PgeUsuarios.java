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
@Table(name = "PGE_USUARIOS")
@NamedQueries({
    @NamedQuery(name = "PgeUsuarios.findAll", query = "SELECT p FROM PgeUsuarios p"),
    @NamedQuery(name = "PgeUsuarios.findByUsuId", query = "SELECT p FROM PgeUsuarios p WHERE p.usuId = :usuId"),
    @NamedQuery(name = "PgeUsuarios.findByUsuNomApe", query = "SELECT p FROM PgeUsuarios p WHERE p.usuNomApe = :usuNomApe"),
    @NamedQuery(name = "PgeUsuarios.findByUsuCat", query = "SELECT p FROM PgeUsuarios p WHERE p.usuCat = :usuCat"),
    @NamedQuery(name = "PgeUsuarios.findByUsuEst", query = "SELECT p FROM PgeUsuarios p WHERE p.usuEst = :usuEst"),
    @NamedQuery(name = "PgeUsuarios.findByUsuFecIng", query = "SELECT p FROM PgeUsuarios p WHERE p.usuFecIng = :usuFecIng"),
    @NamedQuery(name = "PgeUsuarios.findByUsuCod", query = "SELECT p FROM PgeUsuarios p WHERE p.usuCod = :usuCod"),
    @NamedQuery(name = "PgeUsuarios.findByUsuCargo", query = "SELECT p FROM PgeUsuarios p WHERE p.usuCargo = :usuCargo"),
    @NamedQuery(name = "PgeUsuarios.findByUsuUsuIns", query = "SELECT p FROM PgeUsuarios p WHERE p.usuUsuIns = :usuUsuIns"),
    @NamedQuery(name = "PgeUsuarios.findByUsuFecIns", query = "SELECT p FROM PgeUsuarios p WHERE p.usuFecIns = :usuFecIns"),
    @NamedQuery(name = "PgeUsuarios.findByUsuUsuMod", query = "SELECT p FROM PgeUsuarios p WHERE p.usuUsuMod = :usuUsuMod"),
    @NamedQuery(name = "PgeUsuarios.findByUsuFecMod", query = "SELECT p FROM PgeUsuarios p WHERE p.usuFecMod = :usuFecMod")})
public class PgeUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USU_ID")
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USU_NOM_APE")
    private String usuNomApe;
    @Size(max = 2)
    @Column(name = "USU_CAT")
    private String usuCat;
    @Column(name = "USU_EST")
    private Character usuEst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_FEC_ING")
    @Temporal(TemporalType.DATE)
    private Date usuFecIng;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USU_COD")
    private String usuCod;
    @Size(max = 60)
    @Column(name = "USU_CARGO")
    private String usuCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USU_USU_INS")
    private String usuUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_FEC_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFecIns;
    @Size(max = 10)
    @Column(name = "USU_USU_MOD")
    private String usuUsuMod;
    @Column(name = "USU_FEC_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFecMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgeUsuarios")
    private List<PgeUsuRoles> pgeUsuRolesList;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
    @ManyToOne(optional = false)
    private PgePersonas perId;

    public PgeUsuarios() {
    }

    public PgeUsuarios(Integer usuId) {
        this.usuId = usuId;
    }

    public PgeUsuarios(Integer usuId, String usuNomApe, Date usuFecIng, String usuCod, String usuUsuIns, Date usuFecIns) {
        this.usuId = usuId;
        this.usuNomApe = usuNomApe;
        this.usuFecIng = usuFecIng;
        this.usuCod = usuCod;
        this.usuUsuIns = usuUsuIns;
        this.usuFecIns = usuFecIns;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuNomApe() {
        return usuNomApe;
    }

    public void setUsuNomApe(String usuNomApe) {
        this.usuNomApe = usuNomApe;
    }

    public String getUsuCat() {
        return usuCat;
    }

    public void setUsuCat(String usuCat) {
        this.usuCat = usuCat;
    }

    public Character getUsuEst() {
        return usuEst;
    }

    public void setUsuEst(Character usuEst) {
        this.usuEst = usuEst;
    }

    public Date getUsuFecIng() {
        return usuFecIng;
    }

    public void setUsuFecIng(Date usuFecIng) {
        this.usuFecIng = usuFecIng;
    }

    public String getUsuCod() {
        return usuCod;
    }

    public void setUsuCod(String usuCod) {
        this.usuCod = usuCod;
    }

    public String getUsuCargo() {
        return usuCargo;
    }

    public void setUsuCargo(String usuCargo) {
        this.usuCargo = usuCargo;
    }

    public String getUsuUsuIns() {
        return usuUsuIns;
    }

    public void setUsuUsuIns(String usuUsuIns) {
        this.usuUsuIns = usuUsuIns;
    }

    public Date getUsuFecIns() {
        return usuFecIns;
    }

    public void setUsuFecIns(Date usuFecIns) {
        this.usuFecIns = usuFecIns;
    }

    public String getUsuUsuMod() {
        return usuUsuMod;
    }

    public void setUsuUsuMod(String usuUsuMod) {
        this.usuUsuMod = usuUsuMod;
    }

    public Date getUsuFecMod() {
        return usuFecMod;
    }

    public void setUsuFecMod(Date usuFecMod) {
        this.usuFecMod = usuFecMod;
    }

    public List<PgeUsuRoles> getPgeUsuRolesList() {
        return pgeUsuRolesList;
    }

    public void setPgeUsuRolesList(List<PgeUsuRoles> pgeUsuRolesList) {
        this.pgeUsuRolesList = pgeUsuRolesList;
    }

    public PgePersonas getPerId() {
        return perId;
    }

    public void setPerId(PgePersonas perId) {
        this.perId = perId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeUsuarios)) {
            return false;
        }
        PgeUsuarios other = (PgeUsuarios) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.PgeUsuarios[ usuId=" + usuId + " ]";
    }
    
}
