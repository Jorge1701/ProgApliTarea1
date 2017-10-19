package Servicios;

import Logica.DtListaUsuarios;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import Presentacion.PropertyManager;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PSesion {

    private Endpoint endpoint = null;
    PropertyManager properties;
    IUsuario iUsuario;

    String ip;
    String puerto;
    String servicio;

    public PSesion() {
        properties = PropertyManager.getInstance();
        iUsuario = Fabrica.getIControladorUsuario();
        this.ip = properties.getProperty("ip");
        this.puerto = properties.getProperty("puerto");
        this.servicio = "registro";//properties.getProperty("servicio");
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + ip + ":" + puerto + "/" + servicio, this);
    }

    
     @WebMethod
     public DtUsuario getDataUsuario(String seguido){
         return iUsuario.getDataUsuario(seguido);
     }
}
