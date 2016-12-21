package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeAtractivos;
import com.fpuna.py.travelware.model.PgeDirecciones;
import com.fpuna.py.travelware.model.PgeOrganizaciones;
import com.fpuna.py.travelware.model.PgePaises;
import com.fpuna.py.travelware.model.ViaActividades;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T17:19:07")
@StaticMetamodel(PgeCiudades.class)
public class PgeCiudades_ { 

    public static volatile ListAttribute<PgeCiudades, PgeDirecciones> pgeDireccionesList;
    public static volatile ListAttribute<PgeCiudades, PgeAtractivos> pgeAtractivosList;
    public static volatile ListAttribute<PgeCiudades, ViaActividades> viaActividadesList;
    public static volatile SingularAttribute<PgeCiudades, Date> ciuFecMod;
    public static volatile SingularAttribute<PgeCiudades, String> ciuUsuIns;
    public static volatile SingularAttribute<PgeCiudades, PgePaises> paiId;
    public static volatile ListAttribute<PgeCiudades, PgeOrganizaciones> pgeOrganizacionesList;
    public static volatile SingularAttribute<PgeCiudades, String> ciuUsuMod;
    public static volatile SingularAttribute<PgeCiudades, String> ciuUbi;
    public static volatile SingularAttribute<PgeCiudades, Integer> ciuId;
    public static volatile SingularAttribute<PgeCiudades, String> ciuDesc;
    public static volatile SingularAttribute<PgeCiudades, Date> ciuFecIns;

}