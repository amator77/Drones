package sim;


/**
 * Transport layer for sending messages or signals between Dispatcher and Drones. 
 * @author leo
 *
 */
public interface Transport {
	
	/**
	 * Send message to some destination.
	 * @param destination - this can be a Drone or the Dispatcher.
	 * @param message - the message
	 */
	public void sendMessage(Destination destination, Message message);
	
	/**
	 * Dispatcher address.
	 * Drones needs to know Dispatcher address.
	 * @return
	 */
	public Destination getDispatcherDestination();
	
	/**
	 * Register listener for incoming messages.
	 * @param listener
	 */
	public void registerListener(TransportListener listener);
	
	
	/**
	 * Remove this listener.
	 * @param listener
	 */
	public void removeListener(TransportListener listener);
}
