/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Presentacion.PropertyManager;
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

/**
 *
 * @author Diego
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PImagen {
    
    private Endpoint endpoint = null;
    PropertyManager properties;
    
    String ip;
    String puerto;
    String servicio;

    public PImagen() {
        properties = PropertyManager.getInstance();
        this.ip = properties.getProperty("ip");
        this.puerto = properties.getProperty("puerto");
        this.servicio = "imagen";
    }
    
    public void publicar() {
        endpoint = Endpoint.publish("http://" + ip + ":" + puerto + "/" + servicio, this);
    }
    
    @WebMethod
    public byte[] getFile(@WebParam(name = "recurso") String recurso, @WebParam(name = "fileName") String nombre) throws Exception {
        byte[] byteArray = null;
        try {
                if (!nombre.equals("")){
                    String path = null;                
                    if(recurso.equals("Usuario")){
                        path = properties.getProperty("pathImagenesUsuario");

                    }else if(recurso.equals("Album")){
                        path = properties.getProperty("pathImagenesAlbum");
                    }else if(recurso.equals("Lista")){                    
                        path = properties.getProperty("pathImagenesLista");

                    }             
                    File f = new File(path + nombre);
                    FileInputStream streamer = new FileInputStream(f);
                    byteArray = new byte[streamer.available()];
                    streamer.read(byteArray);
                }
        } catch (Exception e) {
                System.out.println("recurso: " + recurso );
                System.out.println("nombre: " + nombre );
                throw e;
        }
        return byteArray;
    }
    
    
    
}
