package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComCajas;
import com.fpuna.py.travelware.model.PgeMonedas;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T17:02:39")
@StaticMetamodel(ComMovCajas.class)
public class ComMovCajas_ { 

    public static volatile SingularAttribute<ComMovCajas, String> movObservacion;
    public static volatile SingularAttribute<ComMovCajas, String> movUsuIns;
    public static volatile SingularAttribute<ComMovCajas, BigDecimal> movMonto;
    public static volatile SingularAttribute<ComMovCajas, BigDecimal> movCambio;
    public static volatile SingularAttribute<ComMovCajas, Date> movFecIns;
    public static volatile SingularAttribute<ComMovCajas, String> movForPago;
    public static volatile SingularAttribute<ComMovCajas, String> movUsuMod;
    public static volatile SingularAttribute<ComMovCajas, Date> movFecMod;
    public static volatile SingularAttribute<ComMovCajas, Character> movAnulado;
    public static volatile SingularAttribute<ComMovCajas, Integer> movId;
    public static volatile SingularAttribute<ComMovCajas, Character> movTip;
    public static volatile SingularAttribute<ComMovCajas, ComCajas> cajId;
    public static volatile SingularAttribute<ComMovCajas, String> movMontoLetras;
    public static volatile SingularAttribute<ComMovCajas, PgeMonedas> monId;

}