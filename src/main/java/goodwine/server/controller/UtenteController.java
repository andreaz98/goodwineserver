package goodwine.server.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import goodwine.server.persistenza.UtenteRepository;
import goodwine.server.pojos.Utente;

@RestController @RequestMapping("/utente")
public class UtenteController {
	@Autowired 
	UtenteRepository utenteRepo;//IoC
	
	
	/**
	 * 
	 * nel body della richiesta devono essere IN JSON i valori dell' utente che si vuole registrare
	 * 
	 * query  : /utente/registrazione?username=username
	 * body   : json dell' utente
	 */
	@RequestMapping("/registrazione")
	public boolean registra(@RequestParam("username") String username, @RequestBody Utente utente) {
		boolean registrato = false;
		
		//logica di registrazione
		
		
		return registrato;
	}
}
