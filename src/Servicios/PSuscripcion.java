package Servicios;

import Logica.DtArtista;
import Logica.DtCliente;
import Logica.DtFecha;
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
public class PSuscripcion {

    private Endpoint endpoint = null;
    PropertyManager properties;
    IUsuario iUsuario;

    String ip;
    String puerto;
    String servicio;

    public PSuscripcion() {
        properties = PropertyManager.getInstance();
        iUsuario = Fabrica.getIControladorUsuario();
        this.ip = properties.getProperty("ip");
        this.puerto = properties.getProperty("puerto");
        this.servicio = "suscripcion";//properties.getProperty("servicio");
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + ip + ":" + puerto + "/" + servicio, this);
    }

    @WebMethod
    public int getMonto(String cuota) {
        return iUsuario.getMonto(cuota);
    }

    @WebMethod
    public boolean ingresarSuscripcion(String nickname, String cuota) {
        return iUsuario.ingresarSuscripcion(nickname, cuota);
    }

    @WebMethod
    public DtUsuario getDataUsuario(String nickname) {
        return iUsuario.getDataUsuario(nickname);
    }

    @WebMethod
    public boolean cancelarSuscripcion(String nickname, String previo, String cuota, String fecha, String fecha_venc, DtFecha hoy) {
        return iUsuario.cancelarSuscripcion(nickname, previo, cuota, fecha, fecha_venc, hoy);
    }

    @WebMethod
    public boolean renovarSuscripcion(String nickname, String estado, String cuota, String fecha, String fecha_venc, DtFecha cambio) {
        return iUsuario.renovarSuscripcion(nickname, estado, cuota, fecha, fecha_venc, cambio);
    }
    
    @WebMethod
    public void DtArtista(DtArtista dta){
    }
    @WebMethod
    public void DtCliente(DtCliente dta){
    }

}
