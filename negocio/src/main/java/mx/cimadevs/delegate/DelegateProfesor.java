/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.cimadevs.delegate;
import java.util.List;
import mx.cimadevs.entidad.Profesor;
import mx.cimadevs.integracion.ServiceLocator;
/**
 *
 * @author PC
 */
public class DelegateProfesor {
    
     public Profesor login(int idprofesor, String nombre){
        Profesor profesor = new Profesor();
        List<Profesor> Profesores = ServiceLocator.getInstanceProfesorDAO().findAll();
        
        for(Profesor us:Profesores){
            if(us.getIdprofesor().equals(idprofesor) && us.getNombre().equalsIgnoreCase(nombre)){
                profesor = us;
            }
        }
        return profesor;
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveProfesor(Profesor profesor){
        ServiceLocator.getInstanceProfesorDAO().save(profesor);
    } 
    
}
