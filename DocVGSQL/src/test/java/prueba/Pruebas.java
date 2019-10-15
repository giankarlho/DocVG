package prueba;

import dao.EmpresaImpl;
import java.util.List;
import javax.annotation.PostConstruct;

public class Pruebas {

    public static String[] selectedCities;

    @PostConstruct
    public void init() {

    }

    public Pruebas() throws Exception {

    }


//    public static List<String> listarPrueba() throws Exception {
////        List<String> cities2 = new ArrayList<>();
//        cities.add("Miami");
//        cities.add("London");
//        cities.add("Paris");
//        cities.add("Istanbul");
//        cities.add("Berlin");
//        cities.add("Barcelona");
//        cities.add("Rome");
//        cities.add("Brasilia");
//        cities.add("Amsterdam"); 
//        return cities;
//    }
    public static void main(String[] args) throws Exception {
//        listarPrueba();
//        listarResp();   
//        System.out.println("La lista es ");
//        System.out.println(cities.size());
//        for(int i=0;i<cities.size();i++){
//            System.out.println(cities.get(i));
//        }
//        EmpresaC control = new EmpresaC();
//        System.out.println("Aqui quiero imprimir");
////        control.getCodResp("CAMPOS CASTILLO FLAVIO ALEXANDER");
//        System.out.println(control.getCodResp("CAMPOS CASTILLO FLAVIO ALEXANDER"));

//        Date fecha = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        System.out.println("Fecha: " + dateFormat.format(fecha));
//        System.out.println("Esta es la fecha del sistema: " + fecha);
            EmpresaImpl daoEmp = new EmpresaImpl();
            System.out.println("El último código es: " + daoEmp.getCodEmp());
                    
    }
}
