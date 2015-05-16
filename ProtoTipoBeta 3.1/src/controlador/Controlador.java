package controlador;

import java.util.ArrayList;
import modelo.Bitacora;
import modelo.Modelo;
import modelo.Ticket;
import modelo.Usuario;

public class Controlador {

    private Controlador() {
        model = new Modelo();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public String recortaCorreo(String _correo) {
        return model.recortaCorreo(_correo);
    }//----------------------------------------------------------------------------- FIN recortaCorreo()

    public boolean registraUsuarioAdmin(String correo, int tipo) {
        String correoFinal = model.recortaCorreo(correo) + "@castillo.cr";
        return model.registraUsuarioAdmin(new Usuario(correoFinal, tipo, 1));
    }//----------------------------------------------------------------------------- FIN registraUsuarioAdmin()

    public boolean ModificaUsuarioAdmin(String correo, int tipo) {
        String correoFinal = model.recortaCorreo(correo) + "@castillo.cr";
        return model.ModificaUsuarioAdmin(new Usuario(correoFinal, tipo, 1));
    }//----------------------------------------------------------------------------- FIN registraUsuarioAdmin()

    public boolean cambiaARegistrado(String correoUsuario, int nuevoTipo) {
        String correoFinal = model.recortaCorreo(correoUsuario) + "@castillo.cr";
        return model.cambiaARegistrado(correoFinal, nuevoTipo);
    }//----------------------------------------------------------------------------- FIN cambiaARegistrado()

    public boolean eliminaUsuarioAdmin(String correo) {
        String correoFinal = model.recortaCorreo(correo) + "@castillo.cr";
        return model.eliminaUsuarioAdmin(correoFinal);
    }//----------------------------------------------------------------------------- FIN eliminaUsuarioAdmin()

    public ArrayList<Integer> verificaLoggin(String correo, String contraseña) {
        String correoFinal = model.recortaCorreo(correo) + "@castillo.cr";
        return model.verificaLoggin(correoFinal, contraseña);
    }//----------------------------------------------------------------------------- FIN verificaLoggin()

    public boolean verificarContrasenna(String correo, String contraseña) {
        return model.verificarContrasenna(correo, contraseña);
    }//----------------------------------------------------------------------------- FIN verificarContrasenna()

    public int obtieneEstadoUsuario(String correoUsuario) {
        String correoFinal = model.recortaCorreo(correoUsuario) + "@castillo.cr";
        return model.obtieneEstadoUsuario(correoFinal);
    }//----------------------------------------------------------------------------- FIN obtieneEstadoUsuario()

    public boolean bloqueaUsuarioAdmin(String correo) {
        String correoFinal = model.recortaCorreo(correo) + "@castillo.cr";
        return model.bloqueaUsuarioAdmin(correoFinal);
    }//----------------------------------------------------------------------------- FIN bloqueaUsuarioAdmin()

    public boolean desBloqueaUsuarioAdmin(String correo) {
        String correoFinal = model.recortaCorreo(correo) + "@castillo.cr";
        return model.desBloqueaUsuarioAdmin(correoFinal);
    }//----------------------------------------------------------------------------- FIN desBloqueaUsuarioAdmin()

    public boolean enviaCorreo(String mensaje, String asunto, String correoUsuario) {
        return model.enviaCorreo(mensaje, asunto, correoUsuario);
    }//----------------------------------------------------------------------------- FIN enviaCorreo()

    public boolean validaContraseña(String contraseña) {
        return model.validaContrasenna(contraseña);
    }//----------------------------------------------------------------------------- FIN validaContrasenna()

    public static Controlador obtenerInstancia() {
        if (instancia == null) {
            instancia = new Controlador();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    public boolean registraNuevoTicket(String detalleProblema, int consecutivo, String estado, String comentarios,
            String correoUsuario, int prioridad, String areaDestino, String tiempoSolucion, String responsable,
            String tiempoRealSolucion, String asunto, String hora, String fecha, String especificacion) {

        return model.registraNuevoTicket(new Ticket(detalleProblema, estado, comentarios, correoUsuario, areaDestino,
                tiempoSolucion, responsable, tiempoRealSolucion, asunto, hora, prioridad, consecutivo, fecha, especificacion));
    }//----------------------------------------------------------------------------- FIN registraNuevoTicket()

    public ArrayList<Ticket> consultaTodosTicket(String dato1, String dato2, String _correo) {
        return model.consultaTodosTicket(dato1, dato2, _correo);
    }//------------------------------------------------------------------------------FIN ConsultaTodosTickets

    public Ticket consultaUno(int _codigo, String _correo) {
        Ticket _ticket = model.consultaUno(_codigo, _correo);
        return _ticket;
    }//----------------------------------------------------------------------------- FIN consultaUno()

    public Ticket consultaUltimo(String _correo) {
        return model.consultaUltimo(_correo);
    }//----------------------------------------------------------------------------- FIN consultaUltimo()

    public boolean cambioEstadoLeido(int _codigo) {
        return model.cambioEstadoLeido(_codigo);
    }//----------------------------------------------------------------------------- FIN cambioEstadoLeido()

    public boolean cambiarContrasena(String _correo, String _contNueva, String _contAnterior) {
        return model.cambiarContrasena(_correo, _contNueva, _contAnterior);
    }//----------------------------------------------------------------------------- FIN cambiarContrasena()

    public ArrayList<Ticket> ticketsDelArea(String _correoUsuario) {
        return model.ticketsDelArea(_correoUsuario);
    }//----------------------------------------------------------------------------- FIN ticketsDelArea()

    public ArrayList<Ticket> ticketsEnProcesoArea(String _correoUsuario) {
        return model.ticketsEnProcesoArea(_correoUsuario);
    }//----------------------------------------------------------------------------- FIN ticketsEnProcesoAreaArea()

    public ArrayList<Ticket> ticketsEnProcesoAdmin() {
        return model.ticketsEnProcesoAdmin();
    }//----------------------------------------------------------------------------- FIN ticketsEnProcesoAreaAdmin()

    public ArrayList<Ticket> ticketsDelAreaAsignados(String _correoUsuario) {
        return model.ticketsDelAreaAsignados(_correoUsuario);
    }//----------------------------------------------------------------------------- FIN ticketsDelAreaAsignados()

    public ArrayList<Ticket> ticketsAsignadosAdmin() {
        return model.ticketsAsignadosAdmin();
    }//----------------------------------------------------------------------------- FIN ticketsAsignadosAdmin()

    public ArrayList<Ticket> ticketsBandejaEntradaArea(String _correoUsuario) {
        return model.ticketsBandejaEntradaArea(_correoUsuario);
    }//----------------------------------------------------------------------------- FIN  ticketsBandejaEntradaArea()

    public ArrayList<Ticket> ticketsBandejaEntradaAdmin() {
        return model.ticketsBandejaEntradaAdmin();
    }//----------------------------------------------------------------------------- FIN  ticketsBandejaEntradaAdmin()

    public boolean cerrarTicket(int _codigo) {
        return model.cerrarTicket(_codigo);
    }//----------------------------------------------------------------------------- FIN cerrarTicket()

    public ArrayList<Ticket> ticketsCerradosArea(String _correoUsuario) {
        return model.ticketsCerradosArea(_correoUsuario);
    }//----------------------------------------------------------------------------- FIN ticketsCerradosArea()

    public ArrayList<Ticket> ticketsCerradosAdmin() {
        return model.ticketsCerradosAdmin();
    }//----------------------------------------------------------------------------- FIN ticketsCerradosAdmin()

    public boolean registroAreaUsuario(String _correo, String _area) {
        String correoFinal = model.recortaCorreo(_correo) + "@castillo.cr";
        return model.registraAreaUsuario(correoFinal, _area);
    }//----------------------------------------------------------------------------- FIN registroAreaUsuario()

    public boolean modificaAreaUsuario(String _correo, String _area) {
        String correoFinal = model.recortaCorreo(_correo) + "@castillo.cr";
        return model.modificaAreaUsuario(correoFinal, _area);
    }//----------------------------------------------------------------------------- FIN registroAreaUsuario()

    public ArrayList<String> obtieneAreas() {
        return model.obtieneAreas();
    }//----------------------------------------------------------------------------- FIN obtieneAreas()

    public ArrayList<String> obtieneUsuarios(String usuarioActual, int estado) {
        return model.obtieneUsuarios(usuarioActual, estado);
    }//----------------------------------------------------------------------------- FIN obtieneUsuarios()

    public ArrayList<String> obtieneUsuariosEliminar(String usuarioActual, int estado) {
        return model.obtieneUsuariosEliminar(usuarioActual, estado);
    }//----------------------------------------------------------------------------- FIN obtieneUsuariosEliminar()

    public ArrayList<String> obtieneTodosUsuarios() {
        return model.obtieneTodosUsuarios();
    }//----------------------------------------------------------------------------- FIN obtieneTodosUsuarios()

    public ArrayList<String> obtieneUsuariosGeneral() {
        return model.obtieneUsuariosGeneral();
    }//----------------------------------------------------------------------------- FIN obtieneUsuariosGeneral()

    public String obtieneNombreArea(String _correoUsuario) {
        return model.obtieneNombreArea(_correoUsuario);
    }//----------------------------------------------------------------------------- FIN obtieneNombreArea()

    public ArrayList<String> obtieneUsuariosPorArea(String _area) {
        return model.obtieneUsuariosPorArea(_area);
    }//----------------------------------------------------------------------------- FIN obtieneUsuariosPorArea()

    public ArrayList<String> obtieneAsuntos() {
        return model.obtieneAsuntos();
    }//----------------------------------------------------------------------------- FIN obtieneAsuntos()

    public Ticket informacionTicket(int _codigo) {
        return model.informacionTicket(_codigo);
    }//----------------------------------------------------------------------------- FIN informacionTicket()

    public int cantidadNuevosAdmin() {
        return model.cantidadNuevosAdmin();
    }//----------------------------------------------------------------------------- FIN cantidadNuevosAdmin()

    public int cantidadAsignadosAdmin() {
        return model.cantidadAsignadosAdmin();
    }//----------------------------------------------------------------------------- FIN cantidadAsignadosAdmin()

    public int cantidadProcesoAdmin() {
        return model.cantidadProcesoAdmin();
    }//----------------------------------------------------------------------------- FIN cantidadProcesoAdmin()

    public int cantidadCerradosAdmin() {
        return model.cantidadCerradosAdmin();
    }//----------------------------------------------------------------------------- FIN cantidadCerradosAdmin()

    public int cantidadTotalAdmin() {
        return model.cantidadTotalAdmin();
    }//----------------------------------------------------------------------------- FIN cantidadTotalAdmin()

    public ArrayList<Ticket> ticketsTodoLosTickets() {
        return model.ticketsTodosLosTickets();
    }//----------------------------------------------------------------------------- FIN  ticketsTodosLosTickets()

    public int cantidadTotalArea(String _correo) {
        return model.cantidadTotalArea(_correo);
    }//----------------------------------------------------------------------------- FIN  cantidadTotalArea()

    public int cantidadNuevosArea(String _correo) {
        return model.cantidadNuevosArea(_correo);
    }//----------------------------------------------------------------------------- FIN  cantidadNuevosArea()

    public int cantidadAsignadosArea(String _correo) {
        return model.cantidadAsignadosArea(_correo);
    }//----------------------------------------------------------------------------- FIN  cantidadAsignadosArea()

    public int cantidadProcesoArea(String _correo) {
        return model.cantidadProcesoArea(_correo);
    }//----------------------------------------------------------------------------- FIN  cantidadProcesoArea()

    public int cantidadCerradosArea(String _correo) {
        return model.cantidadCerradosArea(_correo);
    }//----------------------------------------------------------------------------- FIN  cantidadCerradosArea()

    public boolean agregaComentario(int _codigo, String _comentario) {
        return model.agregaComentario(_codigo, _comentario);
    }//----------------------------------------------------------------------------- FIN agregaComentario()

    public String obtieneComentarios(int codigo) {
        return model.obtieneComentarios(codigo);
    }//----------------------------------------------------------------------------- FIN obtieneComentarios()

    public boolean cambiaFechaSolucion(int _codigo, String _comentario) {
        return model.cambiaFechaSolucion(_codigo, _comentario);
    }//----------------------------------------------------------------------------- FIN cambiaFechaSolucion()

    public boolean cambiaPrioridad(int _codigo, int _prioridad) {
        return model.cambiaPrioridad(_codigo, _prioridad);
    }//----------------------------------------------------------------------------- FIN cambiaPrioridad()

    public boolean redireccionarTicket(int _codigo, String _area) {
        return model.redireccionarTicket(_codigo, _area);
    }//----------------------------------------------------------------------------- FIN redireccionarTicket()

    public boolean asignarResponsable(int _codigo, String _responsable) {
        return model.asignarResponsable(_codigo, _responsable);
    }//----------------------------------------------------------------------------- FIN asignarResponsable()

    public boolean cambiaFechaRealSolucion(int _codigo, String _fecha) {
        return model.cambiaFechaRealSolucion(_codigo, _fecha);
    }//----------------------------------------------------------------------------- FIN cambiaFechaRealSolucion()

    public boolean ejecutarSentenciaSQL(int consecutivo, String usuario, String tabla, String accion) {
        return model.ejecutarSentenciaSQL(consecutivo, usuario, tabla, accion);
    }//----------------------------------------------------------------------------- FIN ejecutarSentenciaSQL()

    public int consultarConsecutivoTicket() {
        return model.consultarConsecutivoTicket();
    }//----------------------------------------------------------------------------- FIN consultarConsecutivoTicket()

    public int consultarConsecutivoBitacora() {
        return model.consultarConsecutivoBitacora();
    }//----------------------------------------------------------------------------- FIN consultarConsecutivoBitacora()

    public ArrayList<Bitacora> consultaBitacoraUsuario(String correo) {
        return model.consultaBitacoraUsuario(correo);
    }//----------------------------------------------------------------------------- FIN consultaBitacoraUsuario()

    public ArrayList<Bitacora> consultaBitacoraFechas(String fechaInicio, String fechaFinal) {
        return model.consultaBitacoraFechas(fechaInicio, fechaFinal);
    }//----------------------------------------------------------------------------- FIN consultaBitacoraFechas()

    public ArrayList<Bitacora> consultaBitacoraHoras(String horaInicio, String horaFinal) {
        return model.consultaBitacoraHoras(horaInicio, horaFinal);
    }//----------------------------------------------------------------------------- FIN consultaBitacoraHoras()

    public ArrayList<Bitacora> consultaBitacoraGeneral() {
        return model.consultaBitacoraGeneral();
    }//----------------------------------------------------------------------------- FIN consultaBitacoraGeneral()

    public boolean agregarArea(String nuevaArea) {
        return model.agregarArea(nuevaArea);
    }//----------------------------------------------------------------------------- FIN agregarArea()

    public ArrayList<String> getSysDateFromServer() {
        return model.getSysDateFromServer();
    }//----------------------------------------------------------------------------- FIN getSysDateFromServer()

    public boolean agregarAsunto(String nuevoAsunto) {
        return model.agregarAsunto(nuevoAsunto);
    }//----------------------------------------------------------------------------- FIN agregarAsunto()

    public boolean eliminarAsunto(String asunto) {
        return model.eliminarAsunto(asunto);
    }//----------------------------------------------------------------------------- FIN eliminarAsunto()

    public boolean eliminarArea(String area) {
        return model.eliminarArea(area);
    }//----------------------------------------------------------------------------- FIN eliminarArea()

    public boolean modificarAsunto(String area, String areaNueva) {
        return model.ModificarAsunto(area, areaNueva);
    }//----------------------------------------------------------------------------- FIN modificarAsunto()

    public boolean modificarArea(String area, String areaNueva) {
        return model.ModificarArea(area, areaNueva);
    }//----------------------------------------------------------------------------- FIN modificarArea()

    public ArrayList<Ticket> ticketsAlertaAdmin() {
        return model.ticketsAlertasAdmin();
    }//----------------------------------------------------------------------------- FIN ticketsAlertaAdmin()

    public int numeroAlerta() {
        return model.obtieneNumeroAlertas();
    }//----------------------------------------------------------------------------- FIN numeroAlerta()

    public ArrayList<String> consultaTodosReporteArea(String dato1) {
        return model.consultaReporteArea(dato1);
    }//------------------------------------------------------------------------------FIN consultaTodosReporteArea

    public ArrayList<String> consultaTodosReporteHoras(String dato1, String dato2) {
        return model.consultaReporteHoras(dato1, dato2);
    }//------------------------------------------------------------------------------FIN consultaTodosReporteHoras

    public ArrayList<String> consultaTodosReporteFecha(String dato1, String dato2) {
        return model.consultaReporteFecha(dato1, dato2);
    }//------------------------------------------------------------------------------FIN consultaTodosReporteFecha

    public ArrayList<String> consultaTodosReporteMiArea(String dato1, String _correo) {
        return model.consultaReportesMiArea(dato1, _correo);
    }//------------------------------------------------------------------------------FIN consultaTodosReporteMiArea

    public ArrayList<String> consultaReporteHorasArea(String dato1, String dato2, String _correo) {
        return model.consultaReporteHorasArea(dato1, dato2, _correo);
    }//------------------------------------------------------------------------------FIN consultaReporteHorasArea

    public ArrayList<String> consultaReporteFechaArea(String dato1, String dato2, String _correo) {
        return model.consultaReporteFechaArea(dato1, dato2, _correo);
    }//------------------------------------------------------------------------------FIN consultaReporteFechaArea

    //Declaracion de variables
    private static Controlador instancia = null;
    private Modelo model;
}
