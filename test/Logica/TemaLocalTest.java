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
public class TemaLocalTest {
    
    public TemaLocalTest() {
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
     * Test of getDirectorio method, of class TemaLocal.
     */
    @Test
    public void testGetDirectorio() {
        System.out.println("getDirectorio");
        TemaLocal instance = null;
        String expResult = "";
        String result = instance.getDirectorio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDirectorio method, of class TemaLocal.
     */
    @Test
    public void testSetDirectorio() {
        System.out.println("setDirectorio");
        String directorio = "";
        TemaLocal instance = null;
        instance.setDirectorio(directorio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class TemaLocal.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        TemaLocal instance = null;
        DtTemaLocal expResult = null;
        DtTemaLocal result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
