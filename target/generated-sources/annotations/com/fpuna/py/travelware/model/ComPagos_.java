package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComFacturas;
import com.fpuna.py.travelware.model.PgeMonedas;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T09:07:22")
@StaticMetamodel(ComPagos.class)
public class ComPagos_ { 

    public static volatile SingularAttribute<ComPagos, Boolean> pgoEstado;
    public static volatile SingularAttribute<ComPagos, ComFacturas> facId;
    public static volatile SingularAttribute<ComPagos, Integer> pgoCuotaNro;
    public static volatile SingularAttribute<ComPagos, Date> pgoFecIns;
    public static volatile SingularAttribute<ComPagos, Integer> pgoId;
    public static volatile SingularAttribute<ComPagos, String> pgoUsuIns;
    public static volatile SingularAttribute<ComPagos, Date> pgoFecMod;
    public static volatile SingularAttribute<ComPagos, String> pgoNro;
    public static volatile SingularAttribute<ComPagos, BigDecimal> pgoCambio;
    public static volatile SingularAttribute<ComPagos, BigDecimal> pgoMonto;
    public static volatile SingularAttribute<ComPagos, Character> pgoAnulado;
    public static volatile SingularAttribute<ComPagos, String> pgoUsuMod;
    public static volatile SingularAttribute<ComPagos, String> pgoForPago;
    public static volatile SingularAttribute<ComPagos, String> pgoTipo;
    public static volatile SingularAttribute<ComPagos, String> pgoMontoLetras;
    public static volatile SingularAttribute<ComPagos, String> pgoObservacion;
    public static volatile SingularAttribute<ComPagos, PgeMonedas> monId;

}