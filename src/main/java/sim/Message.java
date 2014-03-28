package sim;

/**
 * Message object.
 * @author leo
 *
 */
public class Message {
	
	public enum TYPE { LOCATION , TRAFFIC_REPORT , SHUTDOWN , LOCATION_REACHED }
	
	private TYPE type;
	
	/**
	 * Message payload. This can be null for signaling messages like SHUTDOWN.
	 */
	private byte[] payload;
	
	public Message(TYPE type){
		this(type,null);		
	}
	
	public Message(TYPE type , byte[] payload){
		this.type = type;
		this.payload = payload;
	}
	
	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public byte[] getPayload() {
		return payload;
	}

	public void setPayload(byte[] payload) {
		this.payload = payload;
	}		
}
