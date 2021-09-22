package semanacultural;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import semanacultural.Alumnos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-06T09:45:07")
@StaticMetamodel(Talleres.class)
public class Talleres_ { 

    public static volatile SingularAttribute<Talleres, String> nombre;
    public static volatile SingularAttribute<Talleres, String> responsable;
    public static volatile SetAttribute<Talleres, Alumnos> alumnosSet;
    public static volatile SingularAttribute<Talleres, String> diaHora;
    public static volatile SingularAttribute<Talleres, String> lugar;
    public static volatile SingularAttribute<Talleres, Integer> idTaller;
    public static volatile SingularAttribute<Talleres, String> observaciones;
    public static volatile SingularAttribute<Talleres, String> duracion;

}