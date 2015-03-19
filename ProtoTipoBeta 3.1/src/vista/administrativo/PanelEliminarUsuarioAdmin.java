package vista.administrativo;

import controlador.Controlador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.Ventana;
import vista.VentanaLogin;
import vista.VentanaRegistro;

public class PanelEliminarUsuarioAdmin extends javax.swing.JPanel {

    private PanelEliminarUsuarioAdmin() {
        initComponents();
        ajustarEventos();
        this.limpiarCampos();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelEliminarUsuarioAdmin obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelEliminarUsuarioAdmin();
        }
        instancia.cargarjComboUsuarios();
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        txtCorreoEliminar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Ventana.obtenerInstancia().tecla();
                if (150 != txtCorreoEliminar.getText().length()) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminarusuario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelCreador = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        txtCorreoEliminar = new javax.swing.JTextField();
        labelCreador1 = new javax.swing.JLabel();
        jComboUsuarios = new javax.swing.JComboBox<String>();

        jPanel1.setBackground(new java.awt.Color(208, 144, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setText("Eliminar usuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(614, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(222, 68, 33));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Limpiar datos");
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

        btnEliminarusuario.setText("Eliminar usuario");
        btnEliminarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarusuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEliminarusuario)
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
                    .addComponent(btnEliminarusuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(158, 143, 123));

        jPanel2.setBackground(new java.awt.Color(226, 221, 205));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelCreador.setText("Digite el correo del usuario que desea eliminar ");

        labelUsuario.setText("@castillo.cr");

        txtCorreoEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoEliminarActionPerformed(evt);
            }
        });

        labelCreador1.setText("Seleccione el usuario que desea eliminar ");

        jComboUsuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreador)
                    .addComponent(labelCreador1))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCorreoEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jComboUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelUsuario)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreador1)
                    .addComponent(jComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreador)
                    .addComponent(labelUsuario)
                    .addComponent(txtCorreoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente desea terminar ahora?", null, JOptionPane.YES_NO_OPTION)) {
            Ventana.obtenerInstancia().ventanaPrincipalAdmin();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarusuarioActionPerformed
         if(this.txtCorreoEliminar.getText().equals("") && this.jComboUsuarios.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Faltan datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if(!this.txtCorreoEliminar.getText().equals("") && this.jComboUsuarios.getSelectedIndex()==0){
            
            if (txtCorreoEliminar.getText().equals(VentanaLogin.correo) || txtCorreoEliminar.getText().equals(VentanaLogin.correo.split("@")[0])){
             JOptionPane.showMessageDialog(this, "No se puede Eliminar a si mismo", "ERROR", JOptionPane.ERROR_MESSAGE);
             this.limpiarCampos();
        }else if(Controlador.obtenerInstancia().obtieneEstadoUsuario(txtCorreoEliminar.getText()) == 2){
            JOptionPane.showMessageDialog(this, "El usuario ya se encuentra eliminado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
        String contrasenna;
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                + "desea eliminar este usuario?", null, JOptionPane.YES_NO_OPTION)) {
            contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
            if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                if (Controlador.obtenerInstancia().eliminaUsuarioAdmin(txtCorreoEliminar.getText())) {
                    JOptionPane.showMessageDialog(this, "   El usuario ha sido eliminado con éxito", "Usuario eliminado", JOptionPane.INFORMATION_MESSAGE);

                    
                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                            VentanaLogin.correo, "Usuario", "Eliminó al usuario " + txtCorreoEliminar.getText());
                    
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "   No se pudo desbloquear el usuario, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
        }else if(this.txtCorreoEliminar.getText().equals("") && this.jComboUsuarios.getSelectedIndex()!=0){
            if(Controlador.obtenerInstancia().obtieneEstadoUsuario(jComboUsuarios.getSelectedItem().toString()) == 2){
            JOptionPane.showMessageDialog(this, "El usuario ya se encuentra eliminado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
        String contrasenna;
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                + "desea eliminar este usuario?", null, JOptionPane.YES_NO_OPTION)) {
            contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
            if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                if (Controlador.obtenerInstancia().eliminaUsuarioAdmin(jComboUsuarios.getSelectedItem().toString())) {
                    JOptionPane.showMessageDialog(this, "   El usuario ha sido eliminado con éxito", "Usuario eliminado", JOptionPane.INFORMATION_MESSAGE);

                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                            VentanaLogin.correo, "Usuario", "Eliminó al usuario " + jComboUsuarios.getSelectedItem().toString());
                    instancia.cargarjComboUsuarios();
                    this.limpiarCampos();
                    
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "   No se pudo desbloquear el usuario, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
        }else{
            JOptionPane.showMessageDialog(this, "Debe elegir una sola opción", "ERROR", JOptionPane.ERROR_MESSAGE);
            instancia.cargarjComboUsuarios();
            this.limpiarCampos();
        }
        
    }//GEN-LAST:event_btnEliminarusuarioActionPerformed

    private void cargarjComboUsuarios(){
        this.jComboUsuarios.removeAllItems();
        this.jComboUsuarios.addItem("Seleccione aquí");
        ArrayList<String> temp = Controlador.obtenerInstancia().obtieneUsuariosEliminar(VentanaLogin.correo, 2);
        for (String temp1 : temp) {
            this.jComboUsuarios.addItem(temp1);
        }
        this.jComboUsuarios.setSelectedIndex(0);
        this.jComboUsuarios.revalidate();
        this.jComboUsuarios.repaint();
    }//----------------------------------------------------------------------------- FIN cargarjComboUsuarios()
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCorreoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoEliminarActionPerformed

    private void limpiarCampos() {
        txtCorreoEliminar.setText("");
        this.jComboUsuarios.setSelectedIndex(0);
    }

    //Declaracion de variables
    private static PanelEliminarUsuarioAdmin instancia = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarusuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelCreador;
    private javax.swing.JLabel labelCreador1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextField txtCorreoEliminar;
    // End of variables declaration//GEN-END:variables
}
