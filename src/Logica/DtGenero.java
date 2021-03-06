package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtGenero")
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
