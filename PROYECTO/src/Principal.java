import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame implements ActionListener {

    private JMenuBar mb;
    private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuColorFondo;
    private JMenuItem miCalculo, miRojo, miNegro, miMorado, miElCreador, miSalir, miNuevo, miRegresar, miPaletaColores;
    private JLabel labelLogo, labelBienvenido, labelTitle, labelNombre, labelAPaterno, labelAMaterno,
            labelDepartamento, labelAntiguedad, labelResultado, labelfooter;
    private JTextField txtNombreTrabajador, txtAPaternoTrabajador, txtAMaternoTrabajador;
    private JComboBox<String> comboDepartamento, comboAntiguedad;
    private JScrollPane scrollpane1;
    private JTextArea textarea1;

    private String nombreUsuario;

    public Principal(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;

        setLayout(null);
        setTitle("Pantalla principal");
        getContentPane().setBackground(new Color(0, 0, 0)); // Fondo negro
        setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

        // Barra de menú
        mb = new JMenuBar();
        mb.setBackground(new Color(0, 0, 0));
        setJMenuBar(mb);

        // Menú de Opciones
        menuOpciones = new JMenu("Opciones");
        menuOpciones.setFont(new Font("Arial", 1, 14));
        menuOpciones.setForeground(new Color(255, 255, 255)); // Texto en blanco
        mb.add(menuOpciones);

        // Menú de Calcular
        menuCalcular = new JMenu("Calcular");
        menuCalcular.setFont(new Font("Arial", 1, 14));
        menuCalcular.setForeground(new Color(255, 255, 255)); // Texto en blanco
        mb.add(menuCalcular);

        // Menú Acerca de
        menuAcercaDe = new JMenu("Acerca de");
        menuAcercaDe.setFont(new Font("Arial", 1, 14));
        menuAcercaDe.setForeground(new Color(255, 255, 255)); // Texto en blanco
        mb.add(menuAcercaDe);

        // Submenú para cambiar el color de fondo
        menuColorFondo = new JMenu("Color de fondo");
        menuColorFondo.setFont(new Font("Arial", 1, 14));
        menuColorFondo.setForeground(new Color(0, 0, 0)); // Texto en negro
        menuOpciones.add(menuColorFondo);

        // Opción de calcular vacaciones
        miCalculo = new JMenuItem("Vacaciones");
        miCalculo.setFont(new Font("Arial", 1, 14));
        miCalculo.setForeground(new Color(0, 0, 0)); // Texto en negro
        menuCalcular.add(miCalculo);
        miCalculo.addActionListener(this);

        // Opciones de color de fondo
        miRojo = new JMenuItem("Rojo");
        miRojo.setFont(new Font("Arial", 1, 14));
        miRojo.setForeground(new Color(0, 0, 0)); // Texto en negro
        menuColorFondo.add(miRojo);
        miRojo.addActionListener(this);

        miNegro = new JMenuItem("Negro");
        miNegro.setFont(new Font("Arial", 1, 14));
        miNegro.setForeground(new Color(0, 0, 0)); // Texto en negro
        menuColorFondo.add(miNegro);
        miNegro.addActionListener(this);

        miMorado = new JMenuItem("Morado");
        miMorado.setFont(new Font("Arial", 1, 14));
        miMorado.setForeground(new Color(0, 0, 0)); // Texto en negro
        menuColorFondo.add(miMorado);
        miMorado.addActionListener(this);

        miPaletaColores = new JMenuItem("Paleta de colores");
        miPaletaColores.setFont(new Font("Arial", 1, 14));
        miPaletaColores.setForeground(new Color(0, 0, 0)); // Texto en negro
        menuColorFondo.add(miPaletaColores);
        miPaletaColores.addActionListener(this);

        // Opción de nuevo
        miNuevo = new JMenuItem("Nuevo");
        miNuevo.setFont(new Font("Arial", 1, 14));
        miNuevo.setForeground(new Color(0, 0, 0)); // Texto en negro
        menuOpciones.add(miNuevo);
        miNuevo.addActionListener(this);

        // Opción para salir
        miSalir = new JMenuItem("Salir");
        miSalir.setFont(new Font("Arial", 1, 14));
        miSalir.setForeground(new Color(0, 0, 0)); // Texto en negro
        menuOpciones.add(miSalir);
        miSalir.addActionListener(this);

        // Opción para regresar
        miRegresar = new JMenuItem("Regresar");
        miRegresar.setFont(new Font("Arial", 1, 14));
        miRegresar.setForeground(new Color(0, 0, 0)); // Texto en negro
        menuOpciones.add(miRegresar);
        miRegresar.addActionListener(this);

        // Logo utilizando getResource
        ImageIcon imagen = new ImageIcon(getClass().getResource("/images/logo.png"));
        labelLogo = new JLabel(imagen);
        labelLogo.setBounds(25, 28, 90, 80);
        add(labelLogo);

        // Mensaje de bienvenida
        labelBienvenido = new JLabel("Bienvenido, " + nombreUsuario, JLabel.CENTER);
        labelBienvenido.setBounds(0, 30, 640, 50);
        labelBienvenido.setFont(new Font("Arial", 1, 32)); // Cambiado a Arial
        labelBienvenido.setForeground(new Color(255, 255, 255)); // Texto en blanco
        add(labelBienvenido);

        // Título de la ventana
        labelTitle = new JLabel("Datos del trabajador para el cálculo de vacaciones");
        labelTitle.setBounds(45, 140, 900, 25);
        labelTitle.setFont(new Font("Arial", 0, 24)); // Cambiado a Arial
        labelTitle.setForeground(new Color(255, 255, 255)); // Texto en blanco
        add(labelTitle);

        // Campos para ingresar el nombre
        labelNombre = new JLabel("Nombre completo:");
        labelNombre.setBounds(25, 188, 180, 25);
        labelNombre.setFont(new Font("Arial", 1, 12));
        labelNombre.setForeground(new Color(255, 255, 255));
        add(labelNombre);

        txtNombreTrabajador = new JTextField();
        txtNombreTrabajador.setBounds(25, 213, 150, 25);
        txtNombreTrabajador.setBackground(new java.awt.Color(224, 224, 224));
        txtNombreTrabajador.setFont(new java.awt.Font("Arial", 1, 14));
        txtNombreTrabajador.setForeground(new Color(0, 0, 0));
        add(txtNombreTrabajador);

        // Campo de Apellido Paterno
        labelAPaterno = new JLabel("Apellido Paterno:");
        labelAPaterno.setBounds(25, 248, 180, 25);
        labelAPaterno.setFont(new Font("Arial", 1, 12));
        labelAPaterno.setForeground(new Color(255, 255, 255));
        add(labelAPaterno);

        txtAPaternoTrabajador = new JTextField();
        txtAPaternoTrabajador.setBounds(25, 273, 150, 25);
        txtAPaternoTrabajador.setBackground(new java.awt.Color(224, 224, 224));
        txtAPaternoTrabajador.setFont(new java.awt.Font("Arial", 1, 14));
        txtAPaternoTrabajador.setForeground(new Color(0, 0, 0));
        add(txtAPaternoTrabajador);

        // Campo de Apellido Materno
        labelAMaterno = new JLabel("Apellido Materno:");
        labelAMaterno.setBounds(25, 308, 180, 25);
        labelAMaterno.setFont(new Font("Arial", 1, 12));
        labelAMaterno.setForeground(new Color(255, 255, 255));
        add(labelAMaterno);

        txtAMaternoTrabajador = new JTextField();
        txtAMaternoTrabajador.setBounds(25, 334, 150, 25);
        txtAMaternoTrabajador.setBackground(new java.awt.Color(224, 224, 224));
        txtAMaternoTrabajador.setFont(new java.awt.Font("Arial", 1, 14));
        txtAMaternoTrabajador.setForeground(new Color(0, 0, 0));
        add(txtAMaternoTrabajador);

        // Selector de Departamento
        labelDepartamento = new JLabel("Selecciona el Departamento:");
        labelDepartamento.setBounds(220, 188, 180, 25);
        labelDepartamento.setFont(new Font("Arial", 1, 12));
        labelDepartamento.setForeground(new Color(255, 255, 255));
        add(labelDepartamento);

        comboDepartamento = new JComboBox<>();
        comboDepartamento.setBounds(220, 213, 220, 25);
        comboDepartamento.setBackground(new java.awt.Color(224, 224, 224));
        comboDepartamento.setFont(new java.awt.Font("Arial", 1, 14));
        comboDepartamento.setForeground(new Color(0, 0, 0));
        add(comboDepartamento);
        comboDepartamento.addItem("");
        comboDepartamento.addItem("Atención al Cliente");
        comboDepartamento.addItem("Departamento de Logística");
        comboDepartamento.addItem("Departamento de Gerencia");

        // Selector de Antigüedad
        labelAntiguedad = new JLabel("Selecciona la Antigüedad:");
        labelAntiguedad.setBounds(220, 248, 180, 25);
        labelAntiguedad.setFont(new Font("Arial", 1, 12));
        labelAntiguedad.setForeground(new Color(255, 255, 255));
        add(labelAntiguedad);

        comboAntiguedad = new JComboBox<>();
        comboAntiguedad.setBounds(220, 273, 220, 25);
        comboAntiguedad.setBackground(new java.awt.Color(224, 224, 224));
        comboAntiguedad.setFont(new java.awt.Font("Arial", 1, 14));
        comboAntiguedad.setForeground(new Color(0, 0, 0));
        add(comboAntiguedad);
        comboAntiguedad.addItem("");
        comboAntiguedad.addItem("1 año de servicio");
        comboAntiguedad.addItem("2 a 6 años de servicio");
        comboAntiguedad.addItem("7 años o más de servicio");

        // Resultado del cálculo
        labelResultado = new JLabel("Resultado del Cálculo:");
        labelResultado.setBounds(220, 307, 180, 25);
        labelResultado.setFont(new Font("Arial", 1, 12));
        labelResultado.setForeground(new Color(255, 255, 255));
        add(labelResultado);

        // Área de texto para mostrar el resultado
        textarea1 = new JTextArea();
        textarea1.setEditable(false);
        textarea1.setBackground(new Color(224, 224, 224));
        textarea1.setFont(new Font("Arial", 1, 11));
        textarea1.setForeground(new Color(0, 0, 0));
        textarea1.setText("\n   Aquí aparece el resultado del cálculo de las vacaciones.");
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(220, 333, 385, 90);
        add(scrollpane1);

        // Footer
        labelfooter = new JLabel("© 2024 Off-White™ | Todos los derechos reservados");
        labelfooter.setBounds(135, 445, 500, 30);
        labelfooter.setFont(new java.awt.Font("Arial", 1, 12));
        labelfooter.setForeground(new java.awt.Color(255, 255, 255));
        add(labelfooter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miCalculo) {
            String nombre = txtNombreTrabajador.getText();
            String apellidoPaterno = txtAPaternoTrabajador.getText();
            String apellidoMaterno = txtAMaternoTrabajador.getText();
            int vacaciones = calcularVacaciones();
            if (vacaciones == -1) {
                textarea1.setText("Error: Selecciona el departamento y la antigüedad.");
            } else {
                textarea1.setText("El trabajador " + nombre + " " + apellidoPaterno + " " + apellidoMaterno +
                        " tiene derecho a " + vacaciones + " días de vacaciones.");
            }
        }
        if (e.getSource() == miRojo) {
            getContentPane().setBackground(new Color(255, 0, 0));
        }
        if (e.getSource() == miNegro) {
            getContentPane().setBackground(new Color(0, 0, 0));
        }
        if (e.getSource() == miMorado) {
            getContentPane().setBackground(new Color(128, 0, 128));
        }
        if (e.getSource() == miPaletaColores) {
            Color color = JColorChooser.showDialog(null, "Elige un color", getContentPane().getBackground());
            if (color != null) {
                getContentPane().setBackground(color);
            }
        }
        if (e.getSource() == miNuevo) {
            txtNombreTrabajador.setText("");
            txtAPaternoTrabajador.setText("");
            txtAMaternoTrabajador.setText("");
            comboDepartamento.setSelectedIndex(0);
            comboAntiguedad.setSelectedIndex(0);
            textarea1.setText("   Aquí aparece el resultado del cálculo de las vacaciones.");
        }
        if (e.getSource() == miSalir) {
            System.exit(0);
        }
        if (e.getSource() == miRegresar) {
            new Bienvenida().setVisible(true);
            this.dispose();
        }
        if (e.getSource() == miElCreador) {
            JOptionPane.showMessageDialog(this, "Desarrollado por: Mauro Jovel");
        }
    }

    public int calcularVacaciones() {
        String departamento = (String) comboDepartamento.getSelectedItem();
        String antiguedad = (String) comboAntiguedad.getSelectedItem();

        if (departamento == null || antiguedad == null || departamento.equals("") || antiguedad.equals("")) {
            return -1;
        }

        switch (departamento) {
            case "Atención al Cliente":
                if (antiguedad.equals("1 año de servicio")) return 6;
                else if (antiguedad.equals("2 a 6 años de servicio")) return 14;
                else if (antiguedad.equals("7 años o más de servicio")) return 20;
                break;
            case "Departamento de Logística":
                if (antiguedad.equals("1 año de servicio")) return 7;
                else if (antiguedad.equals("2 a 6 años de servicio")) return 15;
                else if (antiguedad.equals("7 años o más de servicio")) return 22;
                break;
            case "Departamento de Gerencia":
                if (antiguedad.equals("1 año de servicio")) return 10;
                else if (antiguedad.equals("2 a 6 años de servicio")) return 20;
                else if (antiguedad.equals("7 años o más de servicio")) return 30;
                break;
        }
        return 0;
    }

    public static void main(String[] args) {
        Principal ventanaPrincipal = new Principal("Usuario");
        ventanaPrincipal.setBounds(0, 0, 640, 535);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setLocationRelativeTo(null);
    }
}
