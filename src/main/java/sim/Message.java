package sim;

import java.util.Arrays;

/**
 * Message object.
 * @author leo
 *
 */
public class Message {
	
	/**
	 * Message type.
	 */
	private MessageTyppe type;
	
	/**
	 * Message payload. This can be null for signaling messages like SHUTDOWN.
	 */
	private byte[] payload;
	
	public Message(MessageTyppe type){
		this(type,null);		
	}
	
	public Message(MessageTyppe type , byte[] payload){
		this.type = type;
		this.payload = payload;
	}
	
	public MessageTyppe getType() {
		return type;
	}

	public void setType(MessageTyppe type) {
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
				+ new String(payload) + "]";
	}
}
