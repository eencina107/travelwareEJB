package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeOrganizaciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T17:02:39")
@StaticMetamodel(PgeTipoOrg.class)
public class PgeTipoOrg_ { 

    public static volatile SingularAttribute<PgeTipoOrg, Integer> tipId;
    public static volatile SingularAttribute<PgeTipoOrg, String> tipCodigo;
    public static volatile SingularAttribute<PgeTipoOrg, String> tipDescripcion;
    public static volatile ListAttribute<PgeTipoOrg, PgeOrganizaciones> pgeOrganizacionesList;

}