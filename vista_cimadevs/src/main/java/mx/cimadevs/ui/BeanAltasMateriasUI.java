package mx.cimadevs.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.cimadevs.DAO.MateriaDAO;
import mx.cimadevs.entidad.Materia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name = "materiaAltasBean")
@ViewScoped
public class BeanAltasMateriasUI {

    private String nombreDeLaMateria;
    private String horasClase;
    private String horasTaller;
    private String horasLaboratorio;
    Materia nuevaMateria = new Materia();
    MateriaDAO materiaDao = new MateriaDAO();

    public void init() {

    }

    public String getNombreDeLaMateria() {
        return nombreDeLaMateria;
    }

    public void setNombreDeLaMateria(String nombreDeLaMateria) {
        this.nombreDeLaMateria = nombreDeLaMateria;
    }

    public String getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(String horasClase) {
        this.horasClase = horasClase;
    }

    public String getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(String horasTaller) {
        this.horasTaller = horasTaller;
    }

    public String getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(String horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    // Método para guardar la materia en la base de datos.
    public void guardarMateria() {
       
        nuevaMateria.setNombreDeLaMateria(nombreDeLaMateria);
        nuevaMateria.setHorasClase(parseStringToDate(horasClase));
        nuevaMateria.setHorasTaller(parseStringToDate(horasTaller));
        nuevaMateria.setHorasLaboratorio(parseStringToDate(horasLaboratorio));
        limpiarCampos();
        materiaDao.save(nuevaMateria);

    }

    public void limpiarCampos() {
        
        nombreDeLaMateria = "";
        horasClase = "";
        horasTaller = "";
        horasLaboratorio = "";
    }

    // Método para convertir una cadena de texto en un objeto Date
    private Date parseStringToDate(String texto) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // Formato de hora
            return sdf.parse(texto);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
