package nucleo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public class Semente {

    /**
     * Conxunto de sementes dispoñibles na BD.
     */
    private static Set<Semente> sementesDisponibles = new HashSet<>();

    private String nome;
    private long tempoCrecemento; // días
    private int espazoVital; // sectores
    private double cantidadeAuga; // litros/s
    private double cantidadeLuz; // s/dia
    private double cantidadeNutrientes; // kg/s

    /**
     * Instancia semente a partir de nome.
     * @param nome da semente.
     */
    public Semente(String nome) {
        this.nome = nome;

    }

    /**
     * Instancia semente a partir dos parámetros seguintes
     * @param nome Nome da semente.
     * @param tempoCrecemento Tempo que tarda a semente en dar froitos.
     * @param espazoVital Espazo necesario para o correcto crecemento. Unidades: sectores.
     * @param cantidadeAuga Cantidade de auga necesaria por unidade de tempo. Unidades: ml/día.
     * @param cantidadeLuz Cantidade de luz necesaria por día. Unidades: horas/día.
     * @param cantidadeNutrientes Cantidade de nutrientes encesarios por unidade de tempo. Unidades: g/día.
     */
    public Semente(String nome, long tempoCrecemento, int espazoVital, double cantidadeAuga, long cantidadeLuz, double cantidadeNutrientes) {
        this.nome = nome;
        this.tempoCrecemento = tempoCrecemento;
        this.espazoVital = espazoVital;
        this.cantidadeAuga = cantidadeAuga;
        this.cantidadeLuz = cantidadeLuz;
        this.cantidadeNutrientes = cantidadeNutrientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTempoCrecemento() {
        return tempoCrecemento;
    }

    public void setTempoCrecemento(long tempoCrecemento) {
        this.tempoCrecemento = tempoCrecemento;
    }

    public int getEspazoVital() {
        return espazoVital;
    }

    public void setEspazoVital(int espazoVital) {
        this.espazoVital = espazoVital;
    }

    public double getCantidadeAuga() {
        return cantidadeAuga;
    }

    public void setCantidadeAuga(double cantidadeAuga) {
        this.cantidadeAuga = cantidadeAuga;
    }

    public double getCantidadeLuz() {
        return cantidadeLuz;
    }

    public void setCantidadeLuz(double cantidadeLuz) {
        this.cantidadeLuz = cantidadeLuz;
    }

    public double getCantidadeNutrientes() {
        return cantidadeNutrientes;
    }

    public void setCantidadeNutrientes(double cantidadeNutrientes) {
        this.cantidadeNutrientes = cantidadeNutrientes;
    }

    public static Set<Semente> getSementesDisponibles() {
        return sementesDisponibles;
    }
    
    /**
     * Devolve o obxecto semente que ten por nome <code>nome</code>.
     * @param nome
     * @return 
     */
    public static Semente getSementePorNome(String nome) {
        Semente auxSemente = null;
        for (Semente s : sementesDisponibles) {
            if (s.getNome().equals(nome)) {
                auxSemente = s;
            }
        }
        return auxSemente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Semente other = (Semente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
