package controlador;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviaMensaje {

    private static EnviaMensaje instancia = null;

    public static EnviaMensaje obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new EnviaMensaje();
        }
        return instancia;
    }//-----------------------------------------------------END_obtenerInstancia

    public boolean sendMessage(String mensaje, String subject, String correo) {
        boolean rpta = false;
        Properties props = new Properties();
        // Nombre del host de correo, es smtp.gmail.com
        props.setProperty("mail.smtp.host", "190.7.204.43");
        // TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");//190.7.204.43   25 para salida y 110 para entrada

        props.setProperty("mail.smtp.user", "sigeti@castillo.cr");

        props.setProperty("mail.smtp.auth", "true");

        props.setProperty("mail.smtp.mail.sender", "sigeti@castillo.cr");
        //************************************************************
        Session session = Session.getDefaultInstance(props);
        //Verficiar el envio
        session.setDebug(true);
        MimeMessage  message = new MimeMessage(session);
        try {
            message.setSubject(subject);
            message.setText(mensaje);
            Address address = new InternetAddress((String) props.get("mail.smtp.mail.sender"));
            message.setFrom(address);
            Address address2 = new InternetAddress(correo,false);
            message.addRecipient(Message.RecipientType.TO,address2);
            Transport t = session.getTransport("smtp");
        //************************************************************
            t.connect("sigeti@castillo.cr","casio2015");
        //************************************************************
            t.sendMessage(message,message.getAllRecipients());
            t.close();
            rpta=true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            return rpta;
        }
        return rpta;
    }

}
