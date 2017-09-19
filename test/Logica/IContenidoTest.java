/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class IContenidoTest {
    
    public IContenidoTest() {
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
     * Test of indicarCliente method, of class IContenido.
     */
    @Test
    public void testIndicarCliente() {
        System.out.println("indicarCliente");
        String nick = "";
        IContenido instance = new IContenidoImpl();
        instance.indicarCliente(nick);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarTema method, of class IContenido.
     */
    @Test
    public void testGuardarTema() {
        System.out.println("guardarTema");
        String nickArtista = "";
        String nomAlbum = "";
        String nomTema = "";
        IContenido instance = new IContenidoImpl();
        instance.guardarTema(nickArtista, nomAlbum, nomTema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarListaDefault method, of class IContenido.
     */
    @Test
    public void testGuardarListaDefault() {
        System.out.println("guardarListaDefault");
        String nomGenero = "";
        String nomLista = "";
        IContenido instance = new IContenidoImpl();
        instance.guardarListaDefault(nomGenero, nomLista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarListaParticular method, of class IContenido.
     */
    @Test
    public void testGuardarListaParticular() {
        System.out.println("guardarListaParticular");
        String nickCliente = "";
        String nomLista = "";
        IContenido instance = new IContenidoImpl();
        instance.guardarListaParticular(nickCliente, nomLista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarAlbum method, of class IContenido.
     */
    @Test
    public void testGuardarAlbum() {
        System.out.println("guardarAlbum");
        String nickArtista = "";
        String nomAlbum = "";
        IContenido instance = new IContenidoImpl();
        instance.guardarAlbum(nickArtista, nomAlbum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTema method, of class IContenido.
     */
    @Test
    public void testEliminarTema() {
        System.out.println("eliminarTema");
        int i = 0;
        IContenido instance = new IContenidoImpl();
        instance.eliminarTema(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarListaFavoritos method, of class IContenido.
     */
    @Test
    public void testEliminarListaFavoritos() {
        System.out.println("eliminarListaFavoritos");
        int i = 0;
        IContenido instance = new IContenidoImpl();
        instance.eliminarListaFavoritos(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAlbum method, of class IContenido.
     */
    @Test
    public void testEliminarAlbum() {
        System.out.println("eliminarAlbum");
        int i = 0;
        IContenido instance = new IContenidoImpl();
        instance.eliminarAlbum(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectArtista method, of class IContenido.
     */
    @Test
    public void testSelectArtista() {
        System.out.println("selectArtista");
        String nick = "";
        IContenido instance = new IContenidoImpl();
        boolean expResult = false;
        boolean result = instance.selectArtista(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarGenero method, of class IContenido.
     */
    @Test
    public void testListarGenero() {
        System.out.println("listarGenero");
        IContenido instance = new IContenidoImpl();
        DtGenero expResult = null;
        DtGenero result = instance.listarGenero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarAlbumesGenero method, of class IContenido.
     */
    @Test
    public void testListarAlbumesGenero() {
        System.out.println("listarAlbumesGenero");
        String nombre = "";
        IContenido instance = new IContenidoImpl();
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.listarAlbumesGenero(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearListaReproduccion method, of class IContenido.
     */
    @Test
    public void testCrearListaReproduccion() {
        System.out.println("crearListaReproduccion");
        DtLista lista = null;
        String nickCliente = "";
        IContenido instance = new IContenidoImpl();
        boolean expResult = false;
        boolean result = instance.crearListaReproduccion(lista, nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarAlbum method, of class IContenido.
     */
    @Test
    public void testIngresarAlbum() {
        System.out.println("ingresarAlbum");
        String nom = "";
        int anio = 0;
        ArrayList<String> generos = null;
        String img = "";
        ArrayList<DtTema> temas = null;
        IContenido instance = new IContenidoImpl();
        instance.ingresarAlbum(nom, anio, generos, img, temas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecListaDef method, of class IContenido.
     */
    @Test
    public void testSelecListaDef() {
        System.out.println("selecListaDef");
        String nombre = "";
        IContenido instance = new IContenidoImpl();
        List<DtTema> expResult = null;
        List<DtTema> result = instance.selecListaDef(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitarTema method, of class IContenido.
     */
    @Test
    public void testQuitarTema() {
        System.out.println("quitarTema");
        String nombreT = "";
        String nombre = "";
        String nombreUser = "";
        IContenido instance = new IContenidoImpl();
        boolean expResult = false;
        boolean result = instance.quitarTema(nombreT, nombre, nombreUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecLista method, of class IContenido.
     */
    @Test
    public void testSelecLista() {
        System.out.println("selecLista");
        String nick = "";
        String nomL = "";
        IContenido instance = new IContenidoImpl();
        List<DtTema> expResult = null;
        List<DtTema> result = instance.selecLista(nick, nomL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of publicarLista method, of class IContenido.
     */
    @Test
    public void testPublicarLista() {
        System.out.println("publicarLista");
        String nick = "";
        String nomL = "";
        IContenido instance = new IContenidoImpl();
        boolean expResult = false;
        boolean result = instance.publicarLista(nick, nomL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIUsuario method, of class IContenido.
     */
    @Test
    public void testSetIUsuario() {
        System.out.println("setIUsuario");
        IUsuario iUsuario = null;
        IContenido instance = new IContenidoImpl();
        instance.setIUsuario(iUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLisReproduccionGen method, of class IContenido.
     */
    @Test
    public void testListarLisReproduccionGen() {
        System.out.println("listarLisReproduccionGen");
        String nomGen = "";
        IContenido instance = new IContenidoImpl();
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarLisReproduccionGen(nomGen);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecListGen method, of class IContenido.
     */
    @Test
    public void testSelecListGen() {
        System.out.println("selecListGen");
        String nombreL = "";
        IContenido instance = new IContenidoImpl();
        DtLista expResult = null;
        DtLista result = instance.selecListGen(nombreL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAlbumContenido method, of class IContenido.
     */
    @Test
    public void testObtenerAlbumContenido() {
        System.out.println("obtenerAlbumContenido");
        String nomGenero = "";
        String nomAlbum = "";
        String nickArtista = "";
        IContenido instance = new IContenidoImpl();
        DtAlbumContenido expResult = null;
        DtAlbumContenido result = instance.obtenerAlbumContenido(nomGenero, nomAlbum, nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecGenero method, of class IContenido.
     */
    @Test
    public void testSelecGenero() {
        System.out.println("selecGenero");
        String nomGenero = "";
        IContenido instance = new IContenidoImpl();
        DtGenero expResult = null;
        DtGenero result = instance.selecGenero(nomGenero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarGenero method, of class IContenido.
     */
    @Test
    public void testCargarGenero() {
        System.out.println("cargarGenero");
        String nombre = "";
        String padre = "";
        IContenido instance = new IContenidoImpl();
        instance.cargarGenero(nombre, padre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeGenero method, of class IContenido.
     */
    @Test
    public void testExisteGenero() {
        System.out.println("existeGenero");
        String nombre = "";
        IContenido instance = new IContenidoImpl();
        boolean expResult = false;
        boolean result = instance.existeGenero(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerGenero method, of class IContenido.
     */
    @Test
    public void testObtenerGenero() {
        System.out.println("obtenerGenero");
        String nombre = "";
        IContenido instance = new IContenidoImpl();
        Genero expResult = null;
        Genero result = instance.obtenerGenero(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLisReproduccionDef method, of class IContenido.
     */
    @Test
    public void testListarLisReproduccionDef() {
        System.out.println("listarLisReproduccionDef");
        IContenido instance = new IContenidoImpl();
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarLisReproduccionDef();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarLista method, of class IContenido.
     */
    @Test
    public void testCargarLista() {
        System.out.println("cargarLista");
        ListaDefecto ld = null;
        String nombreGenero = "";
        IContenido instance = new IContenidoImpl();
        instance.cargarLista(ld, nombreGenero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarGenero method, of class IContenido.
     */
    @Test
    public void testIngresarGenero() {
        System.out.println("ingresarGenero");
        String nombre = "";
        String padre = "";
        IContenido instance = new IContenidoImpl();
        instance.ingresarGenero(nombre, padre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTemas method, of class IContenido.
     */
    @Test
    public void testListarTemas() {
        System.out.println("listarTemas");
        String NombreAlbum = "";
        String nickArtista = "";
        IContenido instance = new IContenidoImpl();
        HashMap<String, Tema> expResult = null;
        HashMap<String, Tema> result = instance.listarTemas(NombreAlbum, nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTemasLD method, of class IContenido.
     */
    @Test
    public void testListarTemasLD() {
        System.out.println("listarTemasLD");
        String nombreLista = "";
        IContenido instance = new IContenidoImpl();
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.listarTemasLD(nombreLista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTemasP method, of class IContenido.
     */
    @Test
    public void testListarTemasP() {
        System.out.println("listarTemasP");
        String nombreLista = "";
        String nickCliente = "";
        IContenido instance = new IContenidoImpl();
        ArrayList<DtTema> expResult = null;
        ArrayList<DtTema> result = instance.listarTemasP(nombreLista, nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarDeListasDefectoTema method, of class IContenido.
     */
    @Test
    public void testAgregarDeListasDefectoTema() {
        System.out.println("agregarDeListasDefectoTema");
        String nombreT = "";
        String nombreLista = "";
        String nombreUser = "";
        String listaDefecto = "";
        IContenido instance = new IContenidoImpl();
        boolean expResult = false;
        boolean result = instance.agregarDeListasDefectoTema(nombreT, nombreLista, nombreUser, listaDefecto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarDeListasParticularesTema method, of class IContenido.
     */
    @Test
    public void testAgregarDeListasParticularesTema() {
        System.out.println("agregarDeListasParticularesTema");
        String nombreT = "";
        String nombreLista = "";
        String nombreUser = "";
        String duenio = "";
        String listaDelduenio = "";
        IContenido instance = new IContenidoImpl();
        boolean expResult = false;
        boolean result = instance.agregarDeListasParticularesTema(nombreT, nombreLista, nombreUser, duenio, listaDelduenio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarDeAlbumTema method, of class IContenido.
     */
    @Test
    public void testAgregarDeAlbumTema() {
        System.out.println("agregarDeAlbumTema");
        String nombreT = "";
        String nombreLista = "";
        String nombreUser = "";
        String artista = "";
        String album = "";
        IContenido instance = new IContenidoImpl();
        boolean expResult = false;
        boolean result = instance.agregarDeAlbumTema(nombreT, nombreLista, nombreUser, artista, album);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IContenidoImpl implements IContenido {

        public void indicarCliente(String nick) {
        }

        public void guardarTema(String nickArtista, String nomAlbum, String nomTema) {
        }

        public void guardarListaDefault(String nomGenero, String nomLista) {
        }

        public void guardarListaParticular(String nickCliente, String nomLista) {
        }

        public void guardarAlbum(String nickArtista, String nomAlbum) {
        }

        public void eliminarTema(int i) {
        }

        public void eliminarListaFavoritos(int i) {
        }

        public void eliminarAlbum(int i) {
        }

        public boolean selectArtista(String nick) {
            return false;
        }

        public DtGenero listarGenero() {
            return null;
        }

        public ArrayList<DtAlbum> listarAlbumesGenero(String nombre) {
            return null;
        }

        public boolean crearListaReproduccion(DtLista lista, String nickCliente) {
            return false;
        }

        public void ingresarAlbum(String nom, int anio, ArrayList<String> generos, String img, ArrayList<DtTema> temas) {
        }

        public List<DtTema> selecListaDef(String nombre) {
            return null;
        }

        public boolean quitarTema(String nombreT, String nombre, String nombreUser) {
            return false;
        }

        public List<DtTema> selecLista(String nick, String nomL) {
            return null;
        }

        public boolean publicarLista(String nick, String nomL) {
            return false;
        }

        public void setIUsuario(IUsuario iUsuario) {
        }

        public ArrayList<DtLista> listarLisReproduccionGen(String nomGen) {
            return null;
        }

        public DtLista selecListGen(String nombreL) {
            return null;
        }

        public DtAlbumContenido obtenerAlbumContenido(String nomGenero, String nomAlbum, String nickArtista) {
            return null;
        }

        public DtGenero selecGenero(String nomGenero) {
            return null;
        }

        public void cargarGenero(String nombre, String padre) {
        }

        public boolean existeGenero(String nombre) {
            return false;
        }

        public Genero obtenerGenero(String nombre) {
            return null;
        }

        public ArrayList<DtLista> listarLisReproduccionDef() {
            return null;
        }

        public void cargarLista(ListaDefecto ld, String nombreGenero) {
        }

        public void ingresarGenero(String nombre, String padre) {
        }

        public HashMap<String, Tema> listarTemas(String NombreAlbum, String nickArtista) {
            return null;
        }

        public ArrayList<DtTema> listarTemasLD(String nombreLista) {
            return null;
        }

        public ArrayList<DtTema> listarTemasP(String nombreLista, String nickCliente) {
            return null;
        }

        public boolean agregarDeListasDefectoTema(String nombreT, String nombreLista, String nombreUser, String listaDefecto) {
            return false;
        }

        public boolean agregarDeListasParticularesTema(String nombreT, String nombreLista, String nombreUser, String duenio, String listaDelduenio) {
            return false;
        }

        public boolean agregarDeAlbumTema(String nombreT, String nombreLista, String nombreUser, String artista, String album) {
            return false;
        }

        @Override
        public void reiniciar() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
