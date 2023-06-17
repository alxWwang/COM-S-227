package lecture8G;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;


public class TestGasTank {
			GasTank gasTank = new GasTank(13);
	
		@Before
		public void testNewGasTank() {
			
			assertEquals("Create a tank with capacity 13"
						+ " should return 13", 13, 
			
						gasTank.getCapacity());
		}
	
	
		@Test
		public void testNewGasTank1() {

			
			assertEquals("Create a tank with capacity 13 should return 13"
						, 13, gasTank.getCapacity());
						
		}
		
		
		@Test
		public void addTest() {
			gasTank.add(1);
			
			assertEquals("Create a tank with capacity 13"
						+ " should return 14", 1, 
			
						gasTank.getLevel());
						
		}
		
		@Test
		public void addTest2() {
			gasTank.add(12);
			
			assertEquals("Create a tank with capacity 13"
						+ " should return 12 with no probolem", 12, 
			
						gasTank.getLevel());
						
		}
		
		@Test
		public void addTest3() {
			gasTank.add(14);
			
			assertEquals("Create a tank with capacity 13"
						+ " wouldnt fill", 13, 
			
						gasTank.getLevel());
						
		}
			
		
		

			
}

