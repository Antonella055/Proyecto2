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
public class Documento {
    private String nombre;
    private String tamano;
    private String tipo;
    private String prioridad;
    public ArrayList<ArrayList<Documento>> listaGeneral;

    public Documento(String nombre, String tamano, String tipo) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.tipo = tipo;
        
    }
}
