package Persistencia;

import Logica.DtFecha;
import Logica.DtSuscripcion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDSuscripcion {

    protected Connection conexion = new ConexionBD().getConexion();

    public boolean ingresarSuscripcion(String nickname, String cuota, DtFecha fecha_venc, DtFecha fecha, String estado) {
        try {

            PreparedStatement insertar = conexion.prepareStatement("INSERT INTO suscripcion "
                    + "(nickname, cuota, fecha_venc,fecha,estado) values(?,?,?,?,?)");
            insertar.setString(1, nickname);
            insertar.setString(2, cuota);
            if (fecha_venc == null) {
                insertar.setNull(3, Types.DATE);
            } else {
                insertar.setString(3, String.valueOf(fecha_venc.getAnio()) + "-" + String.valueOf(fecha_venc.getMes() + 1) + "-" + String.valueOf(fecha_venc.getDia()));
            }
            insertar.setString(4, String.valueOf(fecha.getAnio()) + "-" + String.valueOf(fecha.getMes()) + "-" + String.valueOf(fecha.getDia()));
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
        int monto = 0;
        try {
            PreparedStatement sql = conexion.prepareStatement("SELECT m.monto FROM monto as m WHERE cuota='" + cuota + "'");
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                monto = rs.getInt("monto");
                return monto;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDSuscripcion.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return monto;
    }

    public boolean actulizarSuscripcion(String nickname, DtSuscripcion s, String estado, DtFecha cambio, DtFecha fecha_venc) {

        Date fecha1 = java.sql.Date.valueOf(s.getFecha().getAnio() + "-" + s.getFecha().getMes() + "-" + s.getFecha().getDia());
        Date fechavenc1 = null;
        if (s.getFechaVenc() != null) {
            fechavenc1 = java.sql.Date.valueOf(s.getFechaVenc().getAnio() + "-" + s.getFechaVenc().getMes() + "-" + s.getFechaVenc().getDia());
        }
        //las de arriba son para ubicar la suscripcion en la bd
        Date cambio1 = java.sql.Date.valueOf(cambio.getAnio() + "-" + cambio.getMes() + "-" + cambio.getDia());

        if (fecha_venc != null) {
            Date fecha_venc1 = java.sql.Date.valueOf(fecha_venc.getAnio() + "-" + fecha_venc.getMes() + "-" + fecha_venc.getDia());

            try {
                PreparedStatement sql;
                if (fechavenc1 != null) {
                    sql = conexion.prepareStatement("SELECT idSuscripcion FROM suscripcion WHERE nickname = '" + nickname + "' and cuota = '" + s.getCuota() + "' and  estado = '" + s.getEstado() + "' and fecha = '" + fecha1 + "' and fecha_venc = '" + fechavenc1 + "'");
                } else {
                    sql = conexion.prepareStatement("SELECT idSuscripcion FROM suscripcion WHERE nickname = '" + nickname + "' and cuota = '" + s.getCuota() + "' and  estado = '" + s.getEstado() + "' and fecha = '" + fecha1 + "' and fecha_venc IS NULL");
                }
                ResultSet id = sql.executeQuery();

                id.next();
                int idSuscripcion = id.getInt(1);
                sql.close();

                PreparedStatement sql2 = conexion.prepareStatement("UPDATE suscripcion SET estado='" + estado + "',fecha='" + fecha1 + "',fecha_venc='" + fecha_venc1 + "' WHERE idSuscripcion='" + idSuscripcion + "'");
                sql2.executeUpdate();
                sql2.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(BDSuscripcion.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        } else {

            try {
                PreparedStatement sql = conexion.prepareStatement("SELECT idSuscripcion FROM suscripcion WHERE nickname = '" + nickname + "' and cuota = '" + s.getCuota() + "' and  estado= '" + s.getEstado() + "' and fecha = '" + fecha1 + "' and fecha_venc = '" + fechavenc1 + "'");
                ResultSet id = sql.executeQuery();
                id.next();
                int idSuscripcion = id.getInt(1);
                sql.close();

                PreparedStatement sql2 = conexion.prepareStatement("UPDATE suscripcion SET estado='" + estado + "',fecha='" + cambio1 + "' WHERE idSuscripcion='" + idSuscripcion + "'");
                sql2.executeUpdate();
                sql2.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(BDSuscripcion.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }

    }

    public boolean expirarSuscripcion(String nickname, DtSuscripcion s) {

        Date fecha = java.sql.Date.valueOf(s.getFecha().getAnio() + "-" + s.getFecha().getMes() + "-" + s.getFecha().getDia());

        Date fecha_venc = java.sql.Date.valueOf(s.getFechaVenc().getAnio() + "-" + s.getFechaVenc().getMes() + "-" + s.getFechaVenc().getDia());

        try {
            PreparedStatement sql = conexion.prepareStatement("SELECT idSuscripcion FROM suscripcion WHERE nickname = '" + nickname + "' and cuota = '" + s.getCuota() + "' and  estado= '" + s.getEstado() + "' and fecha = '" + fecha + "' and fecha_venc = '" + fecha_venc + "'");
            ResultSet id = sql.executeQuery();
            id.next();
            int idSuscripcion = id.getInt(1);
            sql.close();

            PreparedStatement sql2 = conexion.prepareStatement("UPDATE suscripcion SET estado='Vencida' WHERE idSuscripcion='" + idSuscripcion + "'");
            sql2.executeUpdate();
            sql2.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BDSuscripcion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean renovarSuscripcion(DtSuscripcion s, String nickname, DtFecha cambio, DtFecha fecha_venc) {

        Date fecha1 = java.sql.Date.valueOf(s.getFecha().getAnio() + "-" + s.getFecha().getMes() + "-" + s.getFecha().getDia());

        Date fechav = java.sql.Date.valueOf(s.getFechaVenc().getAnio() + "-" + s.getFechaVenc().getMes() + "-" + s.getFechaVenc().getDia());

        Date cambio1 = java.sql.Date.valueOf(cambio.getAnio() + "-" + cambio.getMes() + "-" + cambio.getDia());
        System.out.println("fecha_venc: " + fecha_venc.getAnio() + "-" + fecha_venc.getMes() + "-" + fecha_venc.getDia());
        Date fecha_venc1;
        if (fecha_venc.getMes() == 0) {
            fecha_venc1 = java.sql.Date.valueOf(fecha_venc.getAnio() + "-" + (fecha_venc.getMes()+1) + "-" + fecha_venc.getDia());
        } else {
            fecha_venc1 = java.sql.Date.valueOf(fecha_venc.getAnio() + "-" + fecha_venc.getMes() + "-" + fecha_venc.getDia());
        }
        try {
            PreparedStatement sql = conexion.prepareStatement("SELECT idSuscripcion FROM suscripcion WHERE nickname = '" + nickname + "' and cuota = '" + s.getCuota() + "' and  estado= '" + s.getEstado() + "' and fecha = '" + fecha1 + "' and fecha_venc = '" + fechav + "'");
            ResultSet id = sql.executeQuery();
            id.next();
            int idSuscripcion = id.getInt(1);
            sql.close();
            //
            PreparedStatement sql2 = conexion.prepareStatement("UPDATE suscripcion SET estado='Vigente', fecha='" + cambio1 + "' , fecha_venc='" + fecha_venc1 + "'  WHERE idSuscripcion='" + idSuscripcion + "'");
            sql2.executeUpdate();
            sql2.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BDSuscripcion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean cancelarSuscripcion(DtSuscripcion s, String nickname, DtFecha cambio) {

        Date fecha = java.sql.Date.valueOf(s.getFecha().getAnio() + "-" + s.getFecha().getMes() + "-" + s.getFecha().getDia());
        Date fecha_cambio = java.sql.Date.valueOf(cambio.getAnio() + "-" + cambio.getMes() + "-" + cambio.getDia());

        if (s.getFechaVenc() != null) {

            Date fecha_venc = java.sql.Date.valueOf(s.getFechaVenc().getAnio() + "-" + s.getFechaVenc().getMes() + "-" + s.getFechaVenc().getDia());

            try {
                PreparedStatement sql = conexion.prepareStatement("SELECT idSuscripcion FROM suscripcion WHERE nickname = '" + nickname + "' and cuota = '" + s.getCuota() + "' and  estado= '" + s.getEstado() + "' and fecha = '" + fecha + "' and fecha_venc = '" + fecha_venc + "'");
                ResultSet id = sql.executeQuery();
                id.next();
                int idSuscripcion = id.getInt(1);
                sql.close();

                PreparedStatement sql2 = conexion.prepareStatement("UPDATE suscripcion SET estado='Cancelada', fecha='" + fecha_cambio + "' WHERE idSuscripcion='" + idSuscripcion + "'");
                sql2.executeUpdate();
                sql2.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(BDSuscripcion.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            try {
                PreparedStatement sql = conexion.prepareStatement("SELECT idSuscripcion FROM suscripcion WHERE nickname = '" + nickname + "' and cuota = '" + s.getCuota() + "' and  estado= '" + s.getEstado() + "' and fecha = '" + fecha + "'");
                ResultSet id = sql.executeQuery();
                id.next();
                int idSuscripcion = id.getInt(1);
                sql.close();

                PreparedStatement sql2 = conexion.prepareStatement("UPDATE suscripcion SET estado='Cancelada', fecha='" + fecha_cambio + "' WHERE idSuscripcion='" + idSuscripcion + "'");
                sql2.executeUpdate();
                sql2.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(BDSuscripcion.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        }

    }

}
