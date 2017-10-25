package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtListaBuscados")
public class DtListaBuscados {

    private ArrayList<DtBuscado> lista;

    public DtListaBuscados(ArrayList<DtBuscado> lista) {
        this.lista = lista;
    }

    public ArrayList<DtBuscado> getLista() {
        return lista;
    }
}
