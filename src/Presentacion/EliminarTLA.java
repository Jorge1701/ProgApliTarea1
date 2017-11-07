package Presentacion;

import Logica.DtAlbum;
import Logica.DtLista;
import Logica.DtListaParticular;
import Logica.DtTema;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class EliminarTLA extends javax.swing.JInternalFrame {

    private IUsuario iUsuario;
    private ArrayList<DtUsuario> clientes;

    public EliminarTLA() {
        initComponents();

        iUsuario = Fabrica.getIControladorUsuario();

        clientes = iUsuario.listarClientes();

        cargarDatosClientes(clientes, "");

        tablaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                cargarAlbumesFav();
                cargarListasFav();
                cargarTemasFav();
            }
        });
    }

    private void cargarDatosClientes(ArrayList<DtUsuario> dtu, String filtro) {
        if (dtu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun cliente registrado");
        }

        DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
        dtm.setRowCount(0);
        for (DtUsuario dtUsuario : dtu) {
            if (dtUsuario.getNickname().contains(filtro)) {
                Object[] data = {
                    dtUsuario.getNickname(),
                    dtUsuario.getNombre(),
                    dtUsuario.getApellido(),
                    dtUsuario.getEmail(),
                    dtUsuario.getFechaNac().toString()
                };
                dtm.addRow(data);
            }
        }
    }

    private void cargarAlbumesFav() {
        if (tablaClientes.getSelectedRow() == -1) {
            return;
        }

        String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();

        ArrayList<DtAlbum> dtAlbums = iUsuario.obtenerAlbumesFav(nickCliente);
        DefaultTableModel dtm = (DefaultTableModel) tablaAlbumes.getModel();
        dtm.setRowCount(0);
        for (DtAlbum dtAlbum : dtAlbums) {
            if (dtAlbum.getNombre().contains(txtAlbum.getText())) {
                Object[] data = {
                    dtAlbum.getNickArtista(),
                    dtAlbum.getNombre(),
                    dtAlbum.getAnio()
                };
                dtm.addRow(data);
            }
        }
    }

    private void cargarListasFav() {
        if (tablaClientes.getSelectedRow() == -1) {
            return;
        }

        String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();

        ArrayList<DtLista> dtListas = iUsuario.obtenerListasFav(nickCliente);
        DefaultTableModel dtm2 = (DefaultTableModel) tablaListas.getModel();
        dtm2.setRowCount(0);
        for (DtLista dtLista : dtListas) {
            if (dtLista.getNombre().contains(txtLista.getText())) {
                Object[] data = {
                    dtLista.getNombre(),
                    dtLista instanceof DtListaParticular ? "Particular" : "Defecto"
                };
                dtm2.addRow(data);
            }
        }
    }

    private void cargarTemasFav() {
        if (tablaClientes.getSelectedRow() == -1) {
            return;
        }

        String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();

        ArrayList<DtTema> dtTemas = iUsuario.obtenerTemasFav(nickCliente);
        DefaultTableModel dtm3 = (DefaultTableModel) tablaTemas.getModel();
        dtm3.setRowCount(0);
        for (DtTema dtTema : dtTemas) {
            if (dtTema.getNombre().contains(txtTema.getText())) {
                Object[] data = {
                    dtTema.getNombre(),
                    dtTema.getDuracion().getMinutos() + ":" + dtTema.getDuracion().getSegundos()
                };
                dtm3.addRow(data);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        txtClientes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListas = new javax.swing.JTable();
        txtLista = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnEliminarLista = new javax.swing.JButton();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlbumes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtAlbum = new javax.swing.JTextField();
        btnEliminarAlbum = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTemas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtTema = new javax.swing.JTextField();
        btnEliminarTema = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Eliminar un favorito");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane1.setDividerLocation(500);

        jSplitPane2.setDividerLocation(310);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaClientes.getColumnModel().getColumn(1).setResizable(false);
            tablaClientes.getColumnModel().getColumn(2).setResizable(false);
            tablaClientes.getColumnModel().getColumn(3).setResizable(false);
        }

        txtClientes.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtClientesCaretUpdate(evt);
            }
        });

        jLabel1.setText("Nickname:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 282, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setTopComponent(jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas Favoritas"));

        tablaListas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaListas);
        if (tablaListas.getColumnModel().getColumnCount() > 0) {
            tablaListas.getColumnModel().getColumn(0).setResizable(false);
            tablaListas.getColumnModel().getColumn(1).setResizable(false);
        }

        txtLista.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtListaCaretUpdate(evt);
            }
        });

        jLabel3.setText("Lista:");

        btnEliminarLista.setText("Eliminar");
        btnEliminarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLista, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarLista, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarLista)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel3);

        jSplitPane1.setLeftComponent(jSplitPane2);

        jSplitPane3.setDividerLocation(310);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Albumes Favoritos"));

        tablaAlbumes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickartista", "Nombre", "Anio"
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
        jScrollPane1.setViewportView(tablaAlbumes);
        if (tablaAlbumes.getColumnModel().getColumnCount() > 0) {
            tablaAlbumes.getColumnModel().getColumn(0).setResizable(false);
            tablaAlbumes.getColumnModel().getColumn(1).setResizable(false);
            tablaAlbumes.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setText("Album:");

        txtAlbum.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAlbumCaretUpdate(evt);
            }
        });

        btnEliminarAlbum.setText("Eliminar");
        btnEliminarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlbumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminarAlbum))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarAlbum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane3.setTopComponent(jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas Favoritos"));

        tablaTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Duracion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTemas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaTemas);
        if (tablaTemas.getColumnModel().getColumnCount() > 0) {
            tablaTemas.getColumnModel().getColumn(0).setResizable(false);
            tablaTemas.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel4.setText("Tema:");

        txtTema.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTemaCaretUpdate(evt);
            }
        });

        btnEliminarTema.setText("Eliminar");
        btnEliminarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTema, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminarTema)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarTema)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane3.setRightComponent(jPanel4);

        jSplitPane1.setRightComponent(jSplitPane3);

        getContentPane().add(jSplitPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClientesCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtClientesCaretUpdate
        cargarDatosClientes(clientes, txtClientes.getText());
    }//GEN-LAST:event_txtClientesCaretUpdate

    private void txtAlbumCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAlbumCaretUpdate
        cargarAlbumesFav();
    }//GEN-LAST:event_txtAlbumCaretUpdate

    private void txtListaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtListaCaretUpdate
        cargarListasFav();
    }//GEN-LAST:event_txtListaCaretUpdate

    private void txtTemaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTemaCaretUpdate
        cargarTemasFav();
    }//GEN-LAST:event_txtTemaCaretUpdate

    private void btnEliminarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlbumActionPerformed
        if (tablaClientes.getSelectedRow() == -1) {
            return;
        }

        if (tablaAlbumes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "No hay ningun tema seleccionado");
            return;
        }

        try {
            String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
            iUsuario.eliminarAlbumFav(nickCliente, tablaAlbumes.getSelectedRow());
            cargarAlbumesFav();
            JOptionPane.showMessageDialog(this, "Se borro el album de favoritos");
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarAlbumActionPerformed

    private void btnEliminarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarListaActionPerformed
        if (tablaClientes.getSelectedRow() == -1) {
            return;
        }

        if (tablaListas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "No hay ningun tema seleccionado");
            return;
        }

        try {
            String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
            iUsuario.eliminarListaFav(nickCliente, tablaListas.getSelectedRow());
            cargarListasFav();
            JOptionPane.showMessageDialog(this, "Se borro la lista de favoritos");
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarListaActionPerformed

    private void btnEliminarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTemaActionPerformed
        if (tablaClientes.getSelectedRow() == -1) {
            return;
        }

        if (tablaTemas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "No hay ningun tema seleccionado");
            return;
        }

        try {
            String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
            iUsuario.eliminarTemaFav(nickCliente, tablaTemas.getSelectedRow());
            cargarTemasFav();
            JOptionPane.showMessageDialog(this, "Se borro el tema de favoritos");
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarTemaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarAlbum;
    private javax.swing.JButton btnEliminarLista;
    private javax.swing.JButton btnEliminarTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTable tablaAlbumes;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaListas;
    private javax.swing.JTable tablaTemas;
    private javax.swing.JTextField txtAlbum;
    private javax.swing.JTextField txtClientes;
    private javax.swing.JTextField txtLista;
    private javax.swing.JTextField txtTema;
    // End of variables declaration//GEN-END:variables
}
