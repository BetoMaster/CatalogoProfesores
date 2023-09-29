package mx.cimadevs.ui;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.cimadevs.entidad.Asignacion;
import mx.cimadevs.entidad.Materia;
import mx.cimadevs.entidad.Profesor;
import mx.cimadevs.helper.AsignacionHelper;
import mx.cimadevs.helper.profesorHelper;

@ManagedBean(name = "profesorAltasBean")
@ViewScoped
public class BeanAltasUI implements Serializable {
    
    
    
    profesorHelper profHelp;
    AsignacionHelper asigHelp;
    private String nombre;
    private String apellido;
    private String rfc;
    Profesor nuevoProfesor = new Profesor();
    Integer idProfesorRegistrado;
    private Integer materiaSeleccionada;

    public void init() {
        profHelp = new profesorHelper();
        asigHelp = new AsignacionHelper();
    }

    public profesorHelper getProfHelp() {
        return profHelp;
    }

    public void setProfHelp(profesorHelper profHelp) {
        this.profHelp = profHelp;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Integer getidProfesorRegistrado() {
        return idProfesorRegistrado;
    }

    public void setidProfesorRegistrado(Integer idProfesorRegistrado) {
        this.idProfesorRegistrado = idProfesorRegistrado;
    }

    public Integer getMateriaSeleccionada() {
        return materiaSeleccionada;
    }

    public void setMateriaSeleccionada(Integer materiaSeleccionada) {
        this.materiaSeleccionada = materiaSeleccionada;
    }

    // Método para guardar el profesor en la base de datos.
    public void guardarProfesor() {
        nuevoProfesor.setNombre(nombre);
        nuevoProfesor.setApellido(apellido);
        nuevoProfesor.setRfc(rfc);
        
        profesorHelper profHelp2 = new profesorHelper();
        profHelp2.guardarProfesor(nuevoProfesor);

        idProfesorRegistrado = nuevoProfesor.getIdprofesor();

        // Crea una nueva asignación
        Asignacion nuevaAsignacion = new Asignacion();
        nuevaAsignacion.setIdprofesor(new Profesor(idProfesorRegistrado)); // Usar el ID del profesor
        nuevaAsignacion.setIdmateria(new Materia(materiaSeleccionada)); // Usar la materia seleccionada

        AsignacionHelper asigHelp2 = new AsignacionHelper();
        asigHelp2.guardarAsignacion(nuevaAsignacion);

        limpiarCampos();
    }

    public void limpiarCampos() {
        nombre = "";
        apellido = "";
        rfc = "";
    }
}
