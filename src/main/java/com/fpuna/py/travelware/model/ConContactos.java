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
import javax.validation.constraints.Size;

/**
 *
 * @author olimp
 */
@Entity
@Table(name = "con_contactos", catalog = "travelware", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ConContactos.findAll", query = "SELECT c FROM ConContactos c"),
    @NamedQuery(name = "ConContactos.findByConId", query = "SELECT c FROM ConContactos c WHERE c.conId = :conId"),
    @NamedQuery(name = "ConContactos.findByConFechaContacto", query = "SELECT c FROM ConContactos c WHERE c.conFechaContacto = :conFechaContacto"),
    @NamedQuery(name = "ConContactos.findByConExito", query = "SELECT c FROM ConContactos c WHERE c.conExito = :conExito"),
    @NamedQuery(name = "ConContactos.findByConObservacion", query = "SELECT c FROM ConContactos c WHERE c.conObservacion = :conObservacion")})
public class ConContactos implements Serializable {
    @Column(name = "con_estado")
    private Character conEstado;
    @JoinColumn(name = "con_id_usuario_cont", referencedColumnName = "usu_id")
    @ManyToOne
    private PgeUsuarios conIdUsuarioCont;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_id", nullable = false)
    private Integer conId;
    @Column(name = "con_fecha_contacto")
    @Temporal(TemporalType.DATE)
    private Date conFechaContacto;
    @Column(name = "con_exito")
    private Boolean conExito;
    @Size(max = 2147483647)
    @Column(name = "con_observacion", length = 2147483647)
    private String conObservacion;
    @JoinColumn(name = "con_id_persona_cont", referencedColumnName = "per_id")
    @ManyToOne
    private PgePersonas conIdPersonaCont;

    public ConContactos() {
    }

    public ConContactos(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Date getConFechaContacto() {
        return conFechaContacto;
    }

    public void setConFechaContacto(Date conFechaContacto) {
        this.conFechaContacto = conFechaContacto;
    }

    public Boolean getConExito() {
        return conExito;
    }

    public void setConExito(Boolean conExito) {
        this.conExito = conExito;
    }

    public String getConObservacion() {
        return conObservacion;
    }

    public void setConObservacion(String conObservacion) {
        this.conObservacion = conObservacion;
    }

    public PgePersonas getConIdPersonaCont() {
        return conIdPersonaCont;
    }

    public void setConIdPersonaCont(PgePersonas conIdPersonaCont) {
        this.conIdPersonaCont = conIdPersonaCont;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConContactos)) {
            return false;
        }
        ConContactos other = (ConContactos) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.py.travelware.model.ConContactos[ conId=" + conId + " ]";
    }

    public Character getConEstado() {
        return conEstado;
    }

    public void setConEstado(Character conEstado) {
        this.conEstado = conEstado;
    }

    public PgeUsuarios getConIdUsuarioCont() {
        return conIdUsuarioCont;
    }

    public void setConIdUsuarioCont(PgeUsuarios conIdUsuarioCont) {
        this.conIdUsuarioCont = conIdUsuarioCont;
    }
    
}
