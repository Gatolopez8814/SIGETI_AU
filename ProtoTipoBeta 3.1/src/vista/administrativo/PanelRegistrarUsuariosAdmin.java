package vista.administrativo;

import controlador.Controlador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.GeneradorDeClave;
import vista.Ventana;
import vista.VentanaLogin;

public class PanelRegistrarUsuariosAdmin extends javax.swing.JPanel {

    private PanelRegistrarUsuariosAdmin() {
        initComponents();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelRegistrarUsuariosAdmin obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelRegistrarUsuariosAdmin();
        }
        instancia.limpiarCampos();
        instancia.ajustarEventos();
        instancia.ocultarComponentes();
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void cargarjComboArea() {
        this.jComboArea.removeAllItems();
        this.jComboArea.addItem("Seleccione aquí");
        ArrayList<String> temp = Controlador.obtenerInstancia().obtieneAreas();
        for (int i = 0; i < temp.size(); i++) {
            this.jComboArea.addItem(temp.get(i));
        }
        this.jComboArea.setSelectedIndex(0);
        this.jComboArea.revalidate();
        this.jComboArea.repaint();
    }//----------------------------------------------------------------------------- FIN cargarjComboArea()

    private void ocultarComponentes() {
        this.jPanelArea.setVisible(false);
    }

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        jtCorreo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Ventana.obtenerInstancia().tecla();
                if (150 != jtCorreo.getText().length()) {
                } else {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        labelCreador = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<String>();
        jPanelArea = new javax.swing.JPanel();
        labelCreador1 = new javax.swing.JLabel();
        jComboArea = new javax.swing.JComboBox<String>();
        PanelBotones = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1660, 1660));

        jPanel1.setBackground(new java.awt.Color(208, 144, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Registro de usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(158, 143, 123));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(226, 221, 205));

        jLabel3.setText("Correo electronico del usuario: ");

        jtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCorreoActionPerformed(evt);
            }
        });

        jLabel2.setText("@castillo.cr");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(226, 221, 205));

        labelCreador.setText("Tipo de usuario:  ");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí", "Usuario estándar", "Usuario de área", "Usuario administrador" }));
        comboTipo.setToolTipText("");
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCreador)
                .addGap(18, 18, 18)
                .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreador)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanelArea.setBackground(new java.awt.Color(226, 221, 205));

        labelCreador1.setText("Seleccione el área: ");

        jComboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí" }));

        javax.swing.GroupLayout jPanelAreaLayout = new javax.swing.GroupLayout(jPanelArea);
        jPanelArea.setLayout(jPanelAreaLayout);
        jPanelAreaLayout.setHorizontalGroup(
            jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCreador1)
                .addGap(18, 18, 18)
                .addComponent(jComboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanelAreaLayout.setVerticalGroup(
            jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreador1)
                    .addComponent(jComboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(358, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelBotones.setBackground(new java.awt.Color(222, 68, 33));
        PanelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRegistrar.setText("Registrar usuario");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar)
                .addGap(65, 65, 65)
                .addComponent(btnCancelar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String contrasenna;
        String connUsuario;
        if (comboTipo.getSelectedIndex() == 0 || jtCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Faltan datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (comboTipo.getSelectedItem().equals("Usuario de área") && jComboArea.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Faltan datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Controlador.obtenerInstancia().obtieneEstadoUsuario(jtCorreo.getText()) == 0) {
                JOptionPane.showMessageDialog(this, "El usuario " + Controlador.obtenerInstancia().recortaCorreo(jtCorreo.getText()) + "@castillo.cr"+ " ya está registrado, se encuentra bloqueado", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (Controlador.obtenerInstancia().obtieneEstadoUsuario(jtCorreo.getText()) == 2) {
                if (Controlador.obtenerInstancia().cambiaARegistrado(jtCorreo.getText(), 4 - comboTipo.getSelectedIndex())) {
                    JOptionPane.showMessageDialog(this, "El usuario " + Controlador.obtenerInstancia().recortaCorreo(jtCorreo.getText()) + "@castillo.cr" + "\n"
                            + "ha sido registrado con éxito", "Usuario registrado", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "   No se pudo registrar el usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                        + "desea registrar este usuario?", null, JOptionPane.YES_NO_OPTION)) {
                    contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                    if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                        if (comboTipo.getSelectedItem().equals("Usuario de área")) {
                            connUsuario = GeneradorDeClave.obtenerInstancia().GenerarClave();
                            if ((Controlador.obtenerInstancia().registraUsuarioAdmin(jtCorreo.getText(), 4 - comboTipo.getSelectedIndex(), connUsuario))
                                    && (Controlador.obtenerInstancia().registroAreaUsuario(jtCorreo.getText(), jComboArea.getSelectedItem().toString()))) {
                                JOptionPane.showMessageDialog(this, "   El usuario " + Controlador.obtenerInstancia().recortaCorreo(jtCorreo.getText()) + "@castillo.cr" + "\n"
                                        + "   ha sido registrado con éxito \n"
                                        + "   La contraseña es: " + connUsuario, "Usuario registrado", JOptionPane.INFORMATION_MESSAGE);
                                Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                                        VentanaLogin.correo, "Usuario", "Registró al usuario " + jtCorreo.getText());
                            } else {
                                JOptionPane.showMessageDialog(this, "   No se pudo registrar el usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            connUsuario = GeneradorDeClave.obtenerInstancia().GenerarClave();
                            if (Controlador.obtenerInstancia().registraUsuarioAdmin(jtCorreo.getText(), 4 - comboTipo.getSelectedIndex(), connUsuario)) {
                                JOptionPane.showMessageDialog(this, "   El usuario " + Controlador.obtenerInstancia().recortaCorreo(jtCorreo.getText()) + "@castillo.cr" + "\n"
                                        + "   ha sido registrado con éxito \n"
                                        + "   La contraseña es: " + connUsuario, "Usuario registrado", JOptionPane.INFORMATION_MESSAGE);
                                Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                                        VentanaLogin.correo, "Usuario", "Registró al usuario " + jtCorreo.getText());
                            } else {
                                JOptionPane.showMessageDialog(this, "   No se pudo registrar el usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "   No se pudo registrar el usuario, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea finalizar el ingreso de un nuevo usuario?", null, JOptionPane.YES_NO_OPTION)) {
            Ventana.obtenerInstancia().ventanaPrincipalAdmin();
        }
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        if (comboTipo.getSelectedItem().equals("Usuario de área")) {
            this.cargarjComboArea();
            this.jPanelArea.setVisible(true);
        } else {
            this.jComboArea.setSelectedIndex(0);
            this.jPanelArea.setVisible(false);
        }
    }//GEN-LAST:event_comboTipoActionPerformed

    private void jtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCorreoActionPerformed

    private void limpiarCampos() {
        comboTipo.setSelectedIndex(0);
        jComboArea.setSelectedIndex(0);
        jtCorreo.setText("");
    }

    //Declaracion de variables
    private static PanelRegistrarUsuariosAdmin instancia = null;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JComboBox<String> jComboArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelArea;
    private javax.swing.JTextField jtCorreo;
    private javax.swing.JLabel labelCreador;
    private javax.swing.JLabel labelCreador1;
    // End of variables declaration//GEN-END:variables
}
