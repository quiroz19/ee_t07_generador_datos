package Generador;

 
import java.util.*;
import java.io.*;  /**Importamos nuestras librerias necesarias*/
import javax.swing.*;
public class NombresAleatoreos
{
  public void NuevosNombres(){
      int crea=Integer.parseInt(JOptionPane.showInputDialog("cuantas datos aleatorios deseas crear? "));
    File n= new File("Nombres.txt");  /**Declaramos la clase file para recibir archivos*/
    File p= new File("aPaternos.txt");
    File m= new File("aMaternos.txt");
    File nu=new File("Nuevos.csv");  /**Declaramos una mas para almacenar nuestros nombres completos*/
    File d=new File("direcciones.txt");
    File e=new File("Edades.txt");
    
      ArrayList<String> nam=new ArrayList<String>(); /**Declaramos 3 arraylist para almacenar todos los nombres, apellidos paternos y maternos que estan en los 3 diferentes archivos*/
      ArrayList<String> apeP=new ArrayList<String>();
      ArrayList<String> apeM=new ArrayList<String>();
      ArrayList<String> dir=new ArrayList<String>();
      ArrayList<String> eda=new ArrayList<String>();
      
     Iterator<String> i=nam.iterator(); /**Declaramos Iteradores para recorrer los arraylist*/
     Iterator<String> o=apeP.iterator();
     Iterator<String> u=apeM.iterator();
  
     String [] nom =new String [1]; /**declaramos unos arreglos auxiliares para almacenar 1 elementos a la vez que estan en los archivos*/
     String [] aP =new String [1];
     String [] aM =new String[1];
     String [] di=new String[1];
     String [] ed=new String[1];
     
     int nObj=0; 
     
     try{
        nam.clear();
        apeP.clear();  /**limpiamos los arrays*/
        apeM.clear();
        dir.clear();
        eda.clear();
        
        BufferedReader le =new BufferedReader(new FileReader(n));
        BufferedReader lee =new BufferedReader(new FileReader(p)); /**instanciamos los buffered 3 para leer los archivos y uno mas para escribir en el nuevo*/
        BufferedReader leer =new BufferedReader(new FileReader(m));
        BufferedReader aa =new BufferedReader(new FileReader(d));
        BufferedReader leeer =new BufferedReader(new FileReader(e));
        BufferedWriter es= new BufferedWriter(new FileWriter(nu));
        
        String aux1=le.readLine();  /**leemos la primera linea de los 3 archivos y almacenamos en una variable String*/
        String aux2=lee.readLine();
        String aux3=leer.readLine();
        String aux4=aa.readLine();
        String aux5=leeer.readLine();
         while(aux1!=null && aux2!=null && aux3!=null && aux4!=null && aux5!=null){  /**iniciamos un ciclo while que termine hasta que no existan mas datos*/
             
           nom= aux1.split(" "); /**guardamos en los arreglos auxiliares lo que leimos en la primera linea de cada archivo*/
           aP= aux2.split(" ");
           aM= aux3.split(" ");
           di=aux4.split("\n");
           ed=aux5.split(" ");
           
           nam.add(nom[0]);
           apeP.add(aP[0]); /**Almacenamos en los arrayList con el metodo add, lo que tenemos en los arreglos string */
           apeM.add(aM[0]);
           dir.add(di[0]);
           eda.add(ed[0]);
           
           aux1=le.readLine();
           aux2=lee.readLine(); /**le damos la instruccion de leer la siguiente linea con el metodo readline*/
           aux3=leer.readLine();
           aux4=aa.readLine();
           aux5=leeer.readLine();
           }
           
           int cont=0;  /**contador para el ciclo while que nos permita decir donde terminar*/
           String s; /**una variable para almacenar los nombres completos, nombre + apellido paterno + apellido materno*/
           
         while(cont<crea){ /**la condicion del while*/
             
             nObj++; /** contador de nombres creados*/
            int z= (int)(Math.random()*nam.size() );  /**instanciamos un metodo math.random que nos permita sacar aleatoriamente un numero entre 0 y el limite de elementos del arraylist*/
            int x= (int)(Math.random()*apeP.size() ); /**ya que tenemos el numero aleatorio lo guardamos en una variable de tipo entero*/
            int y= (int)(Math.random()*apeM.size() );
            int w= (int)(Math.random()*dir.size() );
            int l= (int)(Math.random()*eda.size() );
              
              s= nam.get(z)+","+apeP.get(x)+","+apeM.get(y)+","+eda.get(l)+","+dir.get(w);  /**finalmente con utilizamos estas variables con el numero almacenado y usamos el metodo get de los diferentes arraylist para extraer la informacion ese lugar y guardarlo en el string antes declarado*/
              System.out.println(s); /**imprimimos en consola cada resultado*/
              es.write(s); /**declaramos el metodos write para escribir el contenido de la variable string en el archivo*/
              es.newLine(); /**metodo newline para pasar a la siguiente linea*/
              es.flush(); /**flush por si existen informacion atrapada aun en la clase*/
             cont++;
            }
           
         es.close(); /**cerramos los archivos una vez terminados los ciclos*/
        le.close();
        lee.close();
        leer.close();
        aa.close();
        leeer.close();
        }
        catch(FileNotFoundException na){  /**colocamos las excepciones*/
        System.out.println("Alguno de los archivos no se encuentra");
      }
      catch(IOException io){
        System.out.println("excepcion inesperada");
        }
     finally{
        System.out.println("\nse agregaron "+nObj+" nombres y apellidos del archivo");
        }
    }
    
     public static void main(String [] args){  /**metodo main*/
       NombresAleatoreos data= new NombresAleatoreos();
       data.NuevosNombres();
        }
}
