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

@Entity
@Table(catalog = "DocVG", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusu", query = "SELECT u FROM Usuario u WHERE u.idusu = :idusu")
    , @NamedQuery(name = "Usuario.findByNomusu", query = "SELECT u FROM Usuario u WHERE u.nomusu = :nomusu")
    , @NamedQuery(name = "Usuario.findByPwdusu", query = "SELECT u FROM Usuario u WHERE u.pwdusu = :pwdusu")
    , @NamedQuery(name = "Usuario.findByNivusu", query = "SELECT u FROM Usuario u WHERE u.nivusu = :nivusu")
    , @NamedQuery(name = "Usuario.findByEstusu", query = "SELECT u FROM Usuario u WHERE u.estusu = :estusu")
    , @NamedQuery(name = "Usuario.findByIdper", query = "SELECT u FROM Usuario u WHERE u.idper = :idper")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idusu;
    @Size(max = 6)
    @Column(length = 6)
    private String nomusu;
    @Size(max = 30)
    @Column(length = 30)
    private String pwdusu;
    private Character nivusu;
    private Character estusu;
    private Integer idper;

    public Usuario() {
    }

    public Usuario(Integer idusu) {
        this.idusu = idusu;
    }

    public Integer getIdusu() {
        return idusu;
    }

    public void setIdusu(Integer idusu) {
        this.idusu = idusu;
    }

    public String getNomusu() {
        return nomusu;
    }

    public void setNomusu(String nomusu) {
        this.nomusu = nomusu;
    }

    public String getPwdusu() {
        return pwdusu;
    }

    public void setPwdusu(String pwdusu) {
        this.pwdusu = pwdusu;
    }

    public Character getNivusu() {
        return nivusu;
    }

    public void setNivusu(Character nivusu) {
        this.nivusu = nivusu;
    }

    public Character getEstusu() {
        return estusu;
    }

    public void setEstusu(Character estusu) {
        this.estusu = estusu;
    }

    public Integer getIdper() {
        return idper;
    }

    public void setIdper(Integer idper) {
        this.idper = idper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusu != null ? idusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusu == null && other.idusu != null) || (this.idusu != null && !this.idusu.equals(other.idusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entidad.Usuario[ idusu=" + idusu + " ]";
    }
    
}
