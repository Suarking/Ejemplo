package Controlador;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.Timer;
public class ControlVentanaPrincipal implements ActionListener{
 Vehículo nuevo;
 int distancia = 100;

 JButton bIniciar;
 JButton bDetener;
 Timer tiempo;
 JTextArea taTodos;
 JTextArea taInfractores;

 public ControlVentanaPrincipal(JButton bIniciar, JButton bDetener, Timer
tiempo, JTextArea taTodos, JTextArea taInfractores) {
 this.bIniciar = bIniciar;
 this.bDetener = bDetener;
 this.tiempo = tiempo;
 this.taTodos = taTodos;
 this.taInfractores = taInfractores;
 }
 @Override
 public void actionPerformed(ActionEvent ae) {
 Object fuente = ae.getSource(); //método de EventObject

 if(fuente == bIniciar) {
 tiempo.start(); //si el evento lo ha generado el botón iniciar se pone
 //en marcha el objeto tiempo
 bIniciar.setEnabled(false);
 bDetener.setEnabled(true);
 }

 else if(fuente == bDetener) {
 tiempo.stop(); //si el evento lo ha generado el botón detener se para
 //el objeto tiempo
 bDetener.setEnabled(false);
 bIniciar.setEnabled(true);

 }

 else if(fuente == tiempo){
 nuevoVehículo(); //evento generado cada cierto intervalo de tiempo.
 //Cada 1000 milisegundos es detectado un nuevo
 //vehículo.
 }
 }

 public void nuevoVehículo(){

 nuevo = new Vehículo(); //Se crea un objeto Vehículo detectado

 String cifras = nuevo.getNum_mat(); //se toma el número de la matrícula del
 //nuevo vehículo
 String letras = nuevo.getLet_mat(); //se toman las letras de la matrícula
 //del nuevo vehículo

 float tiempo_entre_camaras = nuevo.getTiempo_entre_camaras(); //se toma el
//tiempo entre cámaras del nuevo vehículo
 double velocidadMS = distancia/tiempo_entre_camaras; //cálculo de la velocidad
 //en metros/segundo (v=e/t)

 int velocidadKMH = (int)(velocidadMS*3.6); //paso de la velocidad de m/s a Km/h

 //se añaden los datos del nuevo vehículo al JTextArea taTodos
 taTodos.append("Matrícula: " + cifras + " " + letras + "\tTiempo: " +
tiempo_entre_camaras + " s \tVelocidad: " + velocidadKMH + " Km/h \n");

 //se añaden los datos del nuevo vehículo al JTextArea taInfractores si su
 //velocidad es superior a 80
 if(velocidadKMH>80)
 taInfractores.append("" + cifras + " " + letras + " \tVelocidad: " +
velocidadKMH + " Km/h \n");

 }
}
