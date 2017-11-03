package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class TemaRemoto extends Tema {

    public String url;

    public TemaRemoto(int reproducciones, Album a, String nombre, DtTime duracion, int ubicacion, String url) {
        super(reproducciones, a, nombre, duracion, ubicacion);
        this.url = url;
    }

    public TemaRemoto(int reproducciones, String nombre, DtTime duracion, int ubicacion, String url) {
        super(reproducciones, nombre, duracion, ubicacion);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DtTemaRemoto getData() {
        DtTemaRemoto dtTemaR = new DtTemaRemoto(getReproducciones(), this.getUrl(), this.getNombre(), this.getDuracion(), this.getUbicacion());
        dtTemaR.setAlbum(this.getAlbum().getNombre());;
        dtTemaR.setArtista(this.getAlbum().getNickArtista());
        return dtTemaR;
    }

}
