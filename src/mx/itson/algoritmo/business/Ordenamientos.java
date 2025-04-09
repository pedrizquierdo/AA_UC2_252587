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

       for(i = 0; i <= n - 2; i++) { // (n-1) asignaciones + (n-1) comparaciones + (n-1) incrementos
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
    
    
    public static void insertionSort(int arr[]) {
    int i, j, key;
    
    // Bucle externo para recorrer el array desde el segundo elemento hasta el final
    for(i = 1; i < arr.length; i++) { // (n-1) iteraciones
        key = arr[i]; // (n-1) asignaciones
        j = i - 1; // (n-1) asignaciones
        
        // Desplazamiento de elementos mayores que 'key' hacia la derecha
        while (j >= 0 && arr[j] > key) { // En el peor caso, O(n) comparaciones por iteración
            arr[j + 1] = arr[j]; // En el peor caso, O(n) asignaciones por iteración
            j = j - 1; // En el peor caso, O(n) decrementos por iteración
        }
        
        // Coloca 'key' en su posición correcta
        arr[j + 1] = key; // (n-1) asignaciones
    }   
}

/*
    Complejidad de Insertion Sort:
    - En el mejor caso (array ya ordenado): O(n)
    - En el caso promedio: O(n²)
    - En el peor caso (array en orden inverso): O(n²)
*/
  
    // Función de partición que coloca el pivote en su posición correcta
    static int partition(int[] arr, int low, int high) {
        
        // Elegimos el pivote como el último elemento
        int pivot = arr[high]; // 1 asignación
        
        // Índice para elementos menores que el pivote
        int i = low - 1; // 1 asignación
        
        // Recorremos el subarray desde 'low' hasta 'high - 1'
        for (int j = low; j <= high - 1; j++) { // (n-1) asignaciones + (n-1) comparaciones + (n-1) incrementos
            // Si el elemento actual es menor que el pivote
            if (arr[j] < pivot) { // (n-1) comparaciones
                i++; // (n-1) incrementos
                swap(arr, i, j); // En el peor caso (n-1) llamadas a swap
            }
        }
        
        // Colocamos el pivote en su posición correcta
        swap(arr, i + 1, high); // 1 llamada a swap
        return i + 1; // 1 asignación
    }

    // Función para intercambiar dos elementos en un array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; // 1 asignación
        arr[i] = arr[j]; // 1 asignación
        arr[j] = temp; // 1 asignación
    }

    // Implementación del algoritmo QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            
            // Particionamos el array y obtenemos la posición del pivote
            int pi = partition(arr, low, high); // log(n) llamadas en el caso promedio

            // Llamadas recursivas para ordenar las dos mitades
            quickSort(arr, low, pi - 1); // log(n) llamadas en el caso promedio
            quickSort(arr, pi + 1, high); // log(n) llamadas en el caso promedio
        }
    }

    /*
    - Partición: 3 + 3(n-1) + (n-1) + (n-1) ≈ 5(n-1)
    - QuickSort: log(n) * O(n)
    - Complejidad total:
        - Mejor caso: O(n log n)
        - Caso promedio: O(n log n)
        - Peor caso: O(n^2) (cuando la partición es muy desbalanceada)
    */
    
    
    public static void merge(int arr[], int l, int m, int r) {
    // Tamaño de los subarrays temporales
    int n1 = m - l + 1; // 1 asignación
    int n2 = r - m; // 1 asignación

    // Creación de subarrays temporales
    int L[] = new int[n1]; // 1 asignación
    int R[] = new int[n2]; // 1 asignación

    // Copiar datos a los arrays temporales
    for (int i = 0; i < n1; ++i) // n1 asignaciones + n1 comparaciones + n1 incrementos
        L[i] = arr[l + i]; // n1 asignaciones

    for (int j = 0; j < n2; ++j) // n2 asignaciones + n2 comparaciones + n2 incrementos
        R[j] = arr[m + 1 + j]; // n2 asignaciones

    // Fusión de los subarrays ordenados
    int i = 0, j = 0, k = l; // 3 asignaciones
    while (i < n1 && j < n2) { // En el peor caso, (n1 + n2 - 1) comparaciones
        if (L[i] <= R[j]) { // (n1 + n2 - 1) comparaciones
            arr[k] = L[i]; // (n1 + n2 - 1) asignaciones
            i++; // (n1 + n2 - 1) incrementos
        } else {
            arr[k] = R[j]; // (n1 + n2 - 1) asignaciones
            j++; // (n1 + n2 - 1) incrementos
        }
        k++; // (n1 + n2 - 1) incrementos
    }

    // Copiar elementos restantes de L[]
    while (i < n1) { // n1 comparaciones
        arr[k] = L[i]; // n1 asignaciones
        i++; // n1 incrementos
        k++; // n1 incrementos
    }

    // Copiar elementos restantes de R[]
    while (j < n2) { // n2 comparaciones
        arr[k] = R[j]; // n2 asignaciones
        j++; // n2 incrementos
        k++; // n2 incrementos
    }
}

    public static void mergeSort(int arr[], int l, int r) {
    if (l < r) { // log(n) comparaciones
        int m = (l + r) / 2; // log(n) asignaciones

        mergeSort(arr, l, m); // log(n) llamadas recursivas
        mergeSort(arr, m + 1, r); // log(n) llamadas recursivas

        merge(arr, l, m, r ); // O(n) en cada nivel
    }
}

/*
    Complejidad de Merge Sort:
    - merge: O(n) en cada nivel de recursión
    - sort: O(log n) niveles de recursión
    - Complejidad total: O(n log n)

    - Mejor caso: O(n log n)
    - Caso promedio: O(n log n)
    - Peor caso: O(n log n)
*/

    
    public static void printArray(int arr[], int size){
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

   
    
}
