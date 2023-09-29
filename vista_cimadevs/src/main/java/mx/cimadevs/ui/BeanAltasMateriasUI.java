package mx.cimadevs.ui;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.cimadevs.entidad.Materia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import mx.cimadevs.entidad.Asignacion;
import mx.cimadevs.entidad.Profesor;
import mx.cimadevs.helper.MateriaHelper;

@ManagedBean(name = "materiaAltasBean")
@ViewScoped
public class BeanAltasMateriasUI implements Serializable {
    
    private MateriaHelper matHelp;
    private String nombreDeLaMateria;
    private String horasClase;
    private String horasTaller;
    private String horasLaboratorio;
    Materia nuevaMateria = new Materia();
    private List<SelectItem> materiasSelectItems;
    private Integer materiaSeleccionada;

    @PostConstruct
    public void init() {
        // Cargar la lista de materias disponibles
        matHelp = new MateriaHelper();
        List<Materia> materias = matHelp.obtenerMaterias();
        materiasSelectItems = new ArrayList<>();

        for (Materia materia : materias) {
            materiasSelectItems.add(new SelectItem(materia.getIdmateria(), materia.getNombreDeLaMateria()));
        }
        
        
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

    public List<SelectItem> getMateriasSelectItems() {
        return materiasSelectItems;
    }

    public Integer getMateriaSeleccionada() {
        return materiaSeleccionada;
    }

    public void setMateriaSeleccionada(Integer materiaSeleccionada) {
        this.materiaSeleccionada = materiaSeleccionada;
    }

    // Método para guardar la materia en la base de datos.
    public void guardarMateria() {

        nuevaMateria.setNombreDeLaMateria(nombreDeLaMateria);
        nuevaMateria.setHorasClase(parseStringToDate(horasClase));
        nuevaMateria.setHorasTaller(parseStringToDate(horasTaller));
        nuevaMateria.setHorasLaboratorio(parseStringToDate(horasLaboratorio));
        
        matHelp = new MateriaHelper();
        matHelp.guardarMateria(nuevaMateria);
        limpiarCampos();
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