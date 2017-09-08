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
public class DtAlbumContenidoTest {
    
    public DtAlbumContenidoTest() {
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
     * Test of getInfo method, of class DtAlbumContenido.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        DtAlbumContenido instance = null;
        DtAlbum expResult = null;
        DtAlbum result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGeneros method, of class DtAlbumContenido.
     */
    @Test
    public void testGetGeneros() {
        System.out.println("getGeneros");
        DtAlbumContenido instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getGeneros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTemas method, of class DtAlbumContenido.
     */
    @Test
    public void testGetTemas() {
        System.out.println("getTemas");
        DtAlbumContenido instance = null;
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.getTemas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
