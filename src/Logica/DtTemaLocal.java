
package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtTemaLocal extends DtTema {
    
    public String directorio;

    public DtTemaLocal(String directorio, String nombre, DtTime duracion, int ubicacion) {
        super(nombre, duracion, ubicacion);
        this.directorio = directorio;
    }

    public String getDirectorio() {
        return directorio;
    }
    
    
}
