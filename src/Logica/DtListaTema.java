/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author brian
 */
public class DtListaTema {
    
    private ArrayList<DtTema> DtTemas ;

    public DtListaTema(ArrayList<DtTema> DtTemas) {
        this.DtTemas = DtTemas;
    }

    public ArrayList<DtTema> getDtTemas() {
        return DtTemas;
    }

    public void setDtTemas(ArrayList<DtTema> DtTemas) {
        this.DtTemas = DtTemas;
    }
    
    
    
}