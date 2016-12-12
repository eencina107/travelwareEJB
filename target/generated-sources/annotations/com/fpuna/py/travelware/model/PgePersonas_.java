package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComProveedores;
import com.fpuna.py.travelware.model.ConContactos;
import com.fpuna.py.travelware.model.PagCobros;
import com.fpuna.py.travelware.model.PagComprobantes;
import com.fpuna.py.travelware.model.PgeDirecciones;
import com.fpuna.py.travelware.model.PgePaises;
import com.fpuna.py.travelware.model.PgeProfesiones;
import com.fpuna.py.travelware.model.PgeUsuarios;
import com.fpuna.py.travelware.model.ViaPasajeros;
import com.fpuna.py.travelware.model.ViaPasaportes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T09:07:22")
@StaticMetamodel(PgePersonas.class)
public class PgePersonas_ { 

    public static volatile SingularAttribute<PgePersonas, String> perDoc;
    public static volatile SingularAttribute<PgePersonas, Date> perFecNac;
    public static volatile ListAttribute<PgePersonas, PgeDirecciones> pgeDireccionesList;
    public static volatile CollectionAttribute<PgePersonas, ConContactos> conContactosList;
    public static volatile SingularAttribute<PgePersonas, String> perDir;
    public static volatile SingularAttribute<PgePersonas, String> perNroDoc;
    public static volatile SingularAttribute<PgePersonas, ViaPasaportes> viaPasaportes;
    public static volatile SingularAttribute<PgePersonas, PgePaises> paiId;
    public static volatile SingularAttribute<PgePersonas, Integer> perId;
    public static volatile SingularAttribute<PgePersonas, String> perEmail;
    public static volatile CollectionAttribute<PgePersonas, ComProveedores> comProveedoresCollection;
    public static volatile ListAttribute<PgePersonas, ViaPasajeros> viaPasajerosList;
    public static volatile SingularAttribute<PgePersonas, String> perTel;
    public static volatile SingularAttribute<PgePersonas, String> perUsuMod;
    public static volatile SingularAttribute<PgePersonas, Character> perSex;
    public static volatile SingularAttribute<PgePersonas, Date> perFecMod;
    public static volatile SingularAttribute<PgePersonas, String> perUsuIns;
    public static volatile SingularAttribute<PgePersonas, String> perNom;
    public static volatile ListAttribute<PgePersonas, PagCobros> pagCobrosList;
    public static volatile ListAttribute<PgePersonas, PgeUsuarios> pgeUsuariosList;
    public static volatile ListAttribute<PgePersonas, PagComprobantes> pagComprobantesList;
    public static volatile SingularAttribute<PgePersonas, PgeProfesiones> prfId;
    public static volatile SingularAttribute<PgePersonas, Date> perFecIns;
    public static volatile SingularAttribute<PgePersonas, String> perLugNac;
    public static volatile SingularAttribute<PgePersonas, String> perApe;
    public static volatile ListAttribute<PgePersonas, ViaPasaportes> viaPasaportesList;

}