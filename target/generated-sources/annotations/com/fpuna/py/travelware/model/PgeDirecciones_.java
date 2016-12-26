package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgeCiudades;
import com.fpuna.py.travelware.model.PgePaises;
import com.fpuna.py.travelware.model.PgePersonas;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T17:02:39")
@StaticMetamodel(PgeDirecciones.class)
public class PgeDirecciones_ { 

    public static volatile SingularAttribute<PgeDirecciones, Character> dirTipo;
    public static volatile SingularAttribute<PgeDirecciones, Integer> dirNro;
    public static volatile SingularAttribute<PgeDirecciones, PgePersonas> perId;
    public static volatile SingularAttribute<PgeDirecciones, PgePaises> paiId;
    public static volatile SingularAttribute<PgeDirecciones, PgeCiudades> ciuId;
    public static volatile SingularAttribute<PgeDirecciones, Integer> dirId;
    public static volatile SingularAttribute<PgeDirecciones, String> dirDesc;
    public static volatile SingularAttribute<PgeDirecciones, String> dirObs;

}