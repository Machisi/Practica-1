package shop;

public class ClothingItem {
    // Variables
    private String name;
    private double price;
    private char size;

    // Constructor
    public ClothingItem(String name, double price, char size) {
        this.name = name;
        this.price = price;
        
        if (size == 'S' || size == 'M' || size == 'L') {
            this.size = size;
        } else {
            this.size = 'S';
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public char getSize() {
        return size;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(char size) {
        if (size == 'S' || size == 'M' || size == 'L') {
            this.size = size;
        } else {
            System.out.println("Talla invalida.");
        }
    }

    @Override
    public String toString() {
        return "ClothingItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }

	public int getUnits() {
		
		return 0;
	}
}