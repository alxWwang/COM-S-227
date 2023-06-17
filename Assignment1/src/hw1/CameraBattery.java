package hw1;


public class CameraBattery {

	
	
	
	public static final int NUM_CHARGER_SETTINGS = 4;
	public static final double CHARGE_RATE = 2.0;
	public static final double DEFAULT_CAMERA_POWER_CONSUMPTION = 1.0;

	
	private int connectedCamera;
	private int connectedCharger;
	
	private double Charge;
	private double Capacity;
	
	private int externalButton;
	
	
	private int totalBatteryDrain;
	private double batteryDrain;
	private double batteryCharge;
	private double powerConsumption;
	
	public CameraBattery (double batteryStartingCharge , double batteryCapacity){
		
		
		
		Charge = Math.min(batteryStartingCharge, batteryCapacity);
		Capacity = batteryCapacity;
		
		connectedCamera = 0; // 1 = true, 0 = false
		connectedCharger = 0; // 1 = true, 0 = false
		batteryDrain = 0;
		powerConsumption = DEFAULT_CAMERA_POWER_CONSUMPTION;
	}
	
	public void buttonPress() {
		externalButton += 1;
		externalButton %= NUM_CHARGER_SETTINGS;
		
		// ada setting 0 1 2 3
	}
	
	
	
	public double cameraCharge(double minutes) {
		
		batteryCharge = minutes*CHARGE_RATE*connectedCamera;
		
		batteryCharge =  Math.min((Capacity - Charge), batteryCharge);
		
		Charge = batteryCharge + Charge;
		
		return batteryCharge;
	}
	
	
	public double drain(double minutes) {
		
		batteryDrain = minutes*powerConsumption*connectedCamera;
		
		// Math.min(drain,Charge)
		
		// drain > charge = charge 	kalo drain lebih dari charge -> Charge - charge
		// charge > drain = drain	kalo charge lebih dari drain -> Charge - drain		
				
		batteryDrain = Math.min(batteryDrain,Charge);
		Charge -= batteryDrain;
		
		totalBatteryDrain += batteryDrain;
		
		
		return batteryDrain;
		
	}
	
	
	
	public double externalCharge(double minutes) {
		
		batteryCharge += minutes*externalButton*CHARGE_RATE* connectedCharger;
		
		batteryCharge =  Math.min((Capacity - Charge), batteryCharge);
		
		Charge = batteryCharge + Charge;
		
		return batteryCharge;
	}
	
	
	
	public void resetBatteryMonitor() {
		totalBatteryDrain = 0;
		
	}
	
	
	
	public double getBatteryCapacity() {
		return Capacity;
	}
	
	
	
	public double getBatteryCharge() {
		return Charge;
	
	}
	
	
	
	public double getCameraCharge() {
		
		return Charge * connectedCamera;
		
		//need help
	}
	
	
	
	public double getCameraPowerConsumption() {
		return powerConsumption;
	}
	
	
	
	public int getChargerSetting() {
		return externalButton;
	}
	
	
	
	public double getTotalDrain() {
		return totalBatteryDrain;
	}
	
	
	
	
	public void moveBatteryExternal() {
		connectedCamera = 0; // 1 = true, 0 = false
		connectedCharger = 1; // 1 = true, 0 = false
	}
	
	
	
	
	public void moveBatteryCamera() {
		connectedCamera = 1; // 1 = true, 0 = false
		connectedCharger = 0; // 1 = true, 0 = false
	}
	
	
	
	
	
	public void removeBattery() {
		connectedCamera = 0;
		connectedCharger = 0;
	}
	
	
	
	
	public void setCameraPowerConsumption (double cameraPowerConsumption) {
		powerConsumption = cameraPowerConsumption;
	}
	
	
	
}
