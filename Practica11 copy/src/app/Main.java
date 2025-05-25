package app;

import java.util.*;

import shop.ClothingItem;
import shop.Inventory;
import sales.SalesRegister;
import sales.ShoppingRegister;

import test.TestClothingItem;
import test.TestInventory;
import test.TestLinkedCart;
import test.TestSalesRegister;
import test.TestShoppingRegister;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Inventory inv = new Inventory(100);
	
    public static void main(String[] args) {
    	int option = 0;

    	do {
    		try {
    			option = menu();
    		} catch(Exception e) {};
    		switch(option) {
    			case 1:
    				addNewCloth();
    				break;
    			case 2:
    				System.out.println(inv.toString());
    				break;
    			case 3:
    				processSell();
    				break;
    			case 4:
    				salesStats();
    				break;
    			case 5:
    				addToCart();
    				break;
    			case 6:
    				removeFromCart();
    				break;
    			case 7:
    				confirmCart();
    				break;
    			case 8:
    				showCart();
    				break;
    			case 9:
    				System.out.println("Adiós");
    				break;
    			case 0:
    				testing();
    				break;
    			default:
    				System.out.println("Opción no valida.");
    				break;
    		}
    	} while (option != 9);

        
    }
    
    
    public static int menu() {
    	String menuStr = "\n Seleccione una de las siguientes opciones:\n"
    			+ "1. Agregar nueva prenda al inventario\n"
    			+ "2. Mostrar el inventario\n"
    			+ "3. Procesar venta\n"
    			+ "4. Mostrar estadísticas de ventas\n"
    			+ "5. Agregar prenda al carrito\n"
    			+ "6. Eliminar prenda del carrito\n"
    			+ "7. Confirmar carrito de compra\n"
    			+ "8. Mostrar los productos del carrito\n"
    			+ "9. Salir\ns"
    			+ "Seleccione una opción (1-9):";
    	int input = -1;
    	
    	System.out.print(menuStr);
    	try {
    		input = sc.nextInt();
    		sc.reset();
    	} catch (Exception e ) {
    		sc.reset();
    		return -1;
    	};
    	
    	
    	if (input >= 0 && input <= 9) {
    		return input;
    	} 
    	
    	return -1;
    }
    
    public static void addNewCloth() {
    	System.out.print("\nIntroduce los detalles de la prenda:\nNombre: ");
    	String name = sc.next();
    	System.out.print("Precio: ");
    	double price = sc.nextDouble();
    	char talla = ' ';
    	
    	do {
    		System.out.print("Talla (S/M/L): ");
        	talla = sc.next().strip().toUpperCase().charAt(0);
        	System.out.println("");
    	} while (talla != 'S' && talla != 'M' && talla != 'L');
    	
    	try {
    		ClothingItem ci = new ClothingItem(name, price, talla);
    		inv.addItem(ci);
    	} catch (Exception e) {
    		System.out.println("Error al añadir una prenda");
    	};
    }
    
    public static void processSell() {
    	System.out.print("\nIntroduce los detalles de la prenda a vender:\nNombre: ");
    	String name = sc.next();
    	char talla = ' ';
    	
    	do {
    		System.out.print("Talla (S/M/L): ");
        	talla = sc.next().strip().toUpperCase().charAt(0);
        	System.out.println("");
    	} while (talla != 'S' && talla != 'M' && talla != 'L');
    	
    	try {
    		SalesRegister.processSale(inv, name, talla);
    	} catch(Exception e) {};
    }
    
    public static void salesStats() {
    	System.out.println(SalesRegister.getBalance());
    }
    
    public static void addToCart() {
    	System.out.print("\nIntroduce los detalles de la prenda que se desea añadir al carrito:\nNombre: ");
    	String name = sc.next();
    	char talla = ' ';
    	int unidades = 0;
    	
    	do {
    		System.out.print("Talla (S/M/L): ");
        	talla = sc.next().strip().toUpperCase().charAt(0);
        	System.out.println("");
    	} while (talla != 'S' && talla != 'M' && talla != 'L');
    	
    	System.out.print("Unidades: ");
    	unidades = sc.nextInt();
    	
    	ShoppingRegister.addToCart(inv, name, talla, unidades);
    }
    
    public static void removeFromCart() {
    	System.out.print("\nIntroduce los detalles de la prenda que se desea quitar del carrito:\nNombre: ");
    	String name = sc.next();
    	char talla = ' ';
    	int unidades = 0;
    	
    	do {
    		System.out.print("Talla (S/M/L): ");
        	talla = sc.next().strip().toUpperCase().charAt(0);
        	System.out.println("");
    	} while (talla != 'S' && talla != 'M' && talla != 'L');
    	
    	System.out.print("Unidades: ");
    	unidades = sc.nextInt();
    	
    	ShoppingRegister.removeFromCart(inv, name, talla, unidades);
    }
    
    public static void confirmCart() {
    	ShoppingRegister.confirmCart(inv);
    }
    
    public static void showCart() {
    	ShoppingRegister.showCart();
    }
    
    public static void testing() {
    	ClothingItem item1 = new ClothingItem("Camisa", 25.99, 'M');
    	if (item1 != null) {
    		TestClothingItem.checkClass(item1.getClass());
    	}
    	
    	Inventory inventory = new Inventory(100);
    	if (inventory != null) {
    		TestInventory.checkClass(inventory.getClass());
    	}
    	
    	TestSalesRegister.checkSalesRegister();
    	
    	TestLinkedCart.checkLinkedCart();
    	TestShoppingRegister.checkShoppingRegister();
    }
}