package goodwine.server.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

import goodwine.server.controller.BottigliaController;
import goodwine.server.pojos.*;
import goodwine.server.persistenza.BottigliaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.LinkedList;

import java.util.Optional;

@RestController
public class BottigliaController{
	
	@Autowired
	BottigliaRepository bottigliaRepo;
	
	@RequestMapping(value = "/scansione")
	public Collection<BottigliaAggiornata> ottieniUltimiAggiornamentiBottiglia(@RequestBody Long idBottiglia) {
		Optional<Bottiglia> b = bottigliaRepo.findById(idBottiglia);
		
		List<BottigliaAggiornata> res = new LinkedList<BottigliaAggiornata>();
		
		if( b.isPresent() ) {
			
			Iterator<BottigliaAggiornata> it = b.get().bottigliaaggiornamenti.iterator();
			
			for( int i=0; i < 10 && it.hasNext(); i++ ) res.add( it.next() );
			
		}
		
		return res;
	}

}
