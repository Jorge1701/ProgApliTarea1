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
public class AlbumTest {

    public AlbumTest() {
    }

    private static Album album;
    private static Artista artista;
    private static String nombre;
    private static int anio;
    private static String imagen;
    private static HashMap<String, Tema> temas;
    private static Tema tema;
    private static ArrayList<Genero> generos;

    @BeforeClass
    public static void setUpClass() {
        nombre = "nomAlbum";
        anio = 2006;
        imagen = "imgAlbum";

        temas = new HashMap<>();
        tema = new TemaLocal("dirt1", "tema1", new DtTime(0, 2, 35), 2017);
        temas.put("tema1", tema);
        temas.put("tema2", new TemaLocal("dirt2", "tema2", new DtTime(0, 2, 35), 2017));

        Genero g = new Genero("Padre");
        g.agregarGenero("Padre", "Hijo1");
        g.agregarGenero("Padre", "Hijo2");
        g.agregarGenero("Hijo1", "Hijo11");

        generos = new ArrayList<>();
        generos.add(g);
        generos.add(g.obtener("Hijo1"));
        generos.add(g.obtener("Hijo2"));
        generos.add(g.obtener("Hijo11"));
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        artista = new Artista("nickname", "nombreArt", "apellidoArt", "emailArt", new DtFecha(12, 5, 1996), "imgArti","", "bioArt", "webArt");
        album = new Album(artista.getNickname(), nombre, anio, imagen, temas, generos);
        album.setArtista(artista);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTema method, of class Album.
     */
    @Test
    public void testGetTema() {
        System.out.println("getTema");
        String nombre = tema.getNombre();
        Album instance = album;
        Tema expResult = tema;
        Tema result = instance.getTema(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNickArtista method, of class Album.
     */
    @Test
    public void testGetNickArtista() {
        System.out.println("getNickArtista");
        Album instance = album;
        String expResult = artista.getNickname();
        String result = instance.getNickArtista();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class Album.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Album instance = album;
        String expResult = nombre;
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnio method, of class Album.
     */
    @Test
    public void testGetAnio() {
        System.out.println("getAnio");
        Album instance = album;
        int expResult = anio;
        int result = instance.getAnio();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImagen method, of class Album.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        Album instance = album;
        String expResult = imagen;
        String result = instance.getImagen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTemas method, of class Album.
     */
    @Test
    public void testGetTemas() {
        System.out.println("getTemas");
        Album instance = album;
        HashMap<String, Tema> expResult = temas;
        HashMap<String, Tema> result = instance.getTemas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeneros method, of class Album.
     */
    @Test
    public void testGetGeneros() {
        System.out.println("getGeneros");
        Album instance = album;
        ArrayList<Genero> expResult = generos;
        ArrayList<Genero> result = instance.getGeneros();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArtista method, of class Album.
     */
    @Test
    public void testGetArtista() {
        System.out.println("getArtista");
        Album instance = album;
        Artista expResult = artista;
        Artista result = instance.getArtista();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Album.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "nuevoNomb";
        Album instance = album;
        instance.setNombre(nombre);
        assertEquals(nombre, instance.getNombre());
    }

    /**
     * Test of setAnio method, of class Album.
     */
    @Test
    public void testSetAnio() {
        System.out.println("setAnio");
        int anio = 2222;
        Album instance = album;
        instance.setAnio(anio);
        assertEquals(anio, instance.getAnio());
    }

    /**
     * Test of setImagen method, of class Album.
     */
    @Test
    public void testSetImagen() {
        System.out.println("setImagen");
        String imagen = "imgNueva";
        Album instance = album;
        instance.setImagen(imagen);
        assertEquals(imagen, instance.getImagen());
    }

    /**
     * Test of setTemas method, of class Album.
     */
    @Test
    public void testSetTemas() {
        System.out.println("setTemas");
        HashMap<String, Tema> temas = new HashMap<>();
        Album instance = album;
        instance.setTemas(temas);
        assertEquals(temas, instance.getTemas());
    }

    /**
     * Test of setGeneros method, of class Album.
     */
    @Test
    public void testSetGeneros() {
        System.out.println("setGeneros");
        ArrayList<Genero> generos = new ArrayList<>();
        Album instance = album;
        instance.setGeneros(generos);
        assertEquals(generos, instance.getGeneros());
    }

    /**
     * Test of setArtista method, of class Album.
     */
    @Test
    public void testSetArtista() {
        System.out.println("setArtista");
        Artista artista = new Artista("nick2", "nombre2", "apellido2", "email2", new DtFecha(2, 2, 2), "img2","", "bio2", "web2");
        Album instance = album;
        instance.setArtista(artista);
        assertEquals(artista, instance.getArtista());
    }

    /**
     * Test of getData method, of class Album.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Album instance = album;
        DtAlbum a = new DtAlbum(album.getNickArtista(), album.getNombre(), album.getAnio(), album.getImagen());
        DtAlbum dta = instance.getData();

        boolean result = true;
        if (!a.getNickArtista().equals(dta.getNickArtista())) {
            result = false;
        }
        if (!a.getNombre().equals(dta.getNombre())) {
            result = false;
        }
        if (!a.getImagen().equals(dta.getImagen())) {
            result = false;
        }
        if (a.getAnio() != dta.getAnio()) {
            result = false;
        }

        assertEquals(true, result);
    }

    /**
     * Test of obtenerAlbumContenido method, of class Album.
     */
    @Test
    public void testObtenerAlbumContenido() {
        System.out.println("obtenerAlbumContenido");
        Album instance = album;

        ArrayList<String> nomGeneros = new ArrayList<>();
        ArrayList<DtTema> dtTemas = new ArrayList<>();

        for (Genero genero : generos) {
            nomGeneros.add(genero.getNombre());
        }

        Iterator it1 = temas.entrySet().iterator();
        while (it1.hasNext()) {
            Tema tema = (Tema) ((Map.Entry) it1.next()).getValue();
            dtTemas.add(tema.getData());
        }

        DtAlbumContenido dtac = new DtAlbumContenido(new DtAlbum(album.getNickArtista(), album.getNombre(), album.getAnio(), album.getImagen()), nomGeneros, dtTemas);

        DtAlbumContenido dtacObtenido = instance.obtenerAlbumContenido();

        boolean result = true;

        if (!dtac.getInfo().getNickArtista().equals(dtacObtenido.getInfo().getNickArtista())) {
            result = false;
        }
        if (!dtac.getInfo().getNombre().equals(dtacObtenido.getInfo().getNombre())) {
            result = false;
        }
        if (!dtac.getInfo().getImagen().equals(dtacObtenido.getInfo().getImagen())) {
            result = false;
        }
        if (dtac.getInfo().getAnio() != dtacObtenido.getInfo().getAnio()) {
            result = false;
        }

        for (int i = 0; i < dtacObtenido.getTemas().size(); i++) {
            DtTema t = (DtTema) dtacObtenido.getTemas().get(i);
            DtTema t2 = (DtTema) dtTemas.get(i);

            if (!t.getNombre().equals(t2.getNombre())) {
                result = false;
            }
        }

        for (int i = 0; i < dtacObtenido.getGeneros().size(); i++) {
            String g = dtacObtenido.getGeneros().get(i);
            if (!g.equals(generos.get(i).getNombre())) {
                result = false;
            }
        }

        assertEquals(true, result);
    }

}
