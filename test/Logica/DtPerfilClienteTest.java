/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
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
public class DtPerfilClienteTest {
    
    public DtPerfilClienteTest() {
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
     * Test of getSeguidos method, of class DtPerfilCliente.
     */
    @Test
    public void testGetSeguidos() {
        System.out.println("getSeguidos");
        DtPerfilCliente instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.getSeguidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListasCreadas method, of class DtPerfilCliente.
     */
    @Test
    public void testGetListasCreadas() {
        System.out.println("getListasCreadas");
        DtPerfilCliente instance = null;
        ArrayList<DtListaParticular> expResult = null;
        ArrayList<DtListaParticular> result = instance.getListasCreadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlbumes method, of class DtPerfilCliente.
     */
    @Test
    public void testGetAlbumes() {
        System.out.println("getAlbumes");
        DtPerfilCliente instance = null;
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.getAlbumes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListasFavoritas method, of class DtPerfilCliente.
     */
    @Test
    public void testGetListasFavoritas() {
        System.out.println("getListasFavoritas");
        DtPerfilCliente instance = null;
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.getListasFavoritas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTemas method, of class DtPerfilCliente.
     */
    @Test
    public void testGetTemas() {
        System.out.println("getTemas");
        DtPerfilCliente instance = null;
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.getTemas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
