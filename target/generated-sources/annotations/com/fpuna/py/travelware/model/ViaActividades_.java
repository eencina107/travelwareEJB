package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeCiudades;
import com.fpuna.py.travelware.model.ViaViajes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T17:19:07")
@StaticMetamodel(ViaActividades.class)
public class ViaActividades_ { 

    public static volatile SingularAttribute<ViaActividades, Date> actFecha;
    public static volatile SingularAttribute<ViaActividades, Integer> actId;
    public static volatile SingularAttribute<ViaActividades, ViaViajes> viaId;
    public static volatile SingularAttribute<ViaActividades, String> actUsuMod;
    public static volatile SingularAttribute<ViaActividades, PgeCiudades> ciuId;
    public static volatile SingularAttribute<ViaActividades, Date> actFecMod;
    public static volatile SingularAttribute<ViaActividades, String> actUsuIns;
    public static volatile SingularAttribute<ViaActividades, Integer> actOrd;
    public static volatile SingularAttribute<ViaActividades, String> actDet;
    public static volatile SingularAttribute<ViaActividades, Date> actFecIns;

}