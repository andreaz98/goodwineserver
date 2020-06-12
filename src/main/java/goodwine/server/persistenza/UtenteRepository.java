package goodwine.server.persistenza;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import goodwine.server.pojos.Utente;

@Component
public interface UtenteRepository extends CrudRepository<Utente,String>{
}
