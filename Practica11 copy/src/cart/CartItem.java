package cart;

import shop.ClothingItem;

public class CartItem {
	private ClothingItem clothingItem;
	private int units;
	
	public CartItem(ClothingItem clothingItem, int units) {
		this.clothingItem = clothingItem;
		this.units = units;
	}
	
	public void setClothingItem(ClothingItem clothingItem) {
		this.clothingItem = clothingItem;
	}
	
	public ClothingItem getClothingItem() {
		return clothingItem;
	}
	
	public void setUnits(int units) {
		this.units = units;
	}
	
	public int getUnits() {
		return units;
	}
	
	@Override
	public String toString() {
		return(clothingItem.toString() + " Units: " + units);
	}
}
