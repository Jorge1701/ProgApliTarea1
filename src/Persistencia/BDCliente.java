package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDCliente extends BDUsuario {

    public boolean agregarListaDefaultFav(String nomGenero, String nomLista, String nomCliente) {
        try {
            int idLista = obtenerIdListaDefecto(nomGenero, nomLista);

            PreparedStatement agregar = conexion.prepareStatement("INSERT INTO favl VALUES (?, ?)");
            agregar.setString(1, nomCliente);
            agregar.setInt(2, idLista);
            agregar.executeUpdate();
            agregar.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean agregarListaParticularFav(String duenio, String nomLista, String cliente) {
        try {
            int idLista = obtenerIdListaParticular(duenio, nomLista);

            PreparedStatement agregar = conexion.prepareStatement("INSERT INTO favl VALUES (?, ?)");
            agregar.setString(1, cliente);
            agregar.setInt(2, idLista);
            agregar.executeUpdate();
            agregar.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean agregarAlbumFav(String nickArt, String nomAlbum, String nickCli) {
        try {
            int idAlbum = obtenerIdAlbum(nickArt, nomAlbum);

            PreparedStatement agregar = conexion.prepareStatement("INSERT INTO fava VALUES (?, ?, ?)");
            agregar.setInt(1, idAlbum);
            agregar.setString(2, nickArt);
            agregar.setString(3, nickCli);
            agregar.executeUpdate();
            agregar.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean agregarTemaFav(String nickArt, String nomAlbum, String nomTema, String nickCliente) {
        try {
            PreparedStatement agregar = conexion.prepareStatement("INSERT INTO favt (nickname, idTema) VALUES (?, ?)");
            agregar.setString(1, nickCliente);
            agregar.setInt(2, obtenerIdTema(nickArt, obtenerIdAlbum(nickArt, nomAlbum), nomTema));
            agregar.executeUpdate();
            agregar.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarAlbumFav(String nickArtista, String nombreAlbum, String nickCliente) {
        try {
            PreparedStatement delete = conexion.prepareStatement("DELETE FROM fava WHERE idAlbum = ? AND nicknameArtista = ? AND nicknameCliente = ?");
            delete.setInt(1, obtenerIdAlbum(nickArtista, nombreAlbum));
            delete.setString(2, nickArtista);
            delete.setString(3, nickCliente);
            delete.executeUpdate();
            delete.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarListaPorDefectoFav(String nombreGenero, String nombreLista, String nickCliente) {
        try {
            PreparedStatement delete = conexion.prepareStatement("DELETE FROM favl WHERE nickname = ? AND idLista = ?");
            delete.setString(1, nickCliente);
            delete.setInt(2, obtenerIdListaDefecto(nombreGenero, nombreLista));
            delete.executeUpdate();
            delete.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarListaParticularFav(String nickDuenio, String nombreLista, String nickCliente) {
        try {
            PreparedStatement delete = conexion.prepareStatement("DELETE FROM favl WHERE nickname = ? AND idLista = ?");
            delete.setString(1, nickCliente);
            delete.setInt(2, obtenerIdListaParticular(nickDuenio, nombreLista));
            delete.executeUpdate();
            delete.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarTemaFav(String nickArtista, String nomAlbum, String nomTema, String nickCliente) {
        try {
            PreparedStatement delete = conexion.prepareStatement("DELETE FROM favt WHERE nickname = ? AND idTema = ?");
            delete.setString(1, nickCliente);
            delete.setInt(2, obtenerIdTema(nickArtista, obtenerIdAlbum(nickArtista, nomAlbum), nomTema));
            delete.executeUpdate();
            delete.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean asociarListaACliente(int idLista, String nickCliente) {
        try {
            PreparedStatement insertar = conexion.prepareStatement("INSERT INTO clientecrealista (idLista, nickname) VALUES (?, ?)");
            insertar.setInt(1, idLista);
            insertar.setString(2, nickCliente);
            insertar.executeUpdate();
            insertar.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private int obtenerIdTema(String nickArtista, int idAlbum, String nomTema) {
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT idTema FROM tema WHERE nicknameArtista = ? AND idAlbum = ? AND nombre = ?");
            query.setString(1, nickArtista);
            query.setInt(2, idAlbum);
            query.setString(3, nomTema);

            int idTema = 0;
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                idTema = rs.getInt(1);
            }

            rs.close();
            query.close();

            return idTema;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int obtenerIdListaDefecto(String nombreGenero, String nombreLista) {
        try {
            PreparedStatement buscar = conexion.prepareStatement("SELECT l.idLista FROM lista AS l, listapordefecto AS ld WHERE l.idLista = ld.idLista AND l.nombre = ? AND ld.nombreGenero = ?");
            buscar.setString(1, nombreLista);
            buscar.setString(2, nombreGenero);

            int idLista = 0;
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {
                idLista = rs.getInt(1);
            }

            rs.close();
            buscar.close();

            return idLista;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int obtenerIdListaParticular(String cliente, String nomLista) {
        try {
            PreparedStatement lista = conexion.prepareStatement("SELECT l.idLista FROM lista AS l, listaparticular AS lp WHERE l.idLista = lp.idLista AND l.nombre = ? AND lp.nickname = ?");
            lista.setString(1, nomLista);
            lista.setString(2, cliente);

            int idLista = 0;
            ResultSet rs = lista.executeQuery();
            while (rs.next()) {
                idLista = rs.getInt(1);
            }
            rs.close();
            lista.close();

            return idLista;
        } catch (SQLException e) {
            e.printStackTrace();;
            return 0;
        }
    }

    private int obtenerIdAlbum(String nickArt, String nomAlbum) {
        try {
            PreparedStatement buscar = conexion.prepareStatement("SELECT idAlbum FROM album WHERE nicknameArtista = ? AND nombre = ?");
            buscar.setString(1, nickArt);
            buscar.setString(2, nomAlbum);
            ResultSet rs = buscar.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt("idAlbum");
            }
            rs.close();
            buscar.close();

            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}
