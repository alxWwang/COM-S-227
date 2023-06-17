package lab2;

import plotter.SimulationPlotter;

public class RabbitSimApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimulationPlotter plott = new SimulationPlotter();
		
		
		RabbitModel myModel = new RabbitModel();

		
		plott.simulate(myModel);
		
		
	}

}
