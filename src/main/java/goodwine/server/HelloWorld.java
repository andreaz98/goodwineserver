package goodwine.server;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Classe di prova di Spring
 * 
 *
 */
@RestController
public class HelloWorld {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot. Ciao!!!!";
	}

}

