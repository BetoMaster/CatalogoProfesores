package mx.cimadevs.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.cimadevs.entidad.Materia;
import mx.cimadevs.entidad.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-23T21:10:24")
@StaticMetamodel(Asignacion.class)
public class Asignacion_ { 

    public static volatile SingularAttribute<Asignacion, Materia> idmateria;
    public static volatile SingularAttribute<Asignacion, Profesor> idprofesor;
    public static volatile SingularAttribute<Asignacion, Integer> idasignacion;

}