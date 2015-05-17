package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel {

    private Image imagen;

    public PanelConFondo() {
        imagen = null;
    }//----------------------------------------------------------------------------- FIN Contructor()

    public PanelConFondo(String nombreImagen) {
        imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
    }//----------------------------------------------------------------------------- FIN Constructor_sobrecargado()

    public PanelConFondo(Image imagenInicial) {
        imagen = imagenInicial;
    }//----------------------------------------------------------------------------- FIN Constructor_sobrecargado()

    public void setImagen(String nombreImagen) {
        imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        repaint();
    }//----------------------------------------------------------------------------- FIN SetImgen()

    public void setImagen(Image nuevaImagen) {
        imagen = nuevaImagen;
        repaint();
    }//----------------------------------------------------------------------------- FIN SetImgen()

    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        } else {
            setOpaque(true);
        }
        super.paint(g);
    }//----------------------------------------------------------------------------- FIN paint()

}//____________________________________________________________________END_CLASS
