/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.ConContactos;
import com.fpuna.py.travelware.model.PgeUsuarios;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author olimp
 */
public interface ContactoDao extends GenericDao<ConContactos, Integer>{
    public List<ConContactos> getPendientesByUsuario(PgeUsuarios usuario);
    public List<ConContactos> getPendientesDia(PgeUsuarios usuario, Date fecha);
}
