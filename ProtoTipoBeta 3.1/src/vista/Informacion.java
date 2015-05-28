package vista;

import javax.swing.ImageIcon;

public class Informacion {//clase para poder asignar la imagen diferente y un nombre a los arboles

    public Informacion(String name, ImageIcon flagIcon) {
        this.name = name;
        this.flagIcon = flagIcon;
    }//----------------------------------------------------------------------------- FIN Constructor()

    public String getName() {
        return name;
    }//----------------------------------------------------------------------------- FIN getName()

    public void setName(String name) {
        this.name = name;
    }//----------------------------------------------------------------------------- FIN setName()

    public ImageIcon getFlagIcon() {
        return flagIcon;
    }//----------------------------------------------------------------------------- FIN getFlagIcon()

    public void setFlagIcon(ImageIcon flagIcon) {
        this.flagIcon = flagIcon;
    }//----------------------------------------------------------------------------- FIN setFlagIcon()

    @Override
    public String toString() {
        return getName();
    }//----------------------------------------------------------------------------- FIN toString()

    //Declaracion de variables
    private String name;
    private ImageIcon flagIcon;
}//____________________________________________________________________END_CLASS
