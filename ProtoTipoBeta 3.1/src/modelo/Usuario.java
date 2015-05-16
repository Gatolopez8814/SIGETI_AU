package modelo;

public class Usuario {

    public Usuario(String correo, int tipoUsuario, int estado) {
        this.correo = correo;
        this.contraseña = GeneradorDeClave.obtenerInstancia().GenerarClave();
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    private String correo;
    private String contraseña;
    private int tipoUsuario;
    private int estado;

}
