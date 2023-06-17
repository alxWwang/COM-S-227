package learnJava;



public class InventoryTag {
	private int quantityRemaining;

	   public InventoryTag() {
	      quantityRemaining = 0;
	   }

	   public int getQuantityRemaining() {
	      return quantityRemaining;
	   }

	   public void addInventory(int numItems) {
	      if (numItems > 10) {
	         quantityRemaining = quantityRemaining + numItems;
	      }
	   }
}

