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
    int i, j, temp;
    boolean intercambio; // 1 asignación

    for (i = 0; i < n - 1; i++) { // n - 1, n - 1
        intercambio = false; // n - 1
        
        for (j = 0; j < n - i - 1; j++) { 
            if (arr[j] > arr[j + 1]) { // (n - 1) + (n - 2) + ... + 1 = O(n^2)
                
                // Intercambio de elementos
                temp = arr[j]; // n^2
                arr[j] = arr[j + 1]; // n^2
                arr[j + 1] = temp; // n^2
                intercambio = true; // 1
            }
        }
        
        if (intercambio == false) // n - 1
            break; //
    }
}

// Complejidad temporal: O(n^2)

    
    
    public static void printArray(int arr[], int size){
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

   
    
}
