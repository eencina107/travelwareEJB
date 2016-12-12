package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComFacturasDet;
import com.fpuna.py.travelware.model.PgeMonedas;
import com.fpuna.py.travelware.model.ViaConceptos;
import com.fpuna.py.travelware.model.ViaViajes;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:03:15")
@StaticMetamodel(ViaViajesDet.class)
public class ViaViajesDet_ { 

    public static volatile SingularAttribute<ViaViajesDet, Integer> vidCantVend;
    public static volatile SingularAttribute<ViaViajesDet, Date> vidFecIns;
    public static volatile SingularAttribute<ViaViajesDet, Date> vidFecMod;
    public static volatile SingularAttribute<ViaViajesDet, ViaConceptos> conId;
    public static volatile SingularAttribute<ViaViajesDet, String> vidDesc;
    public static volatile SingularAttribute<ViaViajesDet, Character> vidTip;
    public static volatile SingularAttribute<ViaViajesDet, ComFacturasDet> fadId;
    public static volatile ListAttribute<ViaViajesDet, ComFacturasDet> comFacturasDetList;
    public static volatile SingularAttribute<ViaViajesDet, String> vidImg;
    public static volatile SingularAttribute<ViaViajesDet, BigDecimal> vidMonto;
    public static volatile SingularAttribute<ViaViajesDet, Integer> vidId;
    public static volatile SingularAttribute<ViaViajesDet, String> vidUsuIns;
    public static volatile SingularAttribute<ViaViajesDet, Integer> vidCantTot;
    public static volatile SingularAttribute<ViaViajesDet, ViaViajes> viaId;
    public static volatile SingularAttribute<ViaViajesDet, String> vidUsuMod;
    public static volatile SingularAttribute<ViaViajesDet, PgeMonedas> monId;

}