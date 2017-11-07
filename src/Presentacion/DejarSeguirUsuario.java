package Presentacion;

import Logica.DtCliente;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DejarSeguirUsuario extends javax.swing.JInternalFrame implements ListSelectionListener {

    private IUsuario iUsuario;
    private ArrayList<DtUsuario> dtcs;
    private String nickUsuario;
    private ArrayList<DtUsuario> dtss;

    public DejarSeguirUsuario() {
        initComponents();
        iUsuario = Fabrica.getIControladorUsuario();

        // Obtiene todo los clientes
        dtcs = iUsuario.listarClientes();

        cargarClientes(dtcs, "");

        // Hace que al hacer click en una fila de la tablaClientes se llame al metodo valueChanged()
        tablaClientes.getSelectionModel().addListSelectionListener(this);
    }

    private void cargarClientes(ArrayList<DtUsuario> dtcs, String filtro) {
        // Obtiene el modelo de la tablaClientes y borra su contenido
        DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
        dtm.setRowCount(0);

        // Agrega los clientes a la tablaClientes
        for (DtUsuario dtc : dtcs) {
            if (dtc.getNickname().contains(filtro)) {
                Object[] data = {
                    dtc.getNickname(),
                    dtc.getNickname(),
                    dtc.getApellido(),
                    dtc.getEmail(),};
                dtm.addRow(data);
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Obtiene el nick del cliente seleccionado y se lo pasa a la funcion cliente seleccionado
        if (tablaClientes.getSelectedRow() != -1) {
            usuarioSeleccionado(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString());
        }
    }

    private void usuarioSeleccionado(String nickUsuario) {
        txtSeguido.setText("");
        // Se obtienen los seguidores de nickUsuario
        dtss = iUsuario.listarSeguidosDe(nickUsuario);

        cargarSeguidos(dtss, txtSeguido.getText());
    }

    private void cargarSeguidos(ArrayList<DtUsuario> seguidos, String filtro) {
        // Si no tiene seguidores se muestra un mensaje
        if (seguidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El usuario " + nickUsuario + " no tiene seguidores");
            return;
        }

        // Obtiene el modelo de la tablaSeguidores y borra su contenido
        DefaultTableModel dtm = (DefaultTableModel) tablaSeguidos.getModel();
        dtm.setRowCount(0);

        // Agrega los seguidores a la tablaSeguidores
        for (DtUsuario seguido : seguidos) {
            if (seguido.getNickname().contains(filtro)) {
                Object[] data = {
                    seguido.getNickname(),
                    seguido.getNickname(),
                    seguido.getApellido(),
                    seguido.getEmail(),
                    (seguido instanceof DtCliente ? "Cliente" : "Artista")
                };
                dtm.addRow(data);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSeguidos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtSeguido = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Dejar de Seguir Usuario");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(250);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seguidos"));

        tablaSeguidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido", "Correo", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaSeguidos);

        jLabel3.setText("Nickname:");

        txtSeguido.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSeguidoCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSeguido, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSeguido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
        );

        jSplitPane2.setTopComponent(jPanel2);

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Al dar 'Aceptar' el seguidor va a dejar de seguir al usuario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCancelar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonAceptar)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel3);

        jSplitPane1.setBottomComponent(jSplitPane2);

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
        jScrollPane1.setViewportView(tablaClientes);

        txtCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtClienteCaretUpdate(evt);
            }
        });

        jLabel2.setText("Nickname:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        getContentPane().add(jSplitPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String tablasSinSeleccionar = "";

        if (tablaClientes.getSelectionModel().isSelectionEmpty()) {
            tablasSinSeleccionar += "\nClientes";
        }

        if (tablaSeguidos.getSelectionModel().isSelectionEmpty()) {
            tablasSinSeleccionar += "\nSeguidos";
        }

        if (!tablasSinSeleccionar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila en las siguientes tablas:\n" + tablasSinSeleccionar);
            return;
        }

        String cliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
        String seguido = tablaSeguidos.getValueAt(tablaSeguidos.getSelectedRow(), 0).toString();

        try {
            iUsuario.dejarSeguirUsuario(cliente, seguido);
            JOptionPane.showMessageDialog(this, "El cliente " + cliente + " dejo de seguir al usuario " + seguido);
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        cargarClientes(dtcs, txtCliente.getText());

        DefaultTableModel dtm = (DefaultTableModel) tablaSeguidos.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void txtClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtClienteCaretUpdate
        cargarClientes(dtcs, txtCliente.getText());
    }//GEN-LAST:event_txtClienteCaretUpdate

    private void txtSeguidoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSeguidoCaretUpdate
        if (dtss != null) {
            cargarSeguidos(dtss, txtSeguido.getText());
        }
    }//GEN-LAST:event_txtSeguidoCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaSeguidos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtSeguido;
    // End of variables declaration//GEN-END:variables
}
