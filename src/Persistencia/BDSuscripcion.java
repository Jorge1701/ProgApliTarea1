package Persistencia;

import Logica.DtArtista;
import Logica.DtFecha;
import Logica.DtUsuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class BDSuscripcion {

    protected Connection conexion = new ConexionBD().getConexion();

    public boolean ingresarSuscripcion(String nickname, String cuota, DtFecha fecha_venc, DtFecha fecha, String estado) {

        Date fecha1 = java.sql.Date.valueOf(fecha.getAnio() + "-" + fecha.getMes() + "-" + fecha.getDia());

        Date fecha_venc1 = java.sql.Date.valueOf(fecha_venc.getAnio() + "-" + fecha_venc.getMes() + "-" + fecha_venc.getDia());

        try {

            PreparedStatement insertar = conexion.prepareStatement("INSERT INTO suscripcion "
                    + "(nickname, cuota, fecha_venc,fecha,estado) values(?,?,?,?,?)");
            insertar.setString(1, nickname);
            insertar.setString(2, cuota);
            insertar.setDate(3, fecha_venc1);
            insertar.setDate(4, fecha1);
            insertar.setString(5, estado);
            insertar.executeUpdate();
            insertar.close();
            return true;
        } catch (SQLException ex) {
            ex.getStackTrace();
            Logger.getLogger(BDUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int getMonto(String cuota) {
        try {
            PreparedStatement sql = conexion.prepareStatement("SELECT monto FROM monto WHERE cuota='" + cuota + "'");
            int rs = sql.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(BDSuscripcion.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public boolean actulizarSuscripcion(String nickname, String estado, DtFecha fecha, DtFecha fecha_venc) {
        Date fecha1 = java.sql.Date.valueOf(fecha.getAnio() + "-" + fecha.getMes() + "-" + fecha.getDia());
        if (fecha_venc != null) {
            Date fecha_venc1 = java.sql.Date.valueOf(fecha_venc.getAnio() + "-" + fecha_venc.getMes() + "-" + fecha_venc.getDia());

            try {
                PreparedStatement sql = conexion.prepareStatement("UPDATE suscripcion SET estado='" + estado + "',fecha='" + fecha1 + "',fecha_venc='" + fecha_venc1 + "' WHERE nickname='" + nickname + "'");
                sql.executeUpdate();
                sql.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(BDSuscripcion.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        } else {

            try {
                PreparedStatement sql = conexion.prepareStatement("UPDATE suscripcion SET estado='" + estado + "',fecha='" + fecha1 + "' WHERE nickname='" + nickname + "'");
                sql.executeUpdate();
                sql.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(BDSuscripcion.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }

    }

}
