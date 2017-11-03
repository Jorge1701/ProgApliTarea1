package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class TemaLocal extends Tema {

    public String directorio;

    public TemaLocal(int reproducciones, Album a, String directorio, String nombre, DtTime duracion, int ubicacion) {
        super(reproducciones, a, nombre, duracion, ubicacion);
        this.directorio = directorio;
    }

    public TemaLocal(int reproducciones, String directorio, String nombre, DtTime duracion, int ubicacion) {
        super(reproducciones, nombre, duracion, ubicacion);
        this.directorio = directorio;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }

    public DtTemaLocal getData() {
        DtTemaLocal dtTemaL = new DtTemaLocal(getReproducciones(), this.getDirectorio(), this.getNombre(), this.getDuracion(), this.getUbicacion());
        dtTemaL.setAlbum(this.getAlbum().getNombre());
        dtTemaL.setArtista(this.getAlbum().getNickArtista());
        dtTemaL.setImagenAlbum(this.getAlbum().getImagen());
        return dtTemaL;
    }
}
