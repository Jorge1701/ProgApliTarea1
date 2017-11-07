package Presentacion;

import Logica.DtGenero;
import Logica.Fabrica;
import Logica.IContenido;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class AltaGenero extends javax.swing.JInternalFrame {

    IContenido iContenido;

    public AltaGenero() {
        initComponents();
        iContenido = Fabrica.getIControladorContenido();
        cargarArbol();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btncancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        generos = new javax.swing.JTree();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Alta de género");

        jLabel1.setText("Nombre:");

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(generos);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(26, 26, 26)
                        .addComponent(btncancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void cargarArbol() {
        generos.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DtGenero g = iContenido.listarGenero();

        DefaultTreeModel modelo = new DefaultTreeModel(getNodo(g));
        generos.setModel(modelo);

    }

    private DefaultMutableTreeNode getNodo(DtGenero g) {
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode(g.getNombre());
        for (DtGenero dtg : g.getSubGeneros()) {
            DefaultMutableTreeNode hijo = getNodo(dtg);
            padre.add(hijo);
        }
        return padre;
    }

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nomGenero = "";
        String nomPadre = "";
        /*if (generos.getSelectionPath() == null) {
            JOptionPane.showMessageDialog(this, "Debe de seleccionar un genero donde ingresar el nuevo");
            return;
        }*/

        if ("".equals(txtNombre.getText())) {
            JOptionPane.showMessageDialog(this, "Debe de ingresar el nombre del genero");
            return;
        }

        if (generos.getSelectionPath() != null) {
            DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) generos.getSelectionPath().getLastPathComponent();
            nomPadre = selectedElement.getUserObject().toString();
        } else {
            if (JOptionPane.showConfirmDialog(this, "Como no ha seleccionado ningun genero donde ingresar el nuevo, el mismo se ingresará en el género principal, ¿desea continuar?", "Confirmación", 0) == 0) {
                nomPadre = "Géneros";
            } else {
                return;
            }

        }

        nomGenero = txtNombre.getText();

        try {
            iContenido.ingresarGenero(nomGenero, nomPadre);
            JOptionPane.showMessageDialog(this, "Genero ingresado con exito");
            cargarArbol();
            txtNombre.setText("");
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JTree generos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
