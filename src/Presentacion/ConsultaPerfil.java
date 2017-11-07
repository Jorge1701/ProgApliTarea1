package Presentacion;

import Logica.DtUsuario;
import Logica.DtPerfilArtista;
import Logica.DtPerfilCliente;
import Logica.DtPerfilUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaPerfil extends javax.swing.JInternalFrame {

    private IUsuario iUsuario;
    private String tipo;
    private ArrayList<DtUsuario> datos;

    public ConsultaPerfil(String tipo) {
        initComponents();
        setTitle(getTitle() + " " + tipo);
        this.tipo = tipo;

        iUsuario = Fabrica.getIControladorUsuario();

        if (tipo.equals("Cliente")) {
            datos = iUsuario.listarClientes();
            cargarDatos(datos, "");
        } else if (tipo.equals("Artista")) {
            datos = iUsuario.listarArtistas();
            cargarDatos(datos, "");
        }

    }

    private void cargarDatos(ArrayList<DtUsuario> dtu, String filtro) {
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consulta de Perfil");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido", "Email", "Fecha Nac."
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

        jLabel1.setText("Seleccione un usuario y presione 'Aceptar' para ver su perfil");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos obligatorio vacios:\nNickname");
            return;
        }
        if (tipo.equals("Cliente")) {
            try {
                DtPerfilUsuario dtpu = iUsuario.obtenerPerfilCliente(nickname);
                PerfilCliente pc = new PerfilCliente((DtPerfilCliente) dtpu);
                getParent().add(pc);
                centrar(pc);
                pc.show();
            } catch (UnsupportedOperationException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            try {
                DtPerfilUsuario dtpu = iUsuario.obtenerPerfilArtista(nickname);
                PerfilArtista pc = new PerfilArtista((DtPerfilArtista) dtpu);
                getParent().add(pc);
                centrar(pc);
                pc.show();
            } catch (UnsupportedOperationException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

    }

    public void centrar(JInternalFrame cpc) {
        Dimension jInternalFrameSize = cpc.getSize();
        int width = (1382 - jInternalFrameSize.width) / 2;
        int height = (634 - jInternalFrameSize.height) / 2;
        cpc.setLocation(width, height);

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNickCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNickCaretUpdate
        cargarDatos(datos, txtNick.getText());
    }//GEN-LAST:event_txtNickCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtNick;
    // End of variables declaration//GEN-END:variables
}
