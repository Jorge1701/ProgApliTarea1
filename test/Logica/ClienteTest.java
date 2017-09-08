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
public class ClienteTest {
    
    public ClienteTest() {
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
     * Test of agregarAlbumFav method, of class Cliente.
     */
    @Test
    public void testAgregarAlbumFav() {
        System.out.println("agregarAlbumFav");
        Album a = null;
        Cliente instance = null;
        int expResult = 0;
        int result = instance.agregarAlbumFav(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarListaFav method, of class Cliente.
     */
    @Test
    public void testAgregarListaFav() {
        System.out.println("agregarListaFav");
        Lista l = null;
        Cliente instance = null;
        int expResult = 0;
        int result = instance.agregarListaFav(l);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarTemaFav method, of class Cliente.
     */
    @Test
    public void testAgregarTemaFav() {
        System.out.println("agregarTemaFav");
        Tema t = null;
        Cliente instance = null;
        int expResult = 0;
        int result = instance.agregarTemaFav(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarLista method, of class Cliente.
     */
    @Test
    public void testAgregarLista() {
        System.out.println("agregarLista");
        Lista l = null;
        Cliente instance = null;
        instance.agregarLista(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAlbumFav method, of class Cliente.
     */
    @Test
    public void testEliminarAlbumFav() {
        System.out.println("eliminarAlbumFav");
        int i = 0;
        Cliente instance = null;
        instance.eliminarAlbumFav(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarListaFav method, of class Cliente.
     */
    @Test
    public void testEliminarListaFav() {
        System.out.println("eliminarListaFav");
        int i = 0;
        Cliente instance = null;
        instance.eliminarListaFav(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTemaFav method, of class Cliente.
     */
    @Test
    public void testEliminarTemaFav() {
        System.out.println("eliminarTemaFav");
        int i = 0;
        Cliente instance = null;
        instance.eliminarTemaFav(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDtAlbumesFav method, of class Cliente.
     */
    @Test
    public void testObtenerDtAlbumesFav() {
        System.out.println("obtenerDtAlbumesFav");
        Cliente instance = null;
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.obtenerDtAlbumesFav();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDtListasFav method, of class Cliente.
     */
    @Test
    public void testObtenerDtListasFav() {
        System.out.println("obtenerDtListasFav");
        Cliente instance = null;
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.obtenerDtListasFav();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDtTemasFav method, of class Cliente.
     */
    @Test
    public void testObtenerDtTemasFav() {
        System.out.println("obtenerDtTemasFav");
        Cliente instance = null;
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.obtenerDtTemasFav();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAlbumsFav method, of class Cliente.
     */
    @Test
    public void testObtenerAlbumsFav() {
        System.out.println("obtenerAlbumsFav");
        Cliente instance = null;
        ArrayList<Album> expResult = null;
        ArrayList<Album> result = instance.obtenerAlbumsFav();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerListasFav method, of class Cliente.
     */
    @Test
    public void testObtenerListasFav() {
        System.out.println("obtenerListasFav");
        Cliente instance = null;
        ArrayList<Lista> expResult = null;
        ArrayList<Lista> result = instance.obtenerListasFav();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTemasFav method, of class Cliente.
     */
    @Test
    public void testObtenerTemasFav() {
        System.out.println("obtenerTemasFav");
        Cliente instance = null;
        ArrayList<Tema> expResult = null;
        ArrayList<Tema> result = instance.obtenerTemasFav();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Cliente.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Cliente.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Cliente instance = null;
        DtCliente expResult = null;
        DtCliente result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPerfil method, of class Cliente.
     */
    @Test
    public void testObtenerPerfil() {
        System.out.println("obtenerPerfil");
        Cliente instance = null;
        DtPerfilUsuario expResult = null;
        DtPerfilUsuario result = instance.obtenerPerfil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregar method, of class Cliente.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        Usuario u = null;
        Cliente instance = null;
        boolean expResult = false;
        boolean result = instance.agregar(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dejarSeguir method, of class Cliente.
     */
    @Test
    public void testDejarSeguir() {
        System.out.println("dejarSeguir");
        Usuario u = null;
        Cliente instance = null;
        boolean expResult = false;
        boolean result = instance.dejarSeguir(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeguidos method, of class Cliente.
     */
    @Test
    public void testGetSeguidos() {
        System.out.println("getSeguidos");
        Cliente instance = null;
        HashMap<String, Usuario> expResult = null;
        HashMap<String, Usuario> result = instance.getSeguidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaParticular method, of class Cliente.
     */
    @Test
    public void testGetListaParticular() {
        System.out.println("getListaParticular");
        String nombre = "";
        Cliente instance = null;
        ListaParticular expResult = null;
        ListaParticular result = instance.getListaParticular(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListasParticulares method, of class Cliente.
     */
    @Test
    public void testGetListasParticulares() {
        System.out.println("getListasParticulares");
        Cliente instance = null;
        HashMap<String, ListaParticular> expResult = null;
        HashMap<String, ListaParticular> result = instance.getListasParticulares();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeguidos method, of class Cliente.
     */
    @Test
    public void testSetSeguidos() {
        System.out.println("setSeguidos");
        HashMap<String, Usuario> seguidos = null;
        Cliente instance = null;
        instance.setSeguidos(seguidos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListasParticulares method, of class Cliente.
     */
    @Test
    public void testSetListasParticulares() {
        System.out.println("setListasParticulares");
        HashMap<String, ListaParticular> listasParticulares = null;
        Cliente instance = null;
        instance.setListasParticulares(listasParticulares);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLista method, of class Cliente.
     */
    @Test
    public void testGetLista() {
        System.out.println("getLista");
        String nomL = "";
        Cliente instance = null;
        Lista expResult = null;
        Lista result = instance.getLista(nomL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLisReproduccion method, of class Cliente.
     */
    @Test
    public void testListarLisReproduccion() {
        System.out.println("listarLisReproduccion");
        Cliente instance = null;
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarLisReproduccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarLista method, of class Cliente.
     */
    @Test
    public void testSeleccionarLista() {
        System.out.println("seleccionarLista");
        String nombreL = "";
        Cliente instance = null;
        DtLista expResult = null;
        DtLista result = instance.seleccionarLista(nombreL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerSeguidos method, of class Cliente.
     */
    @Test
    public void testObtenerSeguidos() {
        System.out.println("obtenerSeguidos");
        Cliente instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.obtenerSeguidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarLista method, of class Cliente.
     */
    @Test
    public void testCargarLista() {
        System.out.println("cargarLista");
        ListaParticular lp = null;
        Cliente instance = null;
        instance.cargarLista(lp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
