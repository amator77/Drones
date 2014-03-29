package sim.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sim.Location;
import sim.Node;
import sim.Time;
import au.com.bytecode.opencsv.CSVReader;

public class InputParser {

	private static final Integer RANGE = 350;
		
	public static List<Location> loadStations(String file) throws IOException {

		List<Location> stations = new ArrayList<Location>();

		try (CSVReader reader = new CSVReader(new FileReader(file));) {
			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				Location location = new Location(
						Double.parseDouble(nextLine[1]),
						Double.parseDouble(nextLine[2]));
				stations.add(location);
			}
		}

		return stations;
	}

	public static List<Node> loadRoutes(String file) throws IOException{
				
		List<Node> nodes = new ArrayList<Node>();

		try (CSVReader reader = new CSVReader(new FileReader(file));) {
			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				String[] timeParts = nextLine[3].split(":");

				Node node = new Node(nextLine[0], new Location(
						Double.parseDouble(nextLine[1]),
						Double.parseDouble(nextLine[2])), new Time(
						Integer.parseInt(timeParts[0]),
						Integer.parseInt(timeParts[1])));

				nodes.add(node);
			}
		}

		return nodes;
	}
	
	public static void updateNodeLocation(List<Node> nodes , List<Location> stations){
		
		for( Node node : nodes){
			for(Location loc : stations ){
				if( isStationCloseToNode(loc,node)){
					node.getLocation().setHasStationsNearby(true);
					break;
				}
			}
		}
	}

	private static boolean isStationCloseToNode(Location loc, Node node) {
		return true;
	}
}
