/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PgePaises;
import java.io.Serializable;

/**
 *
 * @author eencina
 */
public interface PaisDao extends GenericDao<PgePaises, Integer>{
    PgePaises getByName(String name);
}
