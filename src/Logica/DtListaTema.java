/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author brian
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaTema {

    private ArrayList<DtTema> DtTemas;

    public DtListaTema(ArrayList<DtTema> DtTemas) {
        this.DtTemas = DtTemas;
    }

    public DtListaTema() {

    }

    public ArrayList<DtTema> getDtTemas() {
        return DtTemas;
    }

    public void setDtTemas(ArrayList<DtTema> DtTemas) {
        this.DtTemas = DtTemas;
    }

}
