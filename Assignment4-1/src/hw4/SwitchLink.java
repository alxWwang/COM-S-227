package hw4;

import api.Crossable;
import api.Point;
import api.PositionVector;

public class SwitchLink extends AbstractLink{
	private Point firstPoint;
	private Point secondPoint1;
	private Point secondPoint2;
	private boolean crossing;
	
	private boolean yn = false;
	
	/**
	 *  The given endpoints correspond to the paths as labeled below.
	 * A     B 
	 * --- ---
	 *    \
	 *     \C
 
	 * @param a
	 * @param b
	 * @param c
	 */
	
	public SwitchLink(Point a, Point b , Point c) {
		this.firstPoint = a;
		this.secondPoint1 = b;
		this.secondPoint2 = c;
	}
	/**
	 * Updates the link to turn or not turn.
	 * @param boolean 
	 */
	public void setTurn(boolean yn) {
		this.yn = yn;
	}
	/** 
	 * Gets the point that is connected to the given point by the link. Returns null if no point is connected to the given point.

	 * @param point
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		if(!yn && !crossing) {
			if(point == firstPoint) {
				return secondPoint1;
			}
			else {
				return firstPoint;
			}
		}
		if(yn && !crossing) {
			if(point == firstPoint) {
				return secondPoint2;
			}
			else {
				return firstPoint;
			}
		}
		return null;
		
		
		
	}
	@Override
	public void trainEnteredCrossing() {
		crossing = true;
		// TODO Auto-generated method stub
	}
	@Override
	public void trainExitedCrossing() {
		crossing = false;
		// TODO Auto-generated method stub
		
	}

	/**
	 * Gets the total number of paths connected by the link.
	 */
	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return 3;
	}

	

}
