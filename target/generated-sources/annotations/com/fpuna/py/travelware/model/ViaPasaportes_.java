package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaVisas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T17:02:39")
@StaticMetamodel(ViaPasaportes.class)
public class ViaPasaportes_ { 

    public static volatile SingularAttribute<ViaPasaportes, Integer> patId;
    public static volatile SingularAttribute<ViaPasaportes, String> patNroPas;
    public static volatile SingularAttribute<ViaPasaportes, Date> patFecMod;
    public static volatile SingularAttribute<ViaPasaportes, PgePersonas> perId;
    public static volatile SingularAttribute<ViaPasaportes, Date> patFecIns;
    public static volatile ListAttribute<ViaPasaportes, ViaVisas> viaVisasList;
    public static volatile SingularAttribute<ViaPasaportes, Date> patFecEmi;
    public static volatile SingularAttribute<ViaPasaportes, String> patUsuMod;
    public static volatile SingularAttribute<ViaPasaportes, Date> patFecVen;
    public static volatile SingularAttribute<ViaPasaportes, String> patUsuIns;

}