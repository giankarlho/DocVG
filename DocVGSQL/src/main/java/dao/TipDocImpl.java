package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.TipDoc;

public class TipDocImpl extends Conexion implements ICRUD<TipDoc> {

    @Override
    public void registrar(TipDoc tipdoc) throws Exception {
        try {
            this.Conexion();
            String sql = "insert into tipo_documento"
                    + "(ABRTIPDOC,NOMTIPDOC,ESTTIPDOC)"
                    + "values (?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, tipdoc.getABRTIPDOC());
            ps.setString(2, tipdoc.getNOMTIPDOC());
            ps.setString(3, "A");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en registrar " + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(TipDoc tipdoc) throws Exception {
        try {
            this.Conexion();
            String sql = "update TIPO_DOCUMENTO set ABRTIPDOC=?,NOMTIPDOC=?,ESTTIPDOC=? where CODTIPDOC=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, tipdoc.getABRTIPDOC());
            ps.setString(2, tipdoc.getNOMTIPDOC());
            ps.setString(3, tipdoc.getESTTIPDOC());
            ps.setInt(4, tipdoc.getCODTIPDOC());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en modificar " + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(TipDoc tipdoc) throws Exception {
        try {
            this.Conexion();
            String sql = "update TIPO_DOCUMENTO set ESTTIPDOC='I' where CODTIPDOC=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, tipdoc.getCODTIPDOC());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al elimoicar " + e.getMessage());
        } finally {
            this.Cerrar();
        }
    }
    public void activar(TipDoc tipdoc) throws Exception {
        try {
            this.Conexion();
            String sql = "update TIPO_DOCUMENTO set ESTTIPDOC='A' where CODTIPDOC=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, tipdoc.getCODTIPDOC());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al activar " + e.getMessage());
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<TipDoc> listar() throws Exception {
        List<TipDoc> listado;
        TipDoc tipdoc;
        try {
            this.Conexion();
            String sql = "select * from TIPO_DOCUMENTO where ESTTIPDOC='A'";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tipdoc = new TipDoc();
                tipdoc.setCODTIPDOC(rs.getInt("CODTIPDOC"));
                tipdoc.setABRTIPDOC(rs.getString("ABRTIPDOC"));
                tipdoc.setNOMTIPDOC(rs.getString("NOMTIPDOC"));
                tipdoc.setESTTIPDOC(rs.getString("ESTTIPDOC"));
                listado.add(tipdoc);
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
    public List<TipDoc> listarIna() throws Exception {
        List<TipDoc> listado;
        TipDoc tipdoc;
        try {
            this.Conexion();
            String sql = "select * from TIPO_DOCUMENTO where ESTTIPDOC='I'";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tipdoc = new TipDoc();
                tipdoc.setCODTIPDOC(rs.getInt("CODTIPDOC"));
                tipdoc.setABRTIPDOC(rs.getString("ABRTIPDOC"));
                tipdoc.setNOMTIPDOC(rs.getString("NOMTIPDOC"));
                tipdoc.setESTTIPDOC(rs.getString("ESTTIPDOC"));
                listado.add(tipdoc);
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

}
