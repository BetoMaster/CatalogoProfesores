package mx.cimadevs.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mx.cimadevs.entidad.Asignacion;
import mx.cimadevs.helper.AsignacionHelper;

@ManagedBean(name = "consultaprofesorbean")
@ViewScoped
public class BeanConsultaUI implements Serializable {
    
    private AsignacionHelper asigHelp;
    private List<Asignacion> listaAsignaciones;

    public BeanConsultaUI() {
        cargarAsignaciones();
    }

    public List<Asignacion> getListaAsignaciones() {
        return listaAsignaciones;
    }

    private void cargarAsignaciones() {
        asigHelp = new AsignacionHelper();
        listaAsignaciones = asigHelp.obtenerAsignacion();
    }
    
}
