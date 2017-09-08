package Persistencia;

import Logica.DtAlbum;
import Logica.DtArtista;
import Logica.DtCliente;
import Logica.DtFecha;
import Logica.DtGenero;
import Logica.DtLista;
import Logica.DtListaDefecto;
import Logica.DtListaParticular;
import Logica.DtTema;
import Logica.DtTemaLocal;
import Logica.DtTemaRemoto;
import Logica.DtTime;
import Logica.DtUsuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargaDatosPrueba {

    // Datos del DatosPrueba2017.doc del Drive...
    // Pefiles (Ref, Nickname, Correo, Nombre, Apellido, FechaNac, Tipo)
    private String[][] perfiles = {
        {"VP", "vpeople", "vpeople@tuta.io", "Village", "People", "1", "1", "1977", "A"},
        {"DM", "dmode", "dmode@tuta.io", "Depeche", "Mode", "14", "6", "1980", "A"},
        {"CL", "clauper", "clauper@hotmail.com", "Cyndi", "Lauper", "22", "6", "1953", "A"},
        {"BS", "bruceTheBoss", "bruceTheBoss@gmail.com", "Bruce", "Springsteen", "23", "9", "1949", "A"},
        {"TN", "tripleNelson", "tripleNelson@tuta.io", "La Triple", "Nelson", "1", "1", "1998", "A"},
        {"LL", "la_ley", "la_ley@tuta.io", "La", "Ley", "14", "2", "1987", "A"},
        {"TJ", "tigerOfWales", "tigerOfWales@tuta.io", "Tom", "Jones", "7", "6", "1940", "A"},
        {"PT", "chaiko", "chaiko@tuta.io", "Piotr", "Tchaikovsky", "25", "4", "1840", "A"},
        {"NN", "nicoleneu", "nicoleneu@hotmail.com", "Nicole", "Neumann", "31", "10", "1980", "A"},
        {"PI", "lospimpi", "lospimpi@gmail.com", "Pimpinela", "", "13", "8", "1981", "A"},
        {"DY", "dyangounchained", "dyangounchained@gmail.com", "Dyango", "", "5", "3", "1940", "A"},
        {"AL", "alcides", "alcides@tuta.io", "Alcides", "", "17", "7", "1952", "A"},
        {"VC", "el_padrino", "el_padrino@tuta.io", "Vito", "Corleone", "8", "3", "1972", "C"},
        {"SO", "scarlettO", "scarlettO@tuta.io", "Scarlett", "O’Hara", "27", "11", "1984", "C"},
        {"PA", "ppArgento", "ppArgento@hotmail.com", "Pepe", "Argento", "14", "2", "1955", "C"},
        {"WW", "Heisenberg", "Heisenberg@tuta.io", "Walter", "White", "7", "3", "1956", "C"},
        {"OK", "benKenobi", "benKenobi@gmail.com", "Obi-Wan", "Kenobi", "2", "4", "1914", "C"},
        {"ML", "lachiqui", "lachiqui@hotmail.com.ar", "Mirtha", "Legrand", "23", "2", "1927", "C"},
        {"CB", "cbochinche", "cbochinche@vera.com.uy", "Cacho", "Bochinche", "8", "5", "1937", "C"},
        {"EL", "Eleven11", "Eleven11@gmail.com", "Eleven", "", "31", "12", "1971", "C"}
    };

    // Datos Opcionales de Artistas (Ref, Imagen, Bio, Web)
    private String[][] infoArtistas = {
        {"VP", "vpeople.jpg", "Village People es una innovadora formación musical de estilo disco de finales de los años 70. Fue famosa tanto por sus peculiares disfraces, como por sus canciones pegadizas, con letras sugerentes y llenas de dobles sentidos.", "www.officialvillagepeople.com"},
        {"DM", "dmode.jpg", "", "www.depechemode.com"},
        {"CL", "clauper.png", "Cynthia Ann Stephanie Lauper, conocida simplemente como Cyndi Lauper, es una cantautora, actriz y empresaria estadounidense. Después de participaren el grupo musical, Blue Angel, en 1983 firmó con Portrait Records (filial de Epic Records) y lanzó su exitoso álbum debut \"She's So Unusual\" a finales de ese mismo año. Siguió lanzando una serie de álbumes en los que encontró una inmensa popularidad, superando los límites de contenido de las letras de sus canciones.", "cyndilauper.com"},
        {"BS", "bruceTheBoss.jpg", "", "brucespringsteen.net"},
        {"TJ", "", "Sir Thomas John, conocido por su nombre artístico de Tom Jones, es un cantante británico. Ha vendido más de 100 millones de discos en todo el mundo.1", "www.tomjones.com"},
        {"TN", "tripleNelson.jpg", "La Triple Nelson es un grupo de rock uruguayo formado en enero de 1998 e integrado inicialmente por Christian Cary (guitarra y voz), Fernando &quot;Paco&quot; Pintos (bajo y coros) y Rubén Otonello (actualmente su nuevo baterista es Rafael Ugo).", ""},
        {"LL", "", "", ""},
        {"PT", "", "Piotr Ilich Chaikovski fue un compositor ruso del período del Romanticismo", ""},
        {"NN", "nicoleneu.jpg", "", ""},
        {"PI", "lospimpi.jpg", "", "www.pimpinela.net"},
        {"DY", "", "José Gómez Romero, conocido artísticamente como Dyango es un cantante español de música romántica.", ""},
        {"AL", "", "Su carrera comienza en 1976 cuando forma la banda Los Playeros junto a su hermano Víctor. Al poco tiempo se mudan a San Luis donde comienzan a hacerse conocidos en la escena musical. Su éxito a nivel nacional llega a comienzos de los años 1990 cuando desembarca en Buenos Aires y graba el éxito \"Violeta\", originalmente compuesta e interpretada en 1985 por el músico brasileño Luiz Caldas bajo el título «Fricote».", ""}
    };

    // Datos Opcionales de Clientes (Ref, Imagen,)
    private String[][] infoClientes = {
        {"VC", "el_padrino.jpg"},
        {"SO", "scarlettO.jpg"},
        {"PA", "ppArgento.png"},
        {"WW", "Heisenberg.jpg"},
        {"OK", "benKenobi.png"},
        {"ML", "lachiqui.jpg"},
        {"CB", "cbochinche.jpg"},
        {"EL", "Eleven11.jpg"}
    };

    // Seguidores (Seguidor, Seguido)
    private String[][] seguidores = {
        {"VC", "VP"},
        {"VC", "DM"},
        {"VC", "CL"},
        {"VC", "OK"},
        {"VC", "ML"},
        {"VC", "CB"},
        {"VC", "EL"},
        {"SO", "DM"},
        {"SO", "BS"},
        {"SO", "TJ"},
        {"SO", "TN"},
        {"SO", "WW"},
        {"SO", "OK"},
        {"SO", "ML"},
        {"PA", "DM"},
        {"PA", "BS"},
        {"PA", "TN"},
        {"PA", "OK"},
        {"PA", "ML"},
        {"PA", "CB"},
        {"PA", "EL"},
        {"WW", "DM"},
        {"WW", "BS"},
        {"WW", "TJ"},
        {"WW", "TN"},
        {"WW", "PI"},
        {"WW", "DY"},
        {"WW", "AL"},
        {"WW", "VC"},
        {"WW", "SO"},
        {"WW", "PA"},
        {"WW", "OK"},
        {"WW", "ML"},
        {"WW", "EL"},
        {"OK", "DM"},
        {"OK", "BS"},
        {"OK", "LL"},
        {"OK", "PT"},
        {"OK", "NN"},
        {"OK", "PI"},
        {"OK", "AL"},
        {"OK", "VC"},
        {"OK", "PA"},
        {"OK", "ML"},
        {"OK", "CB"},
        {"OK", "EL"},
        {"ML", "BS"},
        {"ML", "LL"},
        {"ML", "PI"},
        {"ML", "AL"},
        {"ML", "VC"},
        {"ML", "SO"},
        {"ML", "PA"},
        {"CB", "LL"},
        {"CB", "PI"},
        {"CB", "DY"},
        {"CB", "AL"},
        {"CB", "PA"},
        {"EL", "LL"},
        {"EL", "VC"},
        {"EL", "SO"},
        {"EL", "PA"}
    };

    // Generos (Ref, Nombre, Padre)
    private String[][] generos = {
        {"ROK", "Rock", ""},
        {"RCL", "Rock Clasico", "ROK"},
        {"RKL", "Rock Latino", "ROK"},
        {"RAR", "Rock & Roll", "ROK"},
        {"CLA", "Clasica", ""},
        {"DIS", "Disco", ""},
        {"POP", "Pop", ""},
        {"EPO", "Electropop", "POP"},
        {"DPO", "Dance-pop", "POP"},
        {"PCL", "Pop Clasico", "POP"},
        {"BAL", "Balada", ""},
        {"CUM", "Cumbia", ""}
    };

    // Albumes (Ref artista, Ref album, Nombre, Generos, Anio, Imagen)
    private String[][] albumes = {
        {"VP", "VPL", "Village People Live and Sleazy", "DIS,DPO,PCL", "1980", ""},
        {"DM", "DMV", "Violator", "EPO", "1990", ""},
        {"CL", "CLU", "She’s So Unusual", "PCL,DPO", "1983", "She’s So Unusual.PNG"},
        {"BS", "USA", "Born In The U.S.A.", "RCL,RAR,PCL", "1984", ""},
        {"TJ", "INU", "It’s Not Unusual", "RCL,PCL", "1965", "It’s Not Unusual.jpeg"},
        {"TN", "AYS", "Agua Y Sal", "RKL", "2012", ""},
        {"LL", "LLU", "MTV Unplugged", "RKL,PCL", "2001", "MTV Unplugged.jpg"},
        {"PT", "LDC", "El Lago De Los Cisnes", "CLA", "1875", ""},
        {"PT", "CPP", "Concierto Para Piano No. 1 En Si Menor, Opus 23", "CLA", "1875", ""},
        {"NN", "PAM", "Primer Amor", "EPO", "1994", ""},
        {"PI", "AMA", "Hay Amores Que Matan", "PCL,BAL", "1993", ""},
        {"DY", "LOC", "Un Loco Como Yo", "PCL,BAL", "1993", "Un Loco Como Yo.jpg"},
        {"AL", "VIO", "20 Grandes Éxitos", "CUM", "1989", "20 Grandes Éxitos.jpg"}
    };

    // Temas de los Albumes (Ref album, Ref tema, Nombre, Minutos, Segundos, Ubicacion)
    private String[][] temas = {
        {"VPL", "T11", "YMCA", "4", "28", "1"},
        {"VPL", "T12", "Macho Man", "3", "28", "2"},
        {"VPL", "T13", "In the Navy", "3", "13", "3"},
        {"DMV", "T21", "Personal Jesus", "4", "56", "1"},
        {"DMV", "T22", "Enjoy The Silence", "4", "21", "2"},
        {"CLU", "T31", "Girls Just Want To Have Fun", "3", "15", "1"},
        {"CLU", "T32", "Time After Time", "5", "12", "2"},
        {"USA", "T41", "Born In The U.S.A.", "4", "58", "1"},
        {"USA", "T42", "Glory Days", "5", "23", "2"},
        {"USA", "T43", "Dancing In The Dark", "3", "58", "3"},
        {"INU", "T51", "It's Not Unusual", "2", "0", "1"},
        {"AYS", "T61", "Adegio De Mi Pais", "4", "50", "1"},
        {"LLU", "T71", "El Duelo", "5", "23", "1"},
        {"LLU", "T72", "Mentira", "4", "48", "2"},
        {"LDC", "T81", "Acto 2, Numero 10, Escena (Moderato)", "2", "40", "1"},
        {"CPP", "T91", "Primer Movimiento (Allegro non troppo e molto maestroso - Allegro con spirito)", "21", "58", "1"},
        {"PAM", "T101", "No Quiero Estudiar", "2", "12", "1"},
        {"AMA", "T111", "Por Ese Hombre", "4", "45", "1"},
        {"LOC", "T121", "Por Ese Hombre", "5", "13", "1"},
        {"VIO", "T131", "Violeta", "1", "56", "1"}
    };

    // Archivos y Streams de Musica (Album ref, Ref, Archivo, Stream)
    private String[][] archivosYStreams = {
        {"VPL", "T11", "", "bit.ly/SCvpymca"},
        {"VPL", "T12", "Macho Man.mp3", ""},
        {"VPL", "T13", "", "bit.ly/SCvpinthenavy"},
        {"DMV", "T21", "Personal Jesus.mp3", ""},
        {"DMV", "T22", "Enjoy The Silence.mp3", ""},
        {"CLU", "T31", "", "bit.ly/SCclgirlsjustwant"},
        {"CLU", "T32", "Time After Time.mp3", ""},
        {"USA", "T41", "", "bit.ly/SCbsborninusa"},
        {"USA", "T42", "", "bit.ly/SCbsglorydays"},
        {"USA", "T43", "Dancing In The Dark.mp3", ""},
        {"INU", "T51", "It's Not Unusual.mp3", ""},
        {"AYS", "T61", "", "bit.ly/SCtnadagiopais"},
        {"LLU", "T71", "El Duelo.mp3", ""},
        {"LLU", "T72", "Mentira.mp3", ""},
        {"LDC", "T81", "", "bit.ly/SCptswanlake"},
        {"CPP", "T91", "", "bit.ly/SCptpiano"},
        {"PAM", "T101", "No Quiero Estudiar.mp3", ""},
        {"AMA", "T111", "Por Ese Hombre.mp3", ""},
        {"LOC", "T121", "", "bit.ly/SCdyporesehombre"},
        {"VIO", "T131", "", "bit.ly/SCvioleta"}
    };

    // Listas de Reproduccion por Defecto (Ref, Nombre, Genero, Imagen)
    private String[][] listasPorDefecto = {
        {"LD1", "Noche De La Nostalgia", "PCL", "Noche De La Nostalgia.jpg"},
        {"LD2", "Rock En Español", "RKL", ""},
        {"LD3", "Musica Clasica", "CLA", "Musica Clasica.jpg"}
    };

    // Listas de Reproduccion Particulares (Ref cliente, Ref, Nombre, Publica, Imagen)
    private String[][] listasParticulares = {
        {"VC", "LP1", "Musica Inspiradora", "S", "Musica Inspiradora.jpg"},
        {"SO", "LP2", "De Todo Un Poco", "S", ""},
        {"WW", "LP3", "Para Cocinar", "N", "Para Cocinar.jpg"},
        {"ML", "LP4", "Para Las Chicas", "S", ""},
        {"CB", "LP5", "Fiesteras", "S", "Fiesteras.jpg"},
        {"CB", "LP6", "Mis Favoritas", "N", ""}
    };

    // Temas De Listas (Ref Lista, Ref Album, Ref Tema)
    private String[][] temasDeListas = {
        {"LD1", "VPL", "T11"},
        {"LD1", "VPL", "T12"},
        {"LD1", "VPL", "T13"},
        {"LD1", "CLU", "T31"},
        {"LD1", "CLU", "T32"},
        {"LD1", "USA", "T41"},
        {"LD1", "USA", "T42"},
        {"LD1", "USA", "T43"},
        {"LD1", "INU", "T51"},
        {"LD2", "AYS", "T61"},
        {"LD2", "LLU", "T71"},
        {"LD2", "LLU", "T72"},
        {"LD3", "LDC", "T81"},
        {"LD3", "CPP", "T91"},
        {"LP1", "LDC", "T81"},
        {"LP1", "CPP", "T91"},
        {"LP1", "DMV", "T21"},
        {"LP2", "CLU", "T31"},
        {"LP2", "CLU", "T32"},
        {"LP2", "INU", "T51"},
        {"LP2", "LDC", "T81"},
        {"LP3", "DMV", "T21"},
        {"LP3", "DMV", "T22"},
        {"LP3", "USA", "T41"},
        {"LP3", "USA", "T42"},
        {"LP4", "CLU", "T31"},
        {"LP4", "INU", "T51"},
        {"LP4", "CPP", "T91"},
        {"LP4", "PAM", "T101"},
        {"LP4", "LOC", "T121"},
        {"LP5", "VPL", "T11"},
        {"LP5", "VPL", "T12"},
        {"LP5", "VPL", "T13"},
        {"LP5", "USA", "T42"},
        {"LP5", "VIO", "T131"},
        {"LP6", "AYS", "T61"},
        {"LP6", "CPP", "T91"},
        {"LP6", "AMA", "T111"}
    };

    // Favoritos
    // Temas Favoritos (Ref Cliente, Ref Album, Ref Tema)
    private String[][] refTemaFav = {
        {"VC", "LLU", "T71"},
        {"PA", "AYS", "T61"},
        {"CB", "CPP", "T91"},
        {"EL", "PAM", "T101"}
    };

    // Listas Favoritas (Ref Cliente, Ref Listas)
    private String[][] refListaFav = {
        {"VC", "LD1"},
        {"VC", "LD3"},
        {"SO", "LD3"},
        {"PA", "LD1"},
        {"PA", "LD2"},
        {"WW", "LP1"},
        {"CB", "LD1"},
        {"CB", "LD2"}
    };

    // Albumes Favoritos (Ref Cliente, Ref Album)
    private String[][] refAlbumFav = {
        {"VC", "DMV"},
        {"VC", "LDC"},
        {"VC", "CPP"},
        {"OK", "LDC"},
        {"OK", "CPP"},
        {"CB", "AMA"}
    };
    // Fin de datos de prueba

    protected Connection conexion = new ConexionBD().getConexion();

    // Funciones para levantar datos de la BD
    public ArrayList<DtUsuario> cargarUsuarios() {
        try {
            ArrayList<DtUsuario> usuarios = new ArrayList<>();

            PreparedStatement usuario = conexion.prepareStatement("SELECT * FROM artista");
            ResultSet artistas = usuario.executeQuery();

            while (artistas.next()) {
                String nickName = artistas.getString(1);
                String nombre = artistas.getString(2);
                String apellido = artistas.getString(3);
                String correo = artistas.getString(4);
                Date fecha = artistas.getDate(5);
                Calendar cal = Calendar.getInstance();      //Las funciones getDay(), getYear() y getMonth() están obsoletas(retornan valores incorrectos), por eso se usa Calendar.
                cal.setTime(fecha);
                DtFecha dtFecha = new DtFecha(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
                String biografia = artistas.getString(6);
                String web = artistas.getString(7);
                String imagen = artistas.getString(8);
                usuarios.add(new DtArtista(nickName, nombre, apellido, correo, dtFecha, imagen, biografia, web));
            }

            usuario.close();
            artistas.close();

            PreparedStatement usuario1 = conexion.prepareStatement("SELECT * FROM cliente");
            ResultSet clientes = usuario1.executeQuery();

            while (clientes.next()) {
                String nickName = clientes.getString(1);
                String nombre = clientes.getString(2);
                String apellido = clientes.getString(3);
                String correo = clientes.getString(4);
                String imagen = clientes.getString(6);
                Date fecha = clientes.getDate(5);
                Calendar cal = Calendar.getInstance();
                cal.setTime(fecha);
                DtFecha dtFecha = new DtFecha(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
                usuarios.add(new DtCliente(nickName, nombre, apellido, correo, dtFecha, imagen));

            }

            usuario1.close();
            clientes.close();

            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<String[]> loadFollowers() {
        try {
            ArrayList<String[]> res = new ArrayList<>();
            PreparedStatement s = conexion.prepareStatement("SELECT * FROM seguir_usuario");
            ResultSet r = s.executeQuery();
            while (r.next()) {
                res.add(new String[]{r.getString(1), r.getString(2)});
            }
            r.close();
            s.close();
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String[]> cargarGeneros() {
        try {
            ArrayList<String[]> res = new ArrayList<>();
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM genero");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                if (rs.getString(2) != null) {
                    res.add(new String[]{rs.getString(1), rs.getString(2)});
                }
            }

            rs.close();
            query.close();

            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<DtAlbum> cargarAlbumes() {
        try {
            ArrayList<DtAlbum> dtas = new ArrayList<>();

            PreparedStatement query = conexion.prepareStatement("SELECT nicknameArtista, nombre, anio, imagen FROM album");
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                dtas.add(new DtAlbum(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }

            rs.close();
            query.close();

            return dtas;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> cargarGenerosAlbum(String nicknameArtista, String nombre) {
        try {
            ArrayList<String> generos = new ArrayList<>();
            int idAlbum = obtenerIdAlbum(nicknameArtista, nombre);

            PreparedStatement query = conexion.prepareStatement("SELECT nombreGenero FROM clasificacionalbum WHERE idAlbum = ? AND nicknameArtista = ?");
            query.setInt(1, idAlbum);
            query.setString(2, nicknameArtista);

            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                generos.add(rs.getString(1));
            }

            rs.close();
            query.close();

            return generos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<DtTema> cargarTemasAlbum(String nicknameArtista, String nombreAlbum) {
        try {
            ArrayList<DtTema> temas = new ArrayList<>();
            PreparedStatement query = conexion.prepareStatement("SELECT nombre, duracion, ubicacion, tipo, link FROM tema WHERE nicknameArtista = ? AND idAlbum = ?");
            query.setString(1, nicknameArtista);
            query.setInt(2, obtenerIdAlbum(nicknameArtista, nombreAlbum));

            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                Time duracion = rs.getTime("duracion");
                int ubicacion = rs.getInt("ubicacion");

                if (rs.getString("tipo").equals("A")) {
                    temas.add(new DtTemaLocal(rs.getString("link"), nombre, new DtTime(duracion.getHours(), duracion.getMinutes(), duracion.getSeconds()), ubicacion));
                } else {
                    temas.add(new DtTemaRemoto(rs.getString("link"), nombre, new DtTime(duracion.getHours(), duracion.getMinutes(), duracion.getSeconds()), ubicacion));
                }
            }

            rs.close();
            query.close();

            return temas;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String[]> cargarListasParticulares() {
        try {
            ArrayList<String[]> res = new ArrayList<>();
            PreparedStatement l = conexion.prepareStatement("SELECT l.idLista, l.nombre, lp.nickname, lp.Publica, l.imagen, lp.nickname FROM lista AS l, listaparticular AS lp WHERE l.idLista = lp.idLista");
            ResultSet listas = l.executeQuery();

            while (listas.next()) {
                res.add(new String[]{String.valueOf(listas.getInt(1)), listas.getString(2), listas.getString(3), listas.getString(4), listas.getString(5), listas.getString(6)});
            }

            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<String[]> cargarTemasLista(int idLista) {
        try {
            ArrayList<String[]> temasInfo = new ArrayList<>();

            PreparedStatement query = conexion.prepareStatement("SELECT t.nombre, a.nicknameArtista, a.nombre AS 'album' FROM listatienetemas AS ltt, tema AS t, album AS a WHERE ltt.idTema = t.idTema AND t.idAlbum = a.idAlbum AND ltt.idLista = ?");
            query.setInt(1, idLista);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                temasInfo.add(new String[]{rs.getString("nicknameArtista"), rs.getString("album"), rs.getString("nombre")});
            }

            rs.close();
            query.close();

            return temasInfo;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String[]> cargarListasDefecto() {
        try {
            ArrayList<String[]> res = new ArrayList<>();

            PreparedStatement l = conexion.prepareStatement("SELECT l.idLista, ld.nombreGenero, l.nombre, l.imagen FROM listapordefecto AS ld, lista AS l WHERE ld.idLista = l.idLista");

            ResultSet listas = l.executeQuery();
            while (listas.next()) {
                res.add(new String[]{String.valueOf(listas.getString(1)), listas.getString(2), listas.getString(3), listas.getString(4)});
            }

            l.close();
            listas.close();

            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<String[]> cargarAlbumesFavoritos() {
        try {
            ArrayList<String[]> res = new ArrayList<>();
            String sql = "SELECT a.nombre, f.nicknameCliente,f.nicknameArtista FROM album as a , fava as f WHERE a.idAlbum = f.idAlbum";
            PreparedStatement statament = conexion.prepareStatement(sql);
            ResultSet favoritos = statament.executeQuery();

            while (favoritos.next()) {

                String nombreAlbum = favoritos.getString(1);
                String nicknameCliente = favoritos.getString(2);
                String nicknameArtista = favoritos.getString(3);
                res.add(new String[]{nombreAlbum, nicknameCliente, nicknameArtista});

            }
            statament.close();
            favoritos.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<String[]> cargaTemasFavoritos() {

        try {
            ArrayList<String[]> res = new ArrayList<>();
            String sql = "SELECT f.nickname, t.nombre, a.nombre,t.nicknameArtista FROM favt as f , tema as t , album as a WHERE f.idTema=t.idTema and t.idAlbum=a.idAlbum";
            PreparedStatement statament = conexion.prepareStatement(sql);
            ResultSet favoritos = statament.executeQuery();
            while (favoritos.next()) {
                String nickname = favoritos.getString(1);
                String nombreTema = favoritos.getString(2);
                String nombreAlbum = favoritos.getString(3);
                String nicknameArtista = favoritos.getString(4);
                res.add(new String[]{nickname, nombreTema, nombreAlbum, nicknameArtista});
            }
            statament.close();
            favoritos.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<String[]> cargaListasFavoritosP() {

        try {
            ArrayList<String[]> res = new ArrayList<>();
            String sqlP = "SELECT f.nickname ,lp.nickname,l.nombre  FROM favl as f, listaparticular as lp , lista as l WHERE f.idLista=l.idLista and l.idLista = lp.idLista";
            PreparedStatement statamentD = conexion.prepareStatement(sqlP);
            ResultSet favoritosD = statamentD.executeQuery();
            while (favoritosD.next()) {
                String nickname = favoritosD.getString(1);
                String nicknameCreador = favoritosD.getString(2);
                String nombre = favoritosD.getString(3);
                res.add(new String[]{nickname, nicknameCreador, nombre});
            }
            statamentD.close();
            favoritosD.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<String[]> cargaListasFavoritosD() {

        try {
            ArrayList<String[]> res = new ArrayList<>();
            String sqlD = "SELECT f.nickname ,ld.nombreGenero,l.nombre  FROM favl as f, listapordefecto as ld , lista as l WHERE f.idLista=l.idLista and l.idLista = ld.idLista";
            PreparedStatement statamentD = conexion.prepareStatement(sqlD);
            ResultSet favoritosD = statamentD.executeQuery();
            while (favoritosD.next()) {
                String nickname = favoritosD.getString(1);
                String nombreGenero = favoritosD.getString(2);
                String nombre = favoritosD.getString(3);
                res.add(new String[]{nickname, nombreGenero, nombre});
            }
            statamentD.close();
            favoritosD.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    // Obtener Id de cosas
    public int obtenerIdAlbum(String nickArtista, String nombreAlbum) {
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT idAlbum FROM album WHERE nombre = ? AND nicknameArtista = ?");
            query.setString(1, nombreAlbum);
            query.setString(2, nickArtista);

            ResultSet rs = query.executeQuery();
            int idAlbum = 0;

            while (rs.next()) {
                idAlbum = rs.getInt(1);
            }

            rs.close();
            query.close();

            return idAlbum;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int obtenerIdListaParticular(String nickCliente, String nombreLista) {
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT l.idLista FROM lista AS l, listaparticular AS lp WHERE l.idLista = lp.idLista AND lp.nickname = ? AND l.nombre = ?");
            query.setString(1, nickCliente);
            query.setString(2, nombreLista);

            int idLista = 0;
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                idLista = rs.getInt(1);
            }

            rs.close();
            query.close();

            return idLista;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int obtenerIdListaDefecto(String nombreGenero, String nombreLista) {
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT l.idLista FROM lista AS l, listapordefecto AS ld WHERE l.idLista = ld.idLista AND nombreGenero = ? AND nombre = ?;");
            query.setString(1, nombreGenero);
            query.setString(2, nombreLista);

            int idLista = 0;
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                idLista = rs.getInt(1);
            }

            rs.close();
            query.close();

            return idLista;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int obtenerIdTema(String nickArtista, int idAlbum, String nombreTema) {
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT idTema FROM tema WHERE nicknameArtista = ? AND idAlbum = ? AND nombre = ?");
            query.setString(1, nickArtista);
            query.setInt(2, idAlbum);
            query.setString(3, nombreTema);

            int idTema = 0;
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                idTema = rs.getInt(1);
            }

            rs.close();
            query.close();

            return idTema;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Insertar Datos de prueba en la BD
    public boolean insertarDatosPrueba() {
        if (!insertarUsuarios()) {
            return false;
        }
        if (!insertarSeguidores()) {
            return false;
        }
        if (!insertarGeneros()) {
            return false;
        }
        if (!insertarAlbumes()) {
            return false;
        }
        if (!insertarTemas()) {
            return false;
        }
        if (!insertarListaParticular()) {
            return false;
        }
        if (!insertarListaPorDefecto()) {
            return false;
        }
        if (!insertarTemasLista()) {
            return false;
        }
        if (!insertarTemaFavorito()) {
            return false;
        }
        if (!insertarAlbumFavorito()) {
            return false;
        }
        if (!insertarListaFavorita()) {
            return false;
        }
        return true;
    }

    private boolean insertarUsuarios() {
        BDUsuario bdu = new BDUsuario();
        boolean res = false;
        DtUsuario dtu;
        for (String[] usuario : perfiles) {

            String nickName = usuario[1];
            String nombre = usuario[3];
            String apellido = usuario[4];
            String correo = usuario[2];
            String imagen = "";

            DtFecha fecha = new DtFecha(Integer.parseInt(usuario[5]), Integer.parseInt(usuario[6]), Integer.parseInt(usuario[7]));
            if (usuario[8] == "A") {

                String bio = "";
                String web = "";

                for (String[] info : infoArtistas) {
                    if (info[0] == usuario[0]) {
                        imagen = info[1];
                        bio = info[2];
                        web = info[3];
                    }
                }
                dtu = new DtArtista(nickName, nombre, apellido, correo, fecha, imagen, bio, web);

            } else {
                for (String[] info : infoClientes) {
                    if (info[0] == usuario[0]) {
                        imagen = info[1];
                    }
                }
               
                dtu = new DtCliente(nickName, nombre, apellido, correo, fecha, imagen);
            }
            res = bdu.ingresarUsuario(dtu);
            if (res == false) {
                break;
            }
        }
        return res;
    }

    private boolean insertarSeguidores() {
        BDCliente bdc = new BDCliente();

        for (String[] seguidor : seguidores) {
            String codC = seguidor[0];
            String codU = seguidor[1];

            String nickC = "";
            String nickU = "";

            for (String[] usuario : perfiles) {
                if (usuario[0] == codC) {
                    nickC = usuario[1];
                }

                if (usuario[0] == codU) {
                    nickU = usuario[1];
                }
            }

            if (!bdc.seguirUsuario(nickC, nickU)) {
                return false;
            }
        }

        return true;
    }

    private boolean insertarGeneros() {
        String nombre = "";
        String padre = "";
        String pRef = "";
        BDGenero bdg = new BDGenero();

        bdg.ingresarGeneros("Géneros", null);

        for (String[] genero : generos) {
            nombre = genero[1];
            pRef = genero[2];

            if ("".equals(pRef)) {
                padre = "Géneros";
            } else {
                for (String[] generoPadre : generos) {
                    if (pRef.equals(generoPadre[0])) {
                        padre = generoPadre[1];
                        break;
                    }
                }
            }
            if (!bdg.ingresarGeneros(nombre, padre)) {
                return false;
            }
        }
        return true;
    }

    private boolean insertarAlbumes() {
        BDAlbum bda = new BDAlbum();

        for (String[] album : albumes) {    // comentario
            String nickArtista = "";

            for (String[] perfil : perfiles) {
                if (perfil[0] == album[0]) {
                    nickArtista = perfil[1];
                    break;
                }
            }

            int idAlbum = bda.insertarAlbum(new DtAlbum(nickArtista, album[2], Integer.parseInt(album[4]), album[5]));

            for (String refGenero : album[3].split(",")) {
                String nombreGenero = "";

                for (String[] genero : generos) {
                    if (refGenero.equals(genero[0])) {
                        nombreGenero = genero[1];
                        break;
                    }
                }

                bda.insertarGeneroDeAlbum(idAlbum, nickArtista, nombreGenero);
            }
        }

        return true;
    }

    private boolean insertarTemas() {
        BDAlbum bda = new BDAlbum();

        for (String[] tema : temas) {
            String nickArtista = "";
            String nombreAlbum = "";

            for (String[] album : albumes) {
                if (album[1] == tema[0]) {
                    nombreAlbum = album[2];

                    for (String[] usuario : perfiles) {
                        if (usuario[0] == album[0]) {
                            nickArtista = usuario[1];
                        }
                    }
                }
            }

            int idAlbum = obtenerIdAlbum(nickArtista, nombreAlbum);
            String nombre = tema[2];
            Time duracion = new Time(0, Integer.parseInt(tema[4]), Integer.parseInt(tema[5]));
            int ubicacion = Integer.parseInt(tema[5]);

            String tipo = "";
            String link = "";

            for (String[] as : archivosYStreams) {
                if (as[0] == tema[0] && as[1] == tema[1]) {
                    if (as[3] != "") {
                        tipo = "S";
                        link = as[3];
                    } else {
                        tipo = "A";
                        link = as[2];
                    }
                }
            }

            bda.insertarTemaDeAlbum(nickArtista, idAlbum, nombre, duracion, ubicacion, tipo, link);
        }

        return true;
    }

    private boolean insertarListaPorDefecto() {
        BDLista bdl = new BDLista();
        for (String[] listaPordefecto : listasPorDefecto) {

            String nombre = listaPordefecto[1];
            String refGenero = listaPordefecto[2];
            String imagen = listaPordefecto[3];

            String nombreGenero = "";

            for (String[] genero : generos) {
                if (genero[0] == refGenero) {
                    nombreGenero = genero[1];
                }
            }
            DtLista lista = new DtListaDefecto(new DtGenero(nombreGenero, null), nombre, null, imagen);

            if (!bdl.altaLista(lista, "")) {
                return false;
            }
        }
        return true;
    }

    private boolean insertarListaParticular() {
        BDLista bdl = new BDLista();
        BDCliente bdc = new BDCliente();

        for (String[] listaParticular : listasParticulares) {
            String refCliente = listaParticular[0];
            String nombreLista = listaParticular[2];
            String publica = listaParticular[3];
            String imagen = listaParticular[4];

            String nickCliente = "";

            for (String[] cliente : perfiles) {
                if (cliente[0] == refCliente) {
                    nickCliente = cliente[1];
                }
            }
            DtLista lista = new DtListaParticular("S".equals(publica) ? false : true, nombreLista, null, imagen);
            if (!bdl.altaLista(lista, nickCliente)) {
                return false;
            }

            if (!bdc.asociarListaACliente(obtenerIdListaParticular(nickCliente, nombreLista), nickCliente)) {
                return false;
            }
        }

        return true;
    }

    private boolean insertarTemasLista() {
        BDLista bdl = new BDLista();

        for (String[] ltt : temasDeListas) {
            String nombreAlbum = "";
            String nickArtista = "";

            for (String[] album : albumes) {
                if (album[1] == ltt[1]) {
                    nombreAlbum = album[2];

                    for (String[] perfil : perfiles) {
                        if (perfil[0] == album[0]) {
                            nickArtista = perfil[1];
                        }
                    }
                }
            }

            String nombreTema = "";

            for (String[] t : temas) {
                if (t[1] == ltt[2]) {
                    nombreTema = t[2];
                }
            }

            int idAlbum = obtenerIdAlbum(nickArtista, nombreAlbum);
            int idTema = obtenerIdTema(nickArtista, idAlbum, nombreTema);

            int idLista = 0;

            String nombreLista = "";
            if (ltt[0].substring(0, 2).equals("LD")) {
                String nombreGenero = "";

                for (String[] lista : listasPorDefecto) {
                    if (lista[0] == ltt[0]) {
                        nombreLista = lista[1];

                        for (String[] genero : generos) {
                            if (genero[0] == lista[2]) {
                                nombreGenero = genero[1];
                            }
                        }
                    }
                }

                idLista = obtenerIdListaDefecto(nombreGenero, nombreLista);
            } else {
                String nickCliente = "";
                for (String[] lista : listasParticulares) {
                    if (lista[1] == ltt[0]) {
                        nombreLista = lista[2];

                        for (String[] perfil : perfiles) {
                            if (lista[0] == perfil[0]) {
                                nickCliente = perfil[1];
                            }
                        }
                    }
                }

                idLista = obtenerIdListaParticular(nickCliente, nombreLista);
            }

            if (!bdl.insertarTemaALista(nickArtista, idAlbum, idTema, idLista)) {
                return false;
            }
        }

        return true;
    }

    // Temas Favoritos (Ref Cliente, Ref Album, Ref Tema)
    public boolean insertarTemaFavorito() {
        BDFavorito bdf = new BDFavorito();
        for (String[] temafav : refTemaFav) {
            String refCliente = temafav[0];
            String refAlbum = temafav[1];
            String refTema = temafav[2];

            String nicknameCliente = "";
            String refArtista = "";
            String nombreAlbum = "";
            String nicknameArtista = "";
            String nombreTema = "";

            for (String[] cliente : perfiles) {
                if (refCliente == cliente[0]) {
                    nicknameCliente = cliente[1];
                }
            }
            for (String[] album : albumes) {
                if (refAlbum == album[1]) {
                    refArtista = album[0];
                    nombreAlbum = album[2];
                }
            }
            for (String[] artista : perfiles) {
                if (refArtista == artista[0]) {
                    nicknameArtista = artista[1];
                }
            }
            for (String[] tema : temas) {
                if (refTema == tema[1]) {
                    nombreTema = tema[2];
                }
            }
            int idAlbum = obtenerIdAlbum(nicknameArtista, nombreAlbum);
            int idTema = obtenerIdTema(nicknameArtista, idAlbum, nombreTema);

            if (!bdf.altaTemaFavortio(nicknameCliente, idTema)) {
                return false;
            }
        }
        return true;

    }

    // Albumes Favoritos (Ref Cliente, Ref Album)
    public boolean insertarAlbumFavorito() {
        BDFavorito bdf = new BDFavorito();
        for (String[] albumFav : refAlbumFav) {
            String refCliente = albumFav[0];
            String refAlbum = albumFav[1];

            String nickCliente = "";
            String nickArtista = "";
            String nombreAlbum = "";
            String refArtista = "";
            for (String[] cliente : perfiles) {
                if (refCliente == cliente[0]) {
                    nickCliente = cliente[1];
                }
            }
            for (String[] album : albumes) {
                if (refAlbum == album[1]) {
                    nombreAlbum = album[2];
                    refArtista = album[0];
                }
            }
            for (String[] artista : perfiles) {
                if (refArtista == artista[0]) {
                    nickArtista = artista[1];
                }
            }
            int idalbum = obtenerIdAlbum(nickArtista, nombreAlbum);
            if (!bdf.altaAlbumFavorito(idalbum, nickArtista, nickCliente)) {
                return false;
            }
        }
        return true;
    }

    // Listas Favoritas (Ref Cliente, Ref Listas)
    public boolean insertarListaFavorita() {
        BDFavorito bdf = new BDFavorito();
        for (String[] listafav : refListaFav) {
            String refCliente = listafav[0];
            String refLista = listafav[1];

            String nickCliente = "";
            String nickArtista = "";
            String nombreLista = "";
            String nombreGenero = "";
            String refGenero = "";
            String refArtista = "";

            for (String[] cliente : perfiles) {
                if (refCliente == cliente[0]) {
                    nickCliente = cliente[1];
                }
            }
            for (String[] listaD : listasPorDefecto) {
                if (refLista == listaD[0]) {
                    nombreLista = listaD[1];
                    refGenero = listaD[2];
                }
            }
            for (String[] listaP : listasParticulares) {
                if (refLista == listaP[1]) {
                    nombreLista = listaP[2];
                    refArtista = listaP[0];
                }
            }
            for (String[] artista : perfiles) {
                if (refArtista == artista[0]) {
                    nickArtista = artista[1];
                }
            }

            for (String[] genero : generos) {
                if (refGenero == genero[0]) {
                    nombreGenero = genero[1];
                }
            }

            int idLista;
            if (nombreGenero == "") {

                idLista = obtenerIdListaParticular(nickArtista, nombreLista);
            } else {

                idLista = obtenerIdListaDefecto(nombreGenero, nombreLista);
            }

            if (!bdf.altaListaFavorita(nickCliente, idLista)) {
                return false;
            }
        }
        return true;
    }

    // Borrar todos los datos de la BD
    public boolean borrarTodosLosDatos() {
        try {
            PreparedStatement query = conexion.prepareStatement("SHOW TABLES");

            ResultSet tablas = query.executeQuery();

            while (tablas.next()) {
                borrarDatosTabla(tablas.getString(1));
            }

            tablas.close();
            query.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean borrarDatosTabla(String nombre) {
        try {
            PreparedStatement truncate = conexion.prepareStatement("DELETE FROM " + nombre);
            truncate.executeUpdate();
            truncate.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
