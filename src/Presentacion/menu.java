package Presentacion;

import Logica.Fabrica;
import Persistencia.CargaDatosPrueba;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class menu extends javax.swing.JFrame {

    public menu() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        Fabrica.inicializarControladores();
        try {
            Fabrica.levantarDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMenu = new DesktopFondo();
        barra = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        altaPerfil = new javax.swing.JMenuItem();
        altaAlbum = new javax.swing.JMenuItem();
        altaGenero = new javax.swing.JMenuItem();
        crearListaRep = new javax.swing.JMenuItem();
        publicarLista = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        consultaPerfilCliente = new javax.swing.JMenuItem();
        ConsultaPerfilArtista = new javax.swing.JMenuItem();
        consultaAlbum = new javax.swing.JMenuItem();
        consultaListaRep = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        seguirUsuario = new javax.swing.JMenuItem();
        dejarSeguirUsuario = new javax.swing.JMenuItem();
        agregarTemaLista = new javax.swing.JMenuItem();
        quitarTemaLista = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        guardarTLA = new javax.swing.JMenuItem();
        eliminarTLA = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        cargarDatos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Espotify");
        setBackground(new java.awt.Color(51, 153, 0));
        setIconImage(Toolkit.getDefaultToolkit().getImage(menu.class.getResource("/Imagenes/icono2.png")));
        setName("Espotify"); // NOI18N

        PanelMenu.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        barra.setBackground(new java.awt.Color(255, 255, 255));
        barra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setText("Registros");

        altaPerfil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        altaPerfil.setText("Alta de Perfil");
        altaPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaPerfilActionPerformed(evt);
            }
        });
        jMenu1.add(altaPerfil);

        altaAlbum.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        altaAlbum.setText("Alta Album");
        altaAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaAlbumActionPerformed(evt);
            }
        });
        jMenu1.add(altaAlbum);

        altaGenero.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        altaGenero.setText("Alta de Genero");
        altaGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaGeneroActionPerformed(evt);
            }
        });
        jMenu1.add(altaGenero);

        crearListaRep.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        crearListaRep.setText("Crear Lista de Reproduccion");
        crearListaRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearListaRepActionPerformed(evt);
            }
        });
        jMenu1.add(crearListaRep);

        publicarLista.setText("Publicar Lista");
        publicarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicarListaActionPerformed(evt);
            }
        });
        jMenu1.add(publicarLista);

        barra.add(jMenu1);

        jMenu2.setText("Consultas");

        consultaPerfilCliente.setText("Consulta de Perfil de Cliente");
        consultaPerfilCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPerfilClienteActionPerformed(evt);
            }
        });
        jMenu2.add(consultaPerfilCliente);

        ConsultaPerfilArtista.setText("Consulta de Perfil de Artista");
        ConsultaPerfilArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaPerfilArtistaActionPerformed(evt);
            }
        });
        jMenu2.add(ConsultaPerfilArtista);

        consultaAlbum.setText("Consulta de Album");
        consultaAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaAlbumActionPerformed(evt);
            }
        });
        jMenu2.add(consultaAlbum);

        consultaListaRep.setText("Consulta de Lista de Reproduccion");
        consultaListaRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaListaRepActionPerformed(evt);
            }
        });
        jMenu2.add(consultaListaRep);

        barra.add(jMenu2);

        jMenu3.setText("Relaciones");

        seguirUsuario.setText("Seguir Usuario");
        seguirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seguirUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(seguirUsuario);

        dejarSeguirUsuario.setText("Dejar de Seguir Usuario");
        dejarSeguirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dejarSeguirUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(dejarSeguirUsuario);

        agregarTemaLista.setText("Agregar Tema a Lista");
        agregarTemaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTemaListaActionPerformed(evt);
            }
        });
        jMenu3.add(agregarTemaLista);

        quitarTemaLista.setText("Quitar Tema de Lista");
        quitarTemaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarTemaListaActionPerformed(evt);
            }
        });
        jMenu3.add(quitarTemaLista);

        barra.add(jMenu3);

        jMenu4.setText("Favoritos");

        guardarTLA.setText("Agregar Tema/Lista/Album");
        guardarTLA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarTLAActionPerformed(evt);
            }
        });
        jMenu4.add(guardarTLA);

        eliminarTLA.setText("Eliminar Tema/Lista/Album");
        eliminarTLA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTLAActionPerformed(evt);
            }
        });
        jMenu4.add(eliminarTLA);

        barra.add(jMenu4);

        jMenu5.setText("Datos de Prueba");

        cargarDatos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        cargarDatos.setText("Cargar");
        cargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosActionPerformed(evt);
            }
        });
        jMenu5.add(cargarDatos);

        barra.add(jMenu5);

        setJMenuBar(barra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dejarSeguirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dejarSeguirUsuarioActionPerformed
        DejarSeguirUsuario dsu = new DejarSeguirUsuario();
        PanelMenu.add(dsu);
        centrar(dsu);
        dsu.show();
    }//GEN-LAST:event_dejarSeguirUsuarioActionPerformed

    private void consultaPerfilClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaPerfilClienteActionPerformed
        ConsultaPerfil cpc = new ConsultaPerfil("Cliente");
        PanelMenu.add(cpc);
        centrar(cpc);
        cpc.show();
    }//GEN-LAST:event_consultaPerfilClienteActionPerformed

    private void seguirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seguirUsuarioActionPerformed
        SeguirUsuario cpc = new SeguirUsuario();
        PanelMenu.add(cpc);
        centrar(cpc);
        cpc.show();
    }//GEN-LAST:event_seguirUsuarioActionPerformed

    private void altaPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaPerfilActionPerformed
        AltaPerfil ap = new AltaPerfil();
        PanelMenu.add(ap);
        centrar(ap);
        ap.show();
    }//GEN-LAST:event_altaPerfilActionPerformed

    private void quitarTemaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarTemaListaActionPerformed
        QuitarTemaLista qtl = new QuitarTemaLista();
        PanelMenu.add(qtl);
        centrar(qtl);
        qtl.show();
    }//GEN-LAST:event_quitarTemaListaActionPerformed

    private void publicarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicarListaActionPerformed
        PublicarLista pt = new PublicarLista();
        PanelMenu.add(pt);
        centrar(pt);
        pt.show();
    }//GEN-LAST:event_publicarListaActionPerformed
    private void consultaAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaAlbumActionPerformed
        ConsultaAlbum cpc = new ConsultaAlbum();
        PanelMenu.add(cpc);
        centrar(cpc);
        cpc.show();
    }//GEN-LAST:event_consultaAlbumActionPerformed

    public void centrar(JInternalFrame cpc) {
        Dimension desktopSize = this.getSize();
        Dimension jInternalFrameSize = cpc.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        cpc.setLocation(width, height - 30);
    }

    private void consultaListaRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaListaRepActionPerformed
        ConsultaListaReproduccion clr = new ConsultaListaReproduccion();
        PanelMenu.add(clr);
        centrar(clr);
        clr.show();
    }//GEN-LAST:event_consultaListaRepActionPerformed
    private void ConsultaPerfilArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaPerfilArtistaActionPerformed
        ConsultaPerfil cpc = new ConsultaPerfil("Artista");
        PanelMenu.add(cpc);
        centrar(cpc);
        cpc.show();
    }//GEN-LAST:event_ConsultaPerfilArtistaActionPerformed

    private void cargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDatosActionPerformed
        BarraCargando ba = new BarraCargando();
        PanelMenu.add(ba);
        centrar(ba);
        ba.show();
        menu m = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Fabrica.cargaDatosPrueba();
                    ba.dispose();
                    JOptionPane.showMessageDialog(m, "Los Datos de Prueba fueron cargados con exito");
                } catch (Exception ex) {
                    ba.dispose();
                    JOptionPane.showMessageDialog(m, "Los Datos de Prueba no pudieron ser cargados: \n\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }).start();
    }//GEN-LAST:event_cargarDatosActionPerformed

    private void altaAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaAlbumActionPerformed
        AltaAlbum cpc = new AltaAlbum();
        PanelMenu.add(cpc);
        centrar(cpc);
        cpc.show();
    }//GEN-LAST:event_altaAlbumActionPerformed

    private void altaGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaGeneroActionPerformed
        AltaGenero cpc = new AltaGenero();
        PanelMenu.add(cpc);
        centrar(cpc);
        cpc.show();

    }//GEN-LAST:event_altaGeneroActionPerformed

    private void crearListaRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearListaRepActionPerformed
        CrearListaReproduccion clr = new CrearListaReproduccion();
        PanelMenu.add(clr);
        centrar(clr);
        clr.show();
    }//GEN-LAST:event_crearListaRepActionPerformed

    private void guardarTLAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarTLAActionPerformed
        GuardarTLA gtla = new GuardarTLA();
        PanelMenu.add(gtla);
        centrar(gtla);
        gtla.show();
    }//GEN-LAST:event_guardarTLAActionPerformed

    private void eliminarTLAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTLAActionPerformed
        EliminarTLA etla = new EliminarTLA();
        PanelMenu.add(etla);
        centrar(etla);
        etla.show();
    }//GEN-LAST:event_eliminarTLAActionPerformed

    private void agregarTemaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTemaListaActionPerformed
        AgregarTemaLista agr = new AgregarTemaLista();
        PanelMenu.add(agr);
        agr.setLocation(450, 10);
        agr.show();
    }//GEN-LAST:event_agregarTemaListaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ConsultaPerfilArtista;
    private javax.swing.JDesktopPane PanelMenu;
    private javax.swing.JMenuItem agregarTemaLista;
    private javax.swing.JMenuItem altaAlbum;
    private javax.swing.JMenuItem altaGenero;
    private javax.swing.JMenuItem altaPerfil;
    private javax.swing.JMenuBar barra;
    private javax.swing.JMenuItem cargarDatos;
    private javax.swing.JMenuItem consultaAlbum;
    private javax.swing.JMenuItem consultaListaRep;
    private javax.swing.JMenuItem consultaPerfilCliente;
    private javax.swing.JMenuItem crearListaRep;
    private javax.swing.JMenuItem dejarSeguirUsuario;
    private javax.swing.JMenuItem eliminarTLA;
    private javax.swing.JMenuItem guardarTLA;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem publicarLista;
    private javax.swing.JMenuItem quitarTemaLista;
    private javax.swing.JMenuItem seguirUsuario;
    // End of variables declaration//GEN-END:variables
}
