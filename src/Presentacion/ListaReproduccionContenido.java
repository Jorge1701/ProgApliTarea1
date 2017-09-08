package Presentacion;

import Logica.DtLista;
import Logica.DtListaParticular;
import Logica.DtTema;
import Logica.DtTemaLocal;
import Logica.DtTemaRemoto;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ListaReproduccionContenido extends javax.swing.JInternalFrame implements ListSelectionListener {

    PropertyManager pm;
    public ListaReproduccionContenido(DtLista lista, String gna) {
        initComponents();
        pm = PropertyManager.getInstance();
        //Ocultar comlumna de la tablaTemas
        tablaTemas.getColumnModel().getColumn(0).setMinWidth(0);
        tablaTemas.getColumnModel().getColumn(0).setMaxWidth(0);

        txtNombre.setText(lista.getNombre());
        txtGenOnick.setText(gna);

        lblGenOnick.setText(lista instanceof DtListaParticular ? "Propietario" : "Genero");

        //Obtiene el modelo de la tabla y la vacia
        DefaultTableModel dtm = (DefaultTableModel) tablaTemas.getModel();
        dtm.setRowCount(0);

        //Carga la tabla temas
        for (DtTema dtt : lista.getTemas()) {

            Object[] data = {
                dtt instanceof DtTemaLocal ? "A" : "S",
                ((DtTema) dtt).getNombre(),
                ((DtTema) dtt).getDuracion().getHoras() + ":" + ((DtTema) dtt).getDuracion().getMinutos() + ":" + ((DtTema) dtt).getDuracion().getSegundos(),
                dtt instanceof DtTemaLocal ? ((DtTemaLocal) dtt).getDirectorio() : ((DtTemaRemoto) dtt).getUrl()
            };
            dtm.addRow(data);
        }

        // Cargar imagen
        try {
            String imagen = lista.getImagen();
            String path = pm.getProperty("pathImagenesLista");
            BufferedImage img;
            if (imagen == null || imagen.isEmpty()) {
                img = ImageIO.read(new File("Recursos/Imagenes/Listas/listaDefault.png"));
            } else {
                img = ImageIO.read(new File(path + imagen));
            }
            PanelImagen pImg = new PanelImagen(img);
            imagenPanel.add(pImg);
            pImg.setBounds(0, 0, 150, 150);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen de la lista");
        }

        tablaTemas.getSelectionModel().addListSelectionListener(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTemas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblGenOnick = new javax.swing.JLabel();
        txtGenOnick = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        imagenPanel = new javax.swing.JPanel();
        btnDescargar = new javax.swing.JButton();
        btnAbrirNavegador = new javax.swing.JButton();

        setTitle("Informacion de la lista");

        tablaTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Nombre", "Duración", "Archivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTemas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaTemas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Nombre:");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lblGenOnick.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblGenOnick.setText("Gen o Nick:");

        txtGenOnick.setEditable(false);
        txtGenOnick.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenPanelLayout = new javax.swing.GroupLayout(imagenPanel);
        imagenPanel.setLayout(imagenPanelLayout);
        imagenPanelLayout.setHorizontalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        imagenPanelLayout.setVerticalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnDescargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbrirNavegador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblGenOnick)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre)
                                    .addComponent(txtGenOnick))
                                .addGap(33, 33, 33)
                                .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenOnick)
                            .addComponent(txtGenOnick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDescargar)
                    .addComponent(btnAbrirNavegador)
                    .addComponent(btnVolver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        if (tablaTemas.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe de seleccionar un tema");
            return;
        }

        String nombreTema = tablaTemas.getValueAt(tablaTemas.getSelectedRow(), 3).toString();

        //Descarga el tema seleccionado
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
            //Copia el link del tema el portapapeles
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

        String link = tablaTemas.getValueAt(tablaTemas.getSelectedRow(), 3).toString();

        //Abre el link del tema en el navegador
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirNavegador;
    private javax.swing.JButton btnDescargar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel imagenPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGenOnick;
    private javax.swing.JTable tablaTemas;
    private javax.swing.JTextField txtGenOnick;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
