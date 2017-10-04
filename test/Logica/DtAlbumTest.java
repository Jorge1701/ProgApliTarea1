/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
public class DtAlbumTest {
    
    public DtAlbumTest() {
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
     * Test of getNickArtista method, of class DtAlbum.
     */
    @Test
    public void testGetNickArtista() {
        System.out.println("getNickArtista");
        DtAlbum instance = null;
        String expResult = "";
        String result = instance.getNickArtista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class DtAlbum.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DtAlbum instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnio method, of class DtAlbum.
     */
    @Test
    public void testGetAnio() {
        System.out.println("getAnio");
        DtAlbum instance = null;
        int expResult = 0;
        int result = instance.getAnio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImagen method, of class DtAlbum.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        DtAlbum instance = null;
        String expResult = "";
        String result = instance.getImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
