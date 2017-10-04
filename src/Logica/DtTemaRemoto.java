
package Logica;


public class DtTemaRemoto extends DtTema {

    public   String url;

    public DtTemaRemoto(String url, String nombre, DtTime duracion, int ubicacion) {
        super(nombre, duracion, ubicacion);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
