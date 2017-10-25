package Servicios;

import Configuracion.Configuracion;
import Logica.Fabrica;
import Logica.IUsuario;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC)
public class PDesactivarArtista {

    private Endpoint endpoint = null;

    private IUsuario iUsuario;

    public PDesactivarArtista() {
        iUsuario = Fabrica.getIControladorUsuario();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PDesactivarArtista"), this);
    }

    @WebMethod
    public void desactivar(String nickname) {
        iUsuario.desactivar(nickname);
    }
}
