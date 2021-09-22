package semanacultural;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import semanacultural.Talleres;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-06T09:45:07")
@StaticMetamodel(Alumnos.class)
public class Alumnos_ { 

    public static volatile SingularAttribute<Alumnos, Integer> idalumno;
    public static volatile SingularAttribute<Alumnos, String> nombre;
    public static volatile SingularAttribute<Alumnos, String> alumnoscol;
    public static volatile SetAttribute<Alumnos, Talleres> talleresSet;

}