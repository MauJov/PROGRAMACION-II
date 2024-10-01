import javax.swing.*; 
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Licencia extends JFrame implements ActionListener, ChangeListener{

  private JLabel label1, label2, labelUsuario;
  private JCheckBox check1;
  private JButton boton1, boton2;
  private JScrollPane scrollpane1; 
  private JTextArea textarea1;

  private String nombreUsuario;

  public Licencia(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario; // Captura el nombre
    setLayout(null);
    setTitle("Términos y Condiciones - Off-White™");
    setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

    label1 = new JLabel("TÉRMINOS Y CONDICIONES");
    label1.setBounds(215,5,250,30);
    label1.setFont(new Font("Andale Mono", 1, 14));
    label1.setForeground(new Color(0, 0, 0));
    add(label1);

    // Mostrar el nombre del usuario
    labelUsuario = new JLabel("Usuario: " + nombreUsuario);
    labelUsuario.setBounds(10, 10, 200, 30);
    labelUsuario.setFont(new Font("Andale Mono", 0, 12));
    labelUsuario.setForeground(new Color(0, 0, 0));
    add(labelUsuario);

    textarea1 = new JTextArea();
    textarea1.setEditable(false);
    textarea1.setFont(new Font("Andale Mono", 0, 11));   
    textarea1.setText("\n\n          TÉRMINOS Y CONDICIONES - OFF-WHITE" +
                    "\n\n            A. PROHIBIDA LA VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DE OFF-WHITE." +
                    "\n            B. PROHIBIDA LA ALTERACIÓN O MODIFICACIÓN DE LOS DISEÑOS DE LOS PRODUCTOS OFF-WHITE." +
                    "\n            C. OFF-WHITE NO SE HACE RESPONSABLE DEL USO INAPROPIADO DE SUS PRODUCTOS." +
                    "\n\n          LOS TÉRMINOS Y CONDICIONES AQUÍ EXPUESTOS RIGEN EL USO DE PRODUCTOS Y SERVICIOS OFRECIDOS" +
                    "\n          POR OFF-WHITE. AL ACEPTAR ESTOS TÉRMINOS, USTED SE COMPROMETE A HACER UN USO RESPONSABLE Y" + 
                    "\n          LEGAL DE LOS MISMOS. SI NO ACEPTA ESTOS TÉRMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE LOS" +
                    "\n          PRODUCTOS DE LA MARCA." +
                    "\n\n          PARA MÁS INFORMACIÓN SOBRE NUESTROS PRODUCTOS O SERVICIOS, VISITE" + 
                    "\n          https://www.off---white.com/");
    scrollpane1 = new JScrollPane(textarea1);
    scrollpane1.setBounds(10,40,575,200);
    add(scrollpane1);   
    check1 = new JCheckBox("Yo Acepto");
    check1.setBounds(10,250,300,30);
    check1.addChangeListener(this);
    add(check1);
    boton1 = new JButton("Continuar");
    boton1.setBounds(10,290,100,30);
    boton1.addActionListener(this);
    boton1.setEnabled(false); // Deshabilitado inicialmente
    add(boton1);
    boton2 = new JButton("No Acepto");
    boton2.setBounds(120,290,100,30);
    boton2.addActionListener(this);
    boton2.setEnabled(true); // Habilitado inicialmente
    add(boton2);
    ImageIcon imagen = new ImageIcon(getClass().getResource("/images/logo-off.png"));
    label2 = new JLabel(imagen);  
    label2.setBounds(290,140,300,300);
    add(label2);
  }
  
  public void stateChanged(ChangeEvent e){
    if (check1.isSelected()) {
      boton1.setEnabled(true);  // Habilitar botón Continuar
      boton2.setEnabled(false); // Deshabilitar botón No Acepto
    } else {
      boton1.setEnabled(false); // Deshabilitar botón Continuar
      boton2.setEnabled(true);  // Habilitar botón No Acepto
    }
  } 

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == boton1) {
      // Abre la ventana Principal pasando el nombre del usuario
      Principal ventanaPrincipal = new Principal(nombreUsuario);
      ventanaPrincipal.setBounds(0,0,640,535);
      ventanaPrincipal.setVisible(true);
      ventanaPrincipal.setResizable(false);
      ventanaPrincipal.setLocationRelativeTo(null);
      this.dispose(); // Cierra la ventana actual (Licencia)
    } else if(e.getSource() == boton2) {
      // Regresa a la pantalla de bienvenida
      Bienvenida ventanaBienvenida = new Bienvenida();
      ventanaBienvenida.setBounds(0,0,600,360);
      ventanaBienvenida.setVisible(true);
      ventanaBienvenida.setResizable(false);
      ventanaBienvenida.setLocationRelativeTo(null);
      this.dispose(); // Cierra la ventana actual
    }
  }       

  public static void main(String args[]){
    Licencia ventanalicencia = new Licencia("Usuario"); // Ejemplo con "Usuario" por defecto
    ventanalicencia.setBounds(0,0,600,360);
    ventanalicencia.setVisible(true);
    ventanalicencia.setResizable(false);
    ventanalicencia.setLocationRelativeTo(null);
  }
}
