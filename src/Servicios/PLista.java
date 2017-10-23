/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.DtListaDeListas;
import Logica.DtListaParticular;
import Logica.DtListaString;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import Presentacion.PropertyManager;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author brian
 */
@WebService()
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PLista {

    private Endpoint endpoint = null;
    PropertyManager properties;

    private IUsuario iUsuario;
    private IContenido iContenido;
    String ip;
    String puerto;
    String servicio;

    public PLista() {
        properties = PropertyManager.getInstance();
        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
        this.ip = properties.getProperty("ip");
        this.puerto = properties.getProperty("puerto");
        this.servicio = "lista";
    }

    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://" + ip + ":" + puerto + "/" + servicio, this);

    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public DtListaDeListas listarListaReproduccionCli(String nickname) {
        DtListaDeListas listas = new DtListaDeListas(iUsuario.listarListaReproduccionCli(nickname));
        return listas;
    }

    @WebMethod
    public boolean crearListaReproduccion(DtListaParticular lista, String nickname) {
        return iContenido.crearListaReproduccion(lista, nickname);
    }

}
