/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.cimadevs.facade;
import java.util.List;
import mx.cimadevs.delegate.DelegateMateria;
import mx.cimadevs.entidad.Materia;
/**
 *
 * @author PC
 */
public class FacadeMateria {
    
    private final DelegateMateria delegateMateria;

    public FacadeMateria() {
        this.delegateMateria = new DelegateMateria();
    }
    
    public void guardarMateria(Materia materia){
        delegateMateria.saveMateria(materia);
    }
    
    public List<Materia> obtenerMateria(){
        return delegateMateria.obtenerMaterias();
    }
}
