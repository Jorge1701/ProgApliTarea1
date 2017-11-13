package Logica;

import Persistencia.BDAlbum;
import Persistencia.BDCliente;
import Persistencia.BDSuscripcion;
import Persistencia.BDUsuario;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ControladorUsuario implements IUsuario {

    private static ControladorUsuario instancia;

    public static void cargarInstancia() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        } else {
            instancia.reiniciar();
        }
    }

    public static ControladorUsuario getInstance() {
        if (instancia == null) {
            cargarInstancia();
        }
        return instancia;
    }

    private HashMap<String, Usuario> usuarios;
    private Usuario usuarioRecordado;

    private BDUsuario bdUsuario = null;

    private IContenido iContenido;

    public void reiniciar() {
        this.usuarios = new HashMap();
        this.usuarioRecordado = null;
        this.bdUsuario = new BDUsuario();

        iContenido = null;
    }

    public void setIContenido(IContenido iContenido) {
        this.iContenido = iContenido;
    }

    private ControladorUsuario() {
        this.usuarios = new HashMap();
        this.usuarioRecordado = null;
        this.bdUsuario = new BDUsuario();
    }

    @Override
    public void desactivar(String nickname) {
        Usuario us = usuarios.get(nickname);

        if (us == null) {
            throw new UnsupportedOperationException("El artista " + nickname + " no existe");
        }

        if (!(us instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario no es un Artista");
        }

        if (new BDUsuario().desactivarArtista(nickname)) {
            ((Artista) us).desactivar();
        }
    }

    @Override
    public Usuario soloDesdeFabricaObtenerUsuario(String nick) {
        return usuarios.get(nick);
    }

    @Override
    public Usuario obtenerUsuario(String nick) {
        Usuario u = usuarios.get(nick);

        if (u instanceof Artista) {
            if (!((Artista) u).estaActivo()) {
                return null;
            }
        }

        return u;
    }

    @Override
    public Artista selectArtista(String nick) {
        Usuario us = usuarios.get(nick);

        if (us == null) {
            throw new UnsupportedOperationException("El artista " + nick + " no existe");
        }

        if (!(us instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario no es un Artista");
        }

        if (us instanceof Artista) {
            if (!((Artista) us).estaActivo()) {
                return null;
            }
        }

        return (Artista) us;
    }

    @Override
    public boolean ingresarUsuario(DtUsuario dtu) {
        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();

            if (u.getNickname().equals(dtu.getNickname()) || u.getEmail().equals(dtu.getEmail())) {
                return false;
            }
        }

        Usuario usr;

        if (this.bdUsuario.ingresarUsuario(dtu)) {

            if (dtu instanceof DtCliente) {
                usr = new Cliente(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), new DtFecha(dtu.getFechaNac().getDia(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getAnio()), dtu.getImagen(), dtu.getContrasenia());
            } else {
                usr = new Artista(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), new DtFecha(dtu.getFechaNac().getDia(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getAnio()), dtu.getImagen(), dtu.getContrasenia(), ((DtArtista) dtu).getBiografia(), ((DtArtista) dtu).getWeb(), ((DtArtista) dtu).estaActivo());
            }
            this.usuarios.put(usr.getNickname(), usr);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void levantarUsuario(DtUsuario dtu) {
        Usuario u;
        if (dtu instanceof DtCliente) {
            u = new Cliente(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), new DtFecha(dtu.getFechaNac().getDia(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getAnio()), dtu.getImagen(), dtu.getContrasenia());
        } else {
            u = new Artista(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), new DtFecha(dtu.getFechaNac().getDia(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getAnio()), dtu.getImagen(), dtu.getContrasenia(), ((DtArtista) dtu).getBiografia(), ((DtArtista) dtu).getWeb(), ((DtArtista) dtu).estaActivo());
        }
        usuarios.put(u.getNickname(), u);
    }

    @Override
    public ArrayList<DtUsuario> listarUsuarios() {
        ArrayList<DtUsuario> dtUsuarios = new ArrayList<>();

        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();

            boolean artDes = false;

            if (u instanceof Artista) {
                if (!((Artista) u).estaActivo()) {
                    artDes = true;
                }
            }

            if (!artDes) {
                dtUsuarios.add(u.getData());
            }
        }

        return dtUsuarios;
    }

    @Override
    public ArrayList<DtUsuario> listarClientes() {
        ArrayList<DtUsuario> clientes = new ArrayList<>();

        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();

            if (u instanceof Cliente) {
                clientes.add(u.getData());
            }
        }

        return clientes;
    }

    public ArrayList<DtListaParticular> obtenerPublicas() {

        ArrayList<DtListaParticular> p = new ArrayList<>();
        ArrayList<DtListaParticular> resultado = new ArrayList<>();
        Iterator i = usuarios.entrySet().iterator();

        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();
            if (u instanceof Cliente) {
                DtPerfilCliente cliente = (DtPerfilCliente) u.obtenerPerfil();
                p = cliente.getListasCreadas();
                for (int j = 0; j < p.size(); j++) {
                    resultado.add(p.get(j));
                }
            }
        }
        return resultado;

    }

    @Override
    public ArrayList<DtUsuario> listarArtistas() {
        ArrayList<DtUsuario> artistas = new ArrayList<>();

        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();

            if (u instanceof Artista) {
                if (((Artista) u).estaActivo()) {
                    artistas.add(u.getData());
                }
            }
        }

        return artistas;
    }

    @Override
    public DtPerfilUsuario obtenerPerfilArtista(String nickArtista) {
        Usuario u = usuarios.get(nickArtista);

        if (u == null) {
            throw new UnsupportedOperationException("El Artista " + nickArtista + " no existe");
        }

        if (!(u instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario no es un artista");
        }

        if (u instanceof Artista) {
            if (!((Artista) u).estaActivo()) {
                throw new UnsupportedOperationException("El Artista " + nickArtista + " no existe");
            }
        }

        return ((Artista) u).obtenerPerfil();
    }

    @Override
    public DtPerfilUsuario obtenerPerfilCliente(String nickCliente) {
        Usuario u = usuarios.get(nickCliente);

        if (u == null) {
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no existe");
        }

        if (!(u instanceof Cliente)) {
            throw new UnsupportedOperationException("Este usuario no es un cliente");
        }

        return ((Cliente) u).obtenerPerfil();

    }

    @Override
    public void reproducirTema(String nickArtista, String nomAlbum, String nomTema) {
        Usuario u = usuarios.get(nickArtista);

        if (u == null) {
            throw new UnsupportedOperationException("El artista " + nickArtista + " no existe");
        }

        if (!(u instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario no es un artista");
        }

        if (!((Artista) u).estaActivo()) {
            throw new UnsupportedOperationException("Este artista no esta activo");
        }

        if (new BDAlbum().reproducirTema(nickArtista, nomAlbum, nomTema)) {
            ((Artista) u).getAlbum(nomAlbum).getTema(nomTema).reproducir();
        }
    }

    @Override
    public void descargaTema(String nickArtista, String nomAlbum, String nomTema) {
        Usuario u = usuarios.get(nickArtista);

        if (u == null) {
            throw new UnsupportedOperationException("El artista " + nickArtista + " no existe");
        }

        if (!(u instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario no es un artista");
        }

        if (!((Artista) u).estaActivo()) {
            throw new UnsupportedOperationException("Este artista no esta activo");
        }

        if (new BDAlbum().descargaTema(nickArtista, nomAlbum, nomTema)) {
            ((TemaLocal) (((Artista) u).getAlbum(nomAlbum).getTema(nomTema))).descarga();
        }
    }

    @Override
    public DtUsuario getDataUsuario(String nickUsuario) {
        Usuario user = usuarios.get(nickUsuario);

        if (user instanceof Artista) {
            if (!((Artista) user).estaActivo()) {
                return null;
            }
        }

        if (user != null) {
            return user.getData();
        } else {
            return null;
        }
    }

    @Override
    public DtCliente getDataCliente(String nickname) {
        Usuario usuario = usuarios.get(nickname);
        if (usuario instanceof Cliente) {
            return ((Cliente) usuario).getData();
        } else {
            return null;
        }
    }

    @Override
    public void seguirUsuario(String nickCliente, String nickSeguido) {
        Usuario cliente = usuarios.get(nickCliente);
        Usuario seguido = usuarios.get(nickSeguido);

        BDUsuario bdu = new BDUsuario();
        if (!((Cliente) cliente).agregar(seguido)) {
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no pudo seguir al usuario " + nickSeguido);
        }
        if (!bdu.seguirUsuario(nickCliente, nickSeguido)) {
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no pudo seguir al usuario " + nickSeguido);
        }
    }

    @Override
    public void dejarSeguirUsuario(String nickSeguidor, String nickUsuario) {
        Usuario seguidor = usuarios.get(nickSeguidor);
        Usuario usuario = usuarios.get(nickUsuario);

        if (seguidor == null) {
            throw new UnsupportedOperationException("Cliente seguidor no existe");
        }

        BDUsuario bdu = new BDUsuario();
        if (!bdu.dejarDeSeguir(nickSeguidor, nickUsuario)) {
            throw new UnsupportedOperationException("El cliente " + nickSeguidor + " no pudo dejar de seguir al usuario " + nickUsuario);
        }
        if (!((Cliente) seguidor).dejarSeguir(usuario)) {
            throw new UnsupportedOperationException("El cliente " + nickSeguidor + " no pudo dejar de seguir al usuario " + nickUsuario);
        }
    }

    @Override
    public ArrayList<DtAlbum> listarAlbumesArtista(String nickArtista) {
        Usuario usuario = usuarios.get(nickArtista);
        if (usuario == null) {
            throw new UnsupportedOperationException("Artista no existe");
        }
        if (!(usuario instanceof Artista)) {
            throw new UnsupportedOperationException("Usuario no es un artista");
        }

        if (usuario instanceof Artista) {
            if (!((Artista) usuario).estaActivo()) {
                throw new UnsupportedOperationException("Artista no existe");
            }
        }

        return ((Artista) usuario).obtenerAlbumes();
    }

    @Override
    public DtAlbumContenido obtenerAlbumContenido(String nickArtista, String nomAlbum) {
        Usuario usuario = usuarios.get(nickArtista);
        if (usuario == null) {
            throw new UnsupportedOperationException("Artista no existe");
        }
        if (!(usuario instanceof Artista)) {
            throw new UnsupportedOperationException("Usuario no es un artista");
        }

        if (usuario instanceof Artista) {
            if (!((Artista) usuario).estaActivo()) {
                throw new UnsupportedOperationException("Artista no existe");
            }
        }

        DtAlbumContenido dt = ((Artista) usuario).obtenerAlbumContenido(nomAlbum);
        if (dt == null) {
            throw new UnsupportedOperationException("Album no existe");
        }

        return dt;
    }

    public Usuario getUsuario(String nick) {

        Usuario us = usuarios.get(nick);

        if (us == null) {
            throw new UnsupportedOperationException("El usuario " + nick + " no existe");
        } else {
            return us;
        }

    }

    @Override
    public ArrayList<DtUsuario> listarSeguidosDe(String nickCliente) {
        Cliente c = (Cliente) usuarios.get(nickCliente);
        return c.obtenerSeguidos();
    }

    @Override
    public ArrayList<DtCliente> listarSeguidoresDe(String nickUsuario) {
        Usuario u = usuarios.get(nickUsuario);

        if (u == null) {
            throw new UnsupportedOperationException("El cliente no existe");
        }

        return u.getSeguidores();
    }

    @Override
    public ArrayList<DtLista> listarListaReproduccionCli(String nickCliente) {
        Usuario c = this.usuarios.get(nickCliente);
        if (c == null) {
            throw new UnsupportedOperationException("No existe el Cliente");
        }
        if (!(c instanceof Cliente)) {
            throw new UnsupportedOperationException("Usuario no es un cliente");
        }

        this.usuarioRecordado = c;

        return ((Cliente) c).listarLisReproduccion();
    }

    @Override
    public DtLista selectListaCli(String nombreL) {
        return ((Cliente) this.usuarioRecordado).seleccionarLista(nombreL);
    }

    @Override
    public ArrayList<DtLista> listarLisReproduccion(String nickCliente) {
        return ((Cliente) obtenerUsuario(nickCliente)).listarLisReproduccion();
    }

    @Override
    public void agregarAlbumFav(String nickCliente, String nickArtista, String nomAlbum) {
        int i = ((Cliente) usuarios.get(nickCliente)).agregarAlbumFav(((Artista) usuarios.get(nickArtista)).getAlbum(nomAlbum));

        BDCliente bdc = new BDCliente();
        if (!bdc.agregarAlbumFav(nickArtista, nomAlbum, nickCliente)) {
            ((Cliente) usuarios.get(nickCliente)).eliminarAlbumFav(i);
            throw new UnsupportedOperationException("Error en la BD");
        }
    }

    @Override
    public void agregarLPFav(String nickCliente, String nickClienteDuenio, String nomLista) {
        int i = ((Cliente) usuarios.get(nickCliente)).agregarListaFav(((Cliente) usuarios.get(nickClienteDuenio)).getLista(nomLista));

        BDCliente bdc = new BDCliente();
        if (!bdc.agregarListaParticularFav(nickClienteDuenio, nomLista, nickCliente)) {
            ((Cliente) usuarios.get(nickCliente)).eliminarListaFav(i);
            throw new UnsupportedOperationException("Error en la BD");
        }
    }

    @Override
    public void agregarLDFav(String nickCliente, String nomGenero, String nomLista) {
        int i = ((Cliente) usuarios.get(nickCliente)).agregarListaFav(iContenido.obtenerGenero(nomGenero).getListaDefecto(nomLista));

        BDCliente bdc = new BDCliente();
        if (!bdc.agregarListaDefaultFav(nomGenero, nomLista, nickCliente)) {
            ((Cliente) usuarios.get(nickCliente)).eliminarListaFav(i);
            throw new UnsupportedOperationException("Error en la BD");
        }
    }

    @Override
    public void agregarTemaFav(String nickCliente, String nickArtista, String nomAlbum, String nomTema) {
        int i = ((Cliente) usuarios.get(nickCliente)).agregarTemaFav(((Artista) usuarios.get(nickArtista)).getAlbum(nomAlbum).getTema(nomTema));

        BDCliente bdc = new BDCliente();
        if (!bdc.agregarTemaFav(nickArtista, nomAlbum, nomTema, nickCliente)) {
            ((Cliente) usuarios.get(nickCliente)).eliminarTemaFav(i);
            throw new UnsupportedOperationException("Error en la BD");
        }
    }

    // ===================================
    @Override
    public void quitarAlbumFav(String nickCliente, String nickArtista, String nomAlbum) {
        ((Cliente) usuarios.get(nickCliente)).eliminarAlbumFav(nickArtista, nomAlbum);

        BDCliente bdc = new BDCliente();
        if (!bdc.eliminarAlbumFav(nickArtista, nomAlbum, nickCliente)) {
            throw new UnsupportedOperationException("Error en la BD");
        }
    }

    @Override
    public void quitarLPFav(String nickCliente, String nickClienteDuenio, String nomLista) {
        ((Cliente) usuarios.get(nickCliente)).eliminarLPFav(nickClienteDuenio, nomLista);

        BDCliente bdc = new BDCliente();
        if (!bdc.eliminarListaParticularFav(nickClienteDuenio, nomLista, nickCliente)) {
            throw new UnsupportedOperationException("Error en la BD");
        }
    }

    @Override
    public void quitarLDFav(String nickCliente, String nomGenero, String nomLista) {
        ((Cliente) usuarios.get(nickCliente)).eliminarLDFav(nomGenero, nomLista);

        BDCliente bdc = new BDCliente();
        if (!bdc.eliminarListaPorDefectoFav(nomGenero, nomLista, nickCliente)) {
            throw new UnsupportedOperationException("Error en la BD");
        }
    }

    @Override
    public void quitarTemaFav(String nickCliente, String nickArtista, String nomAlbum, String nomTema) {
        ((Cliente) usuarios.get(nickCliente)).eliminarTemaFav(nickArtista, nomAlbum, nomTema);

        BDCliente bdc = new BDCliente();
        if (!bdc.eliminarTemaFav(nickArtista, nomAlbum, nomTema, nickCliente)) {
            throw new UnsupportedOperationException("Error en la BD");
        }
    }
    // ===================================

    @Override
    public void eliminarAlbumFav(String nickCliente, int i) {
        DtAlbum dta = ((Cliente) usuarios.get(nickCliente)).obtenerDtAlbumesFav().get(i);

        BDCliente bdc = new BDCliente();
        if (!bdc.eliminarAlbumFav(dta.getNickArtista(), dta.getNombre(), nickCliente)) {
            throw new UnsupportedOperationException("Error en la BD");
        }

        ((Cliente) usuarios.get(nickCliente)).eliminarAlbumFav(i);
    }

    @Override
    public void eliminarListaFav(String nickCliente, int i) {
        Lista l = ((Cliente) usuarios.get(nickCliente)).obtenerListasFav().get(i);

        BDCliente bdc = new BDCliente();
        if (l instanceof ListaParticular) {
            if (!bdc.eliminarListaParticularFav(((ListaParticular) l).getDuenio(), l.getNombre(), nickCliente)) {
                throw new UnsupportedOperationException("Error en la BD");
            }
        } else if (l instanceof ListaDefecto) {
            if (!bdc.eliminarListaPorDefectoFav(((ListaDefecto) l).getGenero().getNombre(), l.getNombre(), nickCliente)) {
                throw new UnsupportedOperationException("Error en la BD");
            }
        }

        ((Cliente) usuarios.get(nickCliente)).eliminarListaFav(i);
    }

    @Override
    public void eliminarTemaFav(String nickCliente, int i) {
        Tema t = ((Cliente) usuarios.get(nickCliente)).obtenerTemasFav().get(i);

        BDCliente bdc = new BDCliente();
        if (!bdc.eliminarTemaFav(t.getAlbum().getNickArtista(), t.getAlbum().getNombre(), t.getNombre(), nickCliente)) {
            throw new UnsupportedOperationException("Error en la BD");
        }
        ((Cliente) usuarios.get(nickCliente)).eliminarTemaFav(i);
    }

    @Override
    public ArrayList<DtAlbum> obtenerAlbumesFav(String nickCliente) {
        return ((Cliente) usuarios.get(nickCliente)).obtenerDtAlbumesFav();
    }

    @Override
    public ArrayList<DtLista> obtenerListasFav(String nickCliente) {
        return ((Cliente) usuarios.get(nickCliente)).obtenerDtListasFav();
    }

    @Override
    public ArrayList<DtTema> obtenerTemasFav(String nickCliente) {
        return ((Cliente) usuarios.get(nickCliente)).obtenerDtTemasFav();
    }

    @Override
    public void cargarAlbum(Album a) {
        Usuario u = usuarios.get(a.getNickArtista());
        ((Artista) u).cargarAlbum(a);
    }

    @Override
    public void cargarLista(ListaParticular lp, String nickcliente) {

        ((Cliente) usuarios.get(nickcliente)).cargarLista(lp);
    }

    public Tema getTema(String nombreCliente, String nombreTema) {
        Cliente c = (Cliente) this.obtenerUsuario(nombreCliente);
        Iterator i = c.getListasParticulares().entrySet().iterator();
        while (i.hasNext()) {
            Tema tema = (Tema) ((Map.Entry) i.next()).getValue();
            if (tema.getNombre().equals(nombreTema)) {
                return tema;
            }

        }
        return null;

    }

    @Override
    public boolean correoExiste(String correo) {
        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();

            if (u.getEmail().equals(correo)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean nicknameExiste(String nickname) {
        Usuario u = usuarios.get(nickname);

        if (u == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean esCliente(String nickname) {
        Usuario usuario = usuarios.get(nickname);
        if (usuario instanceof Cliente) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String chequearLogin(String nickname, String pass) {
        if (nickname.contains("@")) {
            Iterator i = usuarios.entrySet().iterator();
            while (i.hasNext()) {
                Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();

                if (u instanceof Artista) {
                    if (!((Artista) u).estaActivo()) {
                        continue;
                    }
                }

                if (u.getEmail().equals(nickname)) {
                    if (u.getContrasenia().equals(pass)) {
                        return u.getNickname();
                    } else {
                        return "Error: Contraseña invalida";
                    }
                }
            }
            return "Error: Correo no existe";
        } else {
            Usuario u = obtenerUsuario(nickname);

            if (u == null) {
                return "Error: Nickname invalido";
            } else if (u.getContrasenia().equals(pass)) {
                return u.getNickname();
            } else {
                return "Error: Contraseña invalida";
            }
        }
    }

    @Override
    public boolean actualizarSuscripcion(String nickname, String estado, DtFecha fecha) {

        Usuario usr = usuarios.get(nickname);
        BDSuscripcion bds = new BDSuscripcion();

        Suscripcion sus = ((Cliente) usr).getSuscripcion();

        if (estado.equals("Cancelada")) {

            if (!bds.actulizarSuscripcion(nickname, sus.getData(), "Cancelada", fecha, null)) {
                return false;
            }

            sus.setEstado(estado);
            sus.setFecha(fecha);
            ((Cliente) usr).cancelarSuscripcion(sus);
            return true;

        } else {

            Calendar c = new GregorianCalendar(fecha.getAnio(), fecha.getMes(), fecha.getDia());

            if (sus.getCuota().equals("Semanal")) {

                c.add(Calendar.DATE, 7);
                DtFecha fecha_venc = new DtFecha(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));

                if (!bds.actulizarSuscripcion(nickname, sus.getData(), "Vigente", fecha, fecha_venc)) {
                    return false;
                }

                sus.setFecha(fecha);
                sus.setFecha_venc(fecha_venc);
                sus.setEstado(estado);
                return true;

            } else if (sus.getCuota().equals("Mensual")) {

                c.add(Calendar.MONTH, 1);
                DtFecha fecha_venc = new DtFecha(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));

                if (!bds.actulizarSuscripcion(nickname, sus.getData(), "Vigente", fecha, fecha_venc)) {
                    return false;
                }

                sus.setFecha(fecha);
                sus.setFecha_venc(fecha_venc);
                sus.setEstado(estado);
                return true;
            } else {

                c.add(Calendar.YEAR, 1);
                DtFecha fecha_venc = new DtFecha(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));

                if (!bds.actulizarSuscripcion(nickname, sus.getData(), "Vigente", fecha, fecha_venc)) {
                    return false;
                }

                sus.setFecha(fecha);
                sus.setFecha_venc(fecha_venc);
                sus.setEstado(estado);
                return true;
            }

        }

    }

    @Override
    public int getMonto(String cuota) {
        BDSuscripcion bds = new BDSuscripcion();
        int monto = bds.getMonto(cuota);
        return monto;
    }

    @Override
    public boolean ingresarSuscripcion(String nickname, String cuota) {
        BDSuscripcion bds = new BDSuscripcion();
        Calendar c = new GregorianCalendar();
        DtFecha fecha = new DtFecha(c.get(Calendar.DATE), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR));
        Usuario usr = usuarios.get(nickname);
        int monto = bds.getMonto(cuota);
        ((Cliente) usr).cargarSuscripcion(new Suscripcion("Pendiente", cuota, null, fecha, monto));
        if (!bds.ingresarSuscripcion(nickname, cuota, null, fecha, "Pendiente")) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean chequearSuscripcion(String nickname) {

        Usuario usr = usuarios.get(nickname);
        Suscripcion sus = ((Cliente) usr).getSuscripcion();
        BDSuscripcion bds = new BDSuscripcion();

        if (sus != null) {

            if (sus.getEstado().equals("Vigente")) {

                Calendar hoy = new GregorianCalendar();

                if (hoy.get(Calendar.YEAR) == sus.getFechaVenc().getAnio() && (hoy.get(Calendar.MONTH) + 1) == sus.getFechaVenc().getMes() && hoy.get(Calendar.DAY_OF_MONTH) == sus.getFechaVenc().getDia()) {

                    return true;

                } else if (hoy.get(Calendar.YEAR) == sus.getFechaVenc().getAnio() && (hoy.get(Calendar.MONTH) + 1) == sus.getFechaVenc().getMes() && hoy.get(Calendar.DAY_OF_MONTH) > sus.getFechaVenc().getDia()) {

                    if (bds.expirarSuscripcion(nickname, sus.getData())) {
                        sus.setEstado("Vencida");
                        ((Cliente) usr).cancelarSuscripcion(sus);
                        return false;
                    } else {
                        return false;
                    }

                } else if (hoy.get(Calendar.YEAR) == sus.getFechaVenc().getAnio() && (hoy.get(Calendar.MONTH) + 1) > sus.getFechaVenc().getMes()) {

                    if (bds.expirarSuscripcion(nickname, sus.getData())) {
                        sus.setEstado("Vencida");
                        ((Cliente) usr).cancelarSuscripcion(sus);
                        return false;
                    } else {
                        return false;
                    }

                } else if (hoy.get(Calendar.YEAR) > sus.getFechaVenc().getAnio()) {

                    if (bds.expirarSuscripcion(nickname, sus.getData())) {
                        sus.setEstado("Vencida");
                        ((Cliente) usr).cancelarSuscripcion(sus);
                        return false;
                    } else {
                        return false;
                    }
                }

            }

            return false;

        }
        return false;
    }

    @Override
    public boolean renovarSuscripcion(String nickname, String estado, String cuota, String fecha, String fecha_venc, DtFecha cambio) {
        BDSuscripcion bds = new BDSuscripcion();
        Usuario usr = usuarios.get(nickname);

        if (((Cliente) usr).getSuscripcion() != null) {
            return false;
        }

        ArrayList<Suscripcion> sus = ((Cliente) usr).getSuscripciones();
        Suscripcion suscripcion = null;
        String[] arreglo = fecha.split("/");
        String[] arreglo2 = fecha_venc.split("/");
        DtFecha fecha1 = new DtFecha(Integer.parseInt(arreglo[0]), Integer.parseInt(arreglo[1]), Integer.parseInt(arreglo[2]));
        DtFecha fecha_venc1 = new DtFecha(Integer.parseInt(arreglo2[0]), Integer.parseInt(arreglo2[1]), Integer.parseInt(arreglo2[2]));;
        DtFecha fechaf = null;

        for (Suscripcion s : sus) {

            if (s.getEstado().equals(estado) && s.getCuota().equals(cuota) && s.getFecha().getAnio() == fecha1.getAnio() && s.getFecha().getMes() == fecha1.getMes() && s.getFecha().getDia() == fecha1.getDia() && s.getFechaVenc().getAnio() == fecha_venc1.getAnio() && s.getFechaVenc().getMes() == fecha_venc1.getMes() && s.getFechaVenc().getDia() == fecha_venc1.getDia()) {
                suscripcion = s;
            }

        }

        if (suscripcion != null) {

            Calendar c = new GregorianCalendar(cambio.getAnio(), cambio.getMes(), cambio.getDia());

            if (suscripcion.getCuota().equals("Semanal")) {

                c.add(Calendar.DATE, 7);
                fechaf = new DtFecha(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));

                if (!bds.renovarSuscripcion(suscripcion.getData(), nickname, cambio, fechaf)) {
                    return false;
                }
                ((Cliente) usr).renovarSuscripcion(suscripcion);
                suscripcion.setFecha(cambio);
                suscripcion.setFecha_venc(fechaf);
                suscripcion.setEstado("Vigente");
                return true;

            } else if (suscripcion.getCuota().equals("Mensual")) {

                
                if (c.get(Calendar.MONTH) == 0) {
                    fechaf = new DtFecha(c.get(Calendar.DAY_OF_MONTH), 1, c.get(Calendar.YEAR));
                } else if (c.get(Calendar.MONTH) == 11) {
                    fechaf = new DtFecha(c.get(Calendar.DAY_OF_MONTH), 12, c.get(Calendar.YEAR));
                } else {
                    c.add(Calendar.MONTH, 1);
                    fechaf = new DtFecha(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
                }

                if (!bds.renovarSuscripcion(suscripcion.getData(), nickname, cambio, fechaf)) {
                    return false;
                }
                ((Cliente) usr).renovarSuscripcion(suscripcion);
                suscripcion.setFecha(cambio);
                suscripcion.setFecha_venc(fechaf);
                suscripcion.setEstado("Vigente");
                return true;
            } else {

                c.add(Calendar.YEAR, 1);
                fechaf = new DtFecha(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));

                if (!bds.renovarSuscripcion(suscripcion.getData(), nickname, cambio, fechaf)) {
                    return false;
                }
                ((Cliente) usr).renovarSuscripcion(suscripcion);
                suscripcion.setFecha(cambio);
                suscripcion.setFecha_venc(fechaf);
                suscripcion.setEstado("Vigente");
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean cancelarSuscripcion(String nickname, String previo, String cuota, String fecha, String fecha_venc, DtFecha hoy) {

        BDSuscripcion bds = new BDSuscripcion();
        Usuario u = usuarios.get(nickname);
        Suscripcion s = ((Cliente) u).getSuscripcion();

        if (previo.equals("Pendiente")) {

            if (!bds.cancelarSuscripcion(s.getData(), nickname, hoy)) {
                return false;
            }

            s.setEstado("Cancelada");
            s.setFecha(hoy);
            ((Cliente) u).cancelarSuscripcion(s);
            return true;
        } else {

            ArrayList<Suscripcion> sus = ((Cliente) u).getSuscripciones();
            Suscripcion v = null;
            String[] arreglo = fecha.split("/");
            String[] arreglo2 = fecha_venc.split("/");
            DtFecha f = new DtFecha(Integer.parseInt(arreglo[0]), Integer.parseInt(arreglo[1]), Integer.parseInt(arreglo[2]));
            DtFecha fv = new DtFecha(Integer.parseInt(arreglo2[0]), Integer.parseInt(arreglo2[1]), Integer.parseInt(arreglo2[2]));
            for (Suscripcion ss : sus) {
                if (ss.getEstado().equals(previo) && ss.getCuota().equals(cuota) && ss.getFecha().getAnio() == f.getAnio() && ss.getFecha().getMes() == f.getMes() && ss.getFecha().getDia() == f.getDia() && ss.getFechaVenc().getAnio() == fv.getAnio() && ss.getFechaVenc().getMes() == fv.getMes() && ss.getFechaVenc().getDia() == fv.getDia()) {
                    v = ss;
                }
            }

            if (!bds.cancelarSuscripcion(v.getData(), nickname, hoy)) {
                return false;
            }
            v.setEstado("Cancelada");
            v.setFecha(hoy);
            return true;
        }
    }

    @Override
    public DtListaRanking obtenerRanking() {
        ArrayList<DtUsuario> usuarios = listarUsuarios();

        ArrayList<DtRanking> resultado = new ArrayList<>();

        for (DtUsuario usr : usuarios) {
            if (usr instanceof DtArtista) {
                if (!((DtArtista) usr).estaActivo()) {
                    continue;
                }
            }

            resultado.add(new DtRanking(usr.getNombre() + " " + usr.getApellido(), usr.getNickname(), obtenerUsuario(usr.getNickname()).getSeguidores().size()));
        }

        ordenarRanking(resultado);
        return new DtListaRanking(resultado);
    }

    private ArrayList<DtRanking> ordenarRanking(ArrayList<DtRanking> usuarios) {
        Collections.sort(usuarios, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                if (cantSeguidores(o1) == cantSeguidores(o2)) {
                    return 0;
                }
                return cantSeguidores(o1) > cantSeguidores(o2) ? -1 : 1;
            }
        });
        return usuarios;
    }

    private int cantSeguidores(Object o) {
        if (o instanceof DtRanking) {

            return ((DtRanking) o).getCantSeguidores();

        } else {
            return 0;
        }
    }

}
