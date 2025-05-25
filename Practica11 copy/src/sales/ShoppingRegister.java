package sales;

import cart.LinkedCart;
import cart.CartItem;
import shop.Inventory;
import shop.ClothingItem;

public class ShoppingRegister {
    private static LinkedCart cart;
    
    public ShoppingRegister() {
    	cart = new LinkedCart();
    }
    
    public static void addToCart(Inventory inventory, String itemName, char size, int quantity) {
    	if (inventory.checkStock(itemName, size) >= quantity) {
    		for (int i = 0; i < quantity; i++) {
    			ClothingItem clothing = inventory.extractItem(itemName, size);
    			if (cart == null) {
    				cart = new LinkedCart();
    			}
    			int currentIndex = cart.find(itemName, size);
    			if (currentIndex == -1) {
    				CartItem ci = new CartItem(clothing, 1);
    				cart.insert(0, ci);
    			} else {
    				CartItem ci = cart.find(currentIndex);
    				ci.setUnits(ci.getUnits() + 1);
    			}
    		}
    		System.out.println("Añadido al carrito correctamente");
    	} else {
    		System.out.println("No hay stock disponible");
    	}
    }
    
    public static void removeFromCart(Inventory inventory, String itemName, char size, int quantity) {
    	int index = cart.find(itemName, size);
    	if (index == -1) {
    		System.out.println("El producto no se encuentra en el carrito.");
    		return;
    	}
    	
    	CartItem ci = cart.find(index);
    	ClothingItem clothing = ci.getClothingItem();
    	if (ci.getUnits() < quantity) {
    		System.out.println("No tienes unidades suficientes en el carrito.");
    		return;
    	} else if (ci.getUnits() == quantity) {
    		cart.remove(index);
    	} else {
    		ci.setUnits(ci.getUnits() - quantity);
    	}
    	
    	for (int i = 0; i < quantity; i++) {
			inventory.addItem(clothing);
		}
    	
    	System.out.println("Eliminado del carrito correctamente");
    }
    
    public static void confirmCart(Inventory inventory) {
    	double totalPrice = 0;
    	StringBuilder sb = new StringBuilder();
    	sb.append("\nNombre\tTalla\tPrecio Unidad\tUnidades\tCoste Total\n\n");
    	while (cart.find(0) != null) {
    		CartItem ci = cart.find(0);
    		ClothingItem clothing = ci.getClothingItem(); 
    		double cost = clothing.getPrice() * ci.getUnits();
    		totalPrice += cost;
    		for (int i = 0; i < ci.getUnits(); i++) {
    			inventory.addItem(clothing);
    			SalesRegister.processSale(inventory, clothing.getName(), clothing.getSize());
    		}
    		sb.append(clothing.getName()).append("\t")
    		.append(clothing.getSize()).append("\t")
    		.append(clothing.getPrice()).append("€\t\t")
    		.append(ci.getUnits()).append("\t\t")
    		.append(String.format("%.2f", cost)).append("€\n");
    		cart.remove(0);
    	}
    	sb.append("\nEl coste total del pedido es: " + String.format("%.2f", totalPrice) + "€");
    	System.out.println(sb);
    }
    
    public static void showCart() {
    	if (cart.size() == 0) {
    		System.out.println("El carrito esta vacio.");
    		return;
    	}
    	
    	double totalPrice = 0;
    	StringBuilder sb = new StringBuilder();
    	sb.append("\nNombre\tTalla\tPrecio Unidad\tUnidades\tCoste Total\n\n");
    	for (int i = 0; i < cart.size(); i++) {
    		CartItem ci = cart.find(i);
    		ClothingItem clothing = ci.getClothingItem(); 
    		double cost = clothing.getPrice() * ci.getUnits();
    		totalPrice += cost;
    		sb.append(clothing.getName()).append("\t")
    		.append(clothing.getSize()).append("\t")
    		.append(clothing.getPrice()).append("€\t\t")
    		.append(ci.getUnits()).append("\t\t")
    		.append(String.format("%.2f", cost)).append("€\n");
    	}
    	sb.append("\nEl precio total del pedido es: " + String.format("%.2f", totalPrice) + "€");
    	System.out.println(sb);
    }
}