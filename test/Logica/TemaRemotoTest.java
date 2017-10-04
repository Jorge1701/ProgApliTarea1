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
public class TemaRemotoTest {
    
    public TemaRemotoTest() {
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
     * Test of getUrl method, of class TemaRemoto.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl");
        TemaRemoto instance = null;
        String expResult = "";
        String result = instance.getUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl method, of class TemaRemoto.
     */
    @Test
    public void testSetUrl() {
        System.out.println("setUrl");
        String url = "";
        TemaRemoto instance = null;
        instance.setUrl(url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class TemaRemoto.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        TemaRemoto instance = null;
        DtTemaRemoto expResult = null;
        DtTemaRemoto result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
