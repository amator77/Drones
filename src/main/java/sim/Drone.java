package sim;


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
	public Location getLocation(); 
	
}
