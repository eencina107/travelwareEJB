package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeMonedas;
import com.fpuna.py.travelware.model.ViaConceptos;
import com.fpuna.py.travelware.model.ViaPasajeros;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:03:15")
@StaticMetamodel(ViaGastos.class)
public class ViaGastos_ { 

    public static volatile SingularAttribute<ViaGastos, Integer> gasNro;
    public static volatile SingularAttribute<ViaGastos, ViaPasajeros> pviId;
    public static volatile SingularAttribute<ViaGastos, String> gasTip;
    public static volatile SingularAttribute<ViaGastos, ViaConceptos> conId;
    public static volatile SingularAttribute<ViaGastos, BigDecimal> gasMonto;
    public static volatile SingularAttribute<ViaGastos, Integer> gasId;
    public static volatile SingularAttribute<ViaGastos, PgeMonedas> monId;

}