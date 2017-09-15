/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kopxe
 */
public class ArtistaTest {

    public ArtistaTest() {
    }

    private static Artista artista;
    private static String nickname;
    private static String nombre;
    private static String apellido;
    private static String email;
    private static DtFecha fechaNac;
    private static String imagen;
    private static String biografia;
    private static String web;

    private static HashMap<String, Album> albumes;
    private static Album album1;

    @BeforeClass
    public static void setUpClass() {
        nickname = "nickname";
        nombre = "nombre";
        apellido = "apellido";
        email = "email";
        fechaNac = new DtFecha(30, 11, 1996);
        imagen = "imagen";
        biografia = "biografia";
        web = "web";

        album1 = new Album(nickname, "nomAlbum", 20017, "imagen");

        albumes = new HashMap<>();
        albumes.put(album1.getNombre(), album1);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        artista = new Artista(nickname, nombre, apellido, email, fechaNac, imagen, "", biografia, web);
        artista.setAlbumes(albumes);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerAlbumes method, of class Artista.
     */
    @Test
    public void testObtenerAlbumes() {
        System.out.println("obtenerAlbumes");
        Artista instance = artista;
        ArrayList<DtAlbum> expResult = new ArrayList<>();
        Iterator it = albumes.entrySet().iterator();

        while (it.hasNext()) {
            Album album = (Album) ((Map.Entry) it.next()).getValue();
            expResult.add(new DtAlbum(artista.getNickname(), album.getNombre(), album.getAnio(), album.getImagen()));
        }

        ArrayList<DtAlbum> obtenido = instance.obtenerAlbumes();

        boolean result = true;

        if (expResult.size() != obtenido.size()) {
            result = false;
        }

        for (int i = 0; i < expResult.size(); i++) {
            if (!expResult.get(i).getNickArtista().equals(obtenido.get(i).getNickArtista())) {
                result = false;
            }
            if (!expResult.get(i).getNombre().equals(obtenido.get(i).getNombre())) {
                result = false;
            }
            if (!expResult.get(i).getImagen().equals(obtenido.get(i).getImagen())) {
                result = false;
            }
            if (expResult.get(i).getAnio() != obtenido.get(i).getAnio()) {
                result = false;
            }
        }

        assertEquals(true, result);
    }

    /**
     * Test of obtenerAlbumContenido method, of class Artista.
     */
    @Test
    public void testObtenerAlbumContenido() {
        System.out.println("obtenerAlbumContenido");
        String nomAlbum = "";
        Artista instance = null;
        DtAlbumContenido expResult = null;
        DtAlbumContenido result = instance.obtenerAlbumContenido(nomAlbum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlbum method, of class Artista.
     */
    @Test
    public void testGetAlbum() {
        System.out.println("getAlbum");
        String nombre = album1.getNombre();
        Artista instance = artista;
        Album expResult = album1;
        Album result = instance.getAlbum(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerPerfil method, of class Artista.
     */
    @Test
    public void testObtenerPerfil() {
        System.out.println("obtenerPerfil");
        Artista instance = null;
        DtPerfilUsuario expResult = null;
        DtPerfilUsuario result = instance.obtenerPerfil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarAlbum method, of class Artista.
     */
    @Test
    public void testIngresarAlbum() {
        System.out.println("ingresarAlbum");
        String nom = "";
        int anio = 0;
        ArrayList<Genero> generos = null;
        String img = "";
        HashMap<String, Tema> temas = null;
        Artista instance = null;
        instance.ingresarAlbum(nom, anio, generos, img, temas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Artista.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Artista instance = artista;
        String expResult = "Artista";
        String result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getData method, of class Artista.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Artista instance = artista;
        DtArtista expResult = new DtArtista(nickname, nombre, apellido, email, fechaNac, imagen,"", biografia, web);
        DtArtista obtenido = instance.getData();

        boolean result = true;
        if (!expResult.getNickname().equals(obtenido.getNickname())) {
            result = false;
        }
        if (!expResult.getNombre().equals(obtenido.getNombre())) {
            result = false;
        }
        if (!expResult.getApellido().equals(obtenido.getApellido())) {
            result = false;
        }
        if (!expResult.getEmail().equals(obtenido.getEmail())) {
            result = false;
        }
        if (!expResult.getImagen().equals(obtenido.getImagen())) {
            result = false;
        }
        if (!expResult.getBiografia().equals(obtenido.getBiografia())) {
            result = false;
        }
        if (!expResult.getWeb().equals(obtenido.getWeb())) {
            result = false;
        }
        if (expResult.getFechaNac().getDia() != obtenido.getFechaNac().getDia()) {
            result = false;
        }
        if (expResult.getFechaNac().getMes() != obtenido.getFechaNac().getMes()) {
            result = false;
        }
        if (expResult.getFechaNac().getAnio() != obtenido.getFechaNac().getAnio()) {
            result = false;
        }

        assertEquals(true, result);
    }

    /**
     * Test of getBiografia method, of class Artista.
     */
    @Test
    public void testGetBiografia() {
        System.out.println("getBiografia");
        Artista instance = artista;
        String expResult = biografia;
        String result = instance.getBiografia();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeb method, of class Artista.
     */
    @Test
    public void testGetWeb() {
        System.out.println("getWeb");
        Artista instance = artista;
        String expResult = web;
        String result = instance.getWeb();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBiografia method, of class Artista.
     */
    @Test
    public void testSetBiografia() {
        System.out.println("setBiografia");
        String biografia = "nuevaBio";
        Artista instance = artista;
        instance.setBiografia(biografia);
    }

    /**
     * Test of setWeb method, of class Artista.
     */
    @Test
    public void testSetWeb() {
        System.out.println("setWeb");
        String web = "nuevaWeb";
        Artista instance = artista;
        instance.setWeb(web);
        assertEquals(web, instance.getWeb());
    }

    /**
     * Test of setAlbumes method, of class Artista.
     */
    @Test
    public void testSetAlbumes() {
        System.out.println("setAlbumes");
        HashMap<String, Album> albumes = new HashMap<>();
        Artista instance = artista;
        instance.setAlbumes(albumes);
        assertEquals(true, instance.obtenerAlbumes().size() == 0);
    }

    /**
     * Test of cargarAlbum method, of class Artista.
     */
    @Test
    public void testCargarAlbum() {
        System.out.println("cargarAlbum");
        Album a = new Album(nickname, "nomAlbum", 2002, "img");
        Artista instance = artista;
        instance.cargarAlbum(a);
        assertEquals(true, instance.getAlbum("nomAlbum") != null);
    }

}
