/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author luciano
 * @param <E>
 */

public class ArrayList<E>{
    private Object[] elementos;
    private int size;
    private static final int CAPACIDAD_INICIAL = 10;

    public ArrayList(Object[] elementos, int size) {
        this.elementos = new Object[CAPACIDAD_INICIAL];
        this.size = size;
    }

    public boolean add(E elemento){
        if (size == elementos.length) {
            increaseSize();
        }
        elementos[size] = elemento;
        size++;
        return false;
    }
    
    
    private void increaseSize()throws RuntimeException{
        int nuevaCapacidad= elementos.length*2;
        Object[] nuevoarray= new Object[nuevaCapacidad];
        for (int i=0; i< size; i++){
            nuevoarray[i]=elementos[i];
        }
        elementos= nuevoarray;
    }

    public E get(int indice ) throws RuntimeException{
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return (E) elementos[indice];
    }
    
    
    public boolean remove(  E elemento ) throws RuntimeException {
       int indice = -1;
        for (int i = 0; i < size; i++) {
            if (elementos[i].equals(elemento)) {
                indice = i;
                break;
            }
        }
        if (indice != -1) {
            for (int i = indice; i < size - 1; i++) {
                elementos[i] = elementos[i + 1];
            }
            elementos[size - 1] = null;
            size--;
     
    }
        return false;
    
    }
    public int size() {
    return size;
}
}

