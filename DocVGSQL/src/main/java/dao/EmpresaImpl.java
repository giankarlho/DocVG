package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;
import model.Persona;

public class EmpresaImpl extends Conexion implements ICRUD<Empresa> {

    @Override
    public void registrar(Empresa empresa) throws Exception {
        try {
            this.Conexion();
            String sql = "insert into EMPRESA (RAZEMP,COMEMP,RUCEMP,ESTEMP,DIREMP,CODUBI,TELEMP)"
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, empresa.getRAZEMP());
            ps.setString(2, empresa.getCOMEMP());
            ps.setString(3, empresa.getRUCEMP());
            ps.setString(4, "A");
            ps.setString(5, empresa.getDIREMP());
            ps.setString(6, empresa.getCODUBI());
            ps.setString(7, empresa.getTELEMP());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en registrarAlumno " + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

     public void registrarDet(Empresa empresa, Persona persona) throws Exception {
        try {
            Date fecha = Date.valueOf("10/09/2019");
            this.Conexion();
            String sql = "insert into detEmpresa (IDEMP,IDPER,CARPER,ESTASI,FECASI)"
                    + "values (?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, empresa.getIDEMP());
            ps.setInt(2, persona.getIDPER());
            ps.setString(3, "Administrador");
            ps.setString(4, "A");
            ps.setDate(5,fecha);
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
    public void modificar(Empresa empresa) throws Exception {
        try {
            this.Conexion();
            String sql = "update EMPRESA set RAZEMP=?,DIREMP=?,RUCEMP=?,"
                    + "ESTEMP=?,CODUBI=?,CODRES=? where IDEMP=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, empresa.getRAZEMP());
            ps.setString(2, empresa.getDIREMP());
            ps.setString(3, empresa.getRUCEMP());
            ps.setString(4, empresa.getESTEMP());
            ps.setString(5, empresa.getCODUBI());
            ps.setInt(7, empresa.getIDEMP());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en modificarEmp " + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Empresa empresa) throws Exception {
        try {
            this.Conexion();
            String sql = "update EMPRESA set ESTEMP='I' where IDEMP=?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setInt(1, empresa.getIDEMP());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminarEmpresa " + e.getMessage());
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Empresa> listar() throws Exception {
        List<Empresa> listado;
        Empresa empr;
        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_EMPRESA where ESTEMP='A'";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                empr = new Empresa();
                empr.setIDEMP(rs.getInt("IDEMP"));
                empr.setRAZEMP(rs.getString("RAZEMP"));
                empr.setDIREMP(rs.getString("DIREMP"));
                empr.setRUCEMP(rs.getString("RUCEMP"));
                empr.setESTEMP(rs.getString("ESTEMP"));
                empr.setCODUBI(rs.getString("CODUBI"));
                listado.add(empr);
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

    public String getCodUbigeo(String Empresa) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT CODUBI FROM UBIGEO WHERE CONCAT(DPTUBI,', ',PROUBI,', ',DISUBI) LIKE ?;";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Empresa);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODUBI");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<String> listarUbigeo(String Consulta) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> lista;
        try {
            String sql = "select top 10 CONCAT(DISUBI ,', ',PROUBI,', ',DPTUBI) AS UBIGEO from UBIGEO WHERE DISUBI LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("UBIGEO"));
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<String> listarResp() throws Exception {
        List<String> resp = new ArrayList<>();
        try {
            this.Conexion();
            String sql = "SELECT TOP 10 (NOMPER + ' ' + APEPER) AS NOMBRE  FROM Persona where TIPPER='A'";            
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                resp.add(rs.getString("NOMBRE"));
            }
            rs.close();
            st.close();
            return resp;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
     public Integer getCodResp(String responsable) throws SQLException  {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT IDPER FROM persona WHERE (NOMPER + ' ' + APEPER) = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, responsable);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDPER");                
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<String> listarPrueba() throws Exception {
        List<String> cities = new ArrayList<>();
        cities.add("Miami");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        cities.add("Brasilia");
        cities.add("Amsterdam");
        cities.add("Peru");
        cities.add("San vicente");
        return cities;
    }

//    public String obtenerCodigoResponsable(String Responsable) throws SQLException, Exception {
//        this.Conexion();
//        ResultSet rs;
//        try {
//            String sql = "SELECT CODRES FROM RESPONSABLE WHERE CONCAT(NOMRES,', ',APERES) LIKE ?;";
//            PreparedStatement ps = this.getCn().prepareCall(sql);
//            ps.setString(1, Responsable);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                return rs.getString("CODRES");
//            }
//            return null;
//        } catch (SQLException e) {
//            throw e;
//        }
//    }
//    public List<String> autocompleteResponsable(String Consulta) throws SQLException {
//        this.Conexion();
//        ResultSet rs;
//        List<String> Lista;
//        try {
//            String sql = "select top 10 CONCAT(NOMRES,', ',APERES) AS RESPONSABLE from RESPONSABLE WHERE NOMRES LIKE ?";
//            PreparedStatement ps = this.getCn().prepareCall(sql);
//            ps.setString(1, "%" + Consulta + "%");
//            Lista = new ArrayList<>();
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Lista.add(rs.getString("RESPONSABLE"));
//            }
//            return Lista;
//        } catch (SQLException e) {
//            throw e;
//        }
//
//    }
}
