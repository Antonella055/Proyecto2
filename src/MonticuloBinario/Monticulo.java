/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MonticuloBinario;

import Estructuras.ArrayList;
import Usuario.Documento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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

    public static void ColaAmonticulo() {
        Documento documento = new Documento( "", 0); // Create a Documento object

            try {
                 ArrayList<Documento> documentos = documento.ValidarDoc_Usuario(documento);
                Constr_monticulo tree = new Constr_monticulo();
                for (int i =0; i< documentos.size(); i++){
                        Documento doc= documentos.get(i);
                        String nombreDocumento = doc.getNombreDocumento();
                         int tiempoAlterado = doc.getTiempoAlterado(); 
                         tree.raiz = tree.insertar(tree.raiz, nombreDocumento, tiempoAlterado);
                }
                
                tree.printMonticulo(tree.raiz, "", true);
            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado.");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Error al leer el archivo.");
                e.printStackTrace();
            }

    }
    public static void Mostrar() throws IOException{
         Documento documento = new Documento( "", 0); // Create a Documento object

            try {
                 ArrayList<Documento> documentos = documento.ValidarDoc_Usuario(documento);
                Constr_monticulo tree = new Constr_monticulo();
                for (int i =0; i< documentos.size(); i++){
                        Documento doc= documentos.get(i);
                        String nombreDocumento = doc.getNombreDocumento();
                         int tiempoAlterado = doc.getTiempoAlterado(); 
                         tree.raiz = tree.insertar(tree.raiz, nombreDocumento, tiempoAlterado);
                }
                  
                  tree.DisplayMonticulo(tree.raiz);
    }    catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado.");
                e.printStackTrace();
            } 
    }

    
    
     public void abrirArchivo(){
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
     
      public static String AñadirDocumento(String Usuario){
        String user = (String)JOptionPane.showInputDialog( "Introduzca los datos del documento bajo propiedad de "+Usuario + " con el siguiente formato(Nombre, tamaño, tipo) ");
        String[] lista = user.split(",");
        
        int count = user.length() - user.replace(",", "").length(); //Contar el numero de comas para que valide 
        
        if (user == "end") {
            System.out.println("Existoso");
                
                }
        else if(count == 2 && isInteger(lista[1])){
            String Documento ="Propietario: "+ Usuario + "\n"
                            + "Nombre: " + lista[0]+ "\n"+
                              "Tamaño: " + lista[1]+"\n"
                             +"Tipo: "+lista[2];
            System.out.println("Exito");
         
        return Documento;
    }
        else{
            System.out.println("Error");
            AñadirDocumento(Usuario);
        }
         return null;
        
    }
        public static boolean isInteger(String s) { //Determinar si es int
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
}

     
     
     
     
     
      

