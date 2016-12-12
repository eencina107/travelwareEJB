package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ViaPasajeros;
import com.fpuna.py.travelware.model.ViaPreViajes;
import com.fpuna.py.travelware.model.ViaViajes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:03:15")
@StaticMetamodel(ViaPasViajes.class)
public class ViaPasViajes_ { 

    public static volatile SingularAttribute<ViaPasViajes, Date> pviFecMod;
    public static volatile SingularAttribute<ViaPasViajes, String> pviUsuIns;
    public static volatile SingularAttribute<ViaPasViajes, Integer> pviId;
    public static volatile SingularAttribute<ViaPasViajes, Character> pviRel;
    public static volatile SingularAttribute<ViaPasViajes, ViaPreViajes> viaPreViajes;
    public static volatile SingularAttribute<ViaPasViajes, ViaViajes> viaId;
    public static volatile SingularAttribute<ViaPasViajes, String> pviUsuMod;
    public static volatile SingularAttribute<ViaPasViajes, Date> pviFecIns;
    public static volatile SingularAttribute<ViaPasViajes, ViaPasajeros> perId;
    public static volatile SingularAttribute<ViaPasViajes, ViaPasajeros> pviPasId;
    public static volatile SingularAttribute<ViaPasViajes, Integer> monId;
    public static volatile SingularAttribute<ViaPasViajes, Integer> preId;

}