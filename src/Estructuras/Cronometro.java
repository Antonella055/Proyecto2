/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import javax.swing.JLabel;

/**
 *
 * @author Antonella
 */
public class Cronometro {
    private long Inicio;
    private long tiempoTranscurrido;
    
    public void iniciar(){
        Inicio= System.currentTimeMillis();
    }
    
    public void detener(){
        long fin = System.currentTimeMillis();
        tiempoTranscurrido= fin - Inicio;
    }
    
    public int obtenerMinutos(){
        return (int) (tiempoTranscurrido /1000/60);
    }
    public int obtenerSegundos() {
        return (int) ((tiempoTranscurrido / 1000) % 60);
        
    } public int obtenerMilisegundos() {
        return (int) (tiempoTranscurrido % 1000);
    }
  
}
