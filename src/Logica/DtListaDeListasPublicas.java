/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Brian
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtListaDeListasPublicas")
public class DtListaDeListasPublicas {

    public ArrayList<DtListaParticular> getListas() {
        return listas;
    }

    public void setListas(ArrayList<DtListaParticular> listas) {
        this.listas = listas;
    }
    private ArrayList<DtListaParticular> listas ;
   
    public DtListaDeListasPublicas(){
    this.listas = null;
    
    }
    public DtListaDeListasPublicas(ArrayList<DtListaParticular> listas){
    this.listas = listas;
    }
    
}
