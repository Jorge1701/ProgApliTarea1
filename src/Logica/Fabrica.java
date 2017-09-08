package Logica;

import Persistencia.CargaDatosPrueba;
import java.util.ArrayList;
import java.util.HashMap;

public class Fabrica {

    public static void inicializarControladores() {
        ControladorUsuario.cargarInstancia();
        ControladorContenido.cargarInstancia();
        getIControladorContenido().setIUsuario(getIControladorUsuario());
        getIControladorUsuario().setIContenido(getIControladorContenido());
    }

    public static void cargaDatosPrueba() throws Exception {
        CargaDatosPrueba cdp = new CargaDatosPrueba();
        if (!cdp.borrarTodosLosDatos()) {
            throw new Exception("Error : no se puedieron borrar los datos previos");
        }

        inicializarControladores();

        if (!cdp.insertarDatosPrueba()) {
            throw new Exception("Error : no se puedieron levantar los datos de la BD");
        }

        levantarDatos();
    }

    public static void levantarDatos() throws Exception {
        CargaDatosPrueba cdp = new CargaDatosPrueba();
        IUsuario iu = getIControladorUsuario();
        IContenido ic = getIControladorContenido();

        // Cargar Usuarios (Clientes y Artistas)
        ArrayList<DtUsuario> usuarios = cdp.cargarUsuarios();

        if (usuarios == null) {
            throw new Exception("Error : Los usuarios no puedieron ser cargados");

        }

        for (DtUsuario dtu : usuarios) {
            iu.levantarUsuario(dtu);
        }

        // Cargar Inforamacion de quien sigue a quien
        ArrayList<String[]> relaciones = cdp.loadFollowers();
        if (relaciones == null) {
            throw new Exception("Error : Las relaciones de seguimiento no pudieron ser cargadas");
        }

        for (String[] r : relaciones) {
            Usuario cliente = iu.obtenerUsuario(r[0]);
            Usuario usuario = iu.obtenerUsuario(r[1]);
            ((Cliente) cliente).agregar(usuario);
        }

        // Cargar Generos
        ArrayList<String[]> generos = cdp.cargarGeneros();
        while (generos.size() > 0) {
            for (int i = 0; i < generos.size(); i++) {
                String[] genero = generos.get(i);
                if (ic.existeGenero(genero[1])) {
                    ic.cargarGenero(genero[0], genero[1]);
                    generos.remove(i);
                }
            }
        }

        // Cargar Albumes
        ArrayList<DtAlbum> dtas = cdp.cargarAlbumes();
        for (DtAlbum dta : dtas) {
            Album a = new Album(dta.getNickArtista(), dta.getNombre(), dta.getAnio(), dta.getImagen());

            // Cargar Generos del album
            ArrayList<Genero> albumGeneros = new ArrayList<>();
            for (String g : cdp.cargarGenerosAlbum(dta.getNickArtista(), dta.getNombre())) {
                Genero genero = ic.obtenerGenero(g);
                genero.cargarAlbum(a);
                albumGeneros.add(genero);
            }
            a.setGeneros(albumGeneros);

            // Cargar Temas del album
            HashMap<String, Tema> temas = new HashMap<>();
            for (DtTema dtt : cdp.cargarTemasAlbum(dta.getNickArtista(), dta.getNombre())) {
                if (dtt instanceof DtTemaLocal) {
                    DtTemaLocal dttl = (DtTemaLocal) dtt;
                    temas.put(dttl.getNombre(), new TemaLocal(a, dttl.getDirectorio(), dttl.getNombre(), dttl.getDuracion(), dttl.getUbicacion()));
                } else {
                    DtTemaRemoto dttr = (DtTemaRemoto) dtt;
                    temas.put(dttr.getNombre(), new TemaRemoto(a, dttr.getNombre(), dttr.getDuracion(), dttr.getUbicacion(), dttr.getUrl()));
                }
            }
            a.setTemas(temas);

            // Ingregas album al controlador
            iu.cargarAlbum(a);
        }

        // Cargar Listas Particulares
        ArrayList<String[]> listasParticulares = cdp.cargarListasParticulares();

        for (String[] lista : listasParticulares) {
            ArrayList<Tema> temas = new ArrayList<>();

            for (String[] dtt : cdp.cargarTemasLista(Integer.parseInt(lista[0]))) {
                temas.add(((Artista) iu.obtenerUsuario(dtt[0])).getAlbum(dtt[1]).getTema(dtt[2]));
            }

            iu.cargarLista(new ListaParticular(lista[5], lista[3].equals("N") ? true : false, lista[1], temas, lista[4]), lista[2]);
        }

        // Cargar Lista por Defecto
        ArrayList<String[]> listarPorDefecto = cdp.cargarListasDefecto();

        for (String[] lista : listarPorDefecto) {
            ArrayList<Tema> temas = new ArrayList();

            for (String[] dtt : cdp.cargarTemasLista(Integer.parseInt(lista[0]))) {
                temas.add(((Artista) iu.obtenerUsuario(dtt[0])).getAlbum(dtt[1]).getTema(dtt[2]));
            }

            ic.cargarLista(new ListaDefecto(ic.obtenerGenero(lista[1]), lista[2], temas, lista[3]), lista[1]);
        }

        //Cargar Albumes Favoritos
        ArrayList<String[]> albumesFavoritos = cdp.cargarAlbumesFavoritos();
        for (String[] albumesF : albumesFavoritos) {
            String nombreAlbum = albumesF[0];
            String nickCliente = albumesF[1];
            String nickArtista = albumesF[2];
            Usuario cliente = iu.obtenerUsuario(nickCliente);
            Usuario artista = iu.obtenerUsuario(nickArtista);
            Album a = ((Artista) artista).getAlbum(nombreAlbum);
            ((Cliente) cliente).agregarAlbumFav(a);

        }
        //Cargar Temas Favoritos 
        ArrayList<String[]> temasFavoritos = cdp.cargaTemasFavoritos();
        for (String[] temasF : temasFavoritos) {
            String nicknameCliente = temasF[0];
            String nombreTema = temasF[1];
            String nombreAlbum = temasF[2];
            String nicknameArtista = temasF[3];
            Usuario cliente = iu.obtenerUsuario(nicknameCliente);
            Usuario artista = iu.obtenerUsuario(nicknameArtista);
            Tema t = ((Artista) artista).getAlbum(nombreAlbum).getTema(nombreTema);
            ((Cliente) cliente).agregarTemaFav(t);
        }

        //Cargar Listas Favoritas
        ArrayList<String[]> listasFavoritasP = cdp.cargaListasFavoritosP();
        for (String[] listasF : listasFavoritasP) {
            String nicknameCliente = listasF[0];
            String nicknameCreador = listasF[1];
            String nombreLista = listasF[2];

            Usuario creador = iu.obtenerUsuario(nicknameCreador);
            Usuario cliente = iu.obtenerUsuario(nicknameCliente);
            Lista l = ((Cliente) creador).getLista(nombreLista);
            ((Cliente) cliente).agregarListaFav(l);
        }
        ArrayList<String[]> listasFavoritasD = cdp.cargaListasFavoritosD();
        for (String[] listasF : listasFavoritasD) {
            String nicknameCliente = listasF[0];
            String nombreGenero = listasF[1];
            String nombreLista = listasF[2];

            Usuario cliente = iu.obtenerUsuario(nicknameCliente);
            Genero g = ic.obtenerGenero(nombreGenero);
            Lista l = ((Genero) g).getListaDefecto(nombreLista);
            ((Cliente) cliente).agregarListaFav(l);
        }

    }

    public static IUsuario getIControladorUsuario() {
        IUsuario ICU = ControladorUsuario.getInstance();
        return ICU;
    }

    public static IContenido getIControladorContenido() {
        IContenido ICC = ControladorContenido.getInstance();
        return ICC;
    }
}
