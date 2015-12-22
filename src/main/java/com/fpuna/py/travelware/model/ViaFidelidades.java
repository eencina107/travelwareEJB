/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "via_fidelidades", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"per_id", "org_id"})})
@NamedQueries({
    @NamedQuery(name = "ViaFidelidades.findAll", query = "SELECT v FROM ViaFidelidades v"),
    @NamedQuery(name = "ViaFidelidades.findByFidUsuIns", query = "SELECT v FROM ViaFidelidades v WHERE v.fidUsuIns = :fidUsuIns"),
    @NamedQuery(name = "ViaFidelidades.findByFidFecIns", query = "SELECT v FROM ViaFidelidades v WHERE v.fidFecIns = :fidFecIns"),
    @NamedQuery(name = "ViaFidelidades.findByFidUsuMod", query = "SELECT v FROM ViaFidelidades v WHERE v.fidUsuMod = :fidUsuMod"),
    @NamedQuery(name = "ViaFidelidades.findByFidFecMod", query = "SELECT v FROM ViaFidelidades v WHERE v.fidFecMod = :fidFecMod"),
    @NamedQuery(name = "ViaFidelidades.findByFidId", query = "SELECT v FROM ViaFidelidades v WHERE v.fidId = :fidId")})
public class ViaFidelidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fid_usu_ins", nullable = false, length = 10)
    private String fidUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fid_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fidFecIns;
    @Size(max = 10)
    @Column(name = "fid_usu_mod", length = 10)
    private String fidUsuMod;
    @Column(name = "fid_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fidFecMod;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fid_id", nullable = false)
    private Integer fidId;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id", nullable = false)
    @ManyToOne(optional = false)
    private PgePersonas perId;
    @JoinColumn(name = "org_id", referencedColumnName = "org_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeOrganizaciones orgId;

    public ViaFidelidades() {
    }

    public ViaFidelidades(Integer fidId) {
        this.fidId = fidId;
    }

    public ViaFidelidades(Integer fidId, String fidUsuIns, Date fidFecIns) {
        this.fidId = fidId;
        this.fidUsuIns = fidUsuIns;
        this.fidFecIns = fidFecIns;
    }

    public String getFidUsuIns() {
        return fidUsuIns;
    }

    public void setFidUsuIns(String fidUsuIns) {
        this.fidUsuIns = fidUsuIns;
    }

    public Date getFidFecIns() {
        return fidFecIns;
    }

    public void setFidFecIns(Date fidFecIns) {
        this.fidFecIns = fidFecIns;
    }

    public String getFidUsuMod() {
        return fidUsuMod;
    }

    public void setFidUsuMod(String fidUsuMod) {
        this.fidUsuMod = fidUsuMod;
    }

    public Date getFidFecMod() {
        return fidFecMod;
    }

    public void setFidFecMod(Date fidFecMod) {
        this.fidFecMod = fidFecMod;
    }

    public Integer getFidId() {
        return fidId;
    }

    public void setFidId(Integer fidId) {
        this.fidId = fidId;
    }

    public PgePersonas getPerId() {
        return perId;
    }

    public void setPerId(PgePersonas perId) {
        this.perId = perId;
    }

    public PgeOrganizaciones getOrgId() {
        return orgId;
    }

    public void setOrgId(PgeOrganizaciones orgId) {
        this.orgId = orgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fidId != null ? fidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaFidelidades)) {
            return false;
        }
        ViaFidelidades other = (ViaFidelidades) object;
        if ((this.fidId == null && other.fidId != null) || (this.fidId != null && !this.fidId.equals(other.fidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ViaFidelidades[ fidId=" + fidId + " ]";
    }
    
}
