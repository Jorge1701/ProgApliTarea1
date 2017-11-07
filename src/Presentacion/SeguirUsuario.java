package Presentacion;

import Logica.DtArtista;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class SeguirUsuario extends javax.swing.JInternalFrame implements ListSelectionListener {

    private final IUsuario iUsuario;
    private ArrayList<DtUsuario> dtcs;
    private String nickCliente;
    private ArrayList<DtUsuario> dtus;

    public SeguirUsuario() {
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

    private void cargarUsuarios(ArrayList<DtUsuario> usuarios, String nickCliente, String filtro) {
        DefaultTableModel dtm = (DefaultTableModel) tablaUsuarios.getModel();
        dtm.setRowCount(0);

        for (DtUsuario dtu : usuarios) {
            String nick = dtu.getNickname();
            boolean esta = false;

            for (DtUsuario d : iUsuario.listarSeguidosDe(nickCliente)) {
                if (d.getNickname() == dtu.getNickname()) {
                    esta = true;
                }
            }

            if (nick != nickCliente && !esta) {
                if (dtu.getNickname().contains(filtro)) {
                    Object[] data = {
                        nick,
                        dtu.getNombre(),
                        dtu.getApellido(),
                        dtu.getEmail(),
                        (dtu instanceof DtArtista ? "Artista" : "Cliente")
                    };
                    dtm.addRow(data);
                }
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
        tablaUsuarios = new javax.swing.JTable();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Seguir Usuario");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(250);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido", "Correo", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaUsuarios);

        txtUsuario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtUsuarioCaretUpdate(evt);
            }
        });

        jLabel3.setText("Nickname:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
        );

        jSplitPane2.setTopComponent(jPanel2);

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Al dar 'Aceptar' el cliente comenzara a seguir al usuario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonCancelar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addContainerGap())
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        getContentPane().add(jSplitPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Obtiene el nick del cliente seleccionado y se lo pasa a la funcion cliente seleccionado
        if (tablaClientes.getSelectedRow() != -1) {
            clienteSeleccionado(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString());
        }
    }

    private void clienteSeleccionado(String nickCliente) {
        this.nickCliente = nickCliente;
        txtUsuario.setText("");

        //Lista en tablaUsuarios los usuarios que el cliente nickCliente puede seguir
        dtus = iUsuario.listarUsuarios();

        cargarUsuarios(dtus, nickCliente, txtUsuario.getText());
    }

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String tablasSinSeleccionar = "";

        if (tablaClientes.getSelectionModel().isSelectionEmpty()) {
            tablasSinSeleccionar += "\nClientes";
        }

        if (tablaUsuarios.getSelectionModel().isSelectionEmpty()) {
            tablasSinSeleccionar += "\nUsuarios";
        }

        if (!tablasSinSeleccionar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila en las siguientes tablas:\n" + tablasSinSeleccionar);
            return;
        }

        String cliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
        String usuario = tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString();

        try {
            iUsuario.seguirUsuario(cliente, usuario);
            JOptionPane.showMessageDialog(this, "El cliente " + cliente + " comenzo a seguir al usuario " + usuario);
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        cargarClientes(dtcs, txtCliente.getText());

        DefaultTableModel dtm = (DefaultTableModel) tablaUsuarios.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void txtClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtClienteCaretUpdate
        cargarClientes(dtcs, txtCliente.getText());
    }//GEN-LAST:event_txtClienteCaretUpdate

    private void txtUsuarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtUsuarioCaretUpdate
        if (dtus != null) {
            cargarUsuarios(dtus, nickCliente, txtUsuario.getText());
        }
    }//GEN-LAST:event_txtUsuarioCaretUpdate


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
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
