package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class TemaLocal extends Tema {

    private String directorio;
    private int descargas;

    public TemaLocal(int descargas, int reproducciones, Album a, String directorio, String nombre, DtTime duracion, int ubicacion) {
        super(reproducciones, a, nombre, duracion, ubicacion);
        this.directorio = directorio;
        this.descargas = descargas;
    }

    public TemaLocal(int descargas, int reproducciones, String directorio, String nombre, DtTime duracion, int ubicacion) {
        super(reproducciones, nombre, duracion, ubicacion);
        this.directorio = directorio;
        this.descargas = descargas;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void descarga() {
        descargas++;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }

    public int getDescargas() {
        return descargas;
    }

    public DtTemaLocal getData() {
        DtTemaLocal dtTemaL = new DtTemaLocal(getDescargas(), getReproducciones(), this.getDirectorio(), this.getNombre(), this.getDuracion(), this.getUbicacion());
        dtTemaL.setAlbum(this.getAlbum().getNombre());
        dtTemaL.setArtista(this.getAlbum().getNickArtista());
        dtTemaL.setImagenAlbum(this.getAlbum().getImagen());
        return dtTemaL;
    }
}
