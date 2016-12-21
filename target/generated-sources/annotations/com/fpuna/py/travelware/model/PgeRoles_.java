package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgePermisos;
import com.fpuna.py.travelware.model.PgeUsuRoles;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T17:19:07")
@StaticMetamodel(PgeRoles.class)
public class PgeRoles_ { 

    public static volatile ListAttribute<PgeRoles, PgePermisos> pgePermisosList;
    public static volatile SingularAttribute<PgeRoles, String> rolUsuMod;
    public static volatile SingularAttribute<PgeRoles, Integer> rolId;
    public static volatile ListAttribute<PgeRoles, PgeUsuRoles> pgeUsuRolesList;
    public static volatile SingularAttribute<PgeRoles, Date> rolFecMod;
    public static volatile SingularAttribute<PgeRoles, String> rolDesc;
    public static volatile SingularAttribute<PgeRoles, Date> rolFecIns;
    public static volatile SingularAttribute<PgeRoles, String> rolUsuIns;

}