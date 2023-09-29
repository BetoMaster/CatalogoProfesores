
package mx.cimadevs.helper;

import java.io.Serializable;
import java.util.List;
import mx.cimadevs.DAO.AsignacionDAO;
import mx.cimadevs.entidad.Asignacion;
import mx.cimadevs.integracion.ServiceFacadeLocator;

public class AsignacionHelper implements Serializable{
    
    public void guardarAsignacion(Asignacion asignacion){
        ServiceFacadeLocator.getInstanceFacadeAsignacion().guardarAsignacion(asignacion);
    }
    
    public List<Asignacion> obtenerAsignacion(){
         AsignacionDAO asigDAO = new AsignacionDAO();
        return asigDAO.findAll();
    }
    
    public void modificarAsignacion(Asignacion asignacion){
        AsignacionDAO asigDAO = new AsignacionDAO();
        asigDAO.update(asignacion);
    }
    
}
