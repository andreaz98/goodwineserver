package goodwine.server.persistenza;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import goodwine.server.pojos.BottigliaAggiornata;
import goodwine.server.pojos.BottigliaAggiornataId;

@Component
public interface BottigliaAggiornataRepository extends CrudRepository<BottigliaAggiornata, BottigliaAggiornataId> {}
