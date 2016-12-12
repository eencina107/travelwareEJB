package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgePersonas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T09:07:22")
@StaticMetamodel(PgeProfesiones.class)
public class PgeProfesiones_ { 

    public static volatile SingularAttribute<PgeProfesiones, String> prfUsuMod;
    public static volatile SingularAttribute<PgeProfesiones, String> prfDesc;
    public static volatile SingularAttribute<PgeProfesiones, String> prfObs;
    public static volatile SingularAttribute<PgeProfesiones, Date> prfFecMod;
    public static volatile SingularAttribute<PgeProfesiones, Integer> prfId;
    public static volatile SingularAttribute<PgeProfesiones, Date> prfFecIns;
    public static volatile SingularAttribute<PgeProfesiones, String> prfUsuIns;
    public static volatile ListAttribute<PgeProfesiones, PgePersonas> pgePersonasList;

}