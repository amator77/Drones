package sim.impl;

import java.util.Iterator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sim.TrafficReportEntry;
import sim.TrafficReportRepository;
import sim.TrafficReportService;

@Component("trafficReportService")
@Transactional
public class TrafficReportServiceImpl implements TrafficReportService {
	
	private final TrafficReportRepository reportRepository;
	
	@Autowired
	public TrafficReportServiceImpl(TrafficReportRepository reportRepository){
		this.reportRepository = reportRepository;
	}

	@Override
	public void saveTrafficRepotEntry(TrafficReportEntry entry) {		
		//TODO - add some validations
		
		reportRepository.save(entry);
	}

	@Override
	public Iterator<TrafficReportEntry> getAllEntries() {		
		return reportRepository.findAll().iterator();
	}	
}
