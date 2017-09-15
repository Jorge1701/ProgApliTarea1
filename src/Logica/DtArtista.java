package Logica;

public class DtArtista extends DtUsuario {

    private final String biografia;
    private final String web;

    public DtArtista(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen, String biografia, String web,String contrasenia) {
        super(nickname, nombre, apellido, email, fechaNac, imagen,contrasenia);
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
