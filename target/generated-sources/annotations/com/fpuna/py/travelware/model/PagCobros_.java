package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeMonedas;
import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaViajes;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T17:02:39")
@StaticMetamodel(PagCobros.class)
public class PagCobros_ { 

    public static volatile SingularAttribute<PagCobros, String> cobFacNro;
    public static volatile SingularAttribute<PagCobros, String> cobForPago;
    public static volatile SingularAttribute<PagCobros, PgePersonas> perId;
    public static volatile SingularAttribute<PagCobros, String> cobMontoLetras;
    public static volatile SingularAttribute<PagCobros, Date> cobFecAnu;
    public static volatile SingularAttribute<PagCobros, BigDecimal> cobMonto;
    public static volatile SingularAttribute<PagCobros, String> cobNro;
    public static volatile SingularAttribute<PagCobros, BigDecimal> cobCambio;
    public static volatile SingularAttribute<PagCobros, String> cobUsuMod;
    public static volatile SingularAttribute<PagCobros, String> cobUsuIns;
    public static volatile SingularAttribute<PagCobros, Integer> cobId;
    public static volatile SingularAttribute<PagCobros, String> cobObservacion;
    public static volatile SingularAttribute<PagCobros, ViaViajes> viaId;
    public static volatile SingularAttribute<PagCobros, String> cobNcrNro;
    public static volatile SingularAttribute<PagCobros, Character> cobEstado;
    public static volatile SingularAttribute<PagCobros, Date> cobFecPago;
    public static volatile SingularAttribute<PagCobros, Character> cobAnulado;
    public static volatile SingularAttribute<PagCobros, String> cobTipo;
    public static volatile SingularAttribute<PagCobros, Date> cobFecIns;
    public static volatile SingularAttribute<PagCobros, Date> cobFecMod;
    public static volatile SingularAttribute<PagCobros, PgeMonedas> monId;

}