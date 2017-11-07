package Presentacion;

import Logica.Fabrica;
import Logica.IContenido;
import javax.swing.JOptionPane;
import Logica.DtArtista;
import Logica.DtLista;
import Logica.DtListaParticular;
import Logica.DtUsuario;
import Logica.IUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class PublicarLista extends javax.swing.JInternalFrame implements ListSelectionListener {

    private final IContenido iContenido;
    private final IUsuario iUsuario;
    private final ArrayList<DtUsuario> clientes;

    public PublicarLista() {
        initComponents();
        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
        clientes = iUsuario.listarClientes();
        cargarClientes(clientes, "");
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

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Obtiene el nick del cliente seleccionado y se lo pasa a la funcion cliente seleccionado
        if (tablaClientes.getSelectedRow() != -1) {
            clienteSeleccionado(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString(), "");
        }
    }

    private void clienteSeleccionado(String nickCliente, String filtro) {
        //Lista en tablaUsuarios los usuarios que el cliente nickCliente puede seguir
        ArrayList<DtLista> listas = iUsuario.listarLisReproduccion(nickCliente);

        DefaultTableModel dtm = (DefaultTableModel) tablaListas.getModel();
        dtm.setRowCount(0);

        for (DtLista dtl : listas) {
            if (dtl.getNombre().contains(filtro) && ((DtListaParticular) dtl).isPrivada()) {
                Object[] data = {
                    dtl.getNombre(),};
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
        tablaListas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtLista = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Publicar lista");
        setPreferredSize(new java.awt.Dimension(555, 580));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(230);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas"));

        tablaListas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaListas);
        if (tablaListas.getColumnModel().getColumnCount() > 0) {
            tablaListas.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel3.setText("Nombre:");

        txtLista.setPreferredSize(new java.awt.Dimension(6, 20));
        txtLista.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtListaCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLista, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel1.setText("Al dar 'Aceptar' el cliente hace pública dicha lista");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCancelar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addContainerGap())
        );

        jSplitPane2.setBottomComponent(jPanel3);

        jSplitPane1.setBottomComponent(jSplitPane2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido", "Correo"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        jLabel2.setText("Nickname:");

        txtCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtClienteCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        getContentPane().add(jSplitPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String tablasSinSeleccionar = "";

        if (tablaClientes.getSelectionModel().isSelectionEmpty()) {
            tablasSinSeleccionar += "\nClientes";
        }

        if (tablaListas.getSelectionModel().isSelectionEmpty()) {
            tablasSinSeleccionar += "\nListas";
        }

        if (!tablasSinSeleccionar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila en las siguientes tablas:\n" + tablasSinSeleccionar);
            return;
        }

        String cliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
        String lista = tablaListas.getValueAt(tablaListas.getSelectedRow(), 0).toString();

        try {
            iContenido.publicarLista(cliente, lista);
            JOptionPane.showMessageDialog(this, "La lista " + lista + "del cliente " + cliente + "se hizo pública");
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        cargarClientes(clientes, "");

        DefaultTableModel dtm = (DefaultTableModel) tablaListas.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void txtClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtClienteCaretUpdate
        cargarClientes(clientes, txtCliente.getText());
    }//GEN-LAST:event_txtClienteCaretUpdate

    private void txtListaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtListaCaretUpdate
        if (tablaClientes.getSelectedRow() != -1) {
            clienteSeleccionado(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString(), txtLista.getText());
        }
    }//GEN-LAST:event_txtListaCaretUpdate


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
    private javax.swing.JTable tablaListas;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtLista;
    // End of variables declaration//GEN-END:variables
}
