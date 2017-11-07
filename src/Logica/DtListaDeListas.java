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
 * @author brian
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtListaDeListas")
public class DtListaDeListas {

    public ArrayList<DtLista> getListas() {
        return listas;
    }

    public void setListas(ArrayList<DtLista> listas) {
        this.listas = listas;
    }
    private ArrayList<DtLista> listas ;
   
    public DtListaDeListas(){
    this.listas = null;
    
    }
    public DtListaDeListas(ArrayList<DtLista> listas){
    this.listas = listas;
    }
    
}
