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
 * @author jorge
 */
public class DtSuscripcionTest {
    
    public DtSuscripcionTest() {
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
     * Test of getEstado method, of class DtSuscripcion.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        DtSuscripcion instance = null;
        String expResult = "";
        String result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCuota method, of class DtSuscripcion.
     */
    @Test
    public void testGetCuota() {
        System.out.println("getCuota");
        DtSuscripcion instance = null;
        String expResult = "";
        String result = instance.getCuota();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaVenc method, of class DtSuscripcion.
     */
    @Test
    public void testGetFechaVenc() {
        System.out.println("getFechaVenc");
        DtSuscripcion instance = null;
        DtFecha expResult = null;
        DtFecha result = instance.getFechaVenc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonto method, of class DtSuscripcion.
     */
    @Test
    public void testGetMonto() {
        System.out.println("getMonto");
        DtSuscripcion instance = null;
        int expResult = 0;
        int result = instance.getMonto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class DtSuscripcion.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        DtSuscripcion instance = null;
        DtFecha expResult = null;
        DtFecha result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
