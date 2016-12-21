package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeCiudades;
import com.fpuna.py.travelware.model.PgeDirecciones;
import com.fpuna.py.travelware.model.PgeMonedas;
import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaVisas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T17:19:07")
@StaticMetamodel(PgePaises.class)
public class PgePaises_ { 

    public static volatile SingularAttribute<PgePaises, String> paiUsuIns;
    public static volatile ListAttribute<PgePaises, PgeDirecciones> pgeDireccionesList;
    public static volatile ListAttribute<PgePaises, PgeMonedas> pgeMonedasList;
    public static volatile ListAttribute<PgePaises, PgeCiudades> pgeCiudadesList;
    public static volatile SingularAttribute<PgePaises, Integer> paiId;
    public static volatile ListAttribute<PgePaises, ViaVisas> viaVisasList;
    public static volatile SingularAttribute<PgePaises, Date> paiFecMod;
    public static volatile SingularAttribute<PgePaises, String> paiUbi;
    public static volatile SingularAttribute<PgePaises, String> paiNac;
    public static volatile SingularAttribute<PgePaises, Date> paiFecIns;
    public static volatile SingularAttribute<PgePaises, String> paiDesc;
    public static volatile SingularAttribute<PgePaises, String> paiUsuMod;
    public static volatile ListAttribute<PgePaises, PgePersonas> pgePersonasList;

}