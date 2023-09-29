/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.cimadevs.delegate;
import java.util.List;
import mx.cimadevs.entidad.Asignacion;
import mx.cimadevs.integracion.ServiceLocator;

/**
 *
 * @author PC
 */
public class DelegateAsignacion {
    
  public Asignacion login(int idprofesor, int idmateria){
        Asignacion asignacion = new Asignacion();
        List<Asignacion> asignaciones = ServiceLocator.getInstanceAsignacionDAO().findAll();
        
        for(Asignacion us:asignaciones){
            if(us.getIdprofesor().equals(idprofesor) && us.getIdmateria().equals(idmateria)){
                asignacion = us;
            }
        }
        return asignacion;
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveAsignacion(Asignacion asignacion){
        ServiceLocator.getInstanceAsignacionDAO().save(asignacion);
    } 
    
    public List<Asignacion> obtenerAsignacion() {
        return ServiceLocator.getInstanceAsignacionDAO().findAll();
    }
    
    public void updateAsignacion(Asignacion asignacion){
        ServiceLocator.getInstanceAsignacionDAO().update(asignacion);
    }
}



