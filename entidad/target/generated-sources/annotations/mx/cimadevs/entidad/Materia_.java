package mx.cimadevs.entidad;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.cimadevs.entidad.Asignacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-24T18:47:44")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, Date> horasLaboratorio;
    public static volatile SingularAttribute<Materia, String> nombreDeLaMateria;
    public static volatile ListAttribute<Materia, Asignacion> asignacionList;
    public static volatile SingularAttribute<Materia, Date> horasClase;
    public static volatile SingularAttribute<Materia, Integer> idmateria;
    public static volatile SingularAttribute<Materia, Date> horasTaller;

}