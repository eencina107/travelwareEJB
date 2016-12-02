/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author eencina
 */
@Entity
@Table(name = "pge_direcciones", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgeDirecciones.findAll", query = "SELECT p FROM PgeDirecciones p"),
    @NamedQuery(name = "PgeDirecciones.findByDirId", query = "SELECT p FROM PgeDirecciones p WHERE p.dirId = :dirId"),
    @NamedQuery(name = "PgeDirecciones.findByDirTipo", query = "SELECT p FROM PgeDirecciones p WHERE p.dirTipo = :dirTipo"),
    @NamedQuery(name = "PgeDirecciones.findByDirDesc", query = "SELECT p FROM PgeDirecciones p WHERE p.dirDesc = :dirDesc"),
    @NamedQuery(name = "PgeDirecciones.findByDirObs", query = "SELECT p FROM PgeDirecciones p WHERE p.dirObs = :dirObs"),
    @NamedQuery(name = "PgeDirecciones.findByDirNro", query = "SELECT p FROM PgeDirecciones p WHERE p.dirNro = :dirNro")})
public class PgeDirecciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dir_id", nullable = false)
    private Integer dirId;
    @Column(name = "dir_tipo")
    private Character dirTipo;
    @Size(max = 2147483647)
    @Column(name = "dir_desc", length = 2147483647)
    private String dirDesc;
    @Size(max = 2147483647)
    @Column(name = "dir_obs", length = 2147483647)
    private String dirObs;
    @Column(name = "dir_nro")
    private Integer dirNro;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne
    private PgePersonas perId;
    @JoinColumn(name = "pai_id", referencedColumnName = "pai_id")
    @ManyToOne
    private PgePaises paiId;
    @JoinColumn(name = "ciu_id", referencedColumnName = "ciu_id")
    @ManyToOne
    private PgeCiudades ciuId;

    public PgeDirecciones() {
    }

    public PgeDirecciones(Integer dirId) {
        this.dirId = dirId;
    }

    public Integer getDirId() {
        return dirId;
    }

    public void setDirId(Integer dirId) {
        this.dirId = dirId;
    }

    public Character getDirTipo() {
        return dirTipo;
    }

    public void setDirTipo(Character dirTipo) {
        this.dirTipo = dirTipo;
    }

    public String getDirDesc() {
        return dirDesc;
    }

    public void setDirDesc(String dirDesc) {
        this.dirDesc = dirDesc;
    }

    public String getDirObs() {
        return dirObs;
    }

    public void setDirObs(String dirObs) {
        this.dirObs = dirObs;
    }

    public Integer getDirNro() {
        return dirNro;
    }

    public void setDirNro(Integer dirNro) {
        this.dirNro = dirNro;
    }

    public PgePersonas getPerId() {
        return perId;
    }

    public void setPerId(PgePersonas perId) {
        this.perId = perId;
    }

    public PgePaises getPaiId() {
        return paiId;
    }

    public void setPaiId(PgePaises paiId) {
        this.paiId = paiId;
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
        hash += (dirId != null ? dirId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeDirecciones)) {
            return false;
        }
        PgeDirecciones other = (PgeDirecciones) object;
        if ((this.dirId == null && other.dirId != null) || (this.dirId != null && !this.dirId.equals(other.dirId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeDirecciones[ dirId=" + dirId + " ]";
    }
    
}
