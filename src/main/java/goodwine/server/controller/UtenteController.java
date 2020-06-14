package goodwine.server.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import goodwine.server.persistenza.UtenteRepository;
import goodwine.server.pojos.Utente;
import org.springframework.web.bind.annotation.ResponseBody;
@RestController
public class UtenteController {
	@Autowired 
	UtenteRepository utenteRepo;//IoC
	
	/**
	 * 
	 * nel body della richiesta devono essere IN JSON i valori dell' utente che si vuole registrare
	 * 
	 * query  : /utente/registrazione
	 * body   : json dell' utente
	 */
	@RequestMapping("/utente/registrazione")
	public Utente registra(@RequestBody Utente utente) {
		String username = utente.getUsername();
		
		System.out.println("ricevuta richiesta");
		
		
		Utente u = utenteRepo.findById(username).isPresent() ? utenteRepo.findById(username).get() : null;
		
		if( u == null ) {//utente non esiste
			System.out.println("creo utente");
			utenteRepo.save(utente);
			return utente;//se lo registro faccio echo al client, null altrimenti
			
		}else return null;
	}
}
