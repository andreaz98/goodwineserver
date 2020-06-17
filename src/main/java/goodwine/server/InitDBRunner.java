package goodwine.server;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import goodwine.server.persistenza.*;

import goodwine.server.pojos.*;
@Component
public class InitDBRunner implements ApplicationRunner {
	@Autowired
	BottigliaRepository bottigliaRepo;
	
	@Autowired
	UtenteRepository utenteRepo;
	
	@Autowired
	BottigliaAggiornataRepository bottigliaARepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Utente u = new Utente();
		u.setUsername("giorgio");
		u.setPassword("12345");
		utenteRepo.save(u);
		
		Bottiglia cristal = new Bottiglia();
		
		cristal.setAnnoProduzione(2006);
		cristal.setPrezzo(8900);
		cristal.setNome("Cristal");
		cristal.setTipologia("Champagne");
		
		bottigliaRepo.save(cristal);
		
		Bottiglia sassicaia = new Bottiglia();
		
		sassicaia.setAnnoProduzione(2005);
		sassicaia.setPrezzo(2590);
		sassicaia.setNome("Sassicaia");
		sassicaia.setTipologia("Champagne");
		
		bottigliaRepo.save(sassicaia);
		
		Long now = System.currentTimeMillis();
		//aggiornamenti delle due bottiglie qua sopra
		BottigliaAggiornata ba_cristal1 = new BottigliaAggiornata();
		
		ba_cristal1.id = new BottigliaAggiornataId();
		ba_cristal1.id.setDataRegistrazione(now);
		ba_cristal1.id.setIdBottiglia(1L);
		
		ba_cristal1.setInclinazione(25);
		ba_cristal1.setRaggiuv(false);
		ba_cristal1.setTemperatura(23.12);
		ba_cristal1.setUmidita(89.7);
		ba_cristal1.bottiglia = cristal;
		
		bottigliaARepo.save(ba_cristal1);
		
		BottigliaAggiornata ba_cristal2 = new BottigliaAggiornata();
		
		ba_cristal2.id = new BottigliaAggiornataId();
		ba_cristal2.id.setDataRegistrazione(now + 60*60*1000);
		ba_cristal2.id.setIdBottiglia(1L);
		
		ba_cristal2.setInclinazione(25);
		ba_cristal2.setRaggiuv(false);
		ba_cristal2.setTemperatura(22);
		ba_cristal2.setUmidita(87.7);
		ba_cristal2.bottiglia = cristal;
		
		bottigliaARepo.save(ba_cristal2);
		
		BottigliaAggiornata ba_sassicaia1 = new BottigliaAggiornata();
		
		ba_sassicaia1.id = new BottigliaAggiornataId();
		ba_sassicaia1.id.setDataRegistrazione(now);
		ba_sassicaia1.id.setIdBottiglia(1L);
		
		ba_sassicaia1.setInclinazione(25);
		ba_sassicaia1.setRaggiuv(false);
		ba_sassicaia1.setTemperatura(22);
		ba_sassicaia1.setUmidita(87.7);
		ba_sassicaia1.bottiglia = sassicaia;
		
		bottigliaARepo.save(ba_sassicaia1);
	}

}
