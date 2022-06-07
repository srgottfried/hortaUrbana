package usuarios;

import java.util.Objects;
import nucleo.Horta;

/**
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public class Usuario extends Persoa {

    private String sobrenome;
    private String contrasinal;
    private Horta horta;

    /**
     * Crea un usuario.
     * @param sobrenome Nome de usuario.
     * @param contrasinal Contrasinal de usuario.
     */
    public Usuario(String sobrenome, String contrasinal) {
        this.sobrenome = sobrenome;
        this.contrasinal = contrasinal;
    }
    /**
     * Crea un usuario.
     * @param sobrenome Nome de usuario.
     * @param contrasinal Contrasinal de usuario.
     * @param nomeCompleto
     * @param dni
     * @param telefono
     */
    public Usuario(String sobrenome, String contrasinal, String nomeCompleto, String dni, String telefono) {
        super(nomeCompleto, dni, telefono);
        this.sobrenome = sobrenome;
        this.contrasinal = contrasinal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.sobrenome);
        hash = 97 * hash + Objects.hashCode(this.contrasinal);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.sobrenome, other.sobrenome)) {
            return false;
        }
        if (!Objects.equals(this.contrasinal, other.contrasinal)) {
            return false;
        }
        return true;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getContrasinal() {
        return contrasinal;
    }

    public void setContrasinal(String contrasinal) {
        this.contrasinal = contrasinal;
    }

    public Horta getHorta() {
        return horta;
    }

    public void setHorta(Horta horta) {
        this.horta = horta;
    }

    
    @Override
    public String toString() {
        return sobrenome;
    }
    
    

}
