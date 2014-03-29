package sim.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import sim.Dispatcher;
import sim.Drone;
import sim.Location;
import sim.Message;
import sim.MessageTyppe;
import sim.Node;
import sim.Time;
import sim.Transport;
import sim.TransportListener;
import sim.util.InputParser;
import sim.util.MessageConvertor;

@Component
public class DispatcherImpl implements Dispatcher , TransportListener {
	
	private static final Logger LOG = LoggerFactory.getLogger(DispatcherImpl.class);
	
	private Transport transport;
	
	private Drone drone6043;
	
	private Drone drone5937;
	
	private Time finishTime;
	
	private List<Node> nodes; 
	
	public DispatcherImpl(){
		this.transport = new TransportImpl(this);
		this.transport.registerListener(this);
		this.finishTime = new Time(8, 20);
	}
	
	@Override
	public String getAddress() {
		return "dispatcher";
	}

	@Override
	public void init() throws IOException {
		nodes  = InputParser.loadRoutes("src/main/resources/routes.csv");
		List<Location> stations = InputParser.loadStations("src/main/resources/stations.csv");
		InputParser.updateNodeLocation(nodes, stations);
	}

	@Override
	public void start() {
		this.drone5937 = new DroneImpl("5937", transport);
		this.drone6043 = new DroneImpl("6043", transport);
		
		for( Node node : nodes){
			
			if( node.getTime().compareTo(finishTime) < 0 ){
				
				if( node.getDroneId().equals(drone5937.getId())){
					transport.sendMessage(drone5937, MessageConvertor.locationToMessage(node.getLocation()));
				}
				else{
					transport.sendMessage(drone6043, MessageConvertor.locationToMessage(node.getLocation()));
				}
			}
			else{
				transport.sendMessage(drone5937, new Message(MessageTyppe.SHUTDOWN));
				transport.sendMessage(drone6043, new Message(MessageTyppe.SHUTDOWN));
			}						
		}
	}

	@Override
	public void onMessageReceived(Message message) {
		LOG.info(message.toString());
		
	}
}
