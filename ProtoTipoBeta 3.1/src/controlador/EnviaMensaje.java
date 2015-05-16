package controlador;

import java.util.Properties;

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
        props.setProperty("mail.smtp.host", "smtp.live.com");
        // TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");
        // Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port", "587");

        props.setProperty("mail.smtp.user", "grupo08-sigeti@hotmail.com");

        props.setProperty("mail.smtp.auth", "true");

        props.setProperty("mail.smtp.mail.sender", "grupo08-sigeti@hotmail.com");
        //************************************************************
//        Session session = Session.getDefaultInstance(props);
//        //Verficiar el envio
//        session.setDebug(true);
//        MimeMessage  message = new MimeMessage(session);
//        try {
//            message.setSubject(subject);
//            message.setText(mensaje);
//            Address address = new InternetAddress((String) props.get("mail.smtp.mail.sender"));
//            message.setFrom(address);
//            Address address2 = new InternetAddress(correo,false);
//            message.addRecipient(Message.RecipientType.TO,address2);
//            Transport t = session.getTransport("smtp");
//        //************************************************************
//            t.connect("grupo08-sigeti@hotmail.com","grupo_ingenieria");
//        //************************************************************
//            t.sendMessage(message,message.getAllRecipients());
//            t.close();
//            rpta=true;
//        } catch (MessagingException ex) {
//            ex.printStackTrace();
//            return rpta;
//        }
        return rpta;
    }

}
