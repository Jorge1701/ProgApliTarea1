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
public class DtGeneroTest {

    public DtGeneroTest() {
    }

    private static Genero g;
    private static String nombre;

    @BeforeClass
    public static void setUpClass() {
        nombre = "Padre";
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        g = new Genero(nombre);
        g.agregarGenero(nombre, "genero1");
        g.agregarGenero(nombre, "genero2");
        g.agregarGenero(nombre, "genero3");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class DtGenero.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DtGenero instance = g.getData();
        String expResult = nombre;
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSubGeneros method, of class DtGenero.
     */
    @Test
    public void testGetSubGeneros() {
        System.out.println("getSubGeneros");
        DtGenero instance = g.getData();

        ArrayList<DtGenero> expResult = new ArrayList<>();
        expResult.add(new DtGenero("genero1", new ArrayList<>()));
        expResult.add(new DtGenero("genero2", new ArrayList<>()));
        expResult.add(new DtGenero("genero3", new ArrayList<>()));

        ArrayList<DtGenero> obtenido = instance.getSubGeneros();

        boolean result = true;

        for (int i = 0; i < obtenido.size(); i++) {
            String nom1 = ((DtGenero) obtenido.get(i)).getNombre();
            String nom2 = ((DtGenero) expResult.get(i)).getNombre();
            if (!nom1.equals(nom2)) {
                result = false;
            }
        }

        assertEquals(true, result);
    }

}
