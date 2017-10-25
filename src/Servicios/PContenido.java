package Servicios;

import Configuracion.Configuracion;
import Logica.DtAlbumContenido;
import Logica.DtListaAlbum;
import Logica.DtListaDeListas;
import Logica.DtListaString;
import Logica.DtListaTema;
import Logica.DtTema;
import Logica.DtTemaLocal;
import Logica.DtTemaRemoto;
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
@SOAPBinding(style = Style.RPC)
public class PContenido {

    private Endpoint endpoint = null;

    IUsuario iUsuario;
    IContenido iContenido;

    public PContenido() {
        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PContenido"), this);
    }

    @WebMethod
    public DtListaString obtenerGeneros() {
        DtListaString generos = new DtListaString(iContenido.obtenerGeneros());
        return generos;
    }

    @WebMethod
    public boolean existeGenero(String genero) {
        return iContenido.existeGenero(genero);

    }

    @WebMethod
    public boolean ExisteAlbum(String nickname, String nombreAlbum) {
        return iContenido.ExisteAlbum(nickname, nombreAlbum);
    }

    @WebMethod
    public boolean selectArtista(String nickArt) {
        return iContenido.selectArtista(nickArt);
    }

    @WebMethod
    public DtListaDeListas obtenerListasFav(String nombre) {
        DtListaDeListas listas = new DtListaDeListas(iUsuario.obtenerListasFav(nombre));
        return listas;
    }

    @WebMethod
    public DtListaAlbum obtenerAlbumesFav(String nombre) {
        DtListaAlbum albumes = new DtListaAlbum(iUsuario.obtenerAlbumesFav(nombre));
        return albumes;
    }

    @WebMethod
    public DtListaDeListas listarLisReproduccionGen(String nombre) {
        DtListaDeListas listas = new DtListaDeListas(iContenido.listarLisReproduccionGen(nombre));
        return listas;
    }

    @WebMethod
    public DtListaAlbum listarAlbumesGenero(String nombre) {
        DtListaAlbum albumes = new DtListaAlbum(iContenido.listarAlbumesGenero(nombre));
        return albumes;
    }

    @WebMethod
    public DtUsuario getDataUsuario(String nickname) {
        return iUsuario.getDataUsuario(nickname);
    }

    @WebMethod
    public DtAlbumContenido obtenerAlbumContenido(String nickArtista, String nombreAlbum) {
        return iUsuario.obtenerAlbumContenido(nickArtista, nombreAlbum);
    }

    @WebMethod
    public DtListaDeListas listarLisReproduccion(String nickCliente) {
        DtListaDeListas listas = new DtListaDeListas(iUsuario.listarLisReproduccion(nickCliente));
        return listas;
    }

    @WebMethod
    public void ingresarAlbum(String nombreA, int anio, DtListaString ArrayDeGeneros, String imagen, DtListaTema ArrayDeTemas) {
        iContenido.ingresarAlbum(nombreA, anio, ArrayDeGeneros.getString(), "", ArrayDeTemas.getDtTemas());
    }

    @WebMethod
    public boolean publicarLista(String nickname, String nomLista) {
        return iContenido.publicarLista(nickname, nomLista);
    }

    @WebMethod
    public void DtListaTema(DtListaTema tema) {

    }

    @WebMethod
    public void DtTemaLocal(DtTemaLocal tema) {

    }

    @WebMethod
    public void DtTemaRemoto(DtTemaRemoto tema) {

    }
}
