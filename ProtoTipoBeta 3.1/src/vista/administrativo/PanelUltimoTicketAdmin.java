package vista.administrativo;

import controlador.Controlador;
import java.awt.event.KeyAdapter;
import javax.swing.JOptionPane;
import modelo.Ticket;
import vista.Ventana;
import vista.VentanaLogin;

public class PanelUltimoTicketAdmin extends javax.swing.JPanel {

    private PanelUltimoTicketAdmin() {
        initComponents();
        this.ajustarEventos();
//        this.limpiarCampos();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelUltimoTicketAdmin obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelUltimoTicketAdmin();
        }
        instancia.limpiarCampos();
        instancia.llenarUltimo(VentanaLogin.correo);
        return instancia;
    }////----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void llenarUltimo(String correo) {

        Ticket _ticket = Controlador.obtenerInstancia().consultaUltimo(correo);
        if (_ticket.getEstado() == null) {
            JOptionPane.showMessageDialog(this, "   No se han encontrado tickets a nombre de este usuario", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {
            this.jLabel1.setText("Último ticket creado: " + _ticket.getConsecutivo());
            this.txtResponsable.setText(_ticket.getResponsable());
            this.txtArea.setText(_ticket.getAreaDestino());
            this.txtAsunto.setText(_ticket.getAsunto());
            //cambiar de borrado a cerrado
            if (_ticket.getEstado().equals("borrado")) {
                this.txtEstado.setText("cerrado");
            } else {
                this.txtEstado.setText(_ticket.getEstado());
            }
            this.txtHora.setText(_ticket.getHora());
            this.txtFecha.setText(_ticket.getFecha());
            this.jTextAreaDetalle.setText(_ticket.getDetalleProblema());
            this.jTextAreaComentarios.setText(_ticket.getComentarios());
            this.jPanelDatos.setVisible(true);

            
            Controlador.obtenerInstancia().ejecutarSentenciaSQL( Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                    VentanaLogin.correo, "Ticket", "Consultó el ticket " + _ticket.getConsecutivo());
            
        }
    }

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        jTextAreaDetalle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextAreaComentarios.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        txtEstado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
//        txtClasificacion.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(java.awt.event.KeyEvent evt) {
//                super.keyPressed(evt);
//                Ventana.obtenerInstancia().tecla();
//            }
//        });
        txtHora.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
//        txtCreador.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(java.awt.event.KeyEvent evt) {
//                super.keyPressed(evt);
//                Ventana.obtenerInstancia().tecla();
//            }
//        });
        txtArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        txtAsunto.addKeyListener(new KeyAdapter() {
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
        jPanelDatos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtResponsable = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtAsunto = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDetalle = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaComentarios = new javax.swing.JTextArea();
        PanelBotones = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(208, 144, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Último ticket creado");

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

        jPanelDatos.setBackground(new java.awt.Color(226, 221, 205));
        jPanelDatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Fecha: ");

        jLabel5.setText("Estado:");

        jLabel7.setText("Hora:");

        jLabel10.setText("Asunto");

        jLabel13.setText("Responsable:");

        jLabel9.setText("Área:");

        jPanel3.setBackground(new java.awt.Color(226, 221, 205));

        txtResponsable.setEditable(false);

        txtArea.setEditable(false);
        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });

        txtEstado.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtArea, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(txtResponsable)
            .addComponent(txtEstado)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(226, 221, 205));

        txtFecha.setEditable(false);

        txtHora.setEditable(false);
        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        txtAsunto.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAsunto, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(txtFecha)
            .addComponent(txtHora)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(158, 143, 123));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextAreaDetalle.setEditable(false);
        jTextAreaDetalle.setColumns(20);
        jTextAreaDetalle.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDetalle);

        jTabbedPane1.addTab("Detalle del problema", jScrollPane1);

        jTextAreaComentarios.setEditable(false);
        jTextAreaComentarios.setColumns(20);
        jTextAreaComentarios.setRows(5);
        jScrollPane2.setViewportView(jTextAreaComentarios);

        jTabbedPane1.addTab("Comentarios", jScrollPane2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelBotones.setBackground(new java.awt.Color(222, 68, 33));
        PanelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCancelar.setText("Regresar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea finalizar la consulta?", null, JOptionPane.YES_NO_OPTION)) {
//            this.txtCreador.setText("");
            this.txtArea.setText("");
            this.txtEstado.setText("");
            this.txtAsunto.setText("");
//            this.txtClasificacion.setText("");
            this.txtHora.setText("");
//            this.jList1.setText("El problema consiste en ...");
            this.jTextAreaDetalle.setText("El problema consiste en ...");
            this.jTextAreaComentarios.setText("");
            Ventana.obtenerInstancia().ventanaPrincipalAdmin();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaActionPerformed

    private void limpiarCampos() {
        this.jLabel1.setText("Último ticket creado");
        jTextAreaComentarios.setText("");
        jTextAreaDetalle.setText("");
        txtArea.setText("");
        txtAsunto.setText("");
        txtEstado.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtResponsable.setText("");
    }

//Declaracion de variables
    private static PanelUltimoTicketAdmin instancia = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaComentarios;
    private javax.swing.JTextArea jTextAreaDetalle;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtResponsable;
    // End of variables declaration//GEN-END:variables
}
