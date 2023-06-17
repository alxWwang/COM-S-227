package learnJava;

import java.util.Random;

public class birthday {
	public static void main(String[] args ) {
		Random rand = new Random();
		
		int x;
		int y;
		
		x = rand.nextInt(29) + 1;
		y = rand.nextInt(99) + 1900;
		
		
		System.out.println("September " + x + ", " + y);
	}
}
