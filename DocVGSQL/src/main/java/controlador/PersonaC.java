package controlador;

import reports.report;
import dao.PersonaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Persona;
import org.primefaces.model.chart.PieChartModel;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {
    
    private Persona persona = new Persona();
    private Persona select;
    private List<Persona> listadoAlumno;
    private List<Persona> listadoMonitor;
    private List<Persona> listadoPer2;
    private List<Persona> listadoPerIna;
    private List<Persona> listadoPerIna2;
    
    private PieChartModel Circulo;
    
    @PostConstruct
    public void iniciar() {
        try {
            listarAlumno();
            listarMonitor();
            listarIna();
        } catch (Exception e) {
        }
    }
    

    

    
    public void registrar() throws Exception {
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            persona.setCODUBI(dao.obtenerCodigoUbigeo(persona.getCODUBI()));
            dao.registrar(persona);
            limpiar();
     
            listarAlumno();
            listarMonitor();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean validarExistenciaPersona(String dniPersona) {
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            Persona personaValidacion = new Persona();
            personaValidacion = dao.validarExistenciaPersona(dniPersona);
            String DNIPER = personaValidacion.getDNIPER().toLowerCase().trim();
            if (DNIPER.equals(dniPersona)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public List<String> completeTextUbigeo(String query) throws SQLException {
        PersonaImpl Dao = new PersonaImpl();
        return Dao.autocompleteUbigeo(query);
    }
    
    public void modificar() throws Exception {
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            select.setCODUBI(dao.obtenerCodigoUbigeo(select.getCODUBI()));
            System.out.println(select.getCODUBI());
            dao.modificar(select);
            listarAlumno();
            listarMonitor();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Completado.."));
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar() throws Exception {
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            dao.eliminar(select);
            listarAlumno();
            listarMonitor();
           
            listarIna();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminación", "Completado.."));
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void activar() throws Exception {
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            dao.activar(select);
            listarIna();
           
            listarAlumno();
            listarMonitor();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Activación", "Completado.."));
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void listarAlumno() throws Exception {
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            listadoAlumno = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listarMonitor() throws Exception {
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            listadoMonitor = dao.listarMonitor();
        } catch (Exception e) {
            throw e;
        }
    }
    public void listarIna() throws Exception {
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            listadoPerIna = dao.listarIna();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void limpiar() throws Exception {
        try {
            persona = new Persona();
        } catch (Exception e) {
            throw e;
        }
    }

    public void REPORTE_PDF_ALUMNO(String CodigoAlumno) throws Exception {
        report reportAlu = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put(null, CodigoAlumno); //Insertamos un parametro
            reportAlu.exportarPDFAlumno(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void REPORTE_PDF_PROFESOR(String CodigoAlumno) throws Exception {
        report reportAlu = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put(null, CodigoAlumno); //Insertamos un parametro
            reportAlu.exportarPDFPROFESOR(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void REPORTE_PDF_RESPONSABLE(String CodigoAlumno) throws Exception {
        report reportAlu = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put(null, CodigoAlumno); //Insertamos un parametro
            reportAlu.exportarPDFRESPONSABLE(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }
    
     public void REPORTE_PDF_TERTULIANTE(String CodigoTert) throws Exception {
        report reportTer = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put(null, CodigoTert); //Insertamos un parametro
            reportTer.exportarPDFTERTULIANTE(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Persona getSelect() {
        return select;
    }
    
    public void setSelect(Persona select) {
        this.select = select;
    }
    
    public List<Persona> getListadoPer2() {
        return listadoPer2;
    }
    
    public void setListadoPer2(List<Persona> listadoPer2) {
        this.listadoPer2 = listadoPer2;
    }
    
    public List<Persona> getListadoPerIna() {
        return listadoPerIna;
    }
    
    public void setListadoPerIna(List<Persona> listadoPerIna) {
        this.listadoPerIna = listadoPerIna;
    }
    
    public List<Persona> getListadoPerIna2() {
        return listadoPerIna2;
    }
    
    public void setListadoPerIna2(List<Persona> listadoPerIna2) {
        this.listadoPerIna2 = listadoPerIna2;
    }
    
    public PieChartModel getCirculo() {
        return Circulo;
    }
    
    public void setCirculo(PieChartModel Circulo) {
        this.Circulo = Circulo;
    }

    public List<Persona> getListadoAlumno() {
        return listadoAlumno;
    }

    public void setListadoAlumno(List<Persona> listadoAlumno) {
        this.listadoAlumno = listadoAlumno;
    }

    public List<Persona> getListadoMonitor() {
        return listadoMonitor;
    }

    public void setListadoMonitor(List<Persona> listadoMonitor) {
        this.listadoMonitor = listadoMonitor;
    }
    
}
