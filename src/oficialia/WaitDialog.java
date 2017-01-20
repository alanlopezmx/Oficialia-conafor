/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficialia;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author alan
 */
public class WaitDialog extends JDialog{
    Frame frame;
    public WaitDialog(Frame frame){
        super(frame,true);
        this.frame= frame;
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        JLabel gif = new JLabel();
        gif.setIcon(new ImageIcon(getClass().getResource("/resources/loading.gif")));
        this.setLayout(new FlowLayout());
        this.add(new JLabel("Porfavor espere..."));
        this.add(gif);
        this.pack();
        this.setLocationRelativeTo(null);
    }
            
}
