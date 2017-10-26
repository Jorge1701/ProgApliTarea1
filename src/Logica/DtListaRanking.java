package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtListaRanking")
public class DtListaRanking {

    private ArrayList<DtRanking> ranking;

    public ArrayList<DtRanking> getRanking() {
        return ranking;
    }

    public void setRanking(ArrayList<DtRanking> ranking) {
        this.ranking = ranking;
    }

    public DtListaRanking() {
        this.ranking = null;

    }

    public DtListaRanking(ArrayList<DtRanking> ranking) {
        this.ranking = ranking;
    }

}
