package Servicios;

import Configuracion.Configuracion;
import Logica.DtArtista;
import Logica.DtCliente;
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
public class PRegistro {

    private Endpoint endpoint = null;
    IUsuario iUsuario;

    public PRegistro() {
        iUsuario = Fabrica.getIControladorUsuario();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PRegistro"), this);
    }

    @WebMethod
    public DtUsuario getDataUsuario(String nickname) {
        return iUsuario.getDataUsuario(nickname);
    }

    @WebMethod
    public boolean correoExiste(String correo) {
        return iUsuario.correoExiste(correo);
    }

    @WebMethod
    public boolean nicknameExiste(String nickname) {
        return iUsuario.nicknameExiste(nickname);
    }

    @WebMethod
    public boolean ingresarUsuario(DtUsuario usuario) {
        return iUsuario.ingresarUsuario(usuario);
    }

    @WebMethod
    public void DtArtista(DtArtista dta) {
    }

    @WebMethod
    public void DtCliente(DtCliente dta) {
    }
}
