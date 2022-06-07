package usuarios;

import nucleo.Semente;

/**
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public class UsrAdmin extends Usuario {

    public UsrAdmin(String nome, String contrasinal) {
        super(nome, contrasinal);
    }

    /**
     * Amosa os usuario rexistrados na BD.
     * @return lista de usuarios rexistrados na BD.
     * @see usuarios.Sesion
     */
    public String verUsuariosRexistrados() {
        return Sesion.obterUsuariosRexistrados();
    }

    /**
     * Elimina a un usuario da BD.
     * @param nome do usuario a eliminar.
     * @return si eliminado con éxito.
     * @see usuarios.Sesion
     */
    public boolean borrarUsuario(String nome) {
        return Sesion.getUsuariosRexistrados().remove(Sesion.obterUsuarioPorSobrenome(nome));
    }

    
    /**
     * Engade unha semente ao conxunto de sementes dispoñibles.
     * @param nome da semente a engadir.
     * @return si engadido con éxito.
     */
    public boolean engadirSemente(String nome) {
        return Semente.getSementesDisponibles().add(new Semente(nome));
    }

}
