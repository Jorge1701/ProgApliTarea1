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
    private ArrayList<Suscripcion> suscripciones;
    private Suscripcion actual;

    public Cliente(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen, String contrasenia) {
        super(nickname, nombre, apellido, email, fechaNac, imagen, contrasenia);

        this.seguidos = new HashMap();
        this.listasParticulares = new HashMap<String, ListaParticular>();
        this.albumesfav = new ArrayList<>();
        this.listasfav = new ArrayList<>();
        this.temasfav = new ArrayList<>();
        //this.actual = null;
        this.suscripciones = new ArrayList<>();
    }

    public Cliente(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen, String contrasenia, Suscripcion sus) {
        super(nickname, nombre, apellido, email, fechaNac, imagen, contrasenia);

        this.seguidos = new HashMap();
        this.listasParticulares = new HashMap<String, ListaParticular>();
        this.albumesfav = new ArrayList<>();
        this.listasfav = new ArrayList<>();
        this.temasfav = new ArrayList<>();
        this.suscripciones = new ArrayList<>();
        this.actual = sus;
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

    public void eliminarAlbumFav(String nickArtista, String nomAlbum) {
        for (int i = 0; i < albumesfav.size(); i++) {
            Album album = albumesfav.get(i);
            if (album.getNickArtista().equals(nickArtista) && album.getNombre().equals(nomAlbum)) {
                albumesfav.remove(i);
                return;
            }
        }
    }

    public void eliminarTemaFav(String nickArtista, String nomAlbum, String nombre) {
        for (int i = 0; i < temasfav.size(); i++) {
            Tema tema = temasfav.get(i);
            if (tema.getAlbum().getNickArtista().equals(nickArtista) && tema.getAlbum().getNombre().equals(nomAlbum) && tema.getNombre().equals(nombre)) {
                temasfav.remove(i);
                return;
            }
        }
    }

    public void eliminarLDFav(String nomGenero, String nombre) {
        for (int i = 0; i < listasfav.size(); i++) {
            Lista lista = listasfav.get(i);
            if (lista instanceof ListaDefecto) {
                if (((ListaDefecto) lista).getGenero().getNombre().equals(nomGenero) && lista.getNombre().equals(nombre)) {
                    listasfav.remove(i);
                    return;
                }
            }
        }
    }

    public void eliminarLPFav(String nickDuenio, String nombre) {
        for (int i = 0; i < listasfav.size(); i++) {
            Lista lista = listasfav.get(i);
            if (lista instanceof ListaParticular) {
                if (((ListaParticular) lista).getDuenio().equals(nickDuenio) && lista.getNombre().equals(nombre)) {
                    listasfav.remove(i);
                    return;
                }
            }
        }
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
            if (album.getArtista().estaActivo()) {
                favs.add(album.getData());
            }
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
            if (tema.getAlbum().getArtista().estaActivo()) {
                favs.add(tema.getData());
            }
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
        if (getSuscripcion() != null && getSuscripciones() != null) {

            ArrayList<Suscripcion> sus = getSuscripciones();

            ArrayList<DtSuscripcion> suscripciones = new ArrayList<>();

            for (Suscripcion s : sus) {
                suscripciones.add(s.getData());
            }

            return new DtCliente(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNac(), getImagen(), getContrasenia(), getSuscripcion().getData(), suscripciones);

        } else if (getSuscripcion() != null && getSuscripciones() == null) {

            return new DtCliente(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNac(), getImagen(), getContrasenia(), getSuscripcion().getData(), null);

        } else if (getSuscripcion() == null && getSuscripciones() != null) {

            ArrayList<Suscripcion> sus = getSuscripciones();

            ArrayList<DtSuscripcion> suscripciones = new ArrayList<>();

            for (Suscripcion s : sus) {
                suscripciones.add(s.getData());
            }

            return new DtCliente(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNac(), getImagen(), getContrasenia(), null, suscripciones);
        } else {
            return new DtCliente(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNac(), getImagen(), getContrasenia(), null, null);
        }
    }

    @Override
    public DtPerfilUsuario obtenerPerfil() {
        DtUsuario info = getData();
        ArrayList<DtCliente> dtSeguidores = getSeguidores();
        ArrayList<DtUsuario> dtSeguidos = obtenerSeguidos();
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
            if (a.getArtista().estaActivo()) {
                dtAlbumes.add(a.getData());
            }
        }

        for (Lista l : this.listasfav) {
            dtListas.add(l.getData());
        }

        for (Tema t : this.temasfav) {
            if (t.getAlbum().getArtista().estaActivo()) {
                dtTemas.add(t.getData());
            }
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

    public Suscripcion getSuscripcion() {
        return actual;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.actual = suscripcion;
    }

    public ArrayList<Suscripcion> getSuscripciones() {
        return suscripciones;
    }

    public void setSuscripciones(ArrayList<Suscripcion> suscripciones) {
        this.suscripciones = suscripciones;
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
            res.add(new DtListaParticular(lp.isPrivada(), lp.getNombre(), lp.getTemas(), lp.getImagen(), lp.getFecha(), lp.getDuenio()));

        }
        return res;
    }

    public DtLista seleccionarLista(String nombreL) {
        ListaParticular lp = listasParticulares.get(nombreL);
        return new DtListaParticular(lp.isPrivada(), lp.getNombre(), lp.getTemas(), lp.getImagen(), lp.getFecha(), lp.getDuenio());
    }

    public ArrayList<DtUsuario> obtenerSeguidos() {
        ArrayList<DtUsuario> dtu = new ArrayList<>();

        Iterator it = seguidos.entrySet().iterator();
        while (it.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) it.next()).getValue();

            boolean artDes = false;

            if (u instanceof Artista) {
                if (!((Artista) u).estaActivo()) {
                    artDes = true;
                }
            }

            if (!artDes) {
                dtu.add(u.getData());
            }
        }
        return dtu;
    }

    public void cargarLista(ListaParticular lp) {
        listasParticulares.put(lp.getNombre(), lp);
    }

    public void cancelarSuscripcion(Suscripcion sus) {
        suscripciones.add(sus);
        actual = null;
    }

    public void cargarSuscripcion(Suscripcion sus) {
        if (sus.getEstado().equals("Vigente") || sus.getEstado().equals("Pendiente")) {
            actual = sus;
        } else {
            suscripciones.add(sus);
        }
    }

    public void renovarSuscripcion(Suscripcion s) {
        actual = s;
        suscripciones.remove(s);

    }
}
