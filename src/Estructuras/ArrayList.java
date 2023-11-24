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

public class ArrayList<E> {
    private final int DEFAULT_SIZE = 2;
    private Object[] myData = new Object[DEFAULT_SIZE];
    private int actSize = 0;

    public boolean add(E data) {
        if (actSize >= myData.length / 2) {
            increaseSize();
        }
        myData[actSize++] = data;
        return true;
    }

    private void increaseSize() throws RuntimeException {
        Object[] newArray = new Object[myData.length * 2];
        for (int i = 0; i < myData.length; i++) {
            newArray[i] = myData[i];
        }
        myData = newArray;
    }

    public E get(int index) throws RuntimeException {
        if (index >= actSize) {
            throw new IndexOutOfBoundsException();
        }
        return (E) myData[index];
    }

    public boolean remove(E data) throws RuntimeException {
        int index = -1;
        for (int i = 0; i < actSize; i++) {
            if (myData[i].equals(data)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = index; i < actSize - 1; i++) {
            myData[i] = myData[i + 1];
        }
        myData[actSize - 1] = null;
        actSize--;
        return true;
    }

    public int size() {
        return actSize;
    }

    public static void VerArrayDoble(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);

            if (obj instanceof ArrayList) {
                ArrayList<?> innerArrayList = (ArrayList<?>) obj;
                for (int j = 0; j < innerArrayList.size(); j++) {
                    Object a = innerArrayList.get(j);
                    System.out.println(a);
                }
            } else {
                System.out.println(obj.toString());
            }
        }
    }

    public static void VerElemenEspecifico(ArrayList list, int number) {
        System.out.println(list.get(number).toString());
    }
}
