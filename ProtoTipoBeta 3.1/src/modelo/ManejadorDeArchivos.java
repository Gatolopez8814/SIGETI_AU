package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManejadorDeArchivos {

    private static ManejadorDeArchivos instancia = null;

    public static ManejadorDeArchivos obtenerInstancia() {
        if (instancia == null) {
            instancia = new ManejadorDeArchivos();
        }
        return instancia;
    }

    public String leerFichero(String nombreArchivo) {
        try {
            File f;
            FileReader lectorArchivo;
            f = new File(nombreArchivo);
            lectorArchivo = new FileReader(f);
            BufferedReader br = new BufferedReader(lectorArchivo);
            String l = "";
            String aux = "";
            while (true) {
                aux = br.readLine();
                if (aux != null) {
                    l = l + aux;
                } else {
                    break;
                }
            }
            br.close();
            lectorArchivo.close();
            return l;
        } catch (IOException e) {

        }
        return null;
    }//end_leer

    public void escribirArchivo(String nombreArchivo, String txt) {
        File f = new File(nombreArchivo);
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(txt);
            wr.close();
            bw.close();
        } catch (IOException e) {
        }
    }//end_escribir

}//end class
