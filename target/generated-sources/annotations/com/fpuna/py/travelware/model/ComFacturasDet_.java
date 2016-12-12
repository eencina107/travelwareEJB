package com.fpuna.py.travelware.model;

import com.fpuna.py.travelware.model.ComFacturas;
import com.fpuna.py.travelware.model.ViaConceptos;
import com.fpuna.py.travelware.model.ViaViajesDet;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T09:07:22")
@StaticMetamodel(ComFacturasDet.class)
public class ComFacturasDet_ { 

    public static volatile SingularAttribute<ComFacturasDet, BigDecimal> fadValor;
    public static volatile SingularAttribute<ComFacturasDet, BigDecimal> fadValUni;
    public static volatile ListAttribute<ComFacturasDet, ViaViajesDet> viaViajesDetList;
    public static volatile SingularAttribute<ComFacturasDet, ViaConceptos> conId;
    public static volatile SingularAttribute<ComFacturasDet, ComFacturas> facId;
    public static volatile SingularAttribute<ComFacturasDet, String> fadDesc;
    public static volatile SingularAttribute<ComFacturasDet, String> fadUsuIns;
    public static volatile SingularAttribute<ComFacturasDet, Integer> fadId;
    public static volatile SingularAttribute<ComFacturasDet, ViaViajesDet> viaDetId;
    public static volatile SingularAttribute<ComFacturasDet, Character> fadUti;
    public static volatile SingularAttribute<ComFacturasDet, BigDecimal> fadMtoImp;
    public static volatile SingularAttribute<ComFacturasDet, BigDecimal> fadPorImp;
    public static volatile SingularAttribute<ComFacturasDet, String> fadUsuMod;
    public static volatile SingularAttribute<ComFacturasDet, Integer> fadCant;
    public static volatile SingularAttribute<ComFacturasDet, BigDecimal> fadMtoExe;
    public static volatile SingularAttribute<ComFacturasDet, Integer> fadNroSec;
    public static volatile SingularAttribute<ComFacturasDet, Integer> artId;
    public static volatile SingularAttribute<ComFacturasDet, Date> fadFecIns;
    public static volatile SingularAttribute<ComFacturasDet, BigDecimal> fadMtoGra;
    public static volatile SingularAttribute<ComFacturasDet, BigDecimal> fadMtoTot;
    public static volatile SingularAttribute<ComFacturasDet, Date> fadFecMod;

}