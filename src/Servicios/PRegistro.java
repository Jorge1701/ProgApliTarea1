package Servicios;

import Logica.DtArtista;
import Logica.DtCliente;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import Presentacion.PropertyManager;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC)
public class PRegistro {

    private Endpoint endpoint = null;
    PropertyManager properties;
    IUsuario iUsuario;

    String ip;
    String puerto;
    String servicio;

    public PRegistro() {
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
    public void DtArtista(DtArtista dta){
    }
    @WebMethod
    public void DtCliente(DtCliente dta){
    }

}
