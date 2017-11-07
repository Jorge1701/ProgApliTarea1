package Servicios;

import Configuracion.Configuracion;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC)
public class PSeguir {

    private Endpoint endpoint = null;

    private IUsuario iUsuario;

    public PSeguir() {
        iUsuario = Fabrica.getIControladorUsuario();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PSeguir"), this);
    }

    @WebMethod
    public DtUsuario getDataUsuario(String nickUsuario) {
        return iUsuario.getDataUsuario(nickUsuario);
    }

    @WebMethod
    public void seguirUsuario(String nickC, String nickU) {
        iUsuario.seguirUsuario(nickC, nickU);
    }

    @WebMethod
    public void dejarSeguirUsuario(String nickSeguidor, String nickUsuario) {
        iUsuario.dejarSeguirUsuario(nickSeguidor, nickUsuario);
    }
}
