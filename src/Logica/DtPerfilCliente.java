package Logica;

import java.util.ArrayList;

public class DtPerfilCliente extends DtPerfilUsuario{
    
    private final ArrayList<DtUsuario> seguidos;
    
    private final ArrayList<DtListaParticular> listasCreadas;
    private final ArrayList<DtAlbum> albumes;
    private final ArrayList<DtLista> listasFavoritas;
    private final ArrayList<DtTema> temas;

    public DtPerfilCliente(ArrayList<DtUsuario> seguidos, ArrayList<DtListaParticular> listasCreadas, ArrayList<DtAlbum> albumes, ArrayList<DtLista> listasFavoritas, ArrayList<DtTema> temas, DtUsuario info, ArrayList<DtCliente> seguidores) {
        super(info, seguidores);
        this.seguidos = seguidos;
        this.listasCreadas = listasCreadas;
        this.albumes = albumes;
        this.listasFavoritas = listasFavoritas;
        this.temas = temas;
    }

    public ArrayList<DtUsuario> getSeguidos() {
        return seguidos;
    }

    public ArrayList<DtListaParticular> getListasCreadas() {
        return listasCreadas;
    }

    public ArrayList<DtAlbum> getAlbumes() {
        return albumes;
    }

    public ArrayList<DtLista> getListasFavoritas() {
        return listasFavoritas;
    }

    public ArrayList<DtTema> getTemas() {
        return temas;
    }
}
