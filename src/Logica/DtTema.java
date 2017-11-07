package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtTema")
@XmlSeeAlso({DtTemaLocal.class, DtTemaRemoto.class})
public class DtTema extends DtBuscado {

    private String nombre;
    private DtTime duracion;
    private int ubicacion;
    private String album;
    private String artista;

    private String imagenAlbum;

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

    public String getImagenAlbum() {
        return imagenAlbum;
    }

    public void setImagenAlbum(String imagenAlbum) {
        this.imagenAlbum = imagenAlbum;
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
