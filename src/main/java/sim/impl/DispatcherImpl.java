package sim.impl;

import java.io.IOException;
import java.util.List;

import sim.Dispatcher;
import sim.Drone;
import sim.Location;
import sim.Node;
import sim.Time;
import sim.Transport;
import sim.util.InputParser;

public class DispatcherImpl implements Dispatcher {
	
	private Transport transport;
	
	private Drone drone6043;
	
	private Drone drone5937;
	
	private Time finishTime;
	
	private List<Node> nodes; 
	
	public DispatcherImpl(){
		this.transport = new TransportImpl(this);
		this.finishTime = new Time(8, 20);
	}
	
	@Override
	public String getAddress() {
		return "dispatcher";
	}

	@Override
	public void init() throws IOException {
		nodes  = InputParser.loadRoutes("resources/routes.csv");
		List<Location> stations = InputParser.loadStations("resources/stations.csv");
		InputParser.updateNodeLocation(nodes, stations);
	}

	@Override
	public void start() {
		this.drone5937 = new DroneImpl("5937", transport);
		this.drone6043 = new DroneImpl("6043", transport);
		
		for( Node node : nodes){
			
		}
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
