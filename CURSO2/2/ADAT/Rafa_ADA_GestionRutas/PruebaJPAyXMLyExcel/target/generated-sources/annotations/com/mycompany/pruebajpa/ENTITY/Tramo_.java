package com.mycompany.pruebajpa.ENTITY;

import com.mycompany.pruebajpa.ENTITY.Posicion;
import com.mycompany.pruebajpa.ENTITY.Ruta;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-03-21T10:00:03", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Tramo.class)
public class Tramo_ { 

    public static volatile SingularAttribute<Tramo, Integer> idtramo;
    public static volatile SingularAttribute<Tramo, Posicion> posicion;
    public static volatile SingularAttribute<Tramo, Float> tiempoTeorico;
    public static volatile SingularAttribute<Tramo, Float> tiempoReal;
    public static volatile SingularAttribute<Tramo, Float> distanciaTeorica;
    public static volatile SingularAttribute<Tramo, Float> nodoInicial;
    public static volatile SingularAttribute<Tramo, Float> nodoFinal;
    public static volatile SingularAttribute<Tramo, Ruta> ruta;
    public static volatile SingularAttribute<Tramo, Posicion> posicion1;
    public static volatile SingularAttribute<Tramo, Float> rumbo;
    public static volatile SingularAttribute<Tramo, Float> velocidad;

}