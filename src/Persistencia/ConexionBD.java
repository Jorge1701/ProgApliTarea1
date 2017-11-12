package Persistencia;

import Configuracion.Configuracion;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    private final String host = Configuracion.get("ipBD");
    private final String port = Configuracion.get("puertoBD");
    private final String db = Configuracion.get("nomBD");
    private final String user = Configuracion.get("userBD");
    private final String pass = Configuracion.get("passBD");
    private Connection conexion = null;

    public ConexionBD() {
    }

    ;
    
    public Connection getConexion() {
        if (conexion == null) {
            try {
                Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);
                //conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, pass);
                conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false", user, pass); //De esta manera se elimina la advertencia de la conexion con la BD
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }

    public void cerrar() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
