package vista.Area;

import controlador.Controlador;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.Ventana;
import vista.VentanaLogin;

public class PanelCrearTicketArea extends javax.swing.JPanel {//panel donde se encuentran las opciones para crear el Ticket

    private PanelCrearTicketArea() {
        initComponents();
        this.limpiarCampos();
        this.ajustarEventos();
//        this.cargarjComboArea();
//        this.cargarjComboAsunto();
    }//----------------------------------------------------------------------------- FIN Constructor()

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        jTextDetalle.addFocusListener(new FocusListener() {                       //Focus Listener de TextArea
            @Override
            public void focusGained(FocusEvent e) {                             // Limpia el TextArea cuando se le da click
                if (jTextDetalle.getText().equals("El problema consiste en ...")) {
                    jTextDetalle.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {                               //Devuelve el TextArea a su estado por default
                if (jTextDetalle.getText().equals("")) {                            //si el usuario no escribio nada
                    jTextDetalle.setText("El problema consiste en ...");
                }
            }
        });
        jTextDetalle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        txtEspecificacion2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Ventana.obtenerInstancia().tecla();
                if (150 != txtEspecificacion2.getText().length()) {
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
    }//----------------------------------------------------------------------------- FIN ajustarEventos()

    public static PanelCrearTicketArea obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelCrearTicketArea();
        }
        instancia.cargarjComboArea();
        instancia.cargarjComboAsunto();
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

    private void cargarjComboAsunto() {
        this.jComboAsunto.removeAllItems();
        this.jComboAsunto.addItem("Seleccione aquí");
        this.jComboAsunto.addItem("Otro");
        ArrayList<String> temp = Controlador.obtenerInstancia().obtieneAsuntos();
        for (int i = 0; i < temp.size(); i++) {
            this.jComboAsunto.addItem(temp.get(i));
        }
        this.jComboAsunto.setSelectedIndex(0);
        this.jComboAsunto.revalidate();
        this.jComboAsunto.repaint();
    }//----------------------------------------------------------------------------- FIN cargarjComboAsunto()

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboAsunto = new javax.swing.JComboBox<String>();
        txtEspecificacion2 = new javax.swing.JTextField();
        jComboArea = new javax.swing.JComboBox<String>();
        txtEspecificacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextDetalle = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jLabel16.setText("-|-|-|-|-");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(252, 239, 148));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(102, 51, 0));
        labelTitulo.setLabelFor(labelTitulo);
        labelTitulo.setText("Nuevo ticket");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(217, 213, 206));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Asunto: ");

        jLabel11.setText("Área de destino: ");

        jLabel6.setText("Especifique:");

        jComboAsunto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí" }));
        jComboAsunto.setToolTipText("");
        jComboAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAsuntoActionPerformed(evt);
            }
        });

        txtEspecificacion2.setEnabled(false);

        jComboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí" }));
        jComboArea.setToolTipText("");
        jComboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(60, 60, 60)
                        .addComponent(jComboAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jComboArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEspecificacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jComboAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEspecificacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        txtEspecificacion.setBackground(new java.awt.Color(119, 172, 209));
        txtEspecificacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTextDetalle.setColumns(20);
        jTextDetalle.setRows(5);
        jTextDetalle.setText("El problema consiste en ...");
        jScrollPane1.setViewportView(jTextDetalle);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 51, 0));
        jLabel12.setText("Detalle del problema:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Se recomienda indicar la ubicación donde sucede el problema.");

        javax.swing.GroupLayout txtEspecificacionLayout = new javax.swing.GroupLayout(txtEspecificacion);
        txtEspecificacion.setLayout(txtEspecificacionLayout);
        txtEspecificacionLayout.setHorizontalGroup(
            txtEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtEspecificacionLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(txtEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                    .addGroup(txtEspecificacionLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        txtEspecificacionLayout.setVerticalGroup(
            txtEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtEspecificacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(txtEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(9, 46, 105));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Limpiar campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Crear Ticket");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                .addComponent(jButton2)
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
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEspecificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEspecificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboAreaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea finalizar la creación del ticket?", null, JOptionPane.YES_NO_OPTION)) {
            this.limpiarCampos();
            Ventana.obtenerInstancia().ventanaPrincipalArea();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (jComboAsunto.getSelectedItem().toString().equals("Otro") && (txtEspecificacion2.getText().equals("")
                || (jComboArea.getSelectedIndex() == 0)
                || (jTextDetalle.getText().equals("El problema consiste en ...")))) {
            JOptionPane.showMessageDialog(this, "   Faltan datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if ((jComboAsunto.getSelectedIndex() == 0) || (jComboArea.getSelectedIndex() == 0)
                || (jTextDetalle.getText().equals("El problema consiste en ..."))) {
            JOptionPane.showMessageDialog(this, "   Faltan datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                    + "desea crear el ticket?", null, JOptionPane.YES_NO_OPTION)) {
                int consecutivo = Controlador.obtenerInstancia().consultarConsecutivoTicket();
                if (Controlador.obtenerInstancia().registraNuevoTicket(jTextDetalle.getText(), consecutivo, "1", "No hay comentarios",
                        VentanaLogin.correo, 1, jComboArea.getSelectedItem().toString(), "No asignado", "No asignado", "No asignado",
                        jComboAsunto.getSelectedItem().toString(), "curtime()", "curdate()", txtEspecificacion2.getText())) {
                    JOptionPane.showMessageDialog(this, "   El ticket ha sido creado con éxito", "Ticket creado",
                            JOptionPane.INFORMATION_MESSAGE);

                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora() + 1,
                            VentanaLogin.correo, "Ticket", "Creó el ticket " + consecutivo);
                    this.limpiarCampos();

                    JOptionPane.showMessageDialog(this, "   Falta enviar correo", "Recordatorio",
                            JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "   No se pudo crear el ticket", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAsuntoActionPerformed
        if (jComboAsunto.getSelectedIndex() == 1) {
            txtEspecificacion2.setEnabled(true);
        } else {
            txtEspecificacion2.setText("");
            txtEspecificacion2.setEnabled(false);
        }
    }//GEN-LAST:event_jComboAsuntoActionPerformed

    private void limpiarCampos() {
        this.jComboArea.setSelectedIndex(0);
        this.jComboAsunto.setSelectedIndex(0);
        this.txtEspecificacion2.setText("");
        this.jTextDetalle.setText("El problema consiste en ...");
    }

    //Declaracion de variables
    private static PanelCrearTicketArea instancia = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboArea;
    private javax.swing.JComboBox<String> jComboAsunto;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextDetalle;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel txtEspecificacion;
    private javax.swing.JTextField txtEspecificacion2;
    // End of variables declaration//GEN-END:variables
}//____________________________________________________________________END_CLASS 

