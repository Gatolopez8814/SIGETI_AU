package vista.Area;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.Controlador;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Ticket;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import vista.Ventana;
import vista.VentanaLogin;
import static vista.administrativo.PanelReportesAdmin.isFechaValida;

public class PanelReportesArea extends javax.swing.JPanel {

    private PanelReportesArea() {
        initComponents();
        this.limpiarCampos();
        ocultarComponentes();
        ajustarEventos();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelReportesArea obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelReportesArea();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void ajustarEventos() {

    }

    private void ocultarComponentes() {
        this.btnReporte.setEnabled(false);
        this.jPanelArea.setVisible(false);
        this.btnLimpiar.setEnabled(false);
        this.jPanelRangoFechas.setVisible(false);
        this.jPanelTabla3.setVisible(false);
        this.jPanelRangoHoras.setVisible(false);

    }//----------------------------------------------------------------------------- FIN ocultarComponentes()

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jPanelSeleccion = new javax.swing.JPanel();
        jLabelSubtitulo = new javax.swing.JLabel();
        ComboBusqueda = new javax.swing.JComboBox();
        jPanelArea = new javax.swing.JPanel();
        jLabelAreas = new javax.swing.JLabel();
        jComboArea = new javax.swing.JComboBox();
        jPanelRangoHoras = new javax.swing.JPanel();
        jLabelHoraInicio = new javax.swing.JLabel();
        jLabelGuion6 = new javax.swing.JLabel();
        jLabelHoraFinal = new javax.swing.JLabel();
        jLabelGuion8 = new javax.swing.JLabel();
        comboHoraInicial = new javax.swing.JComboBox();
        comboMinutoInicial = new javax.swing.JComboBox();
        comboHoraFinal = new javax.swing.JComboBox();
        comboMinutoFinal = new javax.swing.JComboBox();
        jPanelRangoFechas = new javax.swing.JPanel();
        jLabelDesde = new javax.swing.JLabel();
        jLabelGuion1 = new javax.swing.JLabel();
        jLabelGuion2 = new javax.swing.JLabel();
        jLabelHasta = new javax.swing.JLabel();
        jLabelGuion3 = new javax.swing.JLabel();
        jLabelGuion4 = new javax.swing.JLabel();
        jComboDiaDesde = new javax.swing.JComboBox<String>();
        jComboMesDesde = new javax.swing.JComboBox<String>();
        jComboAñoDesde = new javax.swing.JComboBox<String>();
        jComboDiaHasta = new javax.swing.JComboBox<String>();
        jComboMesHasta = new javax.swing.JComboBox<String>();
        jComboAñosHasta = new javax.swing.JComboBox<String>();
        PanelBotones = new javax.swing.JPanel();
        btnReporte = new javax.swing.JButton();
        btnCancelarReporte = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanelTabla3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaReporte = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();
        jLabelDesde3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(252, 239, 148));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(102, 51, 0));
        labelTitulo.setText("Generar reportes de tickets");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelSeleccion.setBackground(new java.awt.Color(217, 213, 206));
        jPanelSeleccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelSubtitulo.setText("Seleccione el tipo de reporte que desea: ");

        ComboBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí", "Rango de fechas", "Rango de horas", "Según área especifica" }));
        ComboBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSeleccionLayout = new javax.swing.GroupLayout(jPanelSeleccion);
        jPanelSeleccion.setLayout(jPanelSeleccionLayout);
        jPanelSeleccionLayout.setHorizontalGroup(
            jPanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSubtitulo)
                .addGap(52, 52, 52)
                .addComponent(ComboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSeleccionLayout.setVerticalGroup(
            jPanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeleccionLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSubtitulo)
                    .addComponent(ComboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanelArea.setBackground(new java.awt.Color(119, 172, 209));
        jPanelArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelAreas.setText("Seleccione el área: ");

        jComboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí", "Soporte técnico", "Mantenimiento" }));
        jComboArea.setToolTipText("");
        jComboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAreaLayout = new javax.swing.GroupLayout(jPanelArea);
        jPanelArea.setLayout(jPanelAreaLayout);
        jPanelAreaLayout.setHorizontalGroup(
            jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAreas)
                .addGap(115, 115, 115)
                .addComponent(jComboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAreaLayout.setVerticalGroup(
            jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAreas)
                    .addComponent(jComboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelRangoHoras.setBackground(new java.awt.Color(119, 172, 209));
        jPanelRangoHoras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelHoraInicio.setText("Hora inicial: ");

        jLabelGuion6.setText(":");

        jLabelHoraFinal.setText("Hora Final: ");

        jLabelGuion8.setText(":");

        comboHoraInicial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        comboMinutoInicial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí", "00", "15", "30", "45" }));

        comboHoraFinal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        comboMinutoFinal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí", "00", "15", "30", "45" }));

        javax.swing.GroupLayout jPanelRangoHorasLayout = new javax.swing.GroupLayout(jPanelRangoHoras);
        jPanelRangoHoras.setLayout(jPanelRangoHorasLayout);
        jPanelRangoHorasLayout.setHorizontalGroup(
            jPanelRangoHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRangoHorasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHoraInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabelGuion6, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(comboMinutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabelHoraFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabelGuion8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(comboMinutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );
        jPanelRangoHorasLayout.setVerticalGroup(
            jPanelRangoHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRangoHorasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRangoHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHoraInicio)
                    .addComponent(jLabelGuion6)
                    .addComponent(jLabelHoraFinal)
                    .addComponent(comboHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMinutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMinutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRangoFechas.setBackground(new java.awt.Color(119, 172, 209));
        jPanelRangoFechas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelDesde.setText("Desde: ");

        jLabelGuion1.setText("-");

        jLabelGuion2.setText("-");

        jLabelHasta.setText("Hasta:");

        jLabelGuion3.setText("-");

        jLabelGuion4.setText("-");

        jComboDiaDesde.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboMesDesde.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre" }));

        jComboAñoDesde.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));
        jComboAñoDesde.setToolTipText("");

        jComboDiaHasta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboDiaHasta.setToolTipText("");

        jComboMesHasta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboMesHasta.setToolTipText("");

        jComboAñosHasta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));
        jComboAñosHasta.setToolTipText("");

        javax.swing.GroupLayout jPanelRangoFechasLayout = new javax.swing.GroupLayout(jPanelRangoFechas);
        jPanelRangoFechas.setLayout(jPanelRangoFechasLayout);
        jPanelRangoFechasLayout.setHorizontalGroup(
            jPanelRangoFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRangoFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDesde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboAñoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboMesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboAñosHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRangoFechasLayout.setVerticalGroup(
            jPanelRangoFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRangoFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRangoFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDesde)
                    .addComponent(jLabelGuion1)
                    .addComponent(jLabelGuion2)
                    .addComponent(jLabelHasta)
                    .addComponent(jLabelGuion4)
                    .addComponent(jLabelGuion3)
                    .addComponent(jComboDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboAñoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboMesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboAñosHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelBotones.setBackground(new java.awt.Color(9, 46, 105));
        PanelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnReporte.setText("Generar reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnCancelarReporte.setText("Cancelar");
        btnCancelarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReporteActionPerformed(evt);
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
                .addComponent(btnReporte)
                .addGap(65, 65, 65)
                .addComponent(btnLimpiar)
                .addGap(65, 65, 65)
                .addComponent(btnCancelarReporte)
                .addContainerGap(467, Short.MAX_VALUE))
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarReporte)
                    .addComponent(btnReporte)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTabla3.setBackground(new java.awt.Color(226, 221, 205));
        jPanelTabla3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(158, 143, 123), 10));

        tablaReporte.setBackground(new java.awt.Color(201, 201, 201));
        tablaReporte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Estado", " Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaReporte.setToolTipText("");
        tablaReporte.setAlignmentX(2.0F);
        tablaReporte.setAlignmentY(2.0F);
        tablaReporte.setAutoscrolls(false);
        tablaReporte.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablaReporte.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tablaReporte);

        btnExportar.setText("Exportar a PDF");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jLabelDesde3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDesde3.setText("Tickets según estado");

        javax.swing.GroupLayout jPanelTabla3Layout = new javax.swing.GroupLayout(jPanelTabla3);
        jPanelTabla3.setLayout(jPanelTabla3Layout);
        jPanelTabla3Layout.setHorizontalGroup(
            jPanelTabla3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabla3Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(btnExportar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabla3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDesde3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );
        jPanelTabla3Layout.setVerticalGroup(
            jPanelTabla3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabla3Layout.createSequentialGroup()
                .addComponent(jLabelDesde3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelTabla3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTabla3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTabla3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnExportar)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRangoHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRangoFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTabla3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRangoFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRangoHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTabla3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBusquedaActionPerformed
        //Rango de fechas, Rango de horas, Según área especifica, Tickets redireccionados, Tiempos de solución
        ocultarComponentes();
        if (ComboBusqueda.getSelectedIndex() == 0) {
        } else if (ComboBusqueda.getSelectedItem().equals("Rango de fechas")) {
            this.cargarComboAnnos();
            jPanelRangoFechas.setVisible(true);
            this.btnReporte.setEnabled(true);
        }
        if (ComboBusqueda.getSelectedItem().equals("Rango de horas")) {
            this.cargarjComboArea();
            jPanelRangoHoras.setVisible(true);
            this.btnReporte.setEnabled(true);
        }
        if (ComboBusqueda.getSelectedItem().equals("Según área especifica")) {
            jPanelArea.setVisible(true);
            this.btnReporte.setEnabled(true);
        }
    }//GEN-LAST:event_ComboBusquedaActionPerformed

    private void cargarjComboArea() {
        this.jComboArea.removeAllItems();
        ArrayList<String> temp = Controlador.obtenerInstancia().obtieneAreas();
        // this.jComboArea.addItem("Seleccione aquí");
        for (int i = 0; i < temp.size(); i++) {
            this.jComboArea.addItem(temp.get(i));
        }
        this.jComboArea.setSelectedIndex(0);
        this.jComboArea.revalidate();
        this.jComboArea.repaint();
    }//----------------------------------------------------------------------------- FIN cargarjComboArea()

    private void jComboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboAreaActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        this.jPanelTabla3.setVisible(true);
        modelAux = (DefaultTableModel) tablaReporte.getModel();
        String a = (String) jComboArea.getSelectedItem();
        System.out.println((String) jComboArea.getSelectedItem());
        while (modelAux.getRowCount() > 0) {
            modelAux.removeRow(0);
        }
        if (ComboBusqueda.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Opción de busqueda incorrecta", "ERROR",
                JOptionPane.ERROR_MESSAGE);
        } else if (ComboBusqueda.getSelectedItem().equals("Según área especifica")) {
            if (jComboArea.getSelectedItem().equals("Seleccione aquí")) {
                JOptionPane.showMessageDialog(null, "Seleccione un area.", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            } else {
                ArrayList<String> aux = Controlador.obtenerInstancia().consultaTodosReporteMiArea(a, VentanaLogin.correo);
                if (aux.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se han encontrado tickets referentes a esta area.", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                } else {
                    int i = 0;
                    while (i < aux.size()) {
                        modelAux.insertRow(modelAux.getRowCount(), new Object[]{
                            aux.get(i), aux.get(i + 1)});
                    i = i + 2;
                    //                        jTable1.setModel(modelAux);
                }
            }
            this.tablaReporte.revalidate();
            this.tablaReporte.repaint();
            this.tablaReporte.setVisible(true);
            this.btnLimpiar.setEnabled(true);
        }

        } else if (ComboBusqueda.getSelectedItem().equals("Rango de horas")) {

            if (this.comboHoraInicial.getSelectedIndex() != 0
                && this.comboMinutoInicial.getSelectedIndex() != 0
                && this.comboHoraFinal.getSelectedIndex() != 0
                && this.comboMinutoFinal.getSelectedIndex() != 0) {
                if (Integer.parseInt(comboHoraInicial.getSelectedItem().toString()) > Integer.parseInt(comboHoraFinal.getSelectedItem().toString())) {
                    JOptionPane.showMessageDialog(null, "Rango de horas erroneo.", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                }else
                if ((Integer.parseInt(comboHoraInicial.getSelectedItem().toString()) ==
                    Integer.parseInt(comboHoraFinal.getSelectedItem().toString()))&&
                (Integer.parseInt(comboMinutoInicial.getSelectedItem().toString()) >
                    Integer.parseInt(comboMinutoFinal.getSelectedItem().toString()))) {
                JOptionPane.showMessageDialog(null, "Rango de horas erroneo.", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            }else {
                hora1 = this.comboHoraInicial.getSelectedItem().toString() + ":"
                + this.comboMinutoInicial.getSelectedItem().toString() + ":00";
                hora2 = this.comboHoraFinal.getSelectedItem().toString() + ":"
                + this.comboMinutoFinal.getSelectedItem().toString() + ":59";
                System.err.println(hora1 + "   " + hora2);
                System.err.println(hora1 + "  " + hora2);
                //  if (isHoraValida(hora1) && isHoraValida(hora2)) {
                    ArrayList<String> aux = Controlador.obtenerInstancia().consultaReporteHorasArea(hora1, hora2,VentanaLogin.correo);

                    if (aux.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se han encontrado tickets en este rango de horas.", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    } else {
                        int i = 0;
                        while (i < aux.size()) {
                            modelAux.insertRow(modelAux.getRowCount(), new Object[]{
                                aux.get(i), aux.get(i + 1)});
                        i = i + 2;
                        //                        jTable1.setModel(modelAux);
                    }

                    //                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                        //                            VentanaLogin.correo, "Ticket", "Consultó historial");
                }
                tablaReporte.setVisible(true);
                tablaReporte.revalidate();
                tablaReporte.repaint();
                this.btnLimpiar.setEnabled(true);
                // this.jPanelTabla3.setVisible(true);
                //            } else {
                //                JOptionPane.showMessageDialog(null, "Horas invalidas.", "ERROR",
                    //                        JOptionPane.ERROR_MESSAGE);
            }
        }
        } else {
            String dia1, mes1, anno1, dia2, mes2, anno2;
            dia1 = this.jComboDiaDesde.getSelectedItem().toString();
            mes1 = String.valueOf(this.jComboMesDesde.getSelectedIndex() + 1);
            anno1 = this.jComboAñoDesde.getSelectedItem().toString();
            dia2 = this.jComboDiaHasta.getSelectedItem().toString();
            mes2 = String.valueOf(this.jComboMesHasta.getSelectedIndex() + 1);
            anno2 = this.jComboAñosHasta.getSelectedItem().toString();
            fecha1 = anno1 + "-" + mes1 + "-" + dia1;
            fecha2 = anno2 + "-" + mes2 + "-" + dia2;
            System.err.println(fecha1 + "  " + fecha2);
            if (isFechaValida(fecha1) && isFechaValida(fecha2)) {
                ArrayList<String> aux = Controlador.obtenerInstancia().consultaReporteFechaArea(fecha1, fecha2,VentanaLogin.correo);

                if (aux.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se han encontrado tickets en este rango de fechas.", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                } else {
                    int i = 0;
                    while (i < aux.size()) {
                        modelAux.insertRow(modelAux.getRowCount(), new Object[]{
                            aux.get(i), aux.get(i + 1)});
                    i = i + 2;
                    //                        jTable1.setModel(modelAux);
                }

                Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                    VentanaLogin.correo, "Ticket", "Consultó historial");

            }
            tablaReporte.setVisible(true);
            tablaReporte.revalidate();
            tablaReporte.repaint();
            // this.jPanelTabla3.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Fechas invalidas.", "ERROR",
                JOptionPane.ERROR_MESSAGE);
        }

        }//fin else fechas

    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnCancelarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReporteActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea finalizar el reporte?", null, JOptionPane.YES_NO_OPTION)) {
            Ventana.obtenerInstancia().ventanaPrincipalAdmin();
        }
    }//GEN-LAST:event_btnCancelarReporteActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        String ruta = this.obtieneRuta();
        try {
            Document document = new Document();
            System.out.println(ruta);
            if (!ruta.contains(".pdf")) {//crea el archivo con extension pdf si no la trae ejemplo archivo.txt lo pasa a
                //archivo.txt.pdf
                ruta = ruta + ".pdf";
            }
            if (ComboBusqueda.getSelectedItem().equals("Según área especifica")) {
                writeChartToPDF(document, generateBarChartMiArea(), 400, 400, ruta);
            } else if (ComboBusqueda.getSelectedItem().equals("Rango de fechas")) {
                writeChartToPDF(document, generateBarChartFechas(), 400, 400, ruta);
            } else if (ComboBusqueda.getSelectedItem().equals("Rango de horas")) {
                writeChartToPDF(document, generateBarChartHoras(), 400, 400, ruta);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }//GEN-LAST:event_btnExportarActionPerformed

     private void cargarComboAnnos() {
        ArrayList<String> lstAnyos;
        lstAnyos = new ArrayList<>();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2015; i <= year; i++) {
            lstAnyos.add(String.valueOf(i));
        }
        for (String temp : lstAnyos) {
            this.jComboAñoDesde.addItem(temp);
            this.jComboAñosHasta.addItem(temp);
        }
        this.jComboAñoDesde.setSelectedIndex(0);
        this.jComboAñoDesde.revalidate();
        this.jComboAñoDesde.repaint();
        this.jComboAñosHasta.setSelectedIndex(0);
        this.jComboAñosHasta.revalidate();
        this.jComboAñosHasta.repaint();
    }
     
    private String obtieneEstado(Ticket _ticket) {
        String estado = "";
        if (_ticket.getEstado().equals("borrado")) {
            estado = "cerrado";
        } else {
            estado = _ticket.getEstado();
        }
        return estado;
    }//----------------------------------------------------------------------------- FIN obtieneEstado()

    private void limpiarCampos() {
        jComboArea.setSelectedIndex(0);
        ComboBusqueda.setSelectedIndex(0);
        jComboAñoDesde.setSelectedIndex(0);
        jComboAñosHasta.setSelectedIndex(0);
        jComboDiaDesde.setSelectedIndex(0);
        jComboDiaHasta.setSelectedIndex(0);

        jComboMesDesde.setSelectedIndex(0);
        jComboMesHasta.setSelectedIndex(0);

        comboHoraFinal.setSelectedIndex(0);
        comboHoraInicial.setSelectedIndex(0);
        comboMinutoFinal.setSelectedIndex(0);
        comboMinutoInicial.setSelectedIndex(0);
    }


    private String obtieneRuta() {//obtiene la ruta que el usuario quiere con todo y nombre el archivo que le pone
        JFileChooser file = new JFileChooser();
        file.showSaveDialog(this);
        File ruta = file.getSelectedFile();
        if (ruta != null) {
            return ruta.getPath();
        }
        return "";
    }

    public JFreeChart generateBarChartMiArea() {
        String a = (String) jComboArea.getSelectedItem();
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(Integer.parseInt(Controlador.obtenerInstancia().consultaTodosReporteMiArea(a, correo).get(1)), "",
                Controlador.obtenerInstancia().consultaTodosReporteMiArea(a, correo).get(0));

        dataSet.setValue(Integer.parseInt(Controlador.obtenerInstancia().consultaTodosReporteMiArea(a, correo).get(3)), "",
                Controlador.obtenerInstancia().consultaTodosReporteMiArea(a, correo).get(2));

        dataSet.setValue(Integer.parseInt(Controlador.obtenerInstancia().consultaTodosReporteMiArea(a, correo).get(5)), "",
                Controlador.obtenerInstancia().consultaTodosReporteMiArea(a, correo).get(4));

        JFreeChart chart = ChartFactory.createBarChart(
                "Reporte de tickets del área " + a, "Estado de tickets", "Cantidad de tickets",
                dataSet, PlotOrientation.VERTICAL, false, true, false);

        return chart;
    }

    public JFreeChart generateBarChartFechas() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(Integer.parseInt(Controlador.obtenerInstancia().consultaReporteFechaArea(fecha1, fecha2,VentanaLogin.correo).get(1)), "",
                Controlador.obtenerInstancia().consultaReporteFechaArea(fecha1, fecha2,VentanaLogin.correo).get(0));

        dataSet.setValue(Integer.parseInt(Controlador.obtenerInstancia().consultaReporteFechaArea(fecha1, fecha2,VentanaLogin.correo).get(3)), "",
                Controlador.obtenerInstancia().consultaReporteFechaArea(fecha1, fecha2,VentanaLogin.correo).get(2));

        dataSet.setValue(Integer.parseInt(Controlador.obtenerInstancia().consultaReporteFechaArea(fecha1, fecha2,VentanaLogin.correo).get(5)), "",
                Controlador.obtenerInstancia().consultaReporteFechaArea(fecha1, fecha2,VentanaLogin.correo).get(4));

        JFreeChart chart = ChartFactory.createBarChart(
                "Reporte de tickets del día " + fecha1 + " al " + fecha2, "Estado de tickets", "Cantidad de tickets",
                dataSet, PlotOrientation.VERTICAL, false, true, false);

        return chart;
    }

    public JFreeChart generateBarChartHoras() {

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(Integer.parseInt(Controlador.obtenerInstancia().consultaReporteHorasArea(hora1, hora2,VentanaLogin.correo).get(1)), "",
                Controlador.obtenerInstancia().consultaReporteHorasArea(hora1, hora2,VentanaLogin.correo).get(0));

        dataSet.setValue(Integer.parseInt(Controlador.obtenerInstancia().consultaReporteHorasArea(hora1, hora2,VentanaLogin.correo).get(3)), "",
                Controlador.obtenerInstancia().consultaReporteHorasArea(hora1, hora2,VentanaLogin.correo).get(2));

        dataSet.setValue(Integer.parseInt(Controlador.obtenerInstancia().consultaReporteHorasArea(hora1, hora2,VentanaLogin.correo).get(5)), "",
                Controlador.obtenerInstancia().consultaReporteHorasArea(hora1, hora2,VentanaLogin.correo).get(4));

        JFreeChart chart = ChartFactory.createBarChart(
                "Reporte de tickets entre las " + hora1 + " y las " + hora2, "Estado de tickets", "Cantidad de tickets",
                dataSet, PlotOrientation.VERTICAL, false, true, false);

        return chart;
    }

    public static void writeChartToPDF(Document document, JFreeChart chart, int width, int height, String fileName) {
        PdfWriter writer = null;
        document = new Document();
        try {
//            System.err.println("entro al try");
            writer = PdfWriter.getInstance(document, new FileOutputStream(
                    fileName));
            document.open();
            document.add(new Paragraph("Reporte de tickets"));
            document.add(new Paragraph(new Date().toString()));
//            System.err.println("abrio el doc");
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(width, height);
            Graphics2D graphics2d = template.createGraphics(width, height, new DefaultFontMapper());
            Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width,
                    height);

            chart.draw(graphics2d, rectangle2d);
//            System.err.println("dibuja grafico");
            graphics2d.dispose();
            contentByte.addTemplate(template, 100, 250);

        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
//        System.err.println("cerro el doc");
        JOptionPane.showMessageDialog(null,
                "El archivo se a guardado exitosamente como " + "\n" + fileName,
                "", JOptionPane.INFORMATION_MESSAGE);
    }

//Declaracion de variables
    private static PanelReportesArea instancia = null;
    DefaultTableModel modelAux;
    String fecha1, fecha2, hora1, hora2;
    String correo = VentanaLogin.correo;

    String fecha = new Date().toString();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBusqueda;
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JButton btnCancelarReporte;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox comboHoraFinal;
    private javax.swing.JComboBox comboHoraInicial;
    private javax.swing.JComboBox comboMinutoFinal;
    private javax.swing.JComboBox comboMinutoInicial;
    private javax.swing.JComboBox jComboArea;
    private javax.swing.JComboBox<String> jComboAñoDesde;
    private javax.swing.JComboBox<String> jComboAñosHasta;
    private javax.swing.JComboBox<String> jComboDiaDesde;
    private javax.swing.JComboBox<String> jComboDiaHasta;
    private javax.swing.JComboBox<String> jComboMesDesde;
    private javax.swing.JComboBox<String> jComboMesHasta;
    private javax.swing.JLabel jLabelAreas;
    private javax.swing.JLabel jLabelDesde;
    private javax.swing.JLabel jLabelDesde3;
    private javax.swing.JLabel jLabelGuion1;
    private javax.swing.JLabel jLabelGuion2;
    private javax.swing.JLabel jLabelGuion3;
    private javax.swing.JLabel jLabelGuion4;
    private javax.swing.JLabel jLabelGuion6;
    private javax.swing.JLabel jLabelGuion8;
    private javax.swing.JLabel jLabelHasta;
    private javax.swing.JLabel jLabelHoraFinal;
    private javax.swing.JLabel jLabelHoraInicio;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelArea;
    private javax.swing.JPanel jPanelRangoFechas;
    private javax.swing.JPanel jPanelRangoHoras;
    private javax.swing.JPanel jPanelSeleccion;
    private javax.swing.JPanel jPanelTabla3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tablaReporte;
    // End of variables declaration//GEN-END:variables
}
