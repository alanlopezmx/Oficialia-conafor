/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficialia;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Héctor Alan López Díaz <alanlopez1995@hotmail.com>
 */
public class Administrador extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    String oficioId;
    String oficioAño;
    MySqlConn objConn;
    BufferedImage img[];
    String email, password, host;
    String htmlEmail;
    String fecha;
    ArrayList<String> mails;
    boolean atender = true;

    public Administrador(String email, String password, String host) {

        initComponents();
        getContentPane().setBackground(Color.WHITE);
        initOficio();
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                        if (atender) {
                            actualizaOficio();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
        this.email = email;
        this.password = password;
        this.host = host;
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        asunto = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        remitente = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        oficio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Asunto:");

        asunto.setEditable(false);
        asunto.setColumns(20);
        asunto.setRows(5);
        jScrollPane1.setViewportView(asunto);

        jLabel2.setText("Remitente:");

        remitente.setEditable(false);
        remitente.setColumns(20);
        remitente.setRows(5);
        jScrollPane2.setViewportView(remitente);

        jLabel3.setText("Área:");

        jCheckBox1.setText("Dpto. Administrativo");

        jCheckBox2.setText("Dpto. de Análisis, Seguimiento y Control.");

        jCheckBox3.setText("Dpto. Jurídico");

        observaciones.setColumns(20);
        observaciones.setRows(5);
        observaciones.setToolTipText("Observaciones");
        jScrollPane3.setViewportView(observaciones);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver Oficio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        oficio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                oficioItemStateChanged(evt);
            }
        });
        oficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oficioActionPerformed(evt);
            }
        });

        jLabel4.setText("Oficio:");

        jLabel5.setText("-Subgerencia Operativa.");

        jCheckBox4.setText("Subgerente Operativo");

        jCheckBox5.setText("Dpto. Restauración");

        jCheckBox6.setText("Dpto. Producción");

        jCheckBox7.setText("Dpto. Proteccion");

        jLabel6.setText("Observaciones:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(53, 53, 53)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jCheckBox2)
                            .add(jCheckBox1)
                            .add(jCheckBox3)
                            .add(jLabel5)
                            .add(jCheckBox4)
                            .add(jCheckBox5)
                            .add(jCheckBox6)
                            .add(jCheckBox7))
                        .add(292, 292, 292))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 633, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel2)
                                        .add(jLabel1)
                                        .add(jLabel4))
                                    .add(18, 18, 18)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                        .add(jScrollPane2)
                                        .add(oficio, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .add(18, 18, 18)
                                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 193, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jLabel6))
                        .add(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(oficio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(13, 13, 13)
                        .add(jLabel1))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(27, 27, 27)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jCheckBox1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBox2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBox3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBox4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBox5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBox6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBox7)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 15, Short.MAX_VALUE)
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton1)
                .add(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (oficio.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "No tiene oficios pendiendes!",
                    "Error.",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            new ImageViewer(img);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void initOficio() {
        MySqlConn objConn = new MySqlConn();
        String consulta = "select * from oficio where atendido=0;";
        objConn.Consult(consulta);
        int n = 0;
        if (objConn.rs != null) {
            try {
                objConn.rs.last();
                n = objConn.rs.getRow();
                objConn.rs.first();
            } catch (Exception e) {
            }
        }
        oficio.removeAllItems();
        for (int i = 0; i < n; i++) {
            try {
                oficio.addItem(objConn.rs.getString(1) + "-" + objConn.rs.getInt(6));
                objConn.rs.next();
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (oficio.getItemCount() > 0) {
            oficio.setSelectedIndex(0);
        }
        objConn.desConnect();
    }
    private void oficioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_oficioItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            try {
                oficioId = oficio.getSelectedItem().toString().split("-")[0];
                oficioAño = oficio.getSelectedItem().toString().split("-")[1];
                objConn = new MySqlConn();
                String consulta = "select * from oficio where oficio_id=" + oficioId + ";";
                objConn.Consult(consulta);
                asunto.setText(objConn.rs.getString(2));
                remitente.setText(objConn.rs.getString(3));
                fecha = objConn.rs.getString(5);
                consulta = "select imagen from imagen where oficio_oficio_id=" + oficioId + " and oficio_anio=" + oficioAño + ";";
                objConn.Consult(consulta);
                int n = 0;
                if (objConn.rs != null) {
                    try {
                        objConn.rs.last();
                        n = objConn.rs.getRow();
                        objConn.rs.first();
                    } catch (Exception e) {
                    }
                }
                img = new BufferedImage[n];
                for (int i = 0; i < n; i++) {
                    Blob blob = objConn.rs.getBlob(1);
                    byte[] data = blob.getBytes(1, (int) blob.length());
                    try {
                        img[i] = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    objConn.rs.next();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                objConn.desConnect();
            }
        }
    }//GEN-LAST:event_oficioItemStateChanged

    private void actualizaOficio() {
        MySqlConn objConn = new MySqlConn();
        int numeroOficios = oficio.getItemCount();
        String consulta = "select * from oficio where atendido=0;";
        objConn.Consult(consulta);
        int n = 0;
        if (objConn.rs != null) {
            try {
                objConn.rs.last();
                n = objConn.rs.getRow();
                objConn.rs.first();
            } catch (Exception e) {
            }
        }
        if (n != numeroOficios) {
            try {
                for (int i = 0; i < n; i++) {
                    if (i >= numeroOficios) {
                        oficio.addItem(objConn.rs.getString(1) + "-" + objConn.rs.getInt(6));
                    }
                    objConn.rs.next();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this,
                    "Nuevo Oficio Pendiente.",
                    "Nuevo Oficio",
                    JOptionPane.INFORMATION_MESSAGE);

        }
        objConn.desConnect();
    }

    private void oficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oficioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oficioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (todoCorrecto()) {
            mails = new ArrayList();
            htmlEmail = "<img src=http://voluntariosblp.com.mx/sites/default/files/CONAFOR.jpg width=400><h2>GERENCIA ESTATAL EN AGUASCALIENTES</h2>"
                    + "<p><strong>FECHA:</strong> " + fecha + " <strong>TURNO:</strong>" + oficioId + "<br /> <strong>ASUNTO:</strong>" + asunto.getText() + "<br /> <strong>Remitente:</strong>" + remitente.getText() + "<br /> <strong>Area:</strong></p>"
                    + "<ul>";
            if (jCheckBox1.isSelected()) {
                mails.add(getMail("ADMINISTRATIVO"));
                htmlEmail += "<li>Departamento Administrativo.</li>";
            }
            if (jCheckBox2.isSelected()) {
                mails.add(getMail("ANALISIS"));
                htmlEmail += "<li>Departamento de Analisis, Seguimiento y Control.</li>";
            }
            if (jCheckBox3.isSelected()) {
                mails.add(getMail("JURIDICO"));
                htmlEmail += "<li>Departamento Juridico.</li>";
            }
            if (jCheckBox4.isSelected()) {
                mails.add(getMail("OPERATIVO"));
                htmlEmail += "<li>Subgerencia Operativa.</li>";
            }
            if (jCheckBox5.isSelected()) {
                mails.add(getMail("RESTAURACION"));
                htmlEmail += "<li>Departamento de Restauracion.</li>";
            }
            if (jCheckBox6.isSelected()) {
                mails.add(getMail("PRODUCCION"));
                htmlEmail += "<li>Departamento de Produccion</li>";
            }
            if (jCheckBox7.isSelected()) {
                mails.add(getMail("PROTECCION"));
                htmlEmail += "<li>Departamento de Proteccion de Incendios.</li>";
            }
            String obs = observaciones.getText();
            obs = obs.replaceAll("(\r\n|\n)", "<br />");
            htmlEmail += "</ul>"
                    + "<p><strong>Observaciones:</strong></p>"
                    + "<p>" + obs + "</p>";
            boolean enviado = false;
            Worker worker = new Worker(email, password, host, Worker.SEND_EMAIL);
            worker.setAsunto(asunto.getText());
            WaitDialog dialog = new WaitDialog(this);
            worker.setDialog(dialog);
            worker.setHtmlEmail(htmlEmail);
            worker.setMails(mails);
            worker.setImg(img);
            worker.execute();
            dialog.setVisible(true);
            try {
                enviado = worker.get();
            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (enviado) {
                MySqlConn objConn = new MySqlConn();
                String consulta = "update oficio set atendido=1 where oficio_id=" + oficioId + " and anio=" + oficioAño + ";";
                atender = false;
                objConn.Update(consulta);
                oficio.removeItemAt(oficio.getSelectedIndex());
                initOficio();
                atender = true;
                limpiarCampos();
                JOptionPane.showMessageDialog(this,
                        "Email enviado exitosamente.",
                        "Exito",
                        JOptionPane.INFORMATION_MESSAGE);
                if (jCheckBox1.isSelected()) {
                    insertTrabajador_oficio("ADMINISTRATIVO");
                }
                if (jCheckBox2.isSelected()) {
                    insertTrabajador_oficio("ANALISIS");
                }
                if (jCheckBox3.isSelected()) {
                    insertTrabajador_oficio("JURIDICO");
                }
                if (jCheckBox4.isSelected()) {
                    insertTrabajador_oficio("OPERATIVO");
                }
                if (jCheckBox5.isSelected()) {
                    insertTrabajador_oficio("RESTAURACION");
                }
                if (jCheckBox6.isSelected()) {
                    insertTrabajador_oficio("PRODUCCION");
                }
                if (jCheckBox7.isSelected()) {
                    insertTrabajador_oficio("PROTECCION");
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Ocurrio un error al enviar el email, revise su conexion a internet",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else if (oficio.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "No tiene oficios pendiendes!",
                    "Error.",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Faltan campos por rellenar!",
                    "Error.",
                    JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void limpiarCampos() {
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        observaciones.setText("");
        asunto.setText("");
        remitente.setText("");
    }

    private String getMail(String depto) {
        String consulta = "select correo,usuario_id from trabajador where departamento='" + depto + "';";
        String mail = "";
        MySqlConn objConn = new MySqlConn();
        objConn.Consult(consulta);
        if (objConn.rs != null) {
            try {
                mail = objConn.rs.getString(1);
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        objConn.desConnect();
        return mail;
    }

    private void insertTrabajador_oficio(String depto) {
        String consulta = "select correo,usuario_id from trabajador where departamento='" + depto + "';";
        String mail = "";
        String userId = "";
        MySqlConn objConn = new MySqlConn();
        objConn.Consult(consulta);
        if (objConn.rs != null) {
            try {
                mail = objConn.rs.getString(1);
                userId = objConn.rs.getString(2);
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        consulta = "insert into trabajador_oficio values(" + userId + "," + oficioId + "," + oficioAño + ");";
        objConn.Update(consulta);
        objConn.desConnect();
    }

    private boolean todoCorrecto() {
        boolean checked = false;
        if (jCheckBox1.isSelected()) {
            checked = true;
        }
        if (jCheckBox2.isSelected()) {
            checked = true;
        }
        if (jCheckBox3.isSelected()) {
            checked = true;
        }
        if (jCheckBox4.isSelected()) {
            checked = true;
        }
        if (jCheckBox5.isSelected()) {
            checked = true;
        }
        if (jCheckBox6.isSelected()) {
            checked = true;
        }
        if (jCheckBox7.isSelected()) {
            checked = true;
        }
        if (observaciones.getText().trim().isEmpty() || !checked) {
            return false;
        }
        if (oficio.getItemCount() == 0) {
            return false;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea asunto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea observaciones;
    private javax.swing.JComboBox<String> oficio;
    private javax.swing.JTextArea remitente;
    // End of variables declaration//GEN-END:variables
}
