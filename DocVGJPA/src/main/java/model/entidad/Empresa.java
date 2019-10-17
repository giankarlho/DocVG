/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Giancarlo
 */
@Entity
@Table(catalog = "DocVG", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByIdemp", query = "SELECT e FROM Empresa e WHERE e.idemp = :idemp")
    , @NamedQuery(name = "Empresa.findByRazemp", query = "SELECT e FROM Empresa e WHERE e.razemp = :razemp")
    , @NamedQuery(name = "Empresa.findByComemp", query = "SELECT e FROM Empresa e WHERE e.comemp = :comemp")
    , @NamedQuery(name = "Empresa.findByRucemp", query = "SELECT e FROM Empresa e WHERE e.rucemp = :rucemp")
    , @NamedQuery(name = "Empresa.findByEstemp", query = "SELECT e FROM Empresa e WHERE e.estemp = :estemp")
    , @NamedQuery(name = "Empresa.findByDiremp", query = "SELECT e FROM Empresa e WHERE e.diremp = :diremp")
    , @NamedQuery(name = "Empresa.findByCodubi", query = "SELECT e FROM Empresa e WHERE e.codubi = :codubi")
    , @NamedQuery(name = "Empresa.findByTelemp", query = "SELECT e FROM Empresa e WHERE e.telemp = :telemp")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idemp;
    @Size(max = 60)
    @Column(length = 60)
    private String razemp;
    @Size(max = 60)
    @Column(length = 60)
    private String comemp;
    @Size(max = 11)
    @Column(length = 11)
    private String rucemp;
    private Character estemp;
    @Size(max = 60)
    @Column(length = 60)
    private String diremp;
    @Size(max = 6)
    @Column(length = 6)
    private String codubi;
    @Size(max = 20)
    @Column(length = 20)
    private String telemp;

    public Empresa() {
    }

    public Empresa(Integer idemp) {
        this.idemp = idemp;
    }

    public Integer getIdemp() {
        return idemp;
    }

    public void setIdemp(Integer idemp) {
        this.idemp = idemp;
    }

    public String getRazemp() {
        return razemp;
    }

    public void setRazemp(String razemp) {
        this.razemp = razemp;
    }

    public String getComemp() {
        return comemp;
    }

    public void setComemp(String comemp) {
        this.comemp = comemp;
    }

    public String getRucemp() {
        return rucemp;
    }

    public void setRucemp(String rucemp) {
        this.rucemp = rucemp;
    }

    public Character getEstemp() {
        return estemp;
    }

    public void setEstemp(Character estemp) {
        this.estemp = estemp;
    }

    public String getDiremp() {
        return diremp;
    }

    public void setDiremp(String diremp) {
        this.diremp = diremp;
    }

    public String getCodubi() {
        return codubi;
    }

    public void setCodubi(String codubi) {
        this.codubi = codubi;
    }

    public String getTelemp() {
        return telemp;
    }

    public void setTelemp(String telemp) {
        this.telemp = telemp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemp != null ? idemp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idemp == null && other.idemp != null) || (this.idemp != null && !this.idemp.equals(other.idemp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entidad.Empresa[ idemp=" + idemp + " ]";
    }
    
}
