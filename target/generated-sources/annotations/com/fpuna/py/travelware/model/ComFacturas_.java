package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComFacturasDet;
import com.fpuna.py.travelware.model.ComProveedores;
import com.fpuna.py.travelware.model.PgeMonedas;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T09:07:22")
@StaticMetamodel(ComFacturas.class)
public class ComFacturas_ { 

    public static volatile SingularAttribute<ComFacturas, ComProveedores> proId;
    public static volatile SingularAttribute<ComFacturas, String> facUsuMod;
    public static volatile SingularAttribute<ComFacturas, String> facUsuIns;
    public static volatile SingularAttribute<ComFacturas, String> facRuc;
    public static volatile SingularAttribute<ComFacturas, String> facImg;
    public static volatile SingularAttribute<ComFacturas, Integer> facId;
    public static volatile SingularAttribute<ComFacturas, String> facDesc;
    public static volatile SingularAttribute<ComFacturas, Date> facFecIns;
    public static volatile SingularAttribute<ComFacturas, Date> facFecha;
    public static volatile SingularAttribute<ComFacturas, Integer> facCanCuo;
    public static volatile SingularAttribute<ComFacturas, String> facNro;
    public static volatile SingularAttribute<ComFacturas, BigDecimal> facCambio;
    public static volatile SingularAttribute<ComFacturas, Character> facEst;
    public static volatile SingularAttribute<ComFacturas, Date> facFecMod;
    public static volatile SingularAttribute<ComFacturas, Character> facTip;
    public static volatile ListAttribute<ComFacturas, ComFacturasDet> comFacturasDetList;
    public static volatile SingularAttribute<ComFacturas, String> facNroTim;
    public static volatile SingularAttribute<ComFacturas, Character> facIvaInc;
    public static volatile SingularAttribute<ComFacturas, String> facFormaPago;
    public static volatile SingularAttribute<ComFacturas, Date> facFecVen;
    public static volatile SingularAttribute<ComFacturas, BigDecimal> facTotal;
    public static volatile SingularAttribute<ComFacturas, BigDecimal> facSaldo;
    public static volatile SingularAttribute<ComFacturas, Character> facCond;
    public static volatile SingularAttribute<ComFacturas, PgeMonedas> monId;

}