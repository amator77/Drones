package sim.impl;

import java.util.Date;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sim.Drone;
import sim.Location;
import sim.Message;
import sim.MessageTyppe;
import sim.TrafficCondition;
import sim.TrafficReportEntry;
import sim.Transport;
import sim.TransportListener;
import sim.util.MessageConvertor;

public class DroneImpl implements Drone, Runnable, TransportListener {

	private static final Logger LOG = LoggerFactory.getLogger(DroneImpl.class);

	private String id;

	private Location location;

	private Transport transport;
	
	private Queue<Message> messagesQueue;

	private static final Object LOCK = new Object();
	
	private static final Long SPEED = 1000L;  // the drone is moving with constant speed : 1 s/location
	
	public DroneImpl(String id, Transport transport) {
		this.id = id;
		this.transport = transport;		
		messagesQueue = new LinkedBlockingQueue<Message>(10);
		this.transport.registerListener(this);
		new Thread(this, "Drone " + id).start();
	}

	@Override
	public String getId() {
		return this.id;
	}


	@Override
	public void run() {
		LOG.info("Drone {} is deployed and ready to fly.", id);

		loop : while (true) {
			
			Message message = null;
			
			while( (message = this.messagesQueue.poll()) != null ){
				switch (message.getType()) {
				
				case SHUTDOWN: {
					LOG.warn("Drone {} shutdown signal receveid.Aborting...",
							this.id);
					break loop;
				}					
					
				case MOVE_TO_LOCATION: {
					
					try {						
						Thread.sleep(SPEED);
						this.location = MessageConvertor.messageToLocation(message);
						
						if( this.location.hasStationsNearby() ){
							this.transport.sendMessage(transport.getDispatcherDestination(), new Message(MessageTyppe.IN_LOCATION));
							this.transport.sendMessage(transport.getDispatcherDestination(), new Message(MessageTyppe.TRAFFIC_REPORT,newTrafficReportEntry(this.location)));							
						}
						 
					} catch (InterruptedException e) {						
						LOG.warn(
								"Drone {} moving state is interrupted.Aborting.",
								this.id , this.id , e);
						
						break loop;
					}																			
				}
				break;
				
				default:
					LOG.info("Drone {} receive invalid message ! Ignoring...", this.id);									
				}								
			}
						
			synchronized (LOCK) {

				try {
					LOG.info("Drone {} is waiting for an new location", this.id);
					LOCK.wait();
				} catch (InterruptedException e) {
					LOG.warn(
							"Drone {} waiting or moving state of this drone is interrupted.{} is aborted!",
							this.id , this.id , e);
					break;
				}
			}
		}
		

		LOG.info("Drone {} is returning to base :).", id);
	}

	@Override
	public void onMessageReceived(Message message) {
		LOG.info("Drone: {} message received: {}", this.id, message);

		try {
			
			this.messagesQueue.add(message);

			synchronized (LOCK) {
				this.notify();
			}
			
		} catch (IllegalStateException ex) {
			LOG.error("Drone memory is full! Ignoring the message...", ex);
		}
	}

	@Override
	public String getAddress() {		
		return this.id;
	}

	@Override
	public Location getLocation() {
		return this.location;
	}
	
	private byte[] newTrafficReportEntry(Location location) {
		TrafficReportEntry entry = new TrafficReportEntry();
		entry.setDroneId(this.id);
		entry.setSpeed(new Random().nextInt(200));
		entry.setTime(new Date());
		entry.setTrafficCondition(TrafficCondition.MODERATE);
				
		return MessageConvertor.objectToJsonBytesArray(entry);
	}
}
