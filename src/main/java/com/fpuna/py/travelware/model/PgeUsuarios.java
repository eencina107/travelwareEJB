/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
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
@Table(name = "pge_usuarios", catalog = "travelware", schema = "public")
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
    @NamedQuery(name = "PgeUsuarios.findByUsuFecMod", query = "SELECT p FROM PgeUsuarios p WHERE p.usuFecMod = :usuFecMod"),
    @NamedQuery(name = "PgeUsuarios.findByUsuPass", query = "SELECT p FROM PgeUsuarios p WHERE p.usuPass = :usuPass")})
public class PgeUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_id", nullable = false)
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usu_nom_ape", nullable = false, length = 100)
    private String usuNomApe;
    @Size(max = 2)
    @Column(name = "usu_cat", length = 2)
    private String usuCat;
    @Column(name = "usu_est")
    private Character usuEst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_fec_ing", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date usuFecIng;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usu_cod", nullable = false, length = 10)
    private String usuCod;
    @Size(max = 60)
    @Column(name = "usu_cargo", length = 60)
    private String usuCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usu_usu_ins", nullable = false, length = 10)
    private String usuUsuIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_fec_ins", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFecIns;
    @Size(max = 10)
    @Column(name = "usu_usu_mod", length = 10)
    private String usuUsuMod;
    @Column(name = "usu_fec_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFecMod;
    @Size(max = 2147483647)
    @Column(name = "usu_pass", length = 2147483647)
    private String usuPass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgeUsuarios")
    private List<PgeUsuRoles> pgeUsuRolesList;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id", nullable = false)
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

    public String getUsuPass() {
        return usuPass;
    }

    public void setUsuPass(String usuPass) {
        this.usuPass = usuPass;
    }

    public List<PgeUsuRoles> getPgeUsuRolesList() {
        return pgeUsuRolesList;
    }
  
    public List<PgeRoles> getPgeRoles() {
        List<PgeUsuRoles> usuRoles = this.getPgeUsuRolesList();
        List<PgeRoles> roles = null;
        Iterator i= usuRoles.iterator();
        PgeUsuRoles usuRol;
        PgeRoles rol;
        while (i.hasNext()){
            usuRol = (PgeUsuRoles) i.next();
            rol = usuRol.getPgeRoles();
            roles.add(rol);
        }
        return roles;
    }
    
    public List<PgeMenus> getPgeMenus(){
        List<PgeRoles> roles = this.getPgeRoles();
        List<PgeMenus> menusRol; //permisos recuperados con cada rol
        List<PgeMenus> menus = null; //permisos que seran retornados (suma de todos los permisosRol)
        PgeRoles rol;
        Iterator i= roles.iterator(); //iterador roles
        Iterator i2; //iterador permisosRol
        PgeMenus menu;
        
        while(i.hasNext()){
            rol= (PgeRoles) i.next();
            menusRol = rol.getPgeMenusList();
            i2=menusRol.iterator();
            while(i2.hasNext()){
                menu=(PgeMenus) i2.next();
                menus.add(menu);
            }
        }
        
        return menus;
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
        return "com.fpuna.py.travelware.model.PgeUsuarios[ usuId=" + usuId + " ]";
    }
    
}
