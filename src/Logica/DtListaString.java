package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaString {

    ArrayList<String> string;

    public DtListaString() {
        this.string = null;
    }

    public DtListaString(ArrayList<String> string) {
        this.string = string;
    }

    public ArrayList<String> getString() {
        return string;
    }

    public void setString(ArrayList<String> string) {
        this.string = string;
    }

}
