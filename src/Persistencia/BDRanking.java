package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class BDRanking {

    protected Connection conexion = new ConexionBD().getConexion();

    public ArrayList<String[]> cargarUsuarios() {
        try {
            ArrayList<String[]> res = new ArrayList<>();
            PreparedStatement sql = conexion.prepareStatement("SELECT nickname FROM artista");
            ResultSet sus = sql.executeQuery();
            PreparedStatement sql2 = null;
            while (sus.next()) {
                String nickname = sus.getString("nickname");
                sql2 = conexion.prepareStatement("SELECT COUNT(*) As Cantidad FROM seguir_usuario WHERE nickname_u='" + nickname + "'");
                ResultSet sus2 = sql2.executeQuery();
                sus2.next();
                int cant = sus2.getInt(1);
                if (cant > 0) {
                    res.add(new String[]{nickname, String.valueOf(cant)});
                }
            }

            sql.close();

            PreparedStatement sql3 = conexion.prepareStatement("SELECT nickname FROM cliente");
            ResultSet sus3 = sql3.executeQuery();

            while (sus3.next()) {
                String nickname = sus3.getString("nickname");
                sql2 = conexion.prepareStatement("SELECT COUNT(*) As Cantidad FROM seguir_usuario WHERE nickname_u='" + nickname + "'");
                ResultSet sus2 = sql2.executeQuery();
                sus2.next();
                int cant = sus2.getInt(1);
                if (cant > 0) {
                    res.add(new String[]{nickname, String.valueOf(cant)});
                }
            }

            sql3.close();
            sql2.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
