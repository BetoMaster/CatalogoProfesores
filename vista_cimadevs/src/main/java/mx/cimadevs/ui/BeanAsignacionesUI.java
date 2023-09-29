package mx.cimadevs.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.cimadevs.DAO.ProfesorDAO;
import mx.cimadevs.DAO.MateriaDAO;
import mx.cimadevs.entidad.Profesor;
import mx.cimadevs.entidad.Materia;
import javax.faces.model.SelectItem;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import mx.cimadevs.DAO.AsignacionDAO;
import mx.cimadevs.entidad.Asignacion;
import mx.cimadevs.helper.AsignacionHelper;
import mx.cimadevs.helper.MateriaHelper;
import mx.cimadevs.helper.profesorHelper;

@ManagedBean(name = "asignacionBean")
@ViewScoped
public class BeanAsignacionesUI implements Serializable {
  // Declaración de variables 

    private Integer idasignacion;
    private Profesor idprofesor;
    private Materia idmateria;
    private AsignacionDAO asignacionDao;
    private List<SelectItem> profesoresSelectItems;
    private List<SelectItem> materiasSelectItems;
    private Integer idProfesorSeleccionado;
    private Integer idMateriaSeleccionada;
    private profesorHelper profeHelp;
    private AsignacionHelper asigHelp;
    private MateriaHelper matHelp;

    public BeanAsignacionesUI() {
        asignacionDao = new AsignacionDAO();
    }
 // Getters y setters
    public Integer getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public Profesor getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Profesor idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Materia getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Materia idmateria) {
        this.idmateria = idmateria;
    }
    // Método para obtener la lista de profesores como objetos SelectItem

    public List<SelectItem> getProfesoresSelectItems() {
        ProfesorDAO profesorDao = new ProfesorDAO();
        profeHelp = new profesorHelper();
        List<Profesor> profesores = profeHelp.obteneProfesor();

        profesoresSelectItems = new ArrayList<>();
        for (Profesor profesor : profesores) {
            profesoresSelectItems.add(new SelectItem(profesor.getIdprofesor(), profesor.getNombre()));
        }

        return profesoresSelectItems;
    }
    // Método para obtener la lista de materias como objetos SelectItem

    public List<SelectItem> getMateriasSelectItems() {
        matHelp = new MateriaHelper();
        List<Materia> materias = matHelp.obtenerMaterias();
        materiasSelectItems = new ArrayList<>();
        for (Materia materia : materias) {
            materiasSelectItems.add(new SelectItem(materia.getIdmateria(), materia.getNombreDeLaMateria()));
        }

        return materiasSelectItems;
    }
    // Getters y setters para idMateriaSeleccionada
    public Integer getIdMateriaSeleccionada() {
        return idMateriaSeleccionada;
    }

    public void setIdMateriaSeleccionada(Integer idMateriaSeleccionada) {
        this.idMateriaSeleccionada = idMateriaSeleccionada;
    }

    public Integer getIdProfesorSeleccionado() {
        return idProfesorSeleccionado;
    }
    
    // Getters y setters para idProfesorSeleccionado
    public void setIdProfesorSeleccionado(Integer idProfesorSeleccionado) {
        this.idProfesorSeleccionado = idProfesorSeleccionado;
    }
    // Método para guardar una nueva asignación

    public void guardarAsignacion() {
        MateriaDAO materiaDao = new MateriaDAO();
        ProfesorDAO profeDao = new ProfesorDAO();
        if (idProfesorSeleccionado != null && idMateriaSeleccionada != null) {

            Materia materia = materiaDao.find(idMateriaSeleccionada);
            Profesor profesor = profeDao.find(idProfesorSeleccionado);
            
            Asignacion nuevaAsignacion = new Asignacion();
            nuevaAsignacion.setIdprofesor(profesor);
            nuevaAsignacion.setIdmateria(materia);

            asignacionDao.save(nuevaAsignacion);

            idProfesorSeleccionado = null;
            idMateriaSeleccionada = null;
        }
    }
}
