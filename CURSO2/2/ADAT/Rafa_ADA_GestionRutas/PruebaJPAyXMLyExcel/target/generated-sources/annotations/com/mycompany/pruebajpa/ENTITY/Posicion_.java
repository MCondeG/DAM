package com.mycompany.pruebajpa.ENTITY;

import com.mycompany.pruebajpa.ENTITY.Tramo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-03-21T10:00:03", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Posicion.class)
public class Posicion_ { 

    public static volatile SingularAttribute<Posicion, Integer> idposicion;
    public static volatile SingularAttribute<Posicion, String> descripcion;
    public static volatile SingularAttribute<Posicion, Float> longitud;
    public static volatile SingularAttribute<Posicion, Float> latitud;
    public static volatile ListAttribute<Posicion, Tramo> tramoList;
    public static volatile ListAttribute<Posicion, Tramo> tramoList1;

}