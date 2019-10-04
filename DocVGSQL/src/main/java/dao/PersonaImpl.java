package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Persona;

public class PersonaImpl extends Conexion implements ICRUD<Persona> {

    @Override
    public void registrar(Persona persona) throws Exception {
        try {
            this.Conexion(); //IDPER     NOMPER   APEPER CELPER  CORPER   DNIPER   TIPPER ESTPER DIRPER   CODUBI TITPER 
            String sql = "insert into PERSONA"
                    + "(NOMPER,APEPER,CELPER,CORPER,DNIPER,TIPPER,ESTPER,DIRPER,CODUBI,NACPER,TITPER)"
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, persona.getNOMPER());
            ps.setString(2, persona.getAPEPER());
            ps.setString(3, persona.getCELPER());
            ps.setString(4, persona.getCORPER());
            ps.setString(5, persona.getDNIPER());
            ps.setString(6, persona.getTIPPER());
            ps.setString(7, persona.getESTPER());
            ps.setString(8, persona.getDIRPER());
            ps.setString(9, persona.getCODUBI());
            ps.setDate(10, persona.getNACPER());
            ps.setString(11, persona.getTITPER());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en registrarAlumno " + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Persona persona) throws Exception {
        try {
            this.Conexion();//IDPER NOMPER APEPER CELPER  CORPER   DNIPER   TIPPER ESTPER DIRPER   CODUBI TITPER 
            String sql = "update PERSONA set NOMPER=?,APEPER=?,CELPER=?,CORPER=?,DNIPER=?,TIPPER=?,"
                    + "ESTPER=?,DIRPER=?,CODUBI=?, TITPER where IDPER=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, persona.getNOMPER());
            ps.setString(2, persona.getAPEPER());
            ps.setString(3, persona.getCELPER());
            ps.setString(4, persona.getCORPER());
            ps.setString(5, persona.getDNIPER());
            ps.setString(6, persona.getTIPPER());
            ps.setString(7, persona.getESTPER());
            ps.setString(8, persona.getDIRPER());
            ps.setString(9, persona.getCODUBI());
            ps.setString(10, persona.getTITPER());
            ps.setInt(11, persona.getIDPER());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Persona persona) throws Exception {
        try {
            this.Conexion();
            String sql = "update PERSONA set ESTPER = 'I' where IDPER=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, persona.getIDPER());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void activar(Persona persona) throws Exception {
        try {
            this.Conexion();
            String sql = "update PERSONA set ESTPER = 'A' where IDPER=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, persona.getIDPER());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Persona> listar() throws Exception {
        List<Persona> listado;
        Persona pers;
        try {
            this.Conexion();
            String sql = "select * from VW_PERSONA where ESTPER='A' AND TIPPER='ALUMNO'";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pers = new Persona();
                pers.setIDPER(rs.getInt("IDPER"));
                pers.setNOMPER(rs.getString("NOMPER"));
                pers.setAPEPER(rs.getString("APEPER"));
                pers.setCELPER(rs.getString("CELPER"));
                pers.setCORPER(rs.getString("CORPER"));
                pers.setDNIPER(rs.getString("DNIPER"));
                pers.setESTPER(rs.getString("ESTPER"));
                pers.setDIRPER(rs.getString("DIRPER"));
                pers.setTIPPER(rs.getString("TIPPER"));
                pers.setCODUBI(rs.getString("CODUBI"));
                listado.add(pers);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }

    public List<Persona> listarMonitor() throws Exception {
        List<Persona> listado;
        Persona pers;
        try {
            this.Conexion();
            String sql = "select * from VW_PERSONA where ESTPER='A' AND TIPPER='MONITOR'";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pers = new Persona();
                pers.setIDPER(rs.getInt("IDPER"));
                pers.setNOMPER(rs.getString("NOMPER"));
                pers.setAPEPER(rs.getString("APEPER"));
                pers.setCELPER(rs.getString("CELPER"));
                pers.setCORPER(rs.getString("CORPER"));
                pers.setDNIPER(rs.getString("DNIPER"));
                pers.setESTPER(rs.getString("ESTPER"));
                pers.setDIRPER(rs.getString("DIRPER"));
                pers.setTIPPER(rs.getString("TIPPER"));
                pers.setCODUBI(rs.getString("CODUBI"));
                listado.add(pers);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }

    public List<Persona> listarIna() throws Exception {
        List<Persona> listado;
        Persona pers;
        try {
            this.Conexion();
            String sql = "select * from VW_PERSONA where ESTPER='I'";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pers = new Persona();
                pers.setIDPER(rs.getInt("IDPER"));
                pers.setNOMPER(rs.getString("NOMPER"));
                pers.setAPEPER(rs.getString("APEPER"));
                pers.setCELPER(rs.getString("CELPER"));
                pers.setCORPER(rs.getString("CORPER"));
                pers.setDNIPER(rs.getString("DNIPER"));
                pers.setESTPER(rs.getString("ESTPER"));
                pers.setDIRPER(rs.getString("DIRPER"));
                pers.setTIPPER(rs.getString("TITPER"));
                pers.setCODUBI(rs.getString("CODUBI"));
                listado.add(pers);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }

    public Persona validarExistenciaPersona(String DNIPER) throws Exception {
        try {
            this.Conexion();
            String sql = "Select IDPER, DNIPER from VW_PERSONA where DNIPER = '" + DNIPER + "'";
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            Persona persona = new Persona();
            while (rs.next()) {
                persona.setIDPER(rs.getInt("IDPER"));
                persona.setDNIPER(rs.getString("DNIPER"));
                break;
            }
            return persona;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public String obtenerCodigoUbigeo(String Ubigeo) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT CODUBI FROM UBIGEO WHERE CONCAT(DPTUBI,', ',PROUBI,', ',DISUBI) LIKE ?;";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Ubigeo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODUBI");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<String> autocompleteUbigeo(String Consulta) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "select top 10 CONCAT(DPTUBI,', ',PROUBI,', ',DISUBI) AS UBIGEO from UBIGEO WHERE DISUBI LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                Lista.add(rs.getString("UBIGEO"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }

    }

}
