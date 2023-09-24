package mx.cimadevs.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.cimadevs.DAO.ProfesorDAO;
import mx.cimadevs.entidad.Profesor;

@ManagedBean(name = "profesorAltasBean")
@ViewScoped
public class BeanAltasUI {

    private String nombre;
    private String apellido;
    private String rfc;
    Profesor nuevoProfesor = new Profesor();
    ProfesorDAO profeDao = new ProfesorDAO();

    
    public void init() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    // Método para guardar el profesor en la base de datos.
    public void guardarProfesor() {

        nuevoProfesor.setNombre(nombre);
        nuevoProfesor.setApellido(apellido);
        nuevoProfesor.setRfc(rfc);
        profeDao.save(nuevoProfesor);
        limpiarCampos();
        

    }

    public void limpiarCampos() {
        nombre = "";
        apellido = "";
        rfc = "";
    }

}
