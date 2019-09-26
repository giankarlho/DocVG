package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Aula;

public class AulaImpl extends Conexion implements ICRUD<Aula> {

    @Override
    public void registrar(Aula aula) throws Exception {
        try {
            this.Conexion();
            String sql = "insert into AULA"
                    + "(SECAUL,SEMAUL,CODCAR,PROCAR)"
                    + "values(?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "U");
            ps.setString(2, aula.getSEMAUL());
            ps.setString(3, aula.getCODCAR());
            ps.setString(4, aula.getPROCAR());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Aula aula) throws Exception {
        try {
            this.Conexion();
            String sql = "update AULA set SECAUL=?,SEMAUL=?,CODCAR=?,PROCAR=? where CODAUL=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, aula.getSECAUL());
            ps.setString(2, aula.getSEMAUL());
            ps.setString(3, aula.getCODCAR());
            ps.setString(4, aula.getPROCAR());
            ps.setInt(5, aula.getCODAUL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Aula aula) throws Exception {
        try {
            this.Conexion();
            String sql = "delete from AULA where CODAUL=?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setInt(1, aula.getCODAUL());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Aula> listar() throws Exception {
        List<Aula> listado;
        Aula aul;
        try {
            this.Conexion();
            String sql = "select * from VW_AULA";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                aul = new Aula();
                aul.setCODAUL(rs.getInt("CODAUL"));
                aul.setSECAUL(rs.getString("SECAUL"));
                aul.setSEMAUL(rs.getString("SEMAUL"));
                aul.setCODCAR(rs.getString("CODCAR"));
                aul.setPROCAR(rs.getString("PROCAR"));
                listado.add(aul);
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

    public String obtenerCodigoCarrera(String Carrera) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT CODCAR FROM CARRERA WHERE NOMCAR LIKE ?;";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Carrera);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODCAR");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<String> autocompleteCarrera(String Consulta) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "select top 10 NOMCAR AS CARRERA from CARRERA WHERE NOMCAR LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                Lista.add(rs.getString("CARRERA"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }

    }

}
