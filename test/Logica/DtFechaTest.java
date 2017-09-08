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

    private static DtFecha dtFecha;
    private static int dia;
    private static int mes;
    private static int anio;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dtFecha = new DtFecha(dia, mes, anio);
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
        DtFecha instance = dtFecha;
        int expResult = dia;
        int result = instance.getDia();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMes method, of class DtFecha.
     */
    @Test
    public void testGetMes() {
        System.out.println("getMes");
        DtFecha instance = dtFecha;
        int expResult = mes;
        int result = instance.getMes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnio method, of class DtFecha.
     */
    @Test
    public void testGetAnio() {
        System.out.println("getAnio");
        DtFecha instance = dtFecha;
        int expResult = anio;
        int result = instance.getAnio();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class DtFecha.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtFecha instance = dtFecha;
        String expResult = dia + "/" + mes + "/" + anio;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
