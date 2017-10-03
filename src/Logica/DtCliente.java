package Logica;

import java.util.ArrayList;

public class DtCliente extends DtUsuario {

    private final ArrayList<DtSuscripcion> suscripciones;
    private final DtSuscripcion actual;

    public DtCliente(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen, String contrasenia, DtSuscripcion suscripcion) {
        super(nickname, nombre, apellido, email, fechaNac, imagen, contrasenia);
        this.suscripciones = new ArrayList<>();
        this.actual = suscripcion;
    }
    
    public DtCliente(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen, String contrasenia, DtSuscripcion suscripcion, ArrayList<DtSuscripcion> suscripciones) {
        super(nickname, nombre, apellido, email, fechaNac, imagen, contrasenia);
        this.actual = suscripcion;
        this.suscripciones = suscripciones;
    }

    public ArrayList<DtSuscripcion> getSuscripciones() {
        return suscripciones;
    }

    public DtSuscripcion getSuscripcion() {
        return actual;
    }

    public String getTipo() {
        return "Cliente";
    }

}
