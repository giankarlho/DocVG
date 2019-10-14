package controlador;

import dao.EmpresaImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.DetEmpresa;
import model.Empresa;
import model.Persona;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@Named(value = "empresaC")
@SessionScoped
public class EmpresaC implements Serializable {

    private DetEmpresa detEmp;
    private Persona persona;
    private EmpresaImpl dao;
    private Empresa emp = new Empresa();
    private Empresa select;
    private List<Empresa> listadoEmp;
    private List<String> selectedResp;
    private List<String> responsables;
    private List<DetEmpresa> persxEmp;

    public EmpresaC() throws Exception {
        responsables = new ArrayList<>();
        select = new Empresa();
        listadoEmp = new ArrayList<>();
        listarResp();
        listar();
    }

    public void registrar() throws Exception {
        try {
//            mostrar();
            dao = new EmpresaImpl();
            persona = new Persona();
            emp.setCODUBI(dao.getCodUbigeo(emp.getCODUBI()));
            dao.registrar(emp);
            emp.setIDEMP(dao.getCodEmp());
//            for (int i = 0; i < selectedResp.length; i++) {
//                persona.setIDPER(getCodResp(selectedResp[i]));
//                dao.registrarDet(empresa, persona);
//            }
            for (String strTemp : selectedResp) {
                persona.setIDPER(getCodResp(strTemp));
                dao.registrarDet(emp, persona);
            }

            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void verEscogidos() throws Exception {
        System.out.println("Estos son los elegidos");
        for (String strTemp : selectedResp) {
            System.out.println(getCodResp(strTemp));
        }
    }

    public Integer getCodResp(String nombre) throws Exception {
        dao = new EmpresaImpl();
        int codigo = dao.getCodResp(nombre);
        return codigo;
    }

    public List<String> listarUbigeo(String query) throws SQLException {
        EmpresaImpl ubigeo = new EmpresaImpl();
        return ubigeo.listarUbigeo(query);
    }

    public List<String> listarResp() throws SQLException, Exception {
        dao = new EmpresaImpl();
        responsables = dao.listarResp();
        return responsables;
    }

    public void listadoRespxEmp() throws Exception {
        persxEmp = new ArrayList<>();
        try {
            dao = new EmpresaImpl();
            persxEmp = dao.listarRespxEmp(emp);
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() throws Exception {
        try {
            emp = new Empresa();
            selectedResp.clear();
        } catch (Exception e) {
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
//    public void refresh() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        Application application = context.getApplication();
//        ViewHandler viewHandler = application.getViewHandler();
//        UIViewRoot viewRoot = viewHandler.createView(context, context
//                .getViewRoot().getViewId());
//        context.setViewRoot(viewRoot);
//        context.renderResponse();
//    }

    
    public void onRowSelect(SelectEvent event) throws Exception {
         persxEmp = new ArrayList<>();
        try {
            dao = new EmpresaImpl();
            persxEmp = dao.listarRespxEmp((Empresa) event.getObject());
            System.out.println("Que pasa aqui: " + (Empresa) event.getObject());
        } catch (Exception e) {
            throw e;
        }
//        FacesMessage msg = new FacesMessage("Empresa seleccionada", ((Empresa) event.getObject()).getRAZEMP());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
// 
    public void onRowUnselect(UnselectEvent event) throws Exception {
         persxEmp = new ArrayList<>();
        try {
            dao = new EmpresaImpl();
            persxEmp = dao.listarRespxEmp((Empresa) event.getObject());
        } catch (Exception e) {
            throw e;
        }
//        FacesMessage msg = new FacesMessage("Empresa Unselected", ((Empresa) event.getObject()).getRAZEMP());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    //    public void mostrar() {
//        System.out.println("código: " + emp.getCODUBI());
//        System.out.println("razón: " + emp.getRAZEMP());
//        System.out.println("comercial: " + emp.getCOMEMP());
//        System.out.println("dirección: " + emp.getDIREMP());
//        System.out.println("estado: " + emp.getESTEMP());
//        System.out.println("telefono: " + emp.getTELEMP());
//        System.out.println("ruc: " + emp.getRUCEMP());
//    }
    
    // Getter & Setter
    public Empresa getEmp() {
        return emp;
    }

    public void setEmp(Empresa emp) {
        this.emp = emp;
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

    public List<String> getSelectedResp() {
        return selectedResp;
    }

    public void setSelectedResp(List<String> selectedResp) {
        this.selectedResp = selectedResp;
    }

    public List<String> getResponsables() {
        return responsables;
    }

    public List<DetEmpresa> getPersxEmp() {
        return persxEmp;
    }

    public void setPersxEmp(List<DetEmpresa> persxEmp) {
        this.persxEmp = persxEmp;
    }

}



//    public void setResponsables(List<String> responsables) {
//        this.responsables = responsables;
//    } 