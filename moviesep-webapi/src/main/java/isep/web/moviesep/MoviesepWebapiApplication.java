package isep.web.moviesep;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MoviesepWebapiApplication {
	
	private static final Log log = LogFactory.getLog(MoviesepWebapiApplication.class);

	public static void main(String[] args) {
		log.debug(String.format("***************************************"));
		log.debug(String.format("  Starting Embeded Tomcat"));
		log.debug(String.format("***************************************"));
		SpringApplication.run(MoviesepWebapiApplication.class, args);
		log.debug(String.format("***************************************"));

	}

}

