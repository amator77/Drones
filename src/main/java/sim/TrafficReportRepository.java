package sim;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TrafficReportRepository extends CrudRepository<TrafficReportEntry,Long> {
	
}
