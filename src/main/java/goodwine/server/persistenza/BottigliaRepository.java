package goodwine.server.persistenza;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import goodwine.server.pojos.Bottiglia;

@Component
public interface BottigliaRepository extends CrudRepository<Bottiglia, Long> {}
