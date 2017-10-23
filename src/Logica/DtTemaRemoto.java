
package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtTemaRemoto extends DtTema {

    public   String url;

    public DtTemaRemoto(String url, String nombre, DtTime duracion, int ubicacion) {
        super(nombre, duracion, ubicacion);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
