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
public class ListaDefectoTest {
    
    public ListaDefectoTest() {
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
     * Test of getData method, of class ListaDefecto.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        ListaDefecto instance = null;
        DtLista expResult = null;
        DtLista result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGenero method, of class ListaDefecto.
     */
    @Test
    public void testGetGenero() {
        System.out.println("getGenero");
        ListaDefecto instance = null;
        Genero expResult = null;
        Genero result = instance.getGenero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGenero method, of class ListaDefecto.
     */
    @Test
    public void testSetGenero() {
        System.out.println("setGenero");
        Genero genero = null;
        ListaDefecto instance = null;
        instance.setGenero(genero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitarTema method, of class ListaDefecto.
     */
    @Test
    public void testQuitarTema() {
        System.out.println("quitarTema");
        String nombreT = "";
        ListaDefecto instance = null;
        boolean expResult = false;
        boolean result = instance.quitarTema(nombreT);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarTema method, of class ListaDefecto.
     */
    @Test
    public void testAgregarTema() {
        System.out.println("agregarTema");
        Tema tema = null;
        ListaDefecto instance = null;
        boolean expResult = false;
        boolean result = instance.agregarTema(tema);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
