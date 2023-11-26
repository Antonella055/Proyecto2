/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import MonticuloBinario.Constructor;

/**
 *
 * @author luciano
 */
// Java program to design HashMap


public class MyHashMap {
    private class Node {
        Constructor value;
        Node left;
        Node right;

        public Node(Constructor value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node[] mapArray;

    public MyHashMap() {
        mapArray = new Node[1000001];
        fillArray(mapArray, null);
    }

    private void fillArray(Node[] array, Node value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    public void put(int key, Constructor value) {
        Node newNode = new Node(value);
        mapArray[key] = newNode;
    }

    public Constructor get(int key) {
        Node node = mapArray[key];
        if (node != null) {
            return node.value;
        }
        return null;
    }

    public void remove(int key) {
        mapArray[key] = null;
    }

    public void setLeft(int key, Constructor left) {
        Node node = mapArray[key];
        if (node != null) {
            node.left = new Node(left);
        }
    }

    public void setRight(int key, Constructor right) {
        Node node = mapArray[key];
        if (node != null) {
            node.right = new Node(right);
        }
    }

    public Constructor getLeft(int key) {
        Node node = mapArray[key];
        if (node != null && node.left != null) {
            return node.left.value;
        }
        return null;
    }

    public Constructor getRight(int key) {
        Node node = mapArray[key];
        if (node != null && node.right != null) {
            return node.right.value;
        }
        return null;
    }
}