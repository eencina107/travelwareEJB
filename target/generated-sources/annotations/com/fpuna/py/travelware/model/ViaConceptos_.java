package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComFacturasDet;
import com.fpuna.py.travelware.model.ViaGastos;
import com.fpuna.py.travelware.model.ViaViajesDet;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:03:15")
@StaticMetamodel(ViaConceptos.class)
public class ViaConceptos_ { 

    public static volatile SingularAttribute<ViaConceptos, String> conDesc;
    public static volatile SingularAttribute<ViaConceptos, String> conUsuMod;
    public static volatile SingularAttribute<ViaConceptos, Date> conFecMod;
    public static volatile SingularAttribute<ViaConceptos, Integer> conId;
    public static volatile CollectionAttribute<ViaConceptos, ViaViajesDet> viaViajesDetCollection;
    public static volatile SingularAttribute<ViaConceptos, Character> conReq;
    public static volatile SingularAttribute<ViaConceptos, String> conUsuIns;
    public static volatile CollectionAttribute<ViaConceptos, ComFacturasDet> comFacturasDetCollection;
    public static volatile CollectionAttribute<ViaConceptos, ViaGastos> viaGastosCollection;
    public static volatile SingularAttribute<ViaConceptos, Character> conEst;
    public static volatile SingularAttribute<ViaConceptos, Date> conFecIns;

}