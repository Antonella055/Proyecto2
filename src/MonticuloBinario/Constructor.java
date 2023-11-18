/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MonticuloBinario;

/**
 *
 * @author Antonella
 */
public class Constructor {
    private int[] heap; //vector para guardar los datos
    private int  tamano;  //cantidad de elementos en el heap
    
    public Constructor (int Tmaximo){ //heap vacio
        this.tamano=0;
        heap= new int[Tmaximo];
    }
    
    
    public Constructor (int[] arreglo){ //crear heap 
        this.tamano=arreglo.length;
        heap= arreglo;
        ConstruirHeap();
    }
    
    public int Tamano(){
        return tamano;
    }
    
    //Nodo raiz
    private int padre (int posicion){
        return (posicion/2);
    }
    //Nodo hijo izquierdo 
    private int hijoIzq(int posicion){
        return (2*posicion);
    }
    //Nodo hijo derecho
    private int hijoDer(int posicion){
        return ((2*posicion)+1);
    }
    
    
    public void Insertar(int elemento){
        if(tamano ==heap.length)
            throw new IllegalStateException("Esta lleno");
        else{
            int pActual= tamano;
            heap[pActual]= elemento;
            tamano++;
            
            while (heap[pActual] < heap[padre(pActual)])
                intercambiar(pActual, padre(pActual));
                pActual= padre(pActual);
        }
    }
    
    public void ConstruirHeap(){
        for (int i=tamano/2; i>0;i--){
            Amontonar(i,tamano-1);
        }
    }
    private void Amontonar (int i, int j){
        if ((hijoIzq(i) <= j)){ 
            //K almacena la posicion del elem que subira 
            int k;
            if (hijoDer(i) <= heap[hijoIzq(i)]){
                k= hijoDer(i);
            }else{ //solo tiene hijo izq
                k=hijoIzq(i);
            }
            
            if (heap[i] > heap[k]){
                intercambiar(k,j);
                Amontonar(k,j);
                
            }
        }
    }
        private void intercambiar (int i,int j){
            int temp= heap[1];
            heap[i]= heap[j];
            heap[j]=temp;
    }
        
        public int getMinimo(){
            return heap[0];
        }
        
        public void verArreglo(){
            System.out.println ("Arreglo");
            for (int i=0; i<heap.length;i++)
                System.out.print(heap[i]+"|");
            System.out.println("");
        }
         public void verArbol(){
            System.out.println ("Arbol");
            for (int i=0; i<tamano/2;i++)
                System.out.print("Padre: " +heap[i]
                                        +"Hijo izqu:"+heap[2* i+1]
                                         +"Hijo Der:"+heap[2* i+2]);
            System.out.println("");
        }
}
