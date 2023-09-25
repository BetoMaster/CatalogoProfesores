/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.cimadevs.facade;
import mx.cimadevs.delegate.DelegateUsuario;
import mx.cimadevs.entidad.Usuario;
/**
 *
 * @author PC
 */
public class FacadeUsuario {
    
    private final DelegateUsuario delegateUsuario;
    
    public FacadeUsuario() {
    this.delegateUsuario = new DelegateUsuario();
    }
    
     /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param password 
     * @param correo
     * @return Regresa usuario si el correo y contrasena con correctos
     */
    public Usuario login(String contrasena, String correo){
        return delegateUsuario.login(contrasena, correo);
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUsuario(Usuario usuario){
        delegateUsuario.saveUsuario(usuario);
    }
    
}
