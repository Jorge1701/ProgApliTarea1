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
public class DtArtistaTest {
    
    public DtArtistaTest() {
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
     * Test of getBiografia method, of class DtArtista.
     */
    @Test
    public void testGetBiografia() {
        System.out.println("getBiografia");
        DtArtista instance = null;
        String expResult = "";
        String result = instance.getBiografia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeb method, of class DtArtista.
     */
    @Test
    public void testGetWeb() {
        System.out.println("getWeb");
        DtArtista instance = null;
        String expResult = "";
        String result = instance.getWeb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
