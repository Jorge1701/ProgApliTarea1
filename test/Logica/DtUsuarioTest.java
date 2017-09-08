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
public class DtUsuarioTest {
    
    public DtUsuarioTest() {
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
     * Test of getNickname method, of class DtUsuario.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        DtUsuario instance = null;
        String expResult = "";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class DtUsuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DtUsuario instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class DtUsuario.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        DtUsuario instance = null;
        String expResult = "";
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class DtUsuario.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        DtUsuario instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaNac method, of class DtUsuario.
     */
    @Test
    public void testGetFechaNac() {
        System.out.println("getFechaNac");
        DtUsuario instance = null;
        DtFecha expResult = null;
        DtFecha result = instance.getFechaNac();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImagen method, of class DtUsuario.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        DtUsuario instance = null;
        String expResult = "";
        String result = instance.getImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
