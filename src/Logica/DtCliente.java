package Logica;

public class DtCliente extends DtUsuario {

    private Suscripcion suscripcion;

    public DtCliente(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen, String contrasenia, Suscripcion suscripcion) {
        super(nickname, nombre, apellido, email, fechaNac, imagen, contrasenia);
        this.suscripcion = suscripcion;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

}
