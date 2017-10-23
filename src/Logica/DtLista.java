package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtLista {

    private final String nombre;
    private final ArrayList<DtTema> temas;
    private final String imagen;
    private final DtFecha fecha;

    public DtLista(String nombre, ArrayList<DtTema> temas, String imagen, DtFecha fecha) {
        this.nombre = nombre;
        this.temas = temas;
        this.imagen = imagen;
        this.fecha = fecha;
    }

    public DtFecha getFecha() {
        return fecha;
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
