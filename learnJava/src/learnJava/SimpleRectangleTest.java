package learnJava;


public class SimpleRectangleTest{

public static void main(String[] args)
  {
    // Declare a SimpleRectangle variable. This could refer to a SimpleRectangle
    // object, but initially it doesn't refer to anything.
    SimpleRectangle r;

    // Construct a Rectangle object with width 10 and height 20
    r = new SimpleRectangle(10, 20);
    
    // Call some accessor methods to examine its state
    System.out.println("First rectangle width and height");
    System.out.println(r.getWidth());
    System.out.println(r.getHeight());
    System.out.println("Expected 10, 20");
    
    // Create another rectangle object
    SimpleRectangle r2 = new SimpleRectangle(2, 3);
    System.out.println("Second rectangle width and height");
    System.out.println(r2.getWidth());
    System.out.println(r2.getHeight());
    System.out.println("Expected 2, 3");
    // Call a mutator method to modify the state of r
    r.grow(2, 0);
    
    // Accessor methods again...
    System.out.println("First rectangle after grow(2, 0)");
    System.out.println(r.getWidth());
    System.out.println(r.getHeight());
    System.out.println("Expected 14, 20");
    
    // But r2 stays the same
    System.out.println("Second rectangle width and height");
    System.out.println(r2.getWidth());
    System.out.println(r2.getHeight());
    System.out.println("Expected 2, 3");
    
    // check area
    System.out.println("First rectangle area");
    System.out.println(r.getArea());
    System.out.println("Expected 280");
    System.out.println("Second rectangle area");
    System.out.println(r2.getArea());
    System.out.println("Expected 6");
  }
}

// public keyword omitted below in order to run in zyDE.
// This class should really be in a separate file.
/**
 * Simple model of a rectangle with a width and height.
 */
class SimpleRectangle{
	
	// ini buat bikin variabelnya dulu
	 private int width;
	 private int height;


public SimpleRectangle(int givenWidth, int givenHeight)
  {
   // TODO disini baru diisi variabelnya
	width = givenWidth;
	height = givenHeight;
	 
	  
  }
  
  public int getWidth()
  {
    // TODO proc
	 
	 return width;
  }
  
  public int getHeight()
  {
    // TODO proc
    return height;
  }
  
  public int getArea()
  {
    // TODO proc
    return height *  width;
  }
  
  public void grow(int h, int v)
  {
   // TODO proc
	  
	  
	  height += v + v;
	  width += h + h;
	  
  }
}
