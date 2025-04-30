/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.algoritmo.business;

/**
 *
 * @author pedrizquierdo
 */
public class Nodo {
    
   int valor; // El dato que guarda el nodo
   Nodo izq;  // Referencia al hijo izquierdo
   Nodo der;  // Referencia al hijo derecho

   // Constructor que inicializa un nodo con el valor dado
   public Nodo(int valor) {
       this.valor = valor;
       this.izq = null;
       this.der = null;
   }
   
   // Inserta un nuevo valor en el árbol binario de búsqueda
   // El valor se inserta en la posición correcta según el orden del árbol
   public Nodo insertar(Nodo nodo, int valor) {
       if (nodo == null) {
           return new Nodo(valor); // Caso base: inserta aquí el nodo
       }

       // Si el valor es menor que el valor del nodo actual, insertamos en el subárbol izquierdo
       if (valor < nodo.valor) {
           nodo.izq = insertar(nodo.izq, valor); // Ir a la izquierda
       } 
       // Si el valor es mayor que el valor del nodo actual, insertamos en el subárbol derecho
       else if (valor > nodo.valor) {
           nodo.der = insertar(nodo.der, valor); // Ir a la derecha
       }

       return nodo; // Devuelve la raíz del subárbol
   }

   // Busca un valor en el árbol binario de búsqueda
   // Devuelve true si el valor está en el árbol, false si no
   public boolean buscar(Nodo nodo, int clave) {
       if (nodo == null) return false; // No encontrado, ya que el nodo es null

       if (clave == nodo.valor) return true; // Encontrado, el valor coincide

       // Si la clave es menor que el valor del nodo, se busca en el subárbol izquierdo
       if (clave < nodo.valor) {
           return buscar(nodo.izq, clave); // Buscar a la izquierda
       } else {
           return buscar(nodo.der, clave); // Buscar a la derecha
       }
   }
   
   // Encuentra el nodo con el valor mínimo en un subárbol
   // Este valor será el más a la izquierda en el árbol
   public Nodo minimo(Nodo nodo) {
       while (nodo.izq != null) {
           nodo = nodo.izq; // Navega hacia la izquierda hasta llegar al nodo más pequeño
       }
       return nodo; // Devuelve el nodo con el valor mínimo
   }

   // Elimina un nodo con un valor específico del árbol
   // Tiene tres casos:
   // 1. Si el nodo tiene dos hijos, reemplaza el valor con el mínimo del subárbol derecho
   // 2. Si el nodo tiene un solo hijo, lo reemplaza por ese hijo
   // 3. Si el nodo no tiene hijos, lo elimina
   public Nodo eliminar(Nodo nodo, int valor) {
       if (nodo == null) return null; // Si el nodo es null, no hay nada que eliminar

       // Busca el nodo a eliminar
       if (valor < nodo.valor) {
           nodo.izq = eliminar(nodo.izq, valor); // Buscar y eliminar en el subárbol izquierdo
       } else if (valor > nodo.valor) {
           nodo.der = eliminar(nodo.der, valor); // Buscar y eliminar en el subárbol derecho
       } else {
           // Caso 1: El nodo tiene dos hijos
           if (nodo.izq == null && nodo.der == null) {
               return null; // Elimina el nodo si no tiene hijos
           }

           // Caso 2: El nodo tiene un solo hijo
           if (nodo.izq == null) return nodo.der; // Reemplaza el nodo por su hijo derecho
           if (nodo.der == null) return nodo.izq; // Reemplaza el nodo por su hijo izquierdo

           // Caso 3: El nodo tiene dos hijos, reemplaza por el sucesor
           Nodo sucesor = minimo(nodo.der); // Encuentra el sucesor (el nodo más pequeño del subárbol derecho)
           nodo.valor = sucesor.valor; // Reemplaza el valor del nodo por el del sucesor
           nodo.der = eliminar(nodo.der, sucesor.valor); // Elimina el sucesor del subárbol derecho
       }

       return nodo; // Devuelve el nodo actualizado después de la eliminación
   }

   // Realiza un recorrido en inorden (orden ascendente) y imprime los valores de los nodos
   // El recorrido inorden visita primero el subárbol izquierdo, luego el nodo actual, y luego el subárbol derecho
   public void inorden(Nodo nodo) {
       if (nodo != null) {
           inorden(nodo.izq);    // Primero, recorre el subárbol izquierdo
           System.out.print(nodo.valor + " "); // Luego, imprime el valor del nodo actual
           inorden(nodo.der);    // Finalmente, recorre el subárbol derecho
       }
   }

}
