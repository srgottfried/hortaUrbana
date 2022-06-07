package usuarios;

import nucleo.Horta;

/**
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public class UsrCliente extends Usuario {

    /**
     * Crea un usuario de tipo cliente.
     * @param nome Nome do usuario.
     * @param contrasinal Contrasinal do usuario
     */
    public UsrCliente(String nome, String contrasinal) {
        super(nome, contrasinal);
    }

    /**
     * Crea unha nova horta e vinculaa ao usuario. Cada usuario só poderá ter
     * unha única horta. As hortas créanse baleiras e logo van engadindo
     * diferentes plantíos.
     *
     * @return si creación correcta.
     * @see nucleo.Horta
     */
    public boolean crearHorta() {
        boolean creado;
        if (super.getHorta() == null) {
            super.setHorta(new Horta(this));
            creado = true;
        } else {
            creado = false;
        }
        return creado;
    }

    /**
     * Borra unha horta si existe.
     *
     * @return si borrado correcto.
     * @see nucleo.Horta
     */
    public boolean borrarHorta() {
        boolean borrado;
        if (super.getHorta() == null) {
            borrado = false;
        } else {
            super.setHorta(null);
            borrado = true;
        }
        return borrado;
    }
    
    /**
     * Borra un plantío por nome.
     * @param nome do plantío a borrar.
     * @return si borrado exitoso.
     */
    public boolean borrarPlantio(String nome) {
        return super.getHorta().borrarPlantio(nome);
    }

}
