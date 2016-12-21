package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComFacturas;
import com.fpuna.py.travelware.model.PgeOrganizaciones;
import com.fpuna.py.travelware.model.PgePersonas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T17:19:07")
@StaticMetamodel(ComProveedores.class)
public class ComProveedores_ { 

    public static volatile SingularAttribute<ComProveedores, PgeOrganizaciones> orgId;
    public static volatile SingularAttribute<ComProveedores, Integer> proId;
    public static volatile SingularAttribute<ComProveedores, Date> proFecMod;
    public static volatile SingularAttribute<ComProveedores, String> proNroTim;
    public static volatile SingularAttribute<ComProveedores, Character> proEst;
    public static volatile SingularAttribute<ComProveedores, String> proUsuMod;
    public static volatile SingularAttribute<ComProveedores, Date> proFecIns;
    public static volatile SingularAttribute<ComProveedores, PgePersonas> perId;
    public static volatile SingularAttribute<ComProveedores, String> proUsuIns;
    public static volatile SingularAttribute<ComProveedores, String> proDesc;
    public static volatile CollectionAttribute<ComProveedores, ComFacturas> comFacturasCollection;
    public static volatile SingularAttribute<ComProveedores, Date> proFecVen;

}