package hw4;

import api.Crossable;
import api.Point;
import api.PointPair;
import api.PositionVector;

public class MultiFixedLink extends AbstractLink{

	private PointPair[] connections;
	
	
	/**
	 * Models a link with a minimum of 2 to a maximum of 6 paths. The following figure shows 6 paths.
	 *   \   /
	 *    \ /
	 *  --- ---
	 *    / \
	 *   /   \
 
	 *The connections are provided to the constructor as an array of 2 to 6 point pairs. Each point pair indicates the two endpoints where the train comes from and goes to.
	 *The number of point pairs should be the same as the number of paths.
	 * @param connections
	 */
	public MultiFixedLink(PointPair[] connections) {
		
		this.connections = connections;
	}
	/** 
	 * Gets the point that is connected to the given point by the link. Returns null if no point is connected to the given point.

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
	/**
	 * Gets the total number of paths connected by the link.
	 */
	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return connections.length;
	}

}
