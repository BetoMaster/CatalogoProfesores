package mx.cimadevs.helper;
import java.io.Serializable;
import java.util.List;
import mx.cimadevs.DAO.ProfesorDAO;
import mx.cimadevs.entidad.Profesor;
import mx.cimadevs.integracion.ServiceFacadeLocator;

public class profesorHelper implements Serializable{
     
    public void guardarProfesor(Profesor profesor){
        ServiceFacadeLocator.getInstanceFacadeProfesor().guardarProfesor(profesor);
    }
    
    public void eliminarProfesor(Profesor profesor){
        ProfesorDAO profeDao = new ProfesorDAO();
        profeDao.delete(profesor);
    }
    
    public List<Profesor> obteneProfesor(){
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.findAll();
    }
    
    public void modificarProfesor(Profesor profesor){
        ProfesorDAO profesorDAO = new ProfesorDAO();
        profesorDAO.update(profesor);
    }
}
