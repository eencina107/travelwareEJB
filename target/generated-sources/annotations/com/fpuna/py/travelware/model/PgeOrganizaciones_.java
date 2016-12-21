package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComProveedores;
import com.fpuna.py.travelware.model.PgeCiudades;
import com.fpuna.py.travelware.model.PgeTipoOrg;
import com.fpuna.py.travelware.model.ViaFidelidades;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T17:19:07")
@StaticMetamodel(PgeOrganizaciones.class)
public class PgeOrganizaciones_ { 

    public static volatile SingularAttribute<PgeOrganizaciones, String> orgDir;
    public static volatile SingularAttribute<PgeOrganizaciones, PgeTipoOrg> tipOrgId;
    public static volatile SingularAttribute<PgeOrganizaciones, String> orgSubTipo;
    public static volatile SingularAttribute<PgeOrganizaciones, String> orgPagWeb;
    public static volatile SingularAttribute<PgeOrganizaciones, String> orgUsuMod;
    public static volatile CollectionAttribute<PgeOrganizaciones, ComProveedores> comProveedoresCollection;
    public static volatile SingularAttribute<PgeOrganizaciones, Date> orgFecIns;
    public static volatile SingularAttribute<PgeOrganizaciones, PgeCiudades> ciuId;
    public static volatile SingularAttribute<PgeOrganizaciones, String> orgUsuIns;
    public static volatile SingularAttribute<PgeOrganizaciones, Integer> orgId;
    public static volatile SingularAttribute<PgeOrganizaciones, String> orgDesc;
    public static volatile SingularAttribute<PgeOrganizaciones, Date> orgFecMod;
    public static volatile SingularAttribute<PgeOrganizaciones, String> orgUbi;
    public static volatile SingularAttribute<PgeOrganizaciones, String> orgLogo;
    public static volatile SingularAttribute<PgeOrganizaciones, String> orgTel;
    public static volatile ListAttribute<PgeOrganizaciones, ViaFidelidades> viaFidelidadesList;

}