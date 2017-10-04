package Logica;

import java.util.ArrayList;

public class DtPerfilArtista extends DtPerfilUsuario {
    
    private final ArrayList<DtAlbum> albumes;
    private String web;
    private String biografia;
    
    public DtPerfilArtista(ArrayList<DtAlbum> albumes, DtUsuario info, ArrayList<DtCliente> seguidores,String biografia, String web) {
        super(info, seguidores);
        this.albumes = albumes;
        this.biografia = biografia;
        this.web = web;
    }
    public String getBiografia(){
    return biografia;
    }
    public String getWeb(){
    return web;
    }
    public ArrayList<DtAlbum> getAlbumes() {
        return albumes;
    }
   public DtPerfilArtista getInfoArtista(){
       DtPerfilArtista dt = new DtPerfilArtista(albumes, info, seguidores, biografia, web);
   return dt;
   }

}
