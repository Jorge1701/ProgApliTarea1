package Logica;

import java.util.ArrayList;

public interface IUsuario {
    
    public void setIContenido(IContenido iContenido);
    public Usuario obtenerUsuario(String nick);
    public Artista selectArtista(String nick);
    public ArrayList<DtUsuario> listarUsuarios();
    public boolean ingresarUsuario(DtUsuario dtu);
    public void levantarUsuario(DtUsuario dtu);
    public ArrayList<DtUsuario> listarClientes();
    public ArrayList<DtUsuario> listarArtistas();
    public DtPerfilUsuario obtenerPerfilArtista(String nickArtista);
    public DtPerfilUsuario obtenerPerfilCliente(String nickCliente);
    public DtUsuario getDataUsuario(String nickUsuario);
    public void seguirUsuario(String nickC, String nickU);
    public void dejarSeguirUsuario(String nickSeguidor, String nickUsuario);
    public void cargarUsuarios();
    public ArrayList<DtAlbum> listarAlbumesArtista(String nickArtista);
    public DtAlbumContenido obtenerAlbumContenido(String nickArt, String nomAlbum);
    public ArrayList<DtCliente> listarSeguidoresDe(String nickUsuario);
    public ArrayList<DtUsuario> listarSeguidosDe(String nickCliente);
    public ArrayList<DtLista> listarListaReproduccionCli(String nickCliente);
    public DtLista selectListaCli(String nombreL);
    public ArrayList<DtLista> listarLisReproduccion(String nickCliente);
    
    public void agregarAlbumFav(String nickCliente, String nickArtista, String nomAlbum);
    public void agregarLPFav(String nickCliente, String nickClienteDuenio, String nomLista);
    public void agregarLDFav(String nickCliente, String nomGenero, String nomLista);
    public void agregarTemaFav(String nickCliente, String nickArtista, String nomAlbum, String nomTema);
    
    public void eliminarAlbumFav(String nickCliente, int i);
    public void eliminarListaFav(String nickCliente, int i);
    public void eliminarTemaFav(String nickCliente, int i);
    
    public ArrayList<DtAlbum> obtenerAlbumesFav(String nickCliente);
    public ArrayList<DtLista> obtenerListasFav(String nickCliente);
    public ArrayList<DtTema> obtenerTemasFav(String nickCliente);
    
    public void cargarAlbum(Album dta);
    public void cargarLista(ListaParticular lp, String nickcliente);
}
