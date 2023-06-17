package hw4;

import api.Crossable;
import api.Point;
import api.PositionVector;

public class DeadEndLink extends AbstractLink{

	@Override
	public void shiftPoints(PositionVector positionVector) {
		// TODO Auto-generated method stub
		// Do nothing
	}

	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void trainEnteredCrossing() {
		// TODO Auto-generated method stub
		// Do nothing
	}

	@Override
	public void trainExitedCrossing() {
		// TODO Auto-generated method stub
		//Do nothing
		
	}

	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return 1;
	}

}
