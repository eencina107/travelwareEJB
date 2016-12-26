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
@Table(name = "com_proveedores", catalog = "travelware", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pro_ruc"})})
@NamedQueries({
    @NamedQuery(name = "ComProveedores.findAll", query = "SELECT c FROM ComProveedores c"),
    @NamedQuery(name = "ComProveedores.findByProId", query = "SELECT c FROM ComProveedores c WHERE c.proId = :proId"),
    @NamedQuery(name = "ComProveedores.findByProDesc", query = "SELECT c FROM ComProveedores c WHERE c.proDesc = :proDesc"),
    @NamedQuery(name = "ComProveedores.findByProEst", query = "SELECT c FROM ComProveedores c WHERE c.proEst = :proEst"),
    @NamedQuery(name = "ComProveedores.findByProNroTim", query = "SELECT c FROM ComProveedores c WHERE c.proNroTim = :proNroTim"),
    @NamedQuery(name = "ComProveedores.findByProFecVen", query = "SELECT c FROM ComProveedores c WHERE c.proFecVen = :proFecVen"),
    @NamedQuery(name = "ComProveedores.findByProUsuIns", query = "SELECT c FROM ComProveedores c WHERE c.proUsuIns = :proUsuIns"),
    @NamedQuery(name = "ComProveedores.findByProFecIns", query = "SELECT c FROM ComProveedores c WHERE c.proFecIns = :proFecIns"),
    @NamedQuery(name = "ComProveedores.findByProUsuMod", query = "SELECT c FROM ComProveedores c WHERE c.proUsuMod = :proUsuMod"),
    @NamedQuery(name = "ComProveedores.findByProFecMod", query = "SELECT c FROM ComProveedores c WHERE c.proFecMod = :proFecMod"),
    @NamedQuery(name = "ComProveedores.findByProRuc", query = "SELECT c FROM ComProveedores c WHERE c.proRuc = :proRuc")})
public class ComProveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id", nullable = false)
    private Integer proId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "pro_desc", nullable = false, length = 60)
    private String proDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_est", nullable = false)
    private Character proEst;
    @Size(max = 15)
    @Column(name = "pro_nro_tim", length = 15)
    private String proNroTim;
    @Column(name = "pro_fec_ven")
    @Temporal(TemporalType.DATE)
    private Date proFecVen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pro_usu_ins", nullable = false, length = 10)
    private String proUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date proFecIns;
    @Size(max = 10)
    @Column(name = "pro_usu_mod", length = 10)
    private String proUsuMod;
    @Column(name = "pro_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proFecMod;
    @Size(max = 20)
    @Column(name = "pro_ruc", length = 20)
    private String proRuc;
    @JoinColumn(name = "org_id", referencedColumnName = "org_id")
    @ManyToOne
    private PgeOrganizaciones orgId;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne
    private PgePersonas perId;

    public ComProveedores() {
    }

    public ComProveedores(Integer proId) {
        this.proId = proId;
    }

    public ComProveedores(Integer proId, String proDesc, Character proEst, String proUsuIns, Date proFecIns) {
        this.proId = proId;
        this.proDesc = proDesc;
        this.proEst = proEst;
        this.proUsuIns = proUsuIns;
        this.proFecIns = proFecIns;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public Character getProEst() {
        return proEst;
    }

    public void setProEst(Character proEst) {
        this.proEst = proEst;
    }

    public String getProNroTim() {
        return proNroTim;
    }

    public void setProNroTim(String proNroTim) {
        this.proNroTim = proNroTim;
    }

    public Date getProFecVen() {
        return proFecVen;
    }

    public void setProFecVen(Date proFecVen) {
        this.proFecVen = proFecVen;
    }

    public String getProUsuIns() {
        return proUsuIns;
    }

    public void setProUsuIns(String proUsuIns) {
        this.proUsuIns = proUsuIns;
    }

    public Date getProFecIns() {
        return proFecIns;
    }

    public void setProFecIns(Date proFecIns) {
        this.proFecIns = proFecIns;
    }

    public String getProUsuMod() {
        return proUsuMod;
    }

    public void setProUsuMod(String proUsuMod) {
        this.proUsuMod = proUsuMod;
    }

    public Date getProFecMod() {
        return proFecMod;
    }

    public void setProFecMod(Date proFecMod) {
        this.proFecMod = proFecMod;
    }

    public String getProRuc() {
        return proRuc;
    }

    public void setProRuc(String proRuc) {
        this.proRuc = proRuc;
    }

    public PgeOrganizaciones getOrgId() {
        return orgId;
    }

    public void setOrgId(PgeOrganizaciones orgId) {
        this.orgId = orgId;
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
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComProveedores)) {
            return false;
        }
        ComProveedores other = (ComProveedores) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ComProveedores[ proId=" + proId + " ]";
    }
    
}
