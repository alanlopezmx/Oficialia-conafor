/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficialia;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
 
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
 
 
public class ImageViewer extends JFrame implements ActionListener{
 
 private JPanel pOpciones;
 private JButton btnAumentar,btnDisminuir,btnReset;
 private File archivo;
 private CuadroImagen img;
 private JScrollPane scroll;
 private String imagenes[];
 private ArrayList<String> ListaImagenes;
 private String path;
 private int numImg;
  
  
 public ImageViewer(BufferedImage imgTemp){
  super("Visor de imagen");
  setSize(800,800);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  numImg = 0;
  img = new CuadroImagen();
  img.setImagen(imgTemp);
  scroll= new JScrollPane(img,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
  this.add(scroll,BorderLayout.CENTER);
  pOpciones = new JPanel();
  btnAumentar = new JButton("+");
  btnDisminuir = new JButton("-");
  btnReset = new JButton("Reiniciar");
  pOpciones.add(btnAumentar);
  pOpciones.add(btnDisminuir);
  pOpciones.add(btnReset);
  this.add(pOpciones,BorderLayout.SOUTH);
  //listeners
  btnAumentar.addActionListener(this);
  btnDisminuir.addActionListener(this);
  btnReset.addActionListener(this);
  setLocationRelativeTo(null);
  setVisible(true);
 }
  
 //metodo de ActionListener
  
 public void actionPerformed(ActionEvent e) {

  if(e.getSource()==btnAumentar){
   img.aumentar();
  }else if(e.getSource()==btnDisminuir){
   img.disminuir();
  }else if(e.getSource()==btnReset){
   img.reset();
  }
 }//funciones getter y setter
 
 public File getArchivo() {
  return archivo;
 }
 
 
 public void setArchivo(File archivo) {
  this.archivo = archivo;
 } 
  
 //Comprueba que solo cargue las imagenes
  
 public boolean esImagen(String dirImg){
  if(dirImg.lastIndexOf(".jpg")>0||dirImg.lastIndexOf(".png")>0||dirImg.lastIndexOf(".gif")>0||dirImg.lastIndexOf(".jpeg")>0){
   return true;
  }
  return false;
 }
  
}