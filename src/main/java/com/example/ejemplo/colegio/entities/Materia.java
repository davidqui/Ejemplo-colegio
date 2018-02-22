package com.example.ejemplo.colegio.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "MATERIA")
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTENSIDAD_HORARIA")
    private long intensidadHoraria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private Collection<AsignacionAcademica> asignacionAcademicaCollection;

    public Materia() {
    }

    public Materia(BigDecimal id) {
        this.id = id;
    }

    public Materia(BigDecimal id, String nombre, long intensidadHoraria) {
        this.id = id;
        this.nombre = nombre;
        this.intensidadHoraria = intensidadHoraria;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIntensidadHoraria() {
        return intensidadHoraria;
    }

    public void setIntensidadHoraria(long intensidadHoraria) {
        this.intensidadHoraria = intensidadHoraria;
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
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.ejemplo.colegio.entities.Materia[ id=" + id + " ]";
    }
    
}
