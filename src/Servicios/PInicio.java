package Servicios;

import Logica.DtListaString;
import Logica.DtListaUsuarios;
import Logica.DtSuscripcion;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import Presentacion.PropertyManager;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PInicio {

    private Endpoint endpoint = null;
    PropertyManager properties;
    IUsuario iUsuario;
    IContenido iContenido;

    String ip;
    String puerto;
    String servicio;

    public PInicio() {
        properties = PropertyManager.getInstance();
        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
        this.ip = properties.getProperty("ip");
        this.puerto = properties.getProperty("puerto");
        this.servicio = "inicio";//properties.getProperty("servicio");
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + ip + ":" + puerto + "/" + servicio, this);
    }

    @WebMethod
    public void cargarDatosPrueba() throws Exception {
        Fabrica.cargaDatosPrueba();
    }

    @WebMethod
    public DtListaString obtenerGeneros() {
        DtListaString generos = new DtListaString(iContenido.obtenerGeneros());
        return generos;
    }

    @WebMethod
    public DtListaUsuarios listarClientes() {
        DtListaUsuarios clientes = new DtListaUsuarios(iUsuario.listarClientes());
        return clientes;
    }

    @WebMethod
    public DtListaUsuarios listarArtistas() {
        DtListaUsuarios artistas = new DtListaUsuarios(iUsuario.listarArtistas());
        return artistas;
    }

    @WebMethod
    public boolean chequearSuscripcion(String nickname) {
        return iUsuario.chequearSuscripcion(nickname);
    }

    @WebMethod
    public DtUsuario getDataUsuario(String nickname) {                          //Funcion repetida en PRegistro
        return iUsuario.getDataUsuario(nickname);
    }

    @WebMethod
    public DtListaUsuarios listarSeguidosDe(String nickname) {
        return new DtListaUsuarios(iUsuario.listarSeguidosDe(nickname));
    }

    @WebMethod
    public void DtSuscripcion(DtSuscripcion dts) {                              //Funcion para generear la clase en servicios.DtSuscripcion correctamente 

    }

}
