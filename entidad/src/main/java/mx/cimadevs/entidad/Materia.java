/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.cimadevs.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NEOLAPS
 */
@Entity
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
    , @NamedQuery(name = "Materia.findByIdmateria", query = "SELECT m FROM Materia m WHERE m.idmateria = :idmateria")
    , @NamedQuery(name = "Materia.findByNombreDeLaMateria", query = "SELECT m FROM Materia m WHERE m.nombreDeLaMateria = :nombreDeLaMateria")
    , @NamedQuery(name = "Materia.findByHorasClase", query = "SELECT m FROM Materia m WHERE m.horasClase = :horasClase")
    , @NamedQuery(name = "Materia.findByHorasTaller", query = "SELECT m FROM Materia m WHERE m.horasTaller = :horasTaller")
    , @NamedQuery(name = "Materia.findByHorasLaboratorio", query = "SELECT m FROM Materia m WHERE m.horasLaboratorio = :horasLaboratorio")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmateria")
    private Integer idmateria;
    @Basic(optional = false)
    @Column(name = "nombre_de_la_materia")
    private String nombreDeLaMateria;
    @Basic(optional = false)
    @Column(name = "horas_clase")
    @Temporal(TemporalType.TIME)
    private Date horasClase;
    @Basic(optional = false)
    @Column(name = "horas_taller")
    @Temporal(TemporalType.TIME)
    private Date horasTaller;
    @Basic(optional = false)
    @Column(name = "horas_laboratorio")
    @Temporal(TemporalType.TIME)
    private Date horasLaboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmateria")
    private List<Asignacion> asignacionList;

    public Materia() {
    }

    public Materia(Integer idmateria) {
        this.idmateria = idmateria;
    }

    public Materia(Integer idmateria, String nombreDeLaMateria, Date horasClase, Date horasTaller, Date horasLaboratorio) {
        this.idmateria = idmateria;
        this.nombreDeLaMateria = nombreDeLaMateria;
        this.horasClase = horasClase;
        this.horasTaller = horasTaller;
        this.horasLaboratorio = horasLaboratorio;
    }

    public Integer getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Integer idmateria) {
        this.idmateria = idmateria;
    }

    public String getNombreDeLaMateria() {
        return nombreDeLaMateria;
    }

    public void setNombreDeLaMateria(String nombreDeLaMateria) {
        this.nombreDeLaMateria = nombreDeLaMateria;
    }

    public Date getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Date horasClase) {
        this.horasClase = horasClase;
    }

    public Date getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(Date horasTaller) {
        this.horasTaller = horasTaller;
    }

    public Date getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Date horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    @XmlTransient
    public List<Asignacion> getAsignacionList() {
        return asignacionList;
    }

    public void setAsignacionList(List<Asignacion> asignacionList) {
        this.asignacionList = asignacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmateria != null ? idmateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idmateria == null && other.idmateria != null) || (this.idmateria != null && !this.idmateria.equals(other.idmateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.cimadevs.entidad.Materia[ idmateria=" + idmateria + " ]";
    }
    
}
