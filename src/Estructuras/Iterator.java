/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.NoSuchElementException;

/**
 *
 * @author Antonella
 */
public class Iterator<E> {
    private ArrayList<E> elementos;
    private int indice;

    public Iterator(ArrayList<E> elementos, int indice) {
        this.elementos = elementos;
        this.indice = 0;
    }
    
    public boolean hasNext(){
        return indice < elementos.size();
    }
    
    public E next(){
        if (!hasNext()){
             throw new NoSuchElementException();
        }return elementos.get(indice++);
    }
    
}
