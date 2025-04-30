/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mx.itson.algoritmo.ui;

import mx.itson.algoritmo.business.Nodo;


/**
 *
 * @author pedrizquierdo
 */
public class main {
    
    
    public static void main(String args[]){
        
        Nodo arbol = new Nodo(0); 

        // a. Inserción de los valores en el árbol
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int valor : valores) {
            arbol = arbol.insertar(arbol, valor); 
        }

        // b. Imprimir el recorrido inorden antes de eliminar
        System.out.print("Recorrido inorden antes de eliminar: ");
        arbol.inorden(arbol); 
        System.out.println();

        // c. Eliminar el nodo con valor 50
        System.out.println("Eliminando el nodo con valor 50...");
        arbol = arbol.eliminar(arbol, 50); 
        // - El nodo con valor 50 tiene dos hijos: 30 a la izquierda y 70 a la derecha.
        // - Se encuentra el sucesor (el valor mínimo del subárbol derecho), que es 60.
        // - El valor 50 es reemplazado por 60, y luego se elimina el nodo 60 de su ubicación original.
        // Esto garantiza que el árbol sigue siendo un árbol binario de búsqueda válido.


        // d. Imprimir el recorrido inorden después de eliminar
        System.out.print("Recorrido inorden después de eliminar 50: ");
        arbol.inorden(arbol); 
        System.out.println();

        // e. Realizar búsquedas
        int[] claves = {30, 50, 60};
        for (int clave : claves) {
            boolean encontrado = arbol.buscar(arbol, clave); 
            System.out.println("¿Valor " + clave + " encontrado? " + (encontrado ? "Sí" : "No"));
        }
    }
}
