package controlador;

import java.util.Map;
import java.util.HashMap;
import reports.report;
import dao.EmpresaImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Empresa;
import model.Persona;

@Named(value = "empresaC")
@SessionScoped
public class EmpresaC implements Serializable {

    private Empresa empresa;
    private Empresa select;
    private List<Empresa> listadoEmp;
    private String[] selectedResp;
    private List<String> responsables = new ArrayList<String>();   
  
    public EmpresaC() throws Exception {        
        empresa = new Empresa();
        select = new Empresa();
        listadoEmp = new ArrayList<>(); 
        listarResp();
    }

    public void registrar() throws Exception {
        EmpresaImpl dao;
        try {
            dao = new EmpresaImpl();
            empresa.setCODUBI(dao.getCodUbigeo(empresa.getCODUBI()));
            dao.registrar(empresa);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public List<String> listarUbigeo(String query) throws SQLException {
        EmpresaImpl ubigeo = new EmpresaImpl();
        return ubigeo.listarUbigeo(query);
    }

    public List<String> listarResp() throws SQLException, Exception{
        EmpresaImpl dao = new EmpresaImpl();
        responsables =dao.listarResp();
        return responsables;        
    }

    public void limpiar() throws Exception {
        try {
            empresa = new Empresa();
        } catch (Exception e) {
            throw e;
        }
    }

    public Empresa getSelect() {
        return select;
    }

    public void setSelect(Empresa select) {
        this.select = select;
    }

    public List<Empresa> getListadoEmp() {
        return listadoEmp;
    }

    public void setListadoEmp(List<Empresa> listadoEmp) {
        this.listadoEmp = listadoEmp;
    }

    public String[] getSelectedResp() {
        return selectedResp;
    }

    public void setSelectedResp(String[] selectedResp) {
        this.selectedResp = selectedResp;
    } 

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<String> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<String> responsables) {
        this.responsables = responsables;
    }
}
