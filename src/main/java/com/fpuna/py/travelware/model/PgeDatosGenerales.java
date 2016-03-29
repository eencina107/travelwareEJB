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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "pge_datos_generales", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PgeDatosGenerales.findAll", query = "SELECT p FROM PgeDatosGenerales p"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralNombExt", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralNombExt = :gralNombExt"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralNombAbrev", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralNombAbrev = :gralNombAbrev"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralTel1", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralTel1 = :gralTel1"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralTel2", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralTel2 = :gralTel2"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralEmail1", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralEmail1 = :gralEmail1"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralEmail2", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralEmail2 = :gralEmail2"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralDireccion", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralDireccion = :gralDireccion"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralRuc", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralRuc = :gralRuc"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralId", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralId = :gralId"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralUsuIns", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralUsuIns = :gralUsuIns"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralFecIns", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralFecIns = :gralFecIns"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralUsuMod", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralUsuMod = :gralUsuMod"),
    @NamedQuery(name = "PgeDatosGenerales.findByGralFecMod", query = "SELECT p FROM PgeDatosGenerales p WHERE p.gralFecMod = :gralFecMod")})
public class PgeDatosGenerales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "gral_nomb_ext", length = 2147483647)
    private String gralNombExt;
    @Size(max = 30)
    @Column(name = "gral_nomb_abrev", length = 30)
    private String gralNombAbrev;
    @Size(max = 20)
    @Column(name = "gral_tel1", length = 20)
    private String gralTel1;
    @Size(max = 20)
    @Column(name = "gral_tel2", length = 20)
    private String gralTel2;
    @Size(max = 2147483647)
    @Column(name = "gral_email1", length = 2147483647)
    private String gralEmail1;
    @Size(max = 2147483647)
    @Column(name = "gral_email2", length = 2147483647)
    private String gralEmail2;
    @Size(max = 2147483647)
    @Column(name = "gral_direccion", length = 2147483647)
    private String gralDireccion;
    @Size(max = 10)
    @Column(name = "gral_ruc", length = 10)
    private String gralRuc;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gral_id", nullable = false)
    private Integer gralId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gral_usu_ins", nullable = false, length = 10)
    private String gralUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gral_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date gralFecIns;
    @Size(max = 10)
    @Column(name = "gral_usu_mod", length = 10)
    private String gralUsuMod;
    @Column(name = "gral_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gralFecMod;

    public PgeDatosGenerales() {
    }

    public PgeDatosGenerales(Integer gralId) {
        this.gralId = gralId;
    }

    public PgeDatosGenerales(Integer gralId, String gralUsuIns, Date gralFecIns) {
        this.gralId = gralId;
        this.gralUsuIns = gralUsuIns;
        this.gralFecIns = gralFecIns;
    }

    public String getGralNombExt() {
        return gralNombExt;
    }

    public void setGralNombExt(String gralNombExt) {
        this.gralNombExt = gralNombExt;
    }

    public String getGralNombAbrev() {
        return gralNombAbrev;
    }

    public void setGralNombAbrev(String gralNombAbrev) {
        this.gralNombAbrev = gralNombAbrev;
    }

    public String getGralTel1() {
        return gralTel1;
    }

    public void setGralTel1(String gralTel1) {
        this.gralTel1 = gralTel1;
    }

    public String getGralTel2() {
        return gralTel2;
    }

    public void setGralTel2(String gralTel2) {
        this.gralTel2 = gralTel2;
    }

    public String getGralEmail1() {
        return gralEmail1;
    }

    public void setGralEmail1(String gralEmail1) {
        this.gralEmail1 = gralEmail1;
    }

    public String getGralEmail2() {
        return gralEmail2;
    }

    public void setGralEmail2(String gralEmail2) {
        this.gralEmail2 = gralEmail2;
    }

    public String getGralDireccion() {
        return gralDireccion;
    }

    public void setGralDireccion(String gralDireccion) {
        this.gralDireccion = gralDireccion;
    }

    public String getGralRuc() {
        return gralRuc;
    }

    public void setGralRuc(String gralRuc) {
        this.gralRuc = gralRuc;
    }

    public Integer getGralId() {
        return gralId;
    }

    public void setGralId(Integer gralId) {
        this.gralId = gralId;
    }

    public String getGralUsuIns() {
        return gralUsuIns;
    }

    public void setGralUsuIns(String gralUsuIns) {
        this.gralUsuIns = gralUsuIns;
    }

    public Date getGralFecIns() {
        return gralFecIns;
    }

    public void setGralFecIns(Date gralFecIns) {
        this.gralFecIns = gralFecIns;
    }

    public String getGralUsuMod() {
        return gralUsuMod;
    }

    public void setGralUsuMod(String gralUsuMod) {
        this.gralUsuMod = gralUsuMod;
    }

    public Date getGralFecMod() {
        return gralFecMod;
    }

    public void setGralFecMod(Date gralFecMod) {
        this.gralFecMod = gralFecMod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gralId != null ? gralId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgeDatosGenerales)) {
            return false;
        }
        PgeDatosGenerales other = (PgeDatosGenerales) object;
        if ((this.gralId == null && other.gralId != null) || (this.gralId != null && !this.gralId.equals(other.gralId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.PgeDatosGenerales[ gralId=" + gralId + " ]";
    }
    
}
