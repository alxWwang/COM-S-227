package learnJava;

import java.awt.Rectangle;

public class rectangleTest {
	
	  public class SimpleRectangleTest {

	}

	public static void main(String[] args)
	  {
	    // Declare a Rectangle variable. This could refer to a Rectangle
	    // object, but initially it doesn't refer to anything.
	    Rectangle r;

	    // Construct a Rectangle object with width 10 and height 20
	    r = new Rectangle(10, 20);
	    
	    // Call some accessor methods to examine its state
	    System.out.println("First Rectangle width and height");
	    System.out.println(r.getWidth());
	    System.out.println(r.getHeight());
	    
	    // Create another rectangle object
	    Rectangle r2 = new Rectangle(2, 3);
	    System.out.println("Second Rectangle width and height");
	    System.out.println(r2.getWidth());
	    System.out.println(r2.getHeight());

	    // Call a mutator method to modify the state of r
	    r.grow(2, 0);
	    
	    // Accessor methods again...
	    System.out.println("First Rectangle after grow(2, 0)");
	    System.out.println(r.getWidth());
	    System.out.println(r.getHeight());
	    
	    // But r2 stays the same
	    System.out.println("Second Rectangle width and height");
	 
	    System.out.println(r2.getWidth());
	    System.out.println(r2.getHeight());
	    
	    // (***) Uncomment these lines for the participation activity below
	   //  Rectangle r3;
	   //  r3 = r2;
	   //  r3.grow(1, 1);
	    
	    // Check r2 again
	    System.out.println("Second Rectangle width and height");
	    System.out.println(r2.getWidth());
	    System.out.println(r2.getHeight());
	  }
}
	

