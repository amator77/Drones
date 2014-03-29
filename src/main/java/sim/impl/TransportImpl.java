package sim.impl;

import java.util.ArrayList;
import java.util.List;

import sim.Destination;
import sim.Message;
import sim.Transport;
import sim.TransportListener;

/**
 * Local , in process , transport implementation;
 * @author leo
 *
 */
public class TransportImpl implements Transport {
	
	private Destination dispatcherDestination; 
	
	private List<TransportListener> listeners ;
	
	public TransportImpl(Destination dispatcherDestination){
		this.listeners = new ArrayList<TransportListener>();
		this.dispatcherDestination = dispatcherDestination;
	}
	
	@Override
	public void sendMessage(Destination destination, Message message) {
		
		for( TransportListener listener : listeners ){
			if( listener.getAddress().equals(destination.getAddress()) ){
				listener.onMessageReceived(message);
			}
		}
	}

	@Override
	public Destination getDispatcherDestination() {		
		return dispatcherDestination;
	}

	@Override
	public void registerListener(TransportListener listener) {
		
		if( !this.listeners.contains(listener) ){
			this.listeners.add(listener);
		}
		
	}

	@Override
	public void removeListener(TransportListener listener) {
		
		if( this.listeners.contains(listener) ){
			this.listeners.remove(listener);
		}
	}
}
