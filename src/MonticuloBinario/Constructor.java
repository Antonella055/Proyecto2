/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MonticuloBinario;

/**
 *
 * @author Antonella

 */
public class Constructor{
   String username;
   int prioridad;
   int nivel;
   Constructor left,right;
   
   Constructor(String username, int prioridad){
       this.username=username;
       this.prioridad=prioridad;
       nivel=1;
   }
}

        
    
