/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mx.itson.algoritmo.ui;

import mx.itson.algoritmo.business.Ordenamientos;
import static mx.itson.algoritmo.business.Ordenamientos.printArray;

/**
 *
 * @author pedrizquierdo
 */
public class main {
    
    
    public static void main(String args[]){
        int arr[] = { 23, 41, 34, 15, 9, 29 };
        int n = arr.length;
        Ordenamientos.selectionSort(arr);
        System.out.println("Lista Ordenada: ");
        printArray(arr, n);
    }
}
