package sim;


/**
 * Message object.
 * @author leo
 *
 */
public class Message {
	
	/**
	 * Message type.
	 */
	private MessageType type;
	
	/**
	 * Message payload. This can be null for signaling messages like SHUTDOWN.
	 */
	private byte[] payload;
	
	public Message(MessageType type){
		this(type,null);		
	}
	
	public Message(MessageType type , byte[] payload){
		this.type = type;
		this.payload = payload;
	}
	
	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public byte[] getPayload() {
		return payload;
	}

	public void setPayload(byte[] payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Message [type=" + type + ", payload="
				+ (payload != null ? new String(payload) : "")  + "]";
	}
}
