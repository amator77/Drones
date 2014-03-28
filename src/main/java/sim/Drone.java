package sim;

import java.awt.geom.Point2D;

public interface Drone extends Destination {
	
	/**
	 * Return Drone ID
	 * @return
	 */
	public String getId();
	
	/**
	 * Report the Drone current location.
	 * @return - the current location , or null if the Drone is not yet moved.
	 */
	public Point2D getLocation(); 
	
	/**
	 * Move this Drone to next location
	 * @param location
	 */
	public void move(Point2D.Double location);
	
}
