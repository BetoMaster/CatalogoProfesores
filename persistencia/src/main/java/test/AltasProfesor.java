/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import mx.cimadevs.DAO.ProfesorDAO;
import mx.cimadevs.entidad.Profesor;

/**
 *
 * @author NEOLAPS
 */
public class AltasProfesor {

    public static void main(String[] args) {

        Profesor nuevoProfesor = new Profesor();
        ProfesorDAO profeDao = new ProfesorDAO();

        String nombre = null;
        String apellido = null;
        String rfc = null;

        nuevoProfesor.setNombre(nombre);

        nuevoProfesor.setApellido(apellido);

        nuevoProfesor.setRfc(rfc);
        profeDao.save(nuevoProfesor);

    }
}
