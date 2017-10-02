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
public class ControladorUsuarioTest {
    
    public ControladorUsuarioTest() {
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
     * Test of cargarInstancia method, of class ControladorUsuario.
     */
    @Test
    public void testCargarInstancia() {
        System.out.println("cargarInstancia");
        ControladorUsuario.cargarInstancia();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class ControladorUsuario.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ControladorUsuario expResult = null;
        ControladorUsuario result = ControladorUsuario.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIContenido method, of class ControladorUsuario.
     */
    @Test
    public void testSetIContenido() {
        System.out.println("setIContenido");
        IContenido iContenido = null;
        ControladorUsuario instance = null;
        instance.setIContenido(iContenido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testObtenerUsuario() {
        System.out.println("obtenerUsuario");
        String nick = "";
        ControladorUsuario instance = null;
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuario(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectArtista method, of class ControladorUsuario.
     */
    @Test
    public void testSelectArtista() {
        System.out.println("selectArtista");
        String nick = "";
        ControladorUsuario instance = null;
        Artista expResult = null;
        Artista result = instance.selectArtista(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testIngresarUsuario() {
        System.out.println("ingresarUsuario");
        DtUsuario dtu = null;
        ControladorUsuario instance = null;
        boolean expResult = false;
        boolean result = instance.ingresarUsuario(dtu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of levantarUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testLevantarUsuario() {
        System.out.println("levantarUsuario");
        DtUsuario dtu = null;
        ControladorUsuario instance = null;
        instance.levantarUsuario(dtu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarUsuarios method, of class ControladorUsuario.
     */
    @Test
    public void testListarUsuarios() {
        System.out.println("listarUsuarios");
        ControladorUsuario instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarClientes method, of class ControladorUsuario.
     */
    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        ControladorUsuario instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarArtistas method, of class ControladorUsuario.
     */
    @Test
    public void testListarArtistas() {
        System.out.println("listarArtistas");
        ControladorUsuario instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarArtistas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPerfilArtista method, of class ControladorUsuario.
     */
    @Test
    public void testObtenerPerfilArtista() {
        System.out.println("obtenerPerfilArtista");
        String nickArtista = "";
        ControladorUsuario instance = null;
        DtPerfilUsuario expResult = null;
        DtPerfilUsuario result = instance.obtenerPerfilArtista(nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPerfilCliente method, of class ControladorUsuario.
     */
    @Test
    public void testObtenerPerfilCliente() {
        System.out.println("obtenerPerfilCliente");
        String nickCliente = "";
        ControladorUsuario instance = null;
        DtPerfilUsuario expResult = null;
        DtPerfilUsuario result = instance.obtenerPerfilCliente(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testGetDataUsuario() {
        System.out.println("getDataUsuario");
        String nickUsuario = "";
        ControladorUsuario instance = null;
        DtUsuario expResult = null;
        DtUsuario result = instance.getDataUsuario(nickUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seguirUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testSeguirUsuario() {
        System.out.println("seguirUsuario");
        String nickCliente = "";
        String nickSeguido = "";
        ControladorUsuario instance = null;
        instance.seguirUsuario(nickCliente, nickSeguido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dejarSeguirUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testDejarSeguirUsuario() {
        System.out.println("dejarSeguirUsuario");
        String nickSeguidor = "";
        String nickUsuario = "";
        ControladorUsuario instance = null;
        instance.dejarSeguirUsuario(nickSeguidor, nickUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarAlbumesArtista method, of class ControladorUsuario.
     */
    @Test
    public void testListarAlbumesArtista() {
        System.out.println("listarAlbumesArtista");
        String nickArtista = "";
        ControladorUsuario instance = null;
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.listarAlbumesArtista(nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAlbumContenido method, of class ControladorUsuario.
     */
    @Test
    public void testObtenerAlbumContenido() {
        System.out.println("obtenerAlbumContenido");
        String nickArtista = "";
        String nomAlbum = "";
        ControladorUsuario instance = null;
        DtAlbumContenido expResult = null;
        DtAlbumContenido result = instance.obtenerAlbumContenido(nickArtista, nomAlbum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarUsuarios method, of class ControladorUsuario.
     */
    @Test
    public void testCargarUsuarios() {
        System.out.println("cargarUsuarios");
        ControladorUsuario instance = null;
        instance.cargarUsuarios();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        String nick = "";
        ControladorUsuario instance = null;
        Usuario expResult = null;
        Usuario result = instance.getUsuario(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarSeguidosDe method, of class ControladorUsuario.
     */
    @Test
    public void testListarSeguidosDe() {
        System.out.println("listarSeguidosDe");
        String nickCliente = "";
        ControladorUsuario instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarSeguidosDe(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarSeguidoresDe method, of class ControladorUsuario.
     */
    @Test
    public void testListarSeguidoresDe() {
        System.out.println("listarSeguidoresDe");
        String nickUsuario = "";
        ControladorUsuario instance = null;
        ArrayList<DtCliente> expResult = null;
        ArrayList<DtCliente> result = instance.listarSeguidoresDe(nickUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarListaReproduccionCli method, of class ControladorUsuario.
     */
    @Test
    public void testListarListaReproduccionCli() {
        System.out.println("listarListaReproduccionCli");
        String nickCliente = "";
        ControladorUsuario instance = null;
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarListaReproduccionCli(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectListaCli method, of class ControladorUsuario.
     */
    @Test
    public void testSelectListaCli() {
        System.out.println("selectListaCli");
        String nombreL = "";
        ControladorUsuario instance = null;
        DtLista expResult = null;
        DtLista result = instance.selectListaCli(nombreL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLisReproduccion method, of class ControladorUsuario.
     */
    @Test
    public void testListarLisReproduccion() {
        System.out.println("listarLisReproduccion");
        String nickCliente = "";
        ControladorUsuario instance = null;
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarLisReproduccion(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAlbumFav method, of class ControladorUsuario.
     */
    @Test
    public void testAgregarAlbumFav() {
        System.out.println("agregarAlbumFav");
        String nickCliente = "";
        String nickArtista = "";
        String nomAlbum = "";
        ControladorUsuario instance = null;
        instance.agregarAlbumFav(nickCliente, nickArtista, nomAlbum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarLPFav method, of class ControladorUsuario.
     */
    @Test
    public void testAgregarLPFav() {
        System.out.println("agregarLPFav");
        String nickCliente = "";
        String nickClienteDuenio = "";
        String nomLista = "";
        ControladorUsuario instance = null;
        instance.agregarLPFav(nickCliente, nickClienteDuenio, nomLista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarLDFav method, of class ControladorUsuario.
     */
    @Test
    public void testAgregarLDFav() {
        System.out.println("agregarLDFav");
        String nickCliente = "";
        String nomGenero = "";
        String nomLista = "";
        ControladorUsuario instance = null;
        instance.agregarLDFav(nickCliente, nomGenero, nomLista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarTemaFav method, of class ControladorUsuario.
     */
    @Test
    public void testAgregarTemaFav() {
        System.out.println("agregarTemaFav");
        String nickCliente = "";
        String nickArtista = "";
        String nomAlbum = "";
        String nomTema = "";
        ControladorUsuario instance = null;
        instance.agregarTemaFav(nickCliente, nickArtista, nomAlbum, nomTema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAlbumFav method, of class ControladorUsuario.
     */
    @Test
    public void testEliminarAlbumFav() {
        System.out.println("eliminarAlbumFav");
        String nickCliente = "";
        int i = 0;
        ControladorUsuario instance = null;
        instance.eliminarAlbumFav(nickCliente, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarListaFav method, of class ControladorUsuario.
     */
    @Test
    public void testEliminarListaFav() {
        System.out.println("eliminarListaFav");
        String nickCliente = "";
        int i = 0;
        ControladorUsuario instance = null;
        instance.eliminarListaFav(nickCliente, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTemaFav method, of class ControladorUsuario.
     */
    @Test
    public void testEliminarTemaFav() {
        System.out.println("eliminarTemaFav");
        String nickCliente = "";
        int i = 0;
        ControladorUsuario instance = null;
        instance.eliminarTemaFav(nickCliente, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAlbumesFav method, of class ControladorUsuario.
     */
    @Test
    public void testObtenerAlbumesFav() {
        System.out.println("obtenerAlbumesFav");
        String nickCliente = "";
        ControladorUsuario instance = null;
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.obtenerAlbumesFav(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerListasFav method, of class ControladorUsuario.
     */
    @Test
    public void testObtenerListasFav() {
        System.out.println("obtenerListasFav");
        String nickCliente = "";
        ControladorUsuario instance = null;
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.obtenerListasFav(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTemasFav method, of class ControladorUsuario.
     */
    @Test
    public void testObtenerTemasFav() {
        System.out.println("obtenerTemasFav");
        String nickCliente = "";
        ControladorUsuario instance = null;
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.obtenerTemasFav(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarAlbum method, of class ControladorUsuario.
     */
    @Test
    public void testCargarAlbum() {
        System.out.println("cargarAlbum");
        Album a = null;
        ControladorUsuario instance = null;
        instance.cargarAlbum(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarLista method, of class ControladorUsuario.
     */
    @Test
    public void testCargarLista() {
        System.out.println("cargarLista");
        ListaParticular lp = null;
        String nickcliente = "";
        ControladorUsuario instance = null;
        instance.cargarLista(lp, nickcliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTema method, of class ControladorUsuario.
     */
    @Test
    public void testGetTema() {
        System.out.println("getTema");
        String nombreCliente = "";
        String nombreTema = "";
        ControladorUsuario instance = null;
        Tema expResult = null;
        Tema result = instance.getTema(nombreCliente, nombreTema);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reiniciar method, of class ControladorUsuario.
     */
    @Test
    public void testReiniciar() {
        System.out.println("reiniciar");
        ControladorUsuario instance = null;
        instance.reiniciar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of correoExiste method, of class ControladorUsuario.
     */
    @Test
    public void testCorreoExiste() {
        System.out.println("correoExiste");
        String correo = "";
        ControladorUsuario instance = null;
        boolean expResult = false;
        boolean result = instance.correoExiste(correo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chequearLogin method, of class ControladorUsuario.
     */
    @Test
    public void testChequearLogin() {
        System.out.println("chequearLogin");
        String nickname = "";
        String pass = "";
        ControladorUsuario instance = null;
        String expResult = "";
        String result = instance.chequearLogin(nickname, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarSuscripcion method, of class ControladorUsuario.
     */
    @Test
    public void testActualizarSuscripcion() {
        System.out.println("actualizarSuscripcion");
        String nickname = "";
        String estado = "";
        DtFecha fecha = null;
        ControladorUsuario instance = null;
        boolean expResult = false;
        boolean result = instance.actualizarSuscripcion(nickname, estado, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
