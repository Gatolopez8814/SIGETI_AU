package vista;

import controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import vista.Area.ArbolArea;
import vista.Area.PanelBandejaArea;
import vista.Area.PanelCambioContraseñaArea;
import vista.Area.PanelConsultaHistorialArea;
import vista.Area.PanelConsultaUnoArea;
import vista.Area.PanelCrearTicketArea;
import vista.Area.PanelReportesArea;
import vista.Area.PanelTicketAsignadosArea;
import vista.Area.PanelTicketsDelArea;
import vista.Area.PanelTicketsEnProcesoArea;
import vista.Area.PanelUltimoTicketArea;
import vista.administrativo.ArbolAdministrativo;
import vista.administrativo.PanelAlertaTicketAdmin;
import vista.administrativo.PanelBandejaAdministrador;
import vista.administrativo.PanelBitacoraAdmin;
import vista.administrativo.PanelBloquearUsuarioAdmin;
import vista.administrativo.PanelCambioContraseñaAdmin;
import vista.administrativo.PanelConsultaHistorialAdmin;
import vista.administrativo.PanelConsultaUnoAdmin;
import vista.administrativo.PanelCrearTicketAdministrativo;
import vista.administrativo.PanelDesbloquearUsuarioAdmin;
import vista.administrativo.PanelConfigurarTicket;
import vista.administrativo.PanelEliminarUsuarioAdmin;
import vista.administrativo.PanelGestionarTicketAdmin;
import vista.administrativo.PanelModificarUsuario;
import vista.administrativo.PanelRegistrarUsuariosAdmin;
import vista.administrativo.PanelReportesAdmin;
import vista.administrativo.PanelTicketAsignadosAdmin;
import vista.administrativo.PanelTicketEnProcesoAdmin;
import vista.administrativo.PanelTicketsCerradosAdmin;
import vista.administrativo.PanelTodosTicketsAdmin;
import vista.administrativo.PanelUltimoTicketAdmin;
import vista.standard.ArbolStandard;
import vista.standard.PanelCambioContraseña;
import vista.standard.PanelConsultaHistorial;
import vista.standard.PanelConsultaUno;
import vista.standard.PanelCrearTicket;
import vista.standard.PanelUltimoTicketStandard;

public class Ventana extends JFrame implements Runnable, MouseListener {//la venta a mostrarse en la interface

    private Ventana() {
        super("SISTEMA DE GESTIÓN DE TICKETS - SIGETI ");
        addMouseListener(this);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tecla();
            }
        });
        ajustarConfiguracionInicial();
        ajustarMenu();
        ajustarComponentes(getContentPane());
        ajustarEventos();
        alerta = Alertas.obtenerInstancia();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static Ventana obtenerInstancia() {//asi garantizamos que solo aya una ventana
        if (instancia == null) {
            instancia = new Ventana();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    public void tecla() {
        time_start = System.currentTimeMillis();
        System.out.println("keyPressed");
    }

    public void setTipoUsuario(String tipoUsuario) {
        usuarioActivo = tipoUsuario;
        setLocationRelativeTo(null);
        switch (usuarioActivo) {
            case "3":
                sesion = true;
                time_start = System.currentTimeMillis();
                this.setTitle("SISTEMA DE GESTIÓN DE TICKETS - SIGETI - USUARIO ESTANDARD");
                setSize(910, 605);
                setPreferredSize(new Dimension(910, 605));
                setLocationRelativeTo(null);
                menuStandard();
                ArbolStandard.previeneError();
                ventanaPrincipalStandard();
                break;
            case "2":
                sesion = true;
                time_start = System.currentTimeMillis();
                this.setTitle("SISTEMA DE GESTIÓN DE TICKETS - SIGETI - USUARIO DE AREA");
                setSize(new Dimension(sizeX, sizeY));
                setPreferredSize(new Dimension(sizeX, sizeY));
                setLocationRelativeTo(null);
                menuArea();
                ArbolArea.previeneError();
                ventanaPrincipalArea();
                break;
            case "1":
                sesion = true;
                time_start = System.currentTimeMillis();
                this.setTitle("SISTEMA DE GESTIÓN DE TICKETS - SIGETI - USUARIO ADMINISTRADOR");
                setSize(new Dimension(sizeX, sizeY));
                setPreferredSize(new Dimension(sizeX, sizeY));
                setLocationRelativeTo(null);
                menuAdministrativo();
                ArbolAdministrativo.previeneError();
                ventanaPrincipalAdmin();
                break;
            default:
                VentanaLogin.obtenerInstancia().mostrar();
                this.ocultar();
                break;
        }
    }//----------------------------------------------------------------------------- FIN setTipoUsuario()

    public void mostrar() {//para mostar el JFRAME
        this.setVisible(true);
        ArbolAdministrativo.previeneError();
        ArbolArea.previeneError();
        ArbolStandard.previeneError();
        repaint();              
    }//----------------------------------------------------------------------------- FIN mostrar()

    public void ocultar() {// oculta la ventana de ser necesario
        this.setVisible(false);
    }//----------------------------------------------------------------------------- FIN ocultar()

    public void setBarraEstado(String txt) {//cambia el texto de la barra de estado
        barraEstado.cambiarEstado(txt);
    }//----------------------------------------------------------------------------- FIN setBarraEstado()

    public void setWarning(String txt) {//muestra un Warning en la barra de estado
        barraEstado.mostrarWarning(txt);
    }//----------------------------------------------------------------------------- FIN setWarning()

    public void setError(String txt) {//Muestra un error en la barra de estado
        barraEstado.mostrarError(txt);
    }//----------------------------------------------------------------------------- FIN setError()

    public void setBarraEstadoMensajeAnterior() {//cambia el texto de la barra de estado por el mensaje anterior
        barraEstado.mensajeAnterior();
    }//----------------------------------------------------------------------------- FIN setBarraEstadoMensajeAnterior()

    public String getBarraEstado() {// retorna el texto de la barra de estado
        return barraEstado.getEstado();
    }//----------------------------------------------------------------------------- FIN getBarraEstado()

    private void ajustarConfiguracionInicial() {//configuracion basica de la ventana
        sesion = false;
        time_start = System.currentTimeMillis();
        setSize(910, 605);
        setPreferredSize(new Dimension(910, 605));
        setMinimumSize(new Dimension(910, 605));
        setMaximumSize(new Dimension(sizeX, sizeY));
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }
        });
        cambioIcono();
        new Thread(this).start();
    }//----------------------------------------------------------------------------- FIN ajustarConfiguracionInicial()

    private void ajustarMenu() {//ajusta el menu de la ventana
        menu = new JMenuBar();
        ajustarComponentesBasicosMenu();
        this.setJMenuBar(menu);
        desAbilitarMenu();
    }//----------------------------------------------------------------------------- FIN ajustarMenu()

    public void ajustarComponentesBasicosMenu() {
        menuArchivo = new JMenu("Archivo");
        menuOpciones = new JMenu("Opciones");
        menuBuscar = new JMenu("Busqueda");
        menuCuenta = new JMenu("Cuenta");
        menuAyuda = new JMenu("Ayuda");
        //--o--
        itemSalir = new JMenuItem("Salir");
        itemCrearTicket = new JMenuItem("Crear ticket");
        itemBuscarUnTicket = new JMenuItem("Buscar un ticket");
        itemBuscarUltimoTicket = new JMenuItem("Buscar último ticket");
        itemHistorialTicket = new JMenuItem("Historial tickets");
        itemDesLoggeo = new JMenuItem("Cerrar sesión");
        itemAyuda = new JMenuItem("Ayuda");
        itemCambioClave = new JMenuItem("Cambiar clave");
        Icon icon;
        icon = new ImageIcon(getClass().getResource("/img/Deleteiconx16.png"));
        itemSalir.setIcon(icon);
        Icon icon2 = new ImageIcon(getClass().getResource("/img/ticket16.png"));
        itemCrearTicket.setIcon(icon2);
        Icon icon3 = new ImageIcon(getClass().getResource("/img/Search216.png"));
        itemBuscarUnTicket.setIcon(icon3);
        Icon icon4 = new ImageIcon(getClass().getResource("/img/Search16.png"));
        itemBuscarUltimoTicket.setIcon(icon4);
        Icon icon5 = new ImageIcon(getClass().getResource("/img/Search316.png"));
        itemHistorialTicket.setIcon(icon5);
        Icon icon6 = new ImageIcon(getClass().getResource("/img/Usericonx16.png"));
        itemDesLoggeo.setIcon(icon6);
        Icon icon7 = new ImageIcon(getClass().getResource("/img/supporticonx16.png"));
        itemAyuda.setIcon(icon7);
        Icon icon8 = new ImageIcon(getClass().getResource("/img/claveiconx16.png"));
        itemCambioClave.setIcon(icon8);
        Icon icon9 = new ImageIcon(getClass().getResource("/img/CarpetaSearch16.png"));
        menuBuscar.setIcon(icon9);
        //--o--
        itemSalir.setMnemonic(KeyEvent.VK_S);
        itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        itemCrearTicket.setMnemonic(KeyEvent.VK_C);
        itemCrearTicket.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
        itemBuscarUnTicket.setMnemonic(KeyEvent.VK_B);
        itemBuscarUnTicket.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
        itemBuscarUltimoTicket.setMnemonic(KeyEvent.VK_U);
        itemBuscarUltimoTicket.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK));
        itemHistorialTicket.setMnemonic(KeyEvent.VK_H);
        itemHistorialTicket.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));
        itemDesLoggeo.setMnemonic(KeyEvent.VK_D);
        itemDesLoggeo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
        itemAyuda.setMnemonic(KeyEvent.VK_A);
        itemAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        itemCambioClave.setMnemonic(KeyEvent.VK_P);
        itemCambioClave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));

    }//----------------------------------------------------------------------------- FIN ajustarComponentesBasicosMenu()

    public void desAbilitarMenu() {//desabilita las funciones del menu en caso de no tener acceso
        menu.removeAll();
        menuArchivo.removeAll();
        menuOpciones.removeAll();
        menuCuenta.removeAll();
        menuAyuda.removeAll();
        repaint();
    }//----------------------------------------------------------------------------- FIN desAbilitarMenu()

    public void menuStandard() {
        desAbilitarMenu();
        //solo tiene componentes basicos
        //--o--
        menuArchivo.add(itemSalir);
        menuBuscar.add(itemBuscarUltimoTicket);
        menuBuscar.add(itemBuscarUnTicket);
        menuBuscar.add(itemHistorialTicket);
        menuOpciones.add(itemCrearTicket);
        menuOpciones.add(menuBuscar);
        menuAyuda.add(itemAyuda);
        menuCuenta.add(itemCambioClave);
        menuCuenta.add(itemDesLoggeo);
        //--o--
        menu.add(menuArchivo);
        menu.add(menuOpciones);
        menu.add(menuCuenta);
        menu.add(menuAyuda);
        //--o--
        repaint();
    }//----------------------------------------------------------------------------- FIN menuStandard()

    public void menuArea() {
        desAbilitarMenu();
        //--o--              
        JMenu menuArea = new JMenu("Área");
        JMenuItem itemBandejaEntrada = new JMenuItem("Bandeja de Entrada");
        JMenuItem itemTicketArea = new JMenuItem("Tickets del Área");
        JMenuItem itemTicketProgreso = new JMenuItem("Tickets en Proceso");
        JMenuItem itemTicketsAsignados = new JMenuItem("Tickets Asignados");
        JMenuItem itemGenerarReporte = new JMenuItem("Generar Reporte");
        //--o--
        //estas imagenes son para cargar la barra de menu, no el arbol
        Icon icon2 = new ImageIcon(getClass().getResource("/img/inbox-iconx16.png"));
        itemBandejaEntrada.setIcon(icon2);
        Icon icon3 = new ImageIcon(getClass().getResource("/img/wood-folder-iconx16.png"));
        itemTicketArea.setIcon(icon3);
        Icon icon4 = new ImageIcon(getClass().getResource("/img/helical-gear-iconx16.png"));
        itemTicketProgreso.setIcon(icon4);
        Icon icon5 = new ImageIcon(getClass().getResource("/img/Actions-dashboard-show-iconx16.png"));
        itemTicketsAsignados.setIcon(icon5);
        Icon icon6 = new ImageIcon(getClass().getResource("/img/Balance-iconx16.png"));
        itemGenerarReporte.setIcon(icon6);
        //--o--       
        itemBandejaEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bandejaEntradaArea();
            }
        });
        itemTicketArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ticketsDeArea();
            }
        });
        itemTicketProgreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ticketsEnProcesoArea();
            }
        });
        itemTicketsAsignados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ticketsAsignadosArea();
            }
        });
        itemGenerarReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                reportesArea();
            }
        });
        //--o--
        menuArea.add(itemBandejaEntrada);
        menuArea.add(itemTicketArea);
        menuArea.add(itemTicketProgreso);
        menuArea.add(itemTicketsAsignados);
        menuArchivo.add(itemSalir);
        menuBuscar.add(itemBuscarUltimoTicket);
        menuBuscar.add(itemBuscarUnTicket);
        menuBuscar.add(itemHistorialTicket);
        menuOpciones.add(itemCrearTicket);
        menuOpciones.add(itemGenerarReporte);
        menuOpciones.add(menuBuscar);
        menuAyuda.add(itemAyuda);
        menuCuenta.add(itemCambioClave);
        menuCuenta.add(itemDesLoggeo);
        //--o--
        menu.add(menuArchivo);
        menu.add(menuOpciones);
        menu.add(menuArea);
        menu.add(menuCuenta);
        menu.add(menuAyuda);
        //--o--
        repaint();
    }//----------------------------------------------------------------------------- FIN menuArea()

    public void menuAdministrativo() {
        desAbilitarMenu();
        //--o--              
        JMenu menuReportes = new JMenu("Reportes");
        JMenu menuUsuarios = new JMenu("Gestión Usuarios");
        JMenu menuSistema = new JMenu("Sistema");

        JMenuItem itemBandejaEntrada = new JMenuItem("Bandeja de Entrada");
        JMenuItem itemTicketProgreso = new JMenuItem("Tickets en Proceso");
        JMenuItem itemTicketsAsignados = new JMenuItem("Tickets Asignados");
        JMenuItem itemAlertas = new JMenuItem("Alerta de Tickets");
        JMenuItem itemTicketsCerrados = new JMenuItem("Tickets Cerrados");
        JMenuItem itemRegistrarUsuario = new JMenuItem("Registrar Usuario");
        JMenuItem itemBloquearUsuario = new JMenuItem("Bloquear Usuario");
        JMenuItem itemDesbloquearUsuario = new JMenuItem("DesbloquearUsuario");
        JMenuItem itemEliminarUsuario = new JMenuItem("Eliminar Usuario");
        JMenuItem itemReporte = new JMenuItem("Generar Reporte");
        JMenuItem itemBitacora = new JMenuItem("Bitacora");
        //--o--
        Icon icon = new ImageIcon(getClass().getResource("/img/users-iconx16.png"));
        menuUsuarios.setIcon(icon);
        Icon icon2 = new ImageIcon(getClass().getResource("/img/inbox-iconx16.png"));
        itemBandejaEntrada.setIcon(icon2);
        Icon icon3 = new ImageIcon(getClass().getResource("/img/Alerts-iconx16.png"));
        itemAlertas.setIcon(icon3);
        Icon icon4 = new ImageIcon(getClass().getResource("/img/helical-gear-iconx16.png"));
        itemTicketProgreso.setIcon(icon4);
        Icon icon5 = new ImageIcon(getClass().getResource("/img/Actions-dashboard-show-iconx16.png"));
        itemTicketsAsignados.setIcon(icon5);
        Icon icon6 = new ImageIcon(getClass().getResource("/img/wood-box-iconx16.png"));
        itemTicketsCerrados.setIcon(icon6);
        Icon icon7 = new ImageIcon(getClass().getResource("/img/Actions-list-add-user-iconx16.png"));
        itemRegistrarUsuario.setIcon(icon7);
        Icon icon8 = new ImageIcon(getClass().getResource("/img/Apps-preferences-desktop-user-password-iconx16.png"));
        itemBloquearUsuario.setIcon(icon8);
        Icon icon9 = new ImageIcon(getClass().getResource("/img/Apps-preferences-desktop-user-iconx16.png"));
        itemDesbloquearUsuario.setIcon(icon9);
        Icon icon10 = new ImageIcon(getClass().getResource("/img/Actions-list-remove-user-iconx16.png"));
        itemEliminarUsuario.setIcon(icon10);
        Icon icon11 = new ImageIcon(getClass().getResource("/img/Reports-iconx16.png"));
        itemReporte.setIcon(icon11);
        Icon icon12 = new ImageIcon(getClass().getResource("/img/contacts-icon2x16.png"));
        itemBitacora.setIcon(icon12);

        //--o--       
        itemBandejaEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bandejaEntradaAdmin();
            }
        });
        itemTicketProgreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ticketsProcesoAdmin();
            }
        });
        itemTicketsAsignados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ticketsAsignadosAdmin();
            }
        });
        itemAlertas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alertaTicketsAdmin();
            }
        });
        itemTicketsCerrados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ticketsCerradosAdmin();
            }
        });
        itemRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                registrarUsuarioAdmin();
            }
        });
        itemBloquearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bloquearUsuarioAdmin();
            }
        });
        itemDesbloquearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                desbloquearUsuarioAdmin();
            }
        });
        itemEliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                eliminarUsuarioAdmin();
            }
        });
        itemReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                reportesAdmin();
            }
        });
        itemBitacora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bitacoraAdmin();
            }
        });
        //--o--
        menuUsuarios.add(itemRegistrarUsuario);
        menuUsuarios.add(itemBloquearUsuario);
        menuUsuarios.add(itemDesbloquearUsuario);
        menuUsuarios.add(itemEliminarUsuario);
        menuSistema.add(itemBandejaEntrada);
        menuSistema.add(itemTicketProgreso);
        menuSistema.add(itemTicketsAsignados);
        menuSistema.add(itemAlertas);
        menuSistema.add(itemTicketsCerrados);
        menuSistema.add(menuUsuarios);
        menuReportes.add(itemReporte);
        menuReportes.add(itemBitacora);
        menuArchivo.add(itemSalir);
        menuBuscar.add(itemBuscarUltimoTicket);
        menuBuscar.add(itemBuscarUnTicket);
        menuBuscar.add(itemHistorialTicket);
        menuOpciones.add(itemCrearTicket);
        menuOpciones.add(menuBuscar);
        menuAyuda.add(itemAyuda);
        menuCuenta.add(itemCambioClave);
        menuCuenta.add(itemDesLoggeo);
        //--o--
        menu.add(menuArchivo);
        menu.add(menuOpciones);
        menu.add(menuSistema);
        menu.add(menuReportes);
        menu.add(menuCuenta);
        menu.add(menuAyuda);
        //--o--
        repaint();
    }//----------------------------------------------------------------------------- FIN menuAdministrativo()

    private void ajustarComponentes(Container c) {//coloca lo que debe estar en la ventana        
        barraEstado = new BarraEstado("Bienvenido al sistema de tickets");
        if (scrollPanelPrincipal == null) {
            scrollPanelPrincipal = new JScrollPane();
            scrollPanelPrincipal.setOpaque(true);
        }
        if (panelPrincipal == null) {
            panelPrincipal = new JPanel();
        }
        c.add(panelPrincipal, BorderLayout.CENTER);
        c.add(barraEstado, BorderLayout.PAGE_END);
        repaint();
    }//----------------------------------------------------------------------------- FIN ajustarComponentes()

    private void ajustarEventos() {

        itemCrearTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch (usuarioActivo) {
                    case "3":
                        crearTicketStandard();
                        break;
                    case "2":
                        crearTicketArea();
                        break;
                    case "1":
                        crearTicketAdmin();
                        break;
                }
            }
        });
        itemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cerrarAplicacion();
            }
        });
        itemDesLoggeo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cerrarSesion();
            }
        });
        itemAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setBarraEstado("Necesita Ayuda?");
                ayuda();
                setBarraEstadoMensajeAnterior();
            }
        });
        itemBuscarUnTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch (usuarioActivo) {
                    case "3":
                        buscarUnTicketStandard();
                        break;
                    case "2":
                        buscarUnTicketArea();
                        break;
                    case "1":
                        buscarUnTicketAdmin();
                        break;
                }
            }
        });
        itemBuscarUltimoTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch (usuarioActivo) {
                    case "3":
                        buscarUltimoTicketStandard();
                        break;
                    case "2":
                        buscarUltimoTicketArea();
                        break;
                    case "1":
                        buscarUltimoTicketAdmin();
                        break;
                }
            }
        });
        itemHistorialTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch (usuarioActivo) {
                    case "3":
                        historialTicketsStandard();
                        break;
                    case "2":
                        historialTicketsArea();
                        break;
                    case "1":
                        historialTicketsAdmin();
                        break;
                }
            }
        });
        itemCambioClave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch (usuarioActivo) {
                    case "3":
                        cambiarClaveStandar();
                        break;
                    case "2":
                        cambiarClaveArea();
                        break;
                    case "1":
                        cambiarClaveAdmin();
                        break;
                }
            }
        });
    }//----------------------------------------------------------------------------- FIN ajustarEventos()

    public void cerrarAplicacion() {//mensaje de confirmacion para dar fin a la ejecucion de la aplicacion
        setBarraEstado("¿Realmente desea cerrar la aplicación? ");
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea cerrar la aplicación?", "Cerrar", JOptionPane.YES_NO_OPTION)) {
		
            Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                    VentanaLogin.correo, "No aplica", "Finalizó sesión");
            
            System.exit(0);
        }
        setBarraEstadoMensajeAnterior();
    }//----------------------------------------------------------------------------- FIN cerrarAplicacion()

    public void cambioIcono() {//establece el icono de la aplicacion
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/SIGETI-icon128.png"));
        setIconImage(icon);
    }//----------------------------------------------------------------------------- FIN cambioIcono()

    public void cerrarSesion() {
        setBarraEstado("¿Desea cerrar la sesion?");
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                + "desea cerrar la sesión?", null, JOptionPane.YES_NO_OPTION)) {

            
            Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                    VentanaLogin.correo, "No aplica", "Finalizó sesión");
            
            sesion = false;
            VentanaLogin.obtenerInstancia().mostrar();
            ocultar();
            this.desAbilitarMenu();
            panelPrincipal.removeAll();
            revalidate();//xq ???
        }
        setBarraEstadoMensajeAnterior();
    }//----------------------------------------------------------------------------- FIN cerrarSesion()

    public void cambiarClaveStandar() {
        panelPrincipal.removeAll();
        setBarraEstado("Cambiar clave");
        scrollPanelPrincipal = new JScrollPane(PanelCambioContraseña.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolStandard.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN cambiarClaveStandar()

    public void buscarUnTicketStandard() {
        panelPrincipal.removeAll();
        setBarraEstado("Consulta de ticket");
        scrollPanelPrincipal = new JScrollPane(PanelConsultaUno.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolStandard.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN buscarUnTicketStandard()

    public void ventanaPrincipalStandard() {
        panelPrincipal.removeAll();
        ArbolStandard.previeneError();
        setBarraEstado("Pantalla principal");
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolStandard.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(new PanelConFondo("/img/2014-10-05_1533.png"));
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN ventanaPrincipalStandard()

    public void historialTicketsStandard() {
        panelPrincipal.removeAll();
        setBarraEstado("Historial de tickets");
        scrollPanelPrincipal = new JScrollPane(PanelConsultaHistorial.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolStandard.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN historialTicketsStandard()

    public void buscarUltimoTicketStandard() {
        panelPrincipal.removeAll();
        setBarraEstado("Último ticket creado");
        scrollPanelPrincipal = new JScrollPane(PanelUltimoTicketStandard.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolStandard.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN buscarUltimoTicketStandard()

    public void crearTicketStandard() {
        panelPrincipal.removeAll();
        setBarraEstado("Creación de ticket");
        scrollPanelPrincipal = new JScrollPane(PanelCrearTicket.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolStandard.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN crearTicketStandard()

    public void historialTicketsArea() {
        panelPrincipal.removeAll();
        setBarraEstado("Historial de tickets");
        scrollPanelPrincipal = new JScrollPane(PanelConsultaHistorialArea.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolArea.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN historialTicketsArea()

    public void bandejaEntradaArea() {
        panelPrincipal.removeAll();
        setBarraEstado("Tickets nuevos");
        scrollPanelPrincipal = new JScrollPane(PanelBandejaArea.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolArea.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN bandejaEntradaArea()

    public void reportesArea() {
        panelPrincipal.removeAll();
        setBarraEstado("Reportes de tickets");
        scrollPanelPrincipal = new JScrollPane(PanelReportesArea.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolArea.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN reportesArea()

    public void ticketsDeArea() {
        panelPrincipal.removeAll();
        setBarraEstado("Tickets del área");
        ArbolArea arbol = ArbolArea.obtenerInstancia();
        PanelTicketsDelArea panelCentral = PanelTicketsDelArea.obtenerInstancia();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(arbol, BorderLayout.WEST);
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN ticketsDeArea()

    public void ticketsEnProcesoArea() {
        panelPrincipal.removeAll();
        setBarraEstado("Tickets del área");
        scrollPanelPrincipal = new JScrollPane(PanelTicketsEnProcesoArea.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolArea.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN ticketsEnProcesoArea()

    public void crearTicketArea() {
        panelPrincipal.removeAll();
        setBarraEstado("Creación de ticket");
        scrollPanelPrincipal = new JScrollPane(PanelCrearTicketArea.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolArea.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN crearTicketArea()

    public void buscarUltimoTicketArea() {
        panelPrincipal.removeAll();
        setBarraEstado("Último ticket creado");
        scrollPanelPrincipal = new JScrollPane(PanelUltimoTicketArea.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolArea.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN buscarUltimoTicketArea() 

    public void cambiarClaveArea() {
        panelPrincipal.removeAll();
        setBarraEstado("Cambiar clave");
        scrollPanelPrincipal = new JScrollPane(PanelCambioContraseñaArea.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolArea.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN cambiarClaveArea() 

    public void buscarUnTicketArea() {
        panelPrincipal.removeAll();
        setBarraEstado("Consulta de ticket");
        scrollPanelPrincipal = new JScrollPane(PanelConsultaUnoArea.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolArea.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN buscarUnTicketArea()

    public void ticketsAsignadosArea() {
        panelPrincipal.removeAll();
        setBarraEstado("Tickets asignados");
        scrollPanelPrincipal = new JScrollPane(PanelTicketAsignadosArea.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolArea.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN ticketsAsignadosAdmin()

    public void ventanaPrincipalArea() {
        panelPrincipal.removeAll();
        ArbolArea.previeneError();
        setBarraEstado("Pantalla principal");
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolArea.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(new PanelConFondo("/img/2014-10-12_1322.png"));
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN ventanaPrincipalArea()

    public void cambiarClaveAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Cambiar clave");
        scrollPanelPrincipal = new JScrollPane(PanelCambioContraseñaAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN cambiarClaveAdmin()

    public void bandejaEntradaAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Tickets nuevos");
        scrollPanelPrincipal = new JScrollPane(PanelBandejaAdministrador.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN bandejaEntradaAdmin()

    public void eliminarUsuarioAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Eliminar usuarios");
        scrollPanelPrincipal = new JScrollPane(PanelEliminarUsuarioAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN eliminarUsuarioAdmin()

    public void gestionTicketAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Gestión de ticket");
        scrollPanelPrincipal = new JScrollPane(PanelGestionarTicketAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN gestionTicketAdmin()

    public void registrarUsuarioAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Registro de usuarios");
        scrollPanelPrincipal = new JScrollPane(PanelRegistrarUsuariosAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN registrarUsuarioAdmin()

    public void listaTicketsAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Lista general de tickets");
        scrollPanelPrincipal = new JScrollPane(PanelTodosTicketsAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN listaTicketsAdmin()

    public void buscarUnTicketAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Consulta de ticket");
        scrollPanelPrincipal = new JScrollPane(PanelConsultaUnoAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN buscarUnTicketAdmin()

    public void buscarUltimoTicketAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Último ticket creado");
        scrollPanelPrincipal = new JScrollPane(PanelUltimoTicketAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN buscarUltimoTicketAdmin()

    public void crearTicketAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Creación de ticket");
        scrollPanelPrincipal = new JScrollPane(PanelCrearTicketAdministrativo.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN crearTicketAdmin()

    public void historialTicketsAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Historial de tickets");
        scrollPanelPrincipal = new JScrollPane(PanelConsultaHistorialAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN historialTicketsAdmin()

    public void bloquearUsuarioAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Bloquear usuarios");
        scrollPanelPrincipal = new JScrollPane(PanelBloquearUsuarioAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN bloquearUsuarioAdmin()

    public void desbloquearUsuarioAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Desbloquear usuarios");
        scrollPanelPrincipal = new JScrollPane(PanelDesbloquearUsuarioAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN desbloquearUsuarioAdmin()

    public void ticketsAsignadosAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Tickets asignados");
        scrollPanelPrincipal = new JScrollPane(PanelTicketAsignadosAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN ticketsAsignadosAdmin()
    public void modificarUsuarioAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Modificar Usuario");
        scrollPanelPrincipal = new JScrollPane(PanelModificarUsuario.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN
    public void ConfigurarTicketAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Ajustes en Ticket");
        scrollPanelPrincipal = new JScrollPane(PanelConfigurarTicket.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN
    public void ticketsProcesoAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Tickets en proceso");
        scrollPanelPrincipal = new JScrollPane(PanelTicketEnProcesoAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN ticketsProcesoAdmin()

    public void ticketsCerradosAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Tickets cerrados");
        scrollPanelPrincipal = new JScrollPane(PanelTicketsCerradosAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN ticketsCerradosAdmin()

    public void alertaTicketsAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Alerta de ticket");
        scrollPanelPrincipal = new JScrollPane(PanelAlertaTicketAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN alertaTicketsAdmin()

    public void reportesAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Reportes de tickets");
        ArbolAdministrativo arbol = ArbolAdministrativo.obtenerInstancia();
        PanelReportesAdmin panelCentral = PanelReportesAdmin.obtenerInstancia();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(arbol, BorderLayout.WEST);
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN reportesAdmin()

    public void bitacoraAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Bitácoras");
        scrollPanelPrincipal = new JScrollPane(PanelBitacoraAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN bitacoraAdmin()

    public void TodosTicketsAdmin() {
        panelPrincipal.removeAll();
        setBarraEstado("Todos los Tickets");
        scrollPanelPrincipal = new JScrollPane(PanelTodosTicketsAdmin.obtenerInstancia());
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(scrollPanelPrincipal, BorderLayout.CENTER);
        pack();
        repaint();
    }//----------------------------------------------------------------------------- FIN TodosTicketsAdmin()

    public void ventanaPrincipalAdmin() {
        panelPrincipal.removeAll();
        ArbolAdministrativo.previeneError();
        setBarraEstado("Pantalla principal");
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(ArbolAdministrativo.obtenerInstancia(), BorderLayout.WEST);
        panelPrincipal.add(new PanelConFondo("/img/2014-10-12_1321.png"));
        pack();
        repaint();
    } //----------------------------------------------------------------------------- FIN ventanaPrincipalAdmin()

//    public void olvidoClave(){
//        panelPrincipal.removeAll();
//        setBarraEstado("Recuperar contraseña");
//        PanelOlvidoContraseña panel = PanelOlvidoContraseña.obtenerInstancia();
//        panelPrincipal.setLayout(new BorderLayout());
//        panelPrincipal.add(panel, BorderLayout.CENTER);
//        pack();
//        repaint();
//    }//----------------------------------------------------------------------------- FIN olvidoClave()
    public void ayuda() {
        setBarraEstado("¿Necesita ayuda?");
        JOptionPane.showMessageDialog(this, "Si necesita ayuda por favor comunicarse via "
                + "radio o teléfono \n              con el departamento de TI", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
        setBarraEstadoMensajeAnterior();
    }//----------------------------------------------------------------------------- FIN ayuda()

    @Override
    public void run() {
        try {
            while (true) {
                this.validaTimer();
                this.validarAlertas();
            }
        } catch (Exception e) {
        }
    }//----------------------------------------------------------------------------- FIN run()

    public void validaTimer() {
        //System.out.println("Time ->"+((System.currentTimeMillis() - time_start)/1000));        
        if (sesion && ((System.currentTimeMillis() - time_start) > 300000)) {
            time_start = System.currentTimeMillis();
            sesion = false;
            VentanaLogin.obtenerInstancia().mostrar();
            ocultar();
            this.desAbilitarMenu();
            panelPrincipal.removeAll();
            revalidate();//xq ???
        }
    }//----------------------------------------------------------------------------- FIN validaTimer()
    
    private void validarAlertas() {
        String mensaje = Controlador.obtenerInstancia().nuevaAlerta();
        if(mensaje != null){
            Alertas.obtenerInstancia().WarningAlert(mensaje);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        time_start = System.currentTimeMillis();
        //System.out.println("mouseClicked");
    }//----------------------------------------------------------------------------- FIN mouseClicked()

    @Override
    public void mousePressed(MouseEvent e) {
        time_start = System.currentTimeMillis();
        //System.out.println("mousePressed");
    }//----------------------------------------------------------------------------- FIN mousePressed()

    @Override
    public void mouseReleased(MouseEvent e) {
        time_start = System.currentTimeMillis();
        //System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        time_start = System.currentTimeMillis();
        //System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        time_start = System.currentTimeMillis();
        //System.out.println("mouseExited");
    }

    //Declaracion de variables
    private BarraEstado barraEstado;
    private String usuarioActivo; //Para guardar el tipo de usuario que está utilizando sistema
    //usuarioActivo deber ser clase Usuario posteriormente
    //--o--    
    private final int sizeY = Toolkit.getDefaultToolkit().getScreenSize().height - 50;
    private final int sizeX = Toolkit.getDefaultToolkit().getScreenSize().width - 1;
    //--o--    
    private static Ventana instancia = null;
    //--o--
    private JScrollPane scrollPanelPrincipal = null;
    private JPanel panelPrincipal = null;
    //--o--    
    private JMenuBar menu;
    private JMenu menuArchivo;
    private JMenu menuOpciones;
    private JMenu menuBuscar;
    private JMenu menuCuenta;
    private JMenu menuAyuda;
    //--o--
    private JMenuItem itemSalir;
    private JMenuItem itemCrearTicket;
    private JMenuItem itemBuscarUnTicket;
    private JMenuItem itemBuscarUltimoTicket;
    private JMenuItem itemHistorialTicket;
    private JMenuItem itemDesLoggeo;
    private JMenuItem itemAyuda;
    private JMenuItem itemCambioClave;
    //--o--
     private boolean sesion;
    private long time_start;
    //--o--
    private Alertas alerta;

    

}//____________________________________________________________________END_CLASS
