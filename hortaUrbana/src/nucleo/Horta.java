package nucleo;

import datos.Conector;
import usuarios.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import usuarios.Sesion;

/**
 * A clase <code>Horta</code> aglutina un conxunto de plantíos.
 *
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public class Horta {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Plantio> plantios;
    private Usuario propietario;
    private double augaRequire;
    private double nutrientesRequire;
    private int numSectores;

    /**
     * Xera una horta ligada a un usuaio.
     *
     * @param usuario
     * @see usuarios.Usuario
     */
    public Horta(Usuario usuario) {
        plantios = new ArrayList<>();
        propietario = usuario;
        usuario.setHorta(this);
    }

    /**
     * Xera una horta ligada a un usuaio.
     *
     * @param usuario
     * @param nomePlantio
     * @param semente
     * @param numSectores
     * @see usuarios.Usuario
     */
    public Horta(Usuario usuario, String nomePlantio, Semente semente, int numSectores) {
        plantios = new ArrayList<>();
        propietario = usuario;
        usuario.setHorta(this);
        engadirPlantio(nomePlantio, semente, numSectores);
    }

    public ArrayList<Plantio> getPlantios() {
        return plantios;
    }

    public void setPlantios(ArrayList<Plantio> plantios) {
        this.plantios = plantios;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public double getAugaRequire() {
        return augaRequire;
    }

    public void setAugaRequire(double augaRequire) {
        this.augaRequire = augaRequire;
    }

    public double getNutrientesRequire() {
        return nutrientesRequire;
    }

    public void setNutrientesRequire(double nutrientesRequire) {
        this.nutrientesRequire = nutrientesRequire;
    }

    /**
     * Engade un plantío á horta do usuario.
     *
     * @param nome Nome do plantío.
     * @param semente Semente elixida.
     * @param numSementes Número de sementes a plantar.
     * @return Si éxito.
     */
    public boolean engadirPlantio(String nome, Semente semente, int numSementes) {
        boolean control = true;
        try {
            Plantio auxP = new Plantio(nome, semente, numSementes, this.getPropietario());
            plantios.add(auxP);
            numSectores += auxP.getNumSectores();
        } catch (Exception e) {
            control = false;
            System.out.println("erro");
        }
        return control;
    }

    /**
     * Borra plantío por nome.
     *
     * @param nome do plantío.
     * @return si borrado exitoso.
     */
    public boolean borrarPlantio(String nome) {
        boolean exito = false;
        Plantio auxPlantio = buscarPlantioPorNome(this.getPropietario().getSobrenome(), nome);
        if (auxPlantio != null) {
            plantios.remove(auxPlantio);
            exito = true;
        }
        if (exito) {
            Conector c = new Conector();
            c.setUpdate("call eliminar_plantio('" + this.getPropietario() + "','" + nome + "', @ok)");
            c.close();
        }
        return exito;
    }

    /**
     * Determina os requisitos fotosintéticos totales da horta derivados dos
     * diferentes plantíos
     *
     * @return requisitos fotosintéticos
     * @see nucleo.Semente
     */
    public String requerimentosFotosinteticos() {
        //actualizamos requerimentos fotosinteticos
        for (Plantio x : plantios) {
            augaRequire += x.getSemente().getCantidadeAuga();
            nutrientesRequire += x.getSemente().getCantidadeNutrientes();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("auga (ml/día): ").append(augaRequire);
        sb.append("\nnutrientes (g/día): ").append(nutrientesRequire);

        return sb.toString();
    }


    /**
     * Busca un plantío na lista de plantíos a través do seu nome
     *
     * @param nome Nome do plantío a buscar.
     * @return Plantío buscado.
     */
    public Plantio buscarPlantioPorNome(String propietario, String nome) {
        Plantio auxPlantio = null;
        for (Plantio x : plantios) {
            if (x.getNome().equals(nome) && ((Usuario)x.getPropietario()).getSobrenome().equals(propietario)) {
                auxPlantio = x;
            }
        }
        return auxPlantio;
    }

    
    
    public int getNumSectores() {
        return numSectores;
    }

    /**
     * Obtén un <code>String[]</code> coa lista de plantiós almacenados no aplicativo.
     * @return 
     */
    public String[] getListaPlantios() {
        Iterator<Plantio> i = plantios.iterator();
        String[] str = new String[plantios.size()];
        int c = 0;
        while (i.hasNext()) {
            str[c] = i.next().getNome();
            c++;
        }
        return str;
    }

    @Override
    public String toString() {
        return "Horta (" + numSectores + "sectores) {" + "plantios=" + plantios + '}';
    }

}
