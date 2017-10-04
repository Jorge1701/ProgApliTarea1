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
public class DtArtistaTest {

    public DtArtistaTest() {
    }

    private static DtArtista dtArtista;
    private static String nickname;
    private static String nombre;
    private static String apellido;
    private static String email;
    private static DtFecha fechaNac;
    private static String imagen;
    private static String bio;
    private static String web;

    @BeforeClass
    public static void setUpClass() {
        nickname = "nickname";
        nombre = "nombre";
        apellido = "apellido";
        email = "email";
        fechaNac = new DtFecha(30, 11, 1996);
        imagen = "imagen";
        bio = "bio";
        web = "web";
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dtArtista = new DtArtista(nickname, nombre, apellido, email, fechaNac, imagen,"" ,bio, web);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getBiografia method, of class DtArtista.
     */
    @Test
    public void testGetBiografia() {
        System.out.println("getBiografia");
        DtArtista instance = dtArtista;
        String expResult = bio;
        String result = instance.getBiografia();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeb method, of class DtArtista.
     */
    @Test
    public void testGetWeb() {
        System.out.println("getWeb");
        DtArtista instance = dtArtista;
        String expResult = web;
        String result = instance.getWeb();
        assertEquals(expResult, result);
    }

}
