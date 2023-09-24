package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Agrega la importación de la clase Scanner
import mx.cimadevs.DAO.ProfesorDAO;
import mx.cimadevs.entidad.Profesor;


/**
 *
 * @author lukki
 */
public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea una instancia de Scanner

        // Solicitar datos del profesor al usuario
        System.out.println("Ingrese el nombre del profesor:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del profesor:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese el RFC del profesor:");
        String rfc = scanner.nextLine();

        // Crear un nuevo objeto Profesor con los datos proporcionados
        Profesor nuevoProfesor = new Profesor();
        nuevoProfesor.setNombre(nombre);
        nuevoProfesor.setApellido(apellido);
        nuevoProfesor.setRfc(rfc);

        // Insertar el nuevo profesor en la base de datos
        System.out.println("Profesor insertado exitosamente.");

        // Cerrar el Scanner al final del programa
        scanner.close();

        List<Profesor> listaProfes = new ArrayList();
        ProfesorDAO profeDao = new ProfesorDAO();
        profeDao.save(nuevoProfesor);

        listaProfes = profeDao.findAll();

        for (Profesor pf : listaProfes) {
            System.out.println("Nombre: " + pf.getNombre() + " " + pf.getApellido() + "\n" + "Rfc:" + pf.getRfc());
        }

    }
}
