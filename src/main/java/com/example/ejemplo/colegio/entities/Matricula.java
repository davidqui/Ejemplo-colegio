package com.example.ejemplo.colegio.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author David Antonio Quijano Ramos
 */
@Entity
@Table(name = "MATRICULA")
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANYO")
    private long anyo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private long valor;
    @JoinColumn(name = "CURSO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "ESTUDIANTE", referencedColumnName = "NUM_DOCUMENTO")
    @ManyToOne(optional = false)
    private Estudiante estudiante;
    @JoinColumn(name = "JORNADA", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Jornada jornada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private Collection<AsignacionAcademica> asignacionAcademicaCollection;

    public Matricula() {
    }

    public Matricula(BigDecimal id) {
        this.id = id;
    }

    public Matricula(BigDecimal id, Date fecha, long anyo, long valor) {
        this.id = id;
        this.fecha = fecha;
        this.anyo = anyo;
        this.valor = valor;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getAnyo() {
        return anyo;
    }

    public void setAnyo(long anyo) {
        this.anyo = anyo;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Collection<AsignacionAcademica> getAsignacionAcademicaCollection() {
        return asignacionAcademicaCollection;
    }

    public void setAsignacionAcademicaCollection(Collection<AsignacionAcademica> asignacionAcademicaCollection) {
        this.asignacionAcademicaCollection = asignacionAcademicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.ejemplo.colegio.entities.Matricula[ id=" + id + " ]";
    }
    
}
