package sim;

/**
 * GPS DD (decimal degrees) location point.
 * @author leo
 *
 */
public class Location {
	
	/**
	 * Latitude of an location point as double value . Ex : 53.09745
	 */
	private double latitude;
	
	/**
	 * Longitude of an location point as double value . Ex : -1.382256
	 */
	private double longitude;
	
	/**
	 * This is true if the are any stations close then 350 m to this point.
	 */
	private boolean hasStationsNearby;
	
	public Location(){
		this(0,0);
	}
	
	public Location(double latitude,double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public boolean hasStationsNearby() {
		return hasStationsNearby;
	}

	public void setHasStationsNearby(boolean hasStationsNearby) {
		this.hasStationsNearby = hasStationsNearby;
	}

	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", longitude=" + longitude
				+ ", hasStationsNearby=" + hasStationsNearby + "]";
	}
}
