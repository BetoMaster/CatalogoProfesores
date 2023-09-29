
package mx.cimadevs.helper;

import java.io.Serializable;
import java.util.List;
import mx.cimadevs.DAO.MateriaDAO;
import mx.cimadevs.entidad.Materia;
import mx.cimadevs.integracion.ServiceFacadeLocator;

public class MateriaHelper implements Serializable{
    
    public void guardarMateria(Materia materia){
        ServiceFacadeLocator.getInstanceFacadeMateria().guardarMateria(materia);
    }
    
    public List<Materia> obtenerMaterias(){
        MateriaDAO materiaDao = new MateriaDAO();
        return materiaDao.findAll();
    }
}
