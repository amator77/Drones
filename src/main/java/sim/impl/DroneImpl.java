package sim.impl;

import java.awt.geom.Point2D;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sim.Drone;
import sim.Message;
import sim.Transport;
import sim.TransportListener;

public class DroneImpl implements Drone, Runnable, TransportListener {

	private static final Logger LOG = LoggerFactory.getLogger(DroneImpl.class);

	private String id;

	private Point2D.Double location;

	private Transport transport;

	private Queue<Message> messagesQueue;

	private static final Object LOCK = new Object();

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
	public Point2D.Double getLocation() {
		return this.location;
	}

	@Override
	public void move(Point2D.Double location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		LOG.info("Drone {} is deployed and ready to run.", id);

		loop: while (true) {
			Message message = this.messagesQueue.poll();

			if (message != null) {

				switch (message.getType()) {
				
				case SHUTDOWN: {
					LOG.warn("Drone {} shutdown signal receveid.Aborting...",
							this.id);
					break loop;
				}					
					
				case LOCATION:{
					this.move(messageToLocation(message));
				}
				break;
				
				default:
					LOG.info("Drone {} receive invalid message ! Ignoring...", id);									
				}								
			}

			synchronized (LOCK) {

				try {
					LOG.info("Drone {} is whiting for new location", id);
					LOCK.wait();
				} catch (InterruptedException e) {
					LOG.warn(
							"Drone {} waiting for location id interrupted.This drone is aborted!",
							this.id, e);
					break;
				}
			}
		}

		LOG.info("Drone {} is returning to base :).", id);
	}

	private Point2D.Double messageToLocation(Message message) {
		
		String[] parts = new String(message.getPayload()).split(":");
		
		
		return null;
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
			LOG.error("Drone memory is full!", ex);
		}
	}		
}
