package controlador;

import reports.report;
import dao.DocumentoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Documento;

@Named(value = "documentoC")
@SessionScoped
public class DocumentoC implements Serializable {

    private Documento documento = new Documento();
    private Documento select;
    private List<Documento> listadoDocTertu;
    private List<Documento> listadoDocVisita;
    private List<Documento> listadoDoc;
    private List<Documento> listadoDoc2;
    private List<Documento> listadoDocViaje;
    private List<Documento> listadoDocIna2;
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MMM/yyyy");
    SimpleDateFormat sdf_d = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
    private Date fechaFormulario;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
            listarViaje();
            listarTertulia();
            listarVisita();
        } catch (Exception e) {
        }
    }

    public void rellenar() throws Exception {
        System.out.println(sdf_d.parse(select.getFECDOC()));
        fechaFormulario = sdf_d.parse(select.getFECDOC());
    }

    public void registrar() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            documento.setFECDOC(formateador.format(fechaFormulario));
            documento.setCODTIPDOC(dao.obtenerCodigoTIPDOC(documento.getCODTIPDOC()));
            documento.setCODTER(dao.obtenerCodigoTertuliante(documento.getCODTER()));
            documento.setCODEMP(dao.obtenerCodigoEmpresa(documento.getCODEMP()));
            dao.registrar(documento);
            limpiar();
            listar();
            listarViaje();
            listarTertulia();
            listarVisita();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void registrarPPP() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            documento.setFECDOC(formateador.format(fechaFormulario));
            documento.setCODTIPDOC(dao.obtenerCodigoTIPDOC(documento.getCODTIPDOC()));
            documento.setCODEMP(dao.obtenerCodigoEmpresa(documento.getCODEMP()));
            dao.registrarPPP(documento);
            limpiar();
            listar();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void registrarviaje() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            documento.setFECDOC(formateador.format(fechaFormulario));
            documento.setCODTIPDOC(dao.obtenerCodigoTIPDOC(documento.getCODTIPDOC()));
            documento.setCODEMP(dao.obtenerCodigoEmpresa(documento.getCODEMP()));
            dao.registrarViaje(documento);
            limpiar();
            listarViaje();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void registrarTertulia() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            documento.setFECDOC(formateador.format(fechaFormulario));
            documento.setCODTIPDOC(dao.obtenerCodigoTIPDOC(documento.getCODTIPDOC()));
            documento.setCODTER(dao.obtenerCodigoTertuliante(documento.getCODTER()));
            documento.setCODEMP(dao.obtenerCodigoEmpresa(documento.getCODEMP()));
            dao.registrarTertulia(documento);
            limpiar();
            listarTertulia();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void registrarVisita() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            documento.setFECDOC(formateador.format(fechaFormulario));
            documento.setCODTIPDOC(dao.obtenerCodigoTIPDOC(documento.getCODTIPDOC()));
            documento.setCODEMP(dao.obtenerCodigoEmpresa(documento.getCODEMP()));
            dao.registrarVisita(documento);
            limpiar();
            listarVisita();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public List<String> completeTextTIPDOC(String query) throws SQLException {
        DocumentoImpl Dao = new DocumentoImpl();
        return Dao.autocompleteTIPDOC(query);
    }

    public List<String> completeTextTertuliante(String query) throws SQLException {
        DocumentoImpl Dao = new DocumentoImpl();
        return Dao.autocompleteTertuliante(query);
    }

    public List<String> completeTextEmpresa(String query) throws SQLException {
        DocumentoImpl Dao = new DocumentoImpl();
        return Dao.autocompleteEmpresa(query);
    }

    public void modificar() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            select.setFECDOC(formateador.format(fechaFormulario));
            select.setCODTIPDOC(dao.obtenerCodigoTIPDOC(select.getCODTIPDOC()));
            System.out.println(select.getCODTIPDOC());
            select.setCODTER(dao.obtenerCodigoTertuliante(select.getCODTER()));
            System.out.println(select.getCODTER());
            select.setCODEMP(dao.obtenerCodigoEmpresa(select.getCODEMP()));
            System.out.println(select.getCODEMP());
            dao.modificar(select);
            listar();
            listarViaje();
            listarTertulia();
            listarVisita();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Completado.."));
        } catch (SQLException e) {
            throw e;
        }
    }

    public void eliminar() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            dao.eliminar(select);
            listar();
            listarViaje();
            listarTertulia();
            listarVisita();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminación", "Completado.."));
        } catch (SQLException e) {
            throw e;
        }
    }

    public void activar() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            dao.activar(select);
            listarViaje();
            listar();
            listarViaje();
            listarTertulia();
            listarVisita();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Activación", "Completado.."));
        } catch (SQLException e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            listadoDoc = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarViaje() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            listadoDocViaje = dao.listarViaje();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarTertulia() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            listadoDocTertu = dao.listarTertulia();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarVisita() throws Exception {
        DocumentoImpl dao;
        try {
            dao = new DocumentoImpl();
            listadoDocVisita = dao.listarVisita();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() throws Exception {
        try {
            documento = new Documento();
        } catch (Exception e) {
            throw e;
        }
    }

    //REPORTE DOCUMENTO  
    public void REPORTE_PDF_PERSONAS_viaje(String responsable) throws Exception {
        report reportAlu = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put("CODDOC", responsable); //Insertamos un parametro
            reportAlu.exportarPDFVIAJEPER(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }

    public void REPORTE_PDF_ALUM(String responsable) throws Exception {
        report reportAlu = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put("CODAUL", responsable); //Insertamos un parametro
            reportAlu.exportarPDFDocumento(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }

    public void REPORTE_PDF_PRACTICA(String coddoc) throws Exception {
        report reportPrac = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put("CODDOC", coddoc); //Insertamos un parametro
            reportPrac.exportarPDFPRACTICA(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }

    public void REPORTE_PDF_VIAJE(String coddoc) throws Exception {
        report reportPrac = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put("CODDOC", coddoc); //Insertamos un parametro
            reportPrac.exportarVIAJE(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }

    public void REPORTE_PDF_VISITA(String coddoc) throws Exception {
        report reportPrac = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put("CODDOC", coddoc); //Insertamos un parametro
            reportPrac.exportarPDFVISITA(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }

    public void REPORTE_PDF_TERTULIA(String coddoc) throws Exception {
        report reportPrac = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put("CODDOC", coddoc); //Insertamos un parametro
            reportPrac.exportarTERTULIA(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }

    public SimpleDateFormat getSdf_d() {
        return sdf_d;
    }

    public void setSdf_d(SimpleDateFormat sdf_d) {
        this.sdf_d = sdf_d;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Documento getSelect() {
        return select;
    }

    public void setSelect(Documento select) {
        this.select = select;
    }

    public List<Documento> getListadoDocTertu() {
        return listadoDocTertu;
    }

    public void setListadoDocTertu(List<Documento> listadoDocTertu) {
        this.listadoDocTertu = listadoDocTertu;
    }

    public List<Documento> getListadoDocVisita() {
        return listadoDocVisita;
    }

    public void setListadoDocVisita(List<Documento> listadoDocVisita) {
        this.listadoDocVisita = listadoDocVisita;
    }

    public List<Documento> getListadoDoc() {
        return listadoDoc;
    }

    public void setListadoDoc(List<Documento> listadoDoc) {
        this.listadoDoc = listadoDoc;
    }

    public List<Documento> getListadoDoc2() {
        return listadoDoc2;
    }

    public void setListadoDoc2(List<Documento> listadoDoc2) {
        this.listadoDoc2 = listadoDoc2;
    }

    public List<Documento> getListadoDocViaje() {
        return listadoDocViaje;
    }

    public void setListadoDocViaje(List<Documento> listadoDocViaje) {
        this.listadoDocViaje = listadoDocViaje;
    }

    public List<Documento> getListadoDocIna2() {
        return listadoDocIna2;
    }

    public void setListadoDocIna2(List<Documento> listadoDocIna2) {
        this.listadoDocIna2 = listadoDocIna2;
    }

    public SimpleDateFormat getFormateador() {
        return formateador;
    }

    public void setFormateador(SimpleDateFormat formateador) {
        this.formateador = formateador;
    }

    public Date getFechaFormulario() {
        return fechaFormulario;
    }

    public void setFechaFormulario(Date fechaFormulario) {
        this.fechaFormulario = fechaFormulario;
    }

}
