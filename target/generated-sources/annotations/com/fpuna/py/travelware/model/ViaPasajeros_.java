package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaGastos;
import com.fpuna.py.travelware.model.ViaViajes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T17:19:07")
@StaticMetamodel(ViaPasajeros.class)
public class ViaPasajeros_ { 

    public static volatile SingularAttribute<ViaPasajeros, String> pviUsuIns;
    public static volatile SingularAttribute<ViaPasajeros, Date> pviFecMod;
    public static volatile SingularAttribute<ViaPasajeros, Integer> pviId;
    public static volatile SingularAttribute<ViaPasajeros, ViaViajes> viaId;
    public static volatile SingularAttribute<ViaPasajeros, String> pviUsuMod;
    public static volatile SingularAttribute<ViaPasajeros, Date> pviFecIns;
    public static volatile SingularAttribute<ViaPasajeros, String> pasPrefComi;
    public static volatile SingularAttribute<ViaPasajeros, PgePersonas> perId;
    public static volatile CollectionAttribute<ViaPasajeros, ViaGastos> viaGastosCollection;
    public static volatile SingularAttribute<ViaPasajeros, Character> pasRel;
    public static volatile SingularAttribute<ViaPasajeros, Character> pasPrefAsi;

}