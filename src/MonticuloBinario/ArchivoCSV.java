/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MonticuloBinario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonella
 */
public class ArchivoCSV {
    private BufferedReader lector;
    private String linea;
    private String revisado[]= null; //almacena cada linea leida
   
    public void leerArchivo(String file){
        try{
            lector= new BufferedReader(new FileReader(file));
            while ((linea= lector.readLine()) != null){
                revisado= linea.split(",");
                System.out.println();
            }
            lector.close();
            linea= null;
            revisado=null;
        }catch (Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
    public void printLinea(){
        for(int i=0; i< revisado.length; i++){
            System.out.print(revisado[i]+" | ");
        }
    }
}
