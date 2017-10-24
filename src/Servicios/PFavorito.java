package Servicios;

import Configuracion.Configuracion;
import Logica.DtAlbumContenido;
import Logica.DtListaAlbum;
import Logica.DtListaDeListas;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC)
public class PFavorito {

    private Endpoint endpoint = null;

    private IUsuario iUsuario;
    private IContenido iContenido;

    public PFavorito() {
        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PFavortio"), this);
    }

    @WebMethod
    public DtUsuario getDataUsuario(String nickUsuario) {
        return iUsuario.getDataUsuario(nickUsuario);
    }

    @WebMethod
    public void agregarAlbumFav(String nickCliente, String nickArtista, String nomAlbum) {
        iUsuario.agregarAlbumFav(nickCliente, nickArtista, nomAlbum);
    }

    @WebMethod
    public void agregarLPFav(String nickCliente, String nickClienteDuenio, String nomLista) {
        iUsuario.agregarLPFav(nickCliente, nickClienteDuenio, nomLista);
    }

    @WebMethod
    public void agregarLDFav(String nickCliente, String nomGenero, String nomLista) {
        iUsuario.agregarLDFav(nickCliente, nomGenero, nomLista);
    }

    @WebMethod
    public void agregarTemaFav(String nickCliente, String nickArtista, String nomAlbum, String nomTema) {
        iUsuario.agregarTemaFav(nickCliente, nickArtista, nomAlbum, nomTema);
    }

    @WebMethod
    public void quitarAlbumFav(String nickCliente, String nickArtista, String nomAlbum) {
        iUsuario.quitarAlbumFav(nickCliente, nickArtista, nomAlbum);
    }

    @WebMethod
    public void quitarLPFav(String nickCliente, String nickClienteDuenio, String nomLista) {
        iUsuario.quitarLPFav(nickCliente, nickClienteDuenio, nomLista);
    }

    @WebMethod
    public void quitarLDFav(String nickCliente, String nomGenero, String nomLista) {
        iUsuario.quitarLDFav(nickCliente, nomGenero, nomLista);
    }

    @WebMethod
    public void quitarTemaFav(String nickCliente, String nickArtista, String nomAlbum, String nomTema) {
        iUsuario.quitarTemaFav(nickCliente, nickArtista, nomAlbum, nomTema);
    }

    @WebMethod
    public DtAlbumContenido obtenerAlbumContenido(String nickArt, String nomAlbum) {
        return iUsuario.obtenerAlbumContenido(nickArt, nomAlbum);
    }

    @WebMethod
    public DtListaAlbum listarAlbumesArtista(String nickArtista) {
        return new DtListaAlbum(iUsuario.listarAlbumesArtista(nickArtista));
    }

    @WebMethod
    public DtListaDeListas listarLisReproduccion(String nickCliente) {
        return new DtListaDeListas(iUsuario.listarLisReproduccion(nickCliente));
    }

    @WebMethod
    public DtListaDeListas listarLisReproduccionGen(String nomGen) {
        return new DtListaDeListas(iContenido.listarLisReproduccionGen(nomGen));
    }
}
