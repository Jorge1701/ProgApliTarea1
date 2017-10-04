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
public class DtTemaTest {
    
    public DtTemaTest() {
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
     * Test of getNombre method, of class DtTema.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DtTema instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDuracion method, of class DtTema.
     */
    @Test
    public void testGetDuracion() {
        System.out.println("getDuracion");
        DtTema instance = null;
        DtTime expResult = null;
        DtTime result = instance.getDuracion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUbicacion method, of class DtTema.
     */
    @Test
    public void testGetUbicacion() {
        System.out.println("getUbicacion");
        DtTema instance = null;
        int expResult = 0;
        int result = instance.getUbicacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUbicacion method, of class DtTema.
     */
    @Test
    public void testSetUbicacion() {
        System.out.println("setUbicacion");
        int ubicacion = 0;
        DtTema instance = null;
        instance.setUbicacion(ubicacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlbum method, of class DtTema.
     */
    @Test
    public void testSetAlbum() {
        System.out.println("setAlbum");
        String album = "";
        DtTema instance = null;
        instance.setAlbum(album);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArtista method, of class DtTema.
     */
    @Test
    public void testSetArtista() {
        System.out.println("setArtista");
        String artista = "";
        DtTema instance = null;
        instance.setArtista(artista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlbum method, of class DtTema.
     */
    @Test
    public void testGetAlbum() {
        System.out.println("getAlbum");
        DtTema instance = null;
        String expResult = "";
        String result = instance.getAlbum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArtista method, of class DtTema.
     */
    @Test
    public void testGetArtista() {
        System.out.println("getArtista");
        DtTema instance = null;
        String expResult = "";
        String result = instance.getArtista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImagenAlbum method, of class DtTema.
     */
    @Test
    public void testGetImagenAlbum() {
        System.out.println("getImagenAlbum");
        DtTema instance = null;
        String expResult = "";
        String result = instance.getImagenAlbum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImagenAlbum method, of class DtTema.
     */
    @Test
    public void testSetImagenAlbum() {
        System.out.println("setImagenAlbum");
        String imagenAlbum = "";
        DtTema instance = null;
        instance.setImagenAlbum(imagenAlbum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
