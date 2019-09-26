package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    private Connection cn;

    public void Conexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=DocVG","sa","@gvs123@");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }

    public static void main(String[] args) {
        Conexion dao = new Conexion();
        dao.Conexion();
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

  
}