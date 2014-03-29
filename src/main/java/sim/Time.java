package sim;

public class Time implements Comparable<Time> {
	
	public int hour;
	
	public int minute;
	
	public Time(int hour,int minute){
		this.hour = hour;
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		return fill(hour)+":"+fill(minute);
	}
	
	private String fill(int value){
		if(value < 10){
			return "0"+value;
		}
		else{
			return String.valueOf(value);
		}
	}

	@Override
	public int compareTo(Time t) {
		
		if( this.hour < t.getHour() ){
			return -1;
		}
		else
		if( this.hour > t.getHour() ){
			return 1;
		}
		else
		if( this.minute < t.getMinute() ){
			return -1;
		}	
		else
		if( this.minute > t.getMinute() ){
			return 1;
		}
		else{
			return 0;
		}
	}
}
