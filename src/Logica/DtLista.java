package Logica;

import java.util.ArrayList;

public class DtLista {

    private final String nombre;
    private final ArrayList<DtTema> temas;
    private final String imagen;

    public DtLista(String nombre, ArrayList<DtTema> temas, String imagen) {
        this.nombre = nombre;
        this.temas = temas;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<DtTema> getTemas() {
        return temas;
    }

    public String getImagen() {
        return imagen;
    }
}
