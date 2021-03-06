package Logica;

import Persistencia.BDAlbum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Artista extends Usuario {

    private String biografia;
    private String web;
    private HashMap<String, Album> albumes;
    private BDAlbum bdAlbum = null;
    private boolean activo;

    public Artista(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String imagen, String contrasenia, String biografia, String web, boolean activo) {
        super(nickname, nombre, apellido, email, fechaNac, imagen, contrasenia); //LLama al constructor de Usuario
        this.biografia = biografia;
        this.web = web;
        this.activo = activo;
        this.albumes = new HashMap();
    }

    public ArrayList<DtAlbum> obtenerAlbumes() {
        ArrayList<DtAlbum> res;
        res = new ArrayList<>();
        Iterator it = albumes.entrySet().iterator();
        while (it.hasNext()) {
            Album album = (Album) ((Map.Entry) it.next()).getValue();
            res.add(new DtAlbum(this.getNickname(), album.getNombre(), album.getAnio(), album.getImagen()));
        }
        return res;
    }

    public DtAlbumContenido obtenerAlbumContenido(String nomAlbum) {
        DtAlbumContenido dtac;
        Album album = albumes.get(nomAlbum);
        if (album == null) {
            return null;
        }
        dtac = album.obtenerAlbumContenido();

        return dtac;
    }

    public Album getAlbum(String nombre) {
        return albumes.get(nombre);
    }

    @Override
    public DtPerfilUsuario obtenerPerfil() {
        DtUsuario info = getData();
        ArrayList<DtCliente> dtSeguidores = getSeguidores();
        ArrayList<DtAlbum> dtAlbumes = new ArrayList<>();

        Iterator i = this.albumes.entrySet().iterator();

        while (i.hasNext()) {
            Album a = (Album) ((Map.Entry) i.next()).getValue();
            dtAlbumes.add(a.getData());
        }

        return new DtPerfilArtista(dtAlbumes, info, dtSeguidores, biografia, web);

    }

    public void ingresarAlbum(String nom, int anio, ArrayList<Genero> generos, String img, HashMap<String, Tema> temas) {
        if (this.albumes.get(nom) != null) {
            throw new UnsupportedOperationException("Ya existe Albun con ese nombre");
        } else {

            //Album album = new Album(super.getNickname(), nom, anio, null, temas, generos);
            Album album = new Album(this, super.getNickname(), nom, anio, img, temas, generos);
            bdAlbum = new BDAlbum();

            boolean res = this.bdAlbum.altaAlbum(album);
            if (res) {
                this.albumes.put(nom, album);
                for (int i = 0; i < generos.size(); i++) {
                    Genero g = (Genero) generos.get(i);
                    g.cargarAlbum(album);
                }
            } else {
                throw new UnsupportedOperationException("Error en Persistencia");
            }

        }

    }

    @Override
    public String getTipo() {
        return "Artista";
    }

    @Override
    public DtArtista getData() {
        return new DtArtista(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNac(), getImagen(), getBiografia(), getWeb(), getContrasenia(), estaActivo());
    }

    public String getBiografia() {
        return this.biografia;
    }

    public String getWeb() {
        return this.web;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public void setAlbumes(HashMap<String, Album> albumes) {
        this.albumes = albumes;
    }

    public void cargarAlbum(Album a) {
        albumes.put(a.getNombre(), a);
    }

    public boolean estaActivo() {
        return activo;
    }

    public void activar() {
        activo = true;
    }

    public void desactivar() {
        activo = false;
    }

    public ArrayList<Album> getAlbumes() {
        ArrayList<Album> res = new ArrayList<>();

        Iterator i = albumes.entrySet().iterator();

        while (i.hasNext()) {
            res.add((Album) ((Map.Entry) i.next()).getValue());
        }

        return res;
    }

    public boolean ExisteAlbum(String nombre) {
        Iterator it = this.albumes.entrySet().iterator();

        while (it.hasNext()) {
            Album album = (Album) ((Map.Entry) it.next()).getValue();
            if (nombre.toLowerCase().equals(album.getNombre().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
