/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.cimadevs.delegate;
import java.util.List;
import mx.cimadevs.entidad.Materia;
import mx.cimadevs.integracion.ServiceLocator;
/**
 *
 * @author PC
 */
public class DelegateMateria {
 
     public Materia login(int idmateria, String nombreDeLaMateria){
        Materia materia = new Materia();
        List<Materia> materias = ServiceLocator.getInstanceMateriaDAO().findAll();
        
        for(Materia us:materias){
            if(us.getIdmateria().equals(idmateria) && us.getNombreDeLaMateria().equalsIgnoreCase(nombreDeLaMateria)){
                materia = us;
            }
        }
        return materia;
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveMateria(Materia materia){
        ServiceLocator.getInstanceMateriaDAO().save(materia);
    } 
    
}
