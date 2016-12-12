package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.PagComprobantes;
import com.fpuna.py.travelware.model.ViaViajes;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T09:07:22")
@StaticMetamodel(PagComprobantesDet.class)
public class PagComprobantesDet_ { 

    public static volatile SingularAttribute<PagComprobantesDet, Date> cdeFecIns;
    public static volatile SingularAttribute<PagComprobantesDet, BigDecimal> cdeExe;
    public static volatile SingularAttribute<PagComprobantesDet, String> cdeUsuMod;
    public static volatile SingularAttribute<PagComprobantesDet, BigDecimal> cdeIva;
    public static volatile SingularAttribute<PagComprobantesDet, Date> cdeFecMod;
    public static volatile SingularAttribute<PagComprobantesDet, String> cdeUsuIns;
    public static volatile SingularAttribute<PagComprobantesDet, Integer> cdeNroDet;
    public static volatile SingularAttribute<PagComprobantesDet, Integer> comDetId;
    public static volatile SingularAttribute<PagComprobantesDet, ViaViajes> viaId;
    public static volatile SingularAttribute<PagComprobantesDet, BigDecimal> cdeTot;
    public static volatile SingularAttribute<PagComprobantesDet, Integer> cdeNumCuota;
    public static volatile SingularAttribute<PagComprobantesDet, PagComprobantes> comId;
    public static volatile SingularAttribute<PagComprobantesDet, BigDecimal> cdePorRde;
    public static volatile SingularAttribute<PagComprobantesDet, BigDecimal> cdeGra;

}