package Presentacion;

import Logica.DtCliente;
import Logica.DtLista;
import Logica.DtListaDefecto;
import Logica.DtTema;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class QuitarTemaLista extends javax.swing.JInternalFrame {

    private IUsuario iUsuario;
    private IContenido iContenido;
    //private ArrayList<DtUsuario> clientes;
    String nickCliente; 

    public QuitarTemaLista() {
        initComponents();

        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();
        PestaniaMouseClicked(null);

        
        tablaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                DefaultTableModel dtm = (DefaultTableModel) tablaListParticular.getModel();
                dtm.setRowCount(0);
                DefaultTableModel dtm2 = (DefaultTableModel) tablaTemas.getModel();
                dtm2.setRowCount(0);
                cargarDatosLPListas();
            }
        });

        tablaListParticular.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaListParticular.getSelectedRow() == -1) {
                    return;
                }
                cargarTemasLPListas(tablaListParticular.getValueAt(tablaListParticular.getSelectedRow(), 0).toString());
            }
        });

        tablaListDefecto.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaListDefecto.getSelectedRow() == -1) {
                    return;
                }
                cargarTemasListaDef(tablaListDefecto.getValueAt(tablaListDefecto.getSelectedRow(), 0).toString());
            }
        });

    }

    private void cargarDatosLPListas() {

        if (tablaClientes.getSelectedRow() == -1) {
            return;
        }

        DefaultTableModel dtm = (DefaultTableModel) tablaListParticular.getModel();
        dtm.setRowCount(0);
        nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
        ArrayList<DtLista> dtListas = iUsuario.listarLisReproduccion(nickCliente);
        for (DtLista dtLista : dtListas) {

            Object[] data = {
                dtLista.getNombre()
            };
            dtm.addRow(data);

        }

    }

    private void cargarTemasLPListas(String nomLista) {

        if (tablaListParticular.getSelectedRow() == -1) {
            return;
        }

        DefaultTableModel dtm = (DefaultTableModel) tablaTemas.getModel();
        dtm.setRowCount(0);
        List<DtTema> dtTemas = iContenido.selecLista(nickCliente, nomLista);

        for (DtTema dtTema : dtTemas) {

            Object[] data = {
                dtTema.getNombre(),
                dtTema.getAlbum(),
                dtTema.getArtista(),
                dtTema.getDuracion().toString()
            };
            dtm.addRow(data);

        }
    
    }
    
    private void cargarTemasListaDef(String nomListaD){
        
        List<DtTema> dtTemas = iContenido.selecListaDef(nomListaD);
        
        DefaultTableModel dtm = (DefaultTableModel) tablaTemas.getModel();
        dtm.setRowCount(0);
        
        for (DtTema dtTema : dtTemas) {
               
                Object[] data = {
                    dtTema.getNombre(),
                    dtTema.getAlbum(),
                    dtTema.getArtista(),
                    dtTema.getDuracion().toString()
                };
                dtm.addRow(data);
            
        }
    
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TipoLista = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        Pestania = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaListParticular = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListDefecto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTemas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Quitar Tema Lista");

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

        jSplitPane2.setDividerLocation(280);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setPreferredSize(new java.awt.Dimension(559, 597));

        Pestania.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PestaniaStateChanged(evt);
            }
        });
        Pestania.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PestaniaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PestaniaMouseReleased(evt);
            }
        });

        jSplitPane3.setDividerLocation(140);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(tablaClientes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        jSplitPane3.setTopComponent(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas"));

        tablaListParticular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane2.setViewportView(tablaListParticular);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        jSplitPane3.setRightComponent(jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane3))
        );

        Pestania.addTab("Lista Particular", jPanel3);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaListDefecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Genero"
            }
        ));
        jScrollPane4.setViewportView(tablaListDefecto);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Pestania.addTab("Lista por defecto", jPanel4);

        jSplitPane2.setTopComponent(Pestania);
        Pestania.getAccessibleContext().setAccessibleName("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas"));

        tablaTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Album", "Artista", "Duracionl"
            }
        ));
        jScrollPane3.setViewportView(tablaTemas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        if (tablaTemas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un tema");
            return;
        }

        if ((tablaClientes.getSelectedRow() == -1) && (Pestania.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
            return;
        }
        if ((tablaListParticular.getSelectedRow() == -1) && (Pestania.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(this, "Seleccione una Lista");
            return;
        }
        if ((tablaListDefecto.getSelectedRow() == -1) && !(Pestania.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(this, "Seleccione una Lista");
            return;
        }
        String nomListaP = "";
        String nomListaD = "";
        String nickC = "";
        
        
        String nomTema = tablaTemas.getValueAt(tablaTemas.getSelectedRow(), 0).toString();        
        if (Pestania.getSelectedIndex() == 0) {
            nickC = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
            nomListaP = tablaListParticular.getValueAt(tablaListParticular.getSelectedRow(), 0).toString();
        } else {
            nomListaD = tablaListDefecto.getValueAt(tablaListDefecto.getSelectedRow(), 0).toString();
        }
        
        
        try {
            
            if(Pestania.getSelectedIndex() == 0){
               if(iContenido.quitarTema(nomTema,nomListaP,nickC)==false){
                    JOptionPane.showMessageDialog(this,"Error Al quitar Tema");
               }else{JOptionPane.showMessageDialog(this, "Se elimino tema correctamente");}
                cargarTemasLPListas(nomListaP);
            }else{
                if(iContenido.quitarTema(nomTema, nomListaD, null)==false){JOptionPane.showMessageDialog(this,"Error Al quitar Tema");
                }else{JOptionPane.showMessageDialog(this, "Se elimino tema correctamente");}
                cargarTemasListaDef(nomListaD);
                
            }
            
            
        } catch (Exception e) {
            System.out.println("errr");
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void PestaniaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PestaniaMouseReleased

    }//GEN-LAST:event_PestaniaMouseReleased

    private void PestaniaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PestaniaStateChanged

    }//GEN-LAST:event_PestaniaStateChanged

    private void PestaniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PestaniaMouseClicked

        if (Pestania.getSelectedIndex() == 0) {

            ArrayList<DtUsuario> dtc = iUsuario.listarClientes();

            DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
            dtm.setRowCount(0);

            for (DtUsuario dtu : dtc) {

                Object[] data = {
                    dtu.getNickname(),
                    dtu.getNombre(),
                    dtu.getApellido()
                };
                dtm.addRow(data);
            }

        } else {

            ArrayList<DtLista> dtld = iContenido.listarLisReproduccionDef();

            DefaultTableModel dtm = (DefaultTableModel) tablaListDefecto.getModel();
            dtm.setRowCount(0);
            
            DefaultTableModel dtm2 = (DefaultTableModel) tablaTemas.getModel();
            dtm2.setRowCount(0);

            for (DtLista lista : dtld) {
                Object[] data = {
                    lista.getNombre(),
                    ((DtListaDefecto) lista).getGenero().getNombre()
                };
                dtm.addRow(data);
            }
        }
    }//GEN-LAST:event_PestaniaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Pestania;
    private javax.swing.ButtonGroup TipoLista;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaListDefecto;
    private javax.swing.JTable tablaListParticular;
    private javax.swing.JTable tablaTemas;
    // End of variables declaration//GEN-END:variables
}
