package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtTemaLocal")
public class DtTemaLocal extends DtTema {

    public String directorio;

    public DtTemaLocal(int reproducciones, String directorio, String nombre, DtTime duracion, int ubicacion) {
        super(reproducciones, nombre, duracion, ubicacion);
        this.directorio = directorio;
    }

    public String getDirectorio() {
        return directorio;
    }

}
