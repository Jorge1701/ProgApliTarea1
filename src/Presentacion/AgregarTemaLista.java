/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Artista;
import Logica.DtAlbum;
import Logica.DtLista;
import Logica.DtTema;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import Logica.Tema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brian
 */
public class AgregarTemaLista extends javax.swing.JInternalFrame {

    private IContenido iContenido;
    private IUsuario iUsuario;
    private ArrayList<DtUsuario> clientes;
    private ArrayList<DtUsuario> artistas;

    private String nickArtista;
    private ArrayList<DtLista> listasPorDefecto;
    private ArrayList<DtUsuario> listaDeUsuarios;

    /**
     * Creates new form BuscarTema
     */
    public AgregarTemaLista() {
        initComponents();
        iContenido = Fabrica.getIControladorContenido();
        iUsuario = Fabrica.getIControladorUsuario();
        clientes = iUsuario.listarClientes();
        artistas = iUsuario.listarArtistas();
        listasPorDefecto = iContenido.listarLisReproduccionDef();

        PestaniaMouseClicked(null);

        cargarDatosUsuarios(clientes, nombreUsuario.getText());
        cargarDatosListaDefectoFinal(listasPorDefecto, nombreListaDefectoFinal.getText());
        tablaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaClientes.getSelectedRow() == -1) {
                    return;
                }
                cargarDatosListaP(iUsuario.listarListaReproduccionCli(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()), nombreCliente.getText());
            }
        });
        tablaArtistas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaArtistas.getSelectedRow() == -1) {
                    return;
                }
                cargarDatosAlbumes(iUsuario.listarAlbumesArtista(tablaArtistas.getValueAt(tablaArtistas.getSelectedRow(), 0).toString()), nombreArtistas.getText());
            }
        });
        tablaListaDeAlbumes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaListaDeAlbumes.getSelectedRow() == -1) {
                    return;
                }
                cargarDatosTemaAlbum(iContenido.listarTemas(tablaListaDeAlbumes.getValueAt(tablaListaDeAlbumes.getSelectedRow(), 0).toString(), iUsuario.selectArtista(tablaArtistas.getValueAt(tablaArtistas.getSelectedRow(), 0).toString()).getNickname()), nombreTema.getText());
            }
        });

        tablaListaPordefecto.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaListaPordefecto.getSelectedRow() == -1) {
                    return;
                }
                cargarDatosTemaL(iContenido.listarTemasLD(tablaListaPordefecto.getValueAt(tablaListaPordefecto.getSelectedRow(), 0).toString()), nombreTema.getText());
            }
        });
        nombresDeUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (nombresDeUsuarios.getSelectedRow() == -1) {
                    return;
                }
                cargarDatosListaCliente(iUsuario.listarListaReproduccionCli(nombresDeUsuarios.getValueAt(nombresDeUsuarios.getSelectedRow(), 0).toString()), nombreDeListaFinal.getText());
            }
        });
        tablaListaParticular.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaListaParticular.getSelectedRow() == -1) {
                    return;
                }
                cargarDatosTemaL(iContenido.listarTemasP(tablaListaParticular.getValueAt(tablaListaParticular.getSelectedRow(), 0).toString(), tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()), nombreTema.getText());
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablaListaTema = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nombreTema = new javax.swing.JTextField();
        agregar = new javax.swing.JToggleButton();
        cancelar = new javax.swing.JToggleButton();
        Pestania2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        nombresDeUsuarios = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        ListadeListasParticulares = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        nombreDeListaFinal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaFinalPorDefecto = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        nombreListaDefectoFinal = new javax.swing.JTextField();
        Pestania = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaListaParticular = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        nombreCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        nombreListaP = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListaPordefecto = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        nombreListaD = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaListaDeAlbumes = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaArtistas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        nombreArtistas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel5);

        jSplitPane2.setDividerLocation(280);

        tablaListaTema.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(tablaListaTema);
        if (tablaListaTema.getColumnModel().getColumnCount() > 0) {
            tablaListaTema.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel2.setText("Nombre Del Tema A Agregar");

        nombreTema.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreTemaCaretUpdate(evt);
            }
        });

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nombreTema, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(nombreTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(jPanel1);

        nombresDeUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nick ", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(nombresDeUsuarios);
        if (nombresDeUsuarios.getColumnModel().getColumnCount() > 0) {
            nombresDeUsuarios.getColumnModel().getColumn(0).setResizable(false);
            nombresDeUsuarios.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel8.setText("Nombre De Usuario");

        nombreUsuario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreUsuarioCaretUpdate(evt);
            }
        });

        ListadeListasParticulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre De Lista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(ListadeListasParticulares);
        if (ListadeListasParticulares.getColumnModel().getColumnCount() > 0) {
            ListadeListasParticulares.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel4.setText("Nombre de Lista al cual se le agregara");

        nombreDeListaFinal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreDeListaFinalCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreDeListaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreDeListaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        Pestania2.addTab("Lista Particular", jPanel3);

        listaFinalPorDefecto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(listaFinalPorDefecto);
        if (listaFinalPorDefecto.getColumnModel().getColumnCount() > 0) {
            listaFinalPorDefecto.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel9.setText("Nombre de Lista al cual se le agregara");

        nombreListaDefectoFinal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreListaDefectoFinalCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreListaDefectoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(nombreListaDefectoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Pestania2.addTab("Lista Por Defecto", jPanel4);

        jSplitPane2.setRightComponent(Pestania2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        jSplitPane1.setRightComponent(jPanel2);

        Pestania.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PestaniaMouseClicked(evt);
            }
        });

        tablaListaParticular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre De Lista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaListaParticular);
        if (tablaListaParticular.getColumnModel().getColumnCount() > 0) {
            tablaListaParticular.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel5.setText("Nombre Del Dueño De La Lista");

        nombreCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreClienteCaretUpdate(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NickName", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaClientes.getColumnModel().getColumn(1).setResizable(false);
            tablaClientes.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel6.setText("Nombre De Lista");

        nombreListaP.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreListaPCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(72, 72, 72)
                        .addComponent(nombreListaP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nombreListaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        Pestania.addTab("Listas Particular", jPanel7);

        tablaListaPordefecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre De Lista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaListaPordefecto);
        if (tablaListaPordefecto.getColumnModel().getColumnCount() > 0) {
            tablaListaPordefecto.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel3.setText("Nombre De Lista");

        nombreListaD.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreListaDCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addComponent(nombreListaD, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreListaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
        );

        Pestania.addTab("Listas Por Defecto", jPanel8);

        tablaListaDeAlbumes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre De Album"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaListaDeAlbumes);
        if (tablaListaDeAlbumes.getColumnModel().getColumnCount() > 0) {
            tablaListaDeAlbumes.getColumnModel().getColumn(0).setResizable(false);
        }

        tablaArtistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nickname", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(tablaArtistas);
        if (tablaArtistas.getColumnModel().getColumnCount() > 0) {
            tablaArtistas.getColumnModel().getColumn(0).setResizable(false);
            tablaArtistas.getColumnModel().getColumn(1).setResizable(false);
            tablaArtistas.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel7.setText("Nombre de artista");

        jLabel1.setText("Nombre De Album");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nombreArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Pestania.addTab("Albumes", jPanel9);

        jSplitPane1.setLeftComponent(Pestania);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PestaniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PestaniaMouseClicked
        if (Pestania.getSelectedIndex() == 0) {
            cargarDatosClientes(clientes, nombreCliente.getText());
        } else if (Pestania.getSelectedIndex() == 1) {
            cargarDatosListaD(listasPorDefecto, nombreListaD.getText());

        } else if (Pestania.getSelectedIndex() == 2) {
            cargarDatosArtistas(artistas, nombreArtistas.getText());

        }
    }//GEN-LAST:event_PestaniaMouseClicked

    private void nombreClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreClienteCaretUpdate
        cargarDatosClientes(clientes, nombreCliente.getText());
    }//GEN-LAST:event_nombreClienteCaretUpdate

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarActionPerformed

    private void nombreListaPCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreListaPCaretUpdate
        if (tablaClientes.getSelectedRow() != -1) {
            cargarDatosListaP(iUsuario.listarListaReproduccionCli(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()), nombreCliente.getText());
        }
    }//GEN-LAST:event_nombreListaPCaretUpdate

    private void nombreListaDCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreListaDCaretUpdate
        cargarDatosListaD(listasPorDefecto, nombreListaD.getText());
    }//GEN-LAST:event_nombreListaDCaretUpdate

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked

    }//GEN-LAST:event_tablaClientesMouseClicked

    private void nombreTemaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreTemaCaretUpdate
        if (Pestania.getSelectedIndex() == 0) {
            if (tablaListaParticular.getSelectedRow() != -1) {
                cargarDatosTemaL(iContenido.listarTemasP(tablaListaParticular.getValueAt(tablaListaParticular.getSelectedRow(), 0).toString(), tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()), nombreTema.getText());
            }
        } else if (Pestania.getSelectedIndex() == 1) {
            if (tablaListaPordefecto.getSelectedRow() != -1) {
                cargarDatosTemaL(iContenido.listarTemasLD(tablaListaPordefecto.getValueAt(tablaListaPordefecto.getSelectedRow(), 0).toString()), nombreTema.getText());
            }
        } else {
            if (tablaListaDeAlbumes.getSelectedRow() != -1) {
                cargarDatosTemaAlbum(iContenido.listarTemas(tablaListaDeAlbumes.getValueAt(tablaListaDeAlbumes.getSelectedRow(), 0).toString(), iUsuario.selectArtista(tablaArtistas.getValueAt(tablaArtistas.getSelectedRow(), 0).toString()).getNickname()), nombreTema.getText());
            }
        }

    }//GEN-LAST:event_nombreTemaCaretUpdate

    private void nombreUsuarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreUsuarioCaretUpdate
        cargarDatosUsuarios(clientes, nombreUsuario.getText());

    }//GEN-LAST:event_nombreUsuarioCaretUpdate

    private void nombreDeListaFinalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreDeListaFinalCaretUpdate
        if (nombresDeUsuarios.getSelectedRow() != -1) {
            cargarDatosListaCliente(iUsuario.listarListaReproduccionCli(nombresDeUsuarios.getValueAt(nombresDeUsuarios.getSelectedRow(), 0).toString()), nombreDeListaFinal.getText());
        }
    }//GEN-LAST:event_nombreDeListaFinalCaretUpdate

    private void nombreListaDefectoFinalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreListaDefectoFinalCaretUpdate
        cargarDatosListaDefectoFinal(listasPorDefecto, nombreListaDefectoFinal.getText());
    }//GEN-LAST:event_nombreListaDefectoFinalCaretUpdate

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        String nombreLista = "";
        String nombreUsuario = "";

        if (Pestania.getSelectedIndex() == 0 && Pestania2.getSelectedIndex() == 0) {
            if (tablaClientes.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente");
                return;
            }
            if (tablaListaParticular.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una Lista");
                return;
            }
            if (tablaListaTema.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un tema");
                return;
            }
            if (nombresDeUsuarios.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una cliente");
                return;
            }
            if (ListadeListasParticulares.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una Lista");
                return;
            }

        }

        if (Pestania.getSelectedIndex() == 0 && Pestania2.getSelectedIndex() == 1) {
            if (tablaClientes.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente");
                return;
            }
            if (tablaListaParticular.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una Lista");
                return;
            }
            if (tablaListaTema.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un tema");
                return;
            }
            if (listaFinalPorDefecto.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una Lista");
                return;
            }
        }

        if (Pestania.getSelectedIndex() == 1 && Pestania2.getSelectedIndex() == 0) {
            if (tablaListaPordefecto.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una Lista");
                return;
            }
            if (tablaListaTema.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un tema");
                return;
            }
            if (nombresDeUsuarios.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una cliente");
                return;
            }
            if (ListadeListasParticulares.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una Lista");
                return;
            }

        }

        if (Pestania.getSelectedIndex() == 1 && Pestania2.getSelectedIndex() == 1) {
            if (tablaListaPordefecto.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una Lista");
                return;
            }
            if (tablaListaTema.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un tema");
                return;
            }

            if (listaFinalPorDefecto.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una Lista");
                return;
            }

        }

        if (Pestania.getSelectedIndex() == 2 && Pestania2.getSelectedIndex() == 0) {
            if (tablaArtistas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un artista");
                return;
            }

            if (tablaListaDeAlbumes.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un álbum");
                return;
            }
            if (tablaListaTema.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un tema");
                return;
            }

            if (nombresDeUsuarios.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente");
                return;
            }
            if (ListadeListasParticulares.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una lista");
                return;
            }
        }

        if (Pestania.getSelectedIndex() == 2 && Pestania2.getSelectedIndex() == 1) {
            if (tablaArtistas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un artista");
                return;
            }

            if (tablaListaDeAlbumes.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un álbum");
                return;
            }
            if (tablaListaTema.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un tema");
                return;
            }
            if (listaFinalPorDefecto.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una Lista");
                return;
            }
        }

        String nombreTema = tablaListaTema.getValueAt(tablaListaTema.getSelectedRow(), 0).toString();
        if (Pestania2.getSelectedIndex() == 0) {
            nombreUsuario = nombresDeUsuarios.getValueAt(nombresDeUsuarios.getSelectedRow(), 0).toString();
            nombreLista = ListadeListasParticulares.getValueAt(ListadeListasParticulares.getSelectedRow(), 0).toString();
        } else {
            nombreLista = listaFinalPorDefecto.getValueAt(listaFinalPorDefecto.getSelectedRow(), 0).toString();
        }
        if (Pestania.getSelectedIndex() == 0) {
            String duenio = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
            String listadeDuenio = tablaListaParticular.getValueAt(tablaListaParticular.getSelectedRow(), 0).toString();

            if (iContenido.agregarDeListasParticularesTema(nombreTema, nombreLista, nombreUsuario, duenio, listadeDuenio) == false) {
                JOptionPane.showMessageDialog(this, "El Tema Ya Existe En Esta Lista");
            } else {
                JOptionPane.showMessageDialog(this, "Tema Agregado Con Exito");
            }
        } else if (Pestania.getSelectedIndex() == 1) {
            String listaDefecto = tablaListaPordefecto.getValueAt(tablaListaPordefecto.getSelectedRow(), 0).toString();
            if (iContenido.agregarDeListasDefectoTema(nombreTema, nombreLista, nombreUsuario, listaDefecto) == false) {
                JOptionPane.showMessageDialog(this, "El Tema Ya Existe En Esta Lista");
            } else {
                JOptionPane.showMessageDialog(this, "Tema Agregado Con Exito");
            }
        } else {
            String artista = tablaArtistas.getValueAt(tablaArtistas.getSelectedRow(), 0).toString();
            String album = tablaListaDeAlbumes.getValueAt(tablaListaDeAlbumes.getSelectedRow(), 0).toString();
            if (iContenido.agregarDeAlbumTema(nombreTema, nombreLista, nombreUsuario, artista, album) == false) {
                JOptionPane.showMessageDialog(this, "El Tema Ya Existe En Esta Lista");
            } else {
                JOptionPane.showMessageDialog(this, "Tema Agregado Con Exito");
            }
        }


    }//GEN-LAST:event_agregarActionPerformed

    private void cargarDatosListaDefectoFinal(ArrayList<DtLista> dtl, String filtro) {
        if (dtl.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ninguna lista registrado");
        }

        DefaultTableModel tabla = (DefaultTableModel) listaFinalPorDefecto.getModel();
        tabla.setRowCount(0);
        for (DtLista dtLista : dtl) {
            if (dtLista.getNombre().contains(filtro)) {
                Object[] data = {dtLista.getNombre()};
                tabla.addRow(data);
            }
        }
    }

    private void cargarDatosUsuarios(ArrayList<DtUsuario> usuarios, String filtro) {
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ninguna usuario registrado");
        }
        DefaultTableModel model = (DefaultTableModel) nombresDeUsuarios.getModel();
        model.setRowCount(0);
        for (DtUsuario dtuser : usuarios) {
            if (dtuser.getNombre().contains(filtro)) {
                Object[] data = {dtuser.getNickname(), dtuser.getNombre()};
                model.addRow(data);
            }
        }
    }

    private void cargarDatosListaD(ArrayList<DtLista> dtl, String filtro) {
        if (dtl.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ninguna lista registrado");
        }
        DefaultTableModel model = (DefaultTableModel) tablaListaTema.getModel();
        model.setRowCount(0);
        DefaultTableModel tabla = (DefaultTableModel) tablaListaPordefecto.getModel();
        tabla.setRowCount(0);
        for (DtLista dtLista : dtl) {
            if (dtLista.getNombre().contains(filtro)) {
                Object[] data = {dtLista.getNombre()};
                tabla.addRow(data);
            }
        }
    }

    private void cargarDatosClientes(ArrayList<DtUsuario> dtu, String filtro) {
        if (dtu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun cliente registrado");
        }

        DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
        dtm.setRowCount(0);
        for (DtUsuario dtUsuario : dtu) {
            if (dtUsuario.getNombre().contains(filtro)) {
                Object[] data = {
                    dtUsuario.getNickname(),
                    dtUsuario.getNombre(),
                    dtUsuario.getApellido(),};
                dtm.addRow(data);
            }
        }
    }

    private void cargarDatosArtistas(ArrayList<DtUsuario> dtu, String filtro) {
        if (dtu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun artistas registrado");
        }

        DefaultTableModel dtm = (DefaultTableModel) tablaArtistas.getModel();
        dtm.setRowCount(0);
        for (DtUsuario dtUsuario : dtu) {
            if (dtUsuario.getNickname().contains(filtro)) {
                Object[] data = {
                    dtUsuario.getNickname(),
                    dtUsuario.getNombre(),
                    dtUsuario.getApellido(),};
                dtm.addRow(data);
            }
        }
    }

    private void cargarDatosListaCliente(ArrayList<DtLista> listaP, String filtro) {
        if (listaP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ninguna Lista Particular Registrada");
        }
        DefaultTableModel dtl = (DefaultTableModel) ListadeListasParticulares.getModel();
        dtl.setRowCount(0);
        for (DtLista dtLista : listaP) {
            if (dtLista.getNombre().contains(filtro)) {
                Object[] data = {dtLista.getNombre()};
                dtl.addRow(data);
            }
        }
    }

    private void cargarDatosListaP(ArrayList<DtLista> listaP, String filtro) {
        if (listaP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ninguna Lista Particular Registrada");
        }
        DefaultTableModel model = (DefaultTableModel) tablaListaTema.getModel();
        model.setRowCount(0);
        DefaultTableModel dtl = (DefaultTableModel) tablaListaParticular.getModel();
        dtl.setRowCount(0);

        for (DtLista dtLista : listaP) {
            if (dtLista.getNombre().contains(filtro)) {
                Object[] data = {dtLista.getNombre()};
                dtl.addRow(data);
            }
        }
    }

    private void cargarDatosAlbumes(ArrayList<DtAlbum> albumes, String filtro) {
        if (albumes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun album registrado");
        }
        DefaultTableModel model = (DefaultTableModel) tablaListaTema.getModel();
        model.setRowCount(0);
        DefaultTableModel dta = (DefaultTableModel) tablaListaDeAlbumes.getModel();
        dta.setRowCount(0);
        for (DtAlbum dtAlbumbes : albumes) {
            if (dtAlbumbes.getNombre().contains(filtro)) {
                Object[] data = {dtAlbumbes.getNombre()};
                dta.addRow(data);
            }
        }
    }

    private void cargarDatosTemaAlbum(HashMap<String, Tema> temas, String filtro) {
        if (temas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun tema registrado");
        }
        Iterator i = temas.entrySet().iterator();
        DefaultTableModel dtt = (DefaultTableModel) tablaListaTema.getModel();
        dtt.setRowCount(0);
        while (i.hasNext()) {
            Tema t = (Tema) ((Map.Entry) i.next()).getValue();
            if (t.getNombre().contains(filtro)) {
                Object[] data = {t.getNombre()};
                dtt.addRow(data);
            }
        }
    }

    private void cargarDatosTemaL(ArrayList<DtTema> temas, String filtro) {
        if (temas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun tema registrado");
        }

        DefaultTableModel dtt = (DefaultTableModel) tablaListaTema.getModel();
        dtt.setRowCount(0);
        for (DtTema dtTemas : temas) {
            if (dtTemas.getNombre().contains(filtro)) {
                Object[] data = {dtTemas.getNombre()};
                dtt.addRow(data);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListadeListasParticulares;
    private javax.swing.JTabbedPane Pestania;
    private javax.swing.JTabbedPane Pestania2;
    private javax.swing.JToggleButton agregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable listaFinalPorDefecto;
    private javax.swing.JTextField nombreArtistas;
    private javax.swing.JTextField nombreCliente;
    private javax.swing.JTextField nombreDeListaFinal;
    private javax.swing.JTextField nombreListaD;
    private javax.swing.JTextField nombreListaDefectoFinal;
    private javax.swing.JTextField nombreListaP;
    private javax.swing.JTextField nombreTema;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JTable nombresDeUsuarios;
    private javax.swing.JTable tablaArtistas;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaListaDeAlbumes;
    private javax.swing.JTable tablaListaParticular;
    private javax.swing.JTable tablaListaPordefecto;
    private javax.swing.JTable tablaListaTema;
    // End of variables declaration//GEN-END:variables
}
