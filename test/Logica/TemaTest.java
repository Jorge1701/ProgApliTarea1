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
public class TemaTest {
    
    public TemaTest() {
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
     * Test of getAlbum method, of class Tema.
     */
    @Test
    public void testGetAlbum() {
        System.out.println("getAlbum");
        Tema instance = null;
        Album expResult = null;
        Album result = instance.getAlbum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlbum method, of class Tema.
     */
    @Test
    public void testSetAlbum() {
        System.out.println("setAlbum");
        Album a = null;
        Tema instance = null;
        instance.setAlbum(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Tema.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Tema instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Tema.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Tema instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Tema.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Tema instance = null;
        DtTema expResult = null;
        DtTema result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Tema.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Tema instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDuracion method, of class Tema.
     */
    @Test
    public void testGetDuracion() {
        System.out.println("getDuracion");
        Tema instance = null;
        DtTime expResult = null;
        DtTime result = instance.getDuracion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUbicacion method, of class Tema.
     */
    @Test
    public void testGetUbicacion() {
        System.out.println("getUbicacion");
        Tema instance = null;
        int expResult = 0;
        int result = instance.getUbicacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Tema.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Tema instance = null;
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDuracion method, of class Tema.
     */
    @Test
    public void testSetDuracion() {
        System.out.println("setDuracion");
        DtTime duracion = null;
        Tema instance = null;
        instance.setDuracion(duracion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUbicacion method, of class Tema.
     */
    @Test
    public void testSetUbicacion() {
        System.out.println("setUbicacion");
        int ubicacion = 0;
        Tema instance = null;
        instance.setUbicacion(ubicacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
