package mx.cimadevs.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.cimadevs.entidad.Asignacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-18T15:03:27")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, String> apellido;
    public static volatile ListAttribute<Profesor, Asignacion> asignacionList;
    public static volatile SingularAttribute<Profesor, String> nombre;
    public static volatile SingularAttribute<Profesor, Integer> idprofesor;
    public static volatile SingularAttribute<Profesor, String> rfc;

}