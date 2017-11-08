/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import javax.xml.ws.WebFault;


/**
 *
 * @author Diego
 */
@WebFault(name = "SoapSeviciosFaultException")
public class SoapSeviciosFaultException extends Exception {

    /**
     * Creates a new instance of <code>SoapFaultException</code> without detail
     * message.
     */
    
    protected  SimpleExceptionBean faultBean;

    public SoapSeviciosFaultException(SimpleExceptionBean faultBean, String message) {
        super(message);
        this.faultBean = faultBean;
    }

    public SoapSeviciosFaultException(SimpleExceptionBean faultBean, String message, Throwable cause) {
        super(message, cause);
        this.faultBean = faultBean;
    }

    public SimpleExceptionBean getFaultBean() {
        return faultBean;
    }
    
    
    
    
    
    
}
