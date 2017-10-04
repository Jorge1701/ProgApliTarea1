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

    private final String host = "localhost";
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

    //----------------------------------------------  arme otro tipo de conexion e hice funciones para simplificar la devoluciopnde datos-----------------
    //-----------------------------------------    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean conectar() // funcion que conecta al a base de ddatos con los parametros que estan arriba
    {

        this.url = "jdbc:mysql://" + host + "/" + db;

        try {
            //Class.forName("org.gjt.mm.mysql.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            this.Link = DriverManager.getConnection(this.url, this.user, this.pass);
            if (this.Link != null) {
                this.conectado = true;
                return true;
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION A: " + this.url + "  Configure correctamente los datos del servidor, si el problema persiste se recomienda reiniciar el servidor y el programa", "Problema de conexion", JOptionPane.INFORMATION_MESSAGE);

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public void desconectar()// cierra la conexion
    {
        this.Link = null;
    }

    public Connection GetConection() // devuele la conexion
    {
        return this.Link;
    }

    public boolean Ejecutar(String SQL)// funcion que ejecuta unaconsulta sql , que se pasa como string 
    {
        try {
            PreparedStatement Query = this.GetConection().prepareStatement(SQL);
            Query.execute();
            return true;
        } catch (SQLException ex) {
            //System.out.println("ERROR: "+ex);
            return false;
        }

    }

    public ResultSet Consultar(String SQL)//funcion que ejecuta consulta sql , que se pasa como string, yella devuelve un resulet con los datos 
    {
        try {
            PreparedStatement Query = this.GetConection().prepareStatement(SQL);
            ResultSet Resultado = Query.executeQuery();
            return Resultado;
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
            return null;
        }
    }

}
