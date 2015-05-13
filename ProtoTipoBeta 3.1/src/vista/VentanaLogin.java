package vista;

import controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.TitledBorder;
import modelo.ManejadorDeArchivos;


public class VentanaLogin extends JFrame {//miniVentana donde se ingresa a la aplicacion

    private VentanaLogin() {
        super("Acceso SIGETI");
        ajustarConfiguracionInicial();
        ajustarComponentes(getContentPane());
        ajustarEventos();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static VentanaLogin obtenerInstancia() {//asi garantizamos que solo aya una ventana
        if (instancia == null) {
            instancia = new VentanaLogin();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void ajustarConfiguracionInicial() {
        setSize(425, 279);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }
        });
        cambioIcono();
    }//----------------------------------------------------------------------------- FIN ajustarConfiguracionInicial()

    public void cambioIcono() {//establece el icono de la aplicacion
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/user-login-iconx128.png"));
        setIconImage(icon);
    }//----------------------------------------------------------------------------- FIN cambioIcono()

    public void mostrar() {//para mostar el JFRAME
        setLocationRelativeTo(null);
        this.setVisible(true);
        if ("".equals(ManejadorDeArchivos.obtenerInstancia().leerFichero("remember"))) {
            ckRecordar.setSelected(false);
        } else {
            ckRecordar.setSelected(true);
            txtCorreo.setText(ManejadorDeArchivos.obtenerInstancia().leerFichero("remember"));
        }
        repaint();
    }//----------------------------------------------------------------------------- FIN mostrar()

    public void ocultar() {// oculta la ventana de ser necesario
        this.setVisible(false);
    }//----------------------------------------------------------------------------- FIN ocultar()

    private void ajustarComponentes(Container c) {
        iniciarComponentes();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        JPanel panelCuadro = new JPanel();
        panelCuadro.setOpaque(false);
        panelCuadro.setLayout(new GridLayout(4, 3, 5, 5));

        panelCuadro.add(Box.createRigidArea(new Dimension(20, 2)));
        panelCuadro.add(Box.createRigidArea(new Dimension(0, 0)));
        panelCuadro.add(Box.createRigidArea(new Dimension(0, 0)));

        panelCuadro.add(lbCorreo);
        panelCuadro.add(txtCorreo);
        panelCuadro.add(lbDominioCorreo);

        panelCuadro.add(lbContrasenna);
        panelCuadro.add(txtContrasenna);
        panelCuadro.add(Box.createRigidArea(new Dimension(0, 0)));
        //panelCuadro.setBorder(new TitledBorder(""));
        //--o--
        JPanel panelOpciones = new JPanel();
        panelOpciones.setOpaque(false);
        panelOpciones.setLayout(new GridLayout(1, 4, 0, 0));
        panelOpciones.add(Box.createRigidArea(new Dimension(0, 0)));
        panelOpciones.add(ckRecordar);
        panelOpciones.add(lbOlvidoClave);
        panelOpciones.add(Box.createRigidArea(new Dimension(0, 0)));
        //--o--
        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new FlowLayout());

        panelBotones.add(btnIngresar);
        panelBotones.add(btnRegistrarse);
        panelBotones.add(btnCancelar);
        //--o--
        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(false);
        panelTitulo.add(lbTitulo, BorderLayout.CENTER);
        JPanel panelIndicaciones = new JPanel();
        panelIndicaciones.setOpaque(false);
        panelIndicaciones.add(lbIndicaciones, BorderLayout.CENTER);
        //--o--
        JPanel p = new JPanel();
        p.setOpaque(false);
        p.add(panelCuadro);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(panelIndicaciones);
        panelPrincipal.add(p);
        panelPrincipal.add(panelOpciones);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(panelBotones);
        panelPrincipal.setBorder(new TitledBorder(""));
        c.add(panelPrincipal);
        ckRecordar.setSelected(true);
        pack();
        //--o--
    }//----------------------------------------------------------------------------- FIN ajustarComponentes()

    private void remember() {
        if (ckRecordar.isSelected()) {
            ManejadorDeArchivos.obtenerInstancia().escribirArchivo("remember", txtCorreo.getText());
        } else {
            ManejadorDeArchivos.obtenerInstancia().escribirArchivo("remember", "");
        }
    }

    private void ajustarEventos() {
        ckRecordar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remember();
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarAplicacion();
            }
        });
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remember();
                ArrayList<Integer> valores;
                valores = Controlador.obtenerInstancia().verificaLoggin(txtCorreo.getText(), String.valueOf(txtContrasenna.getPassword()));
                int tipo = valores.get(0);
                int estado = valores.get(1);
                switch (estado) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "El usuario ha sido bloqueado y no tiene acceso a SIGETI", "ERROR", JOptionPane.ERROR_MESSAGE);
                        limpiar();
                        break;
                    case 1:
                        Ventana.obtenerInstancia().setTipoUsuario(String.valueOf(tipo));
                        correo = Controlador.obtenerInstancia().recortaCorreo(txtCorreo.getText()) + "@castillo.cr";
                        System.err.println(Controlador.obtenerInstancia().consultarConsecutivoBitacora());
                        Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                                VentanaLogin.correo, "No aplica", "Ingresó al sistema");
                        limpiar();
                        ocultar();
                        Ventana.obtenerInstancia().mostrar();
                        break;
                    case -1:
                        JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado y no tiene acceso a SIGETI", "ERROR", JOptionPane.ERROR_MESSAGE);
                        limpiar();
                        break;
                    case -2:
                        JOptionPane.showMessageDialog(null, "El usuario no está registrado, datos erróneos", "ERROR", JOptionPane.ERROR_MESSAGE);
                        limpiar();
                        break;
                    default:
                        break;
                }               
            }
        });
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana.obtenerInstancia().setTipoUsuario("");
                limpiar();
                VentanaRegistro.obtenerInstancia().mostrar();
                ocultar();
            }
        });
        lbOlvidoClave.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiar();
                VentanaRecuperaContrasenna.obtenerInstancia().mostrar();
                ocultar();
//                Ventana.obtenerInstancia().mostrar();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("hizo Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("hizo Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("hizo Entered");
                lbOlvidoClave.setForeground(new Color(231, 174, 24));
                lbOlvidoClave.setFont(new Font("tahoma", Font.BOLD, 11));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.out.println("hizo Exited");
                lbOlvidoClave.setForeground(Color.WHITE);
                lbOlvidoClave.setFont(new Font("tahoma", Font.BOLD, 11));
            }
        });

    }//----------------------------------------------------------------------------- FIN ajustarEventos()

    private void iniciarComponentes() {
        lbTitulo = new JLabel("Acceso de Usuario");
        lbIndicaciones = new JLabel("Ingrese los datos correspondientes");
        lbCorreo = new JLabel("Ingrese su Correo:");
        lbDominioCorreo = new JLabel("@castillo.cr");
        lbContrasenna = new JLabel("Contraseña:");
        lbOlvidoClave = new JLabel("¿Olvidó su contraseña?");
        //--o--
        lbTitulo.setForeground(Color.WHITE);
        lbIndicaciones.setForeground(Color.WHITE);
        lbCorreo.setForeground(Color.WHITE);
        lbDominioCorreo.setForeground(Color.WHITE);
        lbContrasenna.setForeground(Color.WHITE);
        lbOlvidoClave.setForeground(Color.WHITE);
        //--o--
        lbTitulo.setFont(new Font("tahoma", Font.BOLD, 18));
        lbIndicaciones.setFont(new Font("tahoma", Font.BOLD, 11));
        lbCorreo.setFont(new Font("tahoma", Font.BOLD, 11));
        lbDominioCorreo.setFont(new Font("tahoma", Font.BOLD, 11));
        lbContrasenna.setFont(new Font("tahoma", Font.BOLD, 11));
        lbOlvidoClave.setFont(new Font("tahoma", Font.BOLD, 11));
        //--o--
        txtCorreo = new JTextField(10);
        txtContrasenna = new JPasswordField(10);
        //--o--
        btnIngresar = new JButton("Accesar");
        this.getRootPane().setDefaultButton(btnIngresar);
        btnRegistrarse = new JButton("Registrarme");
        btnCancelar = new JButton("Cancelar");
        //--o--
        ckRecordar = new JCheckBox("Recordarme");
        ckRecordar.setSelected(false);
        ckRecordar.setOpaque(false);
        ckRecordar.setFont(new Font("tahoma", Font.BOLD, 11));
        ckRecordar.setForeground(Color.WHITE);
        //--o--
        panelPrincipal = new PanelConFondo("/img/fondoLogin.jpg");
    }//----------------------------------------------------------------------------- FIN IniciarComponentes()

    public void cerrarAplicacion() {//mensaje de confirmacion para dar fin a la ejecucion de la aplicacion        
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea cerrar la aplicación?", "Cerrar", JOptionPane.YES_NO_OPTION)) {
            System.exit(0);
        }
    }//----------------------------------------------------------------------------- FIN cerrarAplicacion()

    private void limpiar() {
        if (!ckRecordar.isSelected()) {
            txtCorreo.setText(null);
        }
        txtContrasenna.setText(null);
    }//----------------------------------------------------------------------------- FIN limpiar()   

    //Declaracion de variables
    private JLabel lbTitulo;
    private JLabel lbIndicaciones;
    private JLabel lbCorreo;
    private JLabel lbDominioCorreo;
    private JLabel lbContrasenna;
    private JLabel lbOlvidoClave;
    //--o--
    private JTextField txtCorreo;
    private JPasswordField txtContrasenna;
    //--o--
    private JButton btnIngresar;
    private JButton btnRegistrarse;
    private JButton btnCancelar;
    //--o--
    private JCheckBox ckRecordar;
    //--o--
    private PanelConFondo panelPrincipal;
    //--o--
    private static VentanaLogin instancia = null;
    public static String correo = null;

}//____________________________________________________________________END_CLASS
