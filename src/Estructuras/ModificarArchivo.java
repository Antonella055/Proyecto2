/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano
 */
public class ModificarArchivo{
    
        static void EliminarUsuario(String file, String lineToRemove)
      {

    try {

      File inFile = new File(file);

      if (!inFile.isFile()) {
        JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe, o esta vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
        return;
      }

      File tempFile = new File(inFile.getAbsolutePath() + ".csv"); //Programa para que reemplace el archivo con uno nuevo que no tiene el usuario, elimnandolo

      BufferedReader br = new BufferedReader(new FileReader(file));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

      String line = null;

      
      while ((line = br.readLine()) != null) {

        if (!line.contains(lineToRemove)) {

          pw.println(line);
          pw.flush();
        }
      }
      JOptionPane.showMessageDialog(null, "El documento fue eliminado existosamente", "Operación existosa", JOptionPane.INFORMATION_MESSAGE);

      pw.close();
      br.close();

      if (!inFile.delete()) {
        JOptionPane.showMessageDialog(null, "No se pudo borrar el archivo", "Alerta", JOptionPane.ERROR_MESSAGE);
        return;
      }

      if (!tempFile.renameTo(inFile))
        JOptionPane.showMessageDialog(null, "No se pudo renombrar el archivo", "Alerta", JOptionPane.ERROR_MESSAGE);

    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
   
  }
        
    public static boolean validador(String file, String nombre) throws FileNotFoundException, IOException{
        String line = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        while ((line = br.readLine()) != null) {
            
        if (line.split(",")[0].equals(nombre)) {
            br.close();
            return true;}
      if (line.split(",")[1].equals(nombre)) {
            br.close();
            return true;}
        }
        br.close();
        return false;
    }
    
       public static void InputEliminacionUser(File Archivo, String user) throws IOException{
           BufferedReader br = new BufferedReader(new FileReader(Archivo));
    String aLineFromFile = null;
    String Mensaje = null;
    while ((aLineFromFile = br.readLine()) != null){
            Mensaje = Mensaje +"\n" + aLineFromFile; //Demostrar los elementos dentro del archivo
    }   
      br.close();
               //   JOptionPane.showMessageDialog(null, Mensaje);
                
                if(validador(Archivo.toString(),user)){
                    EliminarUsuario(Archivo.toString(), user);
                }else{
                            JOptionPane.showMessageDialog(null, "ERROR:  No se encontro este elemento registrado", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
    }
    
}