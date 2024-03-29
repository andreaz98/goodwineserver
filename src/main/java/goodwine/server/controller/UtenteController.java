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
		
		Utente u = utenteRepo.findById(username).isPresent() ? utenteRepo.findById(username).get() : null;
		
		if( u == null ) {
			
			return utenteRepo.save(utente);
			
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
