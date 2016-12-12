package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PagCobros;
import com.fpuna.py.travelware.model.PagComprobantesDet;
import com.fpuna.py.travelware.model.PgeMonedas;
import com.fpuna.py.travelware.model.ViaPasajeros;
import com.fpuna.py.travelware.model.ViaViajesDet;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:03:15")
@StaticMetamodel(ViaViajes.class)
public class ViaViajes_ { 

    public static volatile SingularAttribute<ViaViajes, BigDecimal> viaCost;
    public static volatile SingularAttribute<ViaViajes, Date> viaFecIns;
    public static volatile SingularAttribute<ViaViajes, String> viaUsuIns;
    public static volatile SingularAttribute<ViaViajes, String> viaResumen;
    public static volatile SingularAttribute<ViaViajes, String> viaImg;
    public static volatile ListAttribute<ViaViajes, PagComprobantesDet> pagComprobantesDetList;
    public static volatile SingularAttribute<ViaViajes, Integer> viaCantVend;
    public static volatile CollectionAttribute<ViaViajes, ViaViajesDet> viaViajesDetCollection;
    public static volatile SingularAttribute<ViaViajes, Date> viaFecMod;
    public static volatile SingularAttribute<ViaViajes, Date> viaFecReg;
    public static volatile ListAttribute<ViaViajes, ViaPasajeros> viaPasajerosList;
    public static volatile SingularAttribute<ViaViajes, String> viaUsuMod;
    public static volatile SingularAttribute<ViaViajes, Integer> viaCantTot;
    public static volatile SingularAttribute<ViaViajes, String> viaDesc;
    public static volatile SingularAttribute<ViaViajes, Integer> viaId;
    public static volatile ListAttribute<ViaViajes, PagCobros> pagCobrosList;
    public static volatile SingularAttribute<ViaViajes, Date> viaFecSali;
    public static volatile SingularAttribute<ViaViajes, PgeMonedas> monId;

}