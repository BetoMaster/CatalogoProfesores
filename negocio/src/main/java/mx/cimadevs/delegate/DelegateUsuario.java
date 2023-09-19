/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.cimadevs.delegate;
import java.util.List;
import mx.cimadevs.entidad.Usuario;
import mx.cimadevs.integracion.ServiceLocator;
/**
 *
 * @author PC
 */
public class DelegateUsuario {
    
     public Usuario login(String contrasena, String correo){
        Usuario usuario = new Usuario();
        List<Usuario> Usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();
        
        for(Usuario us:Usuarios){
            if(us.getContrasena().equalsIgnoreCase(contrasena) && us.getCorreo().equalsIgnoreCase(correo)){
               usuario = us;
            }
        }
        return usuario;
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUsuario(Usuario usuario){
        ServiceLocator.getInstanceUsuarioDAO().save(usuario);
    } 
    
}
