package vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Alertas {

    private Alertas() {
    }

    public static Alertas obtenerInstancia() {//asi garantizamos que solo aya una ventana
        if (instancia == null) {
            instancia = new Alertas();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    public void WarningAlert(String mensaje) {
        Ventana.obtenerInstancia().setBarraEstado("Warning " + mensaje);
        final JOptionPane pane = new JOptionPane(mensaje);
        pane.setMessageType(JOptionPane.WARNING_MESSAGE);
        final JDialog d = pane.createDialog((JFrame) null, "Warning");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/warning-icon.png"));
        d.setIconImage(icon);
        d.setLocation(sizeX - (mensaje.length()), sizeY);
        Toolkit.getDefaultToolkit().beep();
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ventana.obtenerInstancia().alertaTicketsAdmin();
            }//----------------------------------------------------------------------------- FIN mouseClicked()

            @Override
            public void mousePressed(MouseEvent e) {
                Ventana.obtenerInstancia().alertaTicketsAdmin();
            }//----------------------------------------------------------------------------- FIN mousePressed()
        });
        d.setVisible(true);
        Ventana.obtenerInstancia().setBarraEstadoMensajeAnterior();
    }

    public void CautionAlert(String mensaje) {
        Ventana.obtenerInstancia().setBarraEstado("Alerta " + mensaje);
        final JOptionPane pane = new JOptionPane(mensaje);
        pane.setMessageType(JOptionPane.ERROR_MESSAGE);
        final JDialog d = pane.createDialog((JFrame) null, "Alerta");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/Alerts-icon.png"));
        d.setIconImage(icon);
        d.setLocation(sizeX - (mensaje.length()), sizeY);
        Toolkit.getDefaultToolkit().beep();
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ventana.obtenerInstancia().alertaTicketsAdmin();
            }//----------------------------------------------------------------------------- FIN mouseClicked()

            @Override
            public void mousePressed(MouseEvent e) {
                Ventana.obtenerInstancia().alertaTicketsAdmin();
            }//----------------------------------------------------------------------------- FIN mousePressed()
        });
        d.setVisible(true);
        Ventana.obtenerInstancia().setBarraEstadoMensajeAnterior();
    }
    
    //Declaracion de variables
    private static Alertas instancia = null;
    private final int sizeY = Toolkit.getDefaultToolkit().getScreenSize().height - 200;
    private final int sizeX = Toolkit.getDefaultToolkit().getScreenSize().width - 300;
}
