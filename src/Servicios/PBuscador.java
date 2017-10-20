package Servicios;

import Configuracion.Configuracion;
import Logica.DtListaObjetos;
import Logica.Fabrica;
import Logica.IContenido;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC)
public class PBuscador {

    private Endpoint endpoint = null;

    private IContenido iContenido;

    public PBuscador() {
        iContenido = Fabrica.getIControladorContenido();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PBuscador"), this);
    }

    @WebMethod
    public DtListaObjetos buscar(String texto, String orden) {
        return new DtListaObjetos(iContenido.buscar(texto, orden));
    }
}
