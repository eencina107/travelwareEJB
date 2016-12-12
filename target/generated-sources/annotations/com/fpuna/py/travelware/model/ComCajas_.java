package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComMovCajas;
import com.fpuna.py.travelware.model.PgeMonedas;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:03:15")
@StaticMetamodel(ComCajas.class)
public class ComCajas_ { 

    public static volatile SingularAttribute<ComCajas, String> cajUsuMod;
    public static volatile SingularAttribute<ComCajas, BigDecimal> cajLim;
    public static volatile SingularAttribute<ComCajas, String> cajUsuIns;
    public static volatile SingularAttribute<ComCajas, String> cajDesc;
    public static volatile SingularAttribute<ComCajas, BigDecimal> cajSaldo;
    public static volatile SingularAttribute<ComCajas, Date> cajFecIns;
    public static volatile SingularAttribute<ComCajas, Integer> cajId;
    public static volatile SingularAttribute<ComCajas, Character> cajEst;
    public static volatile SingularAttribute<ComCajas, Date> cajFecMod;
    public static volatile CollectionAttribute<ComCajas, ComMovCajas> comMovCajasCollection;
    public static volatile SingularAttribute<ComCajas, PgeMonedas> monId;

}