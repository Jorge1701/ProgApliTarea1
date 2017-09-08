package Presentacion;

import Logica.DtAlbum;
import Logica.DtCliente;
import Logica.DtLista;
import Logica.DtListaParticular;
import Logica.DtPerfilCliente;
import Logica.DtTema;
import Logica.DtUsuario;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PerfilCliente extends javax.swing.JInternalFrame {

    PropertyManager pm;

    public PerfilCliente(DtPerfilCliente dtPerfilCliente) {
        initComponents();
        pm = PropertyManager.getInstance();

        txtNickname.setEnabled(true);
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtEmail.setEnabled(true);
        txtFechaNac.setEnabled(true);

        txtNickname.setEditable(false);
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        txtEmail.setEditable(false);
        txtFechaNac.setEditable(false);
        tablaSeguidos.setEnabled(false);
        tablaSeguidores.setEnabled(false);

        setTitle(getTitle() + dtPerfilCliente.getInfo().getNickname());

        // Cargar datos basicos
        txtNickname.setText(dtPerfilCliente.getInfo().getNickname());
        txtNombre.setText(dtPerfilCliente.getInfo().getNombre());
        txtApellido.setText(dtPerfilCliente.getInfo().getApellido());
        txtEmail.setText(dtPerfilCliente.getInfo().getEmail());
        txtFechaNac.setText(dtPerfilCliente.getInfo().getFechaNac().toString());

        // Cargar imagen
        try {
            String imagen = dtPerfilCliente.getInfo().getImagen();
            String path = pm.getProperty("pathImagenesUsuario");
            BufferedImage img;

            if (imagen == null || imagen.isEmpty()) {
                img = ImageIO.read(new File(path + "userDefaullt.png"));
            } else {
                img = ImageIO.read(new File(path + imagen));
            }
            PanelImagen pImg = new PanelImagen(img);
            imagenPanel.add(pImg);
            pImg.setBounds(0, 0, 163, 163);

        } catch (IOException e) {
            e.printStackTrace();

        }

        // Cargar Seguidores
        ((TitledBorder) panelSeguidores.getBorder()).setTitle("Seguidores (" + dtPerfilCliente.getSeguidores().size() + "):");

        DefaultTableModel dtmSeguidores = (DefaultTableModel) tablaSeguidores.getModel();

        dtmSeguidores.setRowCount(
                0);
        for (DtCliente dtc
                : dtPerfilCliente.getSeguidores()) {
            Object[] data = {
                dtc.getNickname(),
                dtc.getNombre() + " " + dtc.getApellido()
            };
            dtmSeguidores.addRow(data);
        }

        // Cargar Seguidos
        ((TitledBorder) panelSeguidos.getBorder()).setTitle("Seguidos (" + dtPerfilCliente.getSeguidos().size() + "):");

        DefaultTableModel dtmSeguidos = (DefaultTableModel) tablaSeguidos.getModel();

        dtmSeguidos.setRowCount(
                0);
        for (DtUsuario dtc
                : dtPerfilCliente.getSeguidos()) {
            Object[] data = {
                dtc.getNickname(),
                dtc.getNombre() + " " + dtc.getApellido(),
                (dtc instanceof DtCliente ? "Cliente" : "Artista")
            };
            dtmSeguidos.addRow(data);
        }

        // Cargar Listas Creadas
        ((TitledBorder) panelListasCreadas.getBorder()).setTitle("Listas Creadas (" + dtPerfilCliente.getListasCreadas().size() + "):");

        DefaultTableModel dtmListasCreadas = (DefaultTableModel) tablaListasCreadas.getModel();
        dtmListasCreadas.setRowCount(0);

        for (DtListaParticular dtlp : dtPerfilCliente.getListasCreadas()) {
            Object[] data = {
                dtlp.getNombre(),
                dtlp.getTemas().size()
            };
            dtmListasCreadas.addRow(data);
        }

        // Cargar Listas Favoritos
        ((TitledBorder) panelListasFavs.getBorder()).setTitle("Listas Favoritas (" + dtPerfilCliente.getListasFavoritas().size() + "):");

        DefaultTableModel dtmListasFavs = (DefaultTableModel) tablaListasFavs.getModel();

        dtmListasFavs.setRowCount(
                0);
        for (DtLista dtl
                : dtPerfilCliente.getListasFavoritas()) {
            Object[] data = {
                dtl.getNombre(),
                dtl.getTemas().size()
            };
            dtmListasFavs.addRow(data);
        }

        // Cargar Albumes Favoritos
        ((TitledBorder) panelAlbumes.getBorder()).setTitle("Albumes Favoritos (" + dtPerfilCliente.getAlbumes().size() + "):");

        DefaultTableModel dtmAlbumes = (DefaultTableModel) tablaAlbumes.getModel();

        dtmAlbumes.setRowCount(
                0);
        for (DtAlbum dta
                : dtPerfilCliente.getAlbumes()) {
            Object[] data = {
                dta.getNickArtista(),
                dta.getNombre(),
                dta.getAnio()
            };
            dtmAlbumes.addRow(data);
        }

        // Cargar Temas Favoritos
        ((TitledBorder) panelTemas.getBorder()).setTitle("Temas Favoritos (" + dtPerfilCliente.getTemas().size() + "):");

        DefaultTableModel dtmTemas = (DefaultTableModel) tablaTemas.getModel();

        dtmTemas.setRowCount(
                0);
        for (DtTema dtt
                : dtPerfilCliente.getTemas()) {
            Object[] data = {
                dtt.getNombre(),
                dtt.getDuracion().getHoras() + ":" + dtt.getDuracion().getMinutos() + ":" + dtt.getDuracion().getSegundos(),};
            dtmTemas.addRow(data);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        PanelInfo = new javax.swing.JPanel();
        txtNickname = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtFechaNac = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        imagenPanel = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        panelSeguidores = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSeguidores = new javax.swing.JTable();
        panelSeguidos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSeguidos = new javax.swing.JTable();
        jSplitPane2 = new javax.swing.JSplitPane();
        panelListasCreadas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaListasCreadas = new javax.swing.JTable();
        panelListasFavs = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListasFavs = new javax.swing.JTable();
        jSplitPane3 = new javax.swing.JSplitPane();
        panelAlbumes = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaAlbumes = new javax.swing.JTable();
        panelTemas = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaTemas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Perfil del Cliente ");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jSplitPane1.setDividerLocation(450);
        jSplitPane1.setLastDividerLocation(400);
        jSplitPane1.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        jSplitPane1.setMinimumSize(new java.awt.Dimension(214, 100));

        PanelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Basica"));

        jLabel1.setText("Nickname:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Email:");

        jLabel5.setText("Fecha Nac.:");

        imagenPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenPanel.setPreferredSize(new java.awt.Dimension(163, 163));

        javax.swing.GroupLayout imagenPanelLayout = new javax.swing.GroupLayout(imagenPanel);
        imagenPanel.setLayout(imagenPanelLayout);
        imagenPanelLayout.setHorizontalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );
        imagenPanelLayout.setVerticalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelInfoLayout = new javax.swing.GroupLayout(PanelInfo);
        PanelInfo.setLayout(PanelInfoLayout);
        PanelInfoLayout.setHorizontalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNickname, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtEmail)
                    .addComponent(txtFechaNac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(imagenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(PanelInfo);

        jSplitPane4.setDividerLocation(200);

        panelSeguidores.setBorder(javax.swing.BorderFactory.createTitledBorder("Seguidores"));

        tablaSeguidores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSeguidores.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaSeguidores);
        if (tablaSeguidores.getColumnModel().getColumnCount() > 0) {
            tablaSeguidores.getColumnModel().getColumn(0).setResizable(false);
            tablaSeguidores.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout panelSeguidoresLayout = new javax.swing.GroupLayout(panelSeguidores);
        panelSeguidores.setLayout(panelSeguidoresLayout);
        panelSeguidoresLayout.setHorizontalGroup(
            panelSeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
        );
        panelSeguidoresLayout.setVerticalGroup(
            panelSeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );

        jSplitPane4.setLeftComponent(panelSeguidores);

        panelSeguidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Seguidos"));

        tablaSeguidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSeguidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaSeguidos);
        if (tablaSeguidos.getColumnModel().getColumnCount() > 0) {
            tablaSeguidos.getColumnModel().getColumn(0).setResizable(false);
            tablaSeguidos.getColumnModel().getColumn(1).setResizable(false);
            tablaSeguidos.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout panelSeguidosLayout = new javax.swing.GroupLayout(panelSeguidos);
        panelSeguidos.setLayout(panelSeguidosLayout);
        panelSeguidosLayout.setHorizontalGroup(
            panelSeguidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        );
        panelSeguidosLayout.setVerticalGroup(
            panelSeguidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );

        jSplitPane4.setRightComponent(panelSeguidos);

        jSplitPane1.setRightComponent(jSplitPane4);

        getContentPane().add(jSplitPane1);

        jSplitPane2.setDividerLocation(450);

        panelListasCreadas.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas Creadas"));

        tablaListasCreadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cant. Temas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListasCreadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaListasCreadas);
        if (tablaListasCreadas.getColumnModel().getColumnCount() > 0) {
            tablaListasCreadas.getColumnModel().getColumn(0).setResizable(false);
            tablaListasCreadas.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout panelListasCreadasLayout = new javax.swing.GroupLayout(panelListasCreadas);
        panelListasCreadas.setLayout(panelListasCreadasLayout);
        panelListasCreadasLayout.setHorizontalGroup(
            panelListasCreadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );
        panelListasCreadasLayout.setVerticalGroup(
            panelListasCreadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(panelListasCreadas);

        panelListasFavs.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas Favoritas"));

        tablaListasFavs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cant. Temas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListasFavs.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tablaListasFavs);
        if (tablaListasFavs.getColumnModel().getColumnCount() > 0) {
            tablaListasFavs.getColumnModel().getColumn(0).setResizable(false);
            tablaListasFavs.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout panelListasFavsLayout = new javax.swing.GroupLayout(panelListasFavs);
        panelListasFavs.setLayout(panelListasFavsLayout);
        panelListasFavsLayout.setHorizontalGroup(
            panelListasFavsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );
        panelListasFavsLayout.setVerticalGroup(
            panelListasFavsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(panelListasFavs);

        getContentPane().add(jSplitPane2);

        jSplitPane3.setDividerLocation(450);

        panelAlbumes.setBorder(javax.swing.BorderFactory.createTitledBorder("Albumes Favoritos"));

        tablaAlbumes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artista", "Nombre", "Año"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAlbumes.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tablaAlbumes);
        if (tablaAlbumes.getColumnModel().getColumnCount() > 0) {
            tablaAlbumes.getColumnModel().getColumn(0).setResizable(false);
            tablaAlbumes.getColumnModel().getColumn(1).setResizable(false);
            tablaAlbumes.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout panelAlbumesLayout = new javax.swing.GroupLayout(panelAlbumes);
        panelAlbumes.setLayout(panelAlbumesLayout);
        panelAlbumesLayout.setHorizontalGroup(
            panelAlbumesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );
        panelAlbumesLayout.setVerticalGroup(
            panelAlbumesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );

        jSplitPane3.setLeftComponent(panelAlbumes);

        panelTemas.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas Favoritos"));

        tablaTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Duracion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTemas.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tablaTemas);
        if (tablaTemas.getColumnModel().getColumnCount() > 0) {
            tablaTemas.getColumnModel().getColumn(0).setResizable(false);
            tablaTemas.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout panelTemasLayout = new javax.swing.GroupLayout(panelTemas);
        panelTemas.setLayout(panelTemasLayout);
        panelTemasLayout.setHorizontalGroup(
            panelTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );
        panelTemasLayout.setVerticalGroup(
            panelTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );

        jSplitPane3.setRightComponent(panelTemas);

        getContentPane().add(jSplitPane3);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JPanel imagenPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JPanel panelAlbumes;
    private javax.swing.JPanel panelListasCreadas;
    private javax.swing.JPanel panelListasFavs;
    private javax.swing.JPanel panelSeguidores;
    private javax.swing.JPanel panelSeguidos;
    private javax.swing.JPanel panelTemas;
    private javax.swing.JTable tablaAlbumes;
    private javax.swing.JTable tablaListasCreadas;
    private javax.swing.JTable tablaListasFavs;
    private javax.swing.JTable tablaSeguidores;
    private javax.swing.JTable tablaSeguidos;
    private javax.swing.JTable tablaTemas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
