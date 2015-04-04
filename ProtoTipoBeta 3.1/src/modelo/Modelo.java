package modelo;

//Prueba por karen JAJAJA

import controlador.ConexionMySql;
import controlador.EnviaMensaje;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Modelo {

    public void EjecutaSQL() {
    }//----------------------------------------------------------------------------- FIN Constructor()

    public String recortaCorreo(String correUsuario) {//obtiene los datos antes del @
        String correoFinal = "";
        for (int i = 0; i + 1 <= correUsuario.length() && !correUsuario.substring(i, i + 1).equals("@"); i++) {
            correoFinal = correoFinal + correUsuario.substring(i, i + 1);
        }
        return correoFinal;
    }//----------------------------------------------------------------------------- FIN recortaCorreo()

    public boolean enviaCorreo(String mensaje, String asunto, String correoUsuario) {
        //envia el correo al usuario despues de crear un ticket
        String correo = correoUsuario + "@gmail.com";//cambiar por @castillo.cr
        return EnviaMensaje.obtenerInstancia().sendMessage(mensaje, asunto, correo);
    }//----------------------------------------------------------------------------- FIN enviaCorreo()

    public ArrayList<Integer> verificaLoggin(String correoUsuario, String contrasena) {
        ArrayList<Integer> valores = new ArrayList<>();
        valores.add(0);//1,2,3
        valores.add(-2);//0,1,2
//        String correo = this.recortaCorreo(correoUsuario) + "@castillo.cr";
        System.err.println("correo: "+correoUsuario+" cont: "+contrasena);
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
                        valores.set(1, 0);//bloqueado
                        break;
                    case 1:
                        valores.set(0, tipo_usuario);
                        valores.set(1, 1);//normal
                        break;
                    case 2:
                        valores.set(0, tipo_usuario);
                        valores.set(1, -1);//eliminado
                }
            }
        } catch (Exception e) {
            System.out.println("Error Exception from Modelo -> verificaLoggin()");
            e.printStackTrace();
        }finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion desde el metodo verificaLoggin()");
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
            System.out.println("Error Exception from Modelo -> verificarContrasenna()");
            //e.printStackTrace();
        }finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return ok;
    }//----------------------------------------------------------------------------- FIN verificarContrasenna()   

    public boolean registraUsuarioAdmin(Usuario _usuario) {
        //este metodo permite al administrador ingresar un nuevo usuario a la base de datos
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("insert into usuario values(" + "'" + _usuario.getCorreo() + "'" + ","
                    + "'" + _usuario.getTipoUsuario() + "'" + "," + "'" + _usuario.getContraseña() + "'" + "," + _usuario.getEstado() + ")") == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error Exception from Modelo -> registraUsuarioAdmin()");
            //e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> ModificaUsuarioAdmin()");
            //e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> obtieneEstadoUsuario()");
            //e.printStackTrace();
        }
        return estado;
    }//----------------------------------------------------------------------------- FIN obtieneEstadoUsuario()

    public boolean cambiaARegistrado(String correoUsuario) {
        //este metodo permite al administrador registrar un usuario que ha sido eliminado
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement(); //FALTA VALIDAR NO ELIMINAR USUARIO ACTIVO
            if (sentencia.executeUpdate("update usuario set estado= 1 where correo='" + correoUsuario + "' and estado=2") == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error Exception from Modelo -> cambiaARegistrado()");
            //e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> eliminaUsuarioAdmin()");
            //e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> bloqueaUsuarioAdmin()");
//            e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> desBloqueaUsuarioAdmin()");
//            e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }//----------------------------------------------------------------------------- FIN desBloqueaUsuarioAdmin()

    public boolean validaContraseña(String contraseña) {
        if (contraseña.length() >= 6 && contraseña.length() <= 16) {
            return true;
        }
        return false;
    }//----------------------------------------------------------------------------- FIN validaContraseña()

    public boolean registraNuevoTicket(Ticket _ticket) {
        //este metodo permite a los usuarios ingresar un nuevo ticket a la base de datos
        try {
            System.err.println(_ticket.toString());
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            System.err.println("entroo");
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
            System.out.println("Error Exception from Modelo -> registraNuevoTicket()");
            //e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            Statement sentencia2 = null;
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
            System.out.println("Error Exception from Modelo -> consultaUno()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return _ticket;
    }//----------------------------------------------------------------------------- FIN consultaUno()

    public Ticket consultaUltimo(String _correo) {
        //Este metodo es para consultar el ultimo ticket segun el codigo y segun el usuario actual de la sesion
        Ticket _ticket = new Ticket();
        int codigo;
        String responsable, areaDestino, asunto, detalle, comentarios, estado;
        Date hora, fechaCreacion;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.responsable, tablaTickets.areaDestino, tablaTickets.asunto, tablaEstado.descripcion, "
                    + " tablaTickets.hora, tablaTickets.fechaCreacion, tablaTickets.detalleProblema, tablaTickets.comentarios "
                    + " from ticket tablaTickets, estadoTicket tablaEstado "
                    + " where fechaCreacion =  (select max(fechaCreacion) from ticket where correoUsuario='" + _correo + "') "
                    + " and tablaEstado.consecutivoEstado = tablaTickets.consecEstado");
            if (resultado != null) {
            }
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
            System.out.println("Error Exception from Modelo -> consultaUno()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
        System.out.println("consultando por fechas");
        Date fechaCreacion;
        int idtick;
        ResultSet resultado = null;

        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select tablaTickets.areaDestino, tablaTickets.fechaCreacion, tablaTickets.consecutivoticket, tablaEstado.descripcion, tablaTickets.responsable "
                    + " from ticket tablaTickets, estadoTicket tablaEstado where correoUsuario = '" + _correo + "'"
                    + " and tablaEstado.consecutivoEstado = tablaTickets.consecEstado "
                    + " and fechaCreacion >= " + "'" + dato1 + " 00:00:00'"
                    + " and fechaCreacion <=" + "'" + dato2 + " 23:59:59' order by consecutivoticket");
            if (resultado != null) {
                System.out.println("Si encontró algo");
            }
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
//              
            }
        } catch (Exception e) {
            System.out.println("Error Exception from Modelo -> consultaTicketsfecha()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return tEncontrados;
    }

    private ArrayList<Ticket> consultaTicketsArea(String area, String _correo) {

        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String areaDestino, estado, responsable;
        Date fechaCreacion;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select tablaTickets.areaDestino, tablaTickets.fechaCreacion, tablaTickets.consecutivoticket, "
                    + "tablaTickets.responsable, tablaEstado.descripcion "
                    + "from ticket tablaTickets, estadoTicket tablaEstado "
                    + "where correoUsuario = '" + _correo + "' and areaDestino = '" + area + "' "
                    + "and tablaEstado.consecutivoEstado = tablaTickets.consecEstado \n"
                    + "order by consecutivoticket");
            if (resultado != null) {
            }
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
            System.out.println("Error Exception from Modelo -> consultaTicketsArea()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> consultaUno()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> cambiaEstadoLeido()");
//            e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }//----------------------------------------------------------------------------- FIN cambioEstadoLeido()

    public Ticket informacionTicket(int _codigo) {
        String detalleProblema, correoUsuario, areaDestino, comentarios, tiempoSolucion, responsable, asunto,
                tiempoRealsolucion, especificacion, descripcion;
        int consecutivoticket, consecutivoPriori, consecEstado;
        Date fechaCreacion, hora;
        Ticket datos = null;
        try {
            ResultSet resultado = null;
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select tablaTickets.*, tablaEstado.descripcion from ticket tablaTickets, estadoTicket tablaEstado where consecutivoticket = " + _codigo + " and tablaEstado.consecutivoEstado = tablaTickets.consecEstado");
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
            System.out.println("Error Exception from Modelo -> informacionAdicionalTicket()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> cambioContrasenna()");
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }//----------------------------------------------------------------------------- FIN cambioContrasenna()

    public ArrayList<Ticket> ticketsDelArea(String _correoUsuario) {
        //este metodo es para que el usuario de area pueda consultar todos los tickets de su area
        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String responsable, creador, estado;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.correoUsuario, tablaTickets.responsable, tablaEstado.descripcion  "
                    + "from ticket tablaTickets, estadoTicket tablaEstado where tablaTickets.areaDestino = (select nombArea from areausuario where correousuario = '" + _correoUsuario + "') "
                    + "and tablaEstado.consecutivoEstado = tablaTickets.consecEstado order by consecutivoticket");
            if (resultado != null) {
            }
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
            System.out.println("Error Exception from Modelo -> ticketsDelArea()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN obtieneAreas()

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
            System.out.println("Error Exception from Modelo -> obtieneAreas()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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

            resultado = sentencia.executeQuery("select correo from usuario where estado="+estado+" and correo not like '"+usuarioActual+"' order by correo");
            if (resultado != null) {
            }
            while (resultado.next()) {
                correo = resultado.getString(1);
                tEncontrados.add(correo);
            }
        } catch (Exception e) {
            System.out.println("Error Exception from Modelo -> obtieneUsuarios()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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

            resultado = sentencia.executeQuery("select correo from usuario where estado not like "+estado+" and correo not like '"+usuarioActual+"' order by correo");
            if (resultado != null) {
            }
            while (resultado.next()) {
                correo = resultado.getString(1);
                tEncontrados.add(correo);
            }
        } catch (Exception e) {
            System.out.println("Error Exception from Modelo -> obtieneUsuariosEliminar()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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

            resultado = sentencia.executeQuery("select correo from usuario where estado = 1 order by correo");
            if (resultado != null) {
            }
            while (resultado.next()) {
                correo = resultado.getString(1);
                usuarios.add(correo);
            }
        } catch (Exception e) {
            System.out.println("Error Exception from Modelo -> obtieneTodosUsuarios()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return usuarios;
    }//----------------------------------------------------------------------------- FIN obtieneTodosUsuarios()

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
            System.out.println("Error Exception from Modelo -> obtieneAsuntos()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN obtieneAsuntos()

    public ArrayList<Ticket> ticketsEnProcesoArea(String _correoUsuario) {
        //este metodo es para que el usuario de area pueda consultar todos los tickets en proceso de su area
        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, estado;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.asunto, tablaTickets.responsable, "
                    + "tablaEstado.descripcion from ticket tablaTickets, estadoTicket tablaEstado where tablaTickets.consecEstado = 2 "
                    + "and tablaEstado.consecutivoEstado = 2"); //El numero 2 corresponde al fechaCreacion de "Visto" en la bd
            if (resultado != null) {
                System.out.println("Encontró tickets vistos(en proceso)");
            }
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
            System.out.println("Error Exception from Modelo -> ticketsEnProcesoArea()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN tickets EnprocesoArea()

    public ArrayList<Ticket> ticketsEnProcesoAdmin() {
        //este metodo es para que el usuario administrador pueda consultar todos los tickets en proceso de su area
        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, fechaCreacion;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.asunto, tablaTickets.responsable, "
                    + "tablaTickets.fechaCreacion from ticket tablaTickets, estadoTicket tablaEstado where tablaTickets.consecEstado = 2 "
                    + "and tablaEstado.consecutivoEstado = 2 "); //El numero 2 corresponde al fechaCreacion de "Visto" en la bd
            if (resultado != null) {
                System.out.println("Encontró tickets vistos(en proceso)");
            }
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
            System.out.println("Error Exception from Modelo -> ticketsEnProcesoArea()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN tickets En proceso Area

    public ArrayList<Ticket> ticketsDelAreaAsignados(String _correoUsuario) {
        //este metodo es para que el usuario de area pueda consultar todos los tickets de su area que han sido asignados
        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, estado;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.asunto, tablaTickets.responsable, tablaEstado.descripcion "
                    + " from ticket tablaTickets, estadoTicket tablaEstado "
                    + " where tablaTickets.areaDestino = (select nombArea from areausuario where correousuario = '" + _correoUsuario + "') "
                    + " and tablaEstado.consecutivoEstado = tablaTickets.consecEstado and tablaTickets.responsable not like 'No asignado' "
                    + " and tablaEstado.descripcion not like 'no leido'");//si no ha sido visto, por obvio no tiene responsable
            if (resultado != null) {
            }
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
            System.out.println("Error Exception from Modelo -> ticketsDelAreaAsignados()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN ticketsDelAreaAsignados()

    public ArrayList<Ticket> ticketsAsignadosAdmin() {
        //este metodo es para que el usuario de area pueda consultar todos los tickets de su area que han sido asignados
        ArrayList< Ticket> tEncontrados = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, estado;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.asunto, tablaTickets.responsable, tablaEstado.descripcion "
                    + " from ticket tablaTickets, estadoTicket tablaEstado "
                    + " where tablaEstado.consecutivoEstado = tablaTickets.consecEstado and tablaTickets.responsable not like 'No asignado' "
                    + " and tablaEstado.descripcion not like 'no leido'");//si no ha sido visto, por obvio no tiene responsable
            if (resultado != null) {
            }
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
            System.out.println("Error Exception from Modelo -> ticketsDelAreaAsignados()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return tEncontrados;
    }//----------------------------------------------------------------------------- FIN ticketsDelAreaAsignados()

    public ArrayList<Ticket> ticketsBandejaEntradaArea(String _correoUsuario) {
        //este metodo es para que el usuario de area pueda consultar todos los tickets nuevos 
        ArrayList< Ticket> tBandeja = new ArrayList<>();
        Ticket _ticket;
        String creador, asunto, fechaCreacion;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.asunto, tablaTickets.correoUsuario, tablaTickets.fechaCreacion "
                    + "from ticket tablaTickets, estadoTicket tablaEstado "
                    + "where tablaTickets.areaDestino = (select nombArea from areausuario where correousuario = '" + _correoUsuario + "')"
                    + "and tablaEstado.consecutivoEstado = tablaTickets.consecEstado and tablaEstado.descripcion like 'no leido'");
            if (resultado != null) {
            }
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
            System.out.println("Error Exception from Modelo -> ticketsBandejaEntrada()");
            e.printStackTrace();
        }
        return tBandeja;
    }//----------------------------------------------------------------------------- FIN ticketsBandejaEntradaArea()

    public ArrayList<Ticket> ticketsBandejaEntradaAdmin() {
        //este metodo es para que el usuario de area pueda consultar todos los tickets nuevos 
        ArrayList< Ticket> tBandeja = new ArrayList<>();
        Ticket _ticket;
        String creador, asunto, fechaCreacion;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.asunto, tablaTickets.correoUsuario, tablaTickets.fechaCreacion "
                    + "from ticket tablaTickets, estadoTicket tablaEstado "
                    + "where tablaEstado.consecutivoEstado = tablaTickets.consecEstado and tablaEstado.descripcion like 'no leido'");
            if (resultado != null) {
            }
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
            System.out.println("Error Exception from Modelo -> ticketsBandejaEntradaAdmin()");
            e.printStackTrace();
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
            System.out.println("Error Exception from Modelo -> cerrarTicket()");
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }//----------------------------------------------------------------------------- FIN cerrarTicket()

    public ArrayList<Ticket> ticketsCerradosArea(String _correoUsuario) {
        //este metodo es para que el usuario de area pueda consultar todos los tickets cerrados
        ArrayList< Ticket> tBandeja = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, estado;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.asunto, tablaTickets.responsable, tablaEstado.descripcion "
                    + " from ticket tablaTickets, estadoTicket tablaEstado "
                    + " where tablaTickets.areaDestino = (select nombArea from areausuario where correousuario = '" + _correoUsuario + "') "
                    + " and tablaEstado.consecutivoEstado = tablaTickets.consecEstado and tablaEstado.descripcion like 'borrado'");
            if (resultado != null) {
            }
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
            System.out.println("Error Exception from Modelo -> ticketsCerradosArea()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return tBandeja;
    }//----------------------------------------------------------------------------- FIN ticketsCerradosArea()

    public ArrayList<Ticket> ticketsCerradosAdmin() {
        //este metodo es para que el usuario de area pueda consultar todos los tickets cerrados
        ArrayList< Ticket> tBandeja = new ArrayList<>();
        Ticket _ticket;
        String responsable, asunto, areaDestino;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.asunto, tablaTickets.responsable, tablaTickets.areaDestino "
                    + " from ticket tablaTickets, estadoTicket tablaEstado "
                    + " where tablaEstado.consecutivoEstado = tablaTickets.consecEstado and tablaEstado.descripcion like 'borrado'");
            if (resultado != null) {
            }
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
            System.out.println("Error Exception from Modelo -> ticketsCerradosAdmin()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> registraAreaUsuario()");
            //e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> registraAreaUsuario()");
            //e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }//----------------------------------------------------------------------------- FIN registraAreaUsuariomodificaAreaUsuario

    public int cantidadTotalAdmin() {
        //este metodo es para obtener la cantidad de tickets nuevos
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
            System.out.println("Error Exception from Modelo -> cantidadNuevosAdmin()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadNuevosAdmin()

    public int cantidadNuevosAdmin() {
        //este metodo es para obtener la cantidad de tickets nuevos
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
            System.out.println("Error Exception from Modelo -> cantidadTotalAdmin()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadTotalAdmin()

    public ArrayList<Ticket> ticketsTodosLosTickets() {
        //este metodo es para que el usuario de area pueda consultar todos los tickets 
        ArrayList< Ticket> tBandeja = new ArrayList<>();
        Ticket _ticket;
        String responsable, creador, fechaCreacion, estado;
        int idtick;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select tablaTickets.consecutivoticket, tablaTickets.correoUsuario, tablaTickets.responsable, tablaTickets.fechaCreacion, tablaEstado.descripcion "
                    + "from ticket tablaTickets, estadoTicket tablaEstado "
                    + "where tablaTickets.consecEstado = tablaEstado.consecutivoEstado order by tablaTickets.consecutivoticket");

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
            System.out.println("Error Exception from Modelo -> ticketsTodosLosTickets()");
            e.printStackTrace();
        }
        return tBandeja;
    }//----------------------------------------------------------------------------- FIN ticketsTodosLosTickets()

    public int cantidadAsignadosAdmin() {
        //este metodo es para obtener la cantidad de tickets asignados para el usuario administrados
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
            System.out.println("Error Exception from Modelo -> cantidadAsignadosAdmin()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadAsignadosAdmin()

    public int cantidadProcesoAdmin() {
        //este metodo es para obtener la cantidad de tickets en proceso para el usuario administrados
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
            System.out.println("Error Exception from Modelo -> cantidadProcesoAdmin()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadProcesoAdmin()

    public int cantidadCerradosAdmin() {
        //este metodo es para obtener la cantidad de tickets cerrados para el usuario administrados
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
            System.out.println("Error Exception from Modelo -> cantidadCerradosAdmin()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadCerradosAdmin()

    //A PARTIR DE AQUI COMIENZA LO DE JONATHAN
    public int cantidadNuevosArea(String _correo) {
        //este metodo es para obtener la cantidad de tickets nuevos
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
            System.out.println("Error Exception from Modelo -> cantidadNuevosArea()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadNuevosArea()

    public int cantidadAsignadosArea(String _correo) {
        //este metodo es para obtener la cantidad de tickets asignados
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
            System.out.println("Error Exception from Modelo -> cantidadAsignadosArea()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadAsignadosArea()

    public int cantidadProcesoArea(String _correo) {
        //este metodo es para obtener la cantidad de tickets en proceso
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
            System.out.println("Error Exception from Modelo -> cantidadProcesoArea()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN cantidadProcesoArea()

    public int cantidadCerradosArea(String _correo) {
        //este metodo es para obtener la cantidad de tickets en proceso
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
            System.out.println("Error Exception from Modelo -> cantidadCerradosArea()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> obtieneComentarios()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return cantidad;
    }//----------------------------------------------------------------------------- FIN obtieneComentarios()

    public int cantidadTotalArea(String _correo) {
        //este metodo es para obtener la cantidad de tickets total del area
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
            System.out.println("Error Exception from Modelo -> cantidadTotalArea()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> agregaComentario()");
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> cambiaFechaSolucion()");
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> cambiaPrioridad()");
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> redireccionarTicket()");
            e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> asignarResponsable()");
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> cambiaFechaRealSolucion()");
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> ejecutarSentenciaSQL()");
            e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> consultarConsecutivoTicket()");
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            System.out.println("Error Exception from Modelo -> cambiaFechaRealSolucion()");
            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return contador + 1;
    }//----------------------------------------------------------------------------- FIN consultarConsecutivo()

    public ArrayList<Bitacora> consultaBitacoraUsuario(String correo) {
        //este metodo es para que el usuario administrador consulto la bitacora de un usuario 
        ArrayList< Bitacora> bitacora = new ArrayList<>();
        Bitacora _bitacora;
        String fecha, hora, tabla, accion;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select fecha, hora, tabla, accion from bitacora "
                    + "where usuario = '" + correo + "'");

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
            System.out.println("Error Exception from Modelo -> consultaBitacoraUsuario()");
//            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return bitacora;
    }//----------------------------------------------------------------------------- FIN consultaBitacoraUsuario()

    public ArrayList<Bitacora> consultaBitacoraFechas(String fechaInicio, String fechaFinal) {
        //este metodo es para que el usuario administrador consulto la bitacora de un rango de fechas 
        ArrayList< Bitacora> bitacora = new ArrayList<>();
        Bitacora _bitacora;
        String usuario, fecha, hora, tabla, accion;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select usuario, fecha, hora, tabla, accion from bitacora "
                    + "where fecha between '" + fechaInicio + "' and '" + fechaFinal + "' order by fecha");

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
            System.out.println("Error Exception from Modelo -> consultaBitacoraFechas()");
//            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return bitacora;
    }//----------------------------------------------------------------------------- FIN consultaBitacoraFechas()

    public ArrayList<Bitacora> consultaBitacoraHoras(String horaInicio, String horaFinal) {
        //este metodo es para que el usuario administrador consulto la bitacora de un rango de horas 
        ArrayList< Bitacora> bitacora = new ArrayList<>();
        Bitacora _bitacora;
        String usuario, fecha, hora, tabla, accion;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select usuario, fecha, hora, tabla, accion from bitacora "
                    + "where hora between '" + horaInicio + "' and '" + horaFinal + "' order by hora");

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
            System.out.println("Error Exception from Modelo -> consultaBitacoraHoras()");
//            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
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
            //e.printStackTrace();
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }
    /*
     DELETE FROM `sigeti`.`area`
     WHERE <{where_expression}>;
     */

    public boolean agregarAsunto(String nuevoAsunto) {
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("insert into asuntos values('" + nuevoAsunto + "')") == 1) {
                return true;
            }
        } catch (Exception e) {
            //e.printStackTrace
            System.err.println("kk");
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }

    public boolean eliminarAsunto(String asunto) {
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("delete from asuntos where(asunto = '" + asunto + "')") == 1) {
                return true;
            }
        } catch (Exception e) {
            //e.printStackTrace
            System.err.println("kk");
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }

    public boolean eliminarArea(String area) {
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();
            if (sentencia.executeUpdate("delete from area where(nombreArea = '" + area + "')") == 1) {
                return true;
            }
        } catch (Exception e) {
            //e.printStackTrace
            System.err.println("kk");
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }
    public boolean ModificarArea(String area,String nuevaArea) {
         try {            
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();            
            if (sentencia.executeUpdate("Update area set nombreArea = '" 
                    + nuevaArea+ "'where nombreArea = '"+area+"'") == 1) {
                return true;              
            }
        } catch (Exception e) {            
            //e.printStackTrace             
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }
    public boolean ModificarAsunto(String asunto,String nuevoAsunto) {
         try {            
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();            
            if (sentencia.executeUpdate("Update asuntos set asunto = '" 
                    + nuevoAsunto+ "'where asunto = '"+asunto+"'") == 1) {
                return true;              
            }
        } catch (Exception e) {            
            //e.printStackTrace             
            return false;
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return false;
    }

    public void obtieneAlertas() {
    
    }

    public ArrayList<Bitacora> consultaBitacoraGeneral() {
        //este metodo es para que el usuario administrador consulto la bitacora total
        ArrayList< Bitacora> bitacora = new ArrayList<>();
        Bitacora _bitacora;
        String fecha, hora, tabla, accion, usuario;
        ResultSet resultado = null;
        try {
            Statement sentencia = null;
            sentencia = ConexionMySql.obtenerInstancia().conectar().createStatement();

            resultado = sentencia.executeQuery("select fecha, hora, tabla, accion, usuario from bitacora ");

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
            System.out.println("Error Exception from Modelo -> consultaBitacoraGeneral()");
//            e.printStackTrace();
        } finally {
            ConexionMySql.obtenerInstancia().desconectar();
            System.out.println("Se ha cerrado la conexion");
        }
        return bitacora;
    }

}
