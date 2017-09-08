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
public class DtTimeTest {
    
    public DtTimeTest() {
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
     * Test of getHoras method, of class DtTime.
     */
    @Test
    public void testGetHoras() {
        System.out.println("getHoras");
        DtTime instance = null;
        int expResult = 0;
        int result = instance.getHoras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinutos method, of class DtTime.
     */
    @Test
    public void testGetMinutos() {
        System.out.println("getMinutos");
        DtTime instance = null;
        int expResult = 0;
        int result = instance.getMinutos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSegundos method, of class DtTime.
     */
    @Test
    public void testGetSegundos() {
        System.out.println("getSegundos");
        DtTime instance = null;
        int expResult = 0;
        int result = instance.getSegundos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DtTime.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtTime instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
