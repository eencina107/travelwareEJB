package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeMonedas;
import com.fpuna.py.travelware.model.ViaViajes;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T17:02:39")
@StaticMetamodel(ViaPreViajes.class)
public class ViaPreViajes_ { 

    public static volatile SingularAttribute<ViaPreViajes, String> preDescripcion;
    public static volatile SingularAttribute<ViaPreViajes, ViaViajes> viaId;
    public static volatile SingularAttribute<ViaPreViajes, BigDecimal> prePrecio;
    public static volatile SingularAttribute<ViaPreViajes, String> preNombre;
    public static volatile SingularAttribute<ViaPreViajes, Integer> preId;
    public static volatile SingularAttribute<ViaPreViajes, PgeMonedas> monId;

}