package learnJava;

import java.util.Scanner;

public class CallInventoryTag {
	public static void main(String [] args) {
		
	      Scanner scnr = new Scanner(System.in);
	      InventoryTag redSweater = new InventoryTag();
	      
	      
	      int sweaterShipment;
	      int sweaterInventoryBefore;

	      sweaterInventoryBefore = redSweater.getQuantityRemaining();
	      sweaterShipment = scnr.nextInt();

	      System.out.println("Beginning tests.");
	      
	      redSweater.addInventory(sweaterShipment);
	      sweaterShipment = redSweater.getQuantityRemaining();
	      
	      if (sweaterShipment != sweaterInventoryBefore ) {
	    	  System.out.println( "TEST FAILED: addInventory()");
	      }
	      // FIXME add unit test for addInventory
	      
	     
	      
	      
	      
	      /* Your solution goes here  */

	      System.out.println("Tests complete.");

}
}
