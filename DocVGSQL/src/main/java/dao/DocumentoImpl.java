package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Documento;

public class DocumentoImpl extends Conexion implements ICRUD<Documento> {

    @Override
    public void registrar(Documento documento) throws Exception {
        try {
            this.Conexion();
            String sql = "insert into DOCUMENTO"
                    + "(ESTDOC,ASUDOC,FECDOC,DESDOC,TEMDOC,CODTIPDOC,CODEMP,CODTER,HORDOC)"
                    + "values (?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = this.getCn().prepareStatement(sql)) {
                ps.setString(1, "A");
                ps.setString(2, documento.getASUDOC());
                ps.setString(3, documento.getFECDOC());
                ps.setString(4, documento.getDESDOC());
                ps.setString(5, documento.getTEMDOC());
                ps.setString(6, documento.getCODTIPDOC());
                ps.setString(7, documento.getCODEMP());
                ps.setString(8, documento.getCODTER());
                ps.setString(9, documento.getHORDOC());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error en registrar" + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void registrarPPP(Documento documento) throws Exception {
        try {
            this.Conexion();
            String sql = "insert into DOCUMENTO"
                    + "(ESTDOC,ASUDOC,FECDOC,DESDOC,CODTIPDOC,CODEMP)"
                    + "values (?,?,?,?,?,?)";
            try (PreparedStatement ps = this.getCn().prepareStatement(sql)) {
                ps.setString(1, "A");
                ps.setString(2, documento.getASUDOC());
                ps.setString(3, documento.getFECDOC());
                ps.setString(4, documento.getDESDOC());
                ps.setString(5, "1");
                ps.setString(6, documento.getCODEMP());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error en registrar" + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void registrarViaje(Documento documento) throws Exception {
        try {
            this.Conexion();
            String sql = "insert into DOCUMENTO"
                    + "(ESTDOC,ASUDOC,FECDOC,TEMDOC,CODTIPDOC,CODEMP,HORDOC)"
                    + "values (?,?,?,?,?,?,?)";
            try (PreparedStatement ps = this.getCn().prepareStatement(sql)) {
                ps.setString(1, "A");
                ps.setString(2, "DELEGACIÓN PARA EL VIAJE DE ESTUDIO");
                ps.setString(3, documento.getFECDOC());
                ps.setString(4, documento.getTEMDOC());
                ps.setString(5, "2");
                ps.setString(6, documento.getCODEMP());
                ps.setString(7, documento.getHORDOC());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error en registrar" + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void registrarTertulia(Documento documento) throws Exception {
        try {
            this.Conexion();
            String sql = "insert into DOCUMENTO"
                    + "(ESTDOC,ASUDOC,FECDOC,TEMDOC,CODTIPDOC,CODTER,HORDOC)"
                    + "values (?,?,?,?,?,?,?)";
            try (PreparedStatement ps = this.getCn().prepareStatement(sql)) {
                ps.setString(1, "A");
                ps.setString(2, "TERTULIA PROFESIONAL");
                ps.setString(3, documento.getFECDOC());
                ps.setString(4, documento.getTEMDOC());
                ps.setString(5, "3");
                ps.setString(6, documento.getCODTER());
                ps.setString(7, documento.getHORDOC());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error en registrar" + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void registrarVisita(Documento documento) throws Exception {
        try {
            this.Conexion();
            String sql = "insert into DOCUMENTO"
                    + "(ESTDOC,ASUDOC,FECDOC,TEMDOC,CODTIPDOC,CODEMP,HORDOC)"
                    + "values (?,?,?,?,?,?,?)";
            try (PreparedStatement ps = this.getCn().prepareStatement(sql)) {
                ps.setString(1, "A");
                ps.setString(2, "VISITA DE ESTUDIO");
                ps.setString(3, documento.getFECDOC());
                ps.setString(4, documento.getTEMDOC());
                ps.setString(5, "5");
                ps.setString(6, documento.getCODEMP());
                ps.setString(7, documento.getHORDOC());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error en registrar" + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Documento documento) throws Exception {
        try {
            this.Conexion();
            String sql = "update DOCUMENTO set ESTDOC=?,ASUDOC=?,FECDOC=?,DESDOC=?,TEMDOC=?,"
                    + "CODTIPDOC=?,CODEMP=?,CODTER=?,HORDOC=? where CODDOC=?";
            try (PreparedStatement ps = this.getCn().prepareStatement(sql)) {
                ps.setString(1, documento.getESTDOC());
                ps.setString(2, documento.getASUDOC());
                ps.setString(3, documento.getFECDOC());
                ps.setString(4, documento.getDESDOC());
                ps.setString(5, documento.getTEMDOC());
                ps.setString(6, documento.getCODTIPDOC());
                ps.setString(7, documento.getCODEMP());
                ps.setString(8, documento.getCODTER());
                ps.setString(9, documento.getHORDOC());
                ps.setInt(10, documento.getCODDOC());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error en modificar " + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Documento documento) throws Exception {
        try {
            this.Conexion();
            String sql = "update DOCUMENTO set ESTDOC='I' where CODDOC=?";
            try (PreparedStatement ps = this.getCn().prepareCall(sql)) {
                ps.setInt(1, documento.getCODDOC());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al elimoicar " + e.getMessage());
        } finally {
            this.Cerrar();
        }
    }

    public void activar(Documento documento) throws Exception {
        try {
            this.Conexion();
            String sql = "update DOCUMENTO set ESTDOC='A' where CODDOC=?";
            try (PreparedStatement ps = this.getCn().prepareCall(sql)) {
                ps.setInt(1, documento.getCODDOC());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al activar " + e.getMessage());
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Documento> listar() throws Exception {
        List<Documento> listado;
        Documento doc;
        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_PRAC_DOC WHERE ESTDOC= 'A' AND CODTIPDOC = 'PRACTICA PRE-PROFESIONALES'";
            listado = new ArrayList();
            try (Statement st = this.getCn().createStatement(); ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    doc = new Documento();
                    doc.setCODDOC(rs.getInt("CODDOC"));
                    doc.setESTDOC(rs.getString("ESTDOC"));
                    doc.setASUDOC(rs.getString("ASUDOC"));
                    doc.setFECDOC(rs.getString("FECDOC"));
                    doc.setDESDOC(rs.getString("DESDOC"));
                    doc.setCODTIPDOC(rs.getString("CODTIPDOC"));
                    doc.setCODEMP(rs.getString("CODEMP"));
                    listado.add(doc);
                }
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }

    public List<Documento> listarViaje() throws Exception {
        List<Documento> listado;
        Documento doc;
        try {
            this.Conexion();
            String sql = "select * from VW_VI_DOC WHERE ESTDOC= 'A' AND CODTIPDOC='VIAJE DE ESTUDIO'";
            listado = new ArrayList();
            try (Statement st = this.getCn().createStatement(); ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    doc = new Documento();
                    doc.setCODDOC(rs.getInt("CODDOC"));
                    doc.setESTDOC(rs.getString("ESTDOC"));
                    doc.setASUDOC(rs.getString("ASUDOC"));
                    doc.setHORDOC(rs.getString("HORDOC"));
                    doc.setFECDOC(rs.getString("FECDOC"));
                    doc.setTEMDOC(rs.getString("TEMDOC"));
                    doc.setCODTIPDOC(rs.getString("CODTIPDOC"));
                    doc.setCODEMP(rs.getString("CODEMP"));
                    listado.add(doc);
                }
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }

    public List<Documento> listarTertulia() throws Exception {
        List<Documento> listado;
        Documento doc;
        try {
            this.Conexion();
            String sql = "select * from VW_TER_DOC where ESTDOC= 'A' AND CODTIPDOC='TERTULIA PROFESIONAL'";
            listado = new ArrayList();
            try (Statement st = this.getCn().createStatement(); ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    doc = new Documento();
                    doc.setCODDOC(rs.getInt("CODDOC"));
                    doc.setESTDOC(rs.getString("ESTDOC"));
                    doc.setASUDOC(rs.getString("ASUDOC"));
                    doc.setHORDOC(rs.getString("HORDOC"));
                    doc.setFECDOC(rs.getString("FECDOC"));
                    doc.setTEMDOC(rs.getString("TEMDOC"));
                    doc.setCODTIPDOC(rs.getString("CODTIPDOC"));
                    doc.setCODTER(rs.getString("CODTER"));
                    listado.add(doc);
                }
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }

    public List<Documento> listarVisita() throws Exception {
        List<Documento> listado;
        Documento doc;
        try {
            this.Conexion();
            String sql = "select * from VW_VI_DOC WHERE ESTDOC= 'A' AND CODTIPDOC='VISITA DE ESTUDIO'";
            listado = new ArrayList();
            try (Statement st = this.getCn().createStatement(); ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    doc = new Documento();
                    doc.setCODDOC(rs.getInt("CODDOC"));
                    doc.setESTDOC(rs.getString("ESTDOC"));
                    doc.setASUDOC(rs.getString("ASUDOC"));
                    doc.setHORDOC(rs.getString("HORDOC"));
                    doc.setFECDOC(rs.getString("FECDOC"));
                    doc.setTEMDOC(rs.getString("TEMDOC"));
                    doc.setCODTIPDOC(rs.getString("CODTIPDOC"));
                    doc.setCODEMP(rs.getString("CODEMP"));
                    listado.add(doc);
                }
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }

    public String obtenerCodigoTIPDOC(String TipDoc) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT CODTIPDOC FROM TIPO_DOCUMENTO WHERE NOMTIPDOC LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, TipDoc);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODTIPDOC");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<String> autocompleteTIPDOC(String Consulta) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "select top 10 NOMTIPDOC AS TIPO_DOCUMENTO from TIPO_DOCUMENTO WHERE NOMTIPDOC LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                Lista.add(rs.getString("TIPO_DOCUMENTO"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public String obtenerCodigoTertuliante(String Tertuliante) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT CODTER FROM TERTULIANTE WHERE CONCAT(NOMTER,', ', APETER) LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Tertuliante);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODTER");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<String> autocompleteTertuliante(String Consulta) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "select top 10 CONCAT(NOMTER,', ', APETER) AS TERTULIANTE from TERTULIANTE WHERE NOMTER LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                Lista.add(rs.getString("TERTULIANTE"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public String obtenerCodigoEmpresa(String Empresa) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT CODEMP FROM EMPRESA WHERE RAZEMP LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Empresa);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODEMP");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<String> autocompleteEmpresa(String Consulta) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "select top 10 RAZEMP AS EMPRESA from EMPRESA WHERE RAZEMP LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                Lista.add(rs.getString("EMPRESA"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }
    }

}
