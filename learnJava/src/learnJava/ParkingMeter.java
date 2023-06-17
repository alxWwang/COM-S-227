package learnJava;

public class ParkingMeter {
	
	private int maximumTime;
	private int minutesPerQuarter;
	private  int timeLeft;
	private int dollars;
	
	public ParkingMeter(int minutesPerQuarter, int maximumTime) {
		this.maximumTime = maximumTime;
		this.minutesPerQuarter = minutesPerQuarter;
		timeLeft =0;
	}
	
	public void insertCoin(int howMany) {
		timeLeft += howMany* minutesPerQuarter;
		dollars += howMany/4;
		
		timeLeft = Math.min(timeLeft, maximumTime);
	}
	
	public int getTimeRemaining() {
		return timeLeft;
	}
	
	public void passTime (int minutes) {
		timeLeft -= minutes;
		
		timeLeft = Math.max(timeLeft, 0);
	}
	
	public double getTotal() {
		return dollars;
	}
}
