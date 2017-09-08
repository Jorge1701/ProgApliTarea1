package Logica;

import java.util.ArrayList;

public class DtGenero {
    
    private String nombre;
    private ArrayList<DtGenero> subGeneros;

    public DtGenero(String nombre, ArrayList<DtGenero> subGeneros) {
        this.nombre = nombre;
        this.subGeneros = subGeneros;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<DtGenero> getSubGeneros() {
        return subGeneros;
    }
}
