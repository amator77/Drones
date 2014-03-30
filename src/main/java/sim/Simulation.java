package sim;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Simulation implements CommandLineRunner {
		
	@Autowired 
	Dispatcher dispatcher;
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Simulation.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		dispatcher.init();
		dispatcher.start();
	}
}
