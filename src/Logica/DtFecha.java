package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtFecha {

    //@XmlElement(name = "dia")
    protected final int dia;
    //@XmlElement(name = "mes")
    protected final int mes;
    //@XmlElement(name = "anio")
    protected final int anio;

    public DtFecha() {
        dia = 1;
        mes = 1;
        anio = 1;
    }

    public DtFecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAnio() {
        return this.anio;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}
