package hw4;

import api.Crossable;
import api.Path;
import api.Point;
import api.PositionVector;

public class CouplingLink extends AbstractLink {
	
	private Point highPoint;
	private Point lowPoint;
	
	public CouplingLink(Point highPoint, Point lowPoint) {
		
		this.lowPoint = lowPoint;
		this.highPoint = highPoint;
	}

	@Override
	public void shiftPoints(PositionVector positionVector) {
		// TODO Auto-generated method stub
		positionVector.setPointA(lowPoint);
		positionVector.setPointB(lowPoint.getPath().getPointByIndex( lowPoint.getPointIndex() +1));
		
		
	}

	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		
		return lowPoint.getPath().getLowpoint();

	}

	@Override
	public void trainEnteredCrossing() {
		// TODO Auto-generated method stub
	}

	@Override
	public void trainExitedCrossing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return 2;
	}

}
