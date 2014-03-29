package sim;

public class Node {
	
	private String droneId;
	
	private Location location;
	
	private Time time;
	
	public Node(String droneId,Location location,Time time){
		this.droneId = droneId;
		this.location = location;
		this.time = time;
	}
	
	public String getDroneId() {
		return droneId;
	}

	public void setDroneId(String droneId) {
		this.droneId = droneId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Node [droneId=" + droneId + ", location=" + location
				+ ", time=" + time + "]";
	}
}
