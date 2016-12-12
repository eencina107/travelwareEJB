package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgePaises;
import com.fpuna.py.travelware.model.ViaPasaportes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:03:15")
@StaticMetamodel(ViaVisas.class)
public class ViaVisas_ { 

    public static volatile SingularAttribute<ViaVisas, Date> visFecVenc;
    public static volatile SingularAttribute<ViaVisas, Integer> visId;
    public static volatile SingularAttribute<ViaVisas, ViaPasaportes> patId;
    public static volatile SingularAttribute<ViaVisas, Integer> visNro;
    public static volatile SingularAttribute<ViaVisas, String> visNroSec;
    public static volatile SingularAttribute<ViaVisas, PgePaises> paiId;

}