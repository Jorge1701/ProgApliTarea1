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
public class DtListaAlbum {

    private ArrayList<DtAlbum> album;

    public DtListaAlbum(ArrayList<DtAlbum> album) {
        this.album = album;
    }

    public ArrayList<DtAlbum> getAlbum() {
        return album;
    }

    public void setAlbum(ArrayList<DtAlbum> album) {
        this.album = album;
    }

    public DtListaAlbum() {
        this.album = null;
    }

}
