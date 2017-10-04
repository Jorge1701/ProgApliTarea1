package Presentacion;

import Logica.DtAlbum;
import Logica.DtAlbumContenido;
import Logica.DtTema;
import Logica.DtTemaLocal;
import Logica.DtTemaRemoto;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AlbumContenido extends javax.swing.JInternalFrame implements ListSelectionListener {

    IUsuario iUsuario;
    PropertyManager pm;

    public AlbumContenido(DtAlbumContenido dtac) {
        initComponents();
        iUsuario = Fabrica.getIControladorUsuario();
        pm = PropertyManager.getInstance();
        btnAbrirNavegador.setVisible(false);

        tablaTemas.getColumnModel().getColumn(0).setMinWidth(0);
        tablaTemas.getColumnModel().getColumn(0).setMaxWidth(0);

        //Cargar la informacion
        DtAlbum info = dtac.getInfo();
        txtNombre.setText(info.getNombre());
        DtUsuario dtu = iUsuario.getDataUsuario(info.getNickArtista());
        txtNickArtista.setText(dtu.getNombre() + " " + dtu.getApellido() + " (" + dtu.getNickname() + ")");
        txtAnio.setText(Integer.toString(info.getAnio()));

        // Cargar imagen
        try {
            String imagen = dtac.getInfo().getImagen();
            String path = pm.getProperty("pathImagenesAlbum");
            BufferedImage img;
            if (imagen == null || imagen.isEmpty()) {
                img = ImageIO.read(new File(path + "albumDefault.png"));
            } else {
                img = ImageIO.read(new File(path + imagen));
            }
            PanelImagen pImg = new PanelImagen(img);
            imagenPanel.add(pImg);
            pImg.setBounds(0, 0, 150, 150);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen del album");
        }

        //Cargar tabla de Temas
        DefaultTableModel dtm = (DefaultTableModel) tablaTemas.getModel();
        dtm.setRowCount(0);

        for (DtTema dtt : dtac.getTemas()) {
            Object[] data = {
                dtt instanceof DtTemaLocal ? "A" : "S",
                ((DtTema) dtt).getNombre(),
                ((DtTema) dtt).getDuracion().getHoras() + ":" + ((DtTema) dtt).getDuracion().getMinutos() + ":" + ((DtTema) dtt).getDuracion().getSegundos(),
                ((DtTema) dtt).getUbicacion(),
                dtt instanceof DtTemaLocal ? ((DtTemaLocal) dtt).getDirectorio() : ((DtTemaRemoto) dtt).getUrl()
            };
            dtm.addRow(data);
        }

        //Ordenar tabla por Ubicacion del tema
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tablaTemas.getModel());
        tablaTemas.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = 3;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();

        //Cargar lista de generos
        ArrayList<String> generos = dtac.getGeneros();

        DefaultListModel<String> model = new DefaultListModel<>();
        lstGeneros.setModel(model);

        for (String g : generos) {
            model.addElement(g);
        }

        // Hace que al hacer click en una fila de la tablaClientes se llame al metodo valueChanged()
        tablaTemas.getSelectionModel().addListSelectionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNickArtista = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTemas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstGeneros = new javax.swing.JList<>();
        btnDescargar = new javax.swing.JButton();
        btnAbrirNavegador = new javax.swing.JButton();
        imagenPanel = new javax.swing.JPanel();

        setTitle("Informacion del album");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Artista:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Creado en:");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txtNickArtista.setEditable(false);
        txtNickArtista.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txtAnio.setEditable(false);
        txtAnio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(txtNickArtista)
                    .addComponent(txtAnio))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNickArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSplitPane1.setDividerLocation(400);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas"));

        tablaTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Nombre", "Duración", "Posición", "Archivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTemas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaTemas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));

        jScrollPane2.setViewportView(lstGeneros);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel5);

        btnDescargar.setText("Descargar");
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });

        btnAbrirNavegador.setText("Abrir en navegador");
        btnAbrirNavegador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirNavegadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenPanelLayout = new javax.swing.GroupLayout(imagenPanel);
        imagenPanel.setLayout(imagenPanelLayout);
        imagenPanelLayout.setHorizontalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        imagenPanelLayout.setVerticalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnDescargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrirNavegador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSplitPane1)
                        .addGap(23, 23, 23)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDescargar)
                            .addComponent(btnAbrirNavegador))
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        if (tablaTemas.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe de seleccionar un tema");
            return;
        }

        String nombreTema = tablaTemas.getValueAt(tablaTemas.getSelectedRow(), 4).toString();
        if (btnDescargar.getText().equals("Descargar")) {

            JFileChooser seleccionarRuta = new JFileChooser();
            seleccionarRuta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int o = seleccionarRuta.showOpenDialog(this);

            if (o == JFileChooser.APPROVE_OPTION) {
                try {
                    File carpetaSeleccionada = seleccionarRuta.getSelectedFile();
                    String rutaDescarga = carpetaSeleccionada.getAbsolutePath();
                    String rutaDCompleta = rutaDescarga + "\\" + nombreTema;
                    String path = pm.getProperty("pathMusica");
                    InputStream is = new FileInputStream(path + nombreTema);
                    OutputStream outstream = new FileOutputStream(rutaDCompleta);
                    byte[] buffer = new byte[4096];
                    int len;

                    if (is != null) {
                        while ((len = is.read(buffer)) > 0) {
                            outstream.write(buffer, 0, len);
                        }
                        JOptionPane.showMessageDialog(this, "Tema descargado exitosamente en: " + rutaDCompleta, "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        throw new FileNotFoundException();
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "El tema " + "\"" + nombreTema + "\"" + " ya no se encuentra disponible para descargar.", "Error", JOptionPane.WARNING_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(AltaAlbum.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection data = new StringSelection(nombreTema);
            clipboard.setContents(data, data);
            JOptionPane.showMessageDialog(this, "Copiado al portapapeles: " + nombreTema);
        }
    }//GEN-LAST:event_btnDescargarActionPerformed

    private void btnAbrirNavegadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirNavegadorActionPerformed
        if (tablaTemas.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe de seleccionar un tema");
            return;
        }

        String link = tablaTemas.getValueAt(tablaTemas.getSelectedRow(), 4).toString();

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("http://" + link));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el navegador", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (URISyntaxException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el navegador", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAbrirNavegadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirNavegador;
    private javax.swing.JButton btnDescargar;
    private javax.swing.JPanel imagenPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JList<String> lstGeneros;
    private javax.swing.JTable tablaTemas;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtNickArtista;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (tablaTemas.getValueAt(tablaTemas.getSelectedRow(), 0).toString().equals("A")) {
            btnDescargar.setText("Descargar");
            btnAbrirNavegador.setVisible(false);
        } else {
            btnDescargar.setText("Copiar Link");
            btnAbrirNavegador.setVisible(true);
        }
    }

}
