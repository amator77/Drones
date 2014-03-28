package sim;

import java.util.Date;

public class TrafficReportEntry {
	
	/**
	 * Drone id ,source of this report entry.
	 */
	private String droneId;
	
	/**
	 * Time of this report entry. 
	 */
	private Date time;
	
	/**
	 * Traffic speed in miles/h.
	 */
	private Integer speed;
		
	/**
	 *	 Traffic condition.
	 */
	private TrafficCondition trafficCondition;

	public String getDroneId() {
		return droneId;
	}

	public void setDroneId(String droneId) {
		this.droneId = droneId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public TrafficCondition getTrafficCondition() {
		return trafficCondition;
	}

	public void setTrafficCondition(TrafficCondition trafficCondition) {
		this.trafficCondition = trafficCondition;
	}

	@Override
	public String toString() {
		return "TrafficReportEntry [droneId=" + droneId + ", time=" + time
				+ ", speed=" + speed + ", trafficCondition=" + trafficCondition
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((droneId == null) ? 0 : droneId.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime
				* result
				+ ((trafficCondition == null) ? 0 : trafficCondition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrafficReportEntry other = (TrafficReportEntry) obj;
		if (droneId == null) {
			if (other.droneId != null)
				return false;
		} else if (!droneId.equals(other.droneId))
			return false;
		if (speed == null) {
			if (other.speed != null)
				return false;
		} else if (!speed.equals(other.speed))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (trafficCondition != other.trafficCondition)
			return false;
		return true;
	}
}
