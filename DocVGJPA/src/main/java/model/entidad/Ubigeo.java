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
    @NamedQuery(name = "Ubigeo.findAll", query = "SELECT u FROM Ubigeo u")
    , @NamedQuery(name = "Ubigeo.findByCodubi", query = "SELECT u FROM Ubigeo u WHERE u.codubi = :codubi")
    , @NamedQuery(name = "Ubigeo.findByDptubi", query = "SELECT u FROM Ubigeo u WHERE u.dptubi = :dptubi")
    , @NamedQuery(name = "Ubigeo.findByProubi", query = "SELECT u FROM Ubigeo u WHERE u.proubi = :proubi")
    , @NamedQuery(name = "Ubigeo.findByDisubi", query = "SELECT u FROM Ubigeo u WHERE u.disubi = :disubi")})
public class Ubigeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(nullable = false, length = 6)
    private String codubi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String dptubi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String proubi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String disubi;

    public Ubigeo() {
    }

    public Ubigeo(String codubi) {
        this.codubi = codubi;
    }

    public Ubigeo(String codubi, String dptubi, String proubi, String disubi) {
        this.codubi = codubi;
        this.dptubi = dptubi;
        this.proubi = proubi;
        this.disubi = disubi;
    }

    public String getCodubi() {
        return codubi;
    }

    public void setCodubi(String codubi) {
        this.codubi = codubi;
    }

    public String getDptubi() {
        return dptubi;
    }

    public void setDptubi(String dptubi) {
        this.dptubi = dptubi;
    }

    public String getProubi() {
        return proubi;
    }

    public void setProubi(String proubi) {
        this.proubi = proubi;
    }

    public String getDisubi() {
        return disubi;
    }

    public void setDisubi(String disubi) {
        this.disubi = disubi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codubi != null ? codubi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubigeo)) {
            return false;
        }
        Ubigeo other = (Ubigeo) object;
        if ((this.codubi == null && other.codubi != null) || (this.codubi != null && !this.codubi.equals(other.codubi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entidad.Ubigeo[ codubi=" + codubi + " ]";
    }
    
}
