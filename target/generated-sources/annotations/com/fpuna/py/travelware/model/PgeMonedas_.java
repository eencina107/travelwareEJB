package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComCajas;
import com.fpuna.py.travelware.model.ComFacturas;
import com.fpuna.py.travelware.model.ComMovCajas;
import com.fpuna.py.travelware.model.ComPagos;
import com.fpuna.py.travelware.model.PagCobros;
import com.fpuna.py.travelware.model.PgePaises;
import com.fpuna.py.travelware.model.ViaGastos;
import com.fpuna.py.travelware.model.ViaViajes;
import com.fpuna.py.travelware.model.ViaViajesDet;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:03:15")
@StaticMetamodel(PgeMonedas.class)
public class PgeMonedas_ { 

    public static volatile SingularAttribute<PgeMonedas, Date> monFecIns;
    public static volatile SingularAttribute<PgeMonedas, PgePaises> paiId;
    public static volatile CollectionAttribute<PgeMonedas, ViaViajesDet> viaViajesDetCollection;
    public static volatile SingularAttribute<PgeMonedas, String> monUsuIns;
    public static volatile CollectionAttribute<PgeMonedas, ViaGastos> viaGastosCollection;
    public static volatile CollectionAttribute<PgeMonedas, ViaViajes> viaViajesCollection;
    public static volatile SingularAttribute<PgeMonedas, String> monDesc;
    public static volatile SingularAttribute<PgeMonedas, String> monUsuMod;
    public static volatile CollectionAttribute<PgeMonedas, PagCobros> pagCobrosCollection;
    public static volatile SingularAttribute<PgeMonedas, String> monAbreviatura;
    public static volatile SingularAttribute<PgeMonedas, Date> monFecMod;
    public static volatile CollectionAttribute<PgeMonedas, ComFacturas> comFacturasCollection;
    public static volatile CollectionAttribute<PgeMonedas, ComPagos> comPagosCollection;
    public static volatile CollectionAttribute<PgeMonedas, ComMovCajas> comMovCajasCollection;
    public static volatile SingularAttribute<PgeMonedas, Integer> monId;
    public static volatile CollectionAttribute<PgeMonedas, ComCajas> comCajasCollection;

}