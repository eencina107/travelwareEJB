package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PagComprobantesDet;
import com.fpuna.py.travelware.model.PgeMonedas;
import com.fpuna.py.travelware.model.PgePersonas;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:03:15")
@StaticMetamodel(PagComprobantes.class)
public class PagComprobantes_ { 

    public static volatile SingularAttribute<PagComprobantes, String> comUsuMod;
    public static volatile SingularAttribute<PagComprobantes, String> comUsuIns;
    public static volatile SingularAttribute<PagComprobantes, Date> comFecEmis;
    public static volatile SingularAttribute<PagComprobantes, Integer> comIdTran;
    public static volatile SingularAttribute<PagComprobantes, String> comTipDoc;
    public static volatile ListAttribute<PagComprobantes, PagComprobantesDet> pagComprobantesDetList;
    public static volatile SingularAttribute<PagComprobantes, Character> comEstado;
    public static volatile SingularAttribute<PagComprobantes, Character> comCondicion;
    public static volatile SingularAttribute<PagComprobantes, String> comConc;
    public static volatile SingularAttribute<PagComprobantes, PgePersonas> perId;
    public static volatile SingularAttribute<PagComprobantes, BigDecimal> comCotizacion;
    public static volatile SingularAttribute<PagComprobantes, BigDecimal> comTotImp;
    public static volatile SingularAttribute<PagComprobantes, String> comTimbrado;
    public static volatile SingularAttribute<PagComprobantes, String> comObservacion;
    public static volatile SingularAttribute<PagComprobantes, BigDecimal> comTotGra;
    public static volatile SingularAttribute<PagComprobantes, Integer> comNumDoc;
    public static volatile SingularAttribute<PagComprobantes, Date> comFecIns;
    public static volatile SingularAttribute<PagComprobantes, Date> comFecVenc;
    public static volatile SingularAttribute<PagComprobantes, Date> comFecMod;
    public static volatile SingularAttribute<PagComprobantes, BigDecimal> comTotTot;
    public static volatile SingularAttribute<PagComprobantes, BigDecimal> comTotExe;
    public static volatile SingularAttribute<PagComprobantes, PgeMonedas> monId;

}