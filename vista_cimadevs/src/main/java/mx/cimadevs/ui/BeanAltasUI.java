package mx.cimadevs.ui;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.cimadevs.DAO.ProfesorDAO;
import mx.cimadevs.DAO.AsignacionDAO;
import mx.cimadevs.entidad.Asignacion;
import mx.cimadevs.entidad.Materia;
import mx.cimadevs.entidad.Profesor;

@ManagedBean(name = "profesorAltasBean")
@ViewScoped
public class BeanAltasUI implements Serializable {

    // Propiedades para almacenar los datos del nuevo profesor y la materia seleccionada
    private String nombre;
    private String apellido;
    private String rfc;
    Profesor nuevoProfesor = new Profesor(); // Profesor a registrar
    ProfesorDAO profeDao = new ProfesorDAO(); // DAO para profesores
    Integer idProfesorRegistrado; // ID del profesor registrado en la base de datos
    private Integer materiaSeleccionada; // ID de la materia seleccionada en el formulario

    public void init() {
        // Puedes realizar cualquier inicialización necesaria aquí
    }

    // Getters y setters para las propiedades

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
        // Crear un nuevo profesor con los datos proporcionados en el formulario
        nuevoProfesor.setNombre(nombre);
        nuevoProfesor.setApellido(apellido);
        nuevoProfesor.setRfc(rfc);

        // Guardar el nuevo profesor en la base de datos y obtener su ID asignado
        profeDao.save(nuevoProfesor);
        idProfesorRegistrado = nuevoProfesor.getIdprofesor();

        // Crear una nueva asignación entre el profesor y la materia seleccionada
        Asignacion nuevaAsignacion = new Asignacion();
        nuevaAsignacion.setIdprofesor(new Profesor(idProfesorRegistrado)); // Usar el ID del profesor registrado
        nuevaAsignacion.setIdmateria(new Materia(materiaSeleccionada)); // Usar la materia seleccionada

        // Guardar la nueva asignación en la base de datos
        AsignacionDAO asignacionDao = new AsignacionDAO();
        asignacionDao.save(nuevaAsignacion);

        // Limpiar los campos del formulario después de guardar
        limpiarCampos();
    }

    // Método para limpiar los campos del formulario
    public void limpiarCampos() {
        nombre = "";
        apellido = "";
        rfc = "";
    }
}
