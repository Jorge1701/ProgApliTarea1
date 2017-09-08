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
public class DtFechaTest {
    
    public DtFechaTest() {
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
     * Test of getDia method, of class DtFecha.
     */
    @Test
    public void testGetDia() {
        System.out.println("getDia");
        DtFecha instance = null;
        int expResult = 0;
        int result = instance.getDia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMes method, of class DtFecha.
     */
    @Test
    public void testGetMes() {
        System.out.println("getMes");
        DtFecha instance = null;
        int expResult = 0;
        int result = instance.getMes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnio method, of class DtFecha.
     */
    @Test
    public void testGetAnio() {
        System.out.println("getAnio");
        DtFecha instance = null;
        int expResult = 0;
        int result = instance.getAnio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DtFecha.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtFecha instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
