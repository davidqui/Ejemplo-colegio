package com.example.ejemplo.colegio.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author David Antonio Quijano Ramos
 */
@Entity
@Table(name = "ASIGNACION_ACADEMICA")
@NamedQueries({
    @NamedQuery(name = "AsignacionAcademica.findAll", query = "SELECT a FROM AsignacionAcademica a")})
public class AsignacionAcademica implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOTA_1")
    private BigDecimal nota1;
    @Column(name = "NOTA_2")
    private BigDecimal nota2;
    @Column(name = "NOTA_3")
    private BigDecimal nota3;
    @Column(name = "NOTA_4")
    private BigDecimal nota4;
    @Column(name = "NOTA_FINAL")
    private BigDecimal notaFinal;
    @JoinColumn(name = "MATERIA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Materia materia;
    @JoinColumn(name = "MATRICULA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Matricula matricula;
    @JoinColumn(name = "PROFESOR", referencedColumnName = "NUM_DOCUMENTO")
    @ManyToOne(optional = false)
    private Profesor profesor;

    public AsignacionAcademica() {
    }

    public AsignacionAcademica(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    public BigDecimal getNota4() {
        return nota4;
    }

    public void setNota4(BigDecimal nota4) {
        this.nota4 = nota4;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
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
        if (!(object instanceof AsignacionAcademica)) {
            return false;
        }
        AsignacionAcademica other = (AsignacionAcademica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.ejemplo.colegio.entities.AsignacionAcademica[ id=" + id + " ]";
    }
    
}
