package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeRoles;
import com.fpuna.py.travelware.model.PgeUsuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:03:15")
@StaticMetamodel(PgeUsuRoles.class)
public class PgeUsuRoles_ { 

    public static volatile SingularAttribute<PgeUsuRoles, Integer> usuRolId;
    public static volatile SingularAttribute<PgeUsuRoles, Date> uroFecIns;
    public static volatile SingularAttribute<PgeUsuRoles, PgeRoles> rolId;
    public static volatile SingularAttribute<PgeUsuRoles, Date> uroFecMod;
    public static volatile SingularAttribute<PgeUsuRoles, String> uroUsuIns;
    public static volatile SingularAttribute<PgeUsuRoles, PgeUsuarios> usuId;
    public static volatile SingularAttribute<PgeUsuRoles, String> uroUsuMod;

}