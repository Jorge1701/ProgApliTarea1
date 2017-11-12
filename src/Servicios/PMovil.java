/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Configuracion.Configuracion;
import Logica.DtAlbumContenido;
import Logica.DtListaAlbum;
import Logica.DtListaDeListas;
import Logica.DtListaString;
import Logica.DtListaUsuarios;
import Logica.DtPerfilArtista;
import Logica.DtPerfilUsuario;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Brian
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PMovil {

    private Endpoint endpoint = null;

    private IUsuario iUsuario;
    private IContenido iContenido;

    public PMovil() {
        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
    }


    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PMovil"), this);

    }

    @WebMethod
    public String chequearLogin(String nickname, String contrasenia) {
        return iUsuario.chequearLogin(nickname, contrasenia);
    }

    @WebMethod
    public boolean esCliente(String nickname) {
        return iUsuario.esCliente(nickname);
    }

    @WebMethod
    public DtListaString obtenerGeneros() {

        return new DtListaString(iContenido.obtenerGeneros());
    }

    @WebMethod
    public DtListaUsuarios listarArtistas() {
        return new DtListaUsuarios(iUsuario.listarArtistas());
    }

    @WebMethod
    public DtUsuario getDataUsuario(String nickUsuario) {

        return iUsuario.getDataUsuario(nickUsuario);
    }

    @WebMethod
    public DtAlbumContenido obtenerAlbumContenido(String nickArtista, String nomAlbum) {

        return iUsuario.obtenerAlbumContenido(nickArtista, nomAlbum);
    }

    @WebMethod
    public DtUsuario getDataCliente(String nickCliente) {

        return iUsuario.getDataCliente(nickCliente);
    }

    @WebMethod
    public boolean existeGenero(String genero) {
        return iContenido.existeGenero(genero);
    }

    @WebMethod
    public DtListaAlbum listarAlbumesGenero(String genero) {
        return new DtListaAlbum(iContenido.listarAlbumesGenero(genero));
    }

    @WebMethod
    public DtPerfilUsuario obtenerPerfilArtista(String nickUs) {
        return iUsuario.obtenerPerfilArtista(nickUs);
    }

    @WebMethod
    public DtListaDeListas listarLisReproduccion(String genero) {
        return new DtListaDeListas(iContenido.listarLisReproduccionGen(genero));
    }

    @WebMethod
    public void a(DtPerfilArtista a) {

    }

}
