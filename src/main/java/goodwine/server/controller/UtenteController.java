package goodwine.server.controller;

import goodwine.server.pojos.Utente;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UtenteController {
	public Utente registra(Utente utente);
	public boolean autentica(Utente utente);
}
