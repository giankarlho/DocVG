package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DetEmpresa;
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
            System.out.println("Error en registrarEmpresa " + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void registrarDet(Empresa empresa, Persona persona) throws Exception {
        try {
            Date fecha = new Date();
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//            System.out.println("Fecha: " + dateFormat.format(fecha));
            this.Conexion();
            String sql = "insert into detEmpresa (IDEMP,IDPER,CARPER,ESTASI,FECASI)"
                    + "values (?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, empresa.getIDEMP());
            ps.setInt(2, persona.getIDPER());
            ps.setString(3, "Administrador");
            ps.setString(4, "A");
            ps.setString(5, dateFormat.format(fecha));
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
        Date fecha = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        List<Empresa> listado;
        Empresa empr;
        try {
            this.Conexion();
            String sql = "SELECT * FROM EMPRESA where ESTEMP='A' order by IDEMP desc";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                empr = new Empresa();
                empr.setIDEMP(rs.getInt("IDEMP"));
                empr.setRAZEMP(rs.getString("RAZEMP"));
                empr.setCOMEMP(rs.getString("COMEMP"));
                empr.setDIREMP(rs.getString("DIREMP"));
                empr.setRUCEMP(rs.getString("RUCEMP"));
                empr.setESTEMP(rs.getString("ESTEMP"));
                empr.setTELEMP(rs.getString("TELEMP"));
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

    public List<DetEmpresa> listarRespxEmp(Empresa empresa) throws Exception {
        List<DetEmpresa> listado;
        DetEmpresa detEmp;
        try {
            this.Conexion();
            String sql = "SELECT * FROM detEmpresa where IDEMP=?";
            listado = new ArrayList();
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setInt(1, empresa.getIDEMP());
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                detEmp = new DetEmpresa();
                detEmp.setIDEMP(rs.getInt("IDEMP"));
                detEmp.setIDPER(rs.getInt("IDPER"));
                detEmp.setESTASI('A');
                detEmp.setFECASI(rs.getDate("FECASI"));
                listado.add(detEmp);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }

    public String getCodUbigeo(String DistProvDpto) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT CODUBI FROM UBIGEO WHERE CONCAT(DPTUBI,', ',PROUBI,', ',DISUBI) LIKE ?;";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, DistProvDpto);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODUBI");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public Integer getCodEmp() throws SQLException {
        this.Conexion();
        int codigo = 0;
        try {
            String sql = "select max(IDEMP) as CODEND from empresa";
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                codigo = Integer.parseInt(rs.getString("CODEND"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        }
        return codigo;
    }

    public Integer getCodResp(String responsable) throws SQLException {
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

    public List<String> listarUbigeo(String consulta) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> lista;
        try {
            String sql = "select top 10 CONCAT(DPTUBI,', ',PROUBI,', ',DISUBI) AS ubigeo from UBIGEO WHERE DISUBI LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + consulta + "%");
            lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("ubigeo"));
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
