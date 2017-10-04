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
public class DtPerfilUsuarioTest {
    
    public DtPerfilUsuarioTest() {
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
     * Test of getInfo method, of class DtPerfilUsuario.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        DtPerfilUsuario instance = null;
        DtUsuario expResult = null;
        DtUsuario result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeguidores method, of class DtPerfilUsuario.
     */
    @Test
    public void testGetSeguidores() {
        System.out.println("getSeguidores");
        DtPerfilUsuario instance = null;
        ArrayList<DtCliente> expResult = null;
        ArrayList<DtCliente> result = instance.getSeguidores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
