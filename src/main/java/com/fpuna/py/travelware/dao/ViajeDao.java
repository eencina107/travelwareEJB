<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaViajes;
import java.util.List;

/**
 *
 * @author eencina
 */
public interface ViajeDao extends GenericDao<ViaViajes, Integer>{
    ViaViajes getByName(String value);
    List<ViaViajes> getAllDisp();
    List<ViaViajes> getAllFuturos();
    boolean isDisponible(ViaViajes viaje);
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaViajes;
import com.fpuna.py.travelware.model.ViaViajesDet;
import java.util.List;

/**
 *
 * @author eencina
 */
public interface ViajeDao extends GenericDao<ViaViajes, Integer>{
    ViaViajes getByName(String value);
    List<ViaViajes> getAllDisp();
    List<ViaViajes> getAllFuturos();
    ViaViajesDet getByViaDetId(int id);
}
>>>>>>> dc4843a1eb4a63254e61a25b22647dad53c7cde7
