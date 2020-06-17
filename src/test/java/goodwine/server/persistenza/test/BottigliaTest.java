package goodwine.server.persistenza.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;  

import goodwine.server.persistenza.BottigliaRepository;
import goodwine.server.persistenza.BottigliaAggiornataRepository;

import goodwine.server.pojos.Bottiglia;
import goodwine.server.pojos.BottigliaAggiornata;
import goodwine.server.pojos.BottigliaAggiornataId;
//@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest
public class BottigliaTest {
	@Autowired
	BottigliaRepository bottigliaRepo;
	@Autowired
	BottigliaAggiornataRepository bottigliaARepo;
	
	@Test
	public void ottenimentoAggiornamentiPerUnaBottiglia() {
		inizializzazioneBottigliaEAggiornamenti();
		Assertions.assertEquals( bottigliaRepo.findById(1L).get().bottigliaaggiornamenti.size(), 2 );
	}
	
	private void inizializzazioneBottigliaEAggiornamenti() {
		Bottiglia bott = new Bottiglia();
		bott.setLuogo("Luogo bello");
		bott.setNome("vino bello");
		bott.setNomeCantina("cantina bella");
		
		bottigliaRepo.save(bott);
		
		//aggiornamento 1
		BottigliaAggiornata ba = new BottigliaAggiornata();
		
		long now = System.currentTimeMillis();
		
		ba.bottiglia = bott;
		
		ba.id = new BottigliaAggiornataId();
		ba.id.setDataRegistrazione(now);
		ba.id.setIdBottiglia(1L);
		
		
		ba.setInclinazione(45);
		ba.setRaggiuv(false);
		ba.setUmidita(80);
		ba.setTemperatura(22);
		
		bottigliaARepo.save(ba);
		
		//aggiornamento2 (1h dopo per la stessa bottiglia)
		BottigliaAggiornata ba2 = new BottigliaAggiornata();
		ba2.bottiglia = bott;
		
		ba2.id = new BottigliaAggiornataId();
		ba2.id.setDataRegistrazione(now + 60*60*1000);
		ba2.id.setIdBottiglia(1L);
		
		ba2.setInclinazione(52);
		ba2.setRaggiuv(false);
		ba2.setUmidita(90);
		ba2.setTemperatura(18);
		
		bottigliaARepo.save(ba2);
	}
	
}
