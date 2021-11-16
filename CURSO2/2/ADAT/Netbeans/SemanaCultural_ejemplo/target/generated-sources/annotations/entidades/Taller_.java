package entidades;

import entidades.Alumno;
import entidades.Profesor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-11-10T13:16:47", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Taller.class)
public class Taller_ { 

    public static volatile SingularAttribute<Taller, Profesor> idProfesor;
    public static volatile SingularAttribute<Taller, String> observaciones;
    public static volatile ListAttribute<Taller, Alumno> alumnoList;
    public static volatile SingularAttribute<Taller, String> nombre;
    public static volatile SingularAttribute<Taller, Integer> idTaller;

}