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
public class SuscripcionTest {
    
    public SuscripcionTest() {
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
     * Test of getEstado method, of class Suscripcion.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Suscripcion instance = null;
        String expResult = "";
        String result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCuota method, of class Suscripcion.
     */
    @Test
    public void testGetCuota() {
        System.out.println("getCuota");
        Suscripcion instance = null;
        String expResult = "";
        String result = instance.getCuota();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaVenc method, of class Suscripcion.
     */
    @Test
    public void testGetFechaVenc() {
        System.out.println("getFechaVenc");
        Suscripcion instance = null;
        DtFecha expResult = null;
        DtFecha result = instance.getFechaVenc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonto method, of class Suscripcion.
     */
    @Test
    public void testGetMonto() {
        System.out.println("getMonto");
        Suscripcion instance = null;
        int expResult = 0;
        int result = instance.getMonto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class Suscripcion.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Suscripcion instance = null;
        DtFecha expResult = null;
        DtFecha result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class Suscripcion.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        DtFecha fecha = null;
        Suscripcion instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMonto method, of class Suscripcion.
     */
    @Test
    public void testSetMonto() {
        System.out.println("setMonto");
        int monto = 0;
        Suscripcion instance = null;
        instance.setMonto(monto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Suscripcion.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "";
        Suscripcion instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCuota method, of class Suscripcion.
     */
    @Test
    public void testSetCuota() {
        System.out.println("setCuota");
        String cuota = "";
        Suscripcion instance = null;
        instance.setCuota(cuota);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha_venc method, of class Suscripcion.
     */
    @Test
    public void testSetFecha_venc() {
        System.out.println("setFecha_venc");
        DtFecha fecha_venc = null;
        Suscripcion instance = null;
        instance.setFecha_venc(fecha_venc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Suscripcion.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Suscripcion instance = null;
        DtSuscripcion expResult = null;
        DtSuscripcion result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
