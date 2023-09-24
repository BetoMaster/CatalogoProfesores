package mx.cimadevs.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mx.cimadevs.DAO.AsignacionDAO;
import mx.cimadevs.entidad.Asignacion;

@ManagedBean(name = "consultaprofesorbean")
@ViewScoped
public class BeanConsultaUI implements Serializable {

    private List<Asignacion> listaAsignaciones;

    public BeanConsultaUI() {
        cargarAsignaciones();
    }

    public List<Asignacion> getListaAsignaciones() {
        return listaAsignaciones;
    }

    private void cargarAsignaciones() {
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        listaAsignaciones = asignacionDAO.findAll();
    }
    
}
