/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Configuracion.Configuracion;
import Logica.DtPerfilArtista;
import Logica.DtPerfilCliente;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Diego
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PConsultaPerfil {

    private Endpoint endpoint = null;
    IUsuario iUsuario;

    public PConsultaPerfil() {
        iUsuario = Fabrica.getIControladorUsuario();
    }

    public void publicar() {
        endpoint = Endpoint.publish("http://" + Configuracion.get("ip") + ":" + Configuracion.get("puerto") + "/" + Configuracion.get("PConsultaPerfil"), this);
    }

    @WebMethod
    public DtUsuario getDataUsuario(String nickname) {
        DtUsuario dtUs = iUsuario.getDataUsuario(nickname);
        /*if (dtUs == null) {
            try {
                throw new SoapSeviciosFaultException(new SimpleExceptionBean(), "NickName no valido");
            } catch (SoapSeviciosFaultException ex) {
                Logger.getLogger(PConsultaPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/

        return dtUs;
    }

    @WebMethod
    public DtPerfilCliente obtenerPerfilCliente(String nickUs) {
        DtPerfilCliente DtPerfilC = (DtPerfilCliente) iUsuario.obtenerPerfilCliente(nickUs);
        return DtPerfilC;
    }

    @WebMethod
    public DtPerfilArtista obtenerPerfilArtista(String nickUs) {
        DtPerfilArtista dtPerfilArtista = (DtPerfilArtista) iUsuario.obtenerPerfilArtista(nickUs);
        return dtPerfilArtista;

    }

}
