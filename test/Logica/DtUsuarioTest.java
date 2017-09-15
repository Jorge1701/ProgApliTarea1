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

    private static DtUsuario dtUsuario;
    private static String nickname;
    private static String nombre;
    private static String apellido;
    private static String email;
    private static DtFecha fechaNac;
    private static String imagen;

    @BeforeClass
    public static void setUpClass() {
        nickname = "nickname";
        nombre = "nombre";
        apellido = "apellido";
        email = "email";
        fechaNac = new DtFecha(30, 11, 1996);
        imagen = "imagen";
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dtUsuario = new DtUsuario(nickname, nombre, apellido, email, fechaNac, imagen,"");
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
        DtUsuario instance = dtUsuario;
        String expResult = nickname;
        String result = instance.getNickname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class DtUsuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DtUsuario instance = dtUsuario;
        String expResult = nombre;
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getApellido method, of class DtUsuario.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        DtUsuario instance = dtUsuario;
        String expResult = apellido;
        String result = instance.getApellido();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class DtUsuario.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        DtUsuario instance = dtUsuario;
        String expResult = email;
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFechaNac method, of class DtUsuario.
     */
    @Test
    public void testGetFechaNac() {
        System.out.println("getFechaNac");
        DtUsuario instance = dtUsuario;
        DtFecha fecha = fechaNac;
        DtFecha obtenida = instance.getFechaNac();

        boolean result = true;
        if (fecha.getDia() != obtenida.getDia()) {
            result = false;
        }
        if (fecha.getMes() != obtenida.getMes()) {
            result = false;
        }
        if (fecha.getAnio() != obtenida.getAnio()) {
            result = false;
        }

        assertEquals(true, result);
    }

    /**
     * Test of getImagen method, of class DtUsuario.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        DtUsuario instance = dtUsuario;
        String expResult = imagen;
        String result = instance.getImagen();
        assertEquals(expResult, result);
    }

}
