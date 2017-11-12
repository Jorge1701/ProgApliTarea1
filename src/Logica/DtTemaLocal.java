package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtTemaLocal")
public class DtTemaLocal extends DtTema {

    private String directorio;
    private int descargas;

    public DtTemaLocal(int descargas, int reproducciones, String directorio, String nombre, DtTime duracion, int ubicacion) {
        super(reproducciones, nombre, duracion, ubicacion);
        this.descargas = descargas;
        this.directorio = directorio;
    }

    public DtTemaLocal() {

    }

    public String getDirectorio() {
        return directorio;
    }

    public int getDescargas() {
        return descargas;
    }
}
