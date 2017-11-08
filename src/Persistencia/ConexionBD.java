package Persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionBD {

    private final String host = "127.0.0.1";
    private final String port = "3306";
    private final String db = "espotify";
    private final String user = "root";
    private final String pass = "rooteo";
    private String url;
    public Connection Link = null;
    public boolean conectado;
    //Para hacer ConexionDB singleton descomentar
    //private static Connection conexion=null;
    private Connection conexion = null;

    //Para hacer ConexionDB singleton descomentar
    //private ConexionDB(){};
    public ConexionBD() {
    }

    ;
    //Para hacer ConexionDB singleton descomentar
    //public static Connection getConexion() {
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
