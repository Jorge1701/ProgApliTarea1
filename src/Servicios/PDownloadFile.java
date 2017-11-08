/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Configuracion.Configuracion;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author brian
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PDownloadFile {

    private Endpoint endpoint = null;

    IUsuario iUsuario;
    IContenido iContenido;

    public PDownloadFile() {
        this.iUsuario = Fabrica.getIControladorUsuario();
        this.iContenido = Fabrica.getIControladorContenido();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PDownloadFile"), this);
    }

    @WebMethod
    public byte[] getFile(@WebParam(name = "fileName") String filename) {
        String filepath = Configuracion.get("pathMusica");

        byte[] byteArray = null;


        try {
            File f = new File(filepath + filename);
            FileInputStream streamer = new FileInputStream(f);
            byteArray = new byte[streamer.available()];
            streamer.read(byteArray);
        } catch (IOException e) {

        }
        return byteArray;

    }

}
