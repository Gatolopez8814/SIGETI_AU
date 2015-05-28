package vista;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

public class SigetiTreeCellRenderer implements TreeCellRenderer {//clase para modificar el Jtree de java en los arboles

    public SigetiTreeCellRenderer() {
        label = new JLabel();
    }//----------------------------------------------------------------------------- FIN Constructor()

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Object o = ((DefaultMutableTreeNode) value).getUserObject();
        if (o instanceof Informacion) {
            Informacion country = (Informacion) o;
            label.setIcon(country.getFlagIcon());
            label.setText(country.getName());
        } else {
            label.setIcon(null);
            label.setText("" + value);
        }
        return label;
    }//----------------------------------------------------------------------------- FIN getTreeCellRendererComponent()

    //Declaracion de variables
    private JLabel label;
}//____________________________________________________________________END_CLASS
