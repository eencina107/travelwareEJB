package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.PgeUsuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T17:02:39")
@StaticMetamodel(ConContactos.class)
public class ConContactos_ { 

    public static volatile SingularAttribute<ConContactos, PgeUsuarios> conIdUsuarioCont;
    public static volatile SingularAttribute<ConContactos, Integer> conId;
    public static volatile SingularAttribute<ConContactos, Date> conFechaContacto;
    public static volatile SingularAttribute<ConContactos, Boolean> conExito;
    public static volatile SingularAttribute<ConContactos, Character> conTipo;
    public static volatile SingularAttribute<ConContactos, PgePersonas> conIdPersonaCont;
    public static volatile SingularAttribute<ConContactos, Character> conEstado;
    public static volatile SingularAttribute<ConContactos, String> conObservacion;

}