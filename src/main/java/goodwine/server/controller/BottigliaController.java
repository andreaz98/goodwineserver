package goodwine.server.controller;

import java.util.Collection;
import goodwine.server.pojos.BottigliaAggiornata;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BottigliaController {
	public Collection<BottigliaAggiornata> ottieniUltimiAggiornamentiBottiglia(Long idBottiglia);
}
