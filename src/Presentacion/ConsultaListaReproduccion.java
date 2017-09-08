package Presentacion;

import Logica.DtGenero;
import Logica.DtLista;
import Logica.DtListaParticular;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class ConsultaListaReproduccion extends javax.swing.JInternalFrame {

    private final IUsuario iUsuario;
    private final IContenido iContenido;
    private final ArrayList<DtUsuario> clientes;

    public ConsultaListaReproduccion() {
        initComponents();

        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
        clientes = iUsuario.listarClientes();

        consultaGenero.setSelected(true);
        consultaGeneroActionPerformed(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        consultaGenero = new javax.swing.JRadioButton();
        consultaCliente = new javax.swing.JRadioButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        lblNickname = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        generos = new javax.swing.JTree();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstListasRep = new javax.swing.JList<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta de lista de reproducción");

        buttonGroup1.add(consultaGenero);
        consultaGenero.setText("Consultar por género");
        consultaGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaGeneroActionPerformed(evt);
            }
        });

        buttonGroup1.add(consultaCliente);
        consultaCliente.setText("Consultar por cliente");
        consultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaClienteActionPerformed(evt);
            }
        });

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

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane1.setDividerLocation(250);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre completo", "Nick"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setDragEnabled(true);
        jScrollPane2.setViewportView(tablaClientes);

        lblNickname.setText("Nickname:");

        txtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNickname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNickname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));

        generos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        generos.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                generosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(generos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jSplitPane2.setTopComponent(jSplitPane1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas de Reproduccion"));

        lstListasRep.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane3.setViewportView(lstListasRep);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(consultaGenero)
                        .addGap(27, 27, 27)
                        .addComponent(consultaCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnAceptar)
                        .addGap(42, 42, 42)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultaCliente)
                    .addComponent(consultaGenero))
                .addGap(18, 18, 18)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private DefaultMutableTreeNode getNodo(DtGenero g) {
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode(g.getNombre());
        for (DtGenero dtg : g.getSubGeneros()) {
            DefaultMutableTreeNode hijo = getNodo(dtg);
            padre.add(hijo);
        }
        return padre;
    }

    private void mostrar() {
        DefaultListModel<String> model = new DefaultListModel<>();
        lstListasRep.setModel(model);
        // model.removeAllElements();

        if (consultaGenero.isSelected()) {
            generos.setEnabled(true);
            tablaClientes.setEnabled(false);
            txtBuscar.setVisible(false);
            lblNickname.setVisible(false);

        } else if (consultaCliente.isSelected()) {
            tablaClientes.setEnabled(true);
            generos.setEnabled(false);
            txtBuscar.setVisible(true);
            lblNickname.setVisible(true);

        }
        repaint();
    }

    private void consultaGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaGeneroActionPerformed
        this.mostrar();
        generos.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DtGenero g = iContenido.listarGenero();
        DefaultTreeModel modelo = new DefaultTreeModel(getNodo(g));
        generos.setModel(modelo);
    }//GEN-LAST:event_consultaGeneroActionPerformed

    private void cargarDatos(ArrayList<DtUsuario> dtc, String filtro) {
        DefaultListModel<String> model = new DefaultListModel<>();
        lstListasRep.setModel(model);
        // model.removeAllElements();

        DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
        dtm.setRowCount(0);

        for (DtUsuario dtCliente : dtc) {
            if (dtCliente.getNickname().contains(filtro)) {
                Object[] data = {
                    dtCliente.getNombre() + " " + dtCliente.getApellido(),
                    dtCliente.getNickname(),};
                dtm.addRow(data);
            }
        }

        tablaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (tablaClientes.getSelectedRow() != -1) {
                    clienteSeleccionado(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 1).toString());
                }
            }
        });
    }

    private void consultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaClienteActionPerformed
        mostrar();
        cargarDatos(clientes, "");


    }//GEN-LAST:event_consultaClienteActionPerformed

    private void clienteSeleccionado(String nickCliente) {
        ArrayList<DtLista> dtl = iUsuario.listarListaReproduccionCli(nickCliente);

        DefaultListModel<String> model = new DefaultListModel<>();
        lstListasRep.setModel(model);

        for (DtLista dta : dtl) {
            //if (!((DtListaParticular) dta).isPrivada()) {                         // Descomentar para mostrar solo las listas publicas
            // model.addElement(dta.getNombre() + (((DtListaParticular) dta).isPrivada() ? " (Privada)" : ""));
            model.addElement(dta.getNombre());
            //} esto toque por el consultar
        }

    }
    private void generosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_generosValueChanged
        if (generos.getSelectionPath() != null) {
            DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) generos.getSelectionPath().getLastPathComponent();
            String generoSeleccionado = selectedElement.getUserObject().toString();

            ArrayList<DtLista> dtl = iContenido.listarLisReproduccionGen(generoSeleccionado);

            DefaultListModel<String> model = new DefaultListModel<>();
            lstListasRep.setModel(model);

            for (DtLista dta : dtl) {
                model.addElement(dta.getNombre());
            }
        }
    }//GEN-LAST:event_generosValueChanged

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nomCliente;
        String nomLista;
        DtLista lista;

        if (consultaGenero.isSelected()) {
            if (generos.getSelectionPath() == null) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Genero");
                return;
            } else {
                DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) generos.getSelectionPath().getLastPathComponent();
                String generoSeleccionado = selectedElement.getUserObject().toString();
                nomLista = lstListasRep.getSelectedValue();

                if (nomLista == null) {
                    JOptionPane.showMessageDialog(this, "Debe de seleccionar una Lista");
                    return;
                } else {
                    try {
                        lista = iContenido.selecListGen(nomLista);
                        ListaReproduccionContenido l = new ListaReproduccionContenido(lista, generoSeleccionado);
                        this.getParent().add(l);
                        centrar(l);
                        l.show();
                    } catch (UnsupportedOperationException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
        } else if (consultaCliente.isSelected()) {
            if (tablaClientes.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Cliente");
                return;
            } else {
                nomLista = lstListasRep.getSelectedValue();

                if (nomLista == null) {
                    JOptionPane.showMessageDialog(this, "Debe de seleccionar una Lista");
                    return;
                } else {
                    nomCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString() + " (" + tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 1).toString() + ")";
                    try {
                        lista = iUsuario.selectListaCli(nomLista);
                        ListaReproduccionContenido l = new ListaReproduccionContenido(lista, nomCliente);
                        this.getParent().add(l);
                        centrar(l);
                        l.show();
                    } catch (UnsupportedOperationException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }

    }//GEN-LAST:event_btnAceptarActionPerformed
    }

    public void centrar(JInternalFrame cpc) {
        Dimension jInternalFrameSize = cpc.getSize();
        int width = (1382 - jInternalFrameSize.width) / 2;
        int height = (634 - jInternalFrameSize.height) / 2;
        cpc.setLocation(width, height);

    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        cargarDatos(clientes, txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JRadioButton consultaCliente;
    public static javax.swing.JRadioButton consultaGenero;
    private javax.swing.JTree generos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JList<String> lstListasRep;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
