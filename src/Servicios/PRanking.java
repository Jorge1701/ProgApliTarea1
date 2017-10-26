package Servicios;

import Configuracion.Configuracion;
import Logica.DtListaRanking;
import Logica.DtRanking;
import Logica.Fabrica;
import Logica.IUsuario;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC)
public class PRanking {
    private Endpoint endpoint = null;

    private IUsuario iUsuario;
    
    public PRanking(){
    iUsuario = Fabrica.getIControladorUsuario();
    }
    
    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PRanking"), this);
    }
    
    @WebMethod
    public DtListaRanking obtenerRanking() {
        return new DtListaRanking(iUsuario.obtenerRanking().getRanking());
    }
}
