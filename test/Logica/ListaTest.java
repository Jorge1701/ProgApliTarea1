/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
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
public class ListaTest {
    
    public ListaTest() {
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
     * Test of getImagen method, of class Lista.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        Lista instance = null;
        String expResult = "";
        String result = instance.getImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Lista.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Lista instance = null;
        DtLista expResult = null;
        DtLista result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Lista.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Lista instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTema method, of class Lista.
     */
    @Test
    public void testGetTema() {
        System.out.println("getTema");
        String nombreT = "";
        Lista instance = null;
        Tema expResult = null;
        Tema result = instance.getTema(nombreT);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTemas method, of class Lista.
     */
    @Test
    public void testGetTemas() {
        System.out.println("getTemas");
        Lista instance = null;
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.getTemas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTemas method, of class Lista.
     */
    @Test
    public void testObtenerTemas() {
        System.out.println("obtenerTemas");
        Lista instance = null;
        ArrayList<Tema> expResult = null;
        ArrayList<Tema> result = instance.obtenerTemas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Lista.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Lista instance = null;
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTemas method, of class Lista.
     */
    @Test
    public void testSetTemas() {
        System.out.println("setTemas");
        ArrayList<Tema> temas = null;
        Lista instance = null;
        instance.setTemas(temas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImagen method, of class Lista.
     */
    @Test
    public void testSetImagen() {
        System.out.println("setImagen");
        String imagen = "";
        Lista instance = null;
        instance.setImagen(imagen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitarTema method, of class Lista.
     */
    @Test
    public void testQuitarTema() {
        System.out.println("quitarTema");
        String nombreT = "";
        Lista instance = null;
        boolean expResult = false;
        boolean result = instance.quitarTema(nombreT);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarTema method, of class Lista.
     */
    @Test
    public void testAgregarTema() {
        System.out.println("agregarTema");
        Tema tema = null;
        Lista instance = null;
        boolean expResult = false;
        boolean result = instance.agregarTema(tema);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ListaImpl extends Lista {

        public ListaImpl() {
            super("", null, "");
        }

        public DtLista getData() {
            return null;
        }

        public boolean quitarTema(String nombreT) {
            return false;
        }

        public boolean agregarTema(Tema tema) {
            return false;
        }
    }
    
}
