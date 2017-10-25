package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtListaString")
public class DtListaString {

    ArrayList<String> string;

    public DtListaString() {
        this.string = null;
    }

    public DtListaString(ArrayList<String> string) {
        this.string = string;
    }

    public ArrayList<String> getGeneros() {
        return string;
    }

    public void setGeneros(ArrayList<String> string) {
        this.string = string;
    }

}
