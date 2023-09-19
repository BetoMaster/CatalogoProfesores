package test;

import java.util.ArrayList;
import java.util.List;
import mx.cimadevs.DAO.ProfesorDAO;
import mx.cimadevs.DAO.UsuarioDAO;
import mx.cimadevs.entidad.Profesor;
import mx.cimadevs.entidad.Usuario;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        List<Usuario> listaUsuarios = new ArrayList();
        List<Profesor> listaProfesores = new ArrayList();
        ProfesorDAO profesorDao = new ProfesorDAO();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        listaProfesores = profesorDao.findAll();
        listaUsuarios = usuarioDao.findAll();
        
        for(Profesor pr : listaProfesores){
            System.out.println("Profesor:"+pr.getNombre()+ " " + pr.getApellido());
        }
        
        for(Usuario us : listaUsuarios){
            System.out.println("Correo: " + us.getCorreo());
        }
    }
}
