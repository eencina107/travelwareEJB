package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgePermisos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T17:02:39")
@StaticMetamodel(PgeMenus.class)
public class PgeMenus_ { 

    public static volatile ListAttribute<PgeMenus, PgePermisos> pgePermisosList;
    public static volatile SingularAttribute<PgeMenus, Integer> menSubId;
    public static volatile SingularAttribute<PgeMenus, Character> menTipo;
    public static volatile SingularAttribute<PgeMenus, String> menUsuMod;
    public static volatile SingularAttribute<PgeMenus, Date> menFecMod;
    public static volatile SingularAttribute<PgeMenus, String> menDescripcion;
    public static volatile SingularAttribute<PgeMenus, Integer> menId;
    public static volatile SingularAttribute<PgeMenus, String> menUbicacion;
    public static volatile SingularAttribute<PgeMenus, String> menUsuIns;
    public static volatile SingularAttribute<PgeMenus, Date> menFecIns;
    public static volatile SingularAttribute<PgeMenus, Integer> menCod;

}