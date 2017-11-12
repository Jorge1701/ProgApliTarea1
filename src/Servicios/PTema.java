package Servicios;

import Configuracion.Configuracion;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PTema {

    private Endpoint endpoint = null;

    public PTema() {
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PTema"), this);
    }

    @WebMethod
    public byte[] getAudio(@WebParam(name = "audio")String audio) {
        byte[] byteArray = null;
        try {
            File f = new File(Configuracion.get("pathMusica") + audio);
            FileInputStream streamer = new FileInputStream(f);
            byteArray = new byte[streamer.available()];
            streamer.read(byteArray);
        } catch (IOException e) {
            Logger.getLogger(PInicio.class.getName()).log(Level.SEVERE, null, e);
        }
        return byteArray;
    }

}
