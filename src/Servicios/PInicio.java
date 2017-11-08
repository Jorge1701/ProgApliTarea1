package Servicios;

import Configuracion.Configuracion;
import Logica.DtCliente;
import Logica.DtListaString;
import Logica.DtListaUsuarios;
import Logica.DtSuscripcion;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PInicio {

    private Endpoint endpoint = null;
    IUsuario iUsuario;
    IContenido iContenido;

    public PInicio() {
        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
    }

    public void publicar() {
        
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PInicio"), this);
    }

    @WebMethod
    public void cargarDatosPrueba() {
        
        try {
            Fabrica.cargaDatosPrueba();
        } catch (Exception ex) {
            Logger.getLogger(PInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public DtCliente getDataCliente(String nickname) {
        return iUsuario.getDataCliente(nickname);
    }

    @WebMethod
    public DtListaUsuarios listarSeguidosDe(String nickname) {
        return new DtListaUsuarios(iUsuario.listarSeguidosDe(nickname));
    }

    @WebMethod
    public void DtSuscripcion(DtSuscripcion dts) {                              //Funcion para generear la clase en servicios.DtSuscripcion correctamente 

    }


}
