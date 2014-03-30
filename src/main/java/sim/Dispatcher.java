package sim;

import java.io.IOException;

public interface Dispatcher extends Destination {
	
	/**
	 * Load data from csv files
	 * @throws IOException 
	 */
	public void init() throws IOException;
	
	/**
	 * Start simulation
	 */
	public void start();
}
