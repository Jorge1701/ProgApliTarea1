package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtListaDefecto")
public class DtListaDefecto extends DtLista {

    private final DtGenero genero;

    public DtListaDefecto(DtGenero genero, String nombre, ArrayList<DtTema> temas, String imagen, DtFecha fecha) {
        super(nombre, temas, imagen, fecha);
        this.genero = genero;
    }

    public DtGenero getGenero() {
        return genero;
    }

}
