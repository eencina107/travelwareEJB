package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeOrganizaciones;
import com.fpuna.py.travelware.model.PgePersonas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T17:19:07")
@StaticMetamodel(ViaFidelidades.class)
public class ViaFidelidades_ { 

    public static volatile SingularAttribute<ViaFidelidades, PgeOrganizaciones> orgId;
    public static volatile SingularAttribute<ViaFidelidades, Date> fidFecIns;
    public static volatile SingularAttribute<ViaFidelidades, Integer> fidId;
    public static volatile SingularAttribute<ViaFidelidades, Date> fidFecMod;
    public static volatile SingularAttribute<ViaFidelidades, PgePersonas> perId;
    public static volatile SingularAttribute<ViaFidelidades, String> fidUsuIns;
    public static volatile SingularAttribute<ViaFidelidades, String> fidUsuMod;

}