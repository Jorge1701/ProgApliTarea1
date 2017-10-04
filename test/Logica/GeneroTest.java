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
public class GeneroTest {
    
    public GeneroTest() {
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
     * Test of agregarGenero method, of class Genero.
     */
    @Test
    public void testAgregarGenero() {
        System.out.println("agregarGenero");
        String padre = "";
        String nombre = "";
        Genero instance = null;
        instance.agregarGenero(padre, nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existe method, of class Genero.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        String nombre = "";
        Genero instance = null;
        boolean expResult = false;
        boolean result = instance.existe(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlbumes method, of class Genero.
     */
    @Test
    public void testSetAlbumes() {
        System.out.println("setAlbumes");
        ArrayList<Album> albumes = null;
        Genero instance = null;
        instance.setAlbumes(albumes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListasDefecto method, of class Genero.
     */
    @Test
    public void testSetListasDefecto() {
        System.out.println("setListasDefecto");
        HashMap<String, ListaDefecto> listasDefecto = null;
        Genero instance = null;
        instance.setListasDefecto(listasDefecto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlbumes method, of class Genero.
     */
    @Test
    public void testGetAlbumes() {
        System.out.println("getAlbumes");
        Genero instance = null;
        ArrayList<Album> expResult = null;
        ArrayList<Album> result = instance.getAlbumes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDefecto method, of class Genero.
     */
    @Test
    public void testGetListaDefecto() {
        System.out.println("getListaDefecto");
        String nombre = "";
        Genero instance = null;
        ListaDefecto expResult = null;
        ListaDefecto result = instance.getListaDefecto(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListasDefecto method, of class Genero.
     */
    @Test
    public void testGetListasDefecto() {
        System.out.println("getListasDefecto");
        Genero instance = null;
        HashMap<String, ListaDefecto> expResult = null;
        HashMap<String, ListaDefecto> result = instance.getListasDefecto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Genero.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Genero instance = null;
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubgeneros method, of class Genero.
     */
    @Test
    public void testSetSubgeneros() {
        System.out.println("setSubgeneros");
        HashMap<String, Genero> subgeneros = null;
        Genero instance = null;
        instance.setSubgeneros(subgeneros);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Genero.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Genero instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubgeneros method, of class Genero.
     */
    @Test
    public void testGetSubgeneros() {
        System.out.println("getSubgeneros");
        Genero instance = null;
        HashMap<String, Genero> expResult = null;
        HashMap<String, Genero> result = instance.getSubgeneros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Genero.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Genero instance = null;
        DtGenero expResult = null;
        DtGenero result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devolverSubgeneros method, of class Genero.
     */
    @Test
    public void testDevolverSubgeneros() {
        System.out.println("devolverSubgeneros");
        Genero g = null;
        Genero instance = null;
        ArrayList<DtGenero> expResult = null;
        ArrayList<DtGenero> result = instance.devolverSubgeneros(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtener method, of class Genero.
     */
    @Test
    public void testObtener() {
        System.out.println("obtener");
        String nombre = "";
        Genero instance = null;
        Genero expResult = null;
        Genero result = instance.obtener(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAlbumes method, of class Genero.
     */
    @Test
    public void testObtenerAlbumes() {
        System.out.println("obtenerAlbumes");
        Genero instance = null;
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.obtenerAlbumes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLisReproduccion method, of class Genero.
     */
    @Test
    public void testListarLisReproduccion() {
        System.out.println("listarLisReproduccion");
        Genero instance = null;
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarLisReproduccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarLista method, of class Genero.
     */
    @Test
    public void testSeleccionarLista() {
        System.out.println("seleccionarLista");
        String nombreL = "";
        Genero instance = null;
        DtLista expResult = null;
        DtLista result = instance.seleccionarLista(nombreL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAlbumContenido method, of class Genero.
     */
    @Test
    public void testObtenerAlbumContenido() {
        System.out.println("obtenerAlbumContenido");
        String nomAlbum = "";
        String nickArtista = "";
        Genero instance = null;
        DtAlbumContenido expResult = null;
        DtAlbumContenido result = instance.obtenerAlbumContenido(nomAlbum, nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarAlbum method, of class Genero.
     */
    @Test
    public void testCargarAlbum() {
        System.out.println("cargarAlbum");
        Album a = null;
        Genero instance = null;
        instance.cargarAlbum(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarLista method, of class Genero.
     */
    @Test
    public void testCargarLista() {
        System.out.println("cargarLista");
        ListaDefecto ld = null;
        Genero instance = null;
        instance.cargarLista(ld);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
