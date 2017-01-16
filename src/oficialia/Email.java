/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficialia;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Héctor Alan López Díaz <alanlopez1995@hotmail.com>
 */
public class Email {
    private String email;
    private String password;
    private String host;
    private int port;
    private Properties props = new Properties();
    private Session session;
    public boolean login;
    public Email(String email, String password, String host, int port){
        this.email = email;
        this.password = password;
        this.host = host;
        this.port = port;
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        this.login = login();
    }
    public Email(String email,String password, String host){
        this(email,password,host,587);
    }
    public Email(String email, String password){
        this(email,password,"smtp.gmail.com",587);
    }
    private boolean login(){
        session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email,password);
            }
        });
        Transport transport = null;
        try {
            transport = session.getTransport("smtp");
            transport.connect(host,email,password);
            transport.close();
        } catch (AuthenticationFailedException e) {
            System.out.println("Error al iniciar sesion");
            return false;
        } catch(MessagingException e){
            System.out.println("Cualquier otro error:" + e);
            return false;
        }
        System.out.println("Inicio correcto de sesion");
        return true;
    }
    public void sendMail(String to, String subject, String mail){
        try {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(mail);
            Transport.send(message);
            System.out.println("Tu mensaje ha sido enviado");
 
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void sendHtmlMail(String to, String subject, String mail){
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email,password);
                    }
                });
        try {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(mail,"text/html");
            Transport.send(message);
            System.out.println("Tu mensaje ha sido enviado");
 
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
