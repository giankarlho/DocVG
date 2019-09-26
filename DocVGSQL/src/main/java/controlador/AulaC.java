package controlador;

import reports.report;
import dao.AulaImpl;
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
import model.Aula;

@Named(value = "aulaC")
@SessionScoped
public class AulaC implements Serializable {

    private Aula aula = new Aula();
    private Aula select;
    private List<Aula> lstAul;
    private List<Aula> lstAul2;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public List<String> completeTextAula(String query) throws SQLException {
        AulaImpl Dao = new AulaImpl();
        return Dao.autocompleteCarrera(query);
    }

    public void guardar() throws Exception {
        AulaImpl dao;
        try {
            dao = new AulaImpl();
            aula.setCODCAR(dao.obtenerCodigoCarrera(aula.getCODCAR()));
            dao.registrar(aula);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado.."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        AulaImpl dao;
        try {
            dao = new AulaImpl();
            select.setCODCAR(dao.obtenerCodigoCarrera(select.getCODCAR()));
            System.out.println(select.getCODCAR());
            dao.modificar(select);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación", "Correcto..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        aula = new Aula();
    }

    public void listar() throws Exception {
        AulaImpl dao;
        try {
            dao = new AulaImpl();
            lstAul = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar() throws Exception {
        AulaImpl dao;
        try {
            dao = new AulaImpl();
            dao.eliminar(select);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO", null));
        } catch (Exception e) {
            throw e;
        }
    }

//REPORTE GRUPO    
    public void REPORTE_PDF_GRUPO(String CodigoAlumno) throws Exception {
        report reportAlu = new report();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put(null, CodigoAlumno); //Insertamos un parametro
            reportAlu.exportarPDF(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Aula getSelect() {
        return select;
    }

    public void setSelect(Aula select) {
        this.select = select;
    }

    public List<Aula> getLstAul() {
        return lstAul;
    }

    public void setLstAul(List<Aula> lstAul) {
        this.lstAul = lstAul;
    }

    public List<Aula> getLstAul2() {
        return lstAul2;
    }

    public void setLstAul2(List<Aula> lstAul2) {
        this.lstAul2 = lstAul2;
    }

}
