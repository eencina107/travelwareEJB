/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PgePermisos;
import com.fpuna.py.travelware.model.PgeRoles;
import com.fpuna.py.travelware.model.PgeUsuarios;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author eencina
 */
public interface RolDao extends GenericDao<PgeRoles, Integer>{
    List<PgeRoles> getRolesByUsuario(PgeUsuarios usuario);
    List<PgePermisos> getPermisos(PgeRoles object);
    PgeRoles getByName(String name);
}
