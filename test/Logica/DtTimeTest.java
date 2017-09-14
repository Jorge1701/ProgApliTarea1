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

    private static DtTime time;
    private static int horas;
    private static int minutos;
    private static int segundos;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        time = new DtTime(horas, minutos, segundos);
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
        DtTime instance = time;
        int expResult = horas;
        int result = instance.getHoras();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinutos method, of class DtTime.
     */
    @Test
    public void testGetMinutos() {
        System.out.println("getMinutos");
        DtTime instance = time;
        int expResult = minutos;
        int result = instance.getMinutos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSegundos method, of class DtTime.
     */
    @Test
    public void testGetSegundos() {
        System.out.println("getSegundos");
        DtTime instance = time;
        int expResult = segundos;
        int result = instance.getSegundos();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class DtTime.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtTime instance = time;
        String expResult = horas + ":" + minutos + ":" + segundos;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
