package controlador;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionMySql {

    private static ConexionMySql instancia = null;
    private Connection conexion;

    public static ConexionMySql obtenerInstancia() {
        //asi garantizamos que solo aya una ventana
        if (instancia == null) {
            instancia = new ConexionMySql();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    public Connection conectar() {
        boolean ok = false;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sigeti", "root", "manager");
            if (conexion != null) {
                ok = true;
            } else {
                ok = false;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return conexion;
    }//----------------------------------------------------------------------------- FIN conectar()

    public void desconectar() {
        try {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//----------------------------------------------------------------------------- FIN desconectar()

    public Connection getConexion() {
        return conexion;
    }//----------------------------------------------------------------------------- FIN getConexion()
}
