/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author luciano
 */
import java.util.Arrays;

public class ArrayList<E>{
    private final int DEFAULT_SIZE=2;
    private Object[] myData = new Object[DEFAULT_SIZE];
    private int actSize=0;

    public boolean add(E data){
        if (actSize>=myData.length/2){
            increaseSize();
        }
        myData[actSize++] = data;
        return true;
    }

    private void increaseSize()throws RuntimeException{
        myData = Arrays.copyOf(myData, myData.length*2);
    }

    public E get(int index) throws RuntimeException{
        if (index >= actSize){
            throw new IndexOutOfBoundsException(); 
        }
        return (E) myData[index];
    }}
