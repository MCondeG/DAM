package com.mycompany.pruebajpa.ENTITY;

import com.mycompany.pruebajpa.ENTITY.Tramo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-03-21T10:00:03", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Ruta.class)
public class Ruta_ { 

    public static volatile SingularAttribute<Ruta, String> descripcion;
    public static volatile SingularAttribute<Ruta, Float> tiempoTeorico;
    public static volatile SingularAttribute<Ruta, Float> tiempoReal;
    public static volatile SingularAttribute<Ruta, Tramo> tramo;
    public static volatile SingularAttribute<Ruta, Float> velocidadReal;
    public static volatile SingularAttribute<Ruta, Float> distanciaTeorica;
    public static volatile SingularAttribute<Ruta, Float> distanciaReal;
    public static volatile SingularAttribute<Ruta, Integer> idruta;
    public static volatile SingularAttribute<Ruta, Float> rumbo;
    public static volatile SingularAttribute<Ruta, Float> velocidadTeorica;

}