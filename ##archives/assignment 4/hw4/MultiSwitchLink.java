package hw4;

import api.Crossable;
import api.Point;
import api.PointPair;
import api.PositionVector;

public class MultiSwitchLink extends AbstractLink{
	
	private boolean crossing;
	private PointPair[] connections;
	
	/**
	 * 
	 * Models a link with a minimum of 2 to a maximum of 6 paths. The following figure shows 6 paths.
	 *   \   /
	 *    \ /
	 *  --- ---
	 *    / \
	 *   /   \
 
	 * The connections are provided to the constructor as an array of 2 to 6 point pairs. Each point pair describes the two endpoints where the train comes from and goes to.
	 * The turn cannot be modified when the train is in the crossing.

	 * The number of point pairs should be the same as the number of paths.
	 * @param a
	 */
	public MultiSwitchLink ( PointPair[] a) {
		this.connections = a;
		
	}
	/** 
	 * Gets the point that is connected to the given point by the link. Returns null if no point is connected to the given point.

	 * @param PointPair
	 * @param int
	 */
	public void switchConnection(PointPair b, int c) {
		if(!crossing) {
			connections[c] = b;
		}
	}
	
	/** Returns the connected Point of a MultiSwitchLink.
	 * 
	 * A multiSwitchLink can have 2-6 points, so
	 * It parses through the array for the point, and returns the other poing of the pair. 
	 * 
	 * @param point
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		for(PointPair i : connections) {
			if(point == i.getPointA()) {
				return i.getPointB();
			}
			if(point == i.getPointB()) {
				return i.getPointA();			}
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
	 * 
	 * Gets the total number of paths connected by the link.
	 */
	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return connections.length;
	}

}
