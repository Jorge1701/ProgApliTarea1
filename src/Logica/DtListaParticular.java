package Logica;

import java.util.ArrayList;

public class DtListaParticular extends DtLista {

    private final boolean privada;

    public DtListaParticular(boolean privada, String nombre, ArrayList<DtTema> temas, String imagen) {
        super(nombre, temas, imagen);
        this.privada = privada;
    }

    public boolean isPrivada() {
        return privada;
    }
}
