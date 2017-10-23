package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaObjetos {

    private ArrayList<Object> lista;

    public DtListaObjetos(ArrayList<Object> lista) {
        this.lista = lista;
    }

    public ArrayList<Object> getLista() {
        return lista;
    }
}
