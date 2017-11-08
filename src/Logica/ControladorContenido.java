package Logica;

import Persistencia.BDCliente;
import Persistencia.BDGenero;
import Persistencia.BDLista;
import Persistencia.CargaDatosPrueba;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ControladorContenido implements IContenido {

    private static ControladorContenido instancia;

    public static void cargarInstancia() {
        if (instancia == null) {
            instancia = new ControladorContenido();
        } else {
            instancia.reiniciar();
        }
    }

    public static ControladorContenido getInstance() {
        if (instancia == null) {
            cargarInstancia();
        }
        return instancia;
    }

    private Map<String, ListaDefecto> listasDefecto;
    private Artista artista;
    private Genero genero;
    private Genero generoRecordado;
    private Cliente clienteFav;
    private IUsuario iUsuario;

    @Override
    public void reiniciar() {
        this.listasDefecto = new HashMap<>();
        genero = new Genero("Géneros");

        artista = null;
        generoRecordado = null;
        clienteFav = null;

        iUsuario = null;
    }

    @Override
    public void setIUsuario(IUsuario iUsuario) {
        this.iUsuario = iUsuario;
    }

    private ControladorContenido() {
        this.listasDefecto = new HashMap<>();
        genero = new Genero("Géneros");
    }

    @Override
    public void indicarCliente(String nick) {
        Usuario u = iUsuario.obtenerUsuario(nick);

        if (u == null) {
            throw new UnsupportedOperationException("Usuario " + nick + " no existe");
        }

        if (!(u instanceof Cliente)) {
            throw new UnsupportedOperationException("El usuario " + nick + " debe ser un cliente");
        }

        clienteFav = (Cliente) u;
    }

    @Override
    public void guardarTema(String nickArtista, String nomAlbum, String nomTema) {
        Usuario u = iUsuario.obtenerUsuario(nickArtista);

        if (u == null) {
            throw new UnsupportedOperationException("El artista " + nickArtista + " no existe");
        }

        if (!(u instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario " + nickArtista + " debe ser un artista");
        }

        Album album = ((Artista) u).getAlbum(nomAlbum);

        if (album == null) {
            throw new UnsupportedOperationException("El artista " + nickArtista + " no tiene ningun album llamado " + nomAlbum);
        }

        Tema tema = album.getTema(nomTema);

        if (tema == null) {
            throw new UnsupportedOperationException("El album " + nomAlbum + " no tiene ningun tema llamado " + nomTema);
        }

        try {
            BDCliente bdc = new BDCliente();
            //boolean ok = bdc.agregarTemaFav();

            //if (!ok)
            // throw new UnsupportedOperationException("Error al agregar datos en la base de datos");
            clienteFav.agregarTemaFav(tema);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void guardarListaDefault(String nomGenero, String nomLista) {
        Genero g = genero.obtener(nomGenero);

        if (g == null) {
            throw new UnsupportedOperationException("El genero " + nomGenero + " no existe");
        }

        ListaDefecto l = g.getListaDefecto(nomLista);

        if (l == null) {
            throw new UnsupportedOperationException("La lista " + nomLista + " no existe dentro del genero " + nomGenero);
        }

        try {
            BDCliente bdc = new BDCliente();
            boolean ok = bdc.agregarListaDefaultFav(nomGenero, nomLista, clienteFav.getNickname());

            if (!ok) {
                throw new UnsupportedOperationException("Error al agregar datos en la base de datos");
            }

            clienteFav.agregarListaFav(l);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void guardarListaParticular(String nickCliente, String nomLista) {
        Usuario u = iUsuario.obtenerUsuario(nickCliente);

        if (u == null) {
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no existe");
        }

        if (!(u instanceof Cliente)) {
            throw new UnsupportedOperationException("El usuario " + nickCliente + " debe ser un cliente");
        }

        ListaParticular l = ((Cliente) u).getListaParticular(nomLista);

        if (l == null) {
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no tinene ninguna lista llamada " + nomLista);
        }

        try {
            BDCliente bdc = new BDCliente();
            boolean ok = bdc.agregarListaParticularFav(nickCliente, nomLista, clienteFav.getNickname());

            if (!ok) {
                throw new UnsupportedOperationException("Error al agregar datos en la base de datos");
            }

            clienteFav.agregarListaFav(l);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void guardarAlbum(String nickArtista, String nomAlbum) {
        Usuario u = iUsuario.obtenerUsuario(nickArtista);

        if (u == null) {
            throw new UnsupportedOperationException("El artista " + nickArtista + " no existe");
        }

        if (!(u instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario " + nickArtista + " debe ser un artista");
        }

        Album album = ((Artista) u).getAlbum(nomAlbum);

        if (album == null) {
            throw new UnsupportedOperationException("El artista " + nickArtista + " no tiene ningun album llamado " + nomAlbum);
        }

        try {
            BDCliente bdc = new BDCliente();
            boolean ok = bdc.agregarAlbumFav(nickArtista, nomAlbum, clienteFav.getNickname());

            if (!ok) {
                throw new UnsupportedOperationException("Error al agregar datos en la base de datos");
            }

            clienteFav.agregarAlbumFav(album);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void eliminarTema(int i) {
        try {
            clienteFav.eliminarTemaFav(i);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void eliminarListaFavoritos(int i) {
        try {
            clienteFav.eliminarListaFav(i);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void eliminarAlbum(int i) {
        try {
            clienteFav.eliminarAlbumFav(i);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public boolean selectArtista(String nick) {
        this.artista = ControladorUsuario.getInstance().selectArtista(nick);
        if (this.artista != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public DtGenero listarGenero() {
        return genero.getData();
    }

    @Override
    public ArrayList<DtAlbum> listarAlbumesGenero(String nombre) {
        Genero gen = genero.obtener(nombre);
        if (gen == null) {
            throw new UnsupportedOperationException("Genero no existe");
        }

        return gen.obtenerAlbumes();
    }

    @Override
    public boolean crearListaReproduccion(DtLista dtl, String nickCliente) {
        BDLista bdLista = new BDLista();
        if (dtl instanceof DtListaDefecto) {
            if (listasDefecto.get(dtl.getNombre()) != null) {
                return false;
            }
            if (bdLista.altaLista(dtl, nickCliente)) {
                Lista ld = new ListaDefecto(this.genero.obtener(((DtListaDefecto) dtl).getGenero().getNombre()), dtl.getNombre(), new ArrayList<>(), dtl.getImagen(), dtl.getFecha());
                this.listasDefecto.put(ld.getNombre(), (ListaDefecto) ld);
                this.genero.obtener(((DtListaDefecto) dtl).getGenero().getNombre()).cargarLista((ListaDefecto) ld);
                return true;
            } else {
                return false;
            }

        } else {

            if (((Cliente) iUsuario.obtenerUsuario(nickCliente)).getListaParticular(dtl.getNombre()) != null) {
                return false;
            }
            if (bdLista.altaLista(dtl, nickCliente)) {
                Lista lp = new ListaParticular(dtl.getNombre(), dtl.getImagen(), dtl.getFecha(), nickCliente);
                ((Cliente) iUsuario.obtenerUsuario(nickCliente)).agregarLista(lp);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void ingresarAlbum(String nom, int anio, ArrayList<String> generos, String img, ArrayList<DtTema> temas) {
        ArrayList<Genero> lstGeneros = new ArrayList<>();
        HashMap<String, Tema> mapTemas = new HashMap<>();

        if (generos.isEmpty()) {
            throw new UnsupportedOperationException("Debe de indicar al menos un Genero");
        }

        for (int i = 0; i < generos.size(); i++) {
            String nomG = generos.get(i);
            lstGeneros.add(this.genero.obtener(nomG));
            //mapGeneros.put(nomG, this.genero.obtener(nomG));           

        }

        if (temas.isEmpty()) {
            throw new UnsupportedOperationException("Debe de indicar al menos un Tema");
        }

        for (int i = 0; i < temas.size(); i++) {
            DtTema dtT = (DtTema) temas.get(i);
            Tema t;
            if (dtT instanceof DtTemaLocal) {
                t = new TemaLocal(((DtTemaLocal) dtT).getDescargas(), 0, ((DtTemaLocal) dtT).getDirectorio(), dtT.getNombre(), dtT.getDuracion(), dtT.getUbicacion());
                mapTemas.put(dtT.getNombre(), t);
            } else if (dtT instanceof DtTemaRemoto) {
                t = new TemaRemoto(0, dtT.getNombre(), dtT.getDuracion(), dtT.getUbicacion(), ((DtTemaRemoto) dtT).getUrl());
                mapTemas.put(dtT.getNombre(), t);
            }

        }

        this.artista.ingresarAlbum(nom, anio, lstGeneros, img, mapTemas);

        //set null artista seleccionado
        this.artista = null;
    }

    @Override
    public ArrayList<DtLista> listarLisReproduccionGen(String nomGen) {
        Genero g = this.genero.obtener(nomGen);
        if (g == null) {
            throw new UnsupportedOperationException("El genero no existe");
        }
        this.generoRecordado = g;
        return g.listarLisReproduccion();
    }

    @Override
    public DtLista selecListGen(String nombreL) {
        return generoRecordado.seleccionarLista(nombreL);
    }

    @Override
    public ArrayList<DtTema> selecListaDef(String nombre) {

        ListaDefecto aux = listasDefecto.get(nombre);

        if (aux == null) {
            throw new UnsupportedOperationException("No existe la lista");
        }

        ArrayList<DtTema> res = aux.getTemas();

        //if (res.isEmpty()) {
        //  throw new UnsupportedOperationException("No hay temas en esta lista");
        //} sino cuando borras un tema de una lista que solo tiene un tema crashea
        return res;
    }

    @Override
    public boolean quitarTema(String nombreT, String nombre, String nombreUser) {
        Cliente u = (Cliente) iUsuario.obtenerUsuario(nombreUser);
        if (nombreUser == null) {
            Lista lista = (ListaDefecto) listasDefecto.get(nombre);
            if (lista == null) {
                throw new UnsupportedOperationException("No existe la lista");
            }
            return lista.quitarTema(nombreT);
        } else {
            Lista lista = (ListaParticular) u.getListaParticular(nombre);

            if (lista == null) {
                throw new UnsupportedOperationException("No existe la lista");
            }
            if (u.getLista(nombre).quitarTema(nombreT) /*&& this.quitarTema(nombreT, nombre, nombreUser)*/) {
                return true;
            }
            return false;
        }

    }

    @Override
    public boolean agregarDeListasDefectoTema(String nombreT, String nombreLista, String nombreUser, String listaDefecto) {
        Cliente u = (Cliente) iUsuario.obtenerUsuario(nombreUser);
        Tema tema = (Tema) listasDefecto.get(listaDefecto).getTema(nombreT);
        BDLista bd = new BDLista();
        CargaDatosPrueba obtenerId = new CargaDatosPrueba();
        int idAlbum = obtenerId.obtenerIdAlbum(tema.getAlbum().getNickArtista(), tema.getAlbum().getNombre());
        int idTema = obtenerId.obtenerIdTema(tema.getAlbum().getNickArtista(), idAlbum, tema.getNombre());
        if (nombreUser.equals("")) {
            ListaDefecto lista = (ListaDefecto) listasDefecto.get(nombreLista);
            int idLista = obtenerId.obtenerIdListaDefecto(lista.getGenero().getNombre(), lista.getNombre());
            if (lista == null) {
                throw new UnsupportedOperationException("No existe la lista");
            }
            if (lista.agregarTema(tema) && bd.insertarTemaALista(tema.getAlbum().getNickArtista(), idAlbum, idTema, idLista)) {
                return true;
            } else {
                return false;
            }

        } else {
            ListaParticular lista = (ListaParticular) u.getListaParticular(nombreLista);
            int idLista = obtenerId.obtenerIdListaParticular(u.getNickname(), lista.getNombre());
            if (lista == null) {
                throw new UnsupportedOperationException("No existe la lista");
            }
            if (lista.agregarTema(tema) && bd.insertarTemaALista(tema.getAlbum().getNickArtista(), idAlbum, idTema, idLista)) {
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public boolean agregarDeListasParticularesTema(String nombreT, String nombreLista, String nombreUser, String duenio, String listaDelduenio) {
        Cliente u = (Cliente) iUsuario.obtenerUsuario(nombreUser);
        Tema tema = (Tema) ((ListaParticular) ((Cliente) iUsuario.obtenerUsuario(duenio)).getListaParticular(listaDelduenio)).getTema(nombreT);
        BDLista bd = new BDLista();
        CargaDatosPrueba obtenerId = new CargaDatosPrueba();
        int idAlbum = obtenerId.obtenerIdAlbum(tema.getAlbum().getNickArtista(), tema.getAlbum().getNombre());
        int idTema = obtenerId.obtenerIdTema(tema.getAlbum().getNickArtista(), idAlbum, tema.getNombre());
        if (nombreUser.equals("")) {
            ListaDefecto lista = (ListaDefecto) listasDefecto.get(nombreLista);
            int idLista = obtenerId.obtenerIdListaDefecto(lista.getGenero().getNombre(), lista.getNombre());
            if (lista == null) {
                throw new UnsupportedOperationException("No existe la lista");
            }
            if (lista.agregarTema(tema) && bd.insertarTemaALista(tema.getAlbum().getNickArtista(), idAlbum, idTema, idLista)) {
                return true;
            } else {
                return false;
            }

        } else {
            Lista lista = (ListaParticular) u.getListaParticular(nombreLista);
            int idLista = obtenerId.obtenerIdListaParticular(u.getNickname(), lista.getNombre());
            if (lista == null) {
                throw new UnsupportedOperationException("No existe la lista");
            }
            if (lista.agregarTema(tema) && bd.insertarTemaALista(tema.getAlbum().getNickArtista(), idAlbum, idTema, idLista)) {
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public boolean agregarDeAlbumTema(String nombreT, String nombreLista, String nombreUser, String artista, String album) {
        Cliente u = (Cliente) iUsuario.obtenerUsuario(nombreUser);
        Tema tema = (Tema) ((Album) ((Artista) iUsuario.obtenerUsuario(artista)).getAlbum(album)).getTema(nombreT);
        BDLista bd = new BDLista();
        CargaDatosPrueba obtenerId = new CargaDatosPrueba();

        int idAlbum = obtenerId.obtenerIdAlbum(tema.getAlbum().getNickArtista(), tema.getAlbum().getNombre());
        int idTema = obtenerId.obtenerIdTema(tema.getAlbum().getNickArtista(), idAlbum, tema.getNombre());
        if (nombreUser.equals("")) {
            ListaDefecto lista = (ListaDefecto) listasDefecto.get(nombreLista);
            int idLista = obtenerId.obtenerIdListaDefecto(lista.getGenero().getNombre(), lista.getNombre());
            if (lista == null) {
                throw new UnsupportedOperationException("No existe la lista");
            }
            if (lista.agregarTema(tema) && bd.insertarTemaALista(tema.getAlbum().getNickArtista(), idAlbum, idTema, idLista)) {
                return true;
            } else {
                return false;
            }

        } else {
            Lista lista = (ListaParticular) u.getListaParticular(nombreLista);
            int idLista = obtenerId.obtenerIdListaParticular(u.getNickname(), lista.getNombre());
            if (lista == null) {
                throw new UnsupportedOperationException("No existe la lista");
            }
            if (lista.agregarTema(tema) && bd.insertarTemaALista(tema.getAlbum().getNickArtista(), idAlbum, idTema, idLista)) {
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public ArrayList<DtTema> selecLista(String nick, String nomL) {
        Cliente us = (Cliente) iUsuario.obtenerUsuario(nick);

        if (us == null) {
            throw new UnsupportedOperationException("No existe el usuario" + nick + " en el sistema.");
        }

        Lista lista = us.getLista(nomL);

        ArrayList<DtTema> temas = lista.getTemas();

        if (temas == null) {
            throw new UnsupportedOperationException("No hay temas en la lista " + nomL + ".");
        } else {
            return temas;
        }
    }

    @Override
    public boolean publicarLista(String nick, String nomL) {
        Cliente us = (Cliente) iUsuario.obtenerUsuario(nick);
        BDLista bdLista = new BDLista();
        if (us == null) {
            throw new UnsupportedOperationException("No existe el usuario" + nick + " en el sistema.");
        }

        ListaParticular l = (ListaParticular) us.getLista(nomL);

        if (l == null) {
            throw new UnsupportedOperationException("No existe la lista " + nomL + " en el sistema");
        }

        l.setPrivada(false);
        bdLista.publicarLista(l);
        return true;
    }

    @Override
    public DtGenero selecGenero(String nomGenero) {
        return this.genero.obtener(nomGenero).getData();
    }

    @Override
    public DtAlbumContenido obtenerAlbumContenido(String nomGenero, String nomAlbum, String nickArtista) {
        return genero.obtener(nomGenero).obtenerAlbumContenido(nomAlbum, nickArtista);
    }

    @Override
    public void cargarGenero(String nombre, String padre) {
        // this.genero.agregarGenero(padre.isEmpty() ? genero.getNombre() : padre, nombre);
        genero.agregarGenero(padre, nombre);
    }

    @Override
    public boolean existeGenero(String nombre) {
        return genero.existe(nombre);
    }

    @Override
    public Genero obtenerGenero(String nombre) {
        return genero.obtener(nombre);
    }

    @Override
    public ArrayList<DtLista> listarLisReproduccionDef() {
        ArrayList<DtLista> res = new ArrayList<>();

        Iterator i = listasDefecto.entrySet().iterator();

        while (i.hasNext()) {
            ListaDefecto dtld = (ListaDefecto) ((Map.Entry) i.next()).getValue();
            res.add(dtld.getData());

        }
        return res;

    }

    @Override
    public void cargarLista(ListaDefecto ld, String nombreGenero) {
        genero.obtener(nombreGenero).cargarLista(ld);
        listasDefecto.put(ld.getNombre(), ld);
    }

    @Override
    public void ingresarGenero(String nombre, String padre) {
        if (existeGenero(nombre) == false) {
            genero.agregarGenero(padre, nombre);
            if (!new BDGenero().ingresarGeneros(nombre, padre)) {
                throw new UnsupportedOperationException("No se pudo ingresar el genero a la BD");
            }
        } else {
            throw new UnsupportedOperationException("El genero ya existe");
        }
    }

    @Override
    public HashMap<String, Tema> listarTemas(String NombreAlbum, String nickArtista) {
        Album a = iUsuario.selectArtista(nickArtista).getAlbum(NombreAlbum);
        if (a == null) {
            throw new UnsupportedOperationException("El Album No Existe");
        }
        return a.getTemas();
    }

    @Override
    public ArrayList<DtTema> listarTemasLD(String nombreLista) {
        Lista lista = (Lista) listasDefecto.get(nombreLista);

        if (lista == null) {
            throw new UnsupportedOperationException("La Lista No Existe");
        }
        return lista.getTemas();

    }

    @Override
    public ArrayList<DtTema> listarTemasP(String nombreLista, String nickCliente) {
        Cliente c = (Cliente) iUsuario.obtenerUsuario(nickCliente);
        Lista l = c.getListaParticular(nombreLista);
        if (l == null) {
            throw new UnsupportedOperationException("La Lista No Existe");
        }
        return l.getTemas();
    }

    @Override
    public ArrayList<DtBuscado> buscar(String texto, String orden) {
        texto = texto.toLowerCase();

        ArrayList<DtBuscado> resultados = new ArrayList<>();

        ArrayList<DtUsuario> artistas = iUsuario.listarArtistas();
        for (DtUsuario dtu : artistas) {
            Artista a = (Artista) iUsuario.obtenerUsuario(dtu.getNickname());

            for (Album album : a.getAlbumes()) {
                if (album.getNombre().toLowerCase().contains(texto)) {
                    resultados.add(album.getData());
                }

                Iterator i = album.getTemas().entrySet().iterator();

                while (i.hasNext()) {
                    Tema tema = (Tema) ((Map.Entry) i.next()).getValue();
                    if (tema.getNombre().toLowerCase().contains(texto)) {
                        resultados.add(tema.getData());
                    }
                }
            }
        }

        ArrayList<DtUsuario> clientes = iUsuario.listarClientes();
        for (DtUsuario dtu : clientes) {
            Cliente c = (Cliente) iUsuario.obtenerUsuario(dtu.getNickname());

            Iterator i = c.getListasParticulares().entrySet().iterator();

            while (i.hasNext()) {
                ListaParticular lista = (ListaParticular) ((Map.Entry) i.next()).getValue();
                if (lista.getNombre().toLowerCase().contains(texto) && !lista.isPrivada()) {
                    resultados.add(lista.getData());
                }
            }
        }

        Iterator i = listasDefecto.entrySet().iterator();

        while (i.hasNext()) {
            ListaDefecto lista = (ListaDefecto) ((Map.Entry) i.next()).getValue();
            if (lista.getNombre().toLowerCase().contains(texto)) {
                resultados.add(lista.getData());
            }
        }

        switch (orden) {
            case "alfa":
                return ordenarAlfabeticamente(resultados);
            case "anio":
                return ordenarPorAnio(resultados);
            default:
                return resultados;
        }
    }

    private String obtenerNombre(Object o) {
        if (o instanceof DtAlbum) {
            return ((DtAlbum) o).getNombre();
        } else if (o instanceof DtLista) {
            return ((DtLista) o).getNombre();
        } else if (o instanceof DtTema) {
            return ((DtTema) o).getNombre();
        } else {
            return "";
        }
    }

    private int obtenerAnio(Object o) {
        if (o instanceof DtAlbum) {
            return ((DtAlbum) o).getAnio();
        } else if (o instanceof DtLista) {
            return ((DtLista) o).getFecha().getAnio();
        } else if (o instanceof DtTema) {
            return ((Artista) iUsuario.obtenerUsuario(((DtTema) o).getArtista())).getAlbum(((DtTema) o).getAlbum()).getAnio();
        } else {
            return 0;
        }
    }

    private ArrayList<DtBuscado> ordenarAlfabeticamente(ArrayList<DtBuscado> lista) {
        Collections.sort(lista, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                return obtenerNombre(o1).compareTo(obtenerNombre(o2));
            }
        });
        return lista;
    }

    private ArrayList<DtBuscado> ordenarPorAnio(ArrayList<DtBuscado> lista) {
        Collections.sort(lista, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                if (obtenerAnio(o1) == obtenerAnio(o2)) {
                    return 0;
                }
                return obtenerAnio(o1) > obtenerAnio(o2) ? -1 : 1;
            }
        });
        return lista;
    }

    public ArrayList<String> obtenerGeneros() {
        ArrayList<String> generos = new ArrayList<>();
        obtenerNombres(generos, genero);
        return generos;
    }

    private void obtenerNombres(ArrayList<String> nombres, Genero g) {
        if (!g.getNombre().equals("Géneros")) {
            nombres.add(g.getNombre());
        }

        HashMap<String, Genero> sub_generos = g.getSubgeneros();

        Iterator i = sub_generos.entrySet().iterator();
        while (i.hasNext()) {
            Genero sub = (Genero) ((Map.Entry) i.next()).getValue();
            obtenerNombres(nombres, sub);
        }
    }

    public boolean ExisteAlbum(String nickArtista, String nomAlbum) {
        Usuario usuario = iUsuario.obtenerUsuario(nickArtista);
        if (usuario == null) {
            throw new UnsupportedOperationException("Artista no existe ok");
        }
        if (!(usuario instanceof Artista)) {
            throw new UnsupportedOperationException("Usuario no es un artista");
        }

        return ((Artista) usuario).ExisteAlbum(nomAlbum);

    }
}
