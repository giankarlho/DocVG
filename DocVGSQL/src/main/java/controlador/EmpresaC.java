package controlador;
import java.util.Map;
import java.util.HashMap;
import reports.report;
import dao.EmpresaImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Empresa;

@Named(value = "empresaC")
@SessionScoped
public class EmpresaC implements Serializable {

    private Empresa empresa = new Empresa();
    private Empresa select;
    private List<Empresa> listadoEmp;
    private List<Empresa> listadoEmp2;
    private List<Empresa> listadoEmpIna;
    private List<Empresa> listadoEmpIna2;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
            listarIna();
        } catch (Exception e) {
        }
    }

    public void registrar() throws Exception {
        EmpresaImpl dao;
        try {
            dao = new EmpresaImpl();
            empresa.setCODUBI(dao.obtenerCodigoEmpresa(empresa.getCODUBI()));
            dao.registrar(empresa);
            limpiar();
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public List<String> completeTextEmpresa(String query) throws SQLException {
        EmpresaImpl Dao = new EmpresaImpl();
        return Dao.autocompleteEmpresa(query);
    }

    public List<String> completeTextResponsable(String query) throws SQLException {
        EmpresaImpl Dao = new EmpresaImpl();
        return Dao.autocompleteResponsable(query);
    }

    public void modificar() throws Exception {
        EmpresaImpl dao;
        try {
            dao = new EmpresaImpl();
            select.setCODUBI(dao.obtenerCodigoEmpresa(select.getCODUBI()));
            System.out.println(select.getCODUBI());
            dao.modificar(select);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Completado.."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar() throws Exception {
        EmpresaImpl dao;
        try {
            dao = new EmpresaImpl();
            dao.eliminar(select);
            listar();
            listarIna();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminación", "Completado.."));
        } catch (SQLException e) {
            throw e;
        }
    }
    public void activar() throws Exception {
        EmpresaImpl dao;
        try {
            dao = new EmpresaImpl();
            dao.activar(select);
            listarIna();
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Activación", "Completado.."));
        } catch (SQLException e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        EmpresaImpl dao;
        try {
            dao = new EmpresaImpl();
            listadoEmp = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    public void listarIna() throws Exception {
        EmpresaImpl dao;
        try {
            dao = new EmpresaImpl();
            listadoEmpIna = dao.listarIna();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() throws Exception {
        try {
            empresa = new Empresa();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void REPORTE_PDF_EMPRESA(String CodigoEMPRESA) throws Exception {
        report reportAlu = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put(null, CodigoEMPRESA); //Insertamos un parametro
            reportAlu.exportarPDFEmpresa(parameters);//Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getListadorEmp() {
        return listadoEmp;
    }

    public void setListadoEmp(List<Empresa> listadoEmp) {
        this.listadoEmp = listadoEmp;
    }

    public Empresa getSelect() {
        return select;
    }

    public void setSelect(Empresa select) {
        this.select = select;
    }

    public List<Empresa> getListadoEmp2() {
        return listadoEmp2;
    }

    public void setListadoEmp2(List<Empresa> listadoEmp2) {
        this.listadoEmp2 = listadoEmp2;
    }

    public List<Empresa> getListadoEmpIna() {
        return listadoEmpIna;
    }

    public void setListadoEmpIna(List<Empresa> listadoEmpIna) {
        this.listadoEmpIna = listadoEmpIna;
    }

    public List<Empresa> getListadoEmpIna2() {
        return listadoEmpIna2;
    }

    public void setListadoEmpIna2(List<Empresa> listadoEmpIna2) {
        this.listadoEmpIna2 = listadoEmpIna2;
    }
    
    

}
