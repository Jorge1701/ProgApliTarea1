package Logica;

public class DtAlbum {

    private String nickArtista;
    private String nombre;
    private int anio;
    private String imagen;

    public DtAlbum(String nickArtista, String nombre, int anio, String imagen) {
        this.nickArtista = nickArtista;
        this.nombre = nombre;
        this.anio = anio;
        this.imagen = imagen;
    }

    public String getNickArtista() {
        return nickArtista;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public String getImagen() {
        return imagen;
    }
}
