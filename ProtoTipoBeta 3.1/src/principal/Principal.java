package principal;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Modelo;
import vista.VentanaLogin;

public class Principal {// clase principal donde se encuentra el main

    public static void main(String[] args) {//unico main del proyecto
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.err.println(e.getMessage());
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Principal principal = new Principal();
                principal.mostrarInterfaz();
            }
        });
    }//-----------------------------------------------------------------END_MAIN

    private void mostrarInterfaz() {//donde se ejecuta el MVC          
        VentanaLogin ventana = VentanaLogin.obtenerInstancia();         
        ventana.mostrar();
    }//------------------------------------------------------END_mostrarInterfaz
    
//    private void iniciarSistema(){
//    class SplashScreen extends JWindow {//PERMITE CREAR LA IMAGEN QUE SIMULA CARGA CUANDO SE EJECUTA EL PROGRAMA
//
//            private Image image_;
//            private int x_, y_, width_, height_;
//
//            public SplashScreen(String imageFileName) {
//                super(new Frame());
//
//                try {
//                    Toolkit toolkit = Toolkit.getDefaultToolkit();
//
//                    URL imageUrl = getClass().getResource(imageFileName);
//                    image_ = toolkit.getImage(imageUrl);
//
//                    MediaTracker mediaTracker = new MediaTracker(this);
//                    mediaTracker.addImage(image_, 0);
//                    mediaTracker.waitForID(0);
//
//                    width_ = image_.getWidth(this);
//                    height_ = image_.getHeight(this);
//
//                    Dimension screenSize = toolkit.getScreenSize();
//
//                    x_ = (screenSize.width - width_) / 2;
//                    y_ = (screenSize.height - height_) / 2;
//                } catch (Exception exception) {
//                    exception.printStackTrace();
//                    image_ = null;
//                }
//            }
//
//            public void open(int nMilliseconds) {
//                if (image_ == null) {
//                    return;
//                }
//
//                Timer timer = new Timer(Integer.MAX_VALUE, new ActionListener() {
//                    public void actionPerformed(ActionEvent event) {
//                        ((Timer) event.getSource()).stop();
//                        close();
//                    }
//                ;
//                });
//    
//    timer.setInitialDelay(nMilliseconds);
//                timer.start();
//                setBounds(x_, y_, width_, height_);
//                setVisible(true);
//            }
//
//            public void close() {
//                setVisible(false);
//                dispose();
//                mostrarInterfaz();
//            }
//
//            public void paint(Graphics graphics) {
//                if (image_ == null) {
//                    return;
//                }
//                graphics.drawImage(image_, 0, 0, width_ - 20, height_ - 25, this);
//            }
//        }
//        SplashScreen sp = new SplashScreen("/img/loading1.gif");
//        sp.open(5000);
//
//}
    

}//____________________________________________________________________END_MAIN
