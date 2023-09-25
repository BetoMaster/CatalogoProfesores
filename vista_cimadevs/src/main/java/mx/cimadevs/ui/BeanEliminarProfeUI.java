package mx.cimadevs.ui;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.cimadevs.DAO.AsignacionDAO;
import mx.cimadevs.entidad.Profesor;
import mx.cimadevs.DAO.ProfesorDAO;

@ManagedBean(name = "EliminarProfesorBean")
@ViewScoped

public class BeanEliminarProfeUI implements Serializable{
    
    private List<Profesor> listaProfesores;
    private Profesor profesor;
    
    
    
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
        ProfesorDAO profesorDAO = new ProfesorDAO();
        listaProfesores = profesorDAO.findAll();
    }
    
    public void eliminarProfesor(){
        ProfesorDAO profeDao = new ProfesorDAO();
        profeDao.delete(profesor);
        profesor = new Profesor();
    }
    
    
}
