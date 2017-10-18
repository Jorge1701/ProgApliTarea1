package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtArtista extends DtUsuario {

    private final String biografia;
    private final String web;

    public DtArtista() {
        super("", "", "", "", null, "", "");
        this.biografia = "";
        this.web = "";
    }

    public DtArtista(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen, String biografia, String web, String contrasenia) {
        super(nickname, nombre, apellido, email, fechaNac, imagen, contrasenia);
        this.biografia = biografia;
        this.web = web;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getWeb() {
        return web;
    }
}
