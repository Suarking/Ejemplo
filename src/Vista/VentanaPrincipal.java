package Vista;
//COMMENT
import Controlador.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
public class VentanaPrincipal extends JFrame{

 JTextArea taTodos;
 JTextArea taInfractores;
 Timer tiempo;

 public VentanaPrincipal() {

 // Características generales de la ventana principal
 this.setTitle("MVC Simulador de Radar");
 this.setSize(950, 650);
 this.getContentPane().setLayout(null);
 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 this.setLocationRelativeTo(null); //posiciona la ventana en el centro de
 //la pantalla
 this.setResizable(false); //no redimensionable

 // Panel principal (panelDatos + panelDerecho)
 JPanel panelPrincipal = new JPanel();

 panelPrincipal.setBounds(10, 10, 920, 600);
 panelPrincipal.setLayout(new BorderLayout());

 // Panel datos
 JPanel panelDatos = new JPanel();
 panelDatos.setBorder(BorderFactory.createTitledBorder("Total vehículos"));
 panelDatos.setBackground(Color.WHITE);
 taTodos = new JTextArea();
 panelDatos.add(taTodos);
 JScrollPane spDatos = new JScrollPane(panelDatos);

 // Panel derecho (panelBotones + panelInfractores)
 JPanel panelDerecho = new JPanel();
 panelDerecho.setLayout(new BorderLayout());

 // Panel botones
 JPanel panelBotones = new JPanel();
 panelBotones.setBorder(BorderFactory.createTitledBorder("Controles de la simulación"));
 JButton bIniciar= new JButton("Iniciar");
 JButton bDetener= new JButton("Detener");
 bIniciar.setEnabled(true);
 bDetener.setEnabled(false);

 panelBotones.add(bIniciar);
 panelBotones.add(bDetener);

 //Panel distancia
 JPanel panelDistancia = new JPanel();
 panelDistancia.setBorder(BorderFactory.createTitledBorder("Distancia entre cámaras: 100 metros"));

 JLabel etiImagen = new JLabel();
 etiImagen.setIcon(new ImageIcon(getClass().getResource("RadarTramo.jpg")));

 panelDistancia.add(etiImagen);

 // Panel infractores
 JPanel panelInfractores = new JPanel();
 panelInfractores.setBorder(BorderFactory.createTitledBorder("Vehículos infractores"));
 panelInfractores.setBackground(Color.WHITE);

 taInfractores= new JTextArea();
 taInfractores.setForeground(Color.BLUE);
 panelInfractores.add(taInfractores);
 JScrollPane spInfractores = new JScrollPane(panelInfractores);
 panelDerecho.add(panelBotones, BorderLayout.NORTH);
 panelDerecho.add(spInfractores, BorderLayout.CENTER);
 panelDerecho.add(panelDistancia, BorderLayout.SOUTH);

 panelPrincipal.add(panelDerecho, BorderLayout.EAST);
 panelPrincipal.add(spDatos, BorderLayout.CENTER);

 this.getContentPane().add(panelPrincipal);

 tiempo = new Timer(1000, null); // el objeto tiempo será fuente de evento
// cada 1000 milisegundos (1 segundo)
 // Aquí podría ponerse un tiempo aleatorio
// para que fuera más real.

 bIniciar.addActionListener(new ControlVentanaPrincipal(bIniciar, bDetener,tiempo, taTodos, taInfractores));
 bDetener.addActionListener(new ControlVentanaPrincipal(bIniciar, bDetener,tiempo, taTodos, taInfractores));
 tiempo.addActionListener(new ControlVentanaPrincipal(bIniciar, bDetener,tiempo, taTodos, taInfractores));

 }
}