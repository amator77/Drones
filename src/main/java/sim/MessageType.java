package sim;

public enum MessageType {
	
	/**
	 * Send by Dispatcher to Drone.
	 */
	MOVE_TO_LOCATION,

	/**
	 * Send by Drone to Traffic Report Repository via Dispatcher
	 */
	TRAFFIC_REPORT,

	/**
	 * Send by Dispatcher to Drone.
	 */
	SHUTDOWN,

	/**
	 * Send by Drone to Dispatcher when is running out of locations to move.
	 */
	ASK_FOR_LOCATION
}
