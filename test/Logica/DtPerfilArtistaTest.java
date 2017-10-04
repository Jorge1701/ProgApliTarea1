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
public class DtPerfilArtistaTest {
    
    public DtPerfilArtistaTest() {
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
     * Test of getBiografia method, of class DtPerfilArtista.
     */
    @Test
    public void testGetBiografia() {
        System.out.println("getBiografia");
        DtPerfilArtista instance = null;
        String expResult = "";
        String result = instance.getBiografia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeb method, of class DtPerfilArtista.
     */
    @Test
    public void testGetWeb() {
        System.out.println("getWeb");
        DtPerfilArtista instance = null;
        String expResult = "";
        String result = instance.getWeb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlbumes method, of class DtPerfilArtista.
     */
    @Test
    public void testGetAlbumes() {
        System.out.println("getAlbumes");
        DtPerfilArtista instance = null;
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.getAlbumes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfoArtista method, of class DtPerfilArtista.
     */
    @Test
    public void testGetInfoArtista() {
        System.out.println("getInfoArtista");
        DtPerfilArtista instance = null;
        DtPerfilArtista expResult = null;
        DtPerfilArtista result = instance.getInfoArtista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
