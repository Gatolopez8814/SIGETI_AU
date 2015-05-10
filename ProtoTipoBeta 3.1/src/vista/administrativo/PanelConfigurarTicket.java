package vista.administrativo;

import controlador.Controlador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.Ventana;
import vista.VentanaLogin;

public class PanelConfigurarTicket extends javax.swing.JPanel {

    private PanelConfigurarTicket() {
        initComponents();
        this.limpiarCampos();
        this.ajustarEventos();
        this.cargarjComboArea();
        this.cargarjComboAsunto();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelConfigurarTicket obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelConfigurarTicket();
        }
        instancia.limpiarCampos();
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        txtAgregarArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Ventana.obtenerInstancia().tecla();
                if (130 != txtAgregarArea.getText().length()) {
                } else {
                    e.consume();
                }
            }//

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });

        txtAgreagrAsunto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Ventana.obtenerInstancia().tecla();
                if (130 != txtAgreagrAsunto.getText().length()) {
                } else {
                    e.consume();
                }
            }//

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        txtAreaModificar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Ventana.obtenerInstancia().tecla();
                if (130 != txtAreaModificar.getText().length()) {
                } else {
                    e.consume();
                }
            }//

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        txtModificarAsunto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Ventana.obtenerInstancia().tecla();
                if (130 != txtModificarAsunto.getText().length()) {
                } else {
                    e.consume();
                }
            }//

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
    }

    private void cargarjComboArea() {
        this.jComboBoxModificarArea.removeAllItems();
        this.jComboBoxEliminarArea.removeAllItems();
        this.jComboBoxModificarArea.addItem("Seleccione aquí");
        this.jComboBoxEliminarArea.addItem("Seleccione aquí");
        ArrayList<String> temp = Controlador.obtenerInstancia().obtieneAreas();
        for (String temp1 : temp) {
            this.jComboBoxModificarArea.addItem(temp1);
            this.jComboBoxEliminarArea.addItem(temp1);
        }
        this.jComboBoxModificarArea.setSelectedIndex(0);
        this.jComboBoxModificarArea.revalidate();
        this.jComboBoxModificarArea.repaint();
        this.jComboBoxEliminarArea.setSelectedIndex(0);
        this.jComboBoxEliminarArea.revalidate();
        this.jComboBoxEliminarArea.repaint();
    }//----------------------------------------------------------------------------- FIN cargarjComboArea()

    private void cargarjComboAsunto() {
        this.jComboBoxModificarAsunto.removeAllItems();
        this.jComboBoxEliminarAsunto.removeAllItems();
        this.jComboBoxModificarAsunto.addItem("Seleccione aquí");
        this.jComboBoxEliminarAsunto.addItem("Seleccione aquí");
        ArrayList<String> temp = Controlador.obtenerInstancia().obtieneAsuntos();
        for (String temp1 : temp) {
            this.jComboBoxModificarAsunto.addItem(temp1);
            this.jComboBoxEliminarAsunto.addItem(temp1);
        }
        this.jComboBoxModificarAsunto.setSelectedIndex(0);
        this.jComboBoxModificarAsunto.revalidate();
        this.jComboBoxModificarAsunto.repaint();
        this.jComboBoxEliminarAsunto.setSelectedIndex(0);
        this.jComboBoxEliminarAsunto.revalidate();
        this.jComboBoxEliminarAsunto.repaint();
    }//----------------------------------------------------------------------------- FIN cargarjComboAsunto()

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelCreador2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        labelCreador3 = new javax.swing.JLabel();
        txtAgregarArea = new javax.swing.JTextField();
        btnAgregarArea = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        labelCreador = new javax.swing.JLabel();
        jComboBoxEliminarArea = new javax.swing.JComboBox<String>();
        btnEliminarArea = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        labelCreador4 = new javax.swing.JLabel();
        jComboBoxModificarArea = new javax.swing.JComboBox<String>();
        jPanel7 = new javax.swing.JPanel();
        labelCreador5 = new javax.swing.JLabel();
        txtAreaModificar = new javax.swing.JTextField();
        btnModificarArea = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        labelCreador7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        labelCreador8 = new javax.swing.JLabel();
        txtAgreagrAsunto = new javax.swing.JTextField();
        btnAgregarAsunto = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        labelCreador6 = new javax.swing.JLabel();
        jComboBoxEliminarAsunto = new javax.swing.JComboBox<String>();
        btnEliminarAsunto = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel13 = new javax.swing.JPanel();
        labelCreador9 = new javax.swing.JLabel();
        jComboBoxModificarAsunto = new javax.swing.JComboBox<String>();
        jPanel14 = new javax.swing.JPanel();
        labelCreador10 = new javax.swing.JLabel();
        txtModificarAsunto = new javax.swing.JTextField();
        btnModificarAsunto = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(208, 144, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setText("Configuracion de Ticket");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(656, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(222, 68, 33));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLimpiar.setText("Limpiar datos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiar)
                .addGap(65, 65, 65)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(158, 143, 123));

        jPanel2.setBackground(new java.awt.Color(226, 221, 205));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelCreador2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelCreador2.setText("Configurar Area");

        jPanel8.setBackground(new java.awt.Color(226, 221, 205));

        labelCreador3.setText("Agregar nueva  área :");

        btnAgregarArea.setText("Agregar área");
        btnAgregarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(labelCreador3)
                .addGap(78, 78, 78)
                .addComponent(txtAgregarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btnAgregarArea))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreador3)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAgregarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarArea)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(226, 221, 205));

        labelCreador.setText("Eliminar área :");

        jComboBoxEliminarArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí" }));
        jComboBoxEliminarArea.setToolTipText("");
        jComboBoxEliminarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEliminarAreaActionPerformed(evt);
            }
        });

        btnEliminarArea.setText("Eliminar área");
        btnEliminarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(labelCreador)
                .addGap(117, 117, 117)
                .addComponent(jComboBoxEliminarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(btnEliminarArea))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreador)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxEliminarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarArea)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(226, 221, 205));

        labelCreador4.setText("Cambiar nombre de área:");

        jComboBoxModificarArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí" }));
        jComboBoxModificarArea.setToolTipText("");
        jComboBoxModificarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModificarAreaActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(226, 221, 205));

        labelCreador5.setText("Nuevo nombre:");

        btnModificarArea.setText("Cambiar nombre");
        btnModificarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(labelCreador5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtAreaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(btnModificarArea))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreador5)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAreaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnModificarArea)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(labelCreador4)
                        .addGap(64, 64, 64)
                        .addComponent(jComboBoxModificarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreador4)
                    .addComponent(jComboBoxModificarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(labelCreador2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCreador2)
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(226, 221, 205));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelCreador7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelCreador7.setText("Configurar Asunto");

        jPanel4.setBackground(new java.awt.Color(226, 221, 205));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(226, 221, 205));

        labelCreador8.setText("Agregar nuevo asunto :");

        btnAgregarAsunto.setText("Agregar asunto");
        btnAgregarAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAsuntoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(labelCreador8)
                .addGap(69, 69, 69)
                .addComponent(txtAgreagrAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(btnAgregarAsunto))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreador8)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregarAsunto)
                        .addComponent(txtAgreagrAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(226, 221, 205));

        labelCreador6.setText("Eliminar asunto:");

        jComboBoxEliminarAsunto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí" }));
        jComboBoxEliminarAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEliminarAsuntoActionPerformed(evt);
            }
        });

        btnEliminarAsunto.setText("Eliminar asunto");
        btnEliminarAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAsuntoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(labelCreador6)
                .addGap(107, 107, 107)
                .addComponent(jComboBoxEliminarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarAsunto))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreador6)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminarAsunto)
                        .addComponent(jComboBoxEliminarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(226, 221, 205));

        labelCreador9.setText("Cambiar nombre de asunto:");

        jComboBoxModificarAsunto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí" }));
        jComboBoxModificarAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModificarAsuntoActionPerformed(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(226, 221, 205));

        labelCreador10.setText("Nuevo nombre:");

        txtModificarAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModificarAsuntoActionPerformed(evt);
            }
        });

        btnModificarAsunto.setText("Cambiar nombre");
        btnModificarAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAsuntoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(labelCreador10)
                .addGap(108, 108, 108)
                .addComponent(txtModificarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificarAsunto))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreador10)
                    .addComponent(txtModificarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarAsunto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(labelCreador9)
                        .addGap(50, 50, 50)
                        .addComponent(jComboBoxModificarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreador9)
                    .addComponent(jComboBoxModificarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(labelCreador7))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(109, 109, 109)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCreador7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente desea terminar ahora?", null, JOptionPane.YES_NO_OPTION)) {
            Ventana.obtenerInstancia().ventanaPrincipalAdmin();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAreaActionPerformed
        boolean bandera = false;
        if (txtAgregarArea.getText().equals("")) {
            bandera = true;
        } else {
            for (String areas : Controlador.obtenerInstancia().obtieneAreas()) {

                if (areas.equals(txtAgregarArea.getText())) {
                    System.out.println(areas);
                    bandera = true;
                }
            }
        }
        if (bandera) {
            
            if (txtAgreagrAsunto.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Falta el nombre del área", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar el área", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            String contrasenna;
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                    + "desea agregar el área?", null, JOptionPane.YES_NO_OPTION)) {
                contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                    if (Controlador.obtenerInstancia().agregarArea(txtAgregarArea.getText())) {
                        JOptionPane.showMessageDialog(this, "   Área agregada con éxito", "Área agregada", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo agregar el área", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "   No se pudo agregar el área, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarAreaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnModificarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAreaActionPerformed
        if (txtAreaModificar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "    Falta ingresar nombre nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (jComboBoxModificarArea.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Seleccione el área a modificar", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(txtAreaModificar.getText())) {
                JOptionPane.showMessageDialog(this, "Indique la nueva área", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String contrasenna;
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                        + "desea modificar el área?", null, JOptionPane.YES_NO_OPTION)) {
                    contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                    if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                        if (Controlador.obtenerInstancia().modificarArea(jComboBoxModificarArea.getSelectedItem().toString(), txtAreaModificar.getText())) {
                            JOptionPane.showMessageDialog(this, "   Área modificada con éxito", "Área modificada", JOptionPane.INFORMATION_MESSAGE);
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo Modificar el Area", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "   No se pudo modificar el área, contraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnModificarAreaActionPerformed

    private void btnEliminarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAreaActionPerformed

        if (jComboBoxEliminarArea.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione el área a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String contrasenna;
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                    + "desea eliminar el área?", null, JOptionPane.YES_NO_OPTION)) {
                contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                    if (Controlador.obtenerInstancia().eliminarArea(jComboBoxEliminarArea.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(this, "   Área eliminada con éxito", "Área eliminada", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar el área", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "   No se pudo eliminar el área, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarAreaActionPerformed

    private void btnAgregarAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAsuntoActionPerformed
        boolean bandera = false;
        if (txtAgreagrAsunto.getText().equals("")) {
            bandera = true;
        } else {
            for (String asuntos : Controlador.obtenerInstancia().obtieneAsuntos()) {

                if (asuntos.equals(txtAgreagrAsunto.getText())) {
                    System.out.println(asuntos);
                    bandera = true;
                }
            }
        }
        if (bandera) {
            if (txtAgreagrAsunto.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Falta el nombre de asunto", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar el asunto", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            String contrasenna;
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                    + "desea agregar el asunto?", null, JOptionPane.YES_NO_OPTION)) {
                contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                    if (Controlador.obtenerInstancia().agregarAsunto(txtAgreagrAsunto.getText())) {
                        JOptionPane.showMessageDialog(this, "   Asunto agregada con éxito", "Asunto agregada", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo agregar el asunto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "   No se pudo agregar el asunto, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarAsuntoActionPerformed

    private void btnEliminarAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAsuntoActionPerformed
        if (jComboBoxEliminarAsunto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione el asunto a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String contrasenna;
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                    + "desea eliminar el asunto?", null, JOptionPane.YES_NO_OPTION)) {
                contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                    if (Controlador.obtenerInstancia().eliminarAsunto(jComboBoxEliminarAsunto.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(this, "   Asunto eliminado con éxito", "Asunto eliminado", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar el asunto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "   No se pudo eliminar el asunto, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarAsuntoActionPerformed

    private void btnModificarAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAsuntoActionPerformed
        if (txtModificarAsunto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "    Falta ingresar nombre nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (jComboBoxModificarAsunto.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Seleccione el asunto a modificar", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(txtModificarAsunto.getText())) {
                JOptionPane.showMessageDialog(this, "Indique el nuevo asunto", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String contrasenna;
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                        + "desea modificar el asunto?", null, JOptionPane.YES_NO_OPTION)) {
                    contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                    if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                        if (Controlador.obtenerInstancia().modificarAsunto(jComboBoxModificarAsunto.getSelectedItem().toString(), txtModificarAsunto.getText())) {
                            JOptionPane.showMessageDialog(this, "   Asunto modificado con éxito", "Area Modificada", JOptionPane.INFORMATION_MESSAGE);
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo modificar el asunto", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "   No se pudo modificar el asunto, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnModificarAsuntoActionPerformed

    private void jComboBoxEliminarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEliminarAreaActionPerformed
//        if(jComboBoxEliminarArea.getSelectedIndex()!=0){
//            jComboBoxModificarArea.setSelectedIndex(0);
//            jComboBoxEliminarAsunto.setSelectedIndex(0);
//            jComboBoxModificarArea.setSelectedIndex(0);
//        }
    }//GEN-LAST:event_jComboBoxEliminarAreaActionPerformed

    private void jComboBoxModificarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModificarAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModificarAreaActionPerformed

    private void jComboBoxEliminarAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEliminarAsuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEliminarAsuntoActionPerformed

    private void jComboBoxModificarAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModificarAsuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModificarAsuntoActionPerformed

    private void txtModificarAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModificarAsuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModificarAsuntoActionPerformed

    private void limpiarCampos() {
        txtAgregarArea.setText("");
        txtAgreagrAsunto.setText("");
        txtAreaModificar.setText("");
        txtModificarAsunto.setText("");
        this.cargarjComboArea();
        this.cargarjComboAsunto();
        this.jComboBoxEliminarArea.setSelectedIndex(0);
        this.jComboBoxEliminarAsunto.setSelectedIndex(0);
        this.jComboBoxModificarArea.setSelectedIndex(0);
        this.jComboBoxModificarAsunto.setSelectedIndex(0);
    }

    //Declaracion de variables
    private static PanelConfigurarTicket instancia = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarArea;
    private javax.swing.JButton btnAgregarAsunto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarArea;
    private javax.swing.JButton btnEliminarAsunto;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificarArea;
    private javax.swing.JButton btnModificarAsunto;
    private javax.swing.JComboBox<String> jComboBoxEliminarArea;
    private javax.swing.JComboBox<String> jComboBoxEliminarAsunto;
    private javax.swing.JComboBox<String> jComboBoxModificarArea;
    private javax.swing.JComboBox<String> jComboBoxModificarAsunto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel labelCreador;
    private javax.swing.JLabel labelCreador10;
    private javax.swing.JLabel labelCreador2;
    private javax.swing.JLabel labelCreador3;
    private javax.swing.JLabel labelCreador4;
    private javax.swing.JLabel labelCreador5;
    private javax.swing.JLabel labelCreador6;
    private javax.swing.JLabel labelCreador7;
    private javax.swing.JLabel labelCreador8;
    private javax.swing.JLabel labelCreador9;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField txtAgreagrAsunto;
    private javax.swing.JTextField txtAgregarArea;
    private javax.swing.JTextField txtAreaModificar;
    private javax.swing.JTextField txtModificarAsunto;
    // End of variables declaration//GEN-END:variables
}
