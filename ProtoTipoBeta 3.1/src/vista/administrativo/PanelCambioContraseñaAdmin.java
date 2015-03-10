package vista.administrativo;

import controlador.Controlador;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import vista.standard.*;
import javax.swing.JOptionPane;
import vista.Ventana;
import vista.VentanaLogin;

public class PanelCambioContraseñaAdmin extends javax.swing.JPanel {

    private PanelCambioContraseñaAdmin() {
        initComponents();
        ajustarEventos();
        this.limpiarCampos();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelCambioContraseñaAdmin obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelCambioContraseñaAdmin();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        jPasswordAnterior.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jPasswordNueva.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Ventana.obtenerInstancia().tecla();
               if(16 != Arrays.toString(jPasswordNueva.getPassword()).length()) {
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
        jPasswordNueva2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Ventana.obtenerInstancia().tecla();
               if(16 != Arrays.toString(jPasswordNueva2.getPassword()).length()) {
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

        PanelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelTextos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PanelContrasennas = new javax.swing.JPanel();
        jPasswordAnterior = new javax.swing.JPasswordField();
        jPasswordNueva = new javax.swing.JPasswordField();
        jPasswordNueva2 = new javax.swing.JPasswordField();
        lbmensaje = new javax.swing.JLabel();
        lbmensaje1 = new javax.swing.JLabel();
        PanelBotones = new javax.swing.JPanel();
        btnCambiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        PanelTitulo.setBackground(new java.awt.Color(208, 144, 56));
        PanelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cambio de contraseña");

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        PanelTextos.setBackground(new java.awt.Color(226, 221, 205));
        PanelTextos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(226, 221, 205));

        jPanel2.setBackground(new java.awt.Color(226, 221, 205));

        jLabel2.setText("Contraseña anterior:");

        jLabel3.setText("Nueva contraseña:");

        jLabel4.setText("Repita su contraseña:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanelContrasennas.setBackground(new java.awt.Color(158, 143, 123));
        PanelContrasennas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPasswordAnterior.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordAnteriorActionPerformed(evt);
            }
        });

        jPasswordNueva.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jPasswordNueva2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout PanelContrasennasLayout = new javax.swing.GroupLayout(PanelContrasennas);
        PanelContrasennas.setLayout(PanelContrasennasLayout);
        PanelContrasennasLayout.setHorizontalGroup(
            PanelContrasennasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContrasennasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PanelContrasennasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(jPasswordNueva)
                    .addComponent(jPasswordNueva2))
                .addContainerGap())
        );
        PanelContrasennasLayout.setVerticalGroup(
            PanelContrasennasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContrasennasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPasswordAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordNueva2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelTextosLayout = new javax.swing.GroupLayout(PanelTextos);
        PanelTextos.setLayout(PanelTextosLayout);
        PanelTextosLayout.setHorizontalGroup(
            PanelTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTextosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelContrasennas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTextosLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lbmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelTextosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbmensaje1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelTextosLayout.setVerticalGroup(
            PanelTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTextosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTextosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanelContrasennas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTextosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbmensaje1)
                    .addComponent(lbmensaje))
                .addGap(36, 36, 36))
        );

        PanelBotones.setBackground(new java.awt.Color(222, 68, 33));
        PanelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCambiar.setText("Cambiar");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCambiar)
                .addGap(65, 65, 65)
                .addComponent(btnLimpiar)
                .addGap(65, 65, 65)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambiar)
                    .addComponent(btnCancelar)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTextos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTextos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordAnteriorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea finalizar el cambio de contraseña?", null, JOptionPane.YES_NO_OPTION)) {
            Ventana.obtenerInstancia().ventanaPrincipalAdmin();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        if (String.valueOf(this.jPasswordAnterior.getPassword()).equals("")
                || String.valueOf(this.jPasswordNueva.getPassword()).equals("")
                || String.valueOf(this.jPasswordNueva2.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos para continuar", "ERROR", JOptionPane.ERROR_MESSAGE);
            this.lbmensaje1.setText("");
        } else {
            if (this.validaContrasenna()) {
                if (Controlador.obtenerInstancia().cambiarContrasena(VentanaLogin.correo, String.valueOf(this.jPasswordNueva.getPassword()), String.valueOf(this.jPasswordAnterior.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Tu contraseña ha sido cambiada con éxito", "", JOptionPane.INFORMATION_MESSAGE);

                   
                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                            VentanaLogin.correo, "Usuario", "Cambio de contraseña");
                    

                    this.limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Tu contraseña no se ha podido cambiar", "", JOptionPane.ERROR_MESSAGE);
                    this.lbmensaje1.setText("");
                }
            }
        }
    }//GEN-LAST:event_btnCambiarActionPerformed

    private boolean validaContrasenna() {
        //verifica que se cumplan los requisitos para la contraseña
        boolean ok = true;
        String nl = System.getProperty("line.separator");
        final String pas1 = String.valueOf(this.jPasswordNueva.getPassword());
        if (String.valueOf(this.jPasswordNueva.getPassword()).equals(String.valueOf(this.jPasswordNueva2.getPassword()))) {
            if (pas1.length() >= 6 && pas1.length() <= 16) {
                if (pas1.matches(".*[A-Za-z0-9].*[^@]")) {
//              el primer caracter puede ser cualquiera . es para que se reciba cualquiera
//              * es para que se pueda repetir caracter
//              [^@!] se ponen seguidos los que no se quieren que se usen en la contraseña

//                    int contLetra = 0, conNumero = 0, conSimbolos = 0;
//                    for (int i = 0; i < pas1.length(); i++) {
//                        if (String.valueOf(pas1.charAt(i)).matches("[A-Za-z]")) {
//                            contLetra++;
//                        } else if (String.valueOf(pas1.charAt(i)).matches("[0-9]")) {
//                            conNumero++;
//                        } else if (!String.valueOf(pas1.charAt(i)).matches("[@]")) {
//                            conSimbolos++;
//                        }
//                    }
//                    if (contLetra != 0 && conNumero != 0 && conSimbolos != 0) {
//                        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "La contraseña tiene un nivel alto de seguridad. " + nl
//                                + "¿Deseas modificarla?", null, JOptionPane.YES_NO_OPTION)) {
//                            ok = false;
//                        }
//                    } else if ((contLetra != 0 && conNumero == 0 && conSimbolos == 0)
//                            || (contLetra == 0 && conNumero != 0 && conSimbolos == 0)) {
//                        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "La contraseña tiene un nivel medio de seguridad, " + nl
//                                + "¿Deseas modificarla?", null, JOptionPane.YES_NO_OPTION)) {
//                            ok = false;
//                        }
//                    } else if (conSimbolos > contLetra || conSimbolos > conNumero) {/////
//                        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "La contraseña tiene un nivel bajo de seguridad" + nl
//                                + " ¿Deseas modificarla?", null, JOptionPane.YES_NO_OPTION)) {
//                            ok = false;
//                        }
//                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña no puede tener el caracter especial @ ", "", JOptionPane.WARNING_MESSAGE);
                    this.lbmensaje1.setText("");
                    ok = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña no cumple con los requisitos minimos de seguridad", "", JOptionPane.WARNING_MESSAGE);
                this.lbmensaje1.setText("");
                ok = false;
            }
        } else {
            this.lbmensaje1.setText("* La contraseña no coincide");
            this.lbmensaje1.setForeground(Color.red);
            ok = false;
//                JOptionPane.showMessageDialog(null, "La contraseña nueva no coincide", "", JOptionPane.ERROR_MESSAGE);
        }
        return ok;
    }//----------------------------------------------------------------------------- FIN validaContrasenna()

    private void limpiarCampos() {
        this.jPasswordAnterior.setText("");
        this.jPasswordNueva.setText("");
        this.jPasswordNueva2.setText("");
        this.lbmensaje1.setText("");
    }//----------------------------------------------------------------------------- FIN limpiarCampos()

    //Declaracion de variables
    private static PanelCambioContraseñaAdmin instancia = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JPanel PanelContrasennas;
    private javax.swing.JPanel PanelTextos;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordAnterior;
    private javax.swing.JPasswordField jPasswordNueva;
    private javax.swing.JPasswordField jPasswordNueva2;
    private javax.swing.JLabel lbmensaje;
    private javax.swing.JLabel lbmensaje1;
    // End of variables declaration//GEN-END:variables
}
