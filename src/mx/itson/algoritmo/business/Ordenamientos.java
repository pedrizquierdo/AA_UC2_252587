/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.algoritmo.business;

/**
 *
 * @author pedrizquierdo
 */
public class Ordenamientos {
    
    public static void bubbleSort(int arr[], int n) {
    int i, j, temp; // 3 asignaciones 
    boolean intercambio; // 1 asignación

    for (i = 0; i < n - 1; i++) { // (n - 1) comparaciones, (n - 1) incrementos
        intercambio = false; // (n - 1) asignaciones
        
        for (j = 0; j < n - i - 1; j++) { 
            if (arr[j] > arr[j + 1]) { // (n-1) + (n-2) + ... + 1 = n(n-1)/2 comparaciones
                
                // Intercambio de elementos
                temp = arr[j]; // (n-1)(n-1)/2 asignaciones
                arr[j] = arr[j + 1]; // (n-1)(n-1)/2 asignaciones
                arr[j + 1] = temp; // (n-1)(n-1)/2 asignaciones
                intercambio = true; // (n-1)(n-1)/2 asignaciones
            }
        }
        
        if (intercambio == false) // (n - 1) comparaciones
            break; // (posible 1 vez, pero no siempre)
    }
}
    
    
// Expresión algebraica total: 4 + 4(n−1) + 5((n(n-1))/2) 
 
// Complejidad temporal: O(n^2)
    
    
    
    public static void selectionSort(int arr[]) {
       int i, j, temp;  // 3 asignaciones: i, j, temp → 3
       int n = arr.length; // 1 asignación

       for(i = 0; i < n - 1; i++) { // (n-1) asignaciones + (n-1) comparaciones + (n-1) incrementos
           int min = i; // (n-1) asignaciones

           for(j = i + 1; j < n; j++) { // (n(n-1)/2) asignaciones + (n(n-1)/2) comparaciones + (n(n-1)/2) incrementos
                if (arr[j] < arr[min]) { // (n(n-1)/2) comparaciones
                    min = j; // En el peor de los casos (n(n-1)/2) asignaciones
                }
           }
           temp = arr[i]; // (n-1) asignaciones
           arr[i] = arr[min]; // (n-1) asignaciones
           arr[min] = temp; // (n-1) asignaciones
       }
}

// Expresión algebraica total: 4 + 5(n−1) + ((3n(n - 1))/2)
 
// Complejidad temporal: O(n^2)
    
    
    public static void printArray(int arr[], int size){
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

   
    
}
