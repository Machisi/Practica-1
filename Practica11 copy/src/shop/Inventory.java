package shop;

public class Inventory {
    // Variables
    private ClothingItem[] items;
    private int itemLength;
    private int MAX_SIZE;

    // Constructor
    public Inventory(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        this.items = new ClothingItem[MAX_SIZE];
        this.itemLength = 0;
    }

    // Getters
    public ClothingItem[] getItems() {
        return items;
    }

    public int getItemLength() {
        return itemLength;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    // Setters
    public void setItems(ClothingItem[] items) {
        this.items = items;
    }

    public void setItemLength(int itemLength) {
        this.itemLength = itemLength;
    }

    public void setMAX_SIZE(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    public int getItemCount() {
        return itemLength;
    }

    public void addItem(ClothingItem item) {
        if (itemLength < MAX_SIZE) {
            items[itemLength] = item;
            itemLength++;
            System.out.println("Prenda añadida al inventario correctamente.");
        } else {
            System.out.println("Inventario lleno.");
        }
    }

    public int checkStock(String name, char size) {
        int stock = 0;

        for (int i = 0; i < itemLength; i++) {
            if (items[i].getName().equals(name) && items[i].getSize() == size) {
                stock++;
            }
        }

        return stock;
    }

    public void removeItem(String name, char size) {
        if (checkStock(name, size) > 0) {
            int position = -1;
            for (int i = 0; i < itemLength; i++) {
                if (items[i].getName().equals(name) && items[i].getSize() == size) {
                    position = i;
                    break;
                }
            }
            
            for (int i = position; i < itemLength - 1; i++) {
                items[i] = items[i + 1];
            }
            
            items[itemLength - 1] = null;
            
            itemLength--;
        }
    }

    public ClothingItem extractItem(String name, char size) {
        if (checkStock(name, size) > 0) {
            ClothingItem foundItem = null;
            int position = -1;
            
            for (int i = 0; i < itemLength; i++) {
                if (items[i].getName().equals(name) && items[i].getSize() == size) {
                    foundItem = items[i];
                    position = i;
                    break;
                }
            }
            
            for (int i = position; i < itemLength - 1; i++) {
                items[i] = items[i + 1];
            }
            
            items[itemLength - 1] = null;
            itemLength--;
            
            System.out.println("Prenda '"+ name + "' (Talla " + size + ") extraida correctamente del inventario.");
            
            return foundItem;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Invetario: => itemLength="+ itemLength + ", MAX_SIZE="+ MAX_SIZE + "\n\n");
        
        if (itemLength > 0) {
            sb.append("Nombre\t\tPrecio\t\tTalla\n");
            sb.append("------------------------------------------------\n");
            
            for (int i = 0; i < itemLength; i++) {
                ClothingItem item = items[i];
                sb.append(item.getName()).append("\t\t")
                  .append(item.getPrice()).append("€\t\t")
                  .append(item.getSize()).append("\n");
            }
        } else {
            sb.append("Inventario vacío.\n");
        }
        
        return sb.toString();
    }

	public ClothingItem getClothingItem(String itemName, char sizeChar) {
		return null;
	}
}