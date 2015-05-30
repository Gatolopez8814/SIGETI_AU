package modelo;

import com.mysql.jdbc.Connection;
import controlador.ConexionMySql;
import controlador.EnviaMensaje;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Modelo {

    public void EjecutaSQL() {
    }//----------------------------------------------------------------------------- FIN Constructor()

    public String recortaCorreo(String correUsuario) {
        return correUsuario.split("@")[0];
    }//----------------------------------------------------------------------------- FIN recortaCorreo()

    public boolean enviaCorreo(String mensaje, String asunto, String correoUsuario) {
        String correo = correoUsuario + "@castillo.cr";//cambiar por @castillo.cr
        return EnviaMensaje.obtenerInstancia().sendMessage(mensaje, asunto, correo);
    }//----------------------------------------------------------------------------- FIN enviaCorreo()

    public ArrayList<Integer> verificaLoggin(String correoUsuario, String contrasena) {
        ArrayList<Integer> valores = new ArrayList<>();
        valores.add(0);
        valores.add(-2);
        int tipo_usuario = 0;
        int estado = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select tipo, estado from usuario where correo = '" + correoUsuario + "' and contrasena = '" + contrasena + "'");
            if (resultado != null) {
            }
            while (resultado.next()) {
                tipo_usuario = resultado.getInt(1);
                estado = resultado.getInt(2);
                switch (estado) {
                    case 0:
                        valores.set(0, tipo_usuario);
                        valores.set(1, 0);
                        break;
                    case 1:
                        valores.set(0, tipo_usuario);
                        valores.set(1, 1);
                        break;
                    case 2:
                        valores.set(0, tipo_usuario);
                        valores.set(1, -1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
//            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return valores;
    }//----------------------------------------------------------------------------- FIN verificaLoggin()   

    public boolean verificarContrasenna(String correo, String contrasenaUsuario) {
        boolean ok = false;
        String contrasenna = "";
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select contrasena from usuario where correo = '" + correo + "' and contrasena = '" + contrasenaUsuario + "'");
            if (resultado != null) {
            }
            while (resultado.next()) {
                contrasenna = resultado.getString(1);
                if (contrasenna.equals(contrasenaUsuario)) {
                    ok = true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
//            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return ok;
    }//----------------------------------------------------------------------------- FIN verificarContrasenna()   

    public boolean registraUsuarioAdmin(Usuario _usuario, String contrasenna) {
        //este metodo permite al administrador ingresar un nuevo usuario a la base de datos
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("insert into usuario values(" + "'" + _usuario.getCorreo() + "', '"
                    + _usuario.getTipoUsuario() + "', '" + contrasenna + "'" + "," + _usuario.getEstado() + ")") == 1) {
                return true;
            }
        } catch (Exception e) {
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN registraUsuarioAdmin()

    public boolean ModificaUsuarioAdmin(Usuario _usuario) {
        //este metodo permite al administrador ingresar un nuevo usuario a la base de datos
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update usuario set tipo= '" + _usuario.getEstado() + "' where correo= '" + _usuario.getCorreo() + "' and contrasena= '" + _usuario.getContraseña() + "'") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
//            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN registraUsuarioAdmin()

    public int obtieneEstadoUsuario(String correoUsuario) {
        int estado = -1;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select estado from usuario where correo = '" + correoUsuario + "'");
            if (resultado != null) {
            }
            while (resultado.next()) {
                estado = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
//            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return estado;
    }//----------------------------------------------------------------------------- FIN obtieneEstadoUsuario()

    public boolean cambiaARegistrado(String correoUsuario, int nuevoTipo) {
        //este metodo permite al administrador registrar un usuario que ha sido eliminado
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement(); //FALTA VALIDAR NO ELIMINAR USUARIO ACTIVO
            if (sentencia.executeUpdate("update usuario set estado=1, tipo=" + nuevoTipo + " where correo='" + correoUsuario + "' and estado=2") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN cambiaARegistrado()

    public boolean eliminaUsuarioAdmin(String correoUsuario) {
        //este metodo permite al administrador eliminar un usuario de la base de datos
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement(); //FALTA VALIDAR NO ELIMINAR USUARIO ACTIVO
            if (sentencia.executeUpdate("update usuario set estado= 2 where correo='" + correoUsuario + "'") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN eliminaUsuarioAdmin()

    public boolean bloqueaUsuarioAdmin(String correoUsuario) {
        //este metodo permite al administrador bloquear un usuario de la base de datos
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update usuario set estado=0 where correo=" + "'" + correoUsuario + "'") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN bloqueaUsuarioAdmin()

    public boolean desBloqueaUsuarioAdmin(String correoUsuario) {
        //este metodo permite al administrador bloquear un usuario de la base de datos
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update usuario set estado=1 where correo=" + "'" + correoUsuario + "'") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN desBloqueaUsuarioAdmin()

    public boolean validaContrasenna(String contrasenna) {
        if (contrasenna.length() >= 6 && contrasenna.length() <= 16) {
            return true;
        }
        return false;
    }//----------------------------------------------------------------------------- FIN validaContrasenna()

    public boolean registraNuevoTicket(Ticket _ticket) {
        //este metodo permite a los usuarios ingresar un nuevo ticket a la base de datos
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("insert into ticket values(" + _ticket.getConsecutivo() + "," + "'"
                    + _ticket.getCorreoUsuario() + "'" + "," + _ticket.getPrioridad() + "," + _ticket.getEstado() + "," + "'"
                    + _ticket.getDetalleProblema() + "'" + "," + "'" + _ticket.getAreaDestino() + "'" + "," + "'"
                    + _ticket.getComentarios() + "'" + "," + "'" + _ticket.getTiempoSolucion() + "'" + "," + "'"
                    + _ticket.getResponsable() + "'" + "," + "'" + _ticket.getAsunto() + "'" + "," + "'"
                    + _ticket.getTiempoRealSolucion() + "'" + "," + _ticket.getFecha() + "," + _ticket.getHora() + "," + "'"
                    + _ticket.getEspecificacion() + "'" + ")") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN registraNuevoTicket()

    public Ticket consultaUno(int _codigo, String _correo) {
        //Este metodo es para consultar un ticket segun el codigo y segun el usuario actual de la sesion
        Ticket _ticket = new Ticket();
        try {
            String responsable, areaDestino, asunto, estado2, detalle, comentarios;
            Date hora, fechaCreacion;
            int estado;
            ResultSet resultado = null;
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select responsable, areaDestino, consecEstado, asunto, hora, fechaCreacion, detalleProblema, comentarios from ticket where correoUsuario = '" + _correo + "' and consecutivoticket =" + _codigo);

            while (resultado.next()) {
                responsable = resultado.getString(1);
                areaDestino = resultado.getString(2);
                estado = resultado.getInt(3);
                asunto = resultado.getString(4);
                hora = resultado.getTime(5);
                fechaCreacion = resultado.getDate(6);
                detalle = resultado.getString(7);
                comentarios = resultado.getString(8);
                estado2 = this.consultaEstado(estado);
                _ticket.setResponsable(responsable);
                _ticket.setAreaDestino(areaDestino);
                _ticket.setEstado(estado2);
                _ticket.setAsunto(asunto);
                _ticket.setFecha(String.valueOf(fechaCreacion));
                _ticket.setHora(String.valueOf(hora));
                _ticket.setDetalleProblema(detalle);
                _ticket.setComentarios(comentarios);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return _ticket;
    }//----------------------------------------------------------------------------- FIN consultaUno()

    public Ticket consultaUltimo(String _correo) {
        //Este metodo es para consultar el ultimo ticket segun el codigo y segun el usuario actual de la sesion
        Ticket _ticket = null;
        int codigo;
        String responsable, areaDestino, asunto, detalle, comentarios, estado;
        Date hora, fechaCreacion;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call consultaUltimo(?)}");
            cStmt.setString(1, _correo);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();

            while (resultado.next()) {
                codigo = resultado.getInt(1);
                responsable = resultado.getString(2);
                areaDestino = resultado.getString(3);
                asunto = resultado.getString(4);
                estado = resultado.getString(5);
                hora = resultado.getTime(6);
                fechaCreacion = resultado.getDate(7);
                detalle = resultado.getString(8);
                comentarios = resultado.getString(9);

                _ticket = new Ticket();
                _ticket.setConsecutivo(codigo);
                _ticket.setResponsable(responsable);
                _ticket.setAreaDestino(areaDestino);
                _ticket.setAsunto(asunto);
                _ticket.setEstado(estado);
                _ticket.setHora(String.valueOf(hora));
                _ticket.setFecha(String.valueOf(fechaCreacion));
                _ticket.setDetalleProblema(detalle);
                _ticket.setComentarios(comentarios);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return _ticket;
    }//----------------------------------------------------------------------------- FIN consultaUltimo()

    public ArrayList<Ticket> consultaTodosTicket(String dato1, String dato2, String _correo) {
        //Este metodo es para consultar un ticket segun un rango de fechas o un área específica 
        //y segun el usuario actual de la sesion
        return (dato2.equals("")) ? consultaTicketsArea(dato1, _correo) : consultaTicketsfecha(dato1, dato2, _correo);
        //Si el usuario solicitó una busqueda de área el dato2 vendrá vacío y el sistema ejecuta la busqueda de ticket por area
    }//----------------------------------------------------------------------------- FIN consultaTodosTicket()

    private ArrayList<Ticket> consultaTicketsfecha(String dato1, String dato2, String _correo) {

        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String areaDestino, responsable, estado;
        Date fechaCreacion;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call consultaTicketsfecha(?, ?, ?)}");
            cStmt.setString(1, dato1);
            cStmt.setString(2, dato2);
            cStmt.setString(3, _correo);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                areaDestino = resultado.getString(1);
                fechaCreacion = resultado.getDate(2);
                idtick = resultado.getInt(3);
                estado = resultado.getString(4);
                responsable = resultado.getString(5);
                _ticket.setConsecutivo(idtick);
                _ticket.setAreaDestino(areaDestino);
                _ticket.setFecha(String.valueOf(fechaCreacion));
                _ticket.setEstado(estado);
                _ticket.setResponsable(responsable);
                tEncontrados.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }

    private ArrayList<Ticket> consultaTicketsArea(String area, String _correo) {

        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String areaDestino, estado, responsable;
        Date fechaCreacion;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call consultaTicketsArea(?, ?)}");
            cStmt.setString(1, area);
            cStmt.setString(2, _correo);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                areaDestino = resultado.getString(1);
                fechaCreacion = resultado.getDate(2);
                idtick = resultado.getInt(3);
                responsable = resultado.getString(4);
                estado = resultado.getString(5);
                _ticket.setAreaDestino(areaDestino);
                _ticket.setFecha(String.valueOf(fechaCreacion));
                _ticket.setConsecutivo(idtick);
                _ticket.setResponsable(responsable);
                _ticket.setEstado(estado);
                tEncontrados.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//---------------------------------------------------------------------------------------FIN ConsultaAreaTickets

    public String consultaEstado(int estado) {
        String _estado = "";
        try {
            ResultSet resultado = null;
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select descripcion from estadoTicket where consecutivoEstado =" + estado);
            while (resultado.next()) {
                _estado = resultado.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return _estado;
    }//----------------------------------------------------------------------------- FIN consultaEstado()

    public boolean cambioEstadoLeido(int _codigo) {
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update ticket set consecEstado=2, tiempoRealsolucion='No asignado' where consecutivoticket=" + _codigo + "") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN cambioEstadoLeido()

    public Ticket informacionTicket(int _codigo) {
        String detalleProblema, correoUsuario, areaDestino, comentarios, tiempoSolucion, responsable, asunto,
                tiempoRealsolucion, especificacion, descripcion;
        int consecutivoticket, consecutivoPriori, consecEstado;
        Date fechaCreacion, hora;
        Ticket datos = null;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call informacionTicket(?)}");
            cStmt.setInt(1, _codigo);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                consecutivoticket = resultado.getInt(1);
                correoUsuario = resultado.getString(2);
                consecutivoPriori = resultado.getInt(3);
                consecEstado = resultado.getInt(4);
                detalleProblema = resultado.getString(5);
                areaDestino = resultado.getString(6);
                comentarios = resultado.getString(7);
                tiempoSolucion = resultado.getString(8);
                responsable = resultado.getString(9);
                asunto = resultado.getString(10);
                tiempoRealsolucion = resultado.getString(11);
                fechaCreacion = resultado.getDate(12);
                hora = resultado.getTime(13);
                especificacion = resultado.getString(14);
                descripcion = resultado.getString(15);
                datos = new Ticket(detalleProblema, descripcion, comentarios, correoUsuario, areaDestino,
                        tiempoSolucion, responsable, tiempoRealsolucion, asunto, String.valueOf(hora),
                        consecutivoPriori, consecutivoticket, String.valueOf(fechaCreacion), especificacion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return datos;
    }//----------------------------------------------------------------------------- FIN informacionTicket()

    public boolean cambiarContrasena(String _correo, String _contNueva, String _contAnterior) {
        //este metodo es para cambiar la contraseña de un usuario
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update usuario set contrasena= '" + _contNueva + "' where correo= '" + _correo + "' and contrasena= '" + _contAnterior + "'") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN cambioContrasenna()

    public ArrayList<Ticket> ticketsDelArea(String _correoUsuario) {
        //este metodo es para que el usuario de area pueda consultar todos los tickets de su area
        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String responsable, creador, estado;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsDelArea(?)}");
            cStmt.setString(1, _correoUsuario);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                idtick = resultado.getInt(1);
                creador = resultado.getString(2);
                responsable = resultado.getString(3);
                estado = resultado.getString(4);
                _ticket.setEstado(estado);
                _ticket.setCorreoUsuario(creador);
                _ticket.setResponsable(responsable);
                _ticket.setConsecutivo(idtick);
                tEncontrados.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN ticketsDelArea()

    public ArrayList<String> obtieneAreas() {
        //este metodo es para que el usuario de area pueda consultar todos los tickets de su area
        ArrayList<String> tEncontrados = new ArrayList<>();
        String nombre;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select nombreArea from area order by nombreArea");
            if (resultado != null) {
            }
            while (resultado.next()) {
                nombre = resultado.getString(1);
                tEncontrados.add(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN obtieneAreas()

    public ArrayList<String> obtieneUsuarios(String usuarioActual, int estado) {
        ArrayList<String> tEncontrados = new ArrayList<>();
        String correo;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select correo from usuario where estado=" + estado + " and correo not like '" + usuarioActual + "' order by correo");
            if (resultado != null) {
            }
            while (resultado.next()) {
                correo = resultado.getString(1);
                tEncontrados.add(correo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN obtieneUsuarios()

    public ArrayList<String> obtieneUsuariosEliminar(String usuarioActual, int estado) {
        ArrayList<String> tEncontrados = new ArrayList<>();
        String correo;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select correo from usuario where estado not like " + estado + " and correo not like '" + usuarioActual + "' order by correo");
            if (resultado != null) {
            }
            while (resultado.next()) {
                correo = resultado.getString(1);
                tEncontrados.add(correo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN obtieneUsuariosEliminar()

    public ArrayList<String> obtieneTodosUsuarios() {
        ArrayList<String> usuarios = new ArrayList<>();
        String correo;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select correo from usuario where estado = 1 and tipo not like 3 order by correo");
            if (resultado != null) {
            }
            while (resultado.next()) {
                correo = resultado.getString(1);
                usuarios.add(correo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return usuarios;
    }//----------------------------------------------------------------------------- FIN obtieneTodosUsuarios()

    public ArrayList<String> obtieneUsuariosGeneral() {
        ArrayList<String> usuarios = new ArrayList<>();
        String correo;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select correo from usuario where estado = 1 order by correo");
            if (resultado != null) {
            }
            while (resultado.next()) {
                correo = resultado.getString(1);
                usuarios.add(correo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return usuarios;
    }//----------------------------------------------------------------------------- FIN obtieneUsuariosGeneral()

    public String obtieneNombreArea(String _correoUsuario) {
        //retorna el nombre del area a la que pertenece un usuario de area
        String area = "";
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select nombArea from areausuario where correousuario='" + _correoUsuario + "'");
            if (resultado != null) {
            }
            while (resultado.next()) {
                area = resultado.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return area;
    }//----------------------------------------------------------------------------- FIN obtieneNombreArea()

    public ArrayList<String> obtieneUsuariosPorArea(String _area) {
        //metodo usado para asignar un responsable a un ticket de su respectiva area
        ArrayList<String> usuarios = new ArrayList<>();
        String correo;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select correo from usuario, areausuario where areausuario.correousuario=usuario.correo and areausuario.nombArea='" + _area + "' and usuario.estado=1");
            if (resultado != null) {
            }
            while (resultado.next()) {
                correo = resultado.getString(1);
                usuarios.add(correo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return usuarios;
    }//----------------------------------------------------------------------------- FIN obtieneUsuariosPorArea()

    public ArrayList<String> obtieneAsuntos() {
        //este metodo es para que el usuario de area pueda consultar todos los tickets de su area
        ArrayList<String> tEncontrados = new ArrayList<>();
        String nombre;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select asunto from asuntos order by asunto");
            if (resultado != null) {
            }
            while (resultado.next()) {
                nombre = resultado.getString(1);
                tEncontrados.add(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN obtieneAsuntos()

    public ArrayList<Ticket> ticketsEnProcesoArea(String _correoUsuario) {
        //este metodo es para que el usuario de area pueda consultar todos los tickets en proceso de su area
        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, estado;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsEnProcesoArea(?)}");
            cStmt.setString(1, _correoUsuario);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                idtick = resultado.getInt(1);
                asunto = resultado.getString(2);
                responsable = resultado.getString(3);
                estado = resultado.getString(4);
                _ticket.setEstado(estado);
                _ticket.setAsunto(asunto);
                _ticket.setResponsable(responsable);
                _ticket.setConsecutivo(idtick);
                tEncontrados.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN tickets EnprocesoArea()

    public ArrayList<Ticket> ticketsEnProcesoAdmin() {
        //este metodo es para que el usuario administrador pueda consultar todos los tickets en proceso de su area
        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, fechaCreacion;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsEnProcesoAdmin()}");
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                idtick = resultado.getInt(1);
                asunto = resultado.getString(2);
                responsable = resultado.getString(3);
                fechaCreacion = resultado.getString(4);
                _ticket.setFecha(fechaCreacion);
                _ticket.setAsunto(asunto);
                _ticket.setResponsable(responsable);
                _ticket.setConsecutivo(idtick);
                tEncontrados.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN tickets En proceso Area

    public ArrayList<Ticket> ticketsDelAreaAsignados(String _correoUsuario) {
        //este metodo es para que el usuario de area pueda consultar todos los tickets de su area que han sido asignados
        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, estado;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsDelAreaAsignados(?)}");
            cStmt.setString(1, _correoUsuario);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                idtick = resultado.getInt(1);
                asunto = resultado.getString(2);
                responsable = resultado.getString(3);
                estado = resultado.getString(4);
                _ticket.setEstado(estado);
                _ticket.setAsunto(asunto);
                _ticket.setResponsable(responsable);
                _ticket.setConsecutivo(idtick);
                tEncontrados.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN ticketsDelAreaAsignados()

    public ArrayList<Ticket> ticketsAsignadosAdmin() {
        //este metodo es para que el usuario de area pueda consultar todos los tickets de su area que han sido asignados
        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, estado;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsAsignadosAdmin()}");
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                idtick = resultado.getInt(1);
                asunto = resultado.getString(2);
                responsable = resultado.getString(3);
                estado = resultado.getString(4);
                _ticket.setEstado(estado);
                _ticket.setAsunto(asunto);
                _ticket.setResponsable(responsable);
                _ticket.setConsecutivo(idtick);
                tEncontrados.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN ticketsDelAreaAsignados()

    public ArrayList<Ticket> ticketsBandejaEntradaArea(String _correoUsuario) {
        //este metodo es para que el usuario de area pueda consultar todos los tickets nuevos 
        ArrayList< Ticket> tBandeja = new ArrayList<>();
        Ticket _ticket;
        String creador, asunto, fechaCreacion;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsBandejaEntradaArea(?)}");
            cStmt.setString(1, _correoUsuario);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                idtick = resultado.getInt(1);
                asunto = resultado.getString(2);
                creador = resultado.getString(3);
                fechaCreacion = resultado.getString(4);
                _ticket.setFecha(fechaCreacion);
                _ticket.setAsunto(asunto);
                _ticket.setCorreoUsuario(creador);
                _ticket.setConsecutivo(idtick);
                tBandeja.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tBandeja;
    }//----------------------------------------------------------------------------- FIN ticketsBandejaEntradaArea()

    public ArrayList<Ticket> ticketsBandejaEntradaAdmin() {
        //este metodo es para que el usuario de area pueda consultar todos los tickets nuevos 
        ArrayList< Ticket> tBandeja = new ArrayList<>();
        Ticket _ticket;
        String creador, asunto, fechaCreacion;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsBandejaEntradaAdmin()}");
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                idtick = resultado.getInt(1);
                asunto = resultado.getString(2);
                creador = resultado.getString(3);
                fechaCreacion = resultado.getString(4);
                _ticket.setFecha(fechaCreacion);
                _ticket.setAsunto(asunto);
                _ticket.setCorreoUsuario(creador);
                _ticket.setConsecutivo(idtick);
                tBandeja.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tBandeja;
    }//----------------------------------------------------------------------------- FIN ticketsBandejaEntradaAdmin()

    public boolean cerrarTicket(int codigo) {
        //este metodo es para cerrar los tickets
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update ticket set consecEstado= '" + 3 + "' where consecutivoticket= '" + codigo + "' and consecEstado not like 1") == 1) {//se actualiza el fechaCreacion a 3, cuya descripcion es cerrado
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN cerrarTicket()

    public ArrayList<Ticket> ticketsCerradosArea(String _correoUsuario) {
        //este metodo es para que el usuario de area pueda consultar todos los tickets cerrados
        ArrayList< Ticket> tBandeja = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, estado;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsCerradosArea(?)}");
            cStmt.setString(1, _correoUsuario);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                idtick = resultado.getInt(1);
                asunto = resultado.getString(2);
                responsable = resultado.getString(3);
                estado = resultado.getString(4);
                _ticket.setEstado(estado);
                _ticket.setAsunto(asunto);
                _ticket.setResponsable(responsable);
                _ticket.setConsecutivo(idtick);
                tBandeja.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tBandeja;
    }//----------------------------------------------------------------------------- FIN ticketsCerradosArea()

    public ArrayList<Ticket> ticketsCerradosAdmin() {
        //este metodo es para que el usuario de area pueda consultar todos los tickets cerrados
        ArrayList< Ticket> tBandeja = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, areaDestino;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsCerradosAdmin()}");
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                idtick = resultado.getInt(1);
                asunto = resultado.getString(2);
                responsable = resultado.getString(3);
                areaDestino = resultado.getString(4);
                _ticket.setAreaDestino(areaDestino);
                _ticket.setAsunto(asunto);
                _ticket.setResponsable(responsable);
                _ticket.setConsecutivo(idtick);
                tBandeja.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tBandeja;
    }//----------------------------------------------------------------------------- FIN ticketsCerradosAdmin

    public boolean registraAreaUsuario(String _correo, String _area) {
        //este metodo permite al administrador ingresar un nuevo usuario de area a la base de datos
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("insert into areausuario values(" + "'" + _correo + "', '" + _area + "')") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN registraAreaUsuariomodificaAreaUsuario

    public boolean modificaAreaUsuario(String _correo, String _area) {
        //este metodo permite al administrador ingresar un nuevo usuario de area a la base de datos
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update areausuario set nombArea= '" + _area + "' where correo= '" + _correo + "'") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN registraAreaUsuariomodificaAreaUsuario

    public int cantidadTotalAdmin() {
        //este metodo es para obtener la tipo de tickets nuevos
        int cantidad = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select count(*) as total from ticket");
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadNuevosAdmin()

    public int cantidadNuevosAdmin() {
        //este metodo es para obtener la tipo de tickets nuevos
        int cantidad = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select count(*) as total from ticket where consecEstado=1");
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadTotalAdmin()

    public ArrayList<Ticket> ticketsTodosLosTickets() {
        //este metodo es para que el usuario de area pueda consultar todos los tickets 
        ArrayList< Ticket> tBandeja = new ArrayList<>();
        Ticket _ticket;
        String responsable, creador, fechaCreacion, estado;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsTodosLosTickets()}");
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _ticket = new Ticket();
                idtick = resultado.getInt(1);
                creador = resultado.getString(2);
                responsable = resultado.getString(3);
                fechaCreacion = resultado.getString(4);
                estado = resultado.getString(5);
                _ticket.setFecha(fechaCreacion);
                _ticket.setCorreoUsuario(creador);
                _ticket.setResponsable(responsable);
                _ticket.setConsecutivo(idtick);
                _ticket.setEstado(estado);
                tBandeja.add(_ticket);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tBandeja;
    }//----------------------------------------------------------------------------- FIN ticketsTodosLosTickets()

    public int cantidadAsignadosAdmin() {
        //este metodo es para obtener la tipo de tickets asignados para el usuario administrados
        int cantidad = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select count(*) from ticket where responsable not like 'No asignado'");
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadAsignadosAdmin()

    public int cantidadProcesoAdmin() {
        //este metodo es para obtener la tipo de tickets en proceso para el usuario administrados
        int cantidad = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select count(*) from ticket where consecEstado = 2");
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadProcesoAdmin()

    public int cantidadCerradosAdmin() {
        //este metodo es para obtener la tipo de tickets cerrados para el usuario administrados
        int cantidad = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select count(*) from ticket where consecEstado = 3");
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadCerradosAdmin()

    public int cantidadNuevosArea(String _correo) {
        //este metodo es para obtener la tipo de tickets nuevos
        int cantidad = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select count(*) as total from ticket where consecEstado=1 and areaDestino = "
                    + " (select nombArea from areausuario where correousuario = '" + _correo + "')");
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadNuevosArea()

    public int cantidadAsignadosArea(String _correo) {
        //este metodo es para obtener la tipo de tickets asignados
        int cantidad = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select count(*) as total from ticket tablaTickets "
                    + "where tablaTickets.areaDestino = (select nombArea from areausuario where correousuario = '" + _correo + "') "
                    + "and tablaTickets.responsable not like 'No asignado'");
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadAsignadosArea()

    public int cantidadProcesoArea(String _correo) {
        //este metodo es para obtener la tipo de tickets en proceso
        int cantidad = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select count(*) as total from ticket tablaTickets "
                    + "where tablaTickets.areaDestino = (select nombArea from areausuario where correousuario = '" + _correo + "') "
                    + "and tablaTickets.consecEstado = 2");
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadProcesoArea()

    public int cantidadCerradosArea(String _correo) {
        //este metodo es para obtener la tipo de tickets en proceso
        int cantidad = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select count(*) as total from ticket tablaTickets "
                    + "where tablaTickets.areaDestino = (select nombArea from areausuario where correousuario = '" + _correo + "') "
                    + "and tablaTickets.consecEstado = 3");
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadCerradosArea()

    public String obtieneComentarios(int codigo) {
        //este metodo es para obtener los comentarios de un ticket
        String cantidad = "";
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select comentarios from ticket where consecutivoticket =" + codigo);
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN obtieneComentarios()

    public int cantidadTotalArea(String _correo) {
        //este metodo es para obtener la tipo de tickets total del area
        int cantidad = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select count(*) as total from ticket tablaTickets "
                    + "where tablaTickets.areaDestino = (select nombArea from areausuario where correousuario = '" + _correo + "')");
            if (resultado != null) {
            }
            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadTotalArea()

    public boolean agregaComentario(int _codigo, String _comentario) {
        //este metodo es para agregar un comentario a un ticket
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update ticket set comentarios='" + _comentario + "'"
                    + " where consecutivoticket=" + _codigo + "") == 1) {//se actualiza el fechaCreacion a 3, cuya descripcion es cerrado
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN agregaComentario()

    public boolean cambiaFechaSolucion(int _codigo, String _fecha) {
        //este metodo es para agregar la fecha de solucion de un ticket
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update ticket set tiempoSolucion='" + _fecha + "'"
                    + " where consecutivoticket=" + _codigo + " and '" + _fecha + "' >=curdate()") == 1) {//se actualiza el fechaCreacion a 3, cuya descripcion es cerrado
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN cambiaFechaSolucion()

    public boolean cambiaPrioridad(int _codigo, int _prioridad) {
        //este metodo es para cambiar la prioriad de un ticket
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update ticket set consecutivoPriori=" + _prioridad
                    + " where consecutivoticket=" + _codigo) == 1) {//se actualiza el fechaCreacion a 3, cuya descripcion es cerrado
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN cambiaPrioridad()

    public boolean redireccionarTicket(int _codigo, String _area) {
        //este metodo es para redireccionar un ticket
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update ticket set areaDestino='" + _area + "', consecEstado=1 where consecutivoticket=" + _codigo
                    + " and areaDestino not like '" + _area + "'") == 1) {//se actualiza el fechaCreacion a 3, cuya descripcion es cerrado
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN redireccionarTicket()

    public boolean asignarResponsable(int _codigo, String _responsable) {
        //este metodo es para agregar un responsable a un ticket
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update ticket set responsable='" + _responsable + "' where consecutivoticket=" + _codigo) == 1) {//se actualiza el fechaCreacion a 3, cuya descripcion es cerrado
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN asignarResponsable()

    public boolean cambiaFechaRealSolucion(int _codigo, String _fecha) {
        //este metodo es para agregar la fecha real de solucion de un ticket
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("update ticket set tiempoRealsolucion='" + _fecha + "' where consecutivoticket=" + _codigo + " and consecEstado=3") == 1) {//se actualiza el fechaCreacion a 3, cuya descripcion es cerrado
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN cambiaFechaRealSolucion()

    public boolean ejecutarSentenciaSQL(int consecutivo, String usuario, String tabla, String accion) {
        //este metodo es para ejecutar las sentencias en la tabla bitacora 
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("insert into bitacora values(" + consecutivo + ", '" + usuario + "', "
                    + "curdate(), curtime(), '" + tabla + "', '" + accion + "')") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
//            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN ejecutarSentenciaSQL()

    public int consultarConsecutivoTicket() {
        //este metodo es para obtener el contador de la tabla de tickets
        ResultSet resultado = null;
        Statement sentencia = null;
        int contador = 0;
        try {
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery("select count(consecutivoticket) from ticket");
            while (resultado.next()) {
                contador = resultado.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return contador + 1;
    }//----------------------------------------------------------------------------- FIN consultarConsecutivoTicket()

    public int consultarConsecutivoBitacora() {
        //este metodo es para obtener el contador de la tabla de bitacoras
        ResultSet resultado = null;
        Statement sentencia = null;
        int contador = 0;
        try {
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery("select max(consecutivo) from bitacora");
            while (resultado.next()) {
                contador = resultado.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
//            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return contador + 1;
    }//----------------------------------------------------------------------------- FIN consultarConsecutivoBitacora()

    public ArrayList<Bitacora> consultaBitacoraUsuario(String correo) {
        //este metodo es para que el usuario administrador consulto la bitacora de un usuario 
        ArrayList< Bitacora> bitacora = new ArrayList<>();
        Bitacora _bitacora;
        String fecha, hora, tabla, accion;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call consultaBitacoraUsuario(?)}");
            cStmt.setString(1, correo);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _bitacora = new Bitacora();
                fecha = String.valueOf(resultado.getDate(1));
                hora = String.valueOf(resultado.getTime(2));
                tabla = resultado.getString(3);
                accion = resultado.getString(4);
                _bitacora.setUsuario(correo);
                _bitacora.setHora(hora);
                _bitacora.setFecha(fecha);
                _bitacora.setTabla(tabla);
                _bitacora.setAccion(accion);
                bitacora.add(_bitacora);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return bitacora;
    }//----------------------------------------------------------------------------- FIN consultaBitacoraUsuario()

    public ArrayList<Bitacora> consultaBitacoraFechas(String fechaInicio, String fechaFinal) {
        //este metodo es para que el usuario administrador consulto la bitacora de un rango de fechas 
        ArrayList< Bitacora> bitacora = new ArrayList<>();
        Bitacora _bitacora;
        String usuario, fecha, hora, tabla, accion;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call consultaBitacoraFechas(?, ?)}");
            cStmt.setString(1, fechaInicio);
            cStmt.setString(2, fechaFinal);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _bitacora = new Bitacora();
                usuario = resultado.getString(1);
                fecha = String.valueOf(resultado.getDate(2));
                hora = String.valueOf(resultado.getTime(3));
                tabla = resultado.getString(4);
                accion = resultado.getString(5);
                _bitacora.setUsuario(usuario);
                _bitacora.setHora(hora);
                _bitacora.setFecha(fecha);
                _bitacora.setTabla(tabla);
                _bitacora.setAccion(accion);
                bitacora.add(_bitacora);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return bitacora;
    }//----------------------------------------------------------------------------- FIN consultaBitacoraFechas()

    public ArrayList<Bitacora> consultaBitacoraHoras(String horaInicio, String horaFinal) {
        //este metodo es para que el usuario administrador consulto la bitacora de un rango de horas 
        ArrayList< Bitacora> bitacora = new ArrayList<>();
        Bitacora _bitacora;
        String usuario, fecha, hora, tabla, accion;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call consultaBitacoraHoras(?, ?)}");
            cStmt.setString(1, horaInicio);
            cStmt.setString(2, horaFinal);
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _bitacora = new Bitacora();
                usuario = resultado.getString(1);
                fecha = String.valueOf(resultado.getDate(2));
                hora = String.valueOf(resultado.getTime(3));
                tabla = resultado.getString(4);
                accion = resultado.getString(5);
                _bitacora.setUsuario(usuario);
                _bitacora.setHora(hora);
                _bitacora.setFecha(fecha);
                _bitacora.setTabla(tabla);
                _bitacora.setAccion(accion);
                bitacora.add(_bitacora);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return bitacora;
    }//----------------------------------------------------------------------------- FIN consultaBitacoraHoras()

    public boolean agregarArea(String nuevaArea) {
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("insert into area values('" + nuevaArea + "')") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN agregarArea()

    public boolean agregarAsunto(String nuevoAsunto) {
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("insert into asuntos values('" + nuevoAsunto + "')") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN agregarAsunto()

    public boolean eliminarAsunto(String asunto) {
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("delete from asuntos where(asunto = '" + asunto + "')") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN eliminarAsunto()

    public boolean eliminarArea(String area) {
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("delete from area where(nombreArea = '" + area + "')") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN eliminarArea()

    public boolean ModificarArea(String area, String nuevaArea) {
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("Update area set nombreArea = '"
                    + nuevaArea + "'where nombreArea = '" + area + "'") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN ModificarArea()

    public boolean ModificarAsunto(String asunto, String nuevoAsunto) {
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("Update asuntos set asunto = '"
                    + nuevoAsunto + "'where asunto = '" + asunto + "'") == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return false;
    }//----------------------------------------------------------------------------- FIN ModificarAsunto()

    public ArrayList<String> getSysDateFromServer() {
        ResultSet resultado = null;
        ArrayList<String> fecha = new ArrayList<>();
        String reloj, calendario;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select sysdate() ");
            while (resultado.next()) {
                calendario = String.valueOf(resultado.getString(1).split(" ")[0]);
                fecha.add(0, calendario.split("-")[0]);//año
                fecha.add(1, calendario.split("-")[1]);//mes
                fecha.add(2, calendario.split("-")[2]);//dia
                reloj = String.valueOf(resultado.getString(1).split(" ")[1]);
                fecha.add(3, reloj.split(":")[0]);//hora
                fecha.add(4, reloj.split(":")[1]);//minutos
                fecha.add(5, reloj.split(":")[2]);//segundos                  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return fecha;
    }//----------------------------------------------------------------------------- FIN getSysDateFromServer()

    public ArrayList<Bitacora> consultaBitacoraGeneral() {
        //este metodo es para que el usuario administrador consulto la bitacora total
        ArrayList< Bitacora> bitacora = new ArrayList<>();
        Bitacora _bitacora;
        String fecha, hora, tabla, accion, usuario;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call consultaBitacoraGeneral()}");
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                _bitacora = new Bitacora();
                fecha = String.valueOf(resultado.getDate(1));
                hora = String.valueOf(resultado.getTime(2));
                tabla = resultado.getString(3);
                accion = resultado.getString(4);
                usuario = resultado.getString(5);
                _bitacora.setHora(hora);
                _bitacora.setFecha(fecha);
                _bitacora.setTabla(tabla);
                _bitacora.setAccion(accion);
                _bitacora.setUsuario(usuario);
                bitacora.add(_bitacora);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return bitacora;
    }//----------------------------------------------------------------------------- FIN consultaBitacoraGeneral()

    public ArrayList<Ticket> ticketsAlertasAdmin() {
        //este metodo es para que el usuario de area pueda consultar todas las alertas        
        ArrayList< Ticket> tAlertas = new ArrayList<>();
        Ticket _ticket;
        String creador, asunto, fechaCreacion;
        int idtick;
        Connection conn = null;
        try {
            conn = ConexionMySql.obtenerInstancia().conectar();
            CallableStatement cStmt = conn.prepareCall("{call ticketsAlertasAdmin()}");
            cStmt.execute();
            final ResultSet resultado = cStmt.getResultSet();
            while (resultado.next()) {
                if (condicionAlertas(resultado.getInt(5), resultado.getString(6))) {
                    _ticket = new Ticket();
                    idtick = resultado.getInt(1);
                    asunto = resultado.getString(2);
                    creador = resultado.getString(3);
                    fechaCreacion = resultado.getString(4);
                    _ticket.setFecha(fechaCreacion);
                    _ticket.setAsunto(asunto);
                    _ticket.setCorreoUsuario(creador);
                    _ticket.setConsecutivo(idtick);
                    tAlertas.add(_ticket);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
//            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tAlertas;
    }//---------------------------------------------------------------------------------------FIN ticketsAlertasAdmin

    boolean condicionAlertas(int prioridad, String fecha) {
        if (!"No asignado".equals(fecha)) {
            int dif = difDias(fecha);
            if (prioridad == 1 && dif >= 1) {//alta
                return true;
            } else if (prioridad == 2 && dif >= 2) {//media
                return true;
            } else if (prioridad == 3 && dif >= 4) {//baja
                return true;
            }
        }
        return false;
    }//---------------------------------------------------------------------------------------FIN condicionAlertas

    int difDias(String fecha) {
        ArrayList<String> fechaActual = getSysDateFromServer();
        int diaActual = Integer.valueOf(fechaActual.get(2));
        int mesActual = Integer.valueOf(fechaActual.get(1));
        int anioActual = Integer.valueOf(fechaActual.get(0));
        int diaSolucion = Integer.valueOf(fecha.split("-")[2]);
        int mesSolucion = Integer.valueOf(fecha.split("-")[1]);
        int anioSolucion = Integer.valueOf(fecha.split("-")[0]);
        if (anioSolucion == anioActual) {
            if (mesSolucion == mesActual) {
                return diaActual - diaSolucion;
            } else {
                return ((mesActual - mesSolucion) * 30) + diaSolucion - diaActual;
            }
        } else if (mesSolucion == mesActual) {
            return diaActual - diaSolucion + ((anioActual - anioSolucion) * 366);
        } else {
            return ((mesSolucion - mesActual) * 30) + diaSolucion - diaActual + +((anioActual - anioSolucion) * 366);
        }
    }//---------------------------------------------------------------------------------------FIN difDias

    public int obtieneNumeroAlertas() {
        return ticketsAlertasAdmin().size();
    }//---------------------------------------------------------------------------------------FIN obtieneNumeroAlertas

    public ArrayList<String> consultaReporteArea(String area) {
        ArrayList< String> tEncontrados = new ArrayList<>();
        String estado;
        int cant;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select  (select descripcion from estadoTicket a where a.consecutivoEstado = ticket.consecEstado), count(0) from ticket "
                    + "where ticket.areaDestino = '" + area + "' "
                    + "group by  ticket.consecEstado;");
            if (resultado != null) {
            }
            while (resultado.next()) {
                estado = resultado.getString(1);
                cant = resultado.getInt(2);
                tEncontrados.add(estado);
                tEncontrados.add(String.valueOf(cant));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//---------------------------------------------------------------------------------------FIN consultaReporteArea

    public ArrayList<String> consultaReporteFecha(String fecha1, String fecha2) {
        ArrayList< String> tEncontrados = new ArrayList<>();
        String estado;
        int cant;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select  (select descripcion from estadoTicket a where a.consecutivoEstado = ticket.consecEstado), count(0) from ticket "
                    + "where ticket.fechaCreacion >= '" + fecha1 + " 00:00:00' and  ticket.fechaCreacion <= '" + fecha2 + " 23:59:59' "
                    + "group by  ticket.consecEstado;");
            if (resultado != null) {
            }
            while (resultado.next()) {
                estado = resultado.getString(1);
                cant = resultado.getInt(2);
                tEncontrados.add(estado);
                tEncontrados.add(String.valueOf(cant));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//---------------------------------------------------------------------------------------FIN consultaReporteFecha

    public ArrayList<String> consultaReporteHoras(String hora1, String hora2) {
        ArrayList< String> tEncontrados = new ArrayList<>();
        String estado;
        int cant;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select  (select descripcion from estadoTicket a where a.consecutivoEstado = ticket.consecEstado), count(0) from ticket "
                    + "where ticket.hora between '" + hora1 + "' and '" + hora2
                    + "' group by  ticket.consecEstado;");
            if (resultado != null) {
            }
            while (resultado.next()) {
                estado = resultado.getString(1);
                cant = resultado.getInt(2);
                tEncontrados.add(estado);
                tEncontrados.add(String.valueOf(cant));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//---------------------------------------------------------------------------------------FIN consultaReporteHoras

    public ArrayList<String> consultaReportesMiArea(String area, String _correo) {
        ArrayList< String> tEncontrados = new ArrayList<>();
        String estado;
        int cant;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select  (select descripcion from estadoTicket a "
                    + "where a.consecutivoEstado = ticket.consecEstado), count(0) from ticket "
                    + "where ticket.areaDestino = '" + area + "' "
                    + "group by  ticket.consecEstado;");
            if (resultado != null) {
            }
            while (resultado.next()) {
                estado = resultado.getString(1);
                cant = resultado.getInt(2);
                tEncontrados.add(estado);
                tEncontrados.add(String.valueOf(cant));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//---------------------------------------------------------------------------------------FIN consultaReportesMiArea

    public ArrayList<String> consultaReporteHorasArea(String hora1, String hora2, String _correo) {
        ArrayList< String> tEncontrados = new ArrayList<>();
        String estado;
        int cant;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select  (select descripcion from estadoTicket a "
                    + " where a.consecutivoEstado = ticket.consecEstado), count(0) from ticket "
                    + " where ticket.areaDestino = (select nombArea from areausuario where correousuario = '" + _correo + "') and ticket.hora between '" + hora1 + "' and '" + hora2
                    + "' group by ticket.consecEstado;");
            if (resultado != null) {
            }
            while (resultado.next()) {
                estado = resultado.getString(1);
                cant = resultado.getInt(2);
                tEncontrados.add(estado);
                tEncontrados.add(String.valueOf(cant));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//---------------------------------------------------------------------------------------FIN consultaReporteHorasArea

    public ArrayList<String> consultaReporteFechaArea(String fecha1, String fecha2, String _correo) {
        ArrayList< String> tEncontrados = new ArrayList<>();
        String estado;
        int cant;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select  (select descripcion from estadoTicket a "
                    + " where a.consecutivoEstado = ticket.consecEstado), count(0) from ticket "
                    + " where ticket.areaDestino = (select nombArea from areausuario where correousuario = '" + _correo + "') and ticket.fechaCreacion >= '" + fecha1 + " 00:00:00' and  ticket.fechaCreacion <= '" + fecha2 + " 23:59:59' "
                    + "group by  ticket.consecEstado;");
            if (resultado != null) {
            }
            while (resultado.next()) {
                estado = resultado.getString(1);
                cant = resultado.getInt(2);
                tEncontrados.add(estado);
                tEncontrados.add(String.valueOf(cant));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tEncontrados;
    }//---------------------------------------------------------------------------------------FIN consultaReporteFechaArea

    public int obtieneTipoUsuario(String _correo) {
        //este metodo es para obtener el tipo de usuario que es
        int tipo = 0;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select tipo from usuario where correo='" + _correo + "'");
            if (resultado != null) {
            }
            while (resultado.next()) {
                tipo = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo más tarde",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexionMySql.obtenerInstancia().desconectar();
        }
        return tipo;
    }

    public void abreManual(String _correo) {
        int tipo = this.obtieneTipoUsuario(_correo);
        switch (tipo) {
            case 1:
                try {
                    File path = new File("C:\\Users\\luis-mora\\Desktop\\manuales\\manual de usuario administrador.pdf");
                    Desktop.getDesktop().open(path);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abir el archivo \n"+" comuniquese con TI",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                try {
                    File path = new File("C:\\Users\\luis-mora\\Desktop\\manuales\\manual de usuario área.pdf");
                    Desktop.getDesktop().open(path);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abir el archivo \n"+" comuniquese con TI",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 3:
                try {
                    File path = new File("C:\\Users\\luis-mora\\Desktop\\manuales\\manual de usuario estandar.pdf");
                    Desktop.getDesktop().open(path);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abir el archivo \n"+" comuniquese con TI",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
    }
}
