package Logica;

public class TemaRemoto extends Tema {

    public String url;

    public TemaRemoto(Album a, String nombre, DtTime duracion, int ubicacion, String url) {
        super(a, nombre, duracion, ubicacion);
        this.url = url;
    }

    public TemaRemoto(String nombre, DtTime duracion, int ubicacion, String url) {
        super(nombre, duracion, ubicacion);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DtTemaRemoto getData() {
        DtTemaRemoto dtTemaR = new DtTemaRemoto(this.getUrl(), this.getNombre(), this.getDuracion(), this.getUbicacion());
        dtTemaR.setAlbum(this.getAlbum().getNombre());;
        dtTemaR.setArtista(this.getAlbum().getNickArtista());
        return dtTemaR;
    }
    
    

}
