
package prueba;

import dao.EmpresaImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;


public class Pruebas {
   
    public static String[] selectedCities;
    public static List<String> cities = new ArrayList<String>(); 

    @PostConstruct
    public void init() {
        
    }

    public Pruebas() throws Exception {
  
    }

    public static List<String> listarResp() throws Exception {
        cities=EmpresaImpl.listarPrueba();
        return cities;
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
        listarResp();   
        System.out.println("La lista es ");
        System.out.println(cities.size());
        for(int i=0;i<cities.size();i++){
            System.out.println(cities.get(i));
        }
    }
}
