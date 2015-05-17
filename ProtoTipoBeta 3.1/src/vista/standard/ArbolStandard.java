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
import vista.SigetiTreeCellRenderer;
import vista.Informacion;
import vista.Ventana;

public class ArbolStandard extends JPanel {

    private ArbolStandard() {
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

    private void armarArbol() {
        Informacion infSigeti = new Informacion("SIGETI", "src/img/SIGETI-icon16.png");          
        Informacion infTicket = new Informacion("Gestión de tickets               ", "src/img/Carpeta-tickets16.png");   
        Informacion infCrear = new Informacion("Crear nuevo ticket", "src/img/ticket16.png");
        Informacion infConsultas = new Informacion("Gestión de consultas", "src/img/Carpeta-Search16.png");
        Informacion infConsultarUltimo = new Informacion("Consultar último ticket", "src/img/Search16.png");
        Informacion infConsultarUno = new Informacion("Consultar un ticket", "src/img/Search216.png");
        Informacion infConsultarTodos = new Informacion("Historial de tickets", "src/img/Search316.png");
        Informacion infCambioClave = new Informacion("Cambiar contraseña", "src/img/claveiconx16.png");
        Informacion infConf = new Informacion("Configuración", "src/img/Conf-iconx16.png");
        Informacion infCerrarSeccion = new Informacion("Cerrar sesión", "src/img/user-login-iconx16.png");

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

        nodoTicket.add(nodoCrear);
        nodoConsultas.add(nodoConsultarUltimo);
        nodoConsultas.add(nodoConsultarUno);
        nodoConsultas.add(nodoConsultarTodos);
        nodoConf.add(nodoCambioClave);
        nodoConf.add(nodoCerrar);
        nodoSigeti.add(nodoTicket);
        nodoSigeti.add(nodoConsultas);
        nodoSigeti.add(nodoConf);

        DefaultTreeModel modelo = new DefaultTreeModel(nodoSigeti);
        arbol = new JTree(modelo);
    }//----------------------------------------------------------------------------- FIN armarArbol()

    private void ajustarEventos() {
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
                    break;
                case "Consultar último ticket":
                    Ventana.obtenerInstancia().buscarUltimoTicketStandard();
                    break;
                case "Consultar un ticket":
                    Ventana.obtenerInstancia().buscarUnTicketStandard();
                    break;
                case "Historial de tickets":
                    Ventana.obtenerInstancia().historialTicketsStandard();
                    break;
                case "Cambiar contraseña":
                    Ventana.obtenerInstancia().cambiarClaveStandar();
                    break;
                case "Cerrar sesión":
                    Ventana.obtenerInstancia().cerrarSesion();
                    break;
                case "SIGETI":
                    Ventana.obtenerInstancia().ventanaPrincipalStandard();
                    break;
            }
        } catch (Exception e) {
        }

    }//----------------------------------------------------------------------------- FIN redireccionar()

    //Declaracion de variables
    private static ArbolStandard instancia = null;
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
    private JTree arbol;

}//____________________________________________________________________END_CLASS
