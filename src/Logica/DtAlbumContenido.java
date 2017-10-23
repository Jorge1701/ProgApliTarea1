package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtAlbumContenido {

    private DtAlbum info;
    private ArrayList<String> generos;
    private ArrayList<DtTema> temas;

    public DtAlbumContenido(DtAlbum info, ArrayList<String> generos, ArrayList<DtTema> temas) {
        this.info = info;
        this.generos = generos;
        this.temas = temas;
    }

    public DtAlbum getInfo() {
        return info;
    }

    public ArrayList<String> getGeneros() {
        return generos;
    }

    public ArrayList<DtTema> getTemas() {
        return ordenarPorPosicion(temas);
    }

    public String getGeneros2() {
        //Brian altaAlbum
        ArrayList<String> g = this.getGeneros();

        String Generos = "";
        for (int i = 0; i < g.size(); i++) {
            Generos = Generos + g.get(i) + " ";
        }
        return Generos;
    }

    private ArrayList<DtTema> ordenarPorPosicion(ArrayList<DtTema> tema) {
        Collections.sort(tema, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                if (((DtTema) o1).getUbicacion() == ((DtTema) o2).getUbicacion()) {
                    return 0;
                }
                return ((DtTema) o1).getUbicacion() < ((DtTema) o2).getUbicacion() ? -1 : 1;
            }
        });
        return tema;
    }

}
