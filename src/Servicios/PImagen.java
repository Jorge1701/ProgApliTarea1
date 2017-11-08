package Servicios;

import Configuracion.Configuracion;
import java.io.File;
import java.io.FileInputStream;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PImagen {

    private Endpoint endpoint = null;

    public PImagen() {
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PImagen"), this);
    }

    @WebMethod
    public byte[] getFile(@WebParam(name = "recurso") String recurso, @WebParam(name = "fileName") String nombre) {
        byte[] byteArray = null;
        try {
            if (!nombre.equals("")) {
                String path = null;
                if (recurso.equals("Usuario")) {
                    path = Configuracion.get("pathImagenesUsuario");

                } else if (recurso.equals("Album")) {
                    path = Configuracion.get("pathImagenesAlbum");
                } else if (recurso.equals("Lista")) {
                    path = Configuracion.get("pathImagenesLista");

                }
                File f = new File(path + nombre);
                FileInputStream streamer = new FileInputStream(f);
                byteArray = new byte[streamer.available()];
                streamer.read(byteArray);
            }
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return byteArray;
    }
}
