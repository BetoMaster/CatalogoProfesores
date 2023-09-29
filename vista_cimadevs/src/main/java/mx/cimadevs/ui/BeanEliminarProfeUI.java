package mx.cimadevs.ui;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.cimadevs.entidad.Profesor;
import mx.cimadevs.helper.profesorHelper;

@ManagedBean(name = "EliminarProfesorBean")
@ViewScoped

public class BeanEliminarProfeUI implements Serializable{
    
    private List<Profesor> listaProfesores;
    private Profesor profesor;
    private profesorHelper profeHelp;
    
    
    
    public BeanEliminarProfeUI(){
        cargarProfesores();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    
    
    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }
    
    private void cargarProfesores() {
        profeHelp = new profesorHelper();
        listaProfesores = profeHelp.obteneProfesor();
    }
    
    public void eliminarProfesor(){
        profeHelp = new profesorHelper();
        profeHelp.eliminarProfesor(profesor);
        profesor = new Profesor();
    }
    
    
}
