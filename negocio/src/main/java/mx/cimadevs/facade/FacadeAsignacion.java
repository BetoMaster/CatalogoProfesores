/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.cimadevs.facade;
import mx.cimadevs.delegate.DelegateAsignacion;
import mx.cimadevs.entidad.Asignacion;
/**
 *
 * @author PC
 */
public class FacadeAsignacion {
    
    private final DelegateAsignacion delegateAsignacion;

    public FacadeAsignacion() {
        this.delegateAsignacion = new DelegateAsignacion();
    }
    
    public void guardarAsignacion(Asignacion asignacion){
        delegateAsignacion.saveAsignacion(asignacion);
    }
    
}
