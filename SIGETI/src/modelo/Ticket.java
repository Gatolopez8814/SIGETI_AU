package modelo;

public class Ticket {

    public Ticket() {
    }

    public Ticket(String detalleProblema, String estado, String comentarios, String correoUsuario, String areaDestino,
            String tiempoSolucion, String responsable, String tiempoRealSolucion, String asunto, String hora,
            int prioridad, int consecutivo, String fecha, String especificacion) {
        this.detalleProblema = detalleProblema;
        this.estado = estado;
        this.comentarios = comentarios;
        this.correoUsuario = correoUsuario;
        this.areaDestino = areaDestino;
        this.tiempoSolucion = tiempoSolucion;
        this.responsable = responsable;
        this.tiempoRealSolucion = tiempoRealSolucion;
        this.asunto = asunto;
        this.hora = hora;
        this.prioridad = prioridad;
        this.consecutivo = consecutivo;
        this.fecha = fecha;
        this.especificacion = especificacion;
    }

    public String getDetalleProblema() {
        return detalleProblema;
    }

    public void setDetalleProblema(String detalleProblema) {
        this.detalleProblema = detalleProblema;
    }

    public String getAreaDestino() {
        return areaDestino;
    }

    public void setAreaDestino(String areaDestino) {
        this.areaDestino = areaDestino;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getTiempoSolucion() {
        return tiempoSolucion;
    }

    public void setTiempoSolucion(String tiempoSolucion) {
        this.tiempoSolucion = tiempoSolucion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getTiempoRealSolucion() {
        return tiempoRealSolucion;
    }

    public void setTiempoRealSolucion(String tiempoRealSolucion) {
        this.tiempoRealSolucion = tiempoRealSolucion;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    private String detalleProblema;
    private String estado;
    private String comentarios;
    private String correoUsuario;
    private String areaDestino;
    private String tiempoSolucion;
    private String responsable;
    private String tiempoRealSolucion;
    private String asunto;
    private String hora;
    private int prioridad;
    private int consecutivo;
    private String fecha;
    private String especificacion;
}//____________________________________________________________________END_CLASS 
