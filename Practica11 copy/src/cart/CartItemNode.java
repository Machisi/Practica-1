package cart;

public class CartItemNode {

    private int dato; 
    private CartItemNode next; 

    public CartItemNode(int dato) {
        this.dato = dato; 
        this.next = null; 
    }
    
    public CartItemNode(int dato, CartItemNode next) {
        this.dato = dato; 
        this.next = next;  
    }

    public int getDato() {
        return dato;
    }
    public void setDato(int dato) {
        this.dato = dato; 
    }
    public CartItemNode getNext() {
        return next; 
    }
    public void setNext(CartItemNode next) {
        this.next = next; 

    }
}
