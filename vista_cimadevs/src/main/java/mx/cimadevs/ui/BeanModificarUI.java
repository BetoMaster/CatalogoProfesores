package mx.cimadevs.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import mx.cimadevs.DAO.AsignacionDAO;
import mx.cimadevs.DAO.ProfesorDAO;
import mx.cimadevs.entidad.Asignacion;
import mx.cimadevs.entidad.Materia;
import mx.cimadevs.entidad.Profesor;
import mx.cimadevs.DAO.MateriaDAO;


@ManagedBean(name = "ModificarProfesorBean")
@ViewScoped

public class BeanModificarUI implements Serializable{
    
    private String nombre;
    private String apellido;
    private String rfc;
    Integer idProfesorRegistrado;
    private Integer materiaSeleccionada;
    ProfesorDAO profeDao = new ProfesorDAO();
    private Asignacion asignacion;
    List<Asignacion> listaAsignaciones;
    private List<Profesor> listaProfesores;
    private Profesor profesor;
    private List<SelectItem> materiasSelectItems;
    MateriaDAO materiaDao = new MateriaDAO();
    private Integer idProfesorSeleccionado;
    private Integer idMateriaSeleccionada;

    
    public BeanModificarUI(){
        cargarAsignaciones();
        cargarProfesores();
    }
    
    @PostConstruct
    public void init() {
        // Cargar la lista de materias disponibles
        List<Materia> materias = materiaDao.findAll();
        materiasSelectItems = new ArrayList<>();

        for (Materia materia : materias) {
            materiasSelectItems.add(new SelectItem(materia.getIdmateria(), materia.getNombreDeLaMateria()));
        }
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
     
    
    
    public List<SelectItem> getMateriasSelectItems() {
        return materiasSelectItems;
    }
    
    private void cargarProfesores() {
        ProfesorDAO profesorDAO = new ProfesorDAO();
        listaProfesores = profesorDAO.findAll();
    }
    
    public List<Asignacion> getListaAsignaciones() {
        return listaAsignaciones;
    }
    
     private void cargarAsignaciones() {
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        listaAsignaciones = asignacionDAO.findAll();
    }
     
    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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

    public Integer getIdProfesorRegistrado() {
        return idProfesorRegistrado;
    }

    public void setIdProfesorRegistrado(Integer idProfesorRegistrado) {
        this.idProfesorRegistrado = idProfesorRegistrado;
    }

    public Integer getMateriaSeleccionada() {
        return materiaSeleccionada;
    }

    public void setMateriaSeleccionada(Integer materiaSeleccionada) {
        this.materiaSeleccionada = materiaSeleccionada;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }
     
    
          
    public void modificarAsignacion(){
        AsignacionDAO asignacionDao = new AsignacionDAO();
        asignacionDao.update(asignacion);
        asignacion = new Asignacion();
    }
    //Aqui se hace la actualizacion de los datos de profesor unicamente, funciona perfecto solo falta hacer que se modifique id materia
    //en tabla asignacion
     public void modificarProfesor(){
        profeDao = new ProfesorDAO();
        profeDao.update(profesor);
        profesor = new Profesor();
    }
     
}
