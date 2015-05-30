package vista.administrativo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import vista.SigetiTreeCellRenderer;
import vista.Informacion;
import vista.Ventana;

public class ArbolAdministrativo extends JPanel {//Arbol para usuario de Administrativo

    public ArbolAdministrativo() {//arbol donde se encuentra las opciones del usuario de area       
        ajustarComponentes();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static ArbolAdministrativo obtenerInstancia() {//para garantizar hay solo un arbol
        if (instancia == null) {
            instancia = new ArbolAdministrativo();
        }  
        instancia.ajustarEventos();
        instancia.addMouseListener(Ventana.obtenerInstancia());
        instancia.repaint();
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia

    public static void previeneError() {
        try {
            instancia.abrirArbol();
        } catch (Exception e) {
        }
    }//----------------------------------------------------------------------------- FIN previeneError()

    public void abrirArbol() {
        int[] indice = {1, 2, 3, 4, 5};
        arbol.setSelectionRows(indice);
        for(int i=0;i< arbol.getRowCount();i++){
            arbol.expandRow(i);
        }       
    }//----------------------------------------------------------------------------- FIN abrirArbol()

    private void ajustarComponentes() {
        armarArbol();
        arbol.setCellRenderer(new SigetiTreeCellRenderer());
        this.add(arbol);
        this.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout());
        arbol.setSize(180, 500);
        arbol.setPreferredSize(new Dimension(180, 500));
        arbol.setMinimumSize(new Dimension(180, 500));
        repaint();
    }//----------------------------------------------------------------------------- FIN ajustarComponentes()

    private void armarArbol() {//inicializa y arma el jTree
        Informacion infSigeti = new Informacion("SIGETI", new ImageIcon(getClass().getResource("/img/SIGETI-icon16.png")));          
        Informacion infTicket = new Informacion("Gestión de tickets               ", new ImageIcon(getClass().getResource("/img/Carpeta-tickets16.png")) );   
        Informacion infCrear = new Informacion("Crear nuevo ticket", new ImageIcon(getClass().getResource("/img/ticket16.png")));
        Informacion infBandejaEntrada = new Informacion("Bandeja de entrada", new ImageIcon(getClass().getResource("/img/inbox-iconx16.png")));
        Informacion infEnProceso = new Informacion("Tickets en proceso", new ImageIcon(getClass().getResource("/img/helical-gear-iconx16.png")));
        Informacion infAsignados = new Informacion("Tickets asignados", new ImageIcon(getClass().getResource("/img/User-Files-iconx16.png")));
        Informacion infAlertas = new Informacion("Alertas de tickets", new ImageIcon(getClass().getResource("/img/Alerts-iconx16.png")));
        Informacion infCerrados = new Informacion("Tickets cerrados", new ImageIcon(getClass().getResource("/img/wood-box-iconx16.png")));
        Informacion infConfTicket = new Informacion("Asuntos y áreas", new ImageIcon(getClass().getResource("/img/Control-Panel-icon.png")));
        
        Informacion infGestionReportes = new Informacion("Gestión de reportes", new ImageIcon(getClass().getResource("/img/MI-Scare-Report-iconx16.png")));
        Informacion infReportes = new Informacion("Generar reporte", new ImageIcon(getClass().getResource("/img/Reports-iconx16.png")));
        Informacion infBitacora = new Informacion("Bitácora",new ImageIcon(getClass().getResource("/img/contacts-icon2x16.png")) );

        Informacion infGestionUsuarios = new Informacion("Gestión de usuarios",new ImageIcon(getClass().getResource("/img/users-iconx16.png")) );
        Informacion infAgregarUsuario = new Informacion("Registrar usuario",new ImageIcon(getClass().getResource("/img/Actions-list-add-user-iconx16.png")) );
        Informacion infEliminarUsuario = new Informacion("Eliminar usuario",new ImageIcon(getClass().getResource( "/img/Actions-list-remove-user-iconx16.png")));
        Informacion infBloqueoUsuario = new Informacion("Bloquear usuario", new ImageIcon(getClass().getResource("/img/Apps-preferences-desktop-user-password-iconx16.png")));
        Informacion infDesBloqueoUsuario = new Informacion("Desbloquear usuario", new ImageIcon(getClass().getResource("/img/Apps-preferences-desktop-user-iconx16.png")));
        Informacion infCambioTipo = new Informacion("Cambiar Tipo usuario", new ImageIcon(getClass().getResource("/img/Actions-user-properties-icon.png")));
        
        Informacion infConsultas = new Informacion("Gestión consultas",new ImageIcon(getClass().getResource("/img/Carpeta-Search16.png")) );
        Informacion infConsultarUltimo = new Informacion("Consultar úlltimo ticket",new ImageIcon(getClass().getResource("/img/Search16.png")) );
        Informacion infConsultarUno = new Informacion("Consultar un ticket", new ImageIcon(getClass().getResource("/img/Search216.png")));
        Informacion infConsultarTodos = new Informacion("Consultar varios tickets",new ImageIcon(getClass().getResource( "/img/Search316.png")));
        Informacion infCambioClave = new Informacion("Cambiar contraseña",new ImageIcon(getClass().getResource( "/img/claveiconx16.png")));
        Informacion infConf = new Informacion("Configuración",new ImageIcon(getClass().getResource("/img/Conf-iconx16.png")) );
        Informacion infCerrarSeccion = new Informacion("Cerrar sesión",new ImageIcon(getClass().getResource("/img/user-login-iconx16.png")) );
        Informacion infTodosTickets = new Informacion("Todos los tickets", new ImageIcon(getClass().getResource("/img/3-Gray-Paper-Box-icon.png")));

        DefaultMutableTreeNode nodoSigeti = new DefaultMutableTreeNode(infSigeti);
        DefaultMutableTreeNode nodoTicket = new DefaultMutableTreeNode(infTicket);
        DefaultMutableTreeNode nodoCrear = new DefaultMutableTreeNode(infCrear);
        DefaultMutableTreeNode nodoBandeja = new DefaultMutableTreeNode(infBandejaEntrada);
        DefaultMutableTreeNode nodoProceso = new DefaultMutableTreeNode(infEnProceso);
        DefaultMutableTreeNode nodoAsignados = new DefaultMutableTreeNode(infAsignados);
        DefaultMutableTreeNode nodoAlertas = new DefaultMutableTreeNode(infAlertas);
        DefaultMutableTreeNode nodoCerrados = new DefaultMutableTreeNode(infCerrados);
        DefaultMutableTreeNode nodoConfTicket = new DefaultMutableTreeNode(infConfTicket);
        
        DefaultMutableTreeNode nodoGestionReportes = new DefaultMutableTreeNode(infGestionReportes);
        DefaultMutableTreeNode nodoBitacora = new DefaultMutableTreeNode(infBitacora);
        DefaultMutableTreeNode nodoReportes = new DefaultMutableTreeNode(infReportes);

        DefaultMutableTreeNode nodoGestionUsuarios = new DefaultMutableTreeNode(infGestionUsuarios);
        DefaultMutableTreeNode nodoAgregarUsuarios = new DefaultMutableTreeNode(infAgregarUsuario);
        DefaultMutableTreeNode nodoBloquearUsuario = new DefaultMutableTreeNode(infBloqueoUsuario);
        DefaultMutableTreeNode nodoDesBloquearUsuario = new DefaultMutableTreeNode(infDesBloqueoUsuario);
        DefaultMutableTreeNode nodoEliminarUsuarios = new DefaultMutableTreeNode(infEliminarUsuario);
        DefaultMutableTreeNode nodoCambioTipo = new DefaultMutableTreeNode(infCambioTipo);
        
        DefaultMutableTreeNode nodoConsultas = new DefaultMutableTreeNode(infConsultas);
        DefaultMutableTreeNode nodoConsultarUltimo = new DefaultMutableTreeNode(infConsultarUltimo);
        DefaultMutableTreeNode nodoConsultarUno = new DefaultMutableTreeNode(infConsultarUno);
        DefaultMutableTreeNode nodoConsultarTodos = new DefaultMutableTreeNode(infConsultarTodos);
        DefaultMutableTreeNode nodoCambioClave = new DefaultMutableTreeNode(infCambioClave);
        DefaultMutableTreeNode nodoConf = new DefaultMutableTreeNode(infConf);
        DefaultMutableTreeNode nodoCerrar = new DefaultMutableTreeNode(infCerrarSeccion);
        DefaultMutableTreeNode nodoTodosTickets = new DefaultMutableTreeNode(infTodosTickets);

        nodoTicket.add(nodoCrear);
        nodoTicket.add(nodoTodosTickets);
        nodoTicket.add(nodoBandeja);
        nodoTicket.add(nodoProceso);
        nodoTicket.add(nodoAsignados);
        nodoTicket.add(nodoAlertas);
        nodoTicket.add(nodoCerrados);
        nodoTicket.add(nodoConfTicket);
        nodoGestionReportes.add(nodoReportes);
        nodoGestionReportes.add(nodoBitacora);
        nodoGestionUsuarios.add(nodoAgregarUsuarios);
        nodoGestionUsuarios.add(nodoBloquearUsuario);
        nodoGestionUsuarios.add(nodoDesBloquearUsuario);
        nodoGestionUsuarios.add(nodoEliminarUsuarios);
        nodoGestionUsuarios.add(nodoCambioTipo);
        nodoConsultas.add(nodoConsultarUltimo);
        nodoConsultas.add(nodoConsultarUno);
        nodoConsultas.add(nodoConsultarTodos);
        nodoConf.add(nodoCambioClave);
        nodoConf.add(nodoCerrar);
        nodoSigeti.add(nodoTicket);
        nodoSigeti.add(nodoGestionReportes);
        nodoSigeti.add(nodoGestionUsuarios);
        nodoSigeti.add(nodoConsultas);
        nodoSigeti.add(nodoConf);

        DefaultTreeModel modelo = new DefaultTreeModel(nodoSigeti);
        arbol = new JTree(modelo);
    }//----------------------------------------------------------------------------- FIN armarArbol()

    private void ajustarEventos() {//ajusta los eventos del arbol
        addMouseListener(Ventana.obtenerInstancia());
        arbol.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent tse) {
                try {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();
                    String opc = selectedNode.getUserObject().toString();
                    redireccionar(opc);
                } catch (Exception e) {
                }
            }
        });
    }//----------------------------------------------------------------------------- FIN ajustarEventos()

    public void redireccionar(String opc) {       
        switch (opc) {
            case "SIGETI":
                Ventana.obtenerInstancia().ventanaPrincipalAdmin();
                break;
            case "Crear nuevo ticket":
                Ventana.obtenerInstancia().crearTicketAdmin();
                break;
            case "Bandeja de entrada":
                Ventana.obtenerInstancia().bandejaEntradaAdmin();
                break;
            case "Tickets en proceso":
                Ventana.obtenerInstancia().ticketsProcesoAdmin();
                break;
            case "Tickets asignados":
                Ventana.obtenerInstancia().ticketsAsignadosAdmin();
                break;
            case "Alertas de tickets":
                Ventana.obtenerInstancia().alertaTicketsAdmin();
                break;
            case "Tickets cerrados":
                Ventana.obtenerInstancia().ticketsCerradosAdmin();
                break;
            case "Generar reporte":
                Ventana.obtenerInstancia().reportesAdmin();
                break;
            case "Bitácora":
                Ventana.obtenerInstancia().bitacoraAdmin();
                break;
            case "Cambiar Tipo usuario":
                Ventana.obtenerInstancia().modificarUsuarioAdmin();
                break;
            case "Asuntos y áreas":
                Ventana.obtenerInstancia().ConfigurarTicketAdmin();
                break;
            case "Registrar usuario":
                Ventana.obtenerInstancia().registrarUsuarioAdmin();
                break;
            case "Eliminar usuario":
                Ventana.obtenerInstancia().eliminarUsuarioAdmin();
                break;
            case "Bloquear usuario":
                Ventana.obtenerInstancia().bloquearUsuarioAdmin();
                break;
            case "Desbloquear usuario":
                Ventana.obtenerInstancia().desbloquearUsuarioAdmin();
                break;
            case "Consultar úlltimo ticket":
                Ventana.obtenerInstancia().buscarUltimoTicketAdmin();
                break;
            case "Consultar un ticket":
                Ventana.obtenerInstancia().buscarUnTicketAdmin();
                break;
            case "Consultar varios tickets":
                Ventana.obtenerInstancia().historialTicketsAdmin();
                break;
            case "Cambiar contraseña":
                Ventana.obtenerInstancia().cambiarClaveAdmin();
                break;
            case "Cerrar sesión":
                Ventana.obtenerInstancia().cerrarSesion();
                break;
            case "Todos los tickets":
                Ventana.obtenerInstancia().TodosTicketsAdmin();
                break;
        }//end switch

    }//----------------------------------------------------------------------------- FIN redireccionar()

    //Declaracion de variables
    private static ArbolAdministrativo instancia = null;
    private JTree arbol;
}//____________________________________________________________________END_CLASS
