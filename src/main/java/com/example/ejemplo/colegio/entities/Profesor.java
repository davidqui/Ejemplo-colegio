package com.example.ejemplo.colegio.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David Antonio Quijano Ramos
 */
@Entity
@Table(name = "PROFESOR")
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NUM_DOCUMENTO")
    private String numDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITULO_ACADEMICO")
    private String tituloAcademico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    private Collection<Curso> cursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    private Collection<AsignacionAcademica> asignacionAcademicaCollection;
    @JoinColumn(name = "ESTADO_PROFESOR", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private EstadoProfesor estadoProfesor;
    @JoinColumn(name = "TIPO_DOCUMENTO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;

    public Profesor() {
    }

    public Profesor(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Profesor(String numDocumento, String nombre, String apellidos, String tituloAcademico) {
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tituloAcademico = tituloAcademico;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    public void setTituloAcademico(String tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
    }

    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    public Collection<AsignacionAcademica> getAsignacionAcademicaCollection() {
        return asignacionAcademicaCollection;
    }

    public void setAsignacionAcademicaCollection(Collection<AsignacionAcademica> asignacionAcademicaCollection) {
        this.asignacionAcademicaCollection = asignacionAcademicaCollection;
    }

    public EstadoProfesor getEstadoProfesor() {
        return estadoProfesor;
    }

    public void setEstadoProfesor(EstadoProfesor estadoProfesor) {
        this.estadoProfesor = estadoProfesor;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numDocumento != null ? numDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.numDocumento == null && other.numDocumento != null) || (this.numDocumento != null && !this.numDocumento.equals(other.numDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.ejemplo.colegio.entities.Profesor[ numDocumento=" + numDocumento + " ]";
    }
    
}
