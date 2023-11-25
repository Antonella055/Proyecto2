/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Estructuras.ArrayList;
import static Estructuras.ArrayList.VerArrayDoble;
import static MonticuloBinario.Monticulo.selectedFile;
import static interfaces.GestionDoc.RegistroUsr.usuarioData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonella
 */
public class Usuario {
    private static boolean imprimirTiempo = false;
    private String tiempoRegistrado;
    
    
    
    public void AgregarUsuario(String nombre,String tipo) throws IOException{
        boolean Existe= false;
        try (BufferedReader lector = new BufferedReader(new FileReader(selectedFile))){
            String linea;
            while ((linea=lector.readLine()) !=null){
                String[] campos= linea.split(",");
                //Comprobar que el usuario no exista ya en el archivo
                if (campos.length >= 2 && campos[0].equals(nombre)) {
                    Existe= true;
                    break;
            }
        }
        }
        if (Existe){
            JOptionPane.showMessageDialog(null, "El usuario ya existe en el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            
        try{
            tipo=tipo.replace(" ","_"); //aplicar el formato del csv 
            BufferedWriter writer= new BufferedWriter(new FileWriter(selectedFile,true));
            writer.write(nombre+","+tipo);
            writer.newLine();
            writer.close();
            
           
            JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente", "Nuevo Usuario", JOptionPane.INFORMATION_MESSAGE);
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error en agregar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }}
    }
    
    
    public void EliminarUsuario(String nombre) throws FileNotFoundException, IOException{
        boolean encontrado=false;
        ArrayList<String> lineas = new ArrayList<>(new Object[0], 0);
        
            try (BufferedReader lector = new BufferedReader(new FileReader(selectedFile))) {
                String linea;
                while ((linea=lector.readLine()) !=null){
                    String[] campos= linea.split(",");
                    //Comprobar que el usuario no exista ya en el archivo
                    if (campos.length >= 2 && campos[0].equals(nombre)) {
                       if(!linea.trim().isEmpty()){
                        encontrado=true;
                       }
                    }else{
                    lineas.add(linea);
                }   }
            
                    if (encontrado) { //sobre escribir la info del array en elcsv sin el usuario eliminado
                    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(selectedFile))) {
                         for (int i =0; i< lineas.size(); i++){
                        String actuali= lineas.get(i);
                            escritor.write(actuali);
                            escritor.newLine();
                        
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El usuario " + nombre + " se ha eliminado", "Eliminar Usuario", JOptionPane.INFORMATION_MESSAGE);
                }else{
                        JOptionPane.showMessageDialog(null, "El usuario no esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
        }}
 public void procesaTiempo(String tiempo){
        if(debeImprimirTiempo()){
             System.out.println("Entrada de documento: " + tiempo);
             imprimirTiempo = false;
             
             try{ //solucion al actionlistener donde se extrae el tiempo para obtener ese valor
                 FileWriter writer= new FileWriter("tiempo.txt");
                 BufferedWriter buffer= new BufferedWriter(writer);
                 
                 buffer.write(tiempo);
                 buffer.close();
                System.out.println("Tiempo guardado en archivo.txt");
             } catch (IOException e) {
                System.out.println("Error al guardar el tiempo en el archivo");
                e.printStackTrace();
            }
        }
    }
   public void cambiarImprimirTiempo(boolean valor) {
           imprimirTiempo = valor;
       }

    public boolean debeImprimirTiempo(){
        return imprimirTiempo;
    }

    public void CrearDocumento(String usuario,String nombre,String tamano,String tipo) throws FileNotFoundException {
        ArrayList<String>  Prueba = new ArrayList<>(new Object[0], 0);
        ArrayList<Object> list = new ArrayList<>(new Object[0], 0);
        
        try {
        FileWriter writer = new FileWriter("documentoUsuario.csv", true);
        BufferedWriter buffer = new BufferedWriter(writer);
        
        buffer.write(usuario+","+nombre + "," + tamano + "," + tipo);
        buffer.newLine();
        buffer.close();
        System.out.println("Documento creado y guardado en documentoUsuario.csv");
        
       
   
    } catch (IOException e) {
        System.out.println("Error al guardar el documento en el archivo");
        e.printStackTrace();
    }
        
    }
     public void CrearDocumentoCola(String usuario,String prioridad) throws FileNotFoundException {
        ArrayList<String>  Prueba = new ArrayList<>(new Object[0], 0);
        ArrayList<Object> list = new ArrayList<>(new Object[0], 0);
        
        try {
        FileWriter writer = new FileWriter("documentoCola.csv", true);
        BufferedWriter buffer = new BufferedWriter(writer);
        
        buffer.write(usuario+","+prioridad);
        buffer.newLine();
        buffer.close();
        System.out.println("Documento creado y guardado en documentoCola.csv");
        
       
   
    } catch (IOException e) {
        System.out.println("Error al guardar el documento en el archivo");
        e.printStackTrace();
    }
        
    }
    
    
    public void DocImpresion(String nombre,String tiempo){
        
        
        
        
        
         try {
        FileWriter writer = new FileWriter("documentoImpresion.csv", true);
        BufferedWriter buffer = new BufferedWriter(writer);
        
        buffer.write(nombre + "," + tiempo);
        buffer.newLine();
        buffer.close();
        System.out.println("Documento agregado");
        
    } catch (IOException e) {
        System.out.println("Error al guardar el documento en el archivo");
        e.printStackTrace();
    }
        
        
        
    }
    
    
}
