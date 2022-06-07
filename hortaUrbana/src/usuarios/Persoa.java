package usuarios;

/**
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public abstract class Persoa{
    private String nomeCompleto;
    private String dni;
    private String telefono;
    
    
    
    public Persoa() {
        
    }
    
    public Persoa(String nomeCompleto, String dni, String telefono) {
        this.nomeCompleto = nomeCompleto;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
