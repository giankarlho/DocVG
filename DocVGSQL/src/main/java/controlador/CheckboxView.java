package controlador;

import dao.EmpresaImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CheckboxView {

    EmpresaImpl dao;
    private String[] selectedResp;
    private List<String> responsables;

    public CheckboxView() throws Exception {
        responsables = new ArrayList<String>();
        listarResp();
    }

    public List<String> listarResp() throws SQLException, Exception {
        dao = new EmpresaImpl();
        responsables = dao.listarResp();
        return responsables;
    }

    public List<String> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<String> responsables) {
        this.responsables = responsables;
    }

    public String[] getSelectedResp() {
        return selectedResp;
    }

    public void setSelectedResp(String[] selectedResp) {
        this.selectedResp = selectedResp;
    }
}
