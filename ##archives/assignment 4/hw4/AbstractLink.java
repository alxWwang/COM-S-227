package hw4;

import api.Crossable;
import api.Point;
import api.PositionVector;

public abstract class AbstractLink implements Crossable {
	
	/**
	* Shift the location of the given positionVector to be between the next pair of points.
	* For example, suppose the vector is currently at the end of path 1 on points A and B. Assume endpoint B on path 1 is linked to endpoint C on path 2. Then the positionVector will be updated to be between points C and D, where D is the next point on path 2 after C.
	*
	* The method does not change the relative distance between the points, it only modifies the points.
	* @param  positionVector 
	*/
	public void shiftPoints(PositionVector positionVector) {
		Point temp = getConnectedPoint(positionVector.getPointB());
		positionVector.setPointA(temp);
		
		if(temp.getPointIndex()==0) {
			positionVector.setPointB( temp.getPath().getPointByIndex( 1 ) );	
		}else {
			positionVector.setPointB( temp.getPath().getPointByIndex( temp.getPointIndex()-1 ) );	
		}
		
		
	}
	
	public void trainEnteredCrossing() {}

	public void trainExitedCrossing() {}
	
}
