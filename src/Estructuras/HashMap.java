/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author luciano
 */
// Java program to design HashMap


 
class MyHashMap {
    int[] mapArray;

    public MyHashMap() {
        mapArray = new int[1000001];
        fillArray(mapArray, -1);
    }

    private void fillArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    public void put(int key, int value) {
        mapArray[key] = value;
    }

    public int get(int key) {
        return mapArray[key];
    }

    public void remove(int key) {
        mapArray[key] = -1;
    }
}