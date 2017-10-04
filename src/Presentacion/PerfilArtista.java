package Presentacion;

import Logica.DtAlbum;
import Logica.DtCliente;
import Logica.DtPerfilArtista;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PerfilArtista extends javax.swing.JInternalFrame {

    PropertyManager pm;

    public PerfilArtista(DtPerfilArtista dtPerfilArtista) {
        initComponents();
        pm = PropertyManager.getInstance();
        setTitle(getTitle() + " " + dtPerfilArtista.getInfo().getNickname());

        txtNickname.setText(dtPerfilArtista.getInfo().getNickname());
        txtNombre.setText(dtPerfilArtista.getInfo().getNombre());
        txtApellido.setText(dtPerfilArtista.getInfo().getApellido());
        txtEmail.setText(dtPerfilArtista.getInfo().getEmail());
        txtSitioWeb.setText(dtPerfilArtista.getInfoArtista().getWeb());
        textBiografia.setText(dtPerfilArtista.getInfoArtista().getBiografia());
        txtFechaNac.setText(dtPerfilArtista.getInfo().getFechaNac().toString());

        ((TitledBorder) PanelSeguidores.getBorder()).setTitle("Seguidores (" + dtPerfilArtista.getSeguidores().size() + "):");

        DefaultTableModel dtmSeguidores = (DefaultTableModel) tablaSeguidores.getModel();
        dtmSeguidores.setRowCount(0);

        for (DtCliente dtc : dtPerfilArtista.getSeguidores()) {
            Object[] data = {
                dtc.getNickname(),
                dtc.getNombre(),
                dtc.getApellido(),
                dtc.getEmail(),
                dtc.getFechaNac().toString()
            };
            dtmSeguidores.addRow(data);
        }

        DefaultTableModel dtmAlbumes = (DefaultTableModel) TablaAlbum.getModel();
        dtmAlbumes.setRowCount(0);

        for (DtAlbum dta : dtPerfilArtista.getAlbumes()) {
            Object[] data = {
                dta.getNombre()
            };
            dtmAlbumes.addRow(data);
        }

        // Carga de imagen
        try {
            String imagen = dtPerfilArtista.getInfo().getImagen();
            BufferedImage img;
            String path = pm.getProperty("pathImagenesUsuario");

            if (imagen == null || imagen.isEmpty()) {
                img = ImageIO.read(new File(path + "userDefaullt.png"));
            } else {
                img = ImageIO.read(new File(path + imagen));
            }
            PanelImagen pImg = new PanelImagen(img);
            imagenPanel.add(pImg);
            pImg.setBounds(0, 0, 200, 200);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen del usuario");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jSplitPane3 = new javax.swing.JSplitPane();
        jSplitPane4 = new javax.swing.JSplitPane();
        PanelAlbum = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAlbum = new javax.swing.JTable();
        PanelSeguidores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSeguidores = new javax.swing.JTable();
        PanelInfo7 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtSitioWeb = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        textBiografia = new javax.swing.JTextArea();
        imagenPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Perfil De Artista");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS));

        jSplitPane3.setDividerLocation(350);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane4.setDividerLocation(260);

        PanelAlbum.setBorder(javax.swing.BorderFactory.createTitledBorder("Albumes Publicados: "));

        TablaAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaAlbum);

        javax.swing.GroupLayout PanelAlbumLayout = new javax.swing.GroupLayout(PanelAlbum);
        PanelAlbum.setLayout(PanelAlbumLayout);
        PanelAlbumLayout.setHorizontalGroup(
            PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
        );
        PanelAlbumLayout.setVerticalGroup(
            PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
        );

        jSplitPane4.setLeftComponent(PanelAlbum);

        PanelSeguidores.setBorder(javax.swing.BorderFactory.createTitledBorder("Seguidores:"));

        tablaSeguidores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaSeguidores);

        javax.swing.GroupLayout PanelSeguidoresLayout = new javax.swing.GroupLayout(PanelSeguidores);
        PanelSeguidores.setLayout(PanelSeguidoresLayout);
        PanelSeguidoresLayout.setHorizontalGroup(
            PanelSeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );
        PanelSeguidoresLayout.setVerticalGroup(
            PanelSeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSeguidoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
        );

        jSplitPane4.setRightComponent(PanelSeguidores);

        jSplitPane3.setRightComponent(jSplitPane4);

        PanelInfo7.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Basica:"));

        jLabel38.setText("Fecha de Nacimiento");

        txtSitioWeb.setEditable(false);
        txtSitioWeb.setBackground(new java.awt.Color(255, 255, 255));
        txtSitioWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSitioWebActionPerformed(evt);
            }
        });

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.setEditable(false);
        txtApellido.setBackground(new java.awt.Color(255, 255, 255));

        txtEmail.setEditable(false);
        txtEmail.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setText("Nickname");

        jLabel40.setText("Nombre");

        jLabel41.setText("Apellido");

        jLabel42.setText("Email");

        txtNickname.setEditable(false);
        txtNickname.setBackground(new java.awt.Color(255, 255, 255));
        txtNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknameActionPerformed(evt);
            }
        });

        jLabel7.setText("Biografia");

        jLabel43.setText("Sitio Web");

        txtFechaNac.setEditable(false);
        txtFechaNac.setBackground(new java.awt.Color(255, 255, 255));

        textBiografia.setEditable(false);
        textBiografia.setColumns(20);
        textBiografia.setLineWrap(true);
        textBiografia.setRows(5);
        jScrollPane3.setViewportView(textBiografia);

        imagenPanel.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout imagenPanelLayout = new javax.swing.GroupLayout(imagenPanel);
        imagenPanel.setLayout(imagenPanelLayout);
        imagenPanelLayout.setHorizontalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        imagenPanelLayout.setVerticalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelInfo7Layout = new javax.swing.GroupLayout(PanelInfo7);
        PanelInfo7.setLayout(PanelInfo7Layout);
        PanelInfo7Layout.setHorizontalGroup(
            PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfo7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel7)
                    .addComponent(jLabel43)
                    .addComponent(jLabel38))
                .addGap(41, 41, 41)
                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInfo7Layout.createSequentialGroup()
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNickname, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(txtNombre)
                                .addComponent(txtApellido)
                                .addComponent(txtEmail)
                                .addComponent(txtSitioWeb)))
                        .addGap(29, 29, 29)
                        .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        PanelInfo7Layout.setVerticalGroup(
            PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfo7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInfo7Layout.createSequentialGroup()
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addGap(18, 18, 18)
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addGap(18, 18, 18)
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(txtSitioWeb, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                        .addGap(22, 22, 22)))
                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jSplitPane3.setTopComponent(PanelInfo7);

        getContentPane().add(jSplitPane3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknameActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtSitioWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSitioWebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSitioWebActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAlbum;
    private javax.swing.JPanel PanelInfo7;
    private javax.swing.JPanel PanelSeguidores;
    private javax.swing.JTable TablaAlbum;
    private javax.swing.JPanel imagenPanel;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaSeguidores;
    private javax.swing.JTextArea textBiografia;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSitioWeb;
    // End of variables declaration//GEN-END:variables
}
