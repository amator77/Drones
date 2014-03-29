package sim;

public enum MessageTyppe {
	
	/**
	 * Send by Dispatcher to Drone.
	 */
	MOVE_TO_LOCATION,

	/**
	 * Send by Drone to Traffic Report Repository
	 */
	TRAFFIC_REPORT,

	/**
	 * Send by Dispatcher to Drone.
	 */
	SHUTDOWN,

	/**
	 * Send by Drone to Dispatcher when is in location.
	 */
	IN_LOCATION
}
