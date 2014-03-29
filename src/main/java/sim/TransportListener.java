package sim;

/**
 * Transport listener interface. This is extending Destination in order to
 * simplify routing of messages on transport layer.
 * 
 * @author leo
 * 
 */
public interface TransportListener extends Destination {

	/**
	 * Callback method called by transport layer for an new incoming message.
	 */
	public void onMessageReceived(Message message);
}
