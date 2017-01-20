/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficialia;

import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author alan
 */
public class WaitDialog extends Thread{
    Frame frame;
    public JDialog dialog;
    public WaitDialog(Frame frame){
        super();
        this.frame= frame;
    }
    public void run(){
        dialog = new JDialog();
        JLabel gif = new JLabel();
        gif.setIcon(new ImageIcon(getClass().getResource("/resources/loading.gif")));
        dialog.setLayout(new FlowLayout());
        dialog.add(new JLabel("Porfavor espere..."));
        dialog.add(gif);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
            
}
