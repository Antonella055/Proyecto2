/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MonticuloBinario;


/**
 *
 * @author Antonella
 */
class Constr_monticulo {
    Constructor raiz;

    int nivel(Constructor N) {
        if (N == null) {
            return 0;
        }
        return N.nivel;
    }

    int maximo(int a, int b) {  //cant maxima de niveles
        return (a > b) ? a : b;
    }

    Constructor rotarDerecho(Constructor nodoY) {
        Constructor x = nodoY.left;
        Constructor T2 = x.right;
        x.right = nodoY;  //subárbol derecho de x como nodoY
        nodoY.left = T2; //subárbol izquierdo de nodoY como T2
        nodoY.nivel = maximo(nivel(nodoY.left), nivel(nodoY.right)) + 1;  //Actualiza los niveles de x y nodoY de acuerdo a las alturas de sus subárboles
        x.nivel = maximo(nivel(x.left), nivel(x.right)) + 1;
        return x; //Devuelve x, que ahora es la nueva raíz del subárbol rotado
    }

    Constructor rotarIzquierdo(Constructor nodoX) {
        Constructor y = nodoX.right;
        Constructor T2 = y.left;
        y.left = nodoX;
        nodoX.right = T2;
        y.nivel = maximo(nivel(nodoX.left), nivel(nodoX.right)) + 1;
        nodoX.nivel = maximo(nivel(y.left), nivel(y.right)) + 1;
        return y;
    }

    //Obtener balance
    int getFactorBalance(Constructor N) {
        if (N == null) {
            return 0;
        }
        return nivel(N.left) - nivel(N.right);
    }

    //Insertar nodo
    Constructor insertar(Constructor nodo, String username, int prioridad) {
        {
            if (nodo == null) {
                return new Constructor(username, prioridad);
            }
            if (prioridad < nodo.prioridad) {
                nodo.left = insertar(nodo.left, username, prioridad); //Se inserta al lado izquierdo de la raiz
            } else if (prioridad > nodo.prioridad) {
                nodo.right = insertar(nodo.right, username, prioridad); //Se inserta al lado Derecho de la raiz
                
            } else //si hay mas de un usuario en una prioridad se compara por el orden en que este registrado
            if (username.compareTo(nodo.username) < 0) {
                nodo.left = insertar(nodo.left, username, prioridad);
            } else {
                nodo.right = insertar(nodo.right, username, prioridad);
            }
            //balancear el arbol
            nodo.nivel = 1 + maximo(nivel(nodo.left), nivel(nodo.right));
            int Factorbalance = getFactorBalance(nodo);
            
            if (Factorbalance > 1) {  //el subárbol izquierdo es más alto que el subárbol derecho
                if (prioridad < nodo.left.prioridad) {  
                    return rotarDerecho(nodo);
                } else if (prioridad > nodo.left.prioridad) { 
                    nodo.left = rotarIzquierdo(nodo.left);
                    return rotarDerecho(nodo);  
                }
            }
            if (Factorbalance < -1) { //el subárbol derecho es más alto que el subárbol izquierdo
                if (prioridad > nodo.right.prioridad) {
                    return rotarIzquierdo(nodo);
                } else if (prioridad < nodo.right.prioridad) {
                    nodo.right = rotarDerecho(nodo.right);
                    return rotarIzquierdo(nodo);
                }
            }
            return nodo;
        }
    }
    //Obtener el nodo con el valor mínimo en el subárbol definido por el nodo pasado como parámetro.
    Constructor minimo(Constructor nodo) { 
        Constructor current = nodo;
        while (current.left != null) {
            current = current.left; //current va recorriendo el subárbol izquierdo del nodo
        }
        return current;
    }

    Constructor EliminarConstructor(Constructor raiz, int prioridad) {
        if (raiz == null) {
            return raiz;
        }
        if (prioridad < raiz.prioridad) {
            raiz.left = EliminarConstructor(raiz.left, prioridad);
        } else if (prioridad > raiz.prioridad) {
            raiz.right = EliminarConstructor(raiz.right, prioridad);
        } else {
            //la prioridad es igual a la prioridad del nodo actual
            if ((raiz.left == null) || (raiz.right == null)) { //verificar si el nodo tiene un hijo
                Constructor temp = null;
                if (temp == raiz.left) {
                    temp = raiz.right;
                } else {
                    temp = raiz.left;
                }
                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else {
                    raiz = temp;
                }
            } else { //el nodo tiene dos hijos
                Constructor temp = minimo(raiz.right);
                raiz.username = temp.username;
                raiz.prioridad = temp.prioridad;
                raiz.right = EliminarConstructor(raiz.right, temp.prioridad);
            }
        }
        if (raiz == null) {
            return raiz;
        }
        raiz.nivel = maximo(nivel(raiz.left), nivel(raiz.right)) + 1;
        int Factorbalance = getFactorBalance(raiz);
        
        if (Factorbalance > 1) {
            if (getFactorBalance(raiz.left) >= 0) {
                return rotarDerecho(raiz);
            } else {
                raiz.left = rotarIzquierdo(raiz.left);
                return rotarDerecho(raiz);
            }
        }
        if (Factorbalance < -1) {
            if (getFactorBalance(raiz.right) <= 0) {
                return rotarIzquierdo(raiz);
            } else {
                raiz.right = rotarDerecho(raiz.right);
                return rotarIzquierdo(raiz);
            }
        }
        return raiz;
    }

    void preOrder(Constructor nodo) {
        if (nodo != null) {
            System.out.print(nodo.username + " ");
            preOrder(nodo.left);
            preOrder(nodo.right);
        }
    }

    public void printMonticulo(Constructor currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.username + " (Priority: " + currPtr.prioridad + ")");
            printMonticulo(currPtr.left, indent, false);
            printMonticulo(currPtr.right, indent, true);
        }
    }

    
}
