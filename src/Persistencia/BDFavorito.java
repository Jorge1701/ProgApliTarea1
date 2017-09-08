/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brian
 */
public class BDFavorito {
    

    protected Connection conexion = new ConexionBD().getConexion();
    
    public boolean altaTemaFavortio(String nickname,int idTema){
        try{
        String sql  = "INSERT INTO favt (nickname,idTema) VALUES(?,?)";
        PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        statament.setString(1, nickname);
        statament.setInt(2, idTema);
        statament.executeUpdate();
        statament.close();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(BDLista.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
               
    
    }
    
    public boolean altaListaFavorita(String nickname,int idLista){
    try{
        String sql = "INSERT INTO favl (nickname,idLista) VALUES(?,?)";
        PreparedStatement statament = conexion.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        statament.setString(1, nickname);
        statament.setInt(2, idLista);
        statament.executeUpdate();
        statament.close();
        return true;
            } catch (SQLException ex) {
            Logger.getLogger(BDLista.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    public boolean altaAlbumFavorito(int idAlbum, String nicknameArtista, String nicknameCliente){

    try{
        String sql = "INSERT INTO fava (idAlbum,nicknameArtista,nicknameCliente) VALUES(?,?,?)";
        PreparedStatement statament = conexion.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        statament.setInt(1, idAlbum);
        statament.setString(2, nicknameArtista);
        statament.setString(3, nicknameCliente);
        statament.executeUpdate();
        statament.close();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(BDLista.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

}


}