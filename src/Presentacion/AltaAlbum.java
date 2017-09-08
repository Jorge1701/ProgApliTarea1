package Presentacion;

import Logica.DtGenero;
import Logica.DtTema;
import Logica.DtTemaLocal;
import Logica.DtTemaRemoto;
import Logica.DtTime;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class AltaAlbum extends javax.swing.JInternalFrame {

    private IContenido iContenido;
    private IUsuario iUsuario;
    ArrayList<String> generos;
    DefaultListModel<String> model;
    private final JFileChooser archivoTema;
    private final JFileChooser archivoImg;
    ArrayList<DtTema> temas;
    String pathMp3;
    String nameMp3;
    String pathImage;
    String nameImage;
    DefaultTableModel dtm;
    private ArrayList<DtUsuario> datos;
    PanelImagen pImg;
    PropertyManager pm;

    public AltaAlbum() {
        initComponents();
        archivoTema = new JFileChooser();
        archivoTema.setFileFilter(new FileNameExtensionFilter("mp3 files", "mp3"));
        archivoImg = new JFileChooser();
        archivoImg.setFileFilter(new FileNameExtensionFilter("Images files", "jpg", "png", "gif", "jpeg"));
        this.iContenido = Fabrica.getIControladorContenido();
        this.iUsuario = Fabrica.getIControladorUsuario();
        temas = new ArrayList<DtTema>();
        mostrarGeneros();
        //jScrollPane2.setViewportView(ListaGeneros);
        buttonStream.setSelected(true);
        mostrarTema();
        dtm = (DefaultTableModel) tableTemas.getModel();
        tableTemas.setModel(dtm);
        dtm.setRowCount(0);
        pathMp3 = "";
        nameMp3 = "";
        pathImage = null;
        nameImage = null;
        datos = iUsuario.listarArtistas();
        cargarDatos(datos, "");
        pm = PropertyManager.getInstance();
        cargarImagen(pm.getProperty("pathImagenesAlbum") + "albumDefault.png");

    }

    private DefaultMutableTreeNode getNodo(DtGenero g) {
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode(g.getNombre());
        for (DtGenero dtg : g.getSubGeneros()) {
            DefaultMutableTreeNode hijo = getNodo(dtg);
            padre.add(hijo);
        }
        return padre;
    }

    private boolean exiteNombreTema(String nombreTema) {

        boolean retorno = false;
        if (!this.temas.isEmpty()) {
            for (int i = 0; i < temas.size(); i++) {
                DtTema dtT = (DtTema) temas.get(i);
                if (dtT.getNombre().equals(nombreTema)) {
                    retorno = true;
                }
            }
        }

        return retorno;

    }

    void mostrarGeneros() {

        jTreeGeneros.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DtGenero g = iContenido.listarGenero();

        DefaultTreeModel modelo = new DefaultTreeModel(getNodo(g));
        jTreeGeneros.setModel(modelo);

        model = new DefaultListModel<>();
        jListGros.setModel(model);
        generos = new ArrayList<>();
    }

    private void cargarDatos(ArrayList<DtUsuario> dtu, String filtro) {
        if (dtu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun cliente registrado");
        }

        DefaultTableModel dtm = (DefaultTableModel) tablaArtistas.getModel();
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

    void mostrarTema() {
        if (buttonStream.isSelected()) {
            txtStremTema.setEnabled(true);
            btnSelecMp3.setEnabled(false);

        } else if (buttonArch.isSelected()) {
            txtStremTema.setEnabled(false);
            btnSelecMp3.setEnabled(true);
        }

    }

    private void setUbicacionTemas() {

        for (int i = 0; i < tableTemas.getRowCount(); i++) {
            String nom = tableTemas.getValueAt(i, 0).toString();
            int ubicacion = Integer.parseInt(tableTemas.getValueAt(i, 1).toString());
            for (int e = 0; e < temas.size(); e++) {
                DtTema dtT = (DtTema) temas.get(e);
                if (dtT.getNombre().equals(nom)) {
                    dtT.setUbicacion(ubicacion);
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btonGroupTema = new javax.swing.ButtonGroup();
        AlbumTx = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreAlbum = new javax.swing.JTextField();
        txtNick = new javax.swing.JTextField();
        NombreTx = new javax.swing.JLabel();
        comboAnio = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeGeneros = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListGros = new javax.swing.JList<>();
        jbtnAgregarGro = new javax.swing.JButton();
        btnQuitarGro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomTema = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonArch = new javax.swing.JRadioButton();
        buttonStream = new javax.swing.JRadioButton();
        btnAgregarTema = new javax.swing.JButton();
        txtStremTema = new javax.swing.JTextField();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        jSpinnerDuracion = new javax.swing.JSpinner(sm);
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTemas = new javax.swing.JTable();
        btnSelecMp3 = new javax.swing.JButton();
        btnEliminarTema = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaArtistas = new javax.swing.JTable();
        imagePanel = new javax.swing.JPanel();
        btnCargarImg = new java.awt.Button();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alta de album");
        setFocusCycleRoot(false);
        setMaximumSize(new java.awt.Dimension(214748, 214748));

        AlbumTx.setText("Nombre De Album :");

        jLabel2.setText("Año :");

        txtNick.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNickCaretUpdate(evt);
            }
        });

        NombreTx.setText("Nick De Artista :");

        comboAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", " " }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));
        jPanel1.setName("Generos"); // NOI18N

        jTreeGeneros.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeGenerosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeGeneros);

        jScrollPane2.setViewportView(jListGros);

        jbtnAgregarGro.setText("Agregar");
        jbtnAgregarGro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarGroActionPerformed(evt);
            }
        });

        btnQuitarGro.setText("Quitar");
        btnQuitarGro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarGroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jbtnAgregarGro)
                .addGap(121, 121, 121)
                .addComponent(btnQuitarGro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarGro)
                    .addComponent(jbtnAgregarGro)))
        );

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton1.setText("Guardar Album");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas"));

        jLabel1.setText("Nombre:");

        jLabel3.setText("Duracion:");

        btonGroupTema.add(buttonArch);
        buttonArch.setText("Archivo");
        buttonArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonArchActionPerformed(evt);
            }
        });

        btonGroupTema.add(buttonStream);
        buttonStream.setText("Stream");
        buttonStream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStreamActionPerformed(evt);
            }
        });

        btnAgregarTema.setText("Agregar");
        btnAgregarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTemaActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinnerDuracion, "HH:mm:ss");
        jSpinnerDuracion.setEditor(de);
        jSpinnerDuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSpinnerDuracion.setFocusable(false);

        tableTemas = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col) {
                switch (col) {
                    case 1:
                    return true;
                    default:
                    return false;
                }
            }};
            tableTemas.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Nombre", "Ubicacion","Duración", "Path o Url"
                }
            ));
            jScrollPane3.setViewportView(tableTemas);

            btnSelecMp3.setText("Select .mp3..");
            btnSelecMp3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSelecMp3ActionPerformed(evt);
                }
            });

            btnEliminarTema.setText("Eliminar");
            btnEliminarTema.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnEliminarTemaActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jSpinnerDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addComponent(buttonStream))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(62, 62, 62)
                                    .addComponent(txtStremTema, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(buttonArch)
                                .addComponent(btnSelecMp3))
                            .addGap(37, 37, 37))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(txtNomTema, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addContainerGap())))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonStream)
                            .addComponent(buttonArch))
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addComponent(txtStremTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSelecMp3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(btnAgregarTema)
                            .addGap(30, 30, 30)
                            .addComponent(btnEliminarTema)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            );

            tablaArtistas.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "Nickname", "Nombre", "Apellido", "Email", "Fecha Nac."
                }
            ));
            jScrollPane4.setViewportView(tablaArtistas);

            imagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
            imagePanel.setLayout(imagePanelLayout);
            imagePanelLayout.setHorizontalGroup(
                imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 198, Short.MAX_VALUE)
            );
            imagePanelLayout.setVerticalGroup(
                imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 180, Short.MAX_VALUE)
            );

            btnCargarImg.setLabel("Cargar Imagen");
            btnCargarImg.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCargarImgActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jButton1)
                            .addGap(192, 192, 192)
                            .addComponent(jButton2)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AlbumTx)
                                        .addComponent(btnCargarImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(113, 113, 113)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(NombreTx, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(92, 92, 92)
                                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane4))))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreTx)
                            .addComponent(txtNombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AlbumTx)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCargarImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //String nickA = tablaArtistas.getValueAt(tablaArtistas.getSelectedRow(), 0).toString();
        if (tablaArtistas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "No hay ningun usuario seleccionado");
            return;
        }
        String nickA = tablaArtistas.getValueAt(tablaArtistas.getSelectedRow(), 0).toString();
        //System.out.println("nick:"  + nickA);
        String album = txtNombreAlbum.getText();

        String camposVacios = "";

        if (album.isEmpty()) {
            camposVacios += "Nombre Album \n";
        }

        if (!camposVacios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios vacios:\n" + camposVacios);
            return;
        }

        if (comboAnio.getSelectedItem().toString().equals("----")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un año");
            return;
        }
        int anio = Integer.parseInt(comboAnio.getSelectedItem().toString());

        try {
            iContenido.selectArtista(nickA);

            if (temas.isEmpty()) {
                throw new UnsupportedOperationException("Debe de indicar al menos un Tema");
            }

            if (generos.isEmpty()) {
                throw new UnsupportedOperationException("Debe de indicar al menos un Genero");
            }

            setUbicacionTemas();

            iContenido.ingresarAlbum(album, anio, generos, nameImage, temas);

        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }

        JOptionPane.showMessageDialog(this, "Se ingreso Album");
        txtNick.setText("");
        txtNombreAlbum.setText("");
        dtm.setRowCount(0);
        DefaultListModel mListGros = (DefaultListModel) jListGros.getModel();
        mListGros.removeAllElements();
        pathImage = null;
        nameImage = null;
        comboAnio.setSelectedIndex(0);
        //imagePanel.repaint();
        //imagePanel.setBackground(Color.GRAY);
        tablaArtistas.clearSelection();
        temas.removeAll(temas);
        generos.removeAll(generos);

        cargarImagen(pm.getProperty("pathImagenesAlbum") + "albumDefault.png");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTreeGenerosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeGenerosValueChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jTreeGenerosValueChanged

    private void jbtnAgregarGroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarGroActionPerformed
        // TODO add your handling code here:

        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) jTreeGeneros.getSelectionPath().getLastPathComponent();

        if (selectedElement.isRoot()) {
            JOptionPane.showMessageDialog(this, "No puede seleccionar nodo Raiz:\n");
        } else {
            String generoSeleccionado = selectedElement.getUserObject().toString();
            if (generos.contains(generoSeleccionado)) {
                JOptionPane.showMessageDialog(this, "Ya selecciono ese Genero:\n");
            } else {
                generos.add(generoSeleccionado);
                model.addElement(generoSeleccionado);
            }

        }

    }//GEN-LAST:event_jbtnAgregarGroActionPerformed

    private void btnQuitarGroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarGroActionPerformed
        // TODO add your handling code here:

        String pos = jListGros.getSelectedValue();
        if (pos != null) {
            generos.remove(pos);
            model.removeElement(pos);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un genero:\n");
        }

    }//GEN-LAST:event_btnQuitarGroActionPerformed

    private void btnSelecMp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecMp3ActionPerformed

        try {
            if (archivoTema.showOpenDialog(this) == 0) {
                File arch = archivoTema.getSelectedFile();
                //pathMp3 = "src/Recursos/Musica/" + arch.getName();
                pathMp3 = pm.getProperty("pathMusica") + arch.getName();
                nameMp3 = arch.getName();
                //System.out.println("Path: "+ pathMp3);
                //if (arch != null) {
                InputStream is = new FileInputStream(arch);
                OutputStream outstream = new FileOutputStream(new File(pathMp3));
                byte[] buffer = new byte[4096];
                int len;
                while ((len = is.read(buffer)) > 0) {
                    outstream.write(buffer, 0, len);
                }
                outstream.close();
                JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);

                // }
            }
        } catch (NullPointerException n) {
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "El directorio o nombre de archivo incorrecto.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(AltaAlbum.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSelecMp3ActionPerformed

    private void buttonStreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStreamActionPerformed
        mostrarTema();
    }//GEN-LAST:event_buttonStreamActionPerformed

    private void buttonArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArchActionPerformed
        mostrarTema();
    }//GEN-LAST:event_buttonArchActionPerformed

    private void btnAgregarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTemaActionPerformed

        String nomTema = txtNomTema.getText();
        Date time = new Date();
        time = (Date) jSpinnerDuracion.getValue();
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        DtTime dtTime = new DtTime(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
        String stream;
        String pathtArch;
        DtTema dtTema;

        String camposVacios = "";
        if (nomTema.isEmpty()) {
            camposVacios += "Nombre Tema\n";
        }

        if (!camposVacios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios vacios:\n" + camposVacios);
            return;
        }

        if (txtStremTema.isEnabled()) {
            stream = txtStremTema.getText();
            if (stream.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe indicar la url");
                return;
            }
            if (exiteNombreTema(nomTema)) {
                JOptionPane.showMessageDialog(this, "Nombre de tema Duplicado");
                return;
            }
            int ubicacion = tableTemas.getRowCount() + 1;
            dtTema = new DtTemaRemoto(stream, nomTema, dtTime, ubicacion);
            Object[] data = {
                nomTema,
                ubicacion,
                dtTime.getHoras() + ":" + dtTime.getMinutos() + ":" + dtTime.getSegundos(),
                stream,};
            dtm.addRow(data);
            //System.out.println("Agrego tema" + nomTema);
            temas.add(dtTema);

        } else if (btnSelecMp3.isEnabled()) {

            if (nameMp3 == "") {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo");
                return;
            }
            if (exiteNombreTema(nomTema)) {
                JOptionPane.showMessageDialog(this, "Nombre de tema Duplicado");
                return;
            }
            int ubicacion = tableTemas.getRowCount() + 1;
            dtTema = new DtTemaLocal(nameMp3, nomTema, dtTime, ubicacion);
            Object[] data = {
                nomTema,
                ubicacion,
                dtTime.getHoras() + ":" + dtTime.getMinutos() + ":" + dtTime.getSegundos(),
                nameMp3,};
            dtm.addRow(data);
            System.out.println("Agrego Tema" + nomTema);
            temas.add(dtTema);
            pathMp3 = "";
            nameMp3 = "";

        }

        txtStremTema.setText("");
        txtNomTema.setText("");

    }//GEN-LAST:event_btnAgregarTemaActionPerformed

    private void txtNickCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNickCaretUpdate
        // TODO add your handling code here:
        cargarDatos(datos, txtNick.getText());

    }//GEN-LAST:event_txtNickCaretUpdate

    private void btnCargarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImgActionPerformed
        try {
            if (archivoImg.showOpenDialog(this) == 0) {
                File arch = archivoImg.getSelectedFile();
                nameImage = arch.getName();
                pathImage = pm.getProperty("pathImagenesAlbum") + arch.getName();
                //if (arch != null) {
                InputStream is = new FileInputStream(arch);
                OutputStream outstream = new FileOutputStream(new File(pathImage));
                byte[] buffer = new byte[4096];
                int len;
                while ((len = is.read(buffer)) > 0) {
                    outstream.write(buffer, 0, len);
                }
                outstream.close();
                // }
            } else {
                return;
            }

        } catch (NullPointerException n) {
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo cargar la Imagen.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        cargarImagen(pathImage);
    }//GEN-LAST:event_btnCargarImgActionPerformed

    private void cargarImagen(String pathImage) {
        try {
            BufferedImage img;
            img = ImageIO.read(new File(pathImage));
            pImg = new PanelImagen(img);
            imagePanel.removeAll();
            imagePanel.add(pImg);
            pImg.setBounds(0, 0, 200, 182);
        } catch (IOException ex) {
            Logger.getLogger(AltaAlbum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnEliminarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTemaActionPerformed

        int fila = tableTemas.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableTemas.getModel();
        System.out.println("fila" + fila);
        if (fila >= 0) {
            String nombre = tableTemas.getValueAt(fila, 0).toString();
            if (!temas.isEmpty()) {

                for (int i = 0; i < temas.size(); i++) {
                    DtTema dtT = (DtTema) temas.get(i);
                    if (dtT.getNombre().equals(nombre)) {
                        temas.remove(dtT);
                    }
                }
            }

            model.removeRow(fila);

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tema");
            return;

        }

    }//GEN-LAST:event_btnEliminarTemaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlbumTx;
    private javax.swing.JLabel NombreTx;
    private javax.swing.JButton btnAgregarTema;
    private java.awt.Button btnCargarImg;
    private javax.swing.JButton btnEliminarTema;
    private javax.swing.JButton btnQuitarGro;
    private javax.swing.JButton btnSelecMp3;
    private javax.swing.ButtonGroup btonGroupTema;
    private javax.swing.JRadioButton buttonArch;
    private javax.swing.JRadioButton buttonStream;
    private javax.swing.JComboBox<String> comboAnio;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListGros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinnerDuracion;
    private javax.swing.JTree jTreeGeneros;
    private javax.swing.JButton jbtnAgregarGro;
    private javax.swing.JTable tablaArtistas;
    private javax.swing.JTable tableTemas;
    private javax.swing.JTextField txtNick;
    private javax.swing.JTextField txtNomTema;
    private javax.swing.JTextField txtNombreAlbum;
    private javax.swing.JTextField txtStremTema;
    // End of variables declaration//GEN-END:variables
}
