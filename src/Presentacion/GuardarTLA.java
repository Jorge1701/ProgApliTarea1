package Presentacion;

import Logica.DtAlbum;
import Logica.DtAlbumContenido;
import Logica.DtGenero;
import Logica.DtLista;
import Logica.DtTema;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class GuardarTLA extends javax.swing.JInternalFrame {

    private IUsuario iUsuario;
    private IContenido iContenido;
    private ArrayList<DtUsuario> clientes;
    private ArrayList<DtUsuario> artistas;

    public GuardarTLA() {
        initComponents();

        iUsuario = Fabrica.getIControladorUsuario();
        iContenido = Fabrica.getIControladorContenido();

        clientes = iUsuario.listarClientes();
        artistas = iUsuario.listarArtistas();

        cargarDatosClientes(clientes, "");
        cargarDatosAlbumesArtistas(artistas, "");
        cargarDatosLPClientes(clientes, "");

        DefaultTreeModel modelo = new DefaultTreeModel(getNodo(iContenido.listarGenero()));
        treeLDGeneros.setModel(modelo);

        tablaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                cargarDatosLPClientes(clientes, txtLPCliente.getText());
            }
        });

        tablaAlbumesArtistas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                tablaAlbumesTemas.getSelectionModel().clearSelection();
                tablaAlbumesAlbumes.getSelectionModel().clearSelection();
                if (tablaAlbumesArtistas.getSelectedRow() != -1) {
                    cargarDatosAlbumesAlbumes(iUsuario.listarAlbumesArtista(tablaAlbumesArtistas.getValueAt(tablaAlbumesArtistas.getSelectedRow(), 0).toString()), txtAlbumAlbum.getText());
                }
            }
        });

        tablaAlbumesAlbumes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                tablaAlbumesTemas.getSelectionModel().clearSelection();
                if (tablaAlbumesArtistas.getSelectedRow() != -1 && tablaAlbumesAlbumes.getSelectedRow() != -1) {
                    cargarDatosAlbumesTemas(iUsuario.obtenerAlbumContenido(tablaAlbumesArtistas.getValueAt(tablaAlbumesArtistas.getSelectedRow(), 0).toString(), tablaAlbumesAlbumes.getValueAt(tablaAlbumesAlbumes.getSelectedRow(), 0).toString()), txtAlbumTema.getText());
                }
            }
        });

        tablaLPClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaLPClientes.getSelectedRow() != -1) {
                    cargarDatosLPListas(iUsuario.listarLisReproduccion(tablaLPClientes.getValueAt(tablaLPClientes.getSelectedRow(), 0).toString()), txtLPLista.getText());
                }
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

    private void cargarDatosAlbumesArtistas(ArrayList<DtUsuario> artistas, String filtro) {
        if (artistas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun cliente registrado");
            return;
        }

        DefaultTableModel dtm = (DefaultTableModel) tablaAlbumesArtistas.getModel();
        dtm.setRowCount(0);
        for (DtUsuario dtUsuario : artistas) {
            if (dtUsuario.getNickname().contains(filtro)) {
                Object[] data = {
                    dtUsuario.getNickname(),
                    dtUsuario.getNombre(),
                    dtUsuario.getApellido(),
                    dtUsuario.getEmail()
                };
                dtm.addRow(data);
            }
        }
    }

    private void cargarDatosAlbumesAlbumes(ArrayList<DtAlbum> dtalbums, String filtro) {
        DefaultTableModel dtm = (DefaultTableModel) tablaAlbumesAlbumes.getModel();
        dtm.setRowCount(0);
        for (DtAlbum dtAlbum : dtalbums) {
            if (dtAlbum.getNombre().contains(filtro)) {
                Object[] data = {
                    dtAlbum.getNombre(),
                    dtAlbum.getAnio()
                };
                dtm.addRow(data);
            }
        }
    }

    private void cargarDatosAlbumesTemas(DtAlbumContenido dtAlbumContenido, String filtro) {
        DefaultTableModel dtm = (DefaultTableModel) tablaAlbumesTemas.getModel();
        dtm.setRowCount(0);
        for (DtTema dtTema : dtAlbumContenido.getTemas()) {
            if (dtTema.getNombre().contains(filtro)) {
                Object[] data = {
                    dtTema.getNombre(),
                    dtTema.getDuracion().getMinutos() + ":" + dtTema.getDuracion().getSegundos()
                };
                dtm.addRow(data);
            }
        }
    }

    private void cargarDatosLDListas(ArrayList<DtLista> dtListas, String filtro) {
        DefaultTableModel dtm = (DefaultTableModel) tablaLDListas.getModel();

        dtm.setRowCount(0);
        for (DtLista dtLista : dtListas) {
            if (dtLista.getNombre().contains(filtro)) {
                Object[] data = {
                    dtLista.getNombre()
                };
                dtm.addRow(data);
            }
        }
    }

    private void cargarDatosLPClientes(ArrayList<DtUsuario> dtu, String filtro) {
        if (tablaClientes.getSelectedRow() == -1) {
            return;
        }

        String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();

        DefaultTableModel dtm = (DefaultTableModel) tablaLPClientes.getModel();
        dtm.setRowCount(0);
        for (DtUsuario dtUsuario : dtu) {
            if (dtUsuario.getNickname().contains(filtro) && !dtUsuario.getNickname().equals(nickCliente)) {
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

    private void cargarDatosLPListas(ArrayList<DtLista> dtListas, String filtro) {
        DefaultTableModel dtm = (DefaultTableModel) tablaLPListas.getModel();

        dtm.setRowCount(0);
        for (DtLista dtLista : dtListas) {
            if (dtLista.getNombre().contains(filtro)) {
                Object[] data = {
                    dtLista.getNombre()
                };
                dtm.addRow(data);
            }
        }
    }

    private DefaultMutableTreeNode getNodo(DtGenero g) {
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode(g.getNombre());
        for (DtGenero dtg : g.getSubGeneros()) {
            DefaultMutableTreeNode hijo = getNodo(dtg);
            padre.add(hijo);
        }
        return padre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNickname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        paneles = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlbumesArtistas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAlbumesAlbumes = new javax.swing.JTable();
        txtAlbumesArtista = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAlbumAlbum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaAlbumesTemas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtAlbumTema = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAgregarTema = new javax.swing.JButton();
        btnAgregarAlbum = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        treeLDGeneros = new javax.swing.JTree();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaLDListas = new javax.swing.JTable();
        txtLDLista = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar2 = new javax.swing.JButton();
        btnAceptarLD = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaLPClientes = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaLPListas = new javax.swing.JTable();
        txtLPCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLPLista = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnCancelar3 = new javax.swing.JButton();
        btnAceptarLP = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Agregar a Favorito");

        txtNickname.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNicknameCaretUpdate(evt);
            }
        });

        jLabel2.setText("Nickname:");

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
        tablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaClientes.getColumnModel().getColumn(1).setResizable(false);
            tablaClientes.getColumnModel().getColumn(2).setResizable(false);
            tablaClientes.getColumnModel().getColumn(3).setResizable(false);
        }

        tablaAlbumesArtistas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaAlbumesArtistas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaAlbumesArtistas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaAlbumesArtistas);
        if (tablaAlbumesArtistas.getColumnModel().getColumnCount() > 0) {
            tablaAlbumesArtistas.getColumnModel().getColumn(0).setResizable(false);
            tablaAlbumesArtistas.getColumnModel().getColumn(1).setResizable(false);
            tablaAlbumesArtistas.getColumnModel().getColumn(2).setResizable(false);
            tablaAlbumesArtistas.getColumnModel().getColumn(3).setResizable(false);
        }

        tablaAlbumesAlbumes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Anio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAlbumesAlbumes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaAlbumesAlbumes.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaAlbumesAlbumes);
        if (tablaAlbumesAlbumes.getColumnModel().getColumnCount() > 0) {
            tablaAlbumesAlbumes.getColumnModel().getColumn(0).setResizable(false);
            tablaAlbumesAlbumes.getColumnModel().getColumn(1).setResizable(false);
        }

        txtAlbumesArtista.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAlbumesArtistaCaretUpdate(evt);
            }
        });

        jLabel1.setText("Nickname:");

        txtAlbumAlbum.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAlbumAlbumCaretUpdate(evt);
            }
        });

        jLabel3.setText("Nombre Album:");

        tablaAlbumesTemas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaAlbumesTemas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaAlbumesTemas.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(tablaAlbumesTemas);
        if (tablaAlbumesTemas.getColumnModel().getColumnCount() > 0) {
            tablaAlbumesTemas.getColumnModel().getColumn(0).setResizable(false);
            tablaAlbumesTemas.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel7.setText("Nombre Tema:");

        txtAlbumTema.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAlbumTemaCaretUpdate(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregarTema.setText("Agregar Tema");
        btnAgregarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTemaActionPerformed(evt);
            }
        });

        btnAgregarAlbum.setText("Agregar Album");
        btnAgregarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlbumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAlbumesArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAlbumAlbum)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAlbumTema))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarTema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlbumesArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAlbumTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAlbumAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAgregarTema)
                    .addComponent(btnAgregarAlbum))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneles.addTab("Albumes / Temas", jPanel1);

        treeLDGeneros.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));
        treeLDGeneros.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeLDGenerosValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(treeLDGeneros);

        tablaLDListas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaLDListas.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tablaLDListas);
        if (tablaLDListas.getColumnModel().getColumnCount() > 0) {
            tablaLDListas.getColumnModel().getColumn(0).setResizable(false);
        }

        txtLDLista.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtLDListaCaretUpdate(evt);
            }
        });

        jLabel4.setText("Nombre Lista:");

        btnCancelar2.setText("Cancelar");
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });

        btnAceptarLD.setText("Agregar");
        btnAceptarLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarLDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLDLista, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptarLD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLDLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar2)
                    .addComponent(btnAceptarLD))
                .addContainerGap())
        );

        paneles.addTab("Listas por Defecto", jPanel2);

        tablaLPClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaLPClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tablaLPClientes);
        if (tablaLPClientes.getColumnModel().getColumnCount() > 0) {
            tablaLPClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaLPClientes.getColumnModel().getColumn(1).setResizable(false);
            tablaLPClientes.getColumnModel().getColumn(2).setResizable(false);
            tablaLPClientes.getColumnModel().getColumn(3).setResizable(false);
        }

        tablaLPListas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        tablaLPListas.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tablaLPListas);

        txtLPCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtLPClienteCaretUpdate(evt);
            }
        });

        jLabel5.setText("Nickname:");

        txtLPLista.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtLPListaCaretUpdate(evt);
            }
        });

        jLabel6.setText("Lista:");

        btnCancelar3.setText("Cancelar");
        btnCancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar3ActionPerformed(evt);
            }
        });

        btnAceptarLP.setText("Aceptar");
        btnAceptarLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarLPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLPCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLPLista, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptarLP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLPCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLPLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar3)
                    .addComponent(btnAceptarLP))
                .addContainerGap())
        );

        paneles.addTab("Listas Particulares", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(paneles))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneles, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNicknameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNicknameCaretUpdate
        cargarDatosClientes(clientes, txtNickname.getText());
    }//GEN-LAST:event_txtNicknameCaretUpdate

    private void txtAlbumesArtistaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAlbumesArtistaCaretUpdate
        cargarDatosAlbumesArtistas(artistas, txtAlbumesArtista.getText());
    }//GEN-LAST:event_txtAlbumesArtistaCaretUpdate

    private void txtAlbumAlbumCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAlbumAlbumCaretUpdate
        if (tablaAlbumesArtistas.getSelectedRow() != -1) {
            cargarDatosAlbumesAlbumes(iUsuario.listarAlbumesArtista(tablaAlbumesArtistas.getValueAt(tablaAlbumesArtistas.getSelectedRow(), 0).toString()), txtAlbumAlbum.getText());
        }
    }//GEN-LAST:event_txtAlbumAlbumCaretUpdate

    private void txtAlbumTemaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAlbumTemaCaretUpdate
        if (tablaAlbumesArtistas.getSelectedRow() != -1 && tablaAlbumesAlbumes.getSelectedRow() != -1) {
            cargarDatosAlbumesTemas(iUsuario.obtenerAlbumContenido(tablaAlbumesArtistas.getValueAt(tablaAlbumesArtistas.getSelectedRow(), 0).toString(), tablaAlbumesAlbumes.getValueAt(tablaAlbumesAlbumes.getSelectedRow(), 0).toString()), txtAlbumTema.getText());
        }
    }//GEN-LAST:event_txtAlbumTemaCaretUpdate

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlbumActionPerformed
        if (tablaClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
            return;
        }
        if (tablaAlbumesArtistas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un artista");
            return;
        }
        if (tablaAlbumesAlbumes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un album");
            return;
        }

        String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
        String nickArtista = tablaAlbumesArtistas.getValueAt(tablaAlbumesArtistas.getSelectedRow(), 0).toString();
        String nombreAlbum = tablaAlbumesAlbumes.getValueAt(tablaAlbumesAlbumes.getSelectedRow(), 0).toString();

        try {
            iUsuario.agregarAlbumFav(nickCliente, nickArtista, nombreAlbum);
            JOptionPane.showMessageDialog(this, "Album agregado a favoritos");
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarAlbumActionPerformed

    private void btnAgregarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTemaActionPerformed
        if (tablaClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
            return;
        }
        if (tablaAlbumesArtistas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un artista");
            return;
        }
        if (tablaAlbumesAlbumes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un album");
            return;
        }
        if (tablaAlbumesTemas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un tema");
            return;
        }

        String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
        String nickArtista = tablaAlbumesArtistas.getValueAt(tablaAlbumesArtistas.getSelectedRow(), 0).toString();
        String nombreAlbum = tablaAlbumesAlbumes.getValueAt(tablaAlbumesAlbumes.getSelectedRow(), 0).toString();
        String nombreTema = tablaAlbumesTemas.getValueAt(tablaAlbumesTemas.getSelectedRow(), 0).toString();

        try {
            iUsuario.agregarTemaFav(nickCliente, nickArtista, nombreAlbum, nombreTema);
            JOptionPane.showMessageDialog(this, "Tema agregado a favoritos");
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarTemaActionPerformed

    private void treeLDGenerosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeLDGenerosValueChanged
        if (treeLDGeneros.getSelectionPath() == null) {
            return;
        }

        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) treeLDGeneros.getSelectionPath().getLastPathComponent();
        String generoSeleccionado = selectedElement.getUserObject().toString();

        cargarDatosLDListas(iContenido.listarLisReproduccionGen(generoSeleccionado), txtLDLista.getText());
    }//GEN-LAST:event_treeLDGenerosValueChanged

    private void txtLDListaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtLDListaCaretUpdate
        if (treeLDGeneros.getSelectionPath() == null) {
            return;
        }

        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) treeLDGeneros.getSelectionPath().getLastPathComponent();
        String generoSeleccionado = selectedElement.getUserObject().toString();

        cargarDatosLDListas(iContenido.listarLisReproduccionGen(generoSeleccionado), txtLDLista.getText());
    }//GEN-LAST:event_txtLDListaCaretUpdate

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelar2ActionPerformed

    private void btnAceptarLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarLDActionPerformed
        if (tablaClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
            return;
        }
        if (treeLDGeneros.getSelectionPath() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un genero");
            return;
        }
        if (tablaLDListas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una lista");
            return;
        }

        String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) treeLDGeneros.getSelectionPath().getLastPathComponent();
        String generoSeleccionado = selectedElement.getUserObject().toString();
        String nomLista = tablaLDListas.getValueAt(tablaLDListas.getSelectedRow(), 0).toString();

        try {
            iUsuario.agregarLDFav(nickCliente, generoSeleccionado, nomLista);
            JOptionPane.showMessageDialog(this, "Lista agregada a favoritos");
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarLDActionPerformed

    private void txtLPClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtLPClienteCaretUpdate
        cargarDatosLPClientes(clientes, txtLPCliente.getText());
    }//GEN-LAST:event_txtLPClienteCaretUpdate

    private void txtLPListaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtLPListaCaretUpdate
        if (tablaLPClientes.getSelectedRow() != -1) {
            cargarDatosLPListas(iUsuario.listarLisReproduccion(tablaLPClientes.getValueAt(tablaLPClientes.getSelectedRow(), 0).toString()), txtLPLista.getText());
        }
    }//GEN-LAST:event_txtLPListaCaretUpdate

    private void btnCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar3ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelar3ActionPerformed

    private void btnAceptarLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarLPActionPerformed
        if (tablaClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
            return;
        }
        if (tablaLPClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente (abajo)");
            return;
        }
        if (tablaLPListas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una lista");
            return;
        }

        String nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
        String nickClienteAbajo = tablaLPClientes.getValueAt(tablaLPClientes.getSelectedRow(), 0).toString();
        String nombreLista = tablaLPListas.getValueAt(tablaLPListas.getSelectedRow(), 0).toString();

        try {
            iUsuario.agregarLPFav(nickCliente, nickClienteAbajo, nombreLista);
            JOptionPane.showMessageDialog(this, "Lista agregada a favoritos");
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarLPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarLD;
    private javax.swing.JButton btnAceptarLP;
    private javax.swing.JButton btnAgregarAlbum;
    private javax.swing.JButton btnAgregarTema;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnCancelar3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane paneles;
    private javax.swing.JTable tablaAlbumesAlbumes;
    private javax.swing.JTable tablaAlbumesArtistas;
    private javax.swing.JTable tablaAlbumesTemas;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaLDListas;
    private javax.swing.JTable tablaLPClientes;
    private javax.swing.JTable tablaLPListas;
    private javax.swing.JTree treeLDGeneros;
    private javax.swing.JTextField txtAlbumAlbum;
    private javax.swing.JTextField txtAlbumTema;
    private javax.swing.JTextField txtAlbumesArtista;
    private javax.swing.JTextField txtLDLista;
    private javax.swing.JTextField txtLPCliente;
    private javax.swing.JTextField txtLPLista;
    private javax.swing.JTextField txtNickname;
    // End of variables declaration//GEN-END:variables
}
