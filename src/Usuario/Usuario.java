/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Estructuras.ArrayList;
import static MonticuloBinario.Monticulo.selectedFile;
import interfaces.GestionDoc.CrearDocumento;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonella
 */
public class Usuario {
    
    
    //Crear documento
    public void crearDocumento(String nombre, String tamaño, String tipo, String tiempo){
        CrearDocumento doc= new CrearDocumento();
        ArrayList<Documento> documentos= new ArrayList<>();
        ArrayList<Object>  Prueba = new ArrayList<>();
        
        
        Documento documento= new Documento(nombre,tamaño,tipo, tiempo);
        documentos.add(documento);
        Prueba.add(documentos);
        documento.listaGeneral.add(documentos);
        
        System.out.println (documento.listaGeneral);
        
        
    } 
    public void AñadirDocumentoUser(String propietario, String nombre, String tamaño, String tipo, String tiempo){
        
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
    
}
    
   
