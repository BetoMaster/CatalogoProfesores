package mx.cimadevs.integracion;

import mx.cimadevs.DAO.ProfesorDAO;
import mx.cimadevs.DAO.AsignacionDAO;
import mx.cimadevs.DAO.MateriaDAO;

public class ServiceLocator {
    
    private static ProfesorDAO profesorDAO;
    private static AsignacionDAO asignacionDAO;
    private static MateriaDAO materiaDAO;
    
    /**
     * Crea la instancia para ProfesorDAO si esta no existe
     */
    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    
  
    
    /**
     * Crea la instancia de AsignacionDAO si esta no existe
     */
    public static AsignacionDAO getInstanceAsignacionDAO(){
        if(asignacionDAO == null){
            asignacionDAO = new AsignacionDAO();
            return asignacionDAO;
        } else{
            return asignacionDAO;
        }
    }
    
    /**
     * Crea la instancia de MateriaDAO si esta no existe
     */
    public static MateriaDAO getInstanceMateriaDAO(){
        if(materiaDAO == null){
            materiaDAO = new MateriaDAO();
            return materiaDAO;
        } else{
            return materiaDAO;
        }
    }
   
}
