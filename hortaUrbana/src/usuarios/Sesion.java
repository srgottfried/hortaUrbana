package usuarios;

import java.util.ArrayList;
import excepcions.*;
import java.time.LocalDateTime;

/**
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public class Sesion {

    /**
     * Array estático de usuarios da clase <code>Sesion</code>.
     */
    private static ArrayList<Usuario> usuariosRexistrados = new ArrayList<>();
    private Usuario sesionDe;
    private LocalDateTime inicioSesion;

    public static ArrayList<Usuario> getUsuariosRexistrados() {
        return usuariosRexistrados;
    }

    public Usuario getSesionDe() {
        return sesionDe;
    }

    public LocalDateTime getInicioSesion() {
        return inicioSesion;
    }

    /**
     * Inicia nova sesión si o usuario está resxitrado.
     *
     * @param sobrenome
     * @param contrasinal
     * @throws UsuarioNonAtopadoException
     */
    public Sesion(String sobrenome, String contrasinal) throws UsuarioNonAtopadoException {
        Usuario auxUsr;
        if (obterUsuarioPorSobrenome(sobrenome) instanceof UsrCliente) {
            auxUsr = new UsrCliente(sobrenome, contrasinal);
        } else if (obterUsuarioPorSobrenome(sobrenome) instanceof UsrAdmin) {
            auxUsr = new UsrAdmin(sobrenome, contrasinal);
        } else {
            auxUsr = new Usuario(sobrenome, contrasinal);
        }
        if (!usuariosRexistrados.contains(auxUsr)) {
            throw new UsuarioNonAtopadoException();
        } else {
            sesionDe = usuariosRexistrados.get(usuariosRexistrados.indexOf(auxUsr));
            inicioSesion = LocalDateTime.now();
        }
    }

    /**
     * Rexistra novo usuario no array estático de usuarios da clase
     * <code>Sesion</code>.
     *
     * @param sobrenome
     * @param contrasinal
     * @return
     */
    public static boolean rexistrarUsuario(String sobrenome, String contrasinal) {
        boolean exito;
        if (obterUsuarioPorSobrenome(sobrenome) == null) {
            usuariosRexistrados.add(new UsrCliente(sobrenome, contrasinal));
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    /**
     * Devolve o usuario en base ao nome (unívocamente determinado) que se
     * insire
     *
     * @param sobrenome do usuario unívocamente determinado
     * @return o usuario buscado
     */
    public static Usuario obterUsuarioPorSobrenome(String sobrenome) {
        Usuario usr = null;
        for (Usuario x : usuariosRexistrados) {
            if (x.getSobrenome().equals(sobrenome)) {
                usr = x;
                break;
            }
        }
        return usr;
    }

    /**
     * Amosa a lista de usuarios rexistreados na BD
     * @return lista de usuarios rexitrados na BD
     */
    public static String obterUsuariosRexistrados() {
        return usuariosRexistrados.toString();
    }
}
