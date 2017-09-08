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
public class FabricaTest {
    
    public FabricaTest() {
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
     * Test of inicializarControladores method, of class Fabrica.
     */
    @Test
    public void testInicializarControladores() {
        System.out.println("inicializarControladores");
        Fabrica.inicializarControladores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargaDatosPrueba method, of class Fabrica.
     */
    @Test
    public void testCargaDatosPrueba() throws Exception {
        System.out.println("cargaDatosPrueba");
        Fabrica.cargaDatosPrueba();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of levantarDatos method, of class Fabrica.
     */
    @Test
    public void testLevantarDatos() throws Exception {
        System.out.println("levantarDatos");
        Fabrica.levantarDatos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIControladorUsuario method, of class Fabrica.
     */
    @Test
    public void testGetIControladorUsuario() {
        System.out.println("getIControladorUsuario");
        IUsuario expResult = null;
        IUsuario result = Fabrica.getIControladorUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIControladorContenido method, of class Fabrica.
     */
    @Test
    public void testGetIControladorContenido() {
        System.out.println("getIControladorContenido");
        IContenido expResult = null;
        IContenido result = Fabrica.getIControladorContenido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
