/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

/**
 *
 * @author eencina
 */
public interface SecuenciaDao {
    Integer getSec(String clave); //recupera la secuencia de acuerdo al nombre de tabla
    boolean actSec(String clave); //actualiza la secuencia
}
