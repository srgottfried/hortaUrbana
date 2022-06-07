package nucleo;

import datos.Conector;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import usuarios.UsrCliente;
import usuarios.Usuario;

/**
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public class Plantio {

    private String nome;
    private Semente semente;
    private LocalDate dataPlantacion;
    private LocalDate dataColleita;
    private UsrCliente propietario;
    /**
     * Cada sector representa un cadrado de 1x1 que conceptualiza a unidade de
     * referencia para a extensión do plantío.
     */
    private int numSectores;

    /**
     * Xera un obxecto de tipo plantío.
     *
     * @param nome da semente
     * @param semente que se planta
     * @param numeroSementes número de sementes por plantío.
     * @param propietario
     */
    public Plantio(String nome, Semente semente, int numeroSementes, Usuario propietario) {
        this.nome = nome;
        this.semente = semente;
        this.numSectores = semente.getEspazoVital() * numeroSementes;
        dataPlantacion = LocalDate.now();
        this.dataColleita = dataPlantacion.plusDays(semente.getTempoCrecemento());
        this.propietario = (UsrCliente) propietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Semente getSemente() {
        return semente;
    }

    public void setSemente(Semente semente) {
        this.semente = semente;
    }

    public LocalDate getDataPlantacion() {
        return dataPlantacion;
    }

    public LocalDate getDataColleita() {
        return dataColleita;
    }

    public int getNumSectores() {
        return numSectores;
    }

    /**
     * Amosa a porcentaxe de tempo ata a colleita.
     *
     * @return porcentaxe de tempo ata a colleita.
     */
    public int porcentaxeCrecemeto() {
        Conector c = new Conector();
        c.setQuery("select data_plantacion from plantios where nome = '" + this.nome 
                + "' and usuario = (select id_usuario from usuarios where sobrenome = '" +
                this.propietario +"')");
        try {
            while (c.getResultSet().next()) {
                dataPlantacion = c.getResultSet().getDate(1).toLocalDate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c.close();
        
        int tempoCrecemento = (int) this.getSemente().getTempoCrecemento();
        
        return (int) Math.round((double)(dataPlantacion.until(LocalDate.now()).getDays()) / tempoCrecemento * 100);

    }

    public UsrCliente getPropietario() {
        return propietario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.propietario);
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
        final Plantio other = (Plantio) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.propietario, other.propietario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plantio{" + "nome=" + nome + ", semente=" + semente + ", extension=" + numSectores + ", colleita=" + dataColleita.toString() + "}";
    }

}
