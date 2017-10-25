package Servicios;

import Configuracion.Configuracion;
import Logica.DtBuscado;
import Logica.DtListaBuscados;
import Logica.DtTema;
import Logica.DtTemaLocal;
import Logica.DtTemaRemoto;
import Logica.Fabrica;
import Logica.IContenido;
import java.util.ArrayList;
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
        objetos = new ArrayList<>();
    }

    private ArrayList<DtBuscado> objetos;

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PBuscador"), this);
    }

    @WebMethod
    public DtListaBuscados buscar(String texto, String orden) {
        return new DtListaBuscados(iContenido.buscar(texto, orden));
    }

    @WebMethod
    public DtTema asd(DtTemaRemoto r, DtTemaLocal l) {
        return null;
    }
}
