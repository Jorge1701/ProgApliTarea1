package Presentacion;

import Logica.DtGenero;
import Logica.DtLista;
import Logica.DtListaDefecto;
import Logica.DtListaParticular;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class CrearListaReproduccion extends javax.swing.JInternalFrame {

    IUsuario iUsuario;
    IContenido iContenido;
    private final ArrayList<DtUsuario> clientes;
    private final JFileChooser archivoImg;
    String pathImage;
    String nameImage;
    PanelImagen pImg;
    PropertyManager pm;

    public CrearListaReproduccion() {
        initComponents();
        this.iUsuario = Fabrica.getIControladorUsuario();
        this.iContenido = Fabrica.getIControladorContenido();
        this.clientes = iUsuario.listarClientes();
        btnListaDefecto.setSelected(true);
        btnListaDefectoActionPerformed(null);
        archivoImg = new JFileChooser();
        archivoImg.setFileFilter(new FileNameExtensionFilter("Images files", "jpg", "png", "gif", "jpeg"));
        pathImage = null;
        nameImage = null;
        pm = PropertyManager.getInstance();
        cargarImagen(pm.getProperty("pathImagenesLista") + "listaDefault.png");
    }

    private void mostrar() {
        if (btnListaDefecto.isSelected()) {
            generos.setEnabled(true);
            tablaClientes.setEnabled(false);
            lblSelec.setText("Seleccione un genero y luego indique un nombre");
        } else if (btnListaParticular.isSelected()) {
            generos.setEnabled(false);
            tablaClientes.setEnabled(true);
            lblSelec.setText("Seleccione un cliente y luego indique un nombre");
        }
    }

    private DefaultMutableTreeNode getNodo(DtGenero g) {
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode(g.getNombre());
        for (DtGenero dtg : g.getSubGeneros()) {
            DefaultMutableTreeNode hijo = getNodo(dtg);
            padre.add(hijo);
        }
        return padre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnListaDefecto = new javax.swing.JRadioButton();
        btnListaParticular = new javax.swing.JRadioButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        generos = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        imagePanel = new javax.swing.JPanel();
        btnCargarImg = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblSelec = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Crear Lista de Reproducción");

        buttonGroup1.add(btnListaDefecto);
        btnListaDefecto.setText("Lista Por Defecto");
        btnListaDefecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDefectoActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnListaParticular);
        btnListaParticular.setText("Lista Particular");
        btnListaParticular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaParticularActionPerformed(evt);
            }
        });

        jSplitPane1.setDividerLocation(180);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(279);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));

        jScrollPane1.setViewportView(generos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nick", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setDragEnabled(true);
        jScrollPane2.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaClientes.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setText("Nickname:");

        txtCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtClienteCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane2.setRightComponent(jPanel2);

        jSplitPane1.setTopComponent(jSplitPane2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista"));

        jLabel1.setText("Nombre:");

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });

        imagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );

        btnCargarImg.setLabel("Cargar Imagen");
        btnCargarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(btnCargarImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnCargarImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel3);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCancelar)
                .addComponent(btnAceptar))
        );

        lblSelec.setText("Presione 'Aceptar' para confirmar los datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnListaDefecto)
                        .addGap(28, 28, 28)
                        .addComponent(btnListaParticular))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblSelec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListaDefecto)
                    .addComponent(btnListaParticular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelec)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaDefectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDefectoActionPerformed
        mostrar();
        //Carga los generos en el arbol(generos)
        generos.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DtGenero g = iContenido.listarGenero();

        DefaultTreeModel modelo = new DefaultTreeModel(getNodo(g));
        generos.setModel(modelo);
    }//GEN-LAST:event_btnListaDefectoActionPerformed

    private void btnListaParticularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaParticularActionPerformed
        mostrar();
        //Carga  los clientes en la tabla(tablaClientes)
        cargarClientes(clientes, "");
    }//GEN-LAST:event_btnListaParticularActionPerformed

    private void cargarClientes(ArrayList<DtUsuario> dtcs, String filtro) {
        // Obtiene el modelo de la tablaClientes y borra su contenido
        DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
        dtm.setRowCount(0);

        // Agrega los clientes a la tablaClientes
        for (DtUsuario dtu : dtcs) {
            if (dtu.getNickname().contains(filtro)) {
                Object[] data = {
                    dtu.getNickname(),
                    dtu.getNombre(),
                    dtu.getApellido(),
                    dtu.getEmail()
                };
                dtm.addRow(data);
            }
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nickCliente = "", nomGenero = "", camposVacios = "";
        DtLista lista;
        if (btnListaDefecto.isSelected()) {
            if (generos.getSelectionPath() == null) {
                camposVacios += "Seleccione un genero \n";
            }

            if (nombre.getText().isEmpty()) {
                camposVacios += "Ingrese un nombre \n";
            }

            if (!camposVacios.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Hay campos obligatorios vacios:\n" + camposVacios);
                return;
            }

            DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) generos.getSelectionPath().getLastPathComponent();
            nomGenero = selectedElement.getUserObject().toString();
            lista = new DtListaDefecto(iContenido.selecGenero(nomGenero), nombre.getText(), new ArrayList<>(), nameImage);   // Agregar que se ingrese la imagen en el diseño.
            System.out.println("Presentacion.CrearListaReproduccion.btnAceptarActionPerformed()"+lista.getNombre());
            if (!iContenido.crearListaReproduccion(lista, nickCliente)) {
                JOptionPane.showMessageDialog(this, "La lista que intenta ingresar ya existe", "Mensaje", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "La lista se ingresó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

        } else {

            if (tablaClientes.getSelectionModel().isSelectionEmpty()) {
                camposVacios += "Seleccione un cliente \n";
            }

            if (nombre.getText().isEmpty()) {
                camposVacios += "Ingrese un nombre \n";
            }

            if (!camposVacios.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Hay campos obligatorios vacios:\n" + camposVacios);
                return;
            }
            nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
            lista = new DtListaParticular(true, nombre.getText(), new ArrayList<>(), nameImage);
            System.out.println(lista.getNombre());// Agregar que se ingrese la imagen en el diseño.
            if (!iContenido.crearListaReproduccion(lista, nickCliente)) {
                JOptionPane.showMessageDialog(this, "La lista que intenta ingresar ya existe", "Mensaje", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "La lista se ingresó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        this.txtCliente.setText("");
        this.nombre.setText("");
        this.btnListaDefecto.setSelected(true);
        pathImage = null;
        nameImage = null;
        cargarImagen(pm.getProperty("pathImagenesLista") + "listaDefault.png");

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreKeyTyped

    private void btnCargarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImgActionPerformed
        try {
            if (archivoImg.showOpenDialog(this) == 0) {
                File arch = archivoImg.getSelectedFile();
                nameImage = arch.getName();
                pathImage = pm.getProperty("pathImagenesLista") + arch.getName();
                //if (arch != null) {
                InputStream is = new FileInputStream(arch);
                OutputStream outstream = new FileOutputStream(new File(pathImage));
                byte[] buffer = new byte[4096];
                int len;
                while ((len = is.read(buffer)) > 0) {
                    outstream.write(buffer, 0, len);
                }
                outstream.close();
                // }
            } else {
                return;
            }
        } catch (NullPointerException n) {
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la Imagen.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        cargarImagen(pathImage);
    }//GEN-LAST:event_btnCargarImgActionPerformed

    private void txtClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtClienteCaretUpdate
        cargarClientes(clientes, txtCliente.getText());
    }//GEN-LAST:event_txtClienteCaretUpdate

    private void cargarImagen(String pathImage) {
        try {
            BufferedImage img;
            img = ImageIO.read(new File(pathImage));
            pImg = new PanelImagen(img);
            imagePanel.removeAll();
            imagePanel.add(pImg);
            pImg.setBounds(0, 0, 140, 111);
        } catch (IOException ex) {
            Logger.getLogger(CrearListaReproduccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private java.awt.Button btnCargarImg;
    private javax.swing.JRadioButton btnListaDefecto;
    private javax.swing.JRadioButton btnListaParticular;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTree generos;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lblSelec;
    private javax.swing.JTextField nombre;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
