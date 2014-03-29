package sim.util;

import java.io.ByteArrayOutputStream;

import sim.Location;
import sim.Message;
import sim.MessageType;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Simple utility class for parsing messages.
 * @author leo
 *
 */
public class MessageConvertor {
	
	public static Location messageToLocation(Message message){
		
		if( message.getType() == MessageType.MOVE_TO_LOCATION ){
			return jsonBytesArrayToObject(message.getPayload(),Location.class);
		}
		else{
			throw new IllegalArgumentException("The message must be MOVE_TO_LOCATION type.Input type :"+message.getType());
		}
	}
	
	public static Message locationToMessage(Location location){		
		return new Message(MessageType.MOVE_TO_LOCATION,objectToJsonBytesArray(location));
	}
	
	public static Message newMessage(MessageType type, byte[] payload){		
		return new Message(type,payload);
	}
	
	public static byte[] objectToJsonBytesArray(Object obj){
		try {
			ObjectMapper mapper = new ObjectMapper();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			mapper.writeValue(bos, obj);			
			return bos.toByteArray();
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
	}
	
	public static <T> T jsonBytesArrayToObject( byte[] data,  Class<T> objectClass ){
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.readValue(data, objectClass);
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		} 
	}
}