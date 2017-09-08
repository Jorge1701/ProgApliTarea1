package Logica;

import Persistencia.BDLista;
import java.util.ArrayList;

public class ListaParticular extends Lista {

    private String nickDuenio;
    private boolean privada;

    public ListaParticular(String nickDuenio, boolean privada, String nombre, ArrayList<Tema> temas, String imagen) {
        super(nombre, temas, imagen);
        this.privada = privada;
        this.nickDuenio = nickDuenio;
    }

    public ListaParticular(String nombre, String imagen) {
        super(nombre, new ArrayList<>(), imagen);
        this.privada = true;
        this.nickDuenio = nickDuenio;
    }

    public String getDuenio() {
        return nickDuenio;
    }

    @Override
    public DtLista getData() {
        return new DtListaParticular(isPrivada(), getNombre(), getTemas(), getImagen());
    }

    public boolean isPrivada() {
        return privada;
    }

    public void setPrivada(boolean privada) {
        this.privada = privada;
    }

    public boolean quitarTema(String nombreT) {

        for (int i = 0; i < temas.size(); i++) {
            Tema t = (Tema) temas.get(i);
            if (t.getNombre().equals(nombreT)) {
                BDLista bdLista = new BDLista();
                bdLista.quitarTemaLista(nickDuenio, this.getNombre(), nombreT);
                temas.remove(t);
                return true;
                //return temas.remove(t);
            }
        }
        return false;

    }

    public boolean agregarTema(Tema tema) {

        for (int i = 0; i < temas.size(); i++) {
            if (temas.get(i).getNombre().equals(tema.getNombre())) {
                return false;
            }
        }
        this.temas.add(tema);
        return true;
    }
}
