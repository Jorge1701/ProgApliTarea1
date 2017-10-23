package Servicios;

import Configuracion.Configuracion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PUploadfile {

    private Endpoint endpoint = null;

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PUploadfile"), this);
    }

    public PUploadfile() {

    }

    @WebMethod
    public boolean upload(String ubicacion, String filename, byte[] file) {
        String path = "";
        if (ubicacion != null) {
            switch (ubicacion) {
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
            }
        }

        try {
            OutputStream outstream = new FileOutputStream(new File(path + filename));
            byte[] buffer = file;
            outstream.write(buffer, 0, file.length);
            outstream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
