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
public class PContadores {

    private Endpoint endpoint = null;

    private IUsuario iUsuario;

    public PContadores() {
        iUsuario = Fabrica.getIControladorUsuario();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PContadores"), this);
    }

    @WebMethod
    public void reproducirTema(String nickArtista, String nomAlbum, String nomTema) {
        iUsuario.reproducirTema(nickArtista, nomAlbum, nomTema);
    }
}
