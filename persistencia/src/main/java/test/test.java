package test;

import java.util.ArrayList;
import java.util.List;
import mx.cimadevs.DAO.UsuarioDAO;
import mx.cimadevs.entidad.Usuario;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        List<Usuario> listaUsuarios = new ArrayList();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        listaUsuarios = usuarioDao.findAll();
        
        for(Usuario us : listaUsuarios){
            System.out.println("Correo: " + us.getCorreo());
        }
    }
}
