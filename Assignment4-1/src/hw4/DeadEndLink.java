package hw4;

import api.Crossable;
import api.Point;
import api.PositionVector;

public class DeadEndLink extends AbstractLink{
	/**
	 * Models a link that connects a single path to nothing. getConnectedPoint() returns null and shiftPoints() does nothing.
	 */
	public DeadEndLink(){
		
	}
	
	@Override
	public void shiftPoints(PositionVector positionVector) {
		//do nothing 
	}
	
	/** 
	 * Gets the point that is connected to the given point by the link. Returns null if no point is connected to the given point.

	 * @param point
	 */
	
	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Gets the total number of paths connected by the link.
	 */
	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
