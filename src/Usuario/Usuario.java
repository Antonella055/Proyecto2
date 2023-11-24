/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Estructuras.ArrayList;
import Estructuras.Iterator;
import static MonticuloBinario.Monticulo.selectedFile;
import interfaces.GestionDoc.CrearDocumento;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonella
 */
public class Usuario {
    
    public String linea;
    
    
    //Crear documento
    public void crearDocumento(String nombre, String tamaño, String tipo){
        CrearDocumento doc= new CrearDocumento();
        ArrayList<Documento> documentos= new ArrayList<>();
        
        Documento documento= new Documento(nombre,tamaño,tipo);
        documentos.add(documento);
        documento.listaGeneral.add(documentos);
        System.out.println (documento.listaGeneral);
        
    }
    
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
            BufferedWriter writer= new BufferedWriter(new FileWriter(selectedFile,true));
            writer.newLine();
            writer.write(nombre+","+tipo);
            writer.newLine();
            writer.close();
            
           
            JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente", "Nuevo Usuario", JOptionPane.INFORMATION_MESSAGE);
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error en agregar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }}
    }
    
    
    public void EliminarUsuario(String nombre) throws FileNotFoundException{
        boolean Existe= false;
        ArrayList<String>  lineasArchivo= new ArrayList();
        try (BufferedReader lector = new BufferedReader(new FileReader(selectedFile))){
            String linea;
            while ((linea=lector.readLine()) !=null){
                String[] campos= linea.split(",");
                //Comprobar que el usuario no exista ya en el archivo
                if (campos.length >= 2 && campos[0].equals(nombre)) {
                    Existe= true;
                    String Usereliminar = campos[0];
                     lineasArchivo.add(Usereliminar);
                    break;
            }
        }
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
       
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(selectedFile))){
            try (BufferedReader lector = new BufferedReader(new FileReader(selectedFile))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                
            }
        }
        }   catch (IOException ex1) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        }
    
    }

    
   
