/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PgeMenus;

/**
 *
 * @author eencina
 */
public interface MenuDao extends GenericDao<PgeMenus, Integer>{
    PgeMenus getByName(String name);
}
