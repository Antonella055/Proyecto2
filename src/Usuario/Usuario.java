/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Estructuras.ArrayList;
import interfaces.GestionDoc.CrearDocumento;

/**
 *
 * @author Antonella
 */
public class Usuario {
    
    
    //Crear documento
    public void crearDocumento(String nombre, String tamaño, String tipo){
        CrearDocumento doc= new CrearDocumento();
        ArrayList<Documento> documentos= new ArrayList<>();
        
        
        
        Documento documento= new Documento(nombre,tamaño,tipo);
        documentos.add(documento);
        documento.listaGeneral.add(documentos);
        System.out.println (documento.listaGeneral);
        
    }
}
    
   
