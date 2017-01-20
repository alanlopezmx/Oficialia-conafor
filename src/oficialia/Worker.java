/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficialia;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.SwingWorker;

/**
 *
 * @author alan
 */
public class Worker extends SwingWorker<Boolean, Void> {

    final static int SEND_EMAIL = 0;
    final static int LOGIN = 1;
    final static int DB_PROCESS = 2;
    String email;
    String password;
    String host;
    String asunto;
    String htmlEmail;
    BufferedImage[] img;
    ArrayList<String> mails;
    int opcion;

    public void setDialog(WaitDialog dialog) {
        this.dialog = dialog;
    }
    WaitDialog dialog;

    public Worker(String email, String password, String host, int opcion) {
        this.email = email;
        this.password = password;
        this.host = host;
        this.opcion = opcion;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        boolean ret = true;
        System.out.println("Worker");
        switch (opcion) {
            case SEND_EMAIL:
                ret = sendMail();
                break;
            case LOGIN:
                Email tempLogin = new Email(email, password, host);
                if(!tempLogin.login)
                    ret = false;
                break;
            case DB_PROCESS:
                

        }
        System.out.println("Termino worker");
        dialog.setVisible(false);
        return ret;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setHtmlEmail(String htmlEmail) {
        this.htmlEmail = htmlEmail;
    }

    public void setImg(BufferedImage[] img) {
        this.img = img;
    }

    public void setMails(ArrayList<String> mails) {
        this.mails = mails;
    }
    

    private boolean sendMail() {
        Email tmpEmail = new Email(email, password, host);
        String[] mailArray = new String[mails.size()];
        mailArray = mails.toArray(mailArray);
        return tmpEmail.sendHtmlMail(mailArray, asunto, htmlEmail, img);
    }
}
