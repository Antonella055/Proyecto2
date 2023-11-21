/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Estructuras.ArrayList;

/**
 *
 * @author Antonella
 */
public class Usuario {
    private String nombreUsuario;
    private ArrayList<Documento> documentos;

    public Usuario(String nombreUsuario, ArrayList<Documento> documentos) {
        this.nombreUsuario = nombreUsuario;
        this.documentos = new ArrayList<>();
    }
    
    //Crear documento
    public void crearDocumento(Documento nombre, Documento tamaño, Documento tipo){
    }
    
    //agregar a los documentos del usuario
    public void agregarDoc(Documento documento){
        documentos.add(documento);
    }
    
    public ArrayList <Documento> getDocumentos(){
        return documentos;
    }
    
    public void eliminarDocumento(Documento documento){
        documentos.remove(documento);
    }
}
