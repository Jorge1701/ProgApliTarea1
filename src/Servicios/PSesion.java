package Servicios;

import Configuracion.Configuracion;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PSesion {

    private Endpoint endpoint = null;
    IUsuario iUsuario;

    public PSesion() {
        iUsuario = Fabrica.getIControladorUsuario();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PSesion"), this);
    }

    @WebMethod
    public DtUsuario getDataUsuario(String seguido) {
        return iUsuario.getDataUsuario(seguido);
    }

    @WebMethod
    public String chequearLogin(String nickname, String contrasenia) {
        return iUsuario.chequearLogin(nickname, contrasenia);
    }

}
