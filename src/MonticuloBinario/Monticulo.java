/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MonticuloBinario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Antonella
 */
public class Monticulo { //Abrir archivo y usar sus datos para la creacion del Monticulo
     public static File selectedFile; 

    public static void main(String[] args) {
        Constr_monticulo tree = new Constr_monticulo();
        abrirArchivo();
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    String username = data[0];
                    String prioridad = data[1];
                    int nivelprioridad;
                    switch (prioridad) {
                    //asignarle un valor numerico dependiendo de la prioridad del usuario
                        case "prioridad_baja":
                            nivelprioridad = 1;
                            break;
                        case "prioridad_media":
                            nivelprioridad = 2;
                            break;
                        case "prioridad_alta":
                            nivelprioridad = 3;
                            break;
                        default:
                            nivelprioridad = 0;
                            break;
                    }
                    tree.raiz = tree.insertar(tree.raiz, username, nivelprioridad);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        tree.printMonticulo(tree.raiz, "", true);
    }

    
    
     public static void abrirArchivo(){
        JFileChooser fileChooser = new JFileChooser(); //JFileChooser ->abrir un cuadro de diálogo donde el usuario puede elegir un fichero a través del explorador de archivos de su equipo.
        JTextArea text = new JTextArea();
        text.setEditable(false); //el usuario no tiene permitido editar el contenido
        
        fileChooser.setCurrentDirectory(new File("C:\\Users\\Antonella\\OneDrive\\Escritorio\\Proyecto Github\\Proyecto2git\\archivos CSV")); //abrir una carpeta predeterminada
        
        // Filtrar solo archivos de texto 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.csv", "csv");
        fileChooser.setFileFilter(filter);
        
        // llamada a  el cuadro de diálogo de selección de archivo
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION ) { 
            selectedFile = fileChooser.getSelectedFile(); //file seleccionado
            
            if (selectedFile.length() !=0 && selectedFile.exists()){ //validar que exista y que contenga informacion
                System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath()); 
                
               
             }else {JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe, o esta vacio", "Alerta", JOptionPane.ERROR_MESSAGE);}
        }
    }
     
     }
     
      

