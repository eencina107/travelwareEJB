package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeCiudades;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T17:19:07")
@StaticMetamodel(PgeAtractivos.class)
public class PgeAtractivos_ { 

    public static volatile SingularAttribute<PgeAtractivos, String> atrUbi;
    public static volatile SingularAttribute<PgeAtractivos, String> atrUsuIns;
    public static volatile SingularAttribute<PgeAtractivos, Date> atrFecIns;
    public static volatile SingularAttribute<PgeAtractivos, byte[]> atrImg;
    public static volatile SingularAttribute<PgeAtractivos, PgeCiudades> ciuId;
    public static volatile SingularAttribute<PgeAtractivos, String> atrDesc;
    public static volatile SingularAttribute<PgeAtractivos, String> atrUsuMod;
    public static volatile SingularAttribute<PgeAtractivos, Integer> atrId;
    public static volatile SingularAttribute<PgeAtractivos, Date> atrFecMod;

}