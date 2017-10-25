package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtLista")
@XmlSeeAlso({DtListaDefecto.class, DtListaParticular.class})
public class DtLista extends DtBuscado {

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

    public DtLista() {
        this.nombre = null;
        this.temas = null;
        this.imagen = null;
        this.fecha = null;
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
