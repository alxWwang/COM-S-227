package project3;

import balloon.Balloon;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

//1. blow to much wont pop, when pop it, blow still works
//2. when popped blow still works
//3. blowing twice doesnot work
//4. blowing after deflation wont work

public class BalloonTests {


	    // margin of error for floating-point comparisons
	    private static final double EPSILON = 10e-07;
	 
	    balloon4.Balloon b = new balloon4.Balloon(10);
	    
	    
	    @Before    
	    public void setup()  // runs before every test case
	    {
	    	b = new balloon4.Balloon(10);
	    }
	    
	    @Test
	    public void testBlow()
	    {
	    	b.blow(5);
	    	assertEquals(5, b.getRadius());
	    }

	    @Test
	    public void testInflate()
	    {
	    	b.blow(11);
	    	assertEquals(true, b.isPopped());
	    }

	    @Test
	    public void testDeflate()
	    {
	    	b.deflate();
	    	assertEquals(0, b.getRadius(), EPSILON);
	    }
	   
	    @Test
	    public void popTest() {
	    	b.pop();
	    	assertEquals(0, b.getRadius());
	    }
	    
	    @Test
	    public void blowTest() 
	    {
	    	b.deflate();
	    	b.blow(5);
	    	assertEquals(5,b.getRadius());
	
	    }
	    
	    @Test
	    public void initialTest()
	    {
	    	assertEquals(0, b.getRadius());
	    }
	    
	    @Test
	    public void initialPopTest()
	    {	
	    	assertEquals(false, b.isPopped());
	    }
	    
	    @Test
	    public void minusBlowPop()
	    {	
	    	b.blow(-1);
	    	assertEquals(false, b.isPopped());
	    }
	    
	    @Test
	    public void minusBlowGrow()
	    {	
	    	b.blow(-1);
	    	assertEquals(0, b.getRadius());
	    }
	    
	    @Test
	    public void blowBlowGrow()
	    {	
	    	b.blow(3);
	    	b.blow(2);
	    	assertEquals(5, b.getRadius());
	    }
	    @Test
	    public void popBlowGrow()
	    {	
	    	b.pop();
	    	b.blow(2);
	    	assertEquals(0, b.getRadius());
	    }
}
