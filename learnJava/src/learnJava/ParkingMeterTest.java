package learnJava;

public class ParkingMeterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkingMeter meter = new ParkingMeter(15,20);
		
		meter.insertCoin(3);
		meter.passTime(20);
		
		System.out.println("Expected Time :25");
		System.out.println("Actual time" + meter.getTimeRemaining());
		
		
		meter.insertCoin(4);
		meter.passTime(90);
		
		System.out.println("supposed 0, actually"+ meter.getTimeRemaining());
	}

}
