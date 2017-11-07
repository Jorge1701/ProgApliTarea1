package Presentacion;

import Logica.DtCliente;
import Logica.DtFecha;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Suscripcion extends javax.swing.JInternalFrame {

    private IUsuario iUsuario;
    private ArrayList<DtUsuario> clientes;

    public Suscripcion() {
        initComponents();
        txtEstado.setSelectedIndex(0);
        iUsuario = Fabrica.getIControladorUsuario();
        clientes = iUsuario.listarClientes();
        cargarDatos(clientes, "");

    }

    private void cargarDatos(ArrayList<DtUsuario> dtu, String filtro) {
        if (dtu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun cliente registrado");
        }
       
        DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
        dtm.setRowCount(0);
        for (DtUsuario dtUsuario : dtu) {
            if (dtUsuario.getNickname().contains(filtro)) {
                if(((DtCliente)dtUsuario).getSuscripcion() != null){
                    if(((DtCliente)dtUsuario).getSuscripcion().getEstado().equals("Pendiente")){
                    Object[] data = {
                        dtUsuario.getNickname(),
                        dtUsuario.getNombre() +" "+ dtUsuario.getApellido(),
                        ((DtCliente) dtUsuario).getSuscripcion().getEstado(),
                        ((DtCliente) dtUsuario).getSuscripcion().getCuota(),
                        ((DtCliente) dtUsuario).getSuscripcion().getFecha().toString(),
                    };
                    dtm.addRow(data);
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNick = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Actualización Suscripción");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Cliente", "Estado", "Tipo de Cuota", "Fecha "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaClientes.getColumnModel().getColumn(1).setResizable(false);
            tablaClientes.getColumnModel().getColumn(2).setResizable(false);
            tablaClientes.getColumnModel().getColumn(3).setResizable(false);
            tablaClientes.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("Seleccione una suscripción y presione 'Aceptar' ");

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

        txtNick.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNickCaretUpdate(evt);
            }
        });

        jLabel2.setText("Nickname:");

        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "Vigente", "Cancelada" }));

        jLabel3.setText("Nuevo Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(4, 4, 4)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(22, 22, 22)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAceptar)
                        .addComponent(btnCancelar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tablaClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "No hay ningun usuario seleccionado");
            return;
        }

        String nickname = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
        String camposVacios = "";

        if (nickname.isEmpty()) {
            camposVacios += "Nickname \n";
        }

        if (txtEstado.getSelectedItem().equals("----")) {
            camposVacios += "Nuevo Estado \n";
        }

        if (!camposVacios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios vacios:\n" + camposVacios);
            return;
        }

        Calendar hoy = new GregorianCalendar();
        
        if (iUsuario.actualizarSuscripcion(nickname, txtEstado.getSelectedItem().toString(), new DtFecha(hoy.get(Calendar.DATE), (hoy.get(Calendar.MONTH)+1), hoy.get(Calendar.YEAR)))) {
            javax.swing.JOptionPane.showMessageDialog(null, "Suscripción actualizada correctamente", "Felicitaciones!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al actualizar la suscripción", "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        
        cargarDatos(clientes, txtNick.getText());

        DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
        dtm.setRowCount(0);

    }

    public void centrar(JInternalFrame cpc) {
        Dimension jInternalFrameSize = cpc.getSize();
        int width = (1382 - jInternalFrameSize.width) / 2;
        int height = (634 - jInternalFrameSize.height) / 2;
        cpc.setLocation(width, height);

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNickCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNickCaretUpdate
        cargarDatos(clientes, txtNick.getText());
    }//GEN-LAST:event_txtNickCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JComboBox<String> txtEstado;
    private javax.swing.JTextField txtNick;
    // End of variables declaration//GEN-END:variables
}
