import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Bienvenida extends JFrame implements ActionListener{

  private JTextField textfield1;
  private JLabel label1, label2, label3, label4;
  private JButton boton1;

  public Bienvenida(){
    setLayout(null);
    setTitle("Bienvenido");
    getContentPane().setBackground(new Color(0,0,0)); // Fondo negro
    setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
   
    ImageIcon imagen = new ImageIcon(getClass().getResource("/images/logo.png"));
    label1 = new JLabel(imagen);
    label1.setBounds(25,28,300,130);
    add(label1);

    label2 = new JLabel("Sistema de Control Vacacional");
    label2.setBounds(35,150,300,30);
    label2.setFont(new Font("Arial", Font.BOLD, 19)); // Fuente moderna
    label2.setForeground(new Color(255,255,255)); // Texto en blanco
    add(label2);

    label3 = new JLabel("Ingrese su nombre");
    label3.setBounds(45,212,200,30);
    label3.setFont(new Font("Arial", Font.PLAIN, 15)); // Fuente sencilla
    label3.setForeground(new Color(255,255,255)); // Texto en blanco
    add(label3);

    label4 = new JLabel("© 2024 Off-White™.");
    label4.setBounds(113,375,300,30);
    label4.setFont(new Font("Arial", Font.PLAIN, 13)); // Fuente sencilla
    label4.setForeground(new Color(255,255,255)); // Texto en blanco
    add(label4);
    
    textfield1 = new JTextField ();
    textfield1.setBounds(45,240,255,25);
    textfield1.setBackground(new Color(224,224,224)); // Fondo gris claro
    textfield1.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente sencilla
    textfield1.setForeground(new Color(0,0,0)); // Texto negro
    add(textfield1);
    
    boton1 = new JButton("Ingresar");
    boton1.setBounds(125,280,100,30);
    boton1.setBackground(new Color(255,255,255)); // Fondo blanco
    boton1.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente sencilla
    boton1.setForeground(new Color(0,0,0)); // Texto negro
    boton1.addActionListener(this);
    add(boton1);
  }

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == boton1){
      String nombre = textfield1.getText().trim();
      if(!nombre.equals("")) {
        // Pasa el nombre a la clase Licencia
        Licencia ventanalicencia = new Licencia(nombre);
        ventanalicencia.setBounds(0,0,600,360);
        ventanalicencia.setVisible(true);
        ventanalicencia.setResizable(false);
        ventanalicencia.setLocationRelativeTo(null);
        this.dispose(); // Cierra la ventana actual (Bienvenida)
      } else {
        // Si no se ingresó un nombre, muestra un mensaje de error
        JOptionPane.showMessageDialog(this, "Por favor, ingrese su nombre.");
      }
    }
  }

  public static void main(String args[]){
    Bienvenida ventanabienvenida = new Bienvenida();
    ventanabienvenida.setBounds(0,0,350,450);
    ventanabienvenida.setVisible(true);
    ventanabienvenida.setResizable(false);
    ventanabienvenida.setLocationRelativeTo(null);
  }
}
