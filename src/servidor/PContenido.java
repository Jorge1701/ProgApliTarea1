package servidor;

import Logica.DtAlbum;
import Logica.DtAlbumContenido;
import Logica.DtLista;
import Logica.DtTema;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PContenido {

    private Endpoint endpoint = null;

    private IUsuario iUsuario;
    private IContenido iContenido;

    public PContenido() {
        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
    }

    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://localhost:9129/pcontenido", this);

    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public ArrayList<String> obtenerGeneros() {
        return iContenido.obtenerGeneros();

    }

    @WebMethod
    public boolean existeGenero(String genero) {
        return iContenido.existeGenero(genero);

    }

    @WebMethod
    ArrayList<DtLista> obtenerListasFav(String nombre) {
        return iUsuario.obtenerListasFav(nombre);
    }

    @WebMethod
    ArrayList<DtAlbum> obtenerAlbumesFav(String nombre) {
        return iUsuario.obtenerAlbumesFav(nombre);
    }

    @WebMethod
    ArrayList<DtLista> listarLisReproduccionGen(String nombre) {
        return iContenido.listarLisReproduccionGen(nombre);
    }

    @WebMethod
    ArrayList<DtAlbum> listarAlbumesGenero(String nombre) {
        return iContenido.listarAlbumesGenero(nombre);
    }

    @WebMethod
    DtUsuario getDataUsuario(String nickname) {
        return iUsuario.getDataUsuario(nickname);
    }

    @WebMethod
    DtAlbumContenido obtenerAlbumContenido(String nickArtista, String nombreAlbum) {
        return iUsuario.obtenerAlbumContenido(nickArtista, nombreAlbum);
    }

    @WebMethod
    ArrayList<DtLista> listarLisReproduccion(String nickCliente) {
        return iUsuario.listarLisReproduccion(nickCliente);
    }

    @WebMethod
    boolean ExisteAlbum(String nickname, String nombreAlbum) {
        return iContenido.ExisteAlbum(nickname, nombreAlbum);
    }

    @WebMethod
    boolean selectArtista(String nickArt) {
        return iContenido.selectArtista(nickArt);
    }

    @WebMethod
    void ingresarAlbum(String nombreA, int anio, ArrayList<String> ArrayDeGeneros, String imagen, ArrayList<DtTema> ArrayDeTemas) {
        iContenido.ingresarAlbum(nombreA, anio, ArrayDeGeneros, "", ArrayDeTemas);
    }

    @WebMethod
    boolean publicarLista(String nickname, String nomLista) {
        return iContenido.publicarLista(nickname, nomLista);
    }

}
