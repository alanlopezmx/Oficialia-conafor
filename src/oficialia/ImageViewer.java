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
 private JButton btnAumentar,btnDisminuir,btnReset,btnAtras,btnSiguiente;
 private File archivo;
 private CuadroImagen img;
 private JScrollPane scroll;
 private String imagenes[];
 private ArrayList<String> ListaImagenes;
 private String path;
 private int numImg;
  
  
 public ImageViewer(BufferedImage... imgTemp){
  super("Visor de imagen");
  setSize(800,800);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  numImg = 0;
  img = new CuadroImagen();
  img.setBufferImagen(imgTemp);
  img.setImagen(0);
  scroll= new JScrollPane(img,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
  this.add(scroll,BorderLayout.CENTER);
  pOpciones = new JPanel();
  btnAumentar = new JButton("+");
  btnDisminuir = new JButton("-");
  btnAtras = new JButton("<-");
  btnSiguiente = new JButton("->");
  btnReset = new JButton("Reiniciar");
  pOpciones.add(btnDisminuir);
   pOpciones.add(btnAumentar);
  pOpciones.add(btnAtras);
  pOpciones.add(btnSiguiente);
  pOpciones.add(btnReset);
  this.add(pOpciones,BorderLayout.SOUTH);
  //listeners
  btnAumentar.addActionListener(this);
  btnDisminuir.addActionListener(this);
  btnReset.addActionListener(this);
  btnAtras.addActionListener(this);
  btnSiguiente.addActionListener(this);
  setLocationRelativeTo(null);
  if(imgTemp.length==1){
      btnAtras.setEnabled(false);
      btnSiguiente.setEnabled(false);
  }
  setVisible(true);
 }
  
 //metodo de ActionListener
  
 public void actionPerformed(ActionEvent e) {

  if(e.getSource()==btnAumentar){
   img.aumentar();
   btnDisminuir.setEnabled(true);
  }else if(e.getSource()==btnDisminuir){
      if(!img.disminuir()){
          btnDisminuir.setEnabled(false);
      }else{
          btnDisminuir.setEnabled(true);
      }
  }else if(e.getSource()==btnReset){
   img.reset();
  }else if(e.getSource()==btnAtras){
   img.prev();
  }else if(e.getSource()==btnSiguiente){
   img.next();
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