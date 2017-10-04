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
public class DtClienteTest {

    public DtClienteTest() {
    }

    private static DtCliente dtCliente;
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
        dtCliente = new DtCliente(nickname, nombre, apellido, email, fechaNac, imagen, "", null);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        System.out.println("SomeMethod");
        DtUsuario instance = dtCliente;

        boolean result = true;
        if (!instance.getNickname().equals(nickname)) {
            result = false;
        }
        if (!instance.getNombre().equals(nombre)) {
            result = false;
        }
        if (!instance.getApellido().equals(apellido)) {
            result = false;
        }
        if (!instance.getEmail().equals(email)) {
            result = false;
        }
        if (!instance.getImagen().equals(imagen)) {
            result = false;
        }
        if (instance.getFechaNac().getDia() != fechaNac.getDia()) {
            result = false;
        }
        if (instance.getFechaNac().getMes() != fechaNac.getMes()) {
            result = false;
        }
        if (instance.getFechaNac().getAnio() != fechaNac.getAnio()) {
            result = false;
        }

        assertEquals(true, result);
    }

    /**
     * Test of getSuscripciones method, of class DtCliente.
     */
    @Test
    public void testGetSuscripciones() {
        System.out.println("getSuscripciones");
        DtCliente instance = null;
        ArrayList<DtSuscripcion> expResult = null;
        ArrayList<DtSuscripcion> result = instance.getSuscripciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuscripcion method, of class DtCliente.
     */
    @Test
    public void testGetSuscripcion() {
        System.out.println("getSuscripcion");
        DtCliente instance = null;
        DtSuscripcion expResult = null;
        DtSuscripcion result = instance.getSuscripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
