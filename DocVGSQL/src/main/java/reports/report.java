package reports;

import dao.Conexion;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class report extends Conexion {

    public void exportarPDF(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/grupo1.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DEL TRABAJADOR.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarVIAJE(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/REPORTEVIAJE.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DEL VIAJE.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPDFDocumento(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/DEMO.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DE DOCUMENTO.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPDFAlumno(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/ALUM.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DE ALUMNO.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPDFEmpresa(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/EMPRESA.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DE EMPRESA.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPDFPRACTICA(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/REPORTEPPP.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DE DEMO.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPDFVIAJEPER(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/PersonasViaje.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DE PERSONA.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPDFPROFESOR(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/PROFESOR.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DE PROFESOR.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPDFRESPONSABLE(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/RESPONSABLE.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DE PROFESOR.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPDFTERTULIANTE(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/TERTULIANTE.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DE TERTULIANTE.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPDFVISITA(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/REPORTEVISITA.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DEL VISITA.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarTERTULIA(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/REPORTETERTULIA.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=DOCUMENTO DE TERTULIA.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

}
