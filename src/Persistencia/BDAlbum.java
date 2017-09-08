/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Genero;
import Logica.Tema;
import Logica.Album;
import Logica.DtAlbum;
import Logica.TemaLocal;
import Logica.TemaRemoto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Diego
 */
public class BDAlbum {

    protected Connection conexion = new ConexionBD().getConexion();

    public boolean altaAlbum(Album album) {

        try {

            String sql = "INSERT INTO album" + "(nicknameArtista, nombre, anio, imagen) VALUES (?,?,?,?)";
            PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statament.setString(1, album.getNickArtista());
            statament.setString(2, album.getNombre());
            statament.setInt(3, album.getAnio());
            statament.setString(4, album.getImagen());
            statament.executeUpdate();
            ResultSet rs = statament.getGeneratedKeys();
            rs.next();
            int idAlbum = Integer.parseInt(rs.getString(1));
            statament.close();

            HashMap<String, Tema> temas = album.getTemas();
            Iterator i = temas.entrySet().iterator();
            while (i.hasNext()) {
                Tema t = (Tema) ((Map.Entry) i.next()).getValue();
                String sqlT = "INSERT INTO tema(nicknameArtista, idAlbum, nombre, duracion, ubicacion, tipo, link) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement statament2 = conexion.prepareStatement(sqlT, PreparedStatement.RETURN_GENERATED_KEYS);
                statament2.setString(1, album.getNickArtista());
                statament2.setInt(2, idAlbum);
                statament2.setString(3, t.getNombre());
                String duracion = String.valueOf(t.getDuracion().getHoras()) + ":" + String.valueOf(t.getDuracion().getMinutos()) + ":" + String.valueOf(t.getDuracion().getSegundos());
                statament2.setString(4, duracion);
                statament2.setInt(5, t.getUbicacion());
                if (t instanceof TemaLocal) {
                    statament2.setString(6, "L");
                    statament2.setString(7, ((TemaLocal) t).getDirectorio());

                } else if (t instanceof TemaRemoto) {
                    statament2.setString(6, "R");
                    statament2.setString(7, ((TemaRemoto) t).getUrl());
                }
                statament2.executeUpdate();
                ResultSet rset = statament2.getGeneratedKeys();
                rset.next();
                int idtema = Integer.parseInt(rset.getString(1));

                t.setId(idtema);
                statament2.close();
                //System.out.println("Idtema: " + idtema );

            }

            ArrayList<Genero> gros = album.getGeneros();
            for (int e = 0; e < gros.size(); e++) {
                Genero g = gros.get(e);
                String sqlT = "INSERT INTO clasificacionalbum(idAlbum, nicknameArtista, nombreGenero) VALUES (?,?,?)";
                PreparedStatement statament4 = conexion.prepareStatement(sqlT);
                statament4.setInt(1, idAlbum);
                statament4.setString(2, album.getNickArtista());
                statament4.setString(3, g.getNombre());
                statament4.executeUpdate();
                statament4.close();
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int insertarAlbum(DtAlbum dta) {
        try {
            PreparedStatement insert = conexion.prepareStatement("INSERT INTO album (idAlbum, nicknameArtista, nombre, anio, imagen) VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            insert.setNull(1, Types.INTEGER);
            insert.setString(2, dta.getNickArtista());
            insert.setString(3, dta.getNombre());
            insert.setInt(4, dta.getAnio());
            insert.setString(5, dta.getImagen());
            insert.executeUpdate();

            int idAlbum = 0;
            ResultSet rs = insert.getGeneratedKeys();
            while (rs.next()) {
                idAlbum = rs.getInt(1);
            }

            insert.close();

            return idAlbum;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean insertarGeneroDeAlbum(int idAlbum, String nickname, String nombreGenero) {
        try {
            PreparedStatement insert = conexion.prepareStatement("INSERT INTO clasificacionalbum (idAlbum, nicknameArtista, nombreGenero) VALUES (?, ?, ?)");
            insert.setInt(1, idAlbum);
            insert.setString(2, nickname);
            insert.setString(3, nombreGenero);
            insert.executeUpdate();
            insert.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertarTemaDeAlbum(String nickArtista, int idAlbum, String nombre, Time duracion, int ubicacion, String tipo, String link) {
        try {
            PreparedStatement insert = conexion.prepareStatement("INSERT INTO tema (nicknameArtista, idAlbum, nombre, duracion, ubicacion, tipo, link) VALUES (?, ?, ?, ?, ?, ?, ?)");
            insert.setString(1, nickArtista);
            insert.setInt(2, idAlbum);
            insert.setString(3, nombre);
            insert.setTime(4, duracion);
            insert.setInt(5, ubicacion);
            insert.setString(6, tipo);
            insert.setString(7, link);
            insert.executeUpdate();
            insert.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
