package Modelo;
public class Vehículo {
 private int num_mat;
 private String let_mat;
 private float tiempo_entre_camaras;
 public Vehículo() {
 }

 public String getNum_mat() {
 int min = 0;
 int max = 9999;
 String relleno = ""; //la variable relleno sirve para preceder con ceros el
 //número de matrícula hasta completar 4 cifras
 //de forma que, por ejemplo, el número 56 será el
 //número de matrícula 0056 
 num_mat = (int) (min + (max-min) * Math.random()); //se utiliza el método
// random para calcular un valor aleatorio dentro del rango (min,max)

 if(num_mat<10)
 relleno = "000";
 else if (num_mat<100)
 relleno = "00";
 else if (num_mat<1000)
 relleno = "0";
 return (relleno + num_mat);
 }
 public String getLet_mat() {
 //Para el cálculo aleatorio de las letras no se considera el orden de
//fabricación y tampoco se evita el uso de vocales, por ejemplo, pueden
//darse las matrículas ZZZ o JAV.
 int min = 65; //min y max son los valores ASCII correspondientes a las
 //letras A y Z respectivamente
 int max = 90;
 let_mat = "";
 for(int i = 0; i<3;i++){ //las letras de las matrículas son 3
 let_mat = let_mat + (char)(min + (max-min) * Math.random()); //de nuevo el
 //método random
 }
 return let_mat;
 }

 public float getTiempo_entre_camaras() {
 //Aquí min y max se escogen para obtener unas velocidades de los vehículos
 //en torno a 80Km/h
 double min = 4.2;
 double max = 5;
 tiempo_entre_camaras = (float) (min + (max-min) * Math.random()); //de nuevo el
 //método random
 return tiempo_entre_camaras;
 }

}