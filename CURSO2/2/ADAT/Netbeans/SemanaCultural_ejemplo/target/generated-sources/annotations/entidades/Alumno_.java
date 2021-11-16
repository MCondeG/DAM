package entidades;

import entidades.Taller;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-11-10T13:16:47", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, Integer> idAlumno;
    public static volatile ListAttribute<Alumno, Taller> tallerList;
    public static volatile SingularAttribute<Alumno, String> password;
    public static volatile SingularAttribute<Alumno, String> nombreUsuario;
    public static volatile SingularAttribute<Alumno, String> nombre;
    public static volatile SingularAttribute<Alumno, String> idGrupo;

}