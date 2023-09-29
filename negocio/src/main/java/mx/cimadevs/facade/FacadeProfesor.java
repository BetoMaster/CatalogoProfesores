/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.cimadevs.facade;
import java.util.List;
import mx.cimadevs.delegate.DelegateProfesor;
import mx.cimadevs.entidad.Profesor;
/**
 *
 * @author PC
 */
public class FacadeProfesor {
    
    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }
    
    public void guardarProfesor(Profesor profesor){
        delegateProfesor.saveProfesor(profesor);
    }
    
    public void borrarProfesor(Profesor profesor){
        delegateProfesor.deleteProfesor(profesor);
    }
    
    public List<Profesor> obtenerProfesores() {
        return delegateProfesor.obtenerProfesores();
    }
    
    public void actualizarProfesor(Profesor profesor){
        delegateProfesor.updateProfesor(profesor);
    }
}
