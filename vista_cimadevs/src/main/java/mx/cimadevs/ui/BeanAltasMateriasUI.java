package mx.cimadevs.ui;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.cimadevs.DAO.MateriaDAO;

import mx.cimadevs.entidad.Materia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import mx.cimadevs.entidad.Asignacion;
import mx.cimadevs.entidad.Profesor;
import mx.cimadevs.helper.MateriaHelper;

@ManagedBean(name = "materiaAltasBean")
@ViewScoped
//Esto significa que la instancia del bean estará disponible para la vista y mantendrá su estado durante la duración de la vista.
public class BeanAltasMateriasUI implements Serializable {
    
    private MateriaHelper matHelp;
    private String nombreDeLaMateria;
    private String horasClase;
    private String horasTaller;
    private String horasLaboratorio;
    Materia nuevaMateria = new Materia();
    private List<SelectItem> materiasSelectItems;
    private Integer materiaSeleccionada;

    // Método de inicialización ejecutado después de la creación del bean, sirve para cargar la lista de materias para las asignaciones
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

    // Getters y setters para las propiedades del bean
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
    // Fin de los Getters y setters

    // Validación de campos obligatorios, Si alguno de los campos obligatorios está vacío, se agrega un mensaje de error a la vista.
    private boolean validarCampos() {
        boolean camposValidos = true;

        nuevaMateria.setNombreDeLaMateria(nombreDeLaMateria);
        nuevaMateria.setHorasClase(parseStringToDate(horasClase));
        nuevaMateria.setHorasTaller(parseStringToDate(horasTaller));
        nuevaMateria.setHorasLaboratorio(parseStringToDate(horasLaboratorio));
        
        matHelp = new MateriaHelper();
        matHelp.guardarMateria(nuevaMateria);
        limpiarCampos();
    }

    /* Método para guardar la materia en la base de datos. ste método se llama cuando se presiona el botón "Guardar" en la vista. 
    Primero, llama a validarCampos() para asegurarse de que los campos estén llenos. Si los campos son válidos, crea una nueva 
    instancia de Materia con los datos ingresados y la guarda en la base de datos a través de materiaDao. Luego, muestra un mensaje de éxito */
    public void guardarMateria() {
        if (validarCampos()) {
            nuevaMateria.setNombreDeLaMateria(nombreDeLaMateria);
            nuevaMateria.setHorasClase(parseStringToDate(horasClase));
            nuevaMateria.setHorasTaller(parseStringToDate(horasTaller));
            nuevaMateria.setHorasLaboratorio(parseStringToDate(horasLaboratorio));

            materiaDao.save(nuevaMateria);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
            limpiarCampos();

        }
    }

    // Método para limpiar los campos del formulario
    public void limpiarCampos() {

        nombreDeLaMateria = "";
        horasClase = "";
        horasTaller = "";
        horasLaboratorio = "";
    }

    /* Método para convertir una cadena de texto en un objeto Date,  
    Este método convierte una cadena de texto en un objeto Date. Se utiliza para convertir las horas ingresadas en formato HH:mm a objetos Date.*/
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
