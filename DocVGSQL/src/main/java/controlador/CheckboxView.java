package controlador;

import dao.EmpresaImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CheckboxView {

    EmpresaImpl resp;
    private String[] selectedCities;
    private List<String> cities;

    @PostConstruct
    public void init() {
        
//        cities.add("Miami");
//        cities.add("London");
//        cities.add("Paris");
//        cities.add("Istanbul");
//        cities.add("Berlin");
//        cities.add("Barcelona");
//        cities.add("Rome");
//        cities.add("Brasilia");
//        cities.add("Amsterdam");  
    }

    public CheckboxView() throws Exception {
        cities = new ArrayList<String>();
        listarResp();
    }

    public List<String> listarResp() throws SQLException, Exception {
        cities = EmpresaImpl.listarPrueba();
        return cities;
    }

    public String[] getSelectedCities() {
        return selectedCities;
    }

    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}
