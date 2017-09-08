package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDGenero {

    protected Connection conexion = new ConexionBD().getConexion();

    // ingresar generos a la BD
    public boolean ingresarGeneros(String nombre, String padre) {

        try {
            PreparedStatement insertar = conexion.prepareStatement("INSERT INTO genero(nombreGenero,Padre) VALUES(?,?)");
            insertar.setString(1, nombre);
            if (padre == null) {
                insertar.setNull(2, Types.VARCHAR);
            } else {
                insertar.setString(2, padre);
            }
            insertar.executeUpdate();
            insertar.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDGenero.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

}
