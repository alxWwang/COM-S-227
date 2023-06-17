package lecture8G;

public class GasTank {
	
	private int capacity;
	private int level;
	private boolean isItTooMuch;
	
	

	public GasTank (int getCapacity) {
		
		capacity = getCapacity;
		level = 0 ;
	}

	public int getCapacity() {
		// TODO Auto-generated method stub
		
		return capacity;
	
		
	}
	
	public void add(int amount) {
		
			
		
		if ((amount + level) > capacity){
			level = capacity;
			
		}else {
			level += amount;
		}

			

	}
		
	
	public int getLevel() {
		return level;
		
	}
	
	
	
	
	

}
