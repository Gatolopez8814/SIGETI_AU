package vista.administrativo;

import controlador.Controlador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.Ventana;
import vista.VentanaLogin;

public class PanelBloquearUsuarioAdmin extends javax.swing.JPanel {

    private PanelBloquearUsuarioAdmin() {
        initComponents();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelBloquearUsuarioAdmin obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelBloquearUsuarioAdmin();
        }
        instancia.ajustarEventos();
        instancia.limpiarCampos();
        instancia.cargarjComboUsuarios();
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        txtCorreoBloquear.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Ventana.obtenerInstancia().tecla();
                if (150 != txtCorreoBloquear.getText().length()) {
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBloquearusuario = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        labelCreador = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        txtCorreoBloquear = new javax.swing.JTextField();
        labelCreador1 = new javax.swing.JLabel();
        jComboUsuarios = new javax.swing.JComboBox<String>();

        jPanel3.setBackground(new java.awt.Color(208, 144, 56));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setText("Bloquear usuario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(222, 68, 33));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Limpiar campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnBloquearusuario.setText("Bloquear usuario");
        btnBloquearusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloquearusuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBloquearusuario)
                .addGap(65, 65, 65)
                .addComponent(jButton1)
                .addGap(65, 65, 65)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCancelar)
                    .addComponent(btnBloquearusuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(158, 143, 123));

        jPanel5.setBackground(new java.awt.Color(226, 221, 205));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelCreador.setText("Digite el correo del usuario que desea bloquear");

        labelUsuario.setText("@castillo.cr");

        txtCorreoBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoBloquearActionPerformed(evt);
            }
        });

        labelCreador1.setText("Seleccione el usuario que desea bloquear: ");

        jComboUsuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí" }));
        jComboUsuarios.setToolTipText("");
        jComboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreador)
                    .addComponent(labelCreador1))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCorreoBloquear, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreador1)
                    .addComponent(jComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCreador)
                        .addComponent(labelUsuario))
                    .addComponent(txtCorreoBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(448, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 141, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente desea terminar ahora?", null, JOptionPane.YES_NO_OPTION)) {
            Ventana.obtenerInstancia().ventanaPrincipalAdmin();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBloquearusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloquearusuarioActionPerformed
        if(this.txtCorreoBloquear.getText().equals("") && this.jComboUsuarios.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Faltan datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if(!this.txtCorreoBloquear.getText().equals("") && this.jComboUsuarios.getSelectedIndex()==0){
            if (txtCorreoBloquear.getText().equals(VentanaLogin.correo) || txtCorreoBloquear.getText().equals(VentanaLogin.correo.split("@")[0])){
             JOptionPane.showMessageDialog(this, "No se puede Bloquear a si mismo", "ERROR", JOptionPane.ERROR_MESSAGE);
             this.limpiarCampos();
        }else if(Controlador.obtenerInstancia().obtieneEstadoUsuario(txtCorreoBloquear.getText()) == 0){
            JOptionPane.showMessageDialog(this, "El usuario ya se encuentra bloqueado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
        String contrasenna;
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                + "desea bloquear este usuario?", null, JOptionPane.YES_NO_OPTION)) {
            contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
            if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                if (Controlador.obtenerInstancia().bloqueaUsuarioAdmin(txtCorreoBloquear.getText())) {
                    JOptionPane.showMessageDialog(this, "   El usuario ha sido bloqueado con éxito", "Usuario bloqueado", JOptionPane.INFORMATION_MESSAGE);
                    instancia.cargarjComboUsuarios();
                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                            VentanaLogin.correo, "Usuario", "Bloqueó al usuario " + txtCorreoBloquear.getText());                  
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo bloquear el usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "   No se pudo bloquear el usuario, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
        }else if(this.txtCorreoBloquear.getText().equals("") && this.jComboUsuarios.getSelectedIndex()!=0){
            if(Controlador.obtenerInstancia().obtieneEstadoUsuario(txtCorreoBloquear.getText()) == 0){
            JOptionPane.showMessageDialog(this, "El usuario ya se encuentra bloqueado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
        String contrasenna;
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                + "desea bloquear este usuario?", null, JOptionPane.YES_NO_OPTION)) {
            contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
            if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                if (Controlador.obtenerInstancia().bloqueaUsuarioAdmin(this.jComboUsuarios.getSelectedItem().toString())) {
                    JOptionPane.showMessageDialog(this, "   El usuario ha sido bloqueado con éxito", "Usuario bloqueado", JOptionPane.INFORMATION_MESSAGE);              
                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                            VentanaLogin.correo, "Usuario", "Bloqueó al usuario " + this.jComboUsuarios.getSelectedItem().toString());
                    instancia.cargarjComboUsuarios();
                   this.limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo bloquear el usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "   No se pudo bloquear el usuario, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
        }else{
            JOptionPane.showMessageDialog(this, "Debe elegir una sola opción", "ERROR", JOptionPane.ERROR_MESSAGE);
            instancia.cargarjComboUsuarios();
            this.limpiarCampos();
        }
    }//GEN-LAST:event_btnBloquearusuarioActionPerformed

     private void cargarjComboUsuarios(){
        this.jComboUsuarios.removeAllItems();
        this.jComboUsuarios.addItem("Seleccione aquí");
        ArrayList<String> temp = Controlador.obtenerInstancia().obtieneUsuarios(VentanaLogin.correo, 1);
        for (String temp1 : temp) {
            this.jComboUsuarios.addItem(temp1);
        }
        this.jComboUsuarios.setSelectedIndex(0);
        this.jComboUsuarios.revalidate();
        this.jComboUsuarios.repaint();
    }//----------------------------------------------------------------------------- FIN cargarjComboUsuarios()
     
    private void txtCorreoBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoBloquearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoBloquearActionPerformed

    private void jComboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboUsuariosActionPerformed
        if (jComboUsuarios.getSelectedIndex()==0) {
            this.txtCorreoBloquear.setEnabled(true);
        } else {
            this.txtCorreoBloquear.setEnabled(false);
            this.txtCorreoBloquear.setText("");
        }
    }//GEN-LAST:event_jComboUsuariosActionPerformed

    private void limpiarCampos() {
        txtCorreoBloquear.setText("");
        this.jComboUsuarios.setSelectedIndex(0);
    }
    
    //Declaracion de variables
    private static PanelBloquearUsuarioAdmin instancia = null;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloquearusuario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboUsuarios;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelCreador;
    private javax.swing.JLabel labelCreador1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextField txtCorreoBloquear;
    // End of variables declaration//GEN-END:variables
}
