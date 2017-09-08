/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.HashMap;
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
public class UsuarioTest {
    
    public UsuarioTest() {
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
     * Test of getTipo method, of class Usuario.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Usuario.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Usuario instance = null;
        DtUsuario expResult = null;
        DtUsuario result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPerfil method, of class Usuario.
     */
    @Test
    public void testObtenerPerfil() {
        System.out.println("obtenerPerfil");
        Usuario instance = null;
        DtPerfilUsuario expResult = null;
        DtPerfilUsuario result = instance.obtenerPerfil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeguidores method, of class Usuario.
     */
    @Test
    public void testGetSeguidores() {
        System.out.println("getSeguidores");
        Usuario instance = null;
        ArrayList<DtCliente> expResult = null;
        ArrayList<DtCliente> result = instance.getSeguidores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clienteMeDejoDeSeguir method, of class Usuario.
     */
    @Test
    public void testClienteMeDejoDeSeguir() {
        System.out.println("clienteMeDejoDeSeguir");
        Cliente c = null;
        Usuario instance = null;
        instance.clienteMeDejoDeSeguir(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNickname method, of class Usuario.
     */
    @Test
    public void testSetNickname() {
        System.out.println("setNickname");
        String nickname = "";
        Usuario instance = null;
        instance.setNickname(nickname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Usuario instance = null;
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApellido method, of class Usuario.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "";
        Usuario instance = null;
        instance.setApellido(apellido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Usuario.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Usuario instance = null;
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaNac method, of class Usuario.
     */
    @Test
    public void testSetFechaNac() {
        System.out.println("setFechaNac");
        DtFecha fechaNac = null;
        Usuario instance = null;
        instance.setFechaNac(fechaNac);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImagen method, of class Usuario.
     */
    @Test
    public void testSetImagen() {
        System.out.println("setImagen");
        String imagen = "";
        Usuario instance = null;
        instance.setImagen(imagen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImagen method, of class Usuario.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeguidores method, of class Usuario.
     */
    @Test
    public void testSetSeguidores() {
        System.out.println("setSeguidores");
        HashMap<String, Cliente> seguidores = null;
        Usuario instance = null;
        instance.setSeguidores(seguidores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class Usuario.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Usuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class Usuario.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Usuario.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaNac method, of class Usuario.
     */
    @Test
    public void testGetFechaNac() {
        System.out.println("getFechaNac");
        Usuario instance = null;
        DtFecha expResult = null;
        DtFecha result = instance.getFechaNac();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregar method, of class Usuario.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        Cliente cliente = null;
        Usuario instance = null;
        instance.agregar(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of meComenzoASeguir method, of class Usuario.
     */
    @Test
    public void testMeComenzoASeguir() {
        System.out.println("meComenzoASeguir");
        Cliente cliente = null;
        Usuario instance = null;
        boolean expResult = false;
        boolean result = instance.meComenzoASeguir(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of meDejoDeSeguir method, of class Usuario.
     */
    @Test
    public void testMeDejoDeSeguir() {
        System.out.println("meDejoDeSeguir");
        Cliente cliente = null;
        Usuario instance = null;
        boolean expResult = false;
        boolean result = instance.meDejoDeSeguir(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class UsuarioImpl extends Usuario {

        public UsuarioImpl() {
            super("", "", "", "", null, "");
        }

        public String getTipo() {
            return "";
        }

        public DtUsuario getData() {
            return null;
        }

        public DtPerfilUsuario obtenerPerfil() {
            return null;
        }
    }
    
}
