package vista.Area;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import vista.SigetiTreeCellRenderer;
import vista.Informacion;
import vista.Ventana;

public class ArbolArea extends JPanel {//Arbol para usuario de Area

    public ArbolArea() {//arbol donde se encuentra las opciones del usuario de area       
        ajustarComponentes();
        ajustarEventos();
        addMouseListener(Ventana.obtenerInstancia());
        repaint();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static ArbolArea obtenerInstancia() {//para garantizar hay solo un arbol
        if (instancia == null) {
            instancia = new ArbolArea();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    public static void previeneError() {
        try {
            instancia.abrirArbol();
        } catch (Exception e) {
        }
    }//----------------------------------------------------------------------------- FIN previeneError()

    public void abrirArbol() {
        int[] indice = {1, 2, 3, 4, 5};
        arbol.setSelectionRows(indice);
        for (int i = 0; i < arbol.getRowCount(); i++) {
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
        Informacion infSigeti = new Informacion("SIGET", "src/img/SIGETI-icon16.png");          
        Informacion infTicket = new Informacion("Gestión de tickets               ", "src/img/Carpeta-tickets16.png");  
        Informacion infCrear = new Informacion("Crear nuevo ticket", "src/img/ticket16.png");
        Informacion infArea = new Informacion("Área de trabajo", "src/img/Utilities-iconx16.png"); 
        Informacion infNuevos = new Informacion("Bandeja de entrada", "src/img/inbox-iconx16.png");
        Informacion infTodos = new Informacion("Tickets del área", "src/img/wood-folder-iconx16.png");
        Informacion infEnProceso = new Informacion("Tickets en proceso", "src/img/helical-gear-iconx16.png");
        Informacion infAsignados = new Informacion("Tickets asignados", "src/img/Actions-dashboard-show-iconx16.png");
        Informacion infCarpetaReportes = new Informacion("Gestión reportes", "src/img/Network-Statistics-icon.png");
        Informacion infReportes = new Informacion("Generar reporte", "src/img/Balance-iconx16.png");
        Informacion infConsultas = new Informacion("Gestión consultas", "src/img/Carpeta-Search16.png");
        Informacion infConsultarUltimo = new Informacion("Consultar último ticket", "src/img/Search16.png");
        Informacion infConsultarUno = new Informacion("Consultar un ticket", "src/img/Search216.png");
        Informacion infConsultarTodos = new Informacion("Consultar mis tickets", "src/img/Search316.png");
        Informacion infCambioClave = new Informacion("Cambiar contraseña", "src/img/claveiconx16.png");
        Informacion infConf = new Informacion("Configuración", "src/img/Conf-iconx16.png");
        Informacion infCerrarSeccion = new Informacion("Cerrar sesión", "src/img/user-login-iconx16.png");
        
        nodoSigeti = new DefaultMutableTreeNode(infSigeti);
        nodoTicket = new DefaultMutableTreeNode(infTicket);
        nodoCrear = new DefaultMutableTreeNode(infCrear);

        nodoArea = new DefaultMutableTreeNode(infArea);
        nodoBandejaEntrada = new DefaultMutableTreeNode(infNuevos);
        nodoTodos = new DefaultMutableTreeNode(infTodos);
        nodoProceso = new DefaultMutableTreeNode(infEnProceso);
        nodoAsignados = new DefaultMutableTreeNode(infAsignados);

        nodoReportes = new DefaultMutableTreeNode(infCarpetaReportes);
        nodoReporte = new DefaultMutableTreeNode(infReportes);

        nodoConsultas = new DefaultMutableTreeNode(infConsultas);
        nodoConsultarUltimo = new DefaultMutableTreeNode(infConsultarUltimo);
        nodoConsultarUno = new DefaultMutableTreeNode(infConsultarUno);
        nodoConsultarTodos = new DefaultMutableTreeNode(infConsultarTodos);
        nodoCambioClave = new DefaultMutableTreeNode(infCambioClave);
        nodoConf = new DefaultMutableTreeNode(infConf);
        nodoCerrar = new DefaultMutableTreeNode(infCerrarSeccion);

        nodoReportes.add(nodoReporte);
        nodoArea.add(nodoBandejaEntrada);
        nodoArea.add(nodoTodos);
        nodoArea.add(nodoProceso);
        nodoArea.add(nodoAsignados);
        nodoTicket.add(nodoCrear);
        nodoConsultas.add(nodoConsultarUltimo);
        nodoConsultas.add(nodoConsultarUno);
        nodoConsultas.add(nodoConsultarTodos);
        nodoConf.add(nodoCambioClave);
        nodoConf.add(nodoCerrar);
        nodoSigeti.add(nodoTicket);
        nodoSigeti.add(nodoArea);
        nodoSigeti.add(nodoReportes);
        nodoSigeti.add(nodoConsultas);
        nodoSigeti.add(nodoConf);

        DefaultTreeModel modelo = new DefaultTreeModel(nodoSigeti);

        arbol = new JTree(modelo);
    }//----------------------------------------------------------------------------- FIN armarArbol()

    private void ajustarEventos() {//ajusta los eventos del arbol
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
                Ventana.obtenerInstancia().ventanaPrincipalArea();
                break;
            case "Bandeja de entrada":
                Ventana.obtenerInstancia().bandejaEntradaArea();
                break;
            case "Tickets del área":
                Ventana.obtenerInstancia().ticketsDeArea();
                break;
            case "Crear nuevo ticket":
                Ventana.obtenerInstancia().crearTicketArea();
                break;
            case "Tickets en proceso":
                Ventana.obtenerInstancia().ticketsEnProcesoArea();
                break;
            case "Tickets asignados":
                Ventana.obtenerInstancia().ticketsAsignadosArea();
                break;
            case "Generar reporte":
                Ventana.obtenerInstancia().reportesArea();
                break;
            case "Consultar último ticket":
                Ventana.obtenerInstancia().buscarUltimoTicketArea();
                break;
            case "Consultar un ticket":
                Ventana.obtenerInstancia().buscarUnTicketArea();
                break;
            case "Consultar mis tickets":
                Ventana.obtenerInstancia().historialTicketsArea();
                break;
            case "Cambiar contraseña":
                Ventana.obtenerInstancia().cambiarClaveArea();
                break;
            case "Cerrar sesión":
                Ventana.obtenerInstancia().cerrarSesion();
                break;
        }//end switch
    }//----------------------------------------------------------------------------- FIN redireccionar()

    //Declaracion de variables
    private static ArbolArea instancia = null;
    
    DefaultMutableTreeNode nodoSigeti;
    DefaultMutableTreeNode nodoTicket;
    DefaultMutableTreeNode nodoCrear;
    DefaultMutableTreeNode nodoArea;
    DefaultMutableTreeNode nodoBandejaEntrada;
    DefaultMutableTreeNode nodoTodos;
    DefaultMutableTreeNode nodoProceso;
    DefaultMutableTreeNode nodoAsignados;
    DefaultMutableTreeNode nodoReportes;
    DefaultMutableTreeNode nodoReporte;
    DefaultMutableTreeNode nodoConsultas;
    DefaultMutableTreeNode nodoConsultarUltimo;
    DefaultMutableTreeNode nodoConsultarUno;
    DefaultMutableTreeNode nodoConsultarTodos;
    DefaultMutableTreeNode nodoCambioClave;
    DefaultMutableTreeNode nodoConf;
    DefaultMutableTreeNode nodoCerrar;
    //--o--
    private JTree arbol;

}//____________________________________________________________________END_CLASS
