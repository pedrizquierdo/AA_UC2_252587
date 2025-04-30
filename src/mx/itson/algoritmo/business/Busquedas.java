/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.algoritmo.business;

/**
 *
 * @author pedrizquierdo
 */
public class Busquedas {
    
    public int busquedaBinaria(int[] A, int clave) {
   int izquierda = 0;
   int derecha = A.length - 1;

   while (izquierda <= derecha) {
       int medio = (izquierda + derecha) / 2;

       if (A[medio] == clave) {
           return medio; // ¡Encontrado!
       } else if (A[medio] < clave) {
           izquierda = medio + 1; // Buscar en la mitad derecha
       } else {
           derecha = medio - 1; // Buscar en la mitad izquierda
       }
   }

   return -1; // No se encontró
}

}
