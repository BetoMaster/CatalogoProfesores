/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.cimadevs.entidad.Usuario;
import mx.cimadevs.integracion.ServiceFacadeLocator;

/**
 *
 * @author PC
 */
public class test {
    
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        
        usuario = ServiceFacadeLocator.getInstanceFacadeUsuario().login("contra123","francisco.reyes.parra@uabc.edu.mx");
        
        if(usuario.getIdusuario() != null){
            System.out.println("Login exitoso con el correo: " + usuario.getCorreo());
        }else{
            System.out.println("No se encontro registro");
        }
    }
    
}
