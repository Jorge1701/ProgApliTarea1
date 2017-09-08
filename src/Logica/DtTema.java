package Logica;

public class DtTema {

    private String nombre;
    private DtTime duracion;
    private int ubicacion;
    private String album;
    private String artista;

    public DtTema(String nombre, DtTime duracion, int ubicacion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public DtTime getDuracion() {
        return duracion;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtista() {
        return artista;
    }
    
    
}
