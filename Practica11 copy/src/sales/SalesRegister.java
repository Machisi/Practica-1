package sales;

import shop.ClothingItem;
import shop.Inventory;

public class SalesRegister {
    private static long totalSalesCount;
    private static double totalSalesAmount;
    
    public SalesRegister() {
        totalSalesCount = 0;
        totalSalesAmount = 0.0;
    }

    public static ClothingItem processSale(Inventory inventory, String name, char size) {
        int stock = inventory.checkStock(name, size);
        
        if (stock > 0) {
            ClothingItem soldItem = inventory.extractItem(name, size);
            totalSalesCount++;
            totalSalesAmount += soldItem.getPrice();
            
            System.out.println("Venta procesada correctamente. Articulo vendido: " + soldItem.toString());
            return soldItem;
        } else {
            System.out.println("Producto no disponible.");
            return null;
        }
    }

    public static long getTotalSalesCount() {
        return totalSalesCount;
    }

    public static double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public static String getBalance() {
        return ("Total de ventas: " + totalSalesCount + "\n" + "Captial total: " + totalSalesAmount);
    }

    public static void resetTotalSalesCount() {
        totalSalesCount = 0;
    }

    public static void resetTotalSalesAmount() {
        totalSalesAmount = 0.0;
    }
}