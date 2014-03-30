package sim;

import java.util.Iterator;

public interface TrafficReportService {
	
	public void saveTrafficRepotEntry(TrafficReportEntry entry);
	
	public Iterator<TrafficReportEntry> getAllEntries();
	
}
