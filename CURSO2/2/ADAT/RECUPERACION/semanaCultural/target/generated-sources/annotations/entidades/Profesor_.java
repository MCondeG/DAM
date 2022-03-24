package entidades;

import entidades.Taller;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-11-10T13:16:47", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile ListAttribute<Profesor, Taller> tallerList;
    public static volatile SingularAttribute<Profesor, String> password;
    public static volatile SingularAttribute<Profesor, Integer> idProfesor;
    public static volatile SingularAttribute<Profesor, String> nombreUsuario;
    public static volatile SingularAttribute<Profesor, String> nombre;

}