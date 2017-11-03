package Logica;

import Persistencia.CargaDatosPrueba;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
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
            Usuario cliente = iu.soloDesdeFabricaObtenerUsuario(r[0]);
            Usuario usuario = iu.soloDesdeFabricaObtenerUsuario(r[1]);
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
            Album a = new Album((Artista) iu.soloDesdeFabricaObtenerUsuario(dta.getNickArtista()), dta.getNickArtista(), dta.getNombre(), dta.getAnio(), dta.getImagen());

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
                    temas.put(dttl.getNombre(), new TemaLocal(dttl.getReproducciones(), a, dttl.getDirectorio(), dttl.getNombre(), dttl.getDuracion(), dttl.getUbicacion()));
                } else {
                    DtTemaRemoto dttr = (DtTemaRemoto) dtt;
                    temas.put(dttr.getNombre(), new TemaRemoto(dttr.getReproducciones(), a, dttr.getNombre(), dttr.getDuracion(), dttr.getUbicacion(), dttr.getUrl()));
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
                temas.add(((Artista) iu.soloDesdeFabricaObtenerUsuario(dtt[0])).getAlbum(dtt[1]).getTema(dtt[2]));
            }

            DtFecha fecha = new DtFecha(Integer.valueOf(lista[6]), Integer.valueOf(lista[7]), Integer.valueOf(lista[8]));
            iu.cargarLista(new ListaParticular(lista[5], lista[3].equals("N") ? true : false, lista[1], temas, lista[4], fecha), lista[2]);
        }

        // Cargar Lista por Defecto
        ArrayList<String[]> listarPorDefecto = cdp.cargarListasDefecto();

        for (String[] lista : listarPorDefecto) {
            ArrayList<Tema> temas = new ArrayList();

            for (String[] dtt : cdp.cargarTemasLista(Integer.parseInt(lista[0]))) {
                temas.add(((Artista) iu.soloDesdeFabricaObtenerUsuario(dtt[0])).getAlbum(dtt[1]).getTema(dtt[2]));
            }

            DtFecha fecha = new DtFecha(Integer.valueOf(lista[4]), Integer.valueOf(lista[5]), Integer.valueOf(lista[6]));

            ic.cargarLista(new ListaDefecto(ic.obtenerGenero(lista[1]), lista[2], temas, lista[3], fecha), lista[1]);
        }

        //Cargar Albumes Favoritos
        ArrayList<String[]> albumesFavoritos = cdp.cargarAlbumesFavoritos();
        for (String[] albumesF : albumesFavoritos) {
            String nombreAlbum = albumesF[0];
            String nickCliente = albumesF[1];
            String nickArtista = albumesF[2];
            Usuario cliente = iu.soloDesdeFabricaObtenerUsuario(nickCliente);
            Usuario artista = iu.soloDesdeFabricaObtenerUsuario(nickArtista);
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
            Usuario cliente = iu.soloDesdeFabricaObtenerUsuario(nicknameCliente);
            Usuario artista = iu.soloDesdeFabricaObtenerUsuario(nicknameArtista);
            Tema t = ((Artista) artista).getAlbum(nombreAlbum).getTema(nombreTema);
            ((Cliente) cliente).agregarTemaFav(t);
        }

        //Cargar Listas Favoritas
        ArrayList<String[]> listasFavoritasP = cdp.cargaListasFavoritosP();
        for (String[] listasF : listasFavoritasP) {
            String nicknameCliente = listasF[0];
            String nicknameCreador = listasF[1];
            String nombreLista = listasF[2];

            Usuario creador = iu.soloDesdeFabricaObtenerUsuario(nicknameCreador);
            Usuario cliente = iu.soloDesdeFabricaObtenerUsuario(nicknameCliente);
            Lista l = ((Cliente) creador).getLista(nombreLista);
            ((Cliente) cliente).agregarListaFav(l);
        }
        ArrayList<String[]> listasFavoritasD = cdp.cargaListasFavoritosD();
        for (String[] listasF : listasFavoritasD) {
            String nicknameCliente = listasF[0];
            String nombreGenero = listasF[1];
            String nombreLista = listasF[2];

            Usuario cliente = iu.soloDesdeFabricaObtenerUsuario(nicknameCliente);
            Genero g = ic.obtenerGenero(nombreGenero);
            Lista l = ((Genero) g).getListaDefecto(nombreLista);
            ((Cliente) cliente).agregarListaFav(l);
        }

        //levantar suscripciones
        ArrayList<String[]> suscripciones = cdp.cargarSuscripciones();

        if (suscripciones == null) {
            throw new Exception("Error : Las suscripciones no pudieron ser cargadas");
        }

        for (String[] suscripcion : suscripciones) {
            String nick = suscripcion[0];
            String cuota = suscripcion[1];
            String fecha_venc = suscripcion[2];
            String fecha = suscripcion[3];
            String estado = suscripcion[4];
            String[] arreglo2 = null;
            int monto = Integer.parseInt(suscripcion[5]);
            if (fecha_venc != null) {
                arreglo2 = fecha_venc.split("-");
            }
            String[] arreglo = fecha.split("-");

            Cliente cli = (Cliente) iu.soloDesdeFabricaObtenerUsuario(nick);
            cli.cargarSuscripcion(new Suscripcion(estado, cuota, arreglo2 == null ? null : new DtFecha(Integer.parseInt(arreglo2[2]), Integer.parseInt(arreglo2[1]), Integer.parseInt(arreglo2[0])), new DtFecha(Integer.parseInt(arreglo[2]), Integer.parseInt(arreglo[1]), Integer.parseInt(arreglo[0])), monto));
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
