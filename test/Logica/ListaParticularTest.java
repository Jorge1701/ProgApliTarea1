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
public class ListaParticularTest {
    
    public ListaParticularTest() {
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
     * Test of getDuenio method, of class ListaParticular.
     */
    @Test
    public void testGetDuenio() {
        System.out.println("getDuenio");
        ListaParticular instance = null;
        String expResult = "";
        String result = instance.getDuenio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class ListaParticular.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        ListaParticular instance = null;
        DtLista expResult = null;
        DtLista result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPrivada method, of class ListaParticular.
     */
    @Test
    public void testIsPrivada() {
        System.out.println("isPrivada");
        ListaParticular instance = null;
        boolean expResult = false;
        boolean result = instance.isPrivada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrivada method, of class ListaParticular.
     */
    @Test
    public void testSetPrivada() {
        System.out.println("setPrivada");
        boolean privada = false;
        ListaParticular instance = null;
        instance.setPrivada(privada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitarTema method, of class ListaParticular.
     */
    @Test
    public void testQuitarTema() {
        System.out.println("quitarTema");
        String nombreT = "";
        ListaParticular instance = null;
        boolean expResult = false;
        boolean result = instance.quitarTema(nombreT);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarTema method, of class ListaParticular.
     */
    @Test
    public void testAgregarTema() {
        System.out.println("agregarTema");
        Tema tema = null;
        ListaParticular instance = null;
        boolean expResult = false;
        boolean result = instance.agregarTema(tema);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
