package Servicios;

import Configuracion.Configuracion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PUploadfile {

    private Endpoint endpoint = null;

    public PUploadfile() {
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PUploadfile"), this);
    }

    @WebMethod
    public Boolean Uploadfile(byte[] archivo, String nombre, String recurso) {

        if (!nombre.equals("")) {
            String path = null;
            switch (recurso) {
                case "registro":
                    path = Configuracion.get("pathImagenesUsuario");
                    break;
                case "album":
                    path = Configuracion.get("pathImagenesAlbum");
                    break;
                case "lista":
                    path = Configuracion.get("pathImagenesLista");
                    break;
                case "tema":
                    path = Configuracion.get("pathMusica");
                    break;
                default:
                    break;
            }
            //
            try {

                OutputStream stream = new FileOutputStream(new File(path + nombre));
                byte[] buffer = archivo;
                stream.write(buffer, 0, archivo.length);
                stream.close();
                return true;
            } catch (FileNotFoundException ex) {
                return false;
            } catch (IOException ex) {
                return false;
            }

        }
        return false;
    }

}
