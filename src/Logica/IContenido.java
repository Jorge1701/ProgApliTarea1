package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IContenido {
    
    public void indicarCliente(String nick);
    public void guardarTema(String nickArtista, String nomAlbum, String nomTema);
    public void guardarListaDefault(String nomGenero, String nomLista);
    public void guardarListaParticular(String nickCliente, String nomLista);
    public void guardarAlbum(String nickArtista, String nomAlbum);
    public void eliminarTema(int i);
    public void eliminarListaFavoritos(int i);
    public void eliminarAlbum(int i);
    public boolean selectArtista(String nick);
    public DtGenero listarGenero();
    public ArrayList<DtAlbum> listarAlbumesGenero(String nombre);
    public boolean crearListaReproduccion(DtLista lista,String nickCliente);
    public void ingresarAlbum(String nom, int anio, ArrayList<String> generos, String img, ArrayList<DtTema> temas);
    public List<DtTema> selecListaDef(String nombre);
    public boolean quitarTema(String nombreT,String nombre,String nombreUser);
    public List<DtTema> selecLista(String nick,String nomL);
    public boolean publicarLista(String nick,String nomL);
    public void setIUsuario(IUsuario iUsuario);
    public ArrayList<DtLista> listarLisReproduccionGen(String nomGen);
    public DtLista selecListGen(String nombreL);
    public DtAlbumContenido obtenerAlbumContenido(String nomGenero, String nomAlbum, String nickArtista);
    public DtGenero selecGenero(String nomGenero);
    public void cargarGenero(String nombre, String padre);
    public boolean existeGenero(String nombre);
    public Genero obtenerGenero(String nombre);
    public ArrayList<DtLista> listarLisReproduccionDef();
    public void cargarLista(ListaDefecto ld, String nombreGenero);
    public void ingresarGenero(String nombre,String padre);
    public HashMap<String,Tema> listarTemas(String NombreAlbum,String nickArtista);
    public ArrayList<DtTema> listarTemasLD(String nombreLista);
    public ArrayList<DtTema> listarTemasP(String nombreLista, String nickCliente);
    public boolean agregarDeListasDefectoTema(String nombreT, String nombreLista, String nombreUser, String listaDefecto);
    public boolean agregarDeListasParticularesTema(String nombreT, String nombreLista, String nombreUser, String duenio, String listaDelduenio);
    public boolean agregarDeAlbumTema(String nombreT, String nombreLista, String nombreUser, String artista, String album);
}
