package hw4;

import api.Crossable;
import api.Path;
import api.Point;
import api.PositionVector;

public class CouplingLink extends AbstractLink {
	
	private Point firstPoint;
	private Point secondPoint;
	/**
	 * Models a link between exactly two paths. When the train reaches the endpoint of one of the paths it passes to the endpoint of the other path next.
	 * @param firstPoint
	 * @param secondPoint
	 */
	public CouplingLink(Point firstPoint, Point secondPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
		
	}
	
	/** 
	 * Gets the point that is connected to the given point by the link. Returns null if no point is connected to the given point.
	 * @param point
	 */
	
	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub		
		if(point == secondPoint) {
			return firstPoint;
		}
		if( point == firstPoint) {
			return secondPoint;
		}
			return null;

	}
	
	/**
	 * Gets the total number of paths connected by the link.
	 */
	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	

}
