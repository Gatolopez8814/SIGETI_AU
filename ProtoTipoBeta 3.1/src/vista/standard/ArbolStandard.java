package vista.standard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import vista.SigetiTreeCellRenderer;
import vista.Informacion;
import vista.Ventana;

public class ArbolStandard extends JPanel {//Arbol para usuario standard

    private ArbolStandard() {//arbol donde se encuentra las opciones del usuario       
        ajustarComponentes();
        ajustarEventos();
        addMouseListener(Ventana.obtenerInstancia());        
        repaint();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static ArbolStandard obtenerInstancia() {//para garantizar hay solo un arbol
        if (instancia == null) {
            instancia = new ArbolStandard();
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
        int[] indice = {1, 2, 3};
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
        Informacion infSigeti = new Informacion("SIGETI", "src/img/SIGETI-icon16.png"); //abuelo            
        Informacion infTicket = new Informacion("Gestión de tickets               ", "src/img/Carpeta-tickets16.png");//padre 1   
        Informacion infCrear = new Informacion("Crear nuevo ticket", "src/img/ticket16.png");
        Informacion infConsultas = new Informacion("Gestión de consultas", "src/img/Carpeta-Search16.png");//padre 2
        Informacion infConsultarUltimo = new Informacion("Consultar último ticket", "src/img/Search16.png");
        Informacion infConsultarUno = new Informacion("Consultar un ticket", "src/img/Search216.png");
        Informacion infConsultarTodos = new Informacion("Historial de tickets", "src/img/Search316.png");
        Informacion infCambioClave = new Informacion("Cambiar contraseña", "src/img/claveiconx16.png");
        Informacion infConf = new Informacion("Configuración", "src/img/Conf-iconx16.png");
        Informacion infCerrarSeccion = new Informacion("Cerrar sesión", "src/img/user-login-iconx16.png");
        //--o--
        nodoSigeti = new DefaultMutableTreeNode(infSigeti);
        nodoTicket = new DefaultMutableTreeNode(infTicket);
        nodoCrear = new DefaultMutableTreeNode(infCrear);
        nodoConsultas = new DefaultMutableTreeNode(infConsultas);
        nodoConsultarUltimo = new DefaultMutableTreeNode(infConsultarUltimo);
        nodoConsultarUno = new DefaultMutableTreeNode(infConsultarUno);
        nodoConsultarTodos = new DefaultMutableTreeNode(infConsultarTodos);
        nodoCambioClave = new DefaultMutableTreeNode(infCambioClave);
        nodoConf = new DefaultMutableTreeNode(infConf);
        nodoCerrar = new DefaultMutableTreeNode(infCerrarSeccion);
        //--o--
        nodoTicket.add(nodoCrear);
        nodoConsultas.add(nodoConsultarUltimo);
        nodoConsultas.add(nodoConsultarUno);
        nodoConsultas.add(nodoConsultarTodos);
        nodoConf.add(nodoCambioClave);
        nodoConf.add(nodoCerrar);
        nodoSigeti.add(nodoTicket);
        nodoSigeti.add(nodoConsultas);
        nodoSigeti.add(nodoConf);
        //--o--
        DefaultTreeModel modelo = new DefaultTreeModel(nodoSigeti);
        //--o--
        arbol = new JTree(modelo);
    }//----------------------------------------------------------------------------- FIN armarArbol()

    private void ajustarEventos() {//ajusta los eventos del arbol
        try {
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
        } catch (Exception e) {
        }
    }//----------------------------------------------------------------------------- FIN ajustarEventos()

    public void redireccionar(String opc) {
        try {           
            switch (opc) {
                case "Crear nuevo ticket":
                    Ventana.obtenerInstancia().crearTicketStandard();
                    System.out.println(" Crear Ticket");
                    break;
                case "Consultar último ticket":
                    Ventana.obtenerInstancia().buscarUltimoTicketStandard();
                    System.out.println(" Buscar Ultimo");
                    break;
                case "Consultar un ticket":
                    Ventana.obtenerInstancia().buscarUnTicketStandard();
                    System.out.println(" Buscar uno");
                    break;
                case "Historial de tickets":
                    Ventana.obtenerInstancia().historialTicketsStandard();
                    System.out.println(" Ver Historial");
                    break;
                case "Cambiar contraseña":
                    Ventana.obtenerInstancia().cambiarClaveStandar();
                    System.out.println("Cambiar Clave");
                    break;
                case "Cerrar sesión":
                    Ventana.obtenerInstancia().cerrarSesion();
                    System.out.println("Cerrar Sesion");
                    break;
                case "SIGETI":
                    Ventana.obtenerInstancia().ventanaPrincipalStandard();
                    System.out.println(" Ventana Principal");
                    break;
            }//end switch
        } catch (Exception e) {
        }

    }//----------------------------------------------------------------------------- FIN redireccionar()

    //Declaracion de variables
    private static ArbolStandard instancia = null;
    //--o--
    DefaultMutableTreeNode nodoSigeti;
    DefaultMutableTreeNode nodoTicket;
    DefaultMutableTreeNode nodoCrear;
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
