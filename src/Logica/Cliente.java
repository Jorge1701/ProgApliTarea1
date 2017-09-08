package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cliente extends Usuario {

    private HashMap<String, Usuario> seguidos;
    private HashMap<String, ListaParticular> listasParticulares;

    private ArrayList<Album> albumesfav;
    private ArrayList<Lista> listasfav;
    private ArrayList<Tema> temasfav;

    public Cliente(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen) {
        super(nickname, nombre, apellido, email, fechaNac, imagen);

        this.seguidos = new HashMap();
        this.listasParticulares = new HashMap<String, ListaParticular>();
        this.albumesfav = new ArrayList<>();
        this.listasfav = new ArrayList<>();
        this.temasfav = new ArrayList<>();
    }

    public int agregarAlbumFav(Album a) {
        if (albumesfav.contains(a)) {
            throw new UnsupportedOperationException("Album ya en favoritos");
        } else {
            albumesfav.add(a);
            return albumesfav.indexOf(a);
        }
    }

    public int agregarListaFav(Lista l) {
        if (listasfav.contains(l)) {
            throw new UnsupportedOperationException("Lista ya en favoritos");
        } else {
            listasfav.add(l);
            return listasfav.indexOf(l);
        }
    }

    public int agregarTemaFav(Tema t) {
        if (temasfav.contains(t)) {
            throw new UnsupportedOperationException("Tema ya en favoritos");
        } else {
            temasfav.add(t);
            return temasfav.indexOf(t);
        }
    }

    public void agregarLista(Lista l) {
        this.listasParticulares.put(l.getNombre(), (ListaParticular) l);
    }

    public void eliminarAlbumFav(int i) {
        if (albumesfav.size() >= i) {
            albumesfav.remove(i);
        } else {
            throw new UnsupportedOperationException("Album no esta en favoritos");
        }
    }

    public void eliminarListaFav(int i) {
        if (listasfav.size() >= i) {
            listasfav.remove(i);
        } else {
            throw new UnsupportedOperationException("Lista no esta en favoritos");
        }
    }

    public void eliminarTemaFav(int i) {
        if (temasfav.size() >= i) {
            temasfav.remove(i);
        } else {
            throw new UnsupportedOperationException("Tema no esta en favoritos");
        }
    }

    public ArrayList<DtAlbum> obtenerDtAlbumesFav() {
        ArrayList<DtAlbum> favs = new ArrayList<>();
        for (Album album : albumesfav) {
            favs.add(album.getData());
        }
        return favs;
    }

    public ArrayList<DtLista> obtenerDtListasFav() {
        ArrayList<DtLista> favs = new ArrayList<>();
        for (Lista lista : listasfav) {
            favs.add(lista.getData());
        }
        return favs;
    }

    public ArrayList<DtTema> obtenerDtTemasFav() {
        ArrayList<DtTema> favs = new ArrayList<>();
        for (Tema tema : temasfav) {
            favs.add(tema.getData());
        }
        return favs;
    }

    public ArrayList<Album> obtenerAlbumsFav() {
        return albumesfav;
    }

    public ArrayList<Lista> obtenerListasFav() {
        return listasfav;
    }

    public ArrayList<Tema> obtenerTemasFav() {
        return temasfav;
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }

    @Override
    public DtCliente getData() {
        return new DtCliente(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNac(), getImagen());
    }

    @Override
    public DtPerfilUsuario obtenerPerfil() {
        DtUsuario info = getData();
        ArrayList<DtCliente> dtSeguidores = getSeguidores();
        ArrayList<DtUsuario> dtSeguidos = new ArrayList<>();
        ArrayList<DtListaParticular> dtListasCreadas = new ArrayList<>();
        ArrayList<DtAlbum> dtAlbumes = new ArrayList<>();
        ArrayList<DtLista> dtListas = new ArrayList<>();
        ArrayList<DtTema> dtTemas = new ArrayList<>();

        Iterator i = listasParticulares.entrySet().iterator();
        while (i.hasNext()) {
            ListaParticular p = (ListaParticular) ((Map.Entry) i.next()).getValue();
            dtListasCreadas.add((DtListaParticular) p.getData());
        }

        for (Album a : this.albumesfav) {
            dtAlbumes.add(a.getData());
        }

        for (Lista l : this.listasfav) {
            dtListas.add(l.getData());
        }

        for (Tema t : this.temasfav) {
            dtTemas.add(t.getData());
        }

        Iterator i2 = this.seguidos.entrySet().iterator();
        while (i2.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i2.next()).getValue();
            dtSeguidos.add(u.getData());
        }

        return new DtPerfilCliente(dtSeguidos, dtListasCreadas, dtAlbumes, dtListas, dtTemas, info, dtSeguidores);
    }

    public boolean agregar(Usuario u) {
        if (seguidos.get(u.getNickname()) != null) {
            return false;
        }
        if (!u.meComenzoASeguir(this)) {
            return false;
        }
        seguidos.put(u.getNickname(), u);
        return true;
    }

    public boolean dejarSeguir(Usuario u) {
        if (seguidos.get(u.getNickname()) == null) {
            return false;
        }
        if (!u.meDejoDeSeguir(this)) {
            return false;
        }
        seguidos.remove(u.getNickname());
        return true;
    }

    public HashMap<String, Usuario> getSeguidos() {
        return seguidos;
    }

    public ListaParticular getListaParticular(String nombre) {
        return listasParticulares.get(nombre);
    }

    public HashMap<String, ListaParticular> getListasParticulares() {
        return listasParticulares;
    }

    public void setSeguidos(HashMap<String, Usuario> seguidos) {
        this.seguidos = seguidos;
    }

    public void setListasParticulares(HashMap<String, ListaParticular> listasParticulares) {
        this.listasParticulares = listasParticulares;
    }

    public Lista getLista(String nomL) {

        Lista l = this.listasParticulares.get(nomL);

        if (l == null) {
            throw new UnsupportedOperationException("No existe la lista" + nomL + " en el sistema.");
        } else {
            return l;
        }
    }

    public ArrayList<DtLista> listarLisReproduccion() {
        ArrayList<DtLista> res = new ArrayList<>();
        Iterator it = listasParticulares.entrySet().iterator();
        while (it.hasNext()) {
            ListaParticular lp = (ListaParticular) ((Map.Entry) it.next()).getValue();
            res.add(new DtListaParticular(lp.isPrivada(), lp.getNombre(), lp.getTemas(), lp.getImagen()));

        }
        return res;
    }

    public DtLista seleccionarLista(String nombreL) {
        ListaParticular lp = listasParticulares.get(nombreL);
        return new DtListaParticular(lp.isPrivada(), lp.getNombre(), lp.getTemas(), lp.getImagen());
    }

    public ArrayList<DtUsuario> obtenerSeguidos() {
        ArrayList<DtUsuario> dtu = new ArrayList<>();

        Iterator it = seguidos.entrySet().iterator();
        while (it.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) it.next()).getValue();
            dtu.add(u.getData());
        }
        return dtu;
    }

    public void cargarLista(ListaParticular lp) {
        listasParticulares.put(lp.getNombre(), lp);
    }
}
