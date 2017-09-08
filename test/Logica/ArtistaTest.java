/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.HashMap;
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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
        Artista instance = null;
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.obtenerAlbumes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        String nombre = "";
        Artista instance = null;
        Album expResult = null;
        Album result = instance.getAlbum(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        Artista instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Artista.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Artista instance = null;
        DtArtista expResult = null;
        DtArtista result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBiografia method, of class Artista.
     */
    @Test
    public void testGetBiografia() {
        System.out.println("getBiografia");
        Artista instance = null;
        String expResult = "";
        String result = instance.getBiografia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeb method, of class Artista.
     */
    @Test
    public void testGetWeb() {
        System.out.println("getWeb");
        Artista instance = null;
        String expResult = "";
        String result = instance.getWeb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBiografia method, of class Artista.
     */
    @Test
    public void testSetBiografia() {
        System.out.println("setBiografia");
        String biografia = "";
        Artista instance = null;
        instance.setBiografia(biografia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeb method, of class Artista.
     */
    @Test
    public void testSetWeb() {
        System.out.println("setWeb");
        String web = "";
        Artista instance = null;
        instance.setWeb(web);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlbumes method, of class Artista.
     */
    @Test
    public void testSetAlbumes() {
        System.out.println("setAlbumes");
        HashMap<String, Album> albumes = null;
        Artista instance = null;
        instance.setAlbumes(albumes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarAlbum method, of class Artista.
     */
    @Test
    public void testCargarAlbum() {
        System.out.println("cargarAlbum");
        Album a = null;
        Artista instance = null;
        instance.cargarAlbum(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
