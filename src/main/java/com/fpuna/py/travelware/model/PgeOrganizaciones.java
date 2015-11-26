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
import javax.persistence.Lob;
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
@Table(name = "pge_organizaciones", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ciu_id", "org_id"})})
@NamedQueries({
    @NamedQuery(name = "PgeOrganizaciones.findAll", query = "SELECT p FROM PgeOrganizaciones p"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgId", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgId = :orgId"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgDesc", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgDesc = :orgDesc"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgDir", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgDir = :orgDir"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgTel", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgTel = :orgTel"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgTipo", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgTipo = :orgTipo"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgSubTipo", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgSubTipo = :orgSubTipo"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgUbi", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgUbi = :orgUbi"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgPagWeb", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgPagWeb = :orgPagWeb"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgUsuIns", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgUsuIns = :orgUsuIns"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgFecIns", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgFecIns = :orgFecIns"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgUsuMod", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgUsuMod = :orgUsuMod"),
    @NamedQuery(name = "PgeOrganizaciones.findByOrgFecMod", query = "SELECT p FROM PgeOrganizaciones p WHERE p.orgFecMod = :orgFecMod")})
public class PgeOrganizaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "org_id", nullable = false)
    private Integer orgId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "org_desc", nullable = false, length = 60)
    private String orgDesc;
    @Size(max = 500)
    @Column(name = "org_dir", length = 500)
    private String orgDir;
    @Size(max = 30)
    @Column(name = "org_tel", length = 30)
    private String orgTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "org_tipo", nullable = false, length = 3)
    private String orgTipo;
    @Size(max = 3)
    @Column(name = "org_sub_tipo", length = 3)
    private String orgSubTipo;
    @Size(max = 500)
    @Column(name = "org_ubi", length = 500)
    private String orgUbi;
    @Lob
    @Column(name = "org_logo")
    private byte[] orgLogo;
    @Size(max = 255)
    @Column(name = "org_pag_web", length = 255)
    private String orgPagWeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "org_usu_ins", nullable = false, length = 10)
    private String orgUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "org_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orgFecIns;
    @Size(max = 10)
    @Column(name = "org_usu_mod", length = 10)
    private String orgUsuMod;
    @Column(name = "org_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orgFecMod;
    @JoinColumn(name = "ciu_id", referencedColumnName = "ciu_id", nullable = false)
    @ManyToOne(optional = false)
    private PgeCiudades ciuId;

    public PgeOrganizaciones() {
    }

    public PgeOrganizaciones(Integer orgId) {
        this.orgId = orgId;
    }

    public PgeOrganizaciones(Integer orgId, String orgDesc, String orgTipo, String orgUsuIns, Date orgFecIns) {
        this.orgId = orgId;
        this.orgDesc = orgDesc;
        this.orgTipo = orgTipo;
        this.orgUsuIns = orgUsuIns;
        this.orgFecIns = orgFecIns;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    public String getOrgDir() {
        return orgDir;
    }

    public void setOrgDir(String orgDir) {
        this.orgDir = orgDir;
    }

    public String getOrgTel() {
        return orgTel;
    }

    public void setOrgTel(String orgTel) {
        this.orgTel = orgTel;
    }

    public String getOrgTipo() {
        return orgTipo;
    }

    public void setOrgTipo(String orgTipo) {
        this.orgTipo = orgTipo;
    }

    public String getOrgSubTipo() {
        return orgSubTipo;
    }

    public void setOrgSubTipo(String orgSubTipo) {
        this.orgSubTipo = orgSubTipo;
    }

    public String getOrgUbi() {
        return orgUbi;
    }

    public void setOrgUbi(String orgUbi) {
        this.orgUbi = orgUbi;
    }

    public byte[] getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(byte[] orgLogo) {
        this.orgLogo = orgLogo;
    }

    public String getOrgPagWeb() {
        return orgPagWeb;
    }

    public void setOrgPagWeb(String orgPagWeb) {
        this.orgPagWeb = orgPagWeb;
    }

    public String getOrgUsuIns() {
        return orgUsuIns;
    }

    public void setOrgUsuIns(String orgUsuIns) {
        this.orgUsuIns = orgUsuIns;
    }

    public Date getOrgFecIns() {
        return orgFecIns;
    }

    public void setOrgFecIns(Date orgFecIns) {
        this.orgFecIns = orgFecIns;
    }

    public String getOrgUsuMod() {
        return orgUsuMod;
    }

    public void setOrgUsuMod(String orgUsuMod) {
        this.orgUsuMod = orgUsuMod;
    }

    public Date getOrgFecMod() {
        return orgFecMod;
    }

    public void setOrgFecMod(Date orgFecMod) {
        this.orgFecMod = orgFecMod;
    }

    public PgeCiudades getCiuId() {
        return ciuId;
    }

    public void setCiuId(PgeCiudades ciuId) {
        this.ciuId = ciuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgId != null ? orgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeOrganizaciones)) {
            return false;
        }
        PgeOrganizaciones other = (PgeOrganizaciones) object;
        if ((this.orgId == null && other.orgId != null) || (this.orgId != null && !this.orgId.equals(other.orgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeOrganizaciones[ orgId=" + orgId + " ]";
    }
    
}
