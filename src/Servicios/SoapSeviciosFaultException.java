
package Servicios;

import javax.xml.ws.WebFault;

@WebFault(name = "SoapSeviciosFaultException")
public class SoapSeviciosFaultException extends Exception {
    
    SimpleExceptionBean faultBean;

    public SoapSeviciosFaultException(){
        
    }
    /*public SoapSeviciosFaultException(SimpleExceptionBean faultBean, String message) {
        super(message);
        this.faultBean = faultBean;
    }*/

   /* public SoapSeviciosFaultException(SimpleExceptionBean faultBean, String message, Throwable cause) {
        super(message, cause);
        this.faultBean = faultBean;
    }*/

    public SimpleExceptionBean getFaultBean() {
        return faultBean;
    }

    public void setFaultBean(SimpleExceptionBean faultBean) {
        this.faultBean = faultBean;
    }

}
