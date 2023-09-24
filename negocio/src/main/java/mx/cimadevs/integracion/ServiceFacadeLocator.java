/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.cimadevs.integracion;

import mx.cimadevs.facade.FacadeAsignacion;
import mx.cimadevs.facade.FacadeMateria;
import mx.cimadevs.facade.FacadeProfesor;


/**
 *
 * @author PC
 */
public class ServiceFacadeLocator {
    
    private static FacadeAsignacion facadeAsignacion;
    private static FacadeMateria facadeMateria;
    private static FacadeProfesor facadeProfesor;
    
    public static FacadeAsignacion getInstanceFacadeAsignacion() {
        if (facadeAsignacion == null) {
            facadeAsignacion = new FacadeAsignacion();
            return facadeAsignacion;
        } else {
            return facadeAsignacion;
        }
    }
    
    public static FacadeMateria getInstanceFacadeMateria() {
        if (facadeMateria == null) {
            facadeMateria = new FacadeMateria();
            return facadeMateria;
        } else {
            return facadeMateria;
        }
    }
    
    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        } else {
            return facadeProfesor;
        }
    }

    
}
