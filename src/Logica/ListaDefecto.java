package Logica;

import Persistencia.BDLista;
import java.util.ArrayList;

public class ListaDefecto extends Lista {

    private Genero genero;

    public ListaDefecto(Genero genero, String nombre, ArrayList<Tema> temas, String imagen, DtFecha fecha) {
        super(nombre, temas, imagen, fecha);
        this.genero = genero;
    }

    @Override
    public DtLista getData() {
        return new DtListaDefecto(genero.getData(), getNombre(), getTemas(), getImagen(), getFecha());
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean quitarTema(String nombreT) {

        for (int i = 0; i < temas.size(); i++) {
            Tema t = (Tema) temas.get(i);
            if (t.getNombre().equals(nombreT)) {
                BDLista bdLista = new BDLista();
                bdLista.quitarTemaLista(null, this.getNombre(), nombreT);
                this.temas.remove(t);
                return true;
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
