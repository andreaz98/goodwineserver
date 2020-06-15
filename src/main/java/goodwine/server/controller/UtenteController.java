package goodwine.server.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import goodwine.server.persistenza.UtenteRepository;
import goodwine.server.pojos.Utente;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;
@RestController
@RequestMapping(value = "/utente")
public class UtenteController {
	@Autowired 
	UtenteRepository utenteRepo;//IoC
	
	
	@RequestMapping(value = "/registrazione", method = RequestMethod.POST)
	public Utente registra(@RequestBody Utente utente) {
		String username = utente.getUsername();
		
		System.out.println("ricevuta richiesta");
		System.out.println("username "+utente.getUsername());
		System.out.println("cognome "+utente.getCognome());
		
		Utente u = utenteRepo.findById(username).isPresent() ? utenteRepo.findById(username).get() : null;
		
		if( u == null ) {//utente non esiste
			System.out.println("creo utente");
			utenteRepo.save(utente);
			return utente;//se lo registro faccio echo al client, altrimenti invio utente vuoto
			
		}else return new Utente();
		
	}
	
	//login molto naive
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean autentica(@RequestBody Utente utente) {
		Optional<Utente> user = utenteRepo.findById(utente.getUsername());
		
		if( user.isPresent() ) {
			if( user.get().getPassword().equals( utente.getPassword() ) ) {
				return true;
			}
		}
		
		return false;
	}
}
