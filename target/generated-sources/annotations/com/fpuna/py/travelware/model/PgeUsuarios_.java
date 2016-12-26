package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ConContactos;
import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.PgeUsuRoles;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T17:02:39")
@StaticMetamodel(PgeUsuarios.class)
public class PgeUsuarios_ { 

    public static volatile SingularAttribute<PgeUsuarios, String> usuUsuMod;
    public static volatile CollectionAttribute<PgeUsuarios, ConContactos> conContactosList;
    public static volatile ListAttribute<PgeUsuarios, PgeUsuRoles> pgeUsuRolesList;
    public static volatile SingularAttribute<PgeUsuarios, String> usuCargo;
    public static volatile SingularAttribute<PgeUsuarios, Character> usuEst;
    public static volatile SingularAttribute<PgeUsuarios, String> usuCod;
    public static volatile SingularAttribute<PgeUsuarios, PgePersonas> perId;
    public static volatile SingularAttribute<PgeUsuarios, Integer> usuId;
    public static volatile SingularAttribute<PgeUsuarios, String> usuPass;
    public static volatile SingularAttribute<PgeUsuarios, Date> usuFecMod;
    public static volatile SingularAttribute<PgeUsuarios, Date> usuFecIns;
    public static volatile SingularAttribute<PgeUsuarios, String> usuUsuIns;
    public static volatile SingularAttribute<PgeUsuarios, Date> usuFecIng;

}