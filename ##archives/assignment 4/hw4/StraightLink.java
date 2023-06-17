package hw4;

import api.Crossable;
import api.Point;
import api.PositionVector;

public class StraightLink extends AbstractLink {
	private Point firstPoint;
	private Point secondPoint1;
	private Point secondPoint2;
	
	
	/**
	 * Models a fixed link with three paths. The following figure shows the three paths labeled A, B, and C.
	 * A     B
	 * --- ---
	 *     \
	 *      \C
 
The paths A and B run in the same direction and C branches away.

	 * @param a
	 * @param b
	 * @param c
	 */
	public StraightLink(Point a, Point b, Point c) {
		this.firstPoint = a;
		this.secondPoint1 =b;
		this.secondPoint2 = c;
	
	}

	/** 
	 * Gets the point that is connected to the given point by the link. Returns null if no point is connected to the given point.
	 * @param point
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		Point res= null;
		if(point == firstPoint) {
			res = secondPoint1;
		}
		if(point == secondPoint1) {
			res = firstPoint;
		}
		if(point == secondPoint2) {
			res = firstPoint;
		}
		return res;
	}
	
	/**
	 * Gets the total number of paths connected by the link.
	 * 
	 */
	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return 3;
	}


	

}
