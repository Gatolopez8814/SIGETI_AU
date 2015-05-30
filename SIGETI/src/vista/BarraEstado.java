package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarraEstado extends JPanel {

    private static final Font TIPO_LETRA = new Font("Courier", Font.PLAIN, 10);
    private JLabel lbMensaje;
    private String mensajeAnterior;
    private Color colorAnterior;

    public BarraEstado(String txt) {
        super(true);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setBorder(BorderFactory.createRaisedBevelBorder());
        lbMensaje = new JLabel(txt);
        lbMensaje.setFont(TIPO_LETRA);
        add(lbMensaje);
        mensajeAnterior = "";
        colorAnterior = Color.BLACK;
    }//----------------------------------------------------------------------------- FIN Constructor()

    public void cambiarEstado(String txt, Color color) {//ingresaun nuevo mensaje
        mensajeAnterior = lbMensaje.getText();
        colorAnterior = color;
        lbMensaje.setForeground(color);
        lbMensaje.setText(txt);
    }//----------------------------------------------------------------------------- FIN cambiarEstado()

    public void cambiarEstado(String txt) {//ingresaun nuevo mensaje sin indicar el color
        cambiarEstado(txt, Color.BLACK);
    }//----------------------------------------------------------------------------- FIN cambiarEstado()

    public void mostrarError(String txt) {//muestra mensaje en rojo
        cambiarEstado(txt, Color.RED);
    }//----------------------------------------------------------------------------- FIN mostrarError()

    public void mostrarWarning(String txt) {//indica mensaje de alerta en color amarillo
        cambiarEstado(txt, new Color(255, 215, 0).brighter());
    }//----------------------------------------------------------------------------- FIN mostrarWarning()

    public String getEstado() {//regresa string con el texto que se muestra
        return lbMensaje.getText();
    }//----------------------------------------------------------------------------- FIN getEstado()

    public void mensajeAnterior() {//vuelve a poner el mensaje anterior, incluye el color
        cambiarEstado(mensajeAnterior, colorAnterior);
    }//----------------------------------------------------------------------------- FIN mensajeAnterior()

}//____________________________________________________________________END_CLASS
