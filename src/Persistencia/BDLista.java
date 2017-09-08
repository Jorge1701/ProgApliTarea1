package Persistencia;

import Logica.DtLista;
import Logica.DtListaDefecto;
import Logica.DtListaParticular;
import Logica.Lista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDLista {

    protected Connection conexion = new ConexionBD().getConexion();

    public boolean altaLista(DtLista dtl, String nickCliente) {
        try {
            String tipo = "";
            if (dtl instanceof DtListaDefecto) {
                tipo = "D";
            } else {
                tipo = "P";
            }
            String sql = "INSERT INTO lista" + "(nombre,tipo,imagen) VALUES (?,?,?)";
            PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statament.setString(1, dtl.getNombre());
            statament.setString(2, tipo);
            statament.setString(3, dtl.getImagen());
            statament.executeUpdate();
            ResultSet rs = statament.getGeneratedKeys();
            rs.next();
            int idLista = Integer.parseInt(rs.getString(1));

            //statament.close();
            if (dtl instanceof DtListaDefecto) {
                PreparedStatement statament2 = conexion.prepareStatement("INSERT INTO listapordefecto(idLista,nombreGenero) VALUES (?,?)");
                statament2.setInt(1, idLista);
                statament2.setString(2, ((DtListaDefecto) dtl).getGenero().getNombre());
                statament2.executeUpdate();
                statament2.close();
                statament.close();
                return true;
            } else {
                PreparedStatement statament3 = conexion.prepareStatement("INSERT INTO listaparticular(idLista,nickname,Publica) VALUES (?,?,?)");
                statament3.setInt(1, idLista);
                statament3.setString(2, nickCliente);
                if (((DtListaParticular) dtl).isPrivada()) {
                    statament3.setString(3, "N");
                } else {
                    statament3.setString(3, "S");
                }
                statament3.executeUpdate();
                statament3.close();
                statament.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BDLista.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean publicarLista(Lista l) {

        try {
            PreparedStatement sql = conexion.prepareStatement("SELECT idLista FROM lista WHERE nombre = '" + l.getNombre() + "'");
            ResultSet id = sql.executeQuery();
            id.next();
            int idLista = id.getInt(1);
            sql.close();
            PreparedStatement sql2 = conexion.prepareStatement("UPDATE listaparticular SET Publica='S' WHERE idLista = '" + idLista + "'");
            sql2.executeUpdate();
            sql.close();
            sql2.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BDLista.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean quitarTemaLista(String NomUser, String NomLista, String NomTema) {
        try {
            if (NomUser == null) {
                
                PreparedStatement sql = conexion.prepareStatement("SELECT l.idLista FROM lista AS l, listapordefecto AS ld WHERE l.idLista = ld.idLista and l.nombre = '" + NomLista + "'");
                ResultSet id = sql.executeQuery();
                id.next();
                int idLista = id.getInt(1);
                sql.close(); 
                
                PreparedStatement query = conexion.prepareStatement("SELECT idTema FROM tema WHERE nombre = ?");
                query.setString(1, NomTema);                
                int idTema = 0;
                ResultSet rs = query.executeQuery();
                while (rs.next()) {
                    idTema = rs.getInt(1);
                }
                rs.close();
                query.close();                
                               
                String sql2 = "DELETE FROM listatienetemas WHERE idTema=? and idLista=? ";
                PreparedStatement delete = conexion.prepareStatement(sql2);
                delete.setInt(1,idTema);
                delete.setInt(2, idLista);
                delete.executeUpdate();
                delete.close();
            } else {
                PreparedStatement sql = conexion.prepareStatement("SELECT l.idLista FROM lista AS l, listaparticular AS lp WHERE l.idLista = lp.idLista and l.nombre = '" + NomLista + "' and lp.nickname = '" + NomUser + "'");
                ResultSet id = sql.executeQuery();
                id.next();
                int idLista = id.getInt(1);
                sql.close();                
                PreparedStatement query = conexion.prepareStatement("SELECT idTema FROM tema WHERE nombre = ?");
                query.setString(1, NomTema);                
                int idTema = 0;
                ResultSet rs = query.executeQuery();
                while (rs.next()) {
                    idTema = rs.getInt(1);
                }
                rs.close();
                query.close();                
                                               
                String sql2 = "DELETE FROM listatienetemas WHERE idTema=? and idLista=? ";
                PreparedStatement delete = conexion.prepareStatement(sql2);
                delete.setInt(1,idTema);
                delete.setInt(2, idLista);
                delete.executeUpdate();
                delete.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean insertarTemaALista(String nickArtista, int idAlbum, int idTema, int idLista) {
        try {
            PreparedStatement insert = conexion.prepareStatement("INSERT INTO listatienetemas (nickname, idAlbum, idTema, idLista) VALUES (?, ?, ?, ?)");
            insert.setString(1, nickArtista);
            insert.setInt(2, idAlbum);
            insert.setInt(3, idTema);
            insert.setInt(4, idLista);
            insert.executeUpdate();
            insert.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
