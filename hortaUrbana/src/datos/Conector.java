package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public class Conector {
    
    private String urlP = "jdbc:mysql://localhost:3306/hortas";
    private String usrP = "root";
    private String passP = "root";

    String url, usr, pass;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    /**
     * Establece unha conexión coa base de datos indicada.
     * @param url Dirección da BD.
     * @param usr Usuario da sesión da BD.
     * @param pass Contrasinal da sesión da BD.
     */
    public Conector(String url, String usr, String pass) {
        this.url = url;
        this.pass = pass;
        this.usr = usr;
    }
    
    /**
     * Establece conexión directamente coas crecendiales almacenadas
     * en <code>this</code>.
     */
    public Conector() {
        this.url = urlP;
        this.pass = passP;
        this.usr = usrP;
    }

    /**
     * Devolve un obxecto de tipo <code>ResultSet</code> co resultado da consulta
     * previamente realizada.
     * @return Resultado da consulta.
     * @see java.sql.ResultSet
     * @see java.sql.DriverManager
     * @see java.sql.Connection
     * @see java.sql.Connection
     */
    public ResultSet getResultSet() {
        return rs;
    }

    /**
     * Executa a consulta SQL de lectura de datos 
     * para a consexión establecia por <code>this</code>.
     * @param consulta Consulta SQL que se pretende realizar.
     * @return Si consulta realizada con éxito.
     * @see java.sql.ResultSet
     * @see java.sql.DriverManager
     * @see java.sql.Connection
     * @see java.sql.Connection
     */
    public boolean setQuery(String consulta) {
        boolean control = true;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            con = DriverManager.getConnection(url, usr, pass);
            st = con.createStatement();
            rs = st.executeQuery(consulta);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro.");
            control = false;
            System.out.println(e.getMessage());
        }
        return control;
    }
    
    
    /**
     * Executa a consulta SQL de actualización de datos
     * para a consexión establecia por <code>this</code>.
     * @param consulta Consulta SQL que se pretende realizar.
     * @return Si consulta realizada con éxito.
     * @see java.sql.ResultSet
     * @see java.sql.DriverManager
     * @see java.sql.Connection
     * @see java.sql.Connection
     */
    public boolean setUpdate(String consulta) {
        boolean control = true;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            con = DriverManager.getConnection(url, usr, pass);
            st = con.createStatement();
            st.executeUpdate(consulta);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro.");
            control = false;
            System.out.println(e.getMessage());
        }
        return control;

    }

    /**
     * Pecha todas as conexión establecidas por <code>this</code>.
     * @return Si o peche foi correcto.
     */
    public boolean close() {
        boolean control;
        try {
            control = true;
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            control = false;
        }
        return control;
    }

}
