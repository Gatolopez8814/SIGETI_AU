package modelo;

public class Bitacora {

    public Bitacora(String usuario, String fecha, String hora, String tabla, String accion) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.tabla = tabla;
        this.accion = accion;
    }

    public Bitacora() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    private String usuario, fecha, hora, tabla, accion;
}
