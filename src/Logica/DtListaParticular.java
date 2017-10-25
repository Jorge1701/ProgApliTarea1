package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtListaParticular")
public class DtListaParticular extends DtLista {

    private final boolean privada;
    private final String nickDuenio;


    public DtListaParticular(boolean privada, String nombre, ArrayList<DtTema> temas, String imagen, DtFecha fecha, String nickDuenio) {
        super(nombre, temas, imagen, fecha);
        this.privada = privada;
        this.nickDuenio = nickDuenio;
    }

    public boolean isPrivada() {
        return privada;
    }
    
    public String getNickDuenio(){
        return nickDuenio;
    }
}
