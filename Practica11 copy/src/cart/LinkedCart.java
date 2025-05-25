package cart;

public class LinkedCart {

    private CartItemNode first; 
    private int size; 

    public LinkedCart() {
        this.first = null; 
        this.size = 0; 
    }

    public boolean isEmpty() {
        return size == 0; 
    }

    public int size() {
        return size;
    }
    // Moved CartItemNode to an inner class with 'dato' and 'siguiente' fields
        private static class CartItemNode {
            private CartItem dato;
            private CartItemNode siguiente;
    
            public CartItemNode(CartItem dato) {
                this.dato = dato;
                this.siguiente = null;
            }
    
            public CartItem getDato() {
                return dato;
            }
    
            public CartItemNode getSiguiente() {
                return siguiente;
            }
    
            public void setSiguiente(CartItemNode siguiente) {
                this.siguiente = siguiente;
            }
        }
    // Buscar posición por nombre y talla (char)
    public int find(String itemName, char sizeChar) {
        CartItemNode current = first;
        int index = 0;
        while (current != null) {
            CartItem item = current.getDato();
            if (item.getClothingItem().getName().equals(itemName) && item.getClothingItem().getSize() == sizeChar) {
                return index;
            }
            current = current.getSiguiente();
            index++;
        }
        return -1;
    }

    // Buscar CartItem por índice
    public CartItem find(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        CartItemNode current = first;
        int pos = 0;
        while (current != null) {
            if (pos == index) {
                return current.getDato();
            }
            current = current.getSiguiente();
            pos++;
        }
        return null;
    }

    // Insertar un elemento en una posición dada
    public void insert(int index, CartItem item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        CartItemNode nuevo = new CartItemNode(item);
        if (index == 0) {
            nuevo.setSiguiente(first);
            first = nuevo;
        } else {
            CartItemNode actual = first;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
        size++;
    }

    // Eliminar un CartItem en la posición i y devolverlo
    public CartItem remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        CartItem eliminado;
        if (index == 0) {
            eliminado = first.getDato();
            first = first.getSiguiente();
        } else {
            CartItemNode actual = first;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.getSiguiente();
            }
            eliminado = actual.getSiguiente().getDato();
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
        }
        size--;
        return eliminado;
    }
}