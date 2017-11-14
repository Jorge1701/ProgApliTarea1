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
import Configuracion.Configuracion;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author brian
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PLista {

    private Endpoint endpoint = null;

    private IUsuario iUsuario;
    private IContenido iContenido;

    public PLista() {
        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PLista"), this);

    }

    @WebMethod
    public boolean existeLista(String lista, String nickname) {
        return iUsuario.listaExiste(lista, nickname);
    }

    @WebMethod
    public boolean crearListaReproduccion(DtListaParticular lista, String nickname) {
        return iContenido.crearListaReproduccion(lista, nickname);
    }

}
