package sim;

public interface TransportListener {
	
	/**
	 * Callback method called by transport layer for an new incoming message. 
	 */
	public void onMessageReceived( Message message);
	
}
