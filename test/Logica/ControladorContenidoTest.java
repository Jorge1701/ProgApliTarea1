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
public class ControladorContenidoTest {
    
    public ControladorContenidoTest() {
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
     * Test of cargarInstancia method, of class ControladorContenido.
     */
    @Test
    public void testCargarInstancia() {
        System.out.println("cargarInstancia");
        ControladorContenido.cargarInstancia();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class ControladorContenido.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ControladorContenido expResult = null;
        ControladorContenido result = ControladorContenido.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIUsuario method, of class ControladorContenido.
     */
    @Test
    public void testSetIUsuario() {
        System.out.println("setIUsuario");
        IUsuario iUsuario = null;
        ControladorContenido instance = null;
        instance.setIUsuario(iUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indicarCliente method, of class ControladorContenido.
     */
    @Test
    public void testIndicarCliente() {
        System.out.println("indicarCliente");
        String nick = "";
        ControladorContenido instance = null;
        instance.indicarCliente(nick);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarTema method, of class ControladorContenido.
     */
    @Test
    public void testGuardarTema() {
        System.out.println("guardarTema");
        String nickArtista = "";
        String nomAlbum = "";
        String nomTema = "";
        ControladorContenido instance = null;
        instance.guardarTema(nickArtista, nomAlbum, nomTema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarListaDefault method, of class ControladorContenido.
     */
    @Test
    public void testGuardarListaDefault() {
        System.out.println("guardarListaDefault");
        String nomGenero = "";
        String nomLista = "";
        ControladorContenido instance = null;
        instance.guardarListaDefault(nomGenero, nomLista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarListaParticular method, of class ControladorContenido.
     */
    @Test
    public void testGuardarListaParticular() {
        System.out.println("guardarListaParticular");
        String nickCliente = "";
        String nomLista = "";
        ControladorContenido instance = null;
        instance.guardarListaParticular(nickCliente, nomLista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarAlbum method, of class ControladorContenido.
     */
    @Test
    public void testGuardarAlbum() {
        System.out.println("guardarAlbum");
        String nickArtista = "";
        String nomAlbum = "";
        ControladorContenido instance = null;
        instance.guardarAlbum(nickArtista, nomAlbum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTema method, of class ControladorContenido.
     */
    @Test
    public void testEliminarTema() {
        System.out.println("eliminarTema");
        int i = 0;
        ControladorContenido instance = null;
        instance.eliminarTema(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarListaFavoritos method, of class ControladorContenido.
     */
    @Test
    public void testEliminarListaFavoritos() {
        System.out.println("eliminarListaFavoritos");
        int i = 0;
        ControladorContenido instance = null;
        instance.eliminarListaFavoritos(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAlbum method, of class ControladorContenido.
     */
    @Test
    public void testEliminarAlbum() {
        System.out.println("eliminarAlbum");
        int i = 0;
        ControladorContenido instance = null;
        instance.eliminarAlbum(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectArtista method, of class ControladorContenido.
     */
    @Test
    public void testSelectArtista() {
        System.out.println("selectArtista");
        String nick = "";
        ControladorContenido instance = null;
        boolean expResult = false;
        boolean result = instance.selectArtista(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarGenero method, of class ControladorContenido.
     */
    @Test
    public void testListarGenero() {
        System.out.println("listarGenero");
        ControladorContenido instance = null;
        DtGenero expResult = null;
        DtGenero result = instance.listarGenero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarAlbumesGenero method, of class ControladorContenido.
     */
    @Test
    public void testListarAlbumesGenero() {
        System.out.println("listarAlbumesGenero");
        String nombre = "";
        ControladorContenido instance = null;
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.listarAlbumesGenero(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearListaReproduccion method, of class ControladorContenido.
     */
    @Test
    public void testCrearListaReproduccion() {
        System.out.println("crearListaReproduccion");
        DtLista dtl = null;
        String nickCliente = "";
        ControladorContenido instance = null;
        boolean expResult = false;
        boolean result = instance.crearListaReproduccion(dtl, nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarAlbum method, of class ControladorContenido.
     */
    @Test
    public void testIngresarAlbum() {
        System.out.println("ingresarAlbum");
        String nom = "";
        int anio = 0;
        ArrayList<String> generos = null;
        String img = "";
        ArrayList<DtTema> temas = null;
        ControladorContenido instance = null;
        instance.ingresarAlbum(nom, anio, generos, img, temas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLisReproduccionGen method, of class ControladorContenido.
     */
    @Test
    public void testListarLisReproduccionGen() {
        System.out.println("listarLisReproduccionGen");
        String nomGen = "";
        ControladorContenido instance = null;
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarLisReproduccionGen(nomGen);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecListGen method, of class ControladorContenido.
     */
    @Test
    public void testSelecListGen() {
        System.out.println("selecListGen");
        String nombreL = "";
        ControladorContenido instance = null;
        DtLista expResult = null;
        DtLista result = instance.selecListGen(nombreL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecListaDef method, of class ControladorContenido.
     */
    @Test
    public void testSelecListaDef() {
        System.out.println("selecListaDef");
        String nombre = "";
        ControladorContenido instance = null;
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.selecListaDef(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitarTema method, of class ControladorContenido.
     */
    @Test
    public void testQuitarTema() {
        System.out.println("quitarTema");
        String nombreT = "";
        String nombre = "";
        String nombreUser = "";
        ControladorContenido instance = null;
        boolean expResult = false;
        boolean result = instance.quitarTema(nombreT, nombre, nombreUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarDeListasDefectoTema method, of class ControladorContenido.
     */
    @Test
    public void testAgregarDeListasDefectoTema() {
        System.out.println("agregarDeListasDefectoTema");
        String nombreT = "";
        String nombreLista = "";
        String nombreUser = "";
        String listaDefecto = "";
        ControladorContenido instance = null;
        boolean expResult = false;
        boolean result = instance.agregarDeListasDefectoTema(nombreT, nombreLista, nombreUser, listaDefecto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarDeListasParticularesTema method, of class ControladorContenido.
     */
    @Test
    public void testAgregarDeListasParticularesTema() {
        System.out.println("agregarDeListasParticularesTema");
        String nombreT = "";
        String nombreLista = "";
        String nombreUser = "";
        String duenio = "";
        String listaDelduenio = "";
        ControladorContenido instance = null;
        boolean expResult = false;
        boolean result = instance.agregarDeListasParticularesTema(nombreT, nombreLista, nombreUser, duenio, listaDelduenio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarDeAlbumTema method, of class ControladorContenido.
     */
    @Test
    public void testAgregarDeAlbumTema() {
        System.out.println("agregarDeAlbumTema");
        String nombreT = "";
        String nombreLista = "";
        String nombreUser = "";
        String artista = "";
        String album = "";
        ControladorContenido instance = null;
        boolean expResult = false;
        boolean result = instance.agregarDeAlbumTema(nombreT, nombreLista, nombreUser, artista, album);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecLista method, of class ControladorContenido.
     */
    @Test
    public void testSelecLista() {
        System.out.println("selecLista");
        String nick = "";
        String nomL = "";
        ControladorContenido instance = null;
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.selecLista(nick, nomL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of publicarLista method, of class ControladorContenido.
     */
    @Test
    public void testPublicarLista() {
        System.out.println("publicarLista");
        String nick = "";
        String nomL = "";
        ControladorContenido instance = null;
        boolean expResult = false;
        boolean result = instance.publicarLista(nick, nomL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecGenero method, of class ControladorContenido.
     */
    @Test
    public void testSelecGenero() {
        System.out.println("selecGenero");
        String nomGenero = "";
        ControladorContenido instance = null;
        DtGenero expResult = null;
        DtGenero result = instance.selecGenero(nomGenero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAlbumContenido method, of class ControladorContenido.
     */
    @Test
    public void testObtenerAlbumContenido() {
        System.out.println("obtenerAlbumContenido");
        String nomGenero = "";
        String nomAlbum = "";
        String nickArtista = "";
        ControladorContenido instance = null;
        DtAlbumContenido expResult = null;
        DtAlbumContenido result = instance.obtenerAlbumContenido(nomGenero, nomAlbum, nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarGenero method, of class ControladorContenido.
     */
    @Test
    public void testCargarGenero() {
        System.out.println("cargarGenero");
        String nombre = "";
        String padre = "";
        ControladorContenido instance = null;
        instance.cargarGenero(nombre, padre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeGenero method, of class ControladorContenido.
     */
    @Test
    public void testExisteGenero() {
        System.out.println("existeGenero");
        String nombre = "";
        ControladorContenido instance = null;
        boolean expResult = false;
        boolean result = instance.existeGenero(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerGenero method, of class ControladorContenido.
     */
    @Test
    public void testObtenerGenero() {
        System.out.println("obtenerGenero");
        String nombre = "";
        ControladorContenido instance = null;
        Genero expResult = null;
        Genero result = instance.obtenerGenero(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLisReproduccionDef method, of class ControladorContenido.
     */
    @Test
    public void testListarLisReproduccionDef() {
        System.out.println("listarLisReproduccionDef");
        ControladorContenido instance = null;
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarLisReproduccionDef();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarLista method, of class ControladorContenido.
     */
    @Test
    public void testCargarLista() {
        System.out.println("cargarLista");
        ListaDefecto ld = null;
        String nombreGenero = "";
        ControladorContenido instance = null;
        instance.cargarLista(ld, nombreGenero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarGenero method, of class ControladorContenido.
     */
    @Test
    public void testIngresarGenero() {
        System.out.println("ingresarGenero");
        String nombre = "";
        String padre = "";
        ControladorContenido instance = null;
        instance.ingresarGenero(nombre, padre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTemas method, of class ControladorContenido.
     */
    @Test
    public void testListarTemas() {
        System.out.println("listarTemas");
        String NombreAlbum = "";
        String nickArtista = "";
        ControladorContenido instance = null;
        HashMap<String, Tema> expResult = null;
        HashMap<String, Tema> result = instance.listarTemas(NombreAlbum, nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTemasLD method, of class ControladorContenido.
     */
    @Test
    public void testListarTemasLD() {
        System.out.println("listarTemasLD");
        String nombreLista = "";
        ControladorContenido instance = null;
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.listarTemasLD(nombreLista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTemasP method, of class ControladorContenido.
     */
    @Test
    public void testListarTemasP() {
        System.out.println("listarTemasP");
        String nombreLista = "";
        String nickCliente = "";
        ControladorContenido instance = null;
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.listarTemasP(nombreLista, nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
