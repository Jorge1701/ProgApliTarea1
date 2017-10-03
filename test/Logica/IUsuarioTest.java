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
public class IUsuarioTest {

    public IUsuarioTest() {
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
     * Test of setIContenido method, of class IUsuario.
     */
    @Test
    public void testSetIContenido() {
        System.out.println("setIContenido");
        IContenido iContenido = null;
        IUsuario instance = new IUsuarioImpl();
        instance.setIContenido(iContenido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerUsuario method, of class IUsuario.
     */
    @Test
    public void testObtenerUsuario() {
        System.out.println("obtenerUsuario");
        String nick = "";
        IUsuario instance = new IUsuarioImpl();
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuario(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectArtista method, of class IUsuario.
     */
    @Test
    public void testSelectArtista() {
        System.out.println("selectArtista");
        String nick = "";
        IUsuario instance = new IUsuarioImpl();
        Artista expResult = null;
        Artista result = instance.selectArtista(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarUsuarios method, of class IUsuario.
     */
    @Test
    public void testListarUsuarios() {
        System.out.println("listarUsuarios");
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarUsuario method, of class IUsuario.
     */
    @Test
    public void testIngresarUsuario() {
        System.out.println("ingresarUsuario");
        DtUsuario dtu = null;
        IUsuario instance = new IUsuarioImpl();
        boolean expResult = false;
        boolean result = instance.ingresarUsuario(dtu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of levantarUsuario method, of class IUsuario.
     */
    @Test
    public void testLevantarUsuario() {
        System.out.println("levantarUsuario");
        DtUsuario dtu = null;
        IUsuario instance = new IUsuarioImpl();
        instance.levantarUsuario(dtu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarClientes method, of class IUsuario.
     */
    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarArtistas method, of class IUsuario.
     */
    @Test
    public void testListarArtistas() {
        System.out.println("listarArtistas");
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarArtistas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPerfilArtista method, of class IUsuario.
     */
    @Test
    public void testObtenerPerfilArtista() {
        System.out.println("obtenerPerfilArtista");
        String nickArtista = "";
        IUsuario instance = new IUsuarioImpl();
        DtPerfilUsuario expResult = null;
        DtPerfilUsuario result = instance.obtenerPerfilArtista(nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPerfilCliente method, of class IUsuario.
     */
    @Test
    public void testObtenerPerfilCliente() {
        System.out.println("obtenerPerfilCliente");
        String nickCliente = "";
        IUsuario instance = new IUsuarioImpl();
        DtPerfilUsuario expResult = null;
        DtPerfilUsuario result = instance.obtenerPerfilCliente(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataUsuario method, of class IUsuario.
     */
    @Test
    public void testGetDataUsuario() {
        System.out.println("getDataUsuario");
        String nickUsuario = "";
        IUsuario instance = new IUsuarioImpl();
        DtUsuario expResult = null;
        DtUsuario result = instance.getDataUsuario(nickUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seguirUsuario method, of class IUsuario.
     */
    @Test
    public void testSeguirUsuario() {
        System.out.println("seguirUsuario");
        String nickC = "";
        String nickU = "";
        IUsuario instance = new IUsuarioImpl();
        instance.seguirUsuario(nickC, nickU);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dejarSeguirUsuario method, of class IUsuario.
     */
    @Test
    public void testDejarSeguirUsuario() {
        System.out.println("dejarSeguirUsuario");
        String nickSeguidor = "";
        String nickUsuario = "";
        IUsuario instance = new IUsuarioImpl();
        instance.dejarSeguirUsuario(nickSeguidor, nickUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarUsuarios method, of class IUsuario.
     */
    @Test
    public void testCargarUsuarios() {
        System.out.println("cargarUsuarios");
        IUsuario instance = new IUsuarioImpl();
        instance.cargarUsuarios();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarAlbumesArtista method, of class IUsuario.
     */
    @Test
    public void testListarAlbumesArtista() {
        System.out.println("listarAlbumesArtista");
        String nickArtista = "";
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.listarAlbumesArtista(nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAlbumContenido method, of class IUsuario.
     */
    @Test
    public void testObtenerAlbumContenido() {
        System.out.println("obtenerAlbumContenido");
        String nickArt = "";
        String nomAlbum = "";
        IUsuario instance = new IUsuarioImpl();
        DtAlbumContenido expResult = null;
        DtAlbumContenido result = instance.obtenerAlbumContenido(nickArt, nomAlbum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarSeguidoresDe method, of class IUsuario.
     */
    @Test
    public void testListarSeguidoresDe() {
        System.out.println("listarSeguidoresDe");
        String nickUsuario = "";
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtCliente> expResult = null;
        ArrayList<DtCliente> result = instance.listarSeguidoresDe(nickUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarSeguidosDe method, of class IUsuario.
     */
    @Test
    public void testListarSeguidosDe() {
        System.out.println("listarSeguidosDe");
        String nickCliente = "";
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarSeguidosDe(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarListaReproduccionCli method, of class IUsuario.
     */
    @Test
    public void testListarListaReproduccionCli() {
        System.out.println("listarListaReproduccionCli");
        String nickCliente = "";
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarListaReproduccionCli(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectListaCli method, of class IUsuario.
     */
    @Test
    public void testSelectListaCli() {
        System.out.println("selectListaCli");
        String nombreL = "";
        IUsuario instance = new IUsuarioImpl();
        DtLista expResult = null;
        DtLista result = instance.selectListaCli(nombreL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLisReproduccion method, of class IUsuario.
     */
    @Test
    public void testListarLisReproduccion() {
        System.out.println("listarLisReproduccion");
        String nickCliente = "";
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarLisReproduccion(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAlbumFav method, of class IUsuario.
     */
    @Test
    public void testAgregarAlbumFav() {
        System.out.println("agregarAlbumFav");
        String nickCliente = "";
        String nickArtista = "";
        String nomAlbum = "";
        IUsuario instance = new IUsuarioImpl();
        instance.agregarAlbumFav(nickCliente, nickArtista, nomAlbum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarLPFav method, of class IUsuario.
     */
    @Test
    public void testAgregarLPFav() {
        System.out.println("agregarLPFav");
        String nickCliente = "";
        String nickClienteDuenio = "";
        String nomLista = "";
        IUsuario instance = new IUsuarioImpl();
        instance.agregarLPFav(nickCliente, nickClienteDuenio, nomLista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarLDFav method, of class IUsuario.
     */
    @Test
    public void testAgregarLDFav() {
        System.out.println("agregarLDFav");
        String nickCliente = "";
        String nomGenero = "";
        String nomLista = "";
        IUsuario instance = new IUsuarioImpl();
        instance.agregarLDFav(nickCliente, nomGenero, nomLista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarTemaFav method, of class IUsuario.
     */
    @Test
    public void testAgregarTemaFav() {
        System.out.println("agregarTemaFav");
        String nickCliente = "";
        String nickArtista = "";
        String nomAlbum = "";
        String nomTema = "";
        IUsuario instance = new IUsuarioImpl();
        instance.agregarTemaFav(nickCliente, nickArtista, nomAlbum, nomTema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAlbumFav method, of class IUsuario.
     */
    @Test
    public void testEliminarAlbumFav() {
        System.out.println("eliminarAlbumFav");
        String nickCliente = "";
        int i = 0;
        IUsuario instance = new IUsuarioImpl();
        instance.eliminarAlbumFav(nickCliente, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarListaFav method, of class IUsuario.
     */
    @Test
    public void testEliminarListaFav() {
        System.out.println("eliminarListaFav");
        String nickCliente = "";
        int i = 0;
        IUsuario instance = new IUsuarioImpl();
        instance.eliminarListaFav(nickCliente, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTemaFav method, of class IUsuario.
     */
    @Test
    public void testEliminarTemaFav() {
        System.out.println("eliminarTemaFav");
        String nickCliente = "";
        int i = 0;
        IUsuario instance = new IUsuarioImpl();
        instance.eliminarTemaFav(nickCliente, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAlbumesFav method, of class IUsuario.
     */
    @Test
    public void testObtenerAlbumesFav() {
        System.out.println("obtenerAlbumesFav");
        String nickCliente = "";
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.obtenerAlbumesFav(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerListasFav method, of class IUsuario.
     */
    @Test
    public void testObtenerListasFav() {
        System.out.println("obtenerListasFav");
        String nickCliente = "";
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.obtenerListasFav(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTemasFav method, of class IUsuario.
     */
    @Test
    public void testObtenerTemasFav() {
        System.out.println("obtenerTemasFav");
        String nickCliente = "";
        IUsuario instance = new IUsuarioImpl();
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.obtenerTemasFav(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarAlbum method, of class IUsuario.
     */
    @Test
    public void testCargarAlbum() {
        System.out.println("cargarAlbum");
        Album dta = null;
        IUsuario instance = new IUsuarioImpl();
        instance.cargarAlbum(dta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarLista method, of class IUsuario.
     */
    @Test
    public void testCargarLista() {
        System.out.println("cargarLista");
        ListaParticular lp = null;
        String nickcliente = "";
        IUsuario instance = new IUsuarioImpl();
        instance.cargarLista(lp, nickcliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IUsuarioImpl implements IUsuario {

        public void setIContenido(IContenido iContenido) {
        }

        public Usuario obtenerUsuario(String nick) {
            return null;
        }

        public Artista selectArtista(String nick) {
            return null;
        }

        public ArrayList<DtUsuario> listarUsuarios() {
            return null;
        }

        public boolean ingresarUsuario(DtUsuario dtu) {
            return false;
        }

        public void levantarUsuario(DtUsuario dtu) {
        }

        public ArrayList<DtUsuario> listarClientes() {
            return null;
        }

        public ArrayList<DtUsuario> listarArtistas() {
            return null;
        }

        public DtPerfilUsuario obtenerPerfilArtista(String nickArtista) {
            return null;
        }

        public DtPerfilUsuario obtenerPerfilCliente(String nickCliente) {
            return null;
        }

        public DtUsuario getDataUsuario(String nickUsuario) {
            return null;
        }

        public void seguirUsuario(String nickC, String nickU) {
        }

        public void dejarSeguirUsuario(String nickSeguidor, String nickUsuario) {
        }

        public void cargarUsuarios() {
        }

        public ArrayList<DtAlbum> listarAlbumesArtista(String nickArtista) {
            return null;
        }

        public DtAlbumContenido obtenerAlbumContenido(String nickArt, String nomAlbum) {
            return null;
        }

        public ArrayList<DtCliente> listarSeguidoresDe(String nickUsuario) {
            return null;
        }

        public ArrayList<DtUsuario> listarSeguidosDe(String nickCliente) {
            return null;
        }

        public ArrayList<DtLista> listarListaReproduccionCli(String nickCliente) {
            return null;
        }

        public DtLista selectListaCli(String nombreL) {
            return null;
        }

        public ArrayList<DtLista> listarLisReproduccion(String nickCliente) {
            return null;
        }

        public void agregarAlbumFav(String nickCliente, String nickArtista, String nomAlbum) {
        }

        public void agregarLPFav(String nickCliente, String nickClienteDuenio, String nomLista) {
        }

        public void agregarLDFav(String nickCliente, String nomGenero, String nomLista) {
        }

        public void agregarTemaFav(String nickCliente, String nickArtista, String nomAlbum, String nomTema) {
        }

        public void eliminarAlbumFav(String nickCliente, int i) {
        }

        public void eliminarListaFav(String nickCliente, int i) {
        }

        public void eliminarTemaFav(String nickCliente, int i) {
        }

        public ArrayList<DtAlbum> obtenerAlbumesFav(String nickCliente) {
            return null;
        }

        public ArrayList<DtLista> obtenerListasFav(String nickCliente) {
            return null;
        }

        public ArrayList<DtTema> obtenerTemasFav(String nickCliente) {
            return null;
        }

        public void cargarAlbum(Album dta) {
        }

        public void cargarLista(ListaParticular lp, String nickcliente) {
        }

        @Override
        public boolean correoExiste(String correo) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void reiniciar() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String chequearLogin(String nickname, String pass) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean actualizarSuscripcion(String nickname, String estado, DtFecha fecha) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getMonto(String cuota) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean ingresarSuscripcion(String nickname, String cuota) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean esCliente(String nickname) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    /**
     * Test of reiniciar method, of class IUsuario.
     */
    @Test
    public void testReiniciar() {
        System.out.println("reiniciar");
        IUsuario instance = new IUsuarioImpl();
        instance.reiniciar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of correoExiste method, of class IUsuario.
     */
    @Test
    public void testCorreoExiste() {
        System.out.println("correoExiste");
        String correo = "";
        IUsuario instance = new IUsuarioImpl();
        boolean expResult = false;
        boolean result = instance.correoExiste(correo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarSuscripcion method, of class IUsuario.
     */
    @Test
    public void testActualizarSuscripcion() {
        System.out.println("actualizarSuscripcion");
        String nickname = "";
        String estado = "";
        DtFecha fecha = null;
        IUsuario instance = new IUsuarioImpl();
        boolean expResult = false;
        boolean result = instance.actualizarSuscripcion(nickname, estado, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chequearLogin method, of class IUsuario.
     */
    @Test
    public void testChequearLogin() {
        System.out.println("chequearLogin");
        String nickname = "";
        String pass = "";
        IUsuario instance = new IUsuarioImpl();
        String expResult = "";
        String result = instance.chequearLogin(nickname, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
