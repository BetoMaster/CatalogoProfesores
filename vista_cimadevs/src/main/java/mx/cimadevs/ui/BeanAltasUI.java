package mx.cimadevs.ui;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import mx.cimadevs.DAO.ProfesorDAO;
import mx.cimadevs.DAO.AsignacionDAO;
import mx.cimadevs.entidad.Asignacion;
import mx.cimadevs.entidad.Materia;
import mx.cimadevs.entidad.Profesor;

@ManagedBean(name = "profesorAltasBean")
@ViewScoped
public class BeanAltasUI implements Serializable {
    // Aquí se declaran las propiedades que el bean va a utilizar para almacenar los datos ingresados en el formulario.

    @NotNull(message = "El campo Nombre es obligatorio")
    @Size(min = 1, message = "El campo Nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El campo Apellido es obligatorio")
    @Size(min = 1, message = "El campo Apellido es obligatorio")
    private String apellido;

    @NotNull(message = "El campo RFC es obligatorio")
    @Size(min = 1, message = "El campo RFC es obligatorio")
    private String rfc;

    Profesor nuevoProfesor = new Profesor();
    ProfesorDAO profeDao = new ProfesorDAO();
    Integer idProfesorRegistrado;
    private Integer materiaSeleccionada;
    private boolean mostrarDialogo;

    // Métodos de inicialización
    public void init() {

    }

    //Getters y setters
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

    // Getters y setters adicionales para controlar el diálogo
    public boolean isMostrarDialogo() {
        return mostrarDialogo;
    }

    public void setMostrarDialogo(boolean mostrarDialogo) {
        this.mostrarDialogo = mostrarDialogo;
    }

    // Método para guardar el profesor en la base de datos.
    public void guardarProfesor() {
        if (validarCampos()) {
            nuevoProfesor.setNombre(nombre);
            nuevoProfesor.setApellido(apellido);
            nuevoProfesor.setRfc(rfc);

            profeDao.save(nuevoProfesor);
            mostrarDialogo = true;

            idProfesorRegistrado = nuevoProfesor.getIdprofesor();

            // Crea una nueva asignación, esta se hace por primera vez cada que se registra un nuevo profesor
            Asignacion nuevaAsignacion = new Asignacion();
            nuevaAsignacion.setIdprofesor(new Profesor(idProfesorRegistrado)); // Usar el ID del profesor
            nuevaAsignacion.setIdmateria(new Materia(materiaSeleccionada)); // Usar la materia seleccionada

            AsignacionDAO asignacionDao = new AsignacionDAO();
            asignacionDao.save(nuevaAsignacion);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));

            limpiarCampos();
        }
    }

    // Método para validar los campos obligatorios
    private boolean validarCampos() {
        boolean camposValidos = true;

        if (nombre == null || nombre.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("globalMessages",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo Nombre es obligatorio", null));
            camposValidos = false;
        }

        if (apellido == null || apellido.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("globalMessages",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo Apellido es obligatorio", null));
            camposValidos = false;
        }

        if (rfc == null || rfc.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("globalMessages",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo RFC es obligatorio", null));
            camposValidos = false;
        }
        if (materiaSeleccionada == null || materiaSeleccionada <= 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debes seleccionar una materia", null));
            camposValidos = false;
        }

        return camposValidos;
    }
    
    // Método para limpiar los campos del formulario
    public void limpiarCampos() {
        nombre = "";
        apellido = "";
        rfc = "";
    }
}
