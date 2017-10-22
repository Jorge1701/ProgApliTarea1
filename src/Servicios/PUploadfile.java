package Servicios;

import Configuracion.Configuracion;
import java.io.FileOutputStream;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Luis
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PUploadfile {

    private Endpoint endpoint = null;

    public PUploadfile() {
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PUploadfile"), this);
    }

    @WebMethod
    public Boolean Uploadfile(@WebParam(name = "archivo") byte[] archivo, @WebParam(name = "filename") String nombre, @WebParam(name = "recurso") String recurso) throws Exception {

        if (!nombre.equals("")) {
            String path = null;
            if (recurso.equals("Usuario")) {
                path = Configuracion.get("pathImagenesUsuario");

            } else if (recurso.equals("Album")) {
                path = Configuracion.get("pathImagenesAlbum");
            } else if (recurso.equals("Lista")) {
                path = Configuracion.get("pathImagenesLista");

            }
            //
            FileOutputStream stream = new FileOutputStream(path + nombre);
            try {
                stream.write(archivo);
            } finally {
                stream.close();
                return true;
            }
        }
        return false;
    }

}
