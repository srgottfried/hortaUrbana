package datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import nucleo.Plantio;
import nucleo.Semente;
import usuarios.Sesion;
import usuarios.UsrCliente;

/**
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public class Datos {


    /**
     * Carga os datos precisos para o funcionamento do aplicativo.
     */
    public Datos() {
        cargarUsuarios();
        cargarSementes();
    }

    /**
     * Carga os usuario dende a BD.
     */
    private void cargarUsuarios() {
        Conector c = new Conector();
        c.setQuery("select sobrenome, contrasinal from usuarios");
        try {
            while (c.getResultSet().next()) {
                Sesion.getUsuariosRexistrados().add(new UsrCliente(c.getResultSet().getString(1), c.getResultSet().getString(2)));
            }
        } catch (SQLException e) {

        }
        c.close();

    }
    
    public static boolean exportarDatos(Sesion sesion) {
        String uri = "export\\horta_de_" + sesion.getSesionDe().getSobrenome() + ".txt";
        File f = new File(uri);
        boolean control = false;
        try (FileWriter fw = new FileWriter(f)) {
            for (Plantio x : sesion.getSesionDe().getHorta().getPlantios()) {
                fw.write(x.getNome()
                        + "\nSemente plantada: " + x.getSemente()
                        + "\nExtensión en setctores: " + x.getNumSectores()
                        + "\nData de plantación: " + x.getDataPlantacion()
                        + "\nData de colleita: " + x.getDataColleita()
                        +"\n\n"
                );
                
            }
            control = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return control;
    }

    /**
     * Carga as sementes dende a BD.
     */
    private void cargarSementes() {
        Conector c = new Conector();
        c.setQuery("select * from sementes");
        try {
            while (c.getResultSet().next()) {
                Semente.getSementesDisponibles().add(new Semente(
                        c.getResultSet().getString(2), 
                        c.getResultSet().getInt(4), 
                        c.getResultSet().getInt(3), 
                        c.getResultSet().getDouble(5), 
                        c.getResultSet().getLong(7),
                        c.getResultSet().getDouble(6))
                );
            }
        } catch (SQLException e) {

        }
        c.close();
        
    }
    
    /**
     * 
     * @param sesion
     * @return Cadea con rexistro de sesións.
     */
    public static String[] queryRegistrosSesion(Sesion sesion) {
        Conector c = new Conector();
        ArrayList<String> dataInicioSesion = new ArrayList<>();
        
        c.setUpdate("insert into historico_inicios_sesion values (null, (select id_usuario from usuarios where sobrenome = '" + sesion.getSesionDe().getSobrenome() + "'), current_timestamp() )");
        c.setQuery("select data_mensaxe from historico_inicios_sesion where usuario = (select id_usuario from usuarios where sobrenome = '" + sesion.getSesionDe().getSobrenome() + "') order by data_mensaxe desc");
        try {
            while (c.getResultSet().next()) {
                dataInicioSesion.add(c.getResultSet().getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        int i = 0;
        String[] ses = new String[dataInicioSesion.size()];
        for (String x : dataInicioSesion) {
            ses[i] = x;
            i++;
        }
        
        c.close();
        return ses;
    }
    
   
}
